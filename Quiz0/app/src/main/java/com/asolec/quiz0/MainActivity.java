package com.asolec.quiz0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { // 클래스 상속

    //Field
    Button btn_red1, btn_green1, btn_blue1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {// onCreate = main 함수
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // display, res 폴더-layout폴더-activity_main.wml
        // Res.layout.activity_main

        btn_red1 = findViewById(R.id.btn_red);
        // View(activity_main) 파일의 id가 btn_red와 연결
        btn_green1 = findViewById(R.id.btn_green);
        btn_blue1 = findViewById(R.id.btn_blue);


        btn_red1.setOnClickListener(onClickListener); //리스너(대기중)
        btn_green1.setOnClickListener(onClickListener);
        btn_blue1.setOnClickListener(onClickListener);
    }

    //메소드
       View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colorString = "";
                switch (v.getId()){ // button id값에 따라
                    case R.id.btn_red:
                        colorString = "빨간색";
                        break;
                    case R.id.btn_green:
                        colorString = "초록색";
                        break;
                    case R.id.btn_blue:
                        colorString = "파란색";
                        break;
                }
                Toast.makeText(MainActivity.this,  colorString + " 버튼을 눌렀습니다", Toast.LENGTH_SHORT).show();
            }
        };





        //
//        btn_red.setOnClickListener(new View.OnClickListener() {
//            //버튼을 클릭했을 때 실행하는 이벤트
//            @Override
//            public void onClick(View v) {//메소드
//                Toast.makeText(MainActivity.this, "빨간색 버튼을 눌렀습니다", Toast.LENGTH_SHORT).show();
//                //context:위치, 상태
//                //text:출력할 텍스트
//                //duration:메세지를 표시하는 시간
//                    // LENGTH_SHORT :약 2초
//                //뒤에 .show(); 붙이는 거 잊지 말 것
//            }
//        });
//
//        btn_green.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "초록색 버튼을 눌렀습니다", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        btn_blue.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"파란색 버튼을 눌렀습니다", Toast.LENGTH_SHORT).show();
//            }
//        });
   }
