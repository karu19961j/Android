package com.example.karan.jsonfileinput;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;
public class Jsonhelper {
        private static final String FILE_NAME = "testing.json";
        private static final String TAG = "jsonHelper";
        public static boolean exportToJson(Context context, List<String> dil) {
            DataItem dataItemlist = new DataItem();
            dataItemlist.setCompany(dil.toString());
            Gson gson = new Gson();
            String jsonname = gson.toJson(dataItemlist);
            Log.i(TAG, "Export to jsaon" + jsonname);
            return false;
        }
}
