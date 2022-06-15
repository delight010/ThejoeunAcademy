package com.aoslec.db_crud.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.aoslec.db_crud.Adapter.StudentAdapter;
import com.aoslec.db_crud.Bean.Student;
import com.aoslec.db_crud.NetworkTask.NetworkTask;
import com.aoslec.db_crud.R;

import java.util.ArrayList;

public class SelectAllActivity extends AppCompatActivity {

    String urlAddr = null;
    ArrayList<Student> members;
    StudentAdapter adapter;
    ListView listView;
    String macIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        listView = findViewById(R.id.lv_student);

        Intent intent = getIntent();
        macIP = intent.getStringExtra("macIP");
        urlAddr = "http://" + macIP + ":8080/test/student_query_all.jsp";
        //검색을 하려면 jsp뒤에 ?검색어=검색값을 붙여줘야함
    }

    @Override
    protected void onResume() {
        super.onResume();
        connectGetdata(); // DB를 계속해서 새로 불러올 수 있도록 쓰임(새로고침)
    }

    private void connectGetdata() {
        try {
            NetworkTask networkTask = new NetworkTask(SelectAllActivity.this, urlAddr, "select");
            Object obj = networkTask.execute().get();
            //jsp에서 받아온 내용을 -> arrayList에 추가
            members = (ArrayList<Student>) obj;

            adapter = new StudentAdapter(SelectAllActivity.this, R.layout.student_layout, members);
            //1줄씩 넣어줌(count만큼)
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(onItemClickListener); // 한번 클릭(수정)
            listView.setOnItemLongClickListener(onItemLongClickListener); // 길게 누르기(삭제)

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        Intent intent = null;

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            intent = new Intent(SelectAllActivity.this, UpdateActivity.class);
            intent.putExtra("code", members.get(position).getCode());
            intent.putExtra("name", members.get(position).getName());
            intent.putExtra("dept", members.get(position).getDept());
            intent.putExtra("phone", members.get(position).getPhone());
            intent.putExtra("macIP", macIP);
            startActivity(intent);
        }
    };


    AdapterView.OnItemLongClickListener onItemLongClickListener = new AdapterView.OnItemLongClickListener() {
        Intent intent = null;

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            intent = new Intent(SelectAllActivity.this, DeleteActivity.class);
            intent.putExtra("code", members.get(position).getCode());
            intent.putExtra("name", members.get(position).getName());
            intent.putExtra("dept", members.get(position).getDept());
            intent.putExtra("phone", members.get(position).getPhone());
            intent.putExtra("macIP", macIP);
            startActivity(intent);

            return false;
        }
    };



}//