package com.aoslec.frame_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        // id가 button인 버튼과 연결
        image = findViewById(R.id.image1);

        //버튼을 클릭하면
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // v는 변수
                if(image.getVisibility() == v.VISIBLE){ //v가 visible 상태이면(보이면)
                    image.setVisibility(v.INVISIBLE); // invisible 상태로 (안보이는 상태로)
                }else{
                    image.setVisibility(v.VISIBLE);
                }
            }
        });

    }
}