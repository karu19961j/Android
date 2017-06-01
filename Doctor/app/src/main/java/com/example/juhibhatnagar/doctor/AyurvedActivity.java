package com.example.juhibhatnagar.doctor;

import android.app.Activity;
import android.content.Context;
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

import Data.AyurvedicDoctors_data;
import model.Ayurved;

public class AyurvedActivity extends AppCompatActivity {
    private List<Ayurved> ayurved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayurved);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ayurved = AyurvedicDoctors_data.getData();
        ArrayAdapter<Ayurved> courseArrayAdapter = new AyurvedActivity.CustomArrayAdapter(this, 0, ayurved);
        ListView lv = (ListView) findViewById(android.R.id.list);
        lv.setAdapter(courseArrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Ayurved a = ayurved.get(position);


            }

        });
    }

    class CustomArrayAdapter extends ArrayAdapter<Ayurved> {
        Context context;
        List<Ayurved> objects;

        public CustomArrayAdapter(Context context, int resource, List<Ayurved> objects) {
            super(context, resource, objects);

            this.context = context;
            this.objects = objects;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            Ayurved a = objects.get(position);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.ayurved_list, null);

            TextView tv = (TextView) view.findViewById(R.id.tv);
            tv.setText(a.getTitle().toString());
            return view;
        }
    }
}