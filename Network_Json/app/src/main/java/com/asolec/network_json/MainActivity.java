package com.asolec.network_json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String urlAddr = "http://203.234.110.70:8080/test/json_members.json";
    Button button;
    ListView listView;
    ArrayList<JsonMember> members;
    MemberAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_network_con);
        listView = findViewById(R.id.lv_members);

        button.setOnClickListener(onClickListener);
    }

    final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_network_con:
                    try {
                        NetworkTask networkTask = new NetworkTask(MainActivity.this, urlAddr);
                        //context:보여주는 화면,  주소;
                        Object obj = networkTask.execute().get();
                        members = (ArrayList<JsonMember>) obj;

                        adapter = new MemberAdapter(MainActivity.this, R.layout.custom_layout, members);
                        listView.setAdapter(adapter);
                        button.setText("Results");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }
    };

}