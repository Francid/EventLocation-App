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
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Franchez on 2015-11-19.
 */
public class Fragment_SavedEventsTab extends Fragment {

    ListView listView;
    EventList_Adapter adapter;
    Database_Class db;
    private android.support.v7.app.ActionBar actionBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View android = inflater.inflate(R.layout.fragment_tabs, container, false);
//        ((TextView)android.findViewById(R.id.textView)).setText("Eevents Saved");
        listView = (ListView)android.findViewById(R.id.listAndroid);
        db = new Database_Class(getContext());
        adapter = new EventList_Adapter(getContext(),savedDataGenerate());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                createDetailFragment();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                db.deleteSavedEvent(parent.getItemAtPosition(position).toString());
                //Re-create the Adapter and set it to the listview
                adapter = new EventList_Adapter(getContext(),savedDataGenerate());
                listView.setAdapter(adapter);
                return true;
            }
        });
        return android;
    }

    private ArrayList<String> savedDataGenerate(){
        ArrayList<String> savedList;
        savedList = db.getSavedEvent();
        return  savedList;
    }

    //Open a Detail Fragment of the item clicked
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
}
