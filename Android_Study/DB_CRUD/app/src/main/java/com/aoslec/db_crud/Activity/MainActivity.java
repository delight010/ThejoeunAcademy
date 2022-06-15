package com.aoslec.db_crud.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aoslec.db_crud.R;

public class MainActivity extends AppCompatActivity {

    EditText edtIP;
    Button insertBtn, updateBtn, deleteBtn, selectAllBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListener(); // addListener 실행
    }

    private void addListener(){
        edtIP = findViewById(R.id.edt_ip);
        insertBtn = findViewById(R.id.btn_insert);
        updateBtn = findViewById(R.id.btn_update);
        deleteBtn = findViewById(R.id.btn_delete);
        selectAllBtn = findViewById(R.id.btn_selectA);

        insertBtn.setOnClickListener(onClickListener);
        updateBtn.setOnClickListener(onClickListener);
        deleteBtn.setOnClickListener(onClickListener);
        selectAllBtn.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String tempIp = edtIP.getText().toString();
            Intent intent = null;

            switch (v.getId()){
                case R.id.btn_insert:
                    intent = new Intent(MainActivity.this, InsertActivity.class);
                    //MainActivity -> InsertActivity 좌표 지정
                    intent.putExtra("macIP", tempIp);
                    startActivity(intent); // 이동
                    break;
                case R.id.btn_update:
                    intent = new Intent(MainActivity.this, SelectAllActivity.class);
                    intent.putExtra("macIP", tempIp);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "검색 후 선택을 짧게 누르면 수정화면으로 이동합니다.", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_delete:
                    intent = new Intent(MainActivity.this, SelectAllActivity.class);
                    intent.putExtra("macIP", tempIp);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "검색 후 선택을 길게 누르면 삭제화면으로 이동합니다.", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_selectA:
                    intent = new Intent(MainActivity.this, SelectAllActivity.class);
                    //InsertActivity로 이동
                    intent.putExtra("macIP", tempIp);
                    startActivity(intent);
                    break;

            }
        }
    };

}//MainActivity