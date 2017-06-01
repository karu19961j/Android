package com.example.karan.listandclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class lang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lang);
        Intent i1=getIntent();
        Course cg=(Course)i1.getParcelableExtra("objects");
        TextView tv1= (TextView) findViewById(R.id.id);
        TextView tv2= (TextView) findViewById(R.id.cname);
        TextView tv3= (TextView) findViewById(R.id.desc);
        int id2= cg.getId();
        String img="image_"+id2;
        int res=getResources().getIdentifier(img,"drawable",getPackageName());
        ImageView iv= (ImageView) findViewById(R.id.imageView);
        iv.setImageResource(res);
        tv1.setText(""+cg.getId());
        tv2.setText(cg.getCname());
        tv3.setText(cg.getDesc());
    }
}
