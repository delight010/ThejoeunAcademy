package com.asolec.recyclerview_cardview_pratice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager; // layout(view)를 연결
    RecyclerView.Adapter adapter; // view에 보여줄 data설정(+연결)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this); // listView 형태
        recyclerView.setLayoutManager(layoutManager); // layout을 잡음




    }
}