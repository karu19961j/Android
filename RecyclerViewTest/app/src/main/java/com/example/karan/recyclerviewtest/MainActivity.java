package com.example.karan.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> mTitle;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mTitle = new ArrayList<>();
        mTitle.add("Android");
        mTitle.add("Python");
        mTitle.add("Java");
        mTitle.add("JavaScript");

        for (int i = 0; i <300 ; i++) {
            mTitle.add("Android #" + i);
        }

        mRecyclerView.setHasFixedSize(true);

        //Layout
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MainAdapter(mTitle);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
