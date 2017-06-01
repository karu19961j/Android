package com.example.juhibhatnagar.doctor;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import Data.Doctor_Eye_data;
import model.Address;


public class AddressActivity extends AppCompatActivity {
private List<Address> address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        address = Doctor_Eye_data.getData();
        ArrayAdapter<Address> courseArrayAdapter = new AddressActivity.CustomArrayAdapter(this, 0, address);
        ListView lv = (ListView) findViewById(android.R.id.list);
        lv.setAdapter(courseArrayAdapter);
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Address ad = address.get(position);
//
//            }
//        });


    }
    class CustomArrayAdapter extends ArrayAdapter<Address> {
        Context context;
        List<Address> objects;

        public CustomArrayAdapter(Context context, int resource, List<Address> objects) {
            super(context, resource, objects);

            this.context = context;
            this.objects = objects;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            Address ad = objects.get(position);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.address_list, null);

            TextView tv = (TextView) view.findViewById(R.id.tv);
            tv.setText(ad.getTitle().toString());

            TextView tv1 = (TextView) view.findViewById(R.id.tv1);
            tv1.setText(ad.getAddress().toString());

            TextView tv2 = (TextView) view.findViewById(R.id.tv2);
            tv2.setText("INR"+ad.getFee());

           // Button btn= (Button) view.findViewById(R.id.button);



            return view;
        }

    }

}
