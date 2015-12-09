package com.example.franchez.myswipe;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Franchez on 2015-11-26.
 */
public class WelcomePage_Activity extends AppCompatActivity
        implements ConnectionCallbacks, OnConnectionFailedListener {

    private static EditText edTxtLocation;
    private static Bundle bundle;
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;
    private static final String TAG = WelcomePage_Activity.class.getSimpleName();
    private GoogleApiClient mGoogleApiClient;
    private Location userLocation;

    /*Gson gson;
    AsyncHttpClient client;
    EventBrite_Class eventBrite_class;
    List<EventBrite_Class.EventsEntity> cEvent;
    String venueUrl= null;
    String venueId = null;
    EventBrite_Venue_Class  eventVenueClass;
    String categoryUrl = null;
    EventBrite_Category_Class eventCategoryClass;
    List<EventBrite_Category_Class.CategoriesEntity> categoryEntity;
    Database_Class db;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);

        edTxtLocation = (EditText) findViewById(R.id.edTxtLocation);
        bundle = new Bundle();

        /*Call the buildApiClient only if service is available*/
        if (checkDevicePlayService()) {
            buildApiClient();
        }
        //displayUserLocation();
        userSetDefLoc();

        /*Database_Class db = new Database_Class(this);
        int rowCount = db.getEventsCount();
        Toast.makeText(this,"Events row count: " + rowCount, Toast.LENGTH_LONG).show();*/

        /*Start The Background Process*/
        Intent bIntent = new Intent(Intent.ACTION_SYNC,null,this,BackgroudRun_Service.class);
        startService(bIntent);

        /*client = new AsyncHttpClient();
        db = new Database_Class(this);

        try {
            categoryHandler();
            eventHandler();
        }catch (Exception e){
        }*/
    }

    //===============================================================================================================
/*    private void eventHandler()throws IOException {
        //Get The Events from the EventBrite API Using the Loopj to make an HTTP Get request

        Log.i("MY Background","Service Started");
        String url= "https://www.eventbriteapi.com/v3/events/search/?location.latitude=43.7858101&location.longitude=-79.2272541&start_date.keyword=next_month&token=5EVVG7JA2ON7UFJKMTY3";
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
        //Using the Loopj to make an HTTP Get request

        venueUrl = "https://www.eventbriteapi.com/v3/venues/"+ id + "/?token=I7YWVEEWKICBN26PI5ES";
        client.get(venueUrl, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String venueStr = new String(responseBody);
                gson = new Gson();
                eventVenueClass = gson.fromJson(venueStr, EventBrite_Venue_Class.class);
                db.insertLocation(eventVenueClass);
                System.out.print("Completed the Venue request");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        Log.i("VENUE_HANDLER", "Finish the Venue Handler and Data Insert............");
    }


    private void categoryHandler() throws IOException{

        Log.i("CATEGORY_Handler", "Starting Category HTTP Get request......");
        //Using the Loopj to make an HTTP Get request

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

    //=================================================================================================================*/
    /* 1. Create Google API Client object
* */
    protected synchronized void buildApiClient() {

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    /* 2. Check if google play service is on the device
    * */

    private boolean checkDevicePlayService() {

        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);

        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode,this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Toast.makeText(this, "This device is not supported.",
                        Toast.LENGTH_LONG).show();
            }
            return false;
        }

        return true;
    }

    /* 4. Get the user location using the longitude and latitude
    *     and get the City and Province
    * */
    protected String getUserLocation() {

        double latitude;
        double longitude;
        String userCity = null;
        String userProvince = null;

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        userLocation = LocationServices.FusedLocationApi
                .getLastLocation(mGoogleApiClient);
        try {

            if (userLocation != null) {
                latitude = userLocation.getLatitude();
                longitude = userLocation.getLongitude();

                List<Address> uList = geocoder.getFromLocation(latitude, longitude, 3);

                Address mAddress = uList.get(0);
                userCity = mAddress.getSubLocality();
                userProvince = mAddress.getAdminArea();
            } else {
                Toast.makeText(this, "user Location failed",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Could not get address.",
                    Toast.LENGTH_LONG).show();
        }
        return userCity + ", " + userProvince;
    }

    /* 5. Display it to the user.
    * */
    private void displayUserLocation() {

        edTxtLocation.setText(getUserLocation());
    }

    private void userSetDefLoc() {

        final CheckBox uChkDefLoc = (CheckBox) findViewById(R.id.chkDefLoc);

        uChkDefLoc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (uChkDefLoc.isChecked()) {
                    edTxtLocation.setEnabled(false);
                    displayUserLocation();
                } else {
                    edTxtLocation.getText().clear();
                    edTxtLocation.setEnabled(true);
                }
            }
        });
    }

    /*6. Connect the API client object during onStart
    * */
    @Override
    protected void onStart() {
        super.onStart();
        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }
    }

    /*
    * 3. Perform an action if connection was successful or
    *    If the connection was suspended or
    *    If connection failed
    * */
    @Override
    public void onConnected(Bundle bundle) {

        Toast.makeText(this, "Connection Successful !!!", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onConnectionSuspended(int i) {

        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

        Toast.makeText(this, "Connection Failed", Toast.LENGTH_LONG).show();
        Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = "
                + connectionResult.getErrorCode());
    }

    public void startNextActivity(View view){

        bundle.putString("MyLocation",edTxtLocation.getText().toString());
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
