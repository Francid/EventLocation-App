package com.example.franchez.myswipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Franchez on 2015-12-02.
 */
public class Saved_Fragment extends Fragment {

    private TabAdapter_Saved TabAdapter;
    private android.support.v7.app.ActionBar actionBar;
    private ActionBar.TabListener tabListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        CustomViewPager Tab;
//        ActionBarAdapter_Events eventsTab = new ActionBarAdapter_Events();
        View all_tab = inflater.inflate(R.layout.fragment_event_list, container, false);
        Tab = (CustomViewPager)all_tab.findViewById(R.id.pagerEvent);
        testingTab(Tab);
        return all_tab;
    }

    public void testingTab(CustomViewPager Tab) {

        TabAdapter = new TabAdapter_Saved(getActivity().getSupportFragmentManager());

        Tab.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {

                        actionBar = ((ActionBarActivity) getActivity()).getSupportActionBar();
                        actionBar.setSelectedNavigationItem(position);
                    }
                });

        Tab.setAdapter(TabAdapter);
        actionBar = ((ActionBarActivity)getActivity()).getSupportActionBar();
        actionBar.setNavigationMode(android.support.v7.app.ActionBar.NAVIGATION_MODE_TABS);

        tabListener = new ActionBar.TabListener() {

            @Override
            public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }
        };
        if(actionBar.isShowing()){
            actionBar.removeAllTabs();
        }
        actionBar.addTab(actionBar.newTab().setText("EVENTS").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("PLACES").setTabListener(tabListener));
    }
}
