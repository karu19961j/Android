package com.example.karan.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent i=getIntent();
        String mesg=i.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView tv= (TextView) findViewById(R.id.displayText);
        tv.setText(mesg);
    }
}
