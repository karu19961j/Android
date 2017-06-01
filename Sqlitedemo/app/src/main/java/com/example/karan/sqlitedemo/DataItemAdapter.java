package com.example.karan.sqlitedemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
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

public class DataItemAdapter extends ArrayAdapter<DataItem> {
    List<DataItem>mdataItems;
    LayoutInflater mInflator;
    public DataItemAdapter(Context context,List<DataItem> objects) {
        super(context,R.layout.activity_list_item,objects);
        mdataItems=objects;
        mInflator=LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            convertView=mInflator.inflate(R.layout.activity_list_item,parent,false);
        }
        TextView tvname= (TextView) convertView.findViewById(R.id.listtextview);
        ImageView iv= (ImageView) convertView.findViewById(R.id.listimageview);
        DataItem item=mdataItems.get(position);
        tvname.setText(item.getItemName());
        //iv.setImageResource(R.drawable.apple_pie);
        String im=item.getImage();
        InputStream is=null;
        try{
            is=getContext().getAssets().open(im);
            Drawable d=Drawable.createFromStream(is, null);
            iv.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(is!=null){
                try{
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  convertView;
    }

}
