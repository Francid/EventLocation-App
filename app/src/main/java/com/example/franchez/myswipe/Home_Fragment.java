package com.example.franchez.myswipe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Franchez on 2015-12-02.
 */
public class Home_Fragment extends Fragment {
    private EditText editTextLocation;
    private CheckBox chkDefault;
    private View homeView;
    private Bundle bundle;

    EventList_Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bundle = this.getArguments();
        View homeFrag = inflater.inflate(R.layout.fragment_home,container,false);

        ((TextView)homeFrag.findViewById(R.id.textView)).setText("Home Page Testing");
        chkDefault = (CheckBox)homeFrag.findViewById(R.id.chkDefLoc);
        chkDefault.setChecked(true);
        editTextLocation = (EditText)homeFrag.findViewById(R.id.homeEditTxtLocation);
        editTextLocation.setEnabled(false);
        editTextLocation.setText(bundle.getString("MyLocation"));

        homeView = homeFrag;
        changeLocation();
        setListviewData();
        return homeFrag;
    }

    private void changeLocation(){

        chkDefault.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkDefault.isChecked()) {
                    editTextLocation.setEnabled(false);
                } else {
                    editTextLocation.setEnabled(true);
                }
            }
        });
    }

    /*Set the listview Listener populate the data*/
    private void setListviewData(){
        ListView listView = (ListView)homeView.findViewById(R.id.homeLstVwItems);

        adapter = new EventList_Adapter(homeView.getContext(),generateData());
        listView.setAdapter(adapter);
    }

    /*Generate data for the places*/
    private ArrayList<String> generateData(){
        ArrayList<String> item = new ArrayList<String>();
        item.add("PLaces 1");
        item.add("Events 2");
        item.add("Events 3");
        item.add("PLaces 4");
        item.add("PLaces 5");
        return item;
    }
}
