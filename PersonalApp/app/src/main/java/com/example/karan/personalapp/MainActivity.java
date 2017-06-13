package com.example.karan.personalapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    DrawerLayout mDrawer;
    NavigationView mNav;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setup the drawerLayout and NavigationView
        mDrawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNav = (NavigationView) findViewById(R.id.nav_drawer);

        //Inflating Tab Fragments
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();

        //Setup click events on the navigation View Items
//        mNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(MenuItem item) {
//                mDrawer.closeDrawers();
//                if(item.getItemId()==R.id.pr)
//                return false;
//            }
//        });
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawer,toolbar,R.string.app_name,R.string.app_name);
        //mdrawer.setDrawerListener(mDrawerToggle);
        //mDrawerToggle.syncState();
    }

}
