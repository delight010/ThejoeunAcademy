package com.asolec.listener_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout = null;
    TextView textView;
    Button button;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linerlayout1);
        textView = findViewById(R.id.tv01);
        button = findViewById(R.id.btn01);
        imageView = findViewById(R.id.iv01);

        textView.setOnTouchListener(onTouchListener);


    }//onCreate

    //method
    //touch
    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            TextView textView;
            textView = findViewById(R.id.tv01);
            if(textView.getVisibility()==View.INVISIBLE){
                textView.setVisibility(View.VISIBLE);
            }else{
                textView.setVisibility(View.INVISIBLE);
            }
            Toast.makeText(MainActivity.this, "TextView Touch",Toast.LENGTH_SHORT).show();

            return true;
        }
    };

    //long
    

}