package com.asolec.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1, cb2, cb3, cb4;
    String[] str = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = findViewById(R.id.cb_01);
        cb2 = findViewById(R.id.cb_02);
        cb3 = findViewById(R.id.cb_03);
        cb4 = findViewById(R.id.cb_04);

        //체크여부가 바뀔 때
        cb1.setOnCheckedChangeListener(checkChangeListener);
        cb2.setOnCheckedChangeListener(checkChangeListener);
        cb3.setOnCheckedChangeListener(checkChangeListener);
        cb4.setOnCheckedChangeListener(checkChangeListener);

    }//Oncreate


    //method
    CompoundButton.OnCheckedChangeListener checkChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // type 변수명, 상태
            String chk = "";
            String checked = "";

                switch (buttonView.getId()) {
                    case R.id.cb_01:
                        if (isChecked == true) {
                            chk += "운동 ";
                        }
                        break;
                    case R.id.cb_02:
                        if (isChecked == true) {
                            chk  += "요리 ";
                        }
                        break;
                    case R.id.cb_03:
                        if (isChecked == true) {
                            chk += "독서 ";
                        }
                        break;
                    case R.id.cb_04:
                        if (isChecked == true) {
                            chk += "여행 ";
                        }
                        break;
                }


            Toast.makeText(MainActivity.this, chk + " is checked" , Toast.LENGTH_SHORT).show();

            }
        };



    };
