package com.example.franchez.myswipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Franchez on 2015-11-19.
 */
public class Fragment_SavedEventsTab extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View android = inflater.inflate(R.layout.fragment_tabs, container, false);
        ((TextView)android.findViewById(R.id.textView)).setText("Eevents Saved");
        return android;
    }
}
