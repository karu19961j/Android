package com.example.karan.optionsmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import database.DBhelper;
import model.Student;

public class MainActivity extends AppCompatActivity {
    DBhelper db;
    List<Student>stnd;
    List<String>stnname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //user-made method for gettting the data
        gettingDataListView();
    }
    private void gettingDataListView() {
        ListView lv= (ListView) findViewById(android.R.id.list);
        db=new DBhelper(this);

        //Getting Student details <Student>ArrayList
        stnd=new ArrayList<>();
        stnd=db.getAllData();

        //Creating a <String> ArrayList for passing the student data in listview
        stnname=new ArrayList<>();
        for(Student s:stnd){
            String nm=s.getFname();
            stnname.add(nm);
        }
        ArrayAdapter<String> ad=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,stnname);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(MainActivity.this,ShowActivity.class);
                Bundle b=new Bundle();
                b.putParcelable("student",stnd.get(position));
                i.putExtras(b);
                startActivity(i);
            }
        });
    }

    //onClick eventHandler
    public void insertdata(MenuItem item) {
        Intent i=new Intent(this,InsertActivity.class);
        startActivity(i);
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
}