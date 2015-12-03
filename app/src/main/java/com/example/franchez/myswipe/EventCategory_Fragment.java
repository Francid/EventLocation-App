package com.example.franchez.myswipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Franchez on 2015-11-24.
 */
public class EventCategory_Fragment extends Fragment {

    Button categoryBT;
    CustomViewPager Tab;
    Button btCultural, btScience, btBusiness, btArts, btSports;
    OnClickListener btClickListener;
    Bundle bundle;
//    ActionBarAdapter_Events eventsTab = new ActionBarAdapter_Events();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View all_tab = inflater.inflate(R.layout.navigation_fragment, container, false);

        bundle = new Bundle();
        btClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                selectButton(v);
            }
        };
        categoryBT = (Button) all_tab.findViewById(R.id.btCategory);
        categoryBT.setOnClickListener(btClickListener);
        btCultural = (Button)all_tab.findViewById(R.id.btCultural);
        btCultural.setOnClickListener(btClickListener);
        btScience = (Button)all_tab.findViewById(R.id.btScience);
        btScience.setOnClickListener(btClickListener);
        btBusiness = (Button)all_tab.findViewById(R.id.btBusiness);
        btBusiness.setOnClickListener(btClickListener);
        btArts = (Button)all_tab.findViewById(R.id.btArts);
        btArts.setOnClickListener(btClickListener);
        btSports = (Button)all_tab.findViewById(R.id.btSports);
        btSports.setOnClickListener(btClickListener);

        getActivity().setTitle("EVENT CATEGORIES");

        return all_tab;
    }

    public void selectButton(View menuItem) {

        Fragment fragment = null;

        Class fragmentClass = null;
        switch (menuItem.getId()) {
            case R.id.btCategory:
                bundle.putString("ButtonName","Music");
                fragmentClass = EventList_Fragment.class;
                break;
            case R.id.btCultural:
                bundle.putString("ButtonName","Cultural");
                fragmentClass = EventList_Fragment.class;
                break;
            case R.id.btScience:
                bundle.putString("ButtonName","Science");
                fragmentClass = EventList_Fragment.class;
                break;
            case R.id.btBusiness:
                bundle.putString("ButtonName","Business");
                fragmentClass = EventList_Fragment.class;
                break;
            case R.id.btArts:
                bundle.putString("ButtonName","Arts");
                fragmentClass = EventList_Fragment.class;
                break;
            case R.id.btSports:
                bundle.putString("ButtonName","Sports");
                fragmentClass = EventList_Fragment.class;
                break;
            default:
                //fragmentClass = FirstFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
            fragment.setArguments(bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContent, fragment).commit();

    }

}

