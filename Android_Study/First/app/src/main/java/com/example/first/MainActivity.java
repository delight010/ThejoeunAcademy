package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // onCreate = Main
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // display. res 폴더의 layout에 들어있는 파일.
    }
}