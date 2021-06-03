package com.asolec.editabletest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edittext);
        Button btn1 = findViewById(R.id.btm_ins);
        btn1.setOnClickListener(mClicklistener);

        findViewById(R.id.btn_del).setOnClickListener(mClicklistener);
        findViewById(R.id.btn_app).setOnClickListener(mClicklistener);
        findViewById(R.id.btn_rep).setOnClickListener(mClicklistener);
        findViewById(R.id.btn_clear).setOnClickListener(mClicklistener);


    }//Oncreate

    //method
    View.OnClickListener mClicklistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Editable edit = editText.getText(); // text를 받아와서 씀
            switch (v.getId()){
                case R.id.btm_ins: // 앞에 INS를 삽입
                    edit.insert(0,"INS");
                    break;
                case R.id.btn_del://순서 3~5 문자를 삭제
                    edit.delete(2,5);
                    break;
                case R.id.btn_app://뒤에 APP를 삽입
                    edit.append("APP");
                    break;
                case R.id.btn_rep://순서 3~5에 해당하는 문자를 REP으로 바꿈
                    edit.replace(2,5,"REP");
                    break;
                case R.id.btn_clear://전체 문자 삭제
                    edit.clear();
                    break;
            }
        }
    };


}//MainActivity