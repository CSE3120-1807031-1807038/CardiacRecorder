package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Comment;

public class Input_page extends AppCompatActivity {
    EditText Sp;
    EditText Dp,Heart_rate,Comment;
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
        database_values = FirebaseDatabase.getInstance().getReference("All values");
        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SP = Sp.getText().toString();
                String DP = Dp.getText().toString();
                String HeartRate = Heart_rate.getText().toString();
                String comment = Comment.getText().toString();
                Values values = new Values(SP,DP,HeartRate,comment);
                database_values.push().setValue(values);
            }
        });
    }
}