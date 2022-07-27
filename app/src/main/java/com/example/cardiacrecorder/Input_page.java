package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Comment;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Input_page extends AppCompatActivity {
    EditText Sp;
    EditText Dp,Heart_rate,Comment;
    EditText date_in;
    EditText time_in;
    Button Enter;
    Database DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_page);

        Sp = findViewById(R.id.SP);
        Dp = findViewById(R.id.DP);
        Heart_rate = findViewById(R.id.HeartRate);
        Comment = findViewById(R.id.Comment);
        Enter = findViewById(R.id.enter_btn);
        date_in = findViewById(R.id.editDate);
        time_in = findViewById(R.id.editTime);

        DB = new Database(this);

        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SP = Sp.getText().toString();
                String DP = Dp.getText().toString();
                String HeartRate = Heart_rate.getText().toString();
                String comment = Comment.getText().toString();
                String date =date_in.getText().toString();
                String time=time_in.getText().toString();
                Boolean checkinsertdata = DB.insert_user_data(SP,DP,HeartRate,comment,date,time);
                if(checkinsertdata == true){
                    Toast.makeText(Input_page.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Input_page.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }

        });
    }



}