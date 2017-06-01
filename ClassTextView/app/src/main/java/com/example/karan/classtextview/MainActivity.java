package com.example.karan.classtextview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendtoclass(View view) {
        Intent intent=new Intent(this,Text.class);
        EditText snm= (EditText) findViewById(R.id.sname);
        EditText rno= (EditText) findViewById(R.id.rollno);
        EditText mks= (EditText) findViewById(R.id.marks);

        String stud= snm.getText().toString();
        String rolln=rno.getText().toString();

        int rn=Integer.parseInt(rolln);//converting String value into int
        String marks=mks.getText().toString();
        int mk=Integer.parseInt(marks);
        Student s=new Student();
        s.setSdnm(stud);
        s.setRollno(rn);
        s.setMarks(mk);
        Bundle b=new Bundle();
        b.putParcelable("studentdetails",s);
        intent.putExtras(b);
        startActivity(intent);
    }
}
