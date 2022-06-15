package com.aoslec.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    //Activity 생명 주기
    @Override // AppCompatActivity에 기능을 추가하기 위해 상속
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("Message","onCreate"); // system.out.print와 같음
        //onCreate 생성
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        Log.v("Message","onStart");
        //onStart Activity 실행
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.v("Message", "onResume");
        //onResume Activity 활성화가 되어있는 상태
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.v("Message","onPause");
        //onPause Activity 뒤로가기 눌렀을 때 + 실행되어 있으나 사용하고 있지 않을 때
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.v("Message","onStop");
        //onStop Activity가 실행되어 있으나 사용하고 있지 않을 때
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("Message","onDestroy");
        //onDestroy Activity가 메모리에서 제거 될 때
        super.onDestroy();
    }
}