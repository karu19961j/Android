package com.example.karan.formsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import database.DBhelper;
import model.Student;

public class Gettingdata extends AppCompatActivity {
    DBhelper db1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gettingdata);
        Intent intent=getIntent();
        String s=intent.getStringExtra("fnm");

       // db1=new DBhelper(this);
//        List<Student> allData = db1.getAllData();
//        for (Student s:allData) {
//            String nm=
            TextView tv = (TextView) findViewById(R.id.fname);
        tv.setText("hello.."+s);
//            TextView tv1 = (TextView) findViewById(R.id.lname);
//            TextView tv2 = (TextView) findViewById(R.id.mobile);
//            String f = tv.getText();
        Toast.makeText(this,"record inserted",Toast.LENGTH_SHORT).show();
//        }
    }
}
