package com.example.karan.optionsmenu;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import database.DBhelper;

public class InsertActivity extends AppCompatActivity {
    DBhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Getting intent from mainActivity
        Intent i=getIntent();
    }
    //Printing data from database
    public void InsertData(View view) {
        EditText fname = (EditText) findViewById(R.id.fname);
        EditText lname= (EditText) findViewById(R.id.lname);
        EditText mobile= (EditText) findViewById(R.id.phone);
        String fname1=fname.getText().toString();
        String lname1=lname.getText().toString();
        String mobile1=mobile.getText().toString();
        db=new DBhelper(this);
        db.InsertData(fname1,lname1,mobile1);
        Intent i1=new Intent(this,MainActivity.class);
        startActivity(i1);
        Toast.makeText(this,"Record Inserted",Toast.LENGTH_SHORT).show();
    }
}