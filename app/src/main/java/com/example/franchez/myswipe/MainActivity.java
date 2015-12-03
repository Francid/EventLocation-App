package com.example.franchez.myswipe;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toolbar;


public class MainActivity extends ActionBarActivity {
    CustomViewPager Tab;
    android.support.v7.app.ActionBar actionBar;
    private DrawerLayout mDrawer;
    private NavigationView nvDrawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tab = (CustomViewPager) findViewById(R.id.pager);
        actionBar = getSupportActionBar();

        createHomeFragment();

        /* Creating the drawer from this point**/
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);
    }

    private void createHomeFragment(){

        Fragment homefragment = null;
        Class homeclass = Home_Fragment.class;
        try {
            homefragment = (Fragment)homeclass.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        if (actionBar.isShowing()){
            actionBar.removeAllTabs();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContent,homefragment).commit();
        setTitle("Home Page");
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        selectDrawerItem(item);
                        return true;
                    }
                }
        );
    }

    /* Check which navigation Item is been selected**/
    public void selectDrawerItem(MenuItem menuItem) {

        Fragment fragment = null;
        Class fragmentClass = null;

        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                createHomeFragment();
                break;
            case R.id.nav_places:
                fragmentClass = Place_Fragment.class;
                break;
            case R.id.nav_events:
                fragmentClass = EventCategory_Fragment.class;
                break;
            case R.id.nav_saved:
                fragmentClass = Saved_Fragment.class;
                break;
            default:
                break;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (actionBar.isShowing()){
            actionBar.removeAllTabs();
        }

        if (menuItem.getItemId() != R.id.nav_home ) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragmentContent, fragment).commit();
        }

        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawer.closeDrawers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
/*        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }*/
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }
}
