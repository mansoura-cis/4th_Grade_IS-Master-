package com.example.sqlapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText id , name , email, pass;
    TextView result;
     SqlConnection db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editname);
        email = findViewById(R.id.editmail);
        pass = findViewById(R.id.editpass);
        result= findViewById(R.id.textshow);
        id = findViewById(R.id.editText5);
         db = new SqlConnection(this);
    }

    public void SelectAll(View view) {

        result.setText(db.SelectAll().toString());

    }

    public void InsertStudent(View view) {
        db.insertDB(name.getText().toString(), email.getText().toString(), pass.getText().toString());
        Toast.makeText(MainActivity.this,"Inserted Successfully",Toast.LENGTH_SHORT ).show();

    }

    public void UpdateStudent(View view) {
        db.UpadateStudent(id.getText().toString(), name.getText().toString() , email.getText().toString(), pass.getText().toString());
        Toast.makeText(MainActivity.this,"Updated Successfully",Toast.LENGTH_SHORT ).show();


    }

    public void deleteStudent(View view) {
        db.DeleteStudent(id.getText().toString());
        Toast.makeText(MainActivity.this,"Deleted Successfully",Toast.LENGTH_SHORT ).show();

    }
}
