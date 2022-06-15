package com.aoslec.table_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ETnum1, ETnum2;
    TextView textView;
    Button plus, sub, mul, div;
    Integer num1_int, num2_int;
    String result;

    //10개 숫자 버튼 배열
    Button[] numButtons = new Button[10];
    //10개 숫자 버튼의 id 값 배열
    Integer[] numBtnIDs = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2,
            R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6,
            R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("계산기"); // title명을 바꿔줌

        ETnum1 = findViewById(R.id.num1);
        ETnum2 = findViewById(R.id.num2);

        plus = findViewById(R.id.plus);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);

        textView = findViewById(R.id.textview);

        plus.setOnClickListener(mClickListener);
        sub.setOnClickListener(mClickListener);
        mul.setOnClickListener(mClickListener);
        div.setOnClickListener(mClickListener);

        //숫자 버튼 10개를 대입
        for(int i=0; i<numBtnIDs.length; i++){
            numButtons[i] = findViewById(numBtnIDs[i]);
        }

        //숫자 버튼 10개에 대해서 클릭 이벤트 처리
        for(int i=0; i<numBtnIDs.length; i++){
            final int index = i; // 버튼 번호
            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 포커스가 되어 있는 에디트텍스트에 숫자 추가
                    if(ETnum1.isFocused()==true){
                        num1_int = Integer.parseInt(ETnum1.getText().toString() + numButtons[index].getText().toString());
                        ETnum1.setText(Integer.toString(num1_int));
                    }else if(ETnum2.isFocused()==true){
                        num2_int = Integer.parseInt(ETnum2.getText().toString() + numButtons[index].getText().toString());
                        ETnum2.setText(Integer.toString(num2_int));
                    }else{
                        Toast.makeText(MainActivity.this,"입력 항목부터 선택하세요",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }



    }

    //메소드
    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            num1_int = Integer.parseInt(ETnum1.getText().toString());
            num2_int = Integer.parseInt(ETnum2.getText().toString());

            switch (v.getId()){
                case R.id.plus:
                    result = Integer.toString(num1_int+num2_int);
                    break;
                case R.id.sub:
                    result = Integer.toString(num1_int-num2_int);
                    break;
                case R.id.mul:
                    result = Integer.toString(num1_int*num2_int);
                    break;
                case R.id.div:
                    result = Double.toString(num1_int/(double) num2_int);
                    break;
            }
            textView.setText("계산 결과 : " + result);
        }
    };
}