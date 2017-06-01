package com.example.karan.scrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv=(TextView)findViewById(R.id.tv1);

        StringBuffer sb=new StringBuffer();
        sb.append(getString(R.string.longMsg));
        sb.append(getString(R.string.longMsg));
        sb.append(getString(R.string.longMsg));
        sb.append(getString(R.string.longMsg));

        tv.setText(sb.toString());

    }
}
