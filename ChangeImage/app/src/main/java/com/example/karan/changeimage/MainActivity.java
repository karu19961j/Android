package com.example.karan.changeimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.x;
import static android.R.attr.y;

public class MainActivity extends AppCompatActivity {

    int j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView svt= (TextView) findViewById(R.id.insideSV);

        StringBuffer sb=new StringBuffer();
        sb.append(getString(R.string.svText));
        sb.append(getString(R.string.svText));
        sb.append(getString(R.string.svText));
        sb.append(getString(R.string.svText));

        svt.setText(sb.toString());
    }
        public void ci (View view){
        String[] imgnm = {"image_10102", "image_10103", "image_10104","image_10101"};
        ImageView iv = (ImageView) findViewById(R.id.ibottom);
            //int i=inc(j);
            j++;
            int res = getResources().getIdentifier(imgnm[j], "drawable", getPackageName());
//        int res1 = getResqources().getIdentifier(imgnm[1], "drawable", getPackageName());
//        int res2 = getResources().getIdentifier(imgnm[2], "drawable", getPackageName());

                iv.setImageResource(res);
                Log.d("MainActivity","clicked");
            if(j==3){
                j=-1;
            }
        }
}
