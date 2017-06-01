package com.example.karan.customdialougetest;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showD(View view) {
        AlertDialog.Builder build = new AlertDialog.Builder(MainActivity.this);
        View view1 = getLayoutInflater().inflate(R.layout.customdialouge, null);
        final EditText uname = (EditText) view1.findViewById(R.id.username);
        final EditText pswd = (EditText) view1.findViewById(R.id.password);
        Button login = (Button) view1.findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!uname.getText().toString().isEmpty() && !pswd.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Fill empty fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
        build.setView(view1);
        AlertDialog dialog = build.create();
        dialog.show();
    }
}
