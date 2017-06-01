package com.example.karan.fileinputdata;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_PERMISSION_WRITE=1001;
    private boolean permissionGranted;
    TextView output;
    TextView fName;
    TextView lName;
    public static final String FILE_NAME="loremipsum.txt";

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermissions();}

    private File getFile() {
        return new File(Environment.getExternalStorageDirectory(), FILE_NAME);
    }


    public void Adddata(View view) throws FileNotFoundException {
        if(!permissionGranted){
            checkPermissions();
            return;
        }
        //String string=getString(R.string.txtfile);
        fName= (TextView) findViewById(R.id.fname);
        String fname=fName.getText().toString();
        lName= (TextView) findViewById(R.id.lname);
        String lname=lName.getText().toString();
        File file=getFile();
        FileOutputStream fos= new FileOutputStream(file);
        try {
            //fos=openFileOutput(FILE_NAME,MODE_PRIVATE);
            fos.write(fname.getBytes());
            fos.write(lname.getBytes());
            Toast.makeText(this,"file Added",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(this,"Exception "+e.getMessage(),Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void deleteData(View view) {
        if(!permissionGranted){
            checkPermissions();
            return;
        }
        File file=getFile();
        if(file.exists()){
            file.delete();
            Toast.makeText(this,"File Deleted",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"File Dosent exist",Toast.LENGTH_SHORT).show();
        }

    }

    public void ReadData(View view) throws IOException {
        if(!permissionGranted){
            checkPermissions();
            return;
        }
        output= (TextView) findViewById(R.id.data);
        File file=getFile();
        FileInputStream fos=new FileInputStream(file);
        StringBuffer fileContent=new StringBuffer("");
        try{
            byte[] buffer=new byte[1024];
            int n;
            while ((n = fos.read(buffer)) != -1) {
                // convert to char and display it
                output.setText(new String(buffer,0,n));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state));
    }

    // Initiate request for permissions.
    private boolean checkPermissions() {

        if (!isExternalStorageReadable() || !isExternalStorageWritable()) {
            Toast.makeText(this, "This app only works on devices with usable external storage",
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_PERMISSION_WRITE);
            return false;
        } else {
            return true;
        }
    }

    // Handle permissions result
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_WRITE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    permissionGranted = true;
                    Toast.makeText(this, "External storage permission granted",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "You must grant permission!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
