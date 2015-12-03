package com.example.franchez.myswipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Franchez on 2015-11-24.
 */
public class EventList_Fragment extends Fragment {

    private TabPagerAdapter TabAdapter;
    private android.support.v7.app.ActionBar actionBar;
    private ActionBar.TabListener tabListener;
    Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        CustomViewPager Tab;
        bundle = getArguments();

        View all_tab = inflater.inflate(R.layout.fragment_event_list, container, false);
        Tab = (CustomViewPager)all_tab.findViewById(R.id.pagerEvent);
        Toast.makeText(all_tab.getContext(),"Clicked Button: "+ bundle.getString("ButtonName"),Toast.LENGTH_LONG).show();
        testingTab(Tab);
        return all_tab;
    }

    public void testingTab(CustomViewPager Tab) {

        TabAdapter = new TabPagerAdapter(getActivity().getSupportFragmentManager(), bundle.getString("ButtonName"));

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
        if (actionBar.isShowing()) {
            actionBar.removeAllTabs();
        }
        actionBar.addTab(actionBar.newTab().setText("ALL").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("POPULAR").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("NEARBY").setTabListener(tabListener));
    }
}
