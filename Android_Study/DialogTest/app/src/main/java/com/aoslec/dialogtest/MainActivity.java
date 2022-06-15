package com.aoslec.dialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.call);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AlertDialog.Builder bld = new AlertDialog.Builder(MainActivity.this);
//                bld.setTitle("알립니다."); // title
//                bld.setMessage("대화상자를 열었습니다."); // 내용
//                bld.setIcon(R.mipmap.ic_launcher); // icon
//                bld.show(); //출력

                //축약형으로 쓰기
                new AlertDialog.Builder(MainActivity.this)
                .setTitle("알립니다.") // title
                .setMessage("대화상자를 열었습니다.") // 내용
//              .setIcon(R.mipmap.ic_launcher); // icon
                .setIcon(R.drawable.w2) // icon
                .setCancelable(false) // 버튼을 눌러야만 창이 닫아짐
                .setPositiveButton("닫기",null) // 버튼 생성
                .show(); //출력
            }
        });
    }
}