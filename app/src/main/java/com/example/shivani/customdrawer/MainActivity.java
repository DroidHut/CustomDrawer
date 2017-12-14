package com.example.shivani.customdrawer;


import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.app.Fragment;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] languages;
    Spinner sp;
    private DrawerLayout drawer;
    private ListView mDrawerList;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    CustomDrawerAdapter adapter;
    List<DrawerItem> dataList;
    private ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initializing
        dataList = new ArrayList<DrawerItem>();
        mTitle = mDrawerTitle = getTitle();
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hello User", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
     

       /* NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
       // Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
      

         sp = (Spinner) navigationView.getMenu().findItem(R.id.nav_products).getActionView();
    
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.product_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

       // sp.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,languages));
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              //  Toast.makeText(MainActivity.this,languages[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });*/

        // Add Drawer Item to dataList
        dataList.add(new DrawerItem("Camera",R.drawable.ic_menu_camera ));
        dataList.add(new DrawerItem("Gallery", R.drawable.ic_menu_gallery));
        dataList.add(new DrawerItem("Manage", R.drawable.ic_menu_manage));
        dataList.add(new DrawerItem("Slideshow", R.drawable.ic_menu_slideshow));
        dataList.add(new DrawerItem("Send", R.drawable.ic_menu_send));
        dataList.add(new DrawerItem("Share", R.drawable.ic_menu_share));
       

        adapter = new CustomDrawerAdapter(this, R.layout.custom_drawer_item,
                dataList);

        mDrawerList.setAdapter(adapter);

        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());


         toggle = new ActionBarDrawerToggle(this,
                drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        {
            public void onDrawerClosed(View view) {
                toolbar.setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                toolbar.setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }
        };

        drawer.setDrawerListener(toggle);

        if (savedInstanceState == null) {
            SelectItem(0);
        }
      //  drawer.setDrawerListener(toggle);
        //toggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void SelectItem(int possition) {

        Fragment fragment = null;
        Bundle args = new Bundle();
        switch (possition) {
            case 0:
                fragment = new MyDashboardFragment();
                args.putString(MyDashboardFragment.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(MyDashboardFragment.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());
                break;
            case 1:
                fragment = new SuggestionsFragment();
                args.putString(SuggestionsFragment.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(SuggestionsFragment.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());
                break;
            case 2:
                fragment = new MyDashboardFragment();
                args.putString(MyDashboardFragment.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(MyDashboardFragment.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());
                break;
            case 3:
                fragment = new SuggestionsFragment();
                args.putString(SuggestionsFragment.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(SuggestionsFragment.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());
                break;
            case 4:
                fragment = new MyDashboardFragment();
                args.putString(MyDashboardFragment.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(MyDashboardFragment.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());
                break;
            case 5:
                fragment = new SuggestionsFragment();
                args.putString(SuggestionsFragment.ITEM_NAME, dataList.get(possition)
                        .getItemName());
                args.putInt(SuggestionsFragment.IMAGE_RESOURCE_ID, dataList.get(possition)
                        .getImgResID());
                break;
            default:

                fragment = new MyDashboardFragment();
        }

        fragment.setArguments(args);
        FragmentManager frgManager = getFragmentManager();
        frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                .commit();

        mDrawerList.setItemChecked(possition, true);
        setTitle(dataList.get(possition).getItemName());
        drawer.closeDrawer(mDrawerList);

    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        toolbar.setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        return false;
    }

    private class DrawerItemClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            SelectItem(position);

        }
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        else if (id == R.id.nav_products) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/
}
