package com.aoslec.atsumori.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.aoslec.atsumori.R;

public class MainActivity extends AppCompatActivity {

    String edtIP = "192.168.0.133";

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager; // layout을 연결(view 연결)
    RecyclerView.Adapter adapter; // view에 보여줄 data 설정(+연결)

    Button btn_listView, btn_insert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_listView = findViewById(R.id.main_btn_listView);



        btn_listView.setOnClickListener(mOnClickListener);
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String tempIp = edtIP;
            Intent intent = null;
            switch (v.getId()){
                case R.id.main_btn_listView:
                    intent = new Intent(MainActivity.this, ListActivity.class);
                    //MainActivity -> ListActivity 이동;
//                    intent.putExtra("macIP", tempIp);
                    startActivity(intent);// 이동
                    break;
            }
        }
    };


}