package com.example.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
   Button backbtvn;
   TextView txtname , txtpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtname = findViewById(R.id.txtname);
        txtpass = findViewById(R.id.txtPass);
        Bundle bundle = getIntent().getExtras();
        txtname.setText(bundle.getString("name"));
        txtpass.setText(bundle.getString("password"));
    }

    public void Backbtn(View view) {
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
    }
}
