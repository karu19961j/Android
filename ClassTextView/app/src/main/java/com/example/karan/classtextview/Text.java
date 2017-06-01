package com.example.karan.classtextview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Text extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
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
        Intent i=getIntent();
        Student st=i.getParcelableExtra("studentdetails");
        TextView rollno= (TextView) findViewById(R.id.rollno);
        rollno.setText(""+st.getRollno());
        TextView name= (TextView) findViewById(R.id.name);
        name.setText(st.getSdnm());
        TextView marks= (TextView) findViewById(R.id.marks);
        marks.setText(""+st.getMarks());
    }

}
