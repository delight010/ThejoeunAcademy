package com.aoslec.intent_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    TextView textView = null;

    Button button = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        button = findViewById(R.id.sub_btn);

        button.setOnClickListener(onClickListener);
    }//onCreate

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish(); //  현재 Activity 종료
        }
    };


}