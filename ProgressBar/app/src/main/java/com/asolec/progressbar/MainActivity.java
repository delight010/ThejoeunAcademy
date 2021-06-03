package com.asolec.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb01, pb02;
    Button progressBtn, resetBtn, showBtn, hideBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb01 = findViewById(R.id.pb_01);
        pb02 = findViewById(R.id.pb_02);

        progressBtn = findViewById(R.id.btn_01);
        resetBtn = findViewById(R.id.btn_02);
        showBtn = findViewById(R.id.btn_03);
        hideBtn = findViewById(R.id.btn_04);

        progressBtn.setOnClickListener(clickListener);
        resetBtn.setOnClickListener(clickListener);
        showBtn.setOnClickListener(clickListener);
        hideBtn.setOnClickListener(clickListener);

    }//Oncreate

    //method
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_01:
                    pb01.incrementProgressBy(10); // 10씩 증가
                    pb01.incrementSecondaryProgressBy(10);// 10씩 증가
                    break;
                case R.id.btn_02:
                    pb01.setProgress(0); // 0으로 초기화
                    pb01.setSecondaryProgress(10); // 10으로 초기화(버퍼링)
                    break;
                case R.id.btn_03:
                    pb02.setVisibility(ProgressBar.VISIBLE); // 보이기
                    break;
                case R.id.btn_04:
                    pb02.setVisibility(ProgressBar.INVISIBLE); // 숨기기
                    break;
            }
        }
    };

}//MainActivity