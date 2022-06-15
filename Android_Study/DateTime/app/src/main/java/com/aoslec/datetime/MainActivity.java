package com.aoslec.datetime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calView;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;

    int selectYear, seletctMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("시간 예약");

        // 버튼
        btnStart = findViewById(R.id.btnStart);
        btnEnd = findViewById(R.id.btnEnd);

        // 크로노미터
        chrono = findViewById(R.id.chronometer1);

        // 라디오버튼 2개
        rdoCal = findViewById(R.id.rdoCal);
        rdoTime = findViewById(R.id.rdoTime);

        // FrameLayout의 2개의 위젯
        tPicker = findViewById(R.id.timePicker1);
        calView = findViewById(R.id.calendarView1);

        // TextView중에서 년, 월, 시, 분
        tvYear = findViewById(R.id.tvYear);
        tvMonth = findViewById(R.id.tvMonth);
        tvDay = findViewById(R.id.tvDate);
        tvHour = findViewById(R.id.tvHour);
        tvMinute = findViewById(R.id.tvMinute);

        // 처음에는 2개를 안보이게 설정
        tPicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        // 라디오 버튼 클릭
        // 날짜 클릭
        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            }
        });

        // 시간 클릭
        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.VISIBLE);
                calView.setVisibility(View.INVISIBLE);
            }
        });


        // 타이머 설정
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                //elapsedRealtime는 현재시간 기준
                chrono.start(); // 시작
                chrono.setTextColor(Color.RED); // 시간 글자 색깔 변경
            }
        });

        // 캘린더 설정
        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                seletctMonth = month + 1; // month는 0부터 시작이므로 +1
                selectDay = dayOfMonth;
            }
        });

        // 예약완료 버튼 클릭
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.stop(); // 타이머 중지
                chrono.setTextColor(Color.BLUE); // 시간 글자 색깔 변경

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(seletctMonth));
                tvDay.setText(Integer.toString(selectDay));

                // Picker에서 선택한 시간과 분
                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));

            }
        });

    }//onCreate


}//MainActivity