package com.asolec.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { // 클래스 상속

    //Field
    Button button; //


    @Override
    protected void onCreate(Bundle savedInstanceState) { // onCreate = main 함수

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // display, res 폴더-layout폴더-activity_main.wml

        button = findViewById(R.id.btnOK);
        // View(activity_main) 파일의 id가 btnOK인 것을 찾음

        button.setOnClickListener(new View.OnClickListener() {
            //버튼을 클릭했을 때 실행하는 이벤트
            @Override
            public void onClick(View v) { // 메소드
                Toast.makeText(MainActivity.this, "버튼을 누르다!", Toast.LENGTH_SHORT).show();
                //context:위치, 상태
                //text:텍스트
                //duration:메세지를 표시하는 시간
                    // LENGTH_SHORT :약 2초
            }
        });
    }
}