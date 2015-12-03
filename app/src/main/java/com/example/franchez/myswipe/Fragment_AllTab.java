package com.example.franchez.myswipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

/**
 * Created by Franchez on 2015-11-19.
 */
public class Fragment_AllTab extends Fragment {

    EventList_Adapter adapter;

    private android.support.v7.app.ActionBar actionBar;
    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*Get which button or drawer is click*/
        Bundle bundle = getArguments();
        String callID = bundle.getString("ClickID");

        View android = inflater.inflate(R.layout.fragment_tabs, container, false);

//        tabPagerAdapter = new TabPagerAdapter((getActivity()).getSupportFragmentManager(),"Test");
        listView = (ListView)android.findViewById(R.id.listAndroid);

        switch (callID){

            case "Music":
                adapter = new EventList_Adapter(android.getContext(),eventGenerateData());
                break;
            case "Cultural":
                adapter = new EventList_Adapter(android.getContext(),eventGenerateData());
                break;
            case "Science":
                adapter = new EventList_Adapter(android.getContext(),eventGenerateData());
                break;
            case "Business":
                adapter = new EventList_Adapter(android.getContext(),eventGenerateData());
                break;
            case "Arts":
                adapter = new EventList_Adapter(android.getContext(),eventGenerateData());
                break;
            case "Sports":
                adapter = new EventList_Adapter(android.getContext(),eventGenerateData());
                break;
            case "PLACES":
                /*Get the custome Adapter*/
                adapter = new EventList_Adapter(android.getContext(),placeGenerateData());
                break;
            default:
                break;
        }
        getActivity().setTitle(callID + " Events");
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                createDetailFragment();
            }
        });
        return android;
    }
    //
    private void createDetailFragment(){

        Fragment detailFragment = null;
        Class detailClass = Fragment_Details.class;
        try {
            detailFragment = (Fragment)detailClass.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }

        actionBar = ((ActionBarActivity)getActivity()).getSupportActionBar();

        if(actionBar.isShowing()){
            actionBar.removeAllTabs();
        }
        FragmentManager fragmentManager = (getActivity()).getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContent,detailFragment).commit();
        (getActivity()).setTitle("Details");
    }

    /* Generate data for the events*/
    private ArrayList<String> eventGenerateData(){
        ArrayList<String> events = new ArrayList<String>();
        events.add("Event 1");
        events.add("Event 2");
        events.add("Event 3");
        events.add("Event 4");
        events.add("Event 5");
        return events;
    }

    /*Generate data for the places*/
    private ArrayList<String> placeGenerateData(){
        ArrayList<String> place = new ArrayList<String>();
        place.add("PLaces 1");
        place.add("PLaces 2");
        place.add("PLaces 3");
        place.add("PLaces 4");
        place.add("PLaces 5");
        return place;
    }

}