package com.aoslec.putextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    final  static int ReturnV = 1; // return할 값
    TextView textView= null;
    Button button = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        textView = findViewById(R.id.tv_third);
        button = findViewById(R.id.btn_third);

        button.setOnClickListener(onClickListener);

        Intent intent = getIntent();
        String userid = intent.getStringExtra("userid");
        int passwd = intent.getIntExtra("passwd", 0);
        textView.setText("User Id : " + userid + " / " + "Password : " + passwd);
    }//onCreate

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.putExtra("result","aaaa");
            setResult(ReturnV, intent); // MainActivity의 onActivityResult로 전송
            finish();//현재 Activity 종료
        }
    };
}