package com.example.karan.basics;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageText extends AppCompatActivity {
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_text);
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
        Intent intent=getIntent();
        String fn=intent.getStringExtra("fname");
        String ln=intent.getStringExtra("lname");
        TextView getmsg= (TextView) findViewById(R.id.getmsg);
        getmsg.setText(fn+" "+ln+" Please press the button to change the image");
    }

    public void changeImg(View view) {
        String []imgs={"image_10102","image_10103","image_10104","image_10101"};
        ImageView iv= (ImageView) findViewById(R.id.iv);
        i++;
        int res = getResources().getIdentifier(imgs[i], "drawable", getPackageName());
        iv.setImageResource(res);
        if(i==3){
            Snackbar.make(view,"Images are in LOOP",Snackbar.LENGTH_LONG).show();
            i=-1;
        }
    }
}
