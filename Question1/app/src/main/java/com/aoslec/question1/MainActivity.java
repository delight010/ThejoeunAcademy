package com.aoslec.question1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int a = 3;
    int b = 4;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.call);
        button.setOnClickListener(new Button.OnClickListener() {
            // View 대신 Button을 써도 됨
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("질문")
                        .setMessage("어떤 연산을 하시겠습니까?")
                        .setCancelable(false) // 버튼을 눌러야만 창이 닫아짐
                        .setPositiveButton("덧셈",mClick)
                        .setNegativeButton("곱셈",mClick)
                        .show();
            }
        });
    }//onCreate

    //method
    //dialog의 onClickListener 쓸 것
    DialogInterface.OnClickListener mClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_POSITIVE){
                result = a + b;
            }else{
                result = a * b;
            }
            TextView textView = findViewById(R.id.result);
            textView.setText("연산 결과 : " + result);
            Toast.makeText(MainActivity.this, "연산을 완료했습니다", Toast.LENGTH_SHORT).show();
        }
    };


}