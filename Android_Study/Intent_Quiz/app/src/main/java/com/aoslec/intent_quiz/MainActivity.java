package com.aoslec.intent_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_ID = null;
    EditText et_PW = null;
    Button button = null;

    final static String userid = "aaa";
    final static String pwd = "1111";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_ID = findViewById(R.id.main_et_id);
        et_PW = findViewById(R.id.main_et_pw);
        button = findViewById(R.id.main_btn);

        button.setOnClickListener(onClickListener);

    }//onCreate

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            String getID = et_ID.getText().toString();
            String getPW = et_PW.getText().toString();

            if(getID.equals(userid) && getPW.equals(pwd)){
                intent = new Intent(MainActivity.this, SubActivity.class);
                //현재 Activity -> class로 이동
                startActivity(intent);//실행
//                et_ID.setText("");
//                et_PW.setText("");
            }else{
                Toast.makeText(MainActivity.this,"Error!",Toast.LENGTH_SHORT).show();
            }
        }
    };

}