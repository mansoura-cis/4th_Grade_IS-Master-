package com.example.sqlapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class SqlConnection extends SQLiteOpenHelper {
    public static  final String DBName = "StudentsDB";
    public static  final int Version = 1;

    public SqlConnection(@Nullable Context context) {
        super(context, DBName, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table IF NOT EXISTS students(id INTEGER primary key,name TEXT,email Text,pass TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if EXISTS students ");
        onCreate(db);
    }

    public void  insertDB(String name , String email, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("pass", password);

        db.insert("students",null, values);

    }
    public ArrayList SelectAll() {
        ArrayList dataArray = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from students",null);
        cursor.moveToFirst();
        while ( cursor.moveToNext())
        {
            dataArray.add(cursor.getString(0)+
                    cursor.getString(1)+ cursor.getString(2)+ cursor.getString(3));
        }
        return dataArray;
    }
    public void UpadateStudent(String id , String name , String email,String pass  )
    {
       SQLiteDatabase db = this.getWritableDatabase();
       //db.execSQL("update students set  name=" +name + ",email=" +email+ ",pass="+pass+"where id="+id);
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("pass", pass);
        db.update("students", values, "id", null);
    }
    public  void DeleteStudent(String Id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from students where id ="+Id);
    }

}
