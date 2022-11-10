package com.example.spinnertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Home");
        setUpButtons();
    }

    private void setUpButtons() {
        Button luckyNumberBtn = findViewById(R.id.lucky_number_btn);
        luckyNumberBtn.setOnClickListener(view -> {
            Intent spinnerIntent = new Intent(this, SpinnerActivity.class);
            startActivity(spinnerIntent);
        });
        Button statesBtn = findViewById(R.id.location_btn);
        statesBtn.setOnClickListener(view -> {
            Intent locationIntent = new Intent(this, LocationActivity.class);
            startActivity(locationIntent);
        });
        Button dobBtn = findViewById(R.id.dob_btn);
        dobBtn.setOnClickListener(view -> {
            Intent dobIntent = new Intent(this, DobActivity.class);
            startActivity(dobIntent);
        });
    }
}