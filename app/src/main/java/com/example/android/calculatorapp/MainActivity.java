package com.example.android.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number_1;
    EditText number_2;
    Button add;
    Button subtract;
    Button divide;
    Button multiply;

    double number_result;
    double num1;
    double num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number_1 = findViewById(R.id.editTextNumberDecimal);
        number_2 = findViewById(R.id.editTextNumberDecimal2);

        add = findViewById(R.id.addition);
        subtract = findViewById(R.id.minus);
        divide = findViewById(R.id.division);
        multiply = findViewById(R.id.multiply);
        setResult(findViewById(R.id.resultBTN));
    }

    public void setResult(View v) {
        if (checkFirstNumber() && checkSecondNumber()) {
            calculate();
            Intent intent = new Intent(this, result_activity.class);
            intent.putExtra("result", number_result);
            startActivity(intent);
        }
    }

    public void calculate() {
        add.setOnClickListener(v -> number_result = num1 + num2);
        subtract.setOnClickListener(v -> number_result = num1 - num2);
        divide.setOnClickListener(v -> { number_result = num1 / num2; });
        multiply.setOnClickListener(v -> number_result = num1 * num2);
    }
    public boolean checkFirstNumber() {

        String firstNum = number_1.getText().toString();

        if (!firstNum.equals(" ")) {
            try {
                num1 = Double.parseDouble(firstNum);
                return true;
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else {
            Toast.makeText(this, "Input cannot be empty", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    public boolean checkSecondNumber() {

        String secondNum = number_2.getText().toString();

        if (!secondNum.equals(" ")) {
            try {
                num2 = Double.parseDouble(secondNum);
                return true;
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else {
            Toast.makeText(this, "Input cannot be empty", Toast.LENGTH_LONG).show();
        }
        return false;
    }
}