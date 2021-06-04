package com.aoslec.selectdialog1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int mSelect = 0;
    boolean[] mSelectMulti = {false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.call);

        //체크박스 + 리스트
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("음식을 선택하세요")
                        .setIcon(R.mipmap.ic_launcher)
                        //체크박스
                        .setMultiChoiceItems(R.array.foods, mSelectMulti,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        mSelectMulti[which] = isChecked;
                                    }
                                }
                        )
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String[] foods = getResources().getStringArray(R.array.foods);
                                TextView textView = findViewById(R.id.text);
                                String result = "선택한 음식 : ";
                                for(int i=0; i<mSelectMulti.length; i++){
                                    if(mSelectMulti[i]){
                                        result += foods[i] + " / ";
                                    }
                                }
                                textView.setText(result);
                            }
                        })
                        .setNegativeButton("취소",null)
                        .show();
            }
        });

        //라디오 버튼 + 리스트
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("음식을 선택하세요")
//                        .setIcon(R.mipmap.ic_launcher)
//                        //라디오 버튼 추가
//                        .setSingleChoiceItems(R.array.foods, mSelect,
//                                new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        mSelect = which; // 번호
//                                    }
//                                }
//                        )
//                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                String[] foods = getResources().getStringArray(R.array.foods);
//                                TextView textView = findViewById(R.id.text);
//                                textView.setText("선택한 음식 : " + foods[mSelect]); // alert에서 가져옴
//                            }
//                        })
//                        .setNegativeButton("취소",null)
//                        .show();
//            }
//        });

        //단순 리스트
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("음식을 선택하세요")
//                        .setIcon(R.mipmap.ic_launcher)
                            //리스트 추가
//                        .setItems(R.array.foods,
//                                new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        String[] foods = getResources().getStringArray(R.array.foods);
//                                        TextView textView = findViewById(R.id.text);
//                                        textView.setText("선택한 음식 : " + foods[which]);
//                                    }
//                                }
//                        )
//                        .setNegativeButton("취소", null)
//                        .show();
//            }
//        });
    }
}


