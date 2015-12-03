package com.example.franchez.myswipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Franchez on 2015-12-02.
 */
public class Home_Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View detailsFrag = inflater.inflate(R.layout.fragment_home,container,false);
        ((TextView)detailsFrag.findViewById(R.id.textView)).setText("Home Page Testing");
        return detailsFrag;
    }
}
