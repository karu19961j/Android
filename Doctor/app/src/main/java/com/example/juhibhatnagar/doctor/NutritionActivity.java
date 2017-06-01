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

import Data.Therapist_data;
import model.Nutrition;

public class NutritionActivity extends AppCompatActivity {
    private List<Nutrition> nutrition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nutrition = Therapist_data.getData();
        ArrayAdapter<Nutrition> courseArrayAdapter = new NutritionActivity.CustomArrayAdapter(this, 0, nutrition);
        ListView lv = (ListView) findViewById(android.R.id.list);
        lv.setAdapter(courseArrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Nutrition n = nutrition.get(position);


            }

        });

    }
    class CustomArrayAdapter extends ArrayAdapter<Nutrition> {
        Context context;
        List<Nutrition> objects;

        public CustomArrayAdapter(Context context, int resource, List<Nutrition> objects) {
            super(context, resource, objects);

            this.context = context;
            this.objects = objects;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            Nutrition n = objects.get(position);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.find_list, null);

            TextView tv = (TextView) view.findViewById(R.id.tv);
            tv.setText(n.getTitle().toString());
            TextView tv1 = (TextView) view.findViewById(R.id.tv1);
            tv1.setText(n.getHint().toString());

            return view;
        }
    }

}
