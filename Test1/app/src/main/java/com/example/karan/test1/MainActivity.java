package com.example.karan.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE ="com.example.karan.message" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendData(View view) {
        Intent i=new Intent(this,DisplayMessageActivity.class);
        EditText et= (EditText) findViewById(R.id.mainActivity);
        String message=et.getText().toString();
        i.putExtra(EXTRA_MESSAGE,message);
        startActivity(i);
    }
}
