package com.example.spinnertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class DobActivity extends AppCompatActivity {

    private Integer[] dates = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    private ArrayList<Integer> dateList = new ArrayList<Integer>();
    private String[] months = {"January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"};
    private Integer[] years = {1971, 1972, 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1980,
            1981, 1982, 1983, 1984, 1985, 1986, 1987, 1988, 1989, 1990,
            1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000,
            2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010,
            2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020
    };
    int selectedYear = 1970;
    String selectedMonth = "January";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dob);
        getSupportActionBar().setTitle("Date of Birth");
        setUpData();
        setUpDob();
    }

    private void setUpData() {
        for(int i=1; i<=31; i++){
            dateList.add(i);
        }
    }

    private void setUpDob() {
        Spinner dateSp = findViewById(R.id.date_sp);
        ArrayAdapter<Integer> dateAdapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_list_item_1, dateList);
        dateSp.setAdapter(dateAdapter);
        dateSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(DobActivity.this, "" + dates[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Spinner monthSp = findViewById(R.id.month_sp);
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, months);
        monthSp.setAdapter(monthAdapter);
        monthSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(DobActivity.this, months[i], Toast.LENGTH_SHORT).show();
                selectedMonth = months[i];
//                selectedYear = years[i];
                Integer[] dateRange = getDate(selectedMonth, selectedYear);
                dateAdapter.clear();
                dateAdapter.addAll(dateRange);
                dateAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Spinner yearSp = findViewById(R.id.year_sp);
        ArrayAdapter<Integer> yearAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, years);
        yearSp.setAdapter(yearAdapter);
        yearSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(DobActivity.this, "" + years[i], Toast.LENGTH_SHORT).show();
                selectedYear = years[i];
                Integer[] dateRange = getDate(selectedMonth, selectedYear);
                dateAdapter.clear();
                dateAdapter.addAll(dateRange);
                dateAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private Integer[] getDate(String selectedMonth, int selectedYear) {
        for (int i = 1; i <= months.length; i++) {
            if (selectedMonth == months[i-1]) {
                if ((i % 2 == 1 && i <= 7) || (i % 2 == 0 && i >= 8)) {
                    return Arrays.copyOfRange(dates, 0, 31);
                } else if (i == 2) {
                    int range = (selectedYear % 4 == 0) ? 29 : 28;
                    return Arrays.copyOfRange(dates, 0, range);
                } else if ((i % 2 == 0 && i <= 6) || (i % 2 == 1 && i >= 9)) {
                    return Arrays.copyOfRange(dates, 0, 30);
                }
            }
        }
        return dates;
    }
}