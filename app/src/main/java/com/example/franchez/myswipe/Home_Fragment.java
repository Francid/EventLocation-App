package com.example.franchez.myswipe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
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
    private Button btRefresh;
    private View homeView;
    private Bundle bundle;
    private android.support.v7.app.ActionBar actionBar;

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
        btRefresh = (Button)homeFrag.findViewById(R.id.btReload);
        btRefresh.setEnabled(false);

        homeView = homeFrag;
        changeLocation();
        setListviewData();

        //LocationDetection_Class detection_class = new LocationDetection_Class(homeFrag.getContext());
        return homeFrag;
    }

    /*Listen to the checkbox if checked or not
    * enables or disable the Edittext if checkbox is checked or not*/
    private void changeLocation(){

        chkDefault.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkDefault.isChecked()) {
                    editTextLocation.setEnabled(false);
                    btRefresh.setEnabled(false);
                } else {
                    editTextLocation.setEnabled(true);
                    btRefresh.setEnabled(true);
                }
            }
        });

        btRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Start The Background Process*/
                String d = editTextLocation.getText().toString();
                if(d.contains(",")){
                    d= d.substring(d.indexOf(",")+2);
                }
                /*Intent bIntent = new Intent(Intent.ACTION_SYNC,null,this,BackgroudRun_Service.class);
                bIntent.putExtra("Location",d);
                startService(bIntent);*/
            }
        });
    }

    /*Set the listview Listener populate the data*/
    private void setListviewData(){
        ListView listView = (ListView)homeView.findViewById(R.id.homeLstVwItems);

        adapter = new EventList_Adapter(homeView.getContext(),generateData(),null,null);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                createDetailFragment();
            }
        });
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
