package com.example.karan.sqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import database.DataSource;
import model.DataItem;
import sample.SampleDataProvider;

public class MainActivity extends AppCompatActivity {
    //TextView tvout;
    List<String>itemNames=new ArrayList<>();
    List<DataItem> datalistitem = SampleDataProvider.dataItemList;
    DataSource mDataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Database Code
        mDataSource = new DataSource(this);
        mDataSource.open();
        //Toast.makeText(this, "Database acquired!!!", Toast.LENGTH_LONG).show();
        mDataSource.seedDatabase(datalistitem);
        List<DataItem> datalistdb=mDataSource.getAllItems();
        DataItemAdapter adapter = new DataItemAdapter(this, datalistdb);
        ListView lv = (ListView) findViewById(android.R.id.list);
        lv.setAdapter(adapter);
    }
    @Override
    protected void onPause(){
        super.onPause();
        mDataSource.close();
    }
    @Override
    protected void onResume(){
        super.onResume();
        mDataSource.open();
    }
}
