package com.aoslec.recyclercardtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView; //
    RecyclerView.LayoutManager layoutManager; // layout을 연결(view 연결)
    RecyclerView.Adapter adapter; // view에 보여줄 data 설정(+연결)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this); // 리스트 형태
//        layoutManager = new GridLayoutManager(this,2); // 격자무늬
        recyclerView.setLayoutManager(layoutManager);   // layout을 잡음

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }



}