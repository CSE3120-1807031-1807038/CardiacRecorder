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

public class MainActivity extends AppCompatActivity {
    Button Add_new_record;
    RecyclerView recyclerView;
    List<Values> valuesList;
    Database DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB = new Database(this);
        valuesList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview_mainpage);
        adapter = new MyAdapter(this,valuesList);
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

    private void displaydata() {
        Cursor cursor = DB.getdata();
        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                Values values = new Values(cursor.getString(1),cursor.getString(2),
                        cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6));
                valuesList.add(values);
                cursor.moveToNext();
            }
        }
        cursor.close();
    }
}