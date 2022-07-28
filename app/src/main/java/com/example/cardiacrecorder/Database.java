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

    /**
     * creates database table
     * @param DB
     * takes database as parameter
     */
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(sp TEXT, dp TEXT, heart_rate TEXT, date TEXT, time TEXT, comment TEXT)");
    }

    /**
     * this function drops the table if when updated
     * @param DB
     * @param i
     * @param ii
     * takes database, as parameter, rest are for overriding
     */
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop TABLE if exists Userdetails");
    }

    /**
     * Inserts data in the userdetails table
     * @param sp
     * @param dp
     * @param heart_rate
     * @param date
     * @param time
     * @param comment
     * takes all the table columns values as parameter
     * @return
     * returns -1 if data insert wasn't successful
     */
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

    /**
     * gets all the Userdetails table data
     * @return
     * returns a cursor containing all rows from Userdetails table
     */
    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;
    }

    /**
     * Deletes a row from the table
     * @param sp
     * @param dp
     * @param heart_rate
     * takes all the necessary column values as input to delete
     */
    public void deleteData(String sp, String dp, String heart_rate) {
        SQLiteDatabase DB = this.getWritableDatabase();
        String whereClause = "sp=? AND dp=? AND heart_rate=?";
        String whereArgs[] = {sp, dp, heart_rate};
        DB.delete("Userdetails", whereClause, whereArgs);
    }

    /**
     * Checks if a row exists in the Userdetails tables
     * @param sp
     * @param dp
     * @param heart_rate
     * @param date
     * @param time
     * @param comment
     * takes all the row data to check as parameter
     * @return
     * returns true if the row exists in the table
     */
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

    /**
     * Updates a existing row from Userdata table with changed values
     * @param checkSP
     * @param checkDP
     * @param checkBPM
     * First three parameters are for finding the existing row
     * @param sp
     * @param dp
     * @param heart_rate
     * @param date
     * @param time
     * @param comment
     * These are the changed values for the row as parameters
     */
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
