package com.example.android.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class result_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activity);

        Intent intent = this.getIntent();

        double result = intent.getDoubleExtra("key", 0);
        String result_string = Double.toString(result);

        TextView textView = findViewById(R.id.result);
        textView.setText(result_string);
    }
}