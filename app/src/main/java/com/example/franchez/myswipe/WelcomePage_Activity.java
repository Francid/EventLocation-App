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

import java.util.List;
import java.util.Locale;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Franchez on 2015-11-26.
 */
public class WelcomePage_Activity extends AppCompatActivity
        implements ConnectionCallbacks, OnConnectionFailedListener {

    private static EditText edTxtLocation;
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;
    private static final String TAG = WelcomePage_Activity.class.getSimpleName();
    private GoogleApiClient mGoogleApiClient;
    private Location userLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);

        edTxtLocation = (EditText) findViewById(R.id.edTxtLocation);

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
        /*Intent bIntent = new Intent(Intent.ACTION_SYNC,null,this,BackgroudRun_Service.class);
        startService(bIntent);*/
    }


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
                    displayUserLocation();
                } else {
                    edTxtLocation.getText().clear();
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

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
