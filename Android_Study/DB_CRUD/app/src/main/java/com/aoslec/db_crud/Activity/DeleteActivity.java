package com.aoslec.db_crud.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aoslec.db_crud.NetworkTask.NetworkTask;
import com.aoslec.db_crud.R;

public class DeleteActivity extends AppCompatActivity {

    //변수
    String urlAddr = null;
    String scode, sname, sdept, sphone, macIP;

    //화면 부분
    EditText ecode, ename, edept, ephone;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        //intent 전송값 가져오기
        Intent intent = getIntent();
        macIP = intent.getStringExtra("macIP");

        scode = intent.getStringExtra("code");
        sname = intent.getStringExtra("name");
        sdept = intent.getStringExtra("dept");
        sphone = intent.getStringExtra("phone");

        urlAddr = "http://" + macIP + ":8080/test/studentDeleteReturn.jsp?";
        //주소 끝 물음표(?) 유의

        ecode = findViewById(R.id.delete_code);
        ename = findViewById(R.id.delete_name);
        edept = findViewById(R.id.delete_dept);
        ephone = findViewById(R.id.delete_phone);

        //textView 세팅
        ecode.setText(scode);
        ename.setText(sname);
        edept.setText(sdept);
        ephone.setText(sphone);

        btnDelete = findViewById(R.id.delete_btn);
        btnDelete.setOnClickListener(onClickListener);

    }

    @Override
    protected void onResume() {
        super.onResume();
        connectInsertData(); // DB를 계속해서 새로 불러올 수 있도록 쓰임(새로고침)
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            scode = ecode.getText().toString();
            //url완성해야함
            urlAddr = urlAddr + "code=" + scode;
            Log.v("Status", "DELETE " + scode );

            String result = connectInsertData();
            if(result.equals("1")){
                // 정상인 경우 ( 1만 정상이라는 것은 jsp 에서 판단 할 수 있도록 만들 예정임. )
                Toast.makeText(DeleteActivity.this, scode+" 내역이 삭제되었습니다", Toast.LENGTH_SHORT).show();
            }else /*에러걸렸으면*/ {
                Toast.makeText(DeleteActivity.this, scode+"내역 삭제가 실패되었습니다.",  Toast.LENGTH_SHORT).show();
            }
            // back 버튼을 누른 것과 동일한 역할 (= 입력 다했으니 메인으로 간다)
            finish(); // back 버튼으로 가느 것
        }
    };

    private String connectInsertData(){
        String result = null;
        try{
            NetworkTask networkTask = new NetworkTask(DeleteActivity.this, urlAddr, "delete");
            Object obj = networkTask.execute().get();
            result = (String) obj;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }



}///