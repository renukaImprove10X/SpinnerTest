package com.example.spinnertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity {

    Integer[] luckyNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        getSupportActionBar().setTitle("Lucky Number");
        setupSpinner();
    }

    private void setupSpinner() {
        Spinner luckyNumbersSp = findViewById(R.id.lucky_numbers_sp);
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(
                    this, R.layout.spinner_item, luckyNumbers);
        luckyNumbersSp.setAdapter(adapter);
        luckyNumbersSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SpinnerActivity.this, "Lucky Number : " + luckyNumbers[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}