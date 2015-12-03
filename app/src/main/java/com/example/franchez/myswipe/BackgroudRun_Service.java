package com.example.franchez.myswipe;

import android.app.IntentService;
import android.content.Intent;
import android.preference.PreferenceActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.loopj.android.http.*;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Franchez on 2015-11-26.
 */
public class BackgroudRun_Service extends IntentService {

    String url= "https://www.eventbriteapi.com/v3/events/search/?location.latitude=43.7858101&location.longitude=-79.2272541&start_date.keyword=next_month&token=5EVVG7JA2ON7UFJKMTY3";
    Gson gson;
    AsyncHttpClient client;
    EventBrite_Class eventBrite_class;
    List<EventBrite_Class.EventsEntity> cEvent;
    String venueUrl= null;
    String venueId = null;
    EventBrite_Venue_Class  eventVenueClass;
    String categoryUrl = null;
    EventBrite_Category_Class eventCategoryClass;
    List<EventBrite_Category_Class.CategoriesEntity> categoryEntity;
    Database_Class db;
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param //name Used to name the worker thread, important only for debugging.
     */
/*    public BackgroudRun_Service(String name) {
        super(name);
    }*/
    public BackgroudRun_Service() {
        super(BackgroudRun_Service.class.getName());

    }

    @Override
    protected void onHandleIntent(Intent intent) {

        client = new AsyncHttpClient();
        db = new Database_Class(this);

        try {
            categoryHandler();
            eventHandler();
        }catch (Exception e){
        }
    }

    private void eventHandler()throws IOException{
                /*Get The Events from the EventBrite API Using the Loopj to make an HTTP Get request*/
        Log.i("MY Background","Service Started");

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String eventString = new String(responseBody);
                gson = new Gson();
                eventBrite_class = gson.fromJson(eventString, EventBrite_Class.class);
                cEvent = eventBrite_class.getEvents();

                for (EventBrite_Class.EventsEntity item : cEvent) {
                    venueId = item.getVenue_id();
                    venueHandler(venueId);
                    db.insertEvents(item);
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            }
        });
    }

    private void venueHandler(String id){

        Log.i("VENUE_HANDLER","Starting the Venue HTTP Get Request ......");
        /*Using the Loopj to make an HTTP Get request*/
        venueUrl = "https://www.eventbriteapi.com/v3/venues/"+ id + "/?token=I7YWVEEWKICBN26PI5ES";
        client.get(venueUrl, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String venueStr = new String(responseBody);
                gson = new Gson();
                eventVenueClass = gson.fromJson(venueStr, EventBrite_Venue_Class.class);
                db.insertLocation(eventVenueClass);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        Log.i("VENUE_HANDLER", "Finish the Venue Handler and Data Insert............");
    }


    private void categoryHandler() throws IOException{

        Log.i("CATEGORY_Handler","Starting Category HTTP Get request......");
        /*Using the Loopj to make an HTTP Get request*/
        categoryUrl = "https://www.eventbriteapi.com/v3/categories/?token=I7YWVEEWKICBN26PI5ES";
        client.get(categoryUrl, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String categoryStr = new String(responseBody);
                gson = new Gson();
                eventCategoryClass = gson.fromJson(categoryStr,EventBrite_Category_Class.class);
                categoryEntity = eventCategoryClass.getCategories();
                for (EventBrite_Category_Class.CategoriesEntity item: categoryEntity) {
                    db.insertCategory(item);
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            }
        });

        Log.i("CATEGORY_Handler", "Finish Category Handler and Data Insert.....");
    }
}
