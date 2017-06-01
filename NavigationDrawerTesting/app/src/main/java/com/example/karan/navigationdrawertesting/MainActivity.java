package com.example.karan.navigationdrawertesting;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mfragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setup the DrawerLayout and NavigationView
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff);

        //Inflating the tabFragment as the first Fragmnet
        mFragmentManager=getSupportFragmentManager();
        mfragmentTransaction=mFragmentManager.beginTransaction();
        mfragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();

        //Setup click events on the Navigation View Items

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();

                if(item.getItemId()==R.id.nav_item_sent){
                    FragmentTransaction fragmentTransaction=mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView,new SentFragment()).commit();
                }
                if(item.getItemId()==R.id.nav_item_inbox){
                    FragmentTransaction xfragmentTransaction=mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();
                }
                return false;
            }
        });
        //Setup Drawer Toggle of the toolbar
        android.support.v7.widget.Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle=new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name,R.string.app_name);
        mDrawerToggle.syncState();
    }
}
