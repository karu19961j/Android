package com.example.karan.optionsmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import database.DBhelper;
import model.Student;

import static database.Details.COL_FNAME;

public class ShowActivity extends AppCompatActivity {
    DBhelper db1;
    int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        PrintingData();
    }

    private void PrintingData() {
        Intent i1=getIntent();
        Student s=i1.getParcelableExtra("student");
        EditText etfname= (EditText) findViewById(R.id.showFname);
        EditText etlname= (EditText) findViewById(R.id.showLname);
        EditText etmobile= (EditText) findViewById(R.id.showPhone);
        etfname.setText(s.getFname());
        etlname.setText(s.getLname());
        etmobile.setText(s.getMobile());

        //Getting id for updating and deleting records
        setId(s.getId());
    }
    //onClick eventHandler(Updating Record)
    public void updateRecord(View view) {
        db1=new DBhelper(this);
        EditText etfname= (EditText) findViewById(R.id.showFname);
        EditText etlname= (EditText) findViewById(R.id.showLname);
        EditText etmobile= (EditText) findViewById(R.id.showPhone);
        db1.StdnUpgrade(getId(),etfname.getText().toString(),etlname.getText().toString(),etmobile.getText().toString());
        Intent i=new Intent(ShowActivity.this,MainActivity.class);
        startActivity(i);
        Toast.makeText(this,"Record Updated",Toast.LENGTH_SHORT).show();
    }
    //onClick eventHandler(Deleting Record)
    public void deleteRecord(View view) {
        db1=new DBhelper(this);
        db1.stdnDelete(getId());
        Intent i=new Intent(ShowActivity.this,MainActivity.class);
        startActivity(i);
        Toast.makeText(this,"Record Deleted",Toast.LENGTH_SHORT).show();
    }
}