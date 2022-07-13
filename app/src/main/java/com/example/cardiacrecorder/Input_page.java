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
    DatabaseReference database_values;
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
//        date_in.setInputType(InputType.TYPE_NULL);
//        time_in.setInputType(InputType.TYPE_NULL);
        database_values = FirebaseDatabase.getInstance().getReference("All values");
//        date_in.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDateDialog(date_in);
//            }
//        });
//        time_in.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showTimeDialog(time_in);
//            }
//        });
        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SP = Sp.getText().toString();
                String DP = Dp.getText().toString();
                String HeartRate = Heart_rate.getText().toString();
                String comment = Comment.getText().toString();
                String date =date_in.getText().toString();
                String time=time_in.getText().toString();
                Values values = new Values(SP,DP,HeartRate,comment,date,time);
                database_values.push().setValue(values);
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }

        });
    }

//    private void showTimeDialog(final EditText time_in) {
//        final Calendar calendar=Calendar.getInstance();
//        TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
//            @Override
//            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
//                calendar.set(Calendar.MINUTE,minute);
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
//                time_in.setText(simpleDateFormat.format(calendar.getTime()));
//            }
//        };
//        new TimePickerDialog(Input_page.this,timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
//    }
//
//    private void showDateDialog(final EditText date_in){
//        final Calendar calendar =Calendar.getInstance();
//        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                 calendar.set(Calendar.YEAR,year);
//                 calendar.set(Calendar.MONTH,month);
//                 calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
//                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy-MM-dd");
//                date_in.setText(simpleDateFormat.format(calendar.getTime()));
//            }
//        };
//        new DatePickerDialog(Input_page.this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
//    }

}