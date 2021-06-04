package com.asolec.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.rg_01);
        radioGroup.setOnCheckedChangeListener(checkedChangeListener);


    }//OnCreate

    RadioGroup.OnCheckedChangeListener checkedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            String str = "";
            RadioButton radioButton = findViewById(checkedId); // 체크된 버튼 설정
            str = radioButton.getText().toString(); //text 값을 가져옴
            Toast.makeText(MainActivity.this, str + " is selected", Toast.LENGTH_SHORT).show();
        }
    };
}