package com.example.karan.listviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dept = new ArrayList<>();
        dept.add("IT");
        dept.add("HR");
        dept.add("Systems");
        dept.add("Public Realtions");
        dept.add("Accounts");
        dept.add("Education");
        dept.add("Admin");
        dept.add("HOD");
        dept.add("Teacher");
        dept.add("Teacher");
        dept.add("Teacher");
        dept.add("Teacher");
        dept.add("Teacher");
        dept.add("Teacher");
        dept.add("Teacher");
        dept.add("Teacher");
        dept.add("Teacher");
        dept.add("Teacher");
        //Log.d("ss",dept.get(0));
        ListView lv = (ListView) findViewById(android.R.id.list);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dept);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),dept.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
