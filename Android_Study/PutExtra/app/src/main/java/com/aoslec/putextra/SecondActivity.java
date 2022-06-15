package com.aoslec.putextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView = null;
    Button button = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.tv_second);
        button = findViewById(R.id.btn_second);

        Intent intent = getIntent();
        String userid = intent.getStringExtra("userid"); // 변수의 값을 받아옴
        int passwd = intent.getIntExtra("passwd",0);
        //passwd의 값이 없을 시 -> default 값:0
        textView.setText("UserId : " + userid + " / " + "Password : " + passwd);

        button.setOnClickListener(onClickListener);

    }//onCreate


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();// 현재 Activity를 종료
        }
    };
}