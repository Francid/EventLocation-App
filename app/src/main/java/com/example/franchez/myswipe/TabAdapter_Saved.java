package com.example.franchez.myswipe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Franchez on 2015-11-19.
 */
public class TabAdapter_Saved extends FragmentStatePagerAdapter {
    public TabAdapter_Saved(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                //Fragement for Event Tab
                return new Fragment_SavedEventsTab();
            case 1:
                //Fragment for Places Tab
                return new Fragment_SavedPlacesTab();
        }
        return null;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 2; //No of Tabs
    }
}
