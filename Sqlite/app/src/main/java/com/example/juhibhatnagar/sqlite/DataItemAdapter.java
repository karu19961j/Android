package com.example.juhibhatnagar.sqlite;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import model.DataItem;

/**
 * Created by juhi bhatnagar on 3/10/2017.
 */

public class DataItemAdapter extends ArrayAdapter<DataItem> {
    List<DataItem> mDataItems;
    LayoutInflater mInflater;

    public DataItemAdapter(Context context, List<DataItem> objects) {
        super(context, R.layout.list_item, objects);

        mDataItems = objects;
        mInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tv);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv);

        DataItem item = mDataItems.get(position);

        tvName.setText(item.getItemname());
//        imageView.setImageResource(R.drawable.apple_pie);
        String imgname = item.getImage();
        InputStream inputstream = null;
        try {
            inputstream = getContext().getAssets().open(imgname);
            Drawable drawable = Drawable.createFromStream(inputstream, null);
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        finally
        {
            if(inputstream!=null)
            {
                try {
                    inputstream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return convertView;
    }
}



