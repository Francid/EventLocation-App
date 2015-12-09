package com.example.franchez.myswipe;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;

import java.util.List;
import java.util.Locale;

/**
 * Created by Franchez on 2015-12-09.
 */
public class LocationDetection_Class
        implements ConnectionCallbacks, OnConnectionFailedListener {

    private Context context;

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;
    private static final String TAG = WelcomePage_Activity.class.getSimpleName();
    private GoogleApiClient mGoogleApiClient;
    private Location userLocation;

    public LocationDetection_Class(Context context) {
        this.context = context;

        if (checkDevicePlayService()) {
            buildApiClient();
            if (mGoogleApiClient != null) {
                mGoogleApiClient.connect();
            }
        }
        getUserLocation();

    }

    /* 1. Create Google API Client object
* */
    protected synchronized void buildApiClient() {

        mGoogleApiClient = new GoogleApiClient.Builder(context.getApplicationContext())
                .addConnectionCallbacks((ConnectionCallbacks)context.getApplicationContext())
                .addOnConnectionFailedListener((OnConnectionFailedListener)context.getApplicationContext())
                .addApi(LocationServices.API)
                .build();
    }

    /* 2. Check if google play service is on the device
    * */

    private boolean checkDevicePlayService() {

        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context.getApplicationContext());

        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode,(Activity)context.getApplicationContext(),
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Toast.makeText(context, "This device is not supported.",
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

        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
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
                Toast.makeText(context, "user Location failed",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "Could not get address.",
                    Toast.LENGTH_LONG).show();
        }
        return userCity + ", " + userProvince;
    }

    /* 5. Display it to the user.
    * */
    private void displayUserLocation() {

        System.out.println("Get user location");
    }

    private void userSetDefLoc() {

    }

    /*6. Connect the API client object during onStart
    * */
   /* @Override
    protected void onStart() {
        super.onStart();
        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }
    }*/

    /*
    * 3. Perform an action if connection was successful or
    *    If the connection was suspended or
    *    If connection failed
    * */
    @Override
    public void onConnected(Bundle bundle) {

        Toast.makeText(context, "Connection Successful !!!", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onConnectionSuspended(int i) {

        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

        Toast.makeText(context, "Connection Failed", Toast.LENGTH_LONG).show();
        Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = "
                + connectionResult.getErrorCode());
    }


}
