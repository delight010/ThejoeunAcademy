package com.asolec.buttonclicksize;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btnSmall, btnLarge;
    SeekBar sb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv01);
        btnSmall = findViewById(R.id.btnSmall);
        btnLarge = findViewById(R.id.btnLarge);
        sb1 = findViewById(R.id.sb1);
        int size = 15;

        btnSmall.setOnClickListener(onClickListener);
        btnLarge.setOnClickListener(onClickListener);

        sb1.setMax(50);
        sb1.setProgress(size);
        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }//onCreate

    //method
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            textView = findViewById(R.id.tv01);
            int size = (int)textView.getTextSize();
            switch (v.getId()){
                case R.id.btnSmall:
                    size --;
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,size);
                    break;
                case R.id.btnLarge:
                    size ++;
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,size);
                    break;
            }
        }
    };



}