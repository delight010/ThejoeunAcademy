package com.aoslec.dialog_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int num1, num2, result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.tv_result);
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("질문1")
                        .setMessage("좌변을 선택하십시오")
                        .setCancelable(false) // 버튼을 선택해야만 창이 닫아짐
                        .setNegativeButton("4", q2_Listener)
                        .setPositiveButton("3",q2_Listener)
                        .show();

                }

        });

    }//onCreate

    public DialogInterface.OnClickListener q2_Listener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which==DialogInterface.BUTTON_POSITIVE){
                num1 = 3;
            }else{
                num1 = 4;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("질문2")
                    .setMessage("우변을 선택하십시오")
                    .setCancelable(false) // 버튼을 선택해야만 창이 닫아짐
                    .setNegativeButton("6",q3_Listener)
                    .setPositiveButton("5",q3_Listener)
                    .show();
        }
    };

    public DialogInterface.OnClickListener q3_Listener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which==DialogInterface.BUTTON_POSITIVE){
                num2 = 5;
            }else{
                num2 = 6;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("질문3")
                    .setMessage("어떤 연산을 하시겠습니까?")
                    .setCancelable(false) // 버튼을 선택해야만 창이 닫아짐
                    .setNegativeButton("곱셈",q4_Listener)
                    .setPositiveButton("덧셈",q4_Listener)
                    .show();
        }
    };

    public DialogInterface.OnClickListener q4_Listener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == DialogInterface.BUTTON_POSITIVE) {
                result = num1+num2;
                textView.setText("덧셈결과 : " + result);
            } else {
                result = num1*num2;
                textView.setText("곱셈결과 : " + result);
            }
        }


    };


}