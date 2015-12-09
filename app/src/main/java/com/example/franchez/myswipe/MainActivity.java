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
import android.support.v4.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toolbar;


public class MainActivity extends ActionBarActivity {
    CustomViewPager Tab;
    android.support.v7.app.ActionBar actionBar;
    private DrawerLayout mDrawer;
    private NavigationView nvDrawer;
    private Bundle bundle;
    ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = mDrawerTitle = getTitle();

        Intent in = getIntent();
        bundle = new Bundle();
        Bundle mbundle = in.getExtras();
        String welLoc = mbundle.getString("MyLocation");
        bundle.putString("MyLocation",welLoc);

        Tab = (CustomViewPager) findViewById(R.id.pager);
        actionBar = getSupportActionBar();

        createHomeFragment();

        /* Creating the drawer from this point**/
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);
        setupDrawToggle();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
    /* Drawer Toggle using the App icon**/
    private void setupDrawToggle(){
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawer,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close
        ){
            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mDrawerTitle);
            }
        };
        mDrawer.setDrawerListener(mDrawerToggle);
    }

    private void createHomeFragment(){

        Fragment homefragment = null;
        Class homeclass = Home_Fragment.class;
        try {
            homefragment = (Fragment)homeclass.newInstance();
            homefragment.setArguments(bundle);
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

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }
}
