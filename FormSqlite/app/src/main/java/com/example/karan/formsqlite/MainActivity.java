package com.example.karan.formsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import database.DBhelper;
import model.Student;

public class MainActivity extends AppCompatActivity {
    DBhelper db;
    Student std;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //int mobile2=Integer.parseInt(mobile1);
    }

    public void insertdata(View view) {
        EditText fname = (EditText) findViewById(R.id.fname);
        EditText lname = (EditText) findViewById(R.id.lname);
        EditText mobile = (EditText) findViewById(R.id.phone);
//        String fname1 = fname.getText().toString();
//        String lname1 = lname.getText().toString();
//        String mobile1 = mobile.getText().toString();
        db=new DBhelper(this);
        std=new Student();
        std.setFname(fname.getText().toString());
        String f=std.getFname();
        std.setLname(lname.getText().toString());
        String l=std.getLname();
        std.setMobile(mobile.getText().toString());
        String m=std.getMobile();
        db.InsertData(f,l,m);
        Toast.makeText(this,"Record Inserted",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,Gettingdata.class);
        intent.putExtra("fnm",f);
        startActivity(intent);
    }
}
