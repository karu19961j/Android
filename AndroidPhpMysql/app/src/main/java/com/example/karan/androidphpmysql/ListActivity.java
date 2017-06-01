package com.example.karan.androidphpmysql;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements AsyncResponse {
    private ArrayList<Ddetails> dlist;
    private ListView doctorlv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        PostResponseAsyncTask taskRead=new PostResponseAsyncTask(ListActivity.this,this);
        taskRead.execute("http://192.168.0.101/doctors/dread.php");
    }

    @Override
    public void processFinish(String s) {
        dlist=new JsonConverter<Ddetails>().toArrayList(s,Ddetails.class);

        BindDictionary<Ddetails>details=new BindDictionary<>();

        details.addStringField(R.id.dname, new StringExtractor<Ddetails>() {
            @Override
            public String getStringValue(Ddetails ddetails, int position) {
                return ddetails.name;
            }
        });
        details.addStringField(R.id.dphone, new StringExtractor<Ddetails>() {
            @Override
            public String getStringValue(Ddetails ddetails, int position) {
                return ddetails.phone;
            }
        });
        details.addStringField(R.id.daddress, new StringExtractor<Ddetails>() {
            @Override
            public String getStringValue(Ddetails ddetails, int position) {
                return ddetails.address;
            }
        });
        details.addStringField(R.id.dspeciality, new StringExtractor<Ddetails>() {
            @Override
            public String getStringValue(Ddetails ddetails, int position) {
                return ddetails.speciality;
            }
        });
        FunDapter<Ddetails>fadapter=new FunDapter<>(getApplicationContext(),dlist,R.layout.layout_list,details);
        doctorlv= (ListView) findViewById(R.id.doclist);
        doctorlv.setAdapter(fadapter);
    }
}
