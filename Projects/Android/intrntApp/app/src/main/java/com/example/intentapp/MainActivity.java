package com.example.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button savebtn;
    String name, password;
    EditText editname , editpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        savebtn = findViewById(R.id.savebtn);
        editname = findViewById(R.id.editname);
        editpass = findViewById(R.id.editpass);
    }



    public void saveData(View view) {
        name = editname.getText().toString();
        password = editpass.getText().toString();

        Intent intent = new Intent(MainActivity.this ,Main2Activity.class );
        intent.putExtra("name" , name);
        intent.putExtra("password" , password);
        startActivity(intent);
    }
}


