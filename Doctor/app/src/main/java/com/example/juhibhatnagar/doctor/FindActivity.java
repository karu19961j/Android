package com.example.juhibhatnagar.doctor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import Data.Doctors_data;
import model.Find;

public class FindActivity extends AppCompatActivity {
    private List<Find> find;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        find = Doctors_data.getData();
        ArrayAdapter<Find> courseArrayAdapter = new FindActivity.CustomArrayAdapter(this, 0, find);
        ListView lv = (ListView) findViewById(android.R.id.list);
        lv.setAdapter(courseArrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Intent intent = new Intent(FindActivity.this, AddressActivity.class);

                    startActivity(intent);
                }


            }
        });
    }

    class CustomArrayAdapter extends ArrayAdapter<Find> {
        Context context;
        List<Find> objects;

        public CustomArrayAdapter(Context context, int resource, List<Find> objects) {
            super(context, resource, objects);

            this.context = context;
            this.objects = objects;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            Find f = objects.get(position);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.find_list, null);

            TextView tv = (TextView) view.findViewById(R.id.tv);
            tv.setText(f.getTitle().toString());
            TextView tv1 = (TextView) view.findViewById(R.id.tv1);
            tv1.setText(f.getHint().toString());


            return view;
        }


    }
}
