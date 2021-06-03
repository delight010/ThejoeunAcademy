package com.asolec.bmicalc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import static java.lang.Double.MAX_EXPONENT;
import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {

    LinearLayout resultLayout;

    RadioGroup radioGroup;
    RadioButton radioButton;
    Button calcBMI;

    EditText ETtall, ETkg;
    TextView resultBMI;

    double bmi, tall, kg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("BMI계산기"); //title 변경

        //변수 & id값 연결
        resultLayout = findViewById(R.id.resultLayout);
        calcBMI = findViewById(R.id.btnBMI);
        resultLayout = findViewById(R.id.resultLayout);
        ETtall = findViewById(R.id.ETtall);
        ETkg = findViewById(R.id.ETkg);
        resultBMI = findViewById(R.id.resultBMI);

        Gallery gallery1 = findViewById(R.id.gallery1);
        GridView gv = findViewById(R.id.gridView1);

        MyGridAdapter gridAdapter = new MyGridAdapter(this); // 메소드 생성
        gv.setAdapter(gridAdapter);// adapter 연결

        MyGalleryAdapter myGalleryAdapter = new MyGalleryAdapter(this); //메소드 생성
        gallery1.setAdapter(myGalleryAdapter); //adapter 연결


        //계산하기 버튼 클릭
        calcBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tall = parseDouble(ETtall.getText().toString())/100;
                kg = parseDouble(ETkg.getText().toString());
                bmi = (kg / (tall * tall))/2.0 ;
                resultBMI.setText("당신의 BMI지수는 " + Double.toString(bmi) + " 입니다.");
                resultLayout.setVisibility(View.VISIBLE); // 결과창 보여주기
            }
        });



    }//onCreate

    //----------------------------------------------------------------------------
    //method
    //MyGridAdapter
    public class MyGridAdapter extends BaseAdapter {
        Context context;
        //image는 int
        int[] img = {R.drawable.e01, R.drawable.e02, R.drawable.e03, R.drawable.e04, R.drawable.e05, R.drawable.e06};


        public MyGridAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        //img 1개씩
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(200,300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);//중앙에 배치
            imageView.setPadding(5,5,5,5);

            imageView.setImageResource(img[position]);// data 갯수만큼 실행

            //클릭하면
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //view 전환
                    View dialogView = View.inflate(MainActivity.this, R.layout.dialog, null);
                    //alert 틀 생성
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = dialogView.findViewById(R.id.ivPoster);//변수연결
                    ivPoster.setImageResource(img[position]);

                    dlg.setTitle("그림");//title
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);

                    //null 대신 ClickListener를 쓸 수 있음
                    dlg.show();
                }
            });
            return imageView;
        }
    }//

    //----------------------------------------------------------------------------
    //MyGalleryAdapter
    public class MyGalleryAdapter extends BaseAdapter{
        Context context;
        int[] img = {R.drawable.e01, R.drawable.e02, R.drawable.e03, R.drawable.e04, R.drawable.e05, R.drawable.e06};

        public MyGalleryAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        //img 1개씩
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new Gallery.LayoutParams(200,300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);//중앙에 배치
            imageView.setPadding(5,5,5,5);

            imageView.setImageResource(img[position]);//data 갯수만큼 실행

            //img 터치하면
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView ivIMG = findViewById(R.id.ivIMG);
                    ivIMG.setScaleType(ImageView.ScaleType.FIT_CENTER);//중앙 배치
                    ivIMG.setImageResource(img[position]);

                    return false;
                }
            });

            return imageView;
        }
    }



}