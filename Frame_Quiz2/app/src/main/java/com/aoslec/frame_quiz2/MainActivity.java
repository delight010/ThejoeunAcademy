package com.aoslec.frame_quiz2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button Linear1;
    Button Linear2;

    View frame1View;
    View frame2View;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Linear1 = findViewById(R.id.LINEAR1);
        Linear2 = findViewById(R.id.LINEAR2);
        LinearLayout linear1 = findViewById(R.id.frame1);
        LinearLayout linear2 = findViewById(R.id.frame2);


        //버튼을 클릭하면
        Linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear1.setVisibility(v.VISIBLE);
                linear2.setVisibility(v.INVISIBLE);
            }
        });

        Linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear1.setVisibility(v.INVISIBLE);
                linear2.setVisibility(v.VISIBLE);
            }
        });


    }
}