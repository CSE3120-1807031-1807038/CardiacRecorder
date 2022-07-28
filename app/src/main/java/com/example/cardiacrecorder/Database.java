package com.example.cardiacrecorder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(sp TEXT, dp TEXT, heart_rate TEXT, date TEXT, time TEXT, comment TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop TABLE if exists Userdetails");
    }

    public boolean insert_user_data(String sp, String dp, String heart_rate, String date, String time, String comment) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sp", sp);
        contentValues.put("dp", dp);
        contentValues.put("heart_rate", heart_rate);
        contentValues.put("date", date);
        contentValues.put("time", time);
        contentValues.put("comment", comment);
        long result = DB.insert("Userdetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;
    }

    //    public Cursor deletedata()
//    {
//        {
//            SQLiteDatabase DB = this.getWritableDatabase();
//            Cursor cursor = DB.rawQuery("delete from Userdetails",null);
//            return cursor;
//        }
//    }
    public void deleteData(String sp, String dp, String heart_rate) {
        SQLiteDatabase DB = this.getWritableDatabase();
        String whereClause = "sp=? AND dp=? AND heart_rate=?";
        String whereArgs[] = {sp, dp, heart_rate};
        DB.delete("Userdetails", whereClause, whereArgs);
    }


    public boolean checkIfDataExists(String sp, String dp, String heart_rate, String date, String time, String comment) {
        SQLiteDatabase DB = this.getWritableDatabase();
        String Query = "Select * from Userdetails where sp=" + sp + " and dp= " + dp + " and heart_rate = " + heart_rate;
        Cursor cursor = DB.rawQuery(Query, null);
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public void updateData(String checkSP, String checkDP, String checkBPM, String sp, String dp, String heart_rate, String date, String time, String comment) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sp", sp);
        contentValues.put("dp", dp);
        contentValues.put("heart_rate", heart_rate);
        contentValues.put("date", date);
        contentValues.put("time", time);
        contentValues.put("comment", comment);
        String whereClause = "sp=? AND dp=? AND heart_rate=?";
        String whereArgs[] = {checkSP, checkDP, checkBPM};
        DB.update("Userdetails", contentValues, whereClause, whereArgs);
    }
}
