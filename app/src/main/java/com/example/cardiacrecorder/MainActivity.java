package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * main activity class
 */
public class MainActivity extends AppCompatActivity {
    Button Add_new_record;
    RecyclerView recyclerView;
    ArrayList<String> sp,dp,bpm,date,time,comment;
    Database DB;
    MyAdapter adapter;

    /**
     * this method will add fragment using recyclerview
     * @param savedInstanceState
     * takes a bundle type parameter
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB = new Database(this);
        sp = new ArrayList<>();
        dp = new ArrayList<>();
        bpm = new ArrayList<>();
        date = new ArrayList<>();
        time = new ArrayList<>();
        comment = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview_mainpage);
        adapter = new MyAdapter(this,sp,dp,bpm,date,time,comment);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
        Add_new_record = findViewById(R.id.add_button);
        Add_new_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Input_page.class));
            }
        });
    }

    /**
     * Saves all the data retrieved from database to view
     */
    private void displaydata() {
        Cursor cursor = DB.getdata();
        while(cursor.moveToNext()){
            sp.add(cursor.getString(0));
            dp.add(cursor.getString(1));
            bpm.add(cursor.getString(2));
            date.add(cursor.getString(3));
            time.add(cursor.getString(4));
            comment.add(cursor.getString(5));

        }
    }
}