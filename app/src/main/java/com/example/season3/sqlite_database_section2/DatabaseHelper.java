package com.example.season3.sqlite_database_section2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "my_database.sqlite";
    public static final int DB_VERSION = 1;
    public  static final String DB_TABLE = "my_table";

    public DatabaseHelper( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+DB_TABLE+" (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, mobile TEXT)");
        // db.execSQL("CREATE TABLE my_table (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, mobile TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE);
    }

    public void insertData(String name, String number){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("mobile",number);
        database.insert(DB_TABLE, null, contentValues);
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+DB_TABLE,  null);
        return cursor;
    }

    public Cursor searchDataById(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+DB_TABLE+" WHERE id LIKE '"+id+"'",  null);
        return cursor;
    }

    public Cursor searchDataByName(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+DB_TABLE+" WHERE name LIKE '%"+name+"%'",  null);
        return cursor;
    }


} //DatabaseHelper end here ==============
