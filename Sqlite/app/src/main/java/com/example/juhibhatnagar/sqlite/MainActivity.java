package com.example.juhibhatnagar.sqlite;

import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import database.DataSource;
import model.DataItem;
import sample.SampleDataProvider;

public class MainActivity extends AppCompatActivity {
    TextView tvOut;
    List<DataItem> dataItemList = SampleDataProvider.dataItemList;
    List<String> itemNames = new ArrayList<>();
    DataSource mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDataSource = new DataSource(this);
        mDataSource.open();
        mDataSource.seedDatabase(dataItemList);
//        Toast.makeText(this, "Database required!!!", Toast.LENGTH_SHORT).show();
//        long numItems = mDataSource.getDataItemsCount();
//        if (numItems == 0) {
//            for (DataItem item : dataItemList) {
//                try {
//                    mDataSource.createItem(item);
//                } catch (SQLiteException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//            Toast.makeText(this, "Data inserted!", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Data already inserted!", Toast.LENGTH_SHORT).show();
//        }
//
//
//        Collections.sort(dataItemList, new Comparator<DataItem>() {
//            @Override
//            public int compare(DataItem o1, DataItem o2) {
//                return o1.getItemname().compareTo(o2.getItemname());
//            }
//        });
//
//        for (DataItem item : dataItemList) {
//            itemNames.add(item.getItemname());
//        }
//        DataItemAdapter adapter = new DataItemAdapter(this, dataItemList);
////         Collections.sort(itemNames);
////        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itemNames);
//        ListView listview = (ListView) findViewById(android.R.id.list);
//        listview.setAdapter(adapter);

        List<DataItem> listfromdb=mDataSource.getAllItems();
        DataItemAdapter adapter = new DataItemAdapter(this, listfromdb);

        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(adapter);

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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mDataSource.close();

    }
    @Override
    protected void onResume() {
        super.onResume();
        mDataSource.open();
    }

}