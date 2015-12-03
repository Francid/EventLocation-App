package com.example.franchez.myswipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Franchez on 2015-11-17.
 */
public class ThirdFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View all_tab = inflater.inflate(R.layout.navigation_fragment, container, false);
        return all_tab;
    }
}
