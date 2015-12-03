package com.example.franchez.myswipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Franchez on 2015-11-16.
 */


public class TabPagerAdapter extends FragmentStatePagerAdapter {
    String clickName;
    public TabPagerAdapter(FragmentManager fm, String clickName) {
        super(fm);
        // TODO Auto-generated constructor stub
        this.clickName = clickName;
    }

    @Override
    public Fragment getItem(int i) {

        Bundle mBundle = new Bundle();
        mBundle.putString("ClickID",clickName);

        Fragment fragment;
        switch (i) {
            case 0:
                //Fragement for ALL Tab
                fragment = new Fragment_AllTab();
                fragment.setArguments(mBundle);
                return fragment;
            case 1:
                //Fragment for POPULAR Tab
                return new Fragment_PopularTab();
            case 2:
                //Fragment for NEARBY Tab
                return new Fragment_NearbyTab();
        }
        return null;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 3; //No of Tabs
    }

}