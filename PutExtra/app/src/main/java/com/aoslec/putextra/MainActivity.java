package com.aoslec.putextra;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static int RValue = 0;
    TextView textView = null;
    Button button = null;
    Button button1 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv_main);
        button = findViewById(R.id.btn_main);
        button1 = findViewById(R.id.btn_main1);

        button.setOnClickListener(onClickListener);
        button1.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_main:
                    intent = new Intent(MainActivity.this, SecondActivity.class);
                    //현재 Activity -> class로 이동
                    intent.putExtra("userid","root");//변수이름:userid
                    intent.putExtra("passwd",1111);
                    startActivity(intent);//실행
                    break;
                case R.id.btn_main1:
                    intent = new Intent(MainActivity.this,ThirdActivity.class);
                    intent.putExtra("userid","admin");
                    intent.putExtra("passwd",2222);
                    startActivityForResult(intent, RValue);
                    //결과값을 받기 위해 쓰임(return값)
                default:
                    break;
            }
        }
    };

    @Override // 값을 가져오기 위해 (third에서 보내준 값)
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){ // requestCode or resultCode
            //requestCode는 Third의 값을 가져옴
            //resultCode -> case문 실행
            case MainActivity.RValue: // static으로 잡았기 때문에 사용 가능
                textView.setText("Return Value : " + data.getStringExtra("result"));
                break;
            default:
                break;
        }
    }
}