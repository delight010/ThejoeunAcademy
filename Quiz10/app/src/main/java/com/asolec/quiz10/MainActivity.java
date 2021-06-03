package com.asolec.quiz10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
//    FrameLayout frameLayout;

    CheckBox checkBox;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button button;
    ImageView i01, i02, i03, imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle("좋아하는 동물 선택하기"); // title 변경
        //변수 & id값 연결
        linearLayout = findViewById(R.id.layout1);
//        frameLayout = findViewById(R.id.layout2);

        checkBox = findViewById(R.id.cb1);
        radioGroup = findViewById(R.id.rg01);
        button = findViewById(R.id.btnOK);

        imgPet = findViewById(R.id.imgPet);
        i01 = findViewById(R.id.i01); // dog
        i02 = findViewById(R.id.i02); // cat
        i03 = findViewById(R.id.i03); // rabbit

        //checkbox 체크여부에 따라
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked() == true){
                    linearLayout.setVisibility(LinearLayout.VISIBLE);
                    imgPet.setVisibility(imgPet.VISIBLE);
                }else{
                    linearLayout.setVisibility(LinearLayout.INVISIBLE);
                    imgPet.setVisibility(imgPet.INVISIBLE);
                }
            }
        });



        //선택완료 버튼 클릭
        button.setOnClickListener(new View.OnClickListener() {
            int id = radioGroup.getCheckedRadioButtonId();
            @Override
            public void onClick(View v) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    //체크된 버튼 id값에 따라
                    case R.id.rbtn1:
                        imgPet.setImageResource(R.drawable.i01);
                        break;
                    case R.id.rbtn2:
                        imgPet.setImageResource(R.drawable.i02);
                        break;
                    case R.id.rbtn3:
                        imgPet.setImageResource(R.drawable.i03);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물을 선택하세요", Toast.LENGTH_SHORT).show();
                        //getApplicationContext:현재 떠있는 어플리케이션(디스플레이)
                }

            }
        });

    }//Oncreate


}//MainActivity