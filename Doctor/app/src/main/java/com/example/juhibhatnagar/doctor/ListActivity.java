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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import Data.FindandBook_data;
import model.Book;

public class ListActivity extends AppCompatActivity {
   private List<Book> book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        book = FindandBook_data.getData();
        ArrayAdapter<Book> courseArrayAdapter = new ListActivity.CustomArrayAdapter(this, 0, book);
        ListView lv = (ListView) findViewById(android.R.id.list);
        lv.setAdapter(courseArrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0) {
                    Intent intent = new Intent(ListActivity.this, FindActivity.class);

                    startActivity(intent);
                }
                if(position==2)
                {
                    Intent intent1=new Intent(ListActivity.this,AyurvedActivity.class);
                    startActivity(intent1);
                }
                if(position==4)
                {
                    Intent intent2=new Intent(ListActivity.this,NutritionActivity.class);
                    startActivity(intent2);
                }

            }
        });


    }


class CustomArrayAdapter extends ArrayAdapter<Book> {
    Context context;
    List<Book> objects;

    public CustomArrayAdapter(Context context, int resource, List<Book> objects) {
        super(context, resource, objects);

        this.context = context;
        this.objects = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        Book b = objects.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.book_list, null);

        TextView tv = (TextView) view.findViewById(R.id.tv);
        tv.setText(b.getTitle().toString());

        ImageView iv = (ImageView) view.findViewById(R.id.iv);
        int res = context.getResources().getIdentifier("image_" + b.getId(), "drawable", context.getPackageName());
        iv.setImageResource(res);


        return view;
    }

}
}