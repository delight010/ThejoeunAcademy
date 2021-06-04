package com.asolec.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<CharSequence> adapter = null;
    //xml파일을 불러올 때 <CharSequence>
    Spinner spinner = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adapter와 xml Data 연결
        adapter = ArrayAdapter.createFromResource(this, R.array.travelArea,
                android.R.layout.simple_spinner_dropdown_item);
        spinner = findViewById(R.id.sp_01);
        spinner.setAdapter(adapter);
    }
}