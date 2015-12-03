package com.example.franchez.myswipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Franchez on 2015-11-24.
 */
public class Fragment_Details extends Fragment {

    MapView mapView;
    GoogleMap map;
    private final int[] MAP_TYPES ={GoogleMap.MAP_TYPE_SATELLITE,
                                    GoogleMap.MAP_TYPE_NORMAL,
                                    GoogleMap.MAP_TYPE_HYBRID,
                                    GoogleMap.MAP_TYPE_TERRAIN,
                                    GoogleMap.MAP_TYPE_NONE};

    private int curMapTaypeIndex= 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View detailsFrag = inflater.inflate(R.layout.fragment_details,container,false);
        ((TextView)detailsFrag.findViewById(R.id.textView)).setText("Details");

        mapView = (MapView)detailsFrag.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        return detailsFrag;
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
        //intCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    private void intCamera(){

        map = ((SupportMapFragment)getActivity().getSupportFragmentManager()
                .findFragmentById(R.id.mapView)).getMap();

        CameraPosition position = CameraPosition.builder()
                .target(new LatLng(43.7837452,-79.2471304))
                .zoom(16f)
                .bearing(0.0f)
                .tilt(0.0f)
                .build();
        map.animateCamera(CameraUpdateFactory
                .newCameraPosition(position),null);
        map.setMapType(MAP_TYPES[curMapTaypeIndex]);
        map.setTrafficEnabled(true);
        map.setMyLocationEnabled(true);
        map.getUiSettings().setZoomControlsEnabled(true);
    }
}
