package com.example.juhibhatnagar.doctor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.List;

import Data.MainActivity_data;
import model.ListItem;

public class MainActivity extends AppCompatActivity {
    private List<ListItem> lists;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        lists = MainActivity_data.getData();
        ArrayAdapter<ListItem> courseArrayAdapter = new CustomArrayAdapter(this, 0, lists);
        ListView lv = (ListView) findViewById(android.R.id.list);
        lv.setAdapter(courseArrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListItem lm = lists.get(position);
                Intent intent=new Intent(MainActivity.this,ListActivity.class);

                startActivity(intent);

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

    class CustomArrayAdapter extends ArrayAdapter<ListItem> {
        Context context;
        List<ListItem> objects;

        public CustomArrayAdapter(Context context, int resource, List<ListItem> objects) {
            super(context, resource, objects);

            this.context = context;
            this.objects = objects;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            ListItem l = objects.get(position);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.custom_list, null);

            TextView tv = (TextView) view.findViewById(R.id.tv);
            tv.setText(l.getTitle().toString());

            TextView tv2=(TextView)view.findViewById(R.id.tv2);
            tv2.setText(l.getHint().toString());


            ImageView iv = (ImageView) view.findViewById(R.id.iv);
            int res = context.getResources().getIdentifier("image_" + l.getId(), "drawable", context.getPackageName());
            iv.setImageResource(res);


            return view;
        }
    }
}
