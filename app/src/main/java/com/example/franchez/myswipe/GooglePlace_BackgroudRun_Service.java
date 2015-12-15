package com.example.franchez.myswipe;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;

import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Franchez on 2015-12-14.
 */
public class GooglePlace_BackgroudRun_Service extends IntentService {

    Gson gson;
    GooglePlace_Search_Class googlePlace_search_class;
    List<GooglePlace_Search_Class.ResultsEntity> placesList;
    GooglePLace_Details_Class googlePLace_details_class;
    Database_Class db;
    Double latitude;
    Double longitude;
    String placesId = null;
    String placeDetailUrl = null;
    private final String GOOGLE_KEY ="AIzaSyA7M_tHKRaRgXjtsc6CnlyW6-X9BYkFQ1U";
    private final AsyncHttpClient client = new SyncHttpClient();
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
    // * @param name Used to name the worker thread, important only for debugging.
     */
    /*public GooglePlace_BackgroudRun_Service(String name) {
        super(name);
    }
*/
    public GooglePlace_BackgroudRun_Service(){
        super(GooglePlace_BackgroudRun_Service.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Bundle bundle = intent.getExtras();

        latitude = bundle.getDouble("Latitude");
        longitude = bundle.getDouble("Longitude");

        db = new Database_Class(this);

        final String searchURL = "https://maps.googleapis.com/maps/api/place/search/json?location="+latitude+","+longitude+"&radius=500&sensor=true&key="+GOOGLE_KEY;

        client.get(searchURL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String searcStr = new String(responseBody);
                gson = new Gson();
                googlePlace_search_class = gson.fromJson(searcStr, GooglePlace_Search_Class.class);
                placesList =  googlePlace_search_class.getResults();

                for (final GooglePlace_Search_Class.ResultsEntity item: placesList){
                    placesId = item.getPlace_id();

                    placeDetailUrl = "https://maps.googleapis.com/maps/api/place/details/json?placeid="+placesId+"&key="+GOOGLE_KEY;
                    client.get(placeDetailUrl, new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                            String detailStr = new String(responseBody);
                            gson = new Gson();
                            googlePLace_details_class = gson.fromJson(detailStr,GooglePLace_Details_Class.class);

                            db.insertLocation(null,googlePLace_details_class.getResult());
                            db.insertPlaces(googlePLace_details_class.getResult(),item.getPhotos());
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        }
                    });
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            }
        });
    }
}
