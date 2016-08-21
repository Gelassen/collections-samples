package com.example.collections.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.collections.App;
import com.example.collections.R;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date date = new Date(1468908916275L);
        Log.d(App.TAG, "Date: " + date);

        Calendar calendar = Calendar.getInstance();
        calendar.get(Calendar.MONTH);
        calendar.get(Calendar.YEAR);
        Log.d(App.TAG, "Month: " + calendar.get(Calendar.MONTH) + " " + "Year: " + calendar.get(Calendar.YEAR));

    }
}
