package com.example.karan.listandclass;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class JsonHelper {
    public static final String FILE_NAME="test.json";
    public static final String TAG="jsonHelper";
    public static boolean exportToJson(Context context, List<String> values){
        Course c=new Course();
        c.setCname(values.toString());
        Gson gson=new Gson();
        String j=gson.toJson(c);
        Log.i(TAG,"Exported to json"+j);
        FileOutputStream fos=null;
        File file=new File(Environment.getExternalStorageDirectory(),FILE_NAME);
        try {
            fos=new FileOutputStream(file);
            fos.write(j.getBytes());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try{
                if(fos!=null){
                    fos.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }
    public static String ImportFromJson(Context c){
        FileReader fr=null;
        try{
            File file=new File(Environment.getExternalStorageDirectory(),FILE_NAME);
            try{
                fr=new FileReader(file);
            Gson gson=new Gson();
            Course j=gson.fromJson(fr,Course.class);
            return j.getCname();}
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            finally {
                try{
                    if(fr!=null){
                        fr.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
