package com.aoslec.atsumori.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aoslec.atsumori.Adapter.MoriListAdapter;
import com.aoslec.atsumori.Bean.MoriList;
import com.aoslec.atsumori.NetworkTask.NetworkTask;
import com.aoslec.atsumori.R;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    String urlAddr = null;
    String macIP = "192.168.0.133";
    ArrayList<MoriList> members;
    MoriListAdapter adapter;
    TextView tv_name, tv_gender, tv_chara, tv_birth;
    Button btn_pre, btn_next;
    LinearLayout linearLayout;


    int position = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        linearLayout = findViewById(R.id.layout_listview);

//        Intent intent = getIntent();
//        urlAddr = "http://" + macIP + ":8080/test/moriList_" + position + ".jsp";

        tv_name.findViewById(R.id.list_tv_name);
        tv_gender.findViewById(R.id.list_tv_gender);
        tv_chara.findViewById(R.id.list_tv_chara);
        tv_birth.findViewById(R.id.list_tv_birth);


    }

    @Override
    protected void onResume() {
        super.onResume();
    }







}


