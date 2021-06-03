package com.asolec.fruit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btnApple, btnOrange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.TV01);
        btnApple = findViewById(R.id.btnApple);
        btnOrange = findViewById(R.id.btnOrange);

        btnApple.setOnClickListener(onClickListener);
        btnOrange.setOnClickListener(onClickListener);

    }//onCreate

    //method
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strText;
            TextView textView;
            textView = findViewById(R.id.TV01);
            switch(v.getId()){
                case R.id.btnApple:
                    strText = "APPLE";
                    textView.setText(strText);
                    break;
                case R.id.btnOrange:
                    textView.setText("ORANGE");
                    break;
            }
        }
    };


}