package com.asolec.network_json_student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String urlAddr = "http://203.234.110.70:8080/test/students.json";
    Button button;
    ListView listView;
    ArrayList<JsonStudent> students;
    StudentAdapter adapter;
    String log = "MESSAGE";

    //----RecyclerView-----
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager; // layout을 연결(view 연결)
    RecyclerView.Adapter adapterRecycler;
    //-----------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_network_con);
//        listView = findViewById(R.id.lv_student);

        //----RecyclerView-----
        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        button.setOnClickListener(onClickListener);
    }


    final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_network_con:
                    Log.v(log, "Button Click");
                        try {
                            NetworkTask networkTask = new NetworkTask(MainActivity.this, urlAddr);
                            //context:보여주는 화면,  주소;
                            Object obj = networkTask.execute().get();
                            students = (ArrayList<JsonStudent>) obj;
                            Log.v(log, "ArrayList.obj");
//                             //------ListView-----
//                            adapter = new StudentAdapter(MainActivity.this, R.layout.custom_layout, students);
//                            Log.v(log, "MainActivity adapter");
//                            listView.setAdapter(adapter);
//                            Log.v(log, "MainActivity listview");

                            //----RecyclerView-----
                            adapterRecycler = new RecyclerAdapter(MainActivity.this, students);
                            recyclerView.setAdapter(adapterRecycler);
                            Log.v(log, "MainActivity recyclerView");

                            button.setText("Students List");

                        }catch (Exception e){
                            e.printStackTrace();
                        }
            }
        }
    };





}