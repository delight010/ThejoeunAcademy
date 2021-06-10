package com.aoslec.db_crud.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aoslec.db_crud.NetworkTask.NetworkTask;
import com.aoslec.db_crud.R;

public class UpdateActivity extends AppCompatActivity {

    //변수
    String urlAddr = null;
    String scode, sname, sdept, sphone, macIP;

    //화면 부분
    EditText ecode, ename, edept, ephone;
    Button btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent intent = getIntent();
        macIP = intent.getStringExtra("macIP");
        urlAddr = "http://" + macIP + ":8080/test/studentUpdateReturn.jsp?";
        //주소 끝 물음표(?) 유의

        ecode = findViewById(R.id.update_code);
        ename = findViewById(R.id.update_name);
        edept = findViewById(R.id.update_dept);
        ephone = findViewById(R.id.update_phone);

        //입력 시 자릿수 제한
        ecode.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        ename.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        edept.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
        ephone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});

        ecode.setText(scode);
        ename.setText(sname);
        edept.setText(sdept);
        ephone.setText(sphone);

        btnInsert = findViewById(R.id.btn_update);
        btnInsert.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            scode = ecode.getText().toString();
            sname = ename.getText().toString();
            sdept = edept.getText().toString();
            sphone = ephone.getText().toString();
            //url완성해야함
            urlAddr = urlAddr + "code=" + scode + "&name=" + sname + "&dept=" + sdept + "&phone=" + sphone;
            String result = connectInsertData();
            if(result.equals("1")){
                // 정상인 경우 ( 1만 정상이라는 것은 jsp 에서 판단 할 수 있도록 만들 예정임. )
                Toast.makeText(UpdateActivity.this, scode+"가 수정되었습니다", Toast.LENGTH_SHORT).show();
            }else /*에러걸렸으면*/ {
                Toast.makeText(UpdateActivity.this, "입력이 실패되었습니다.",  Toast.LENGTH_SHORT).show();
            }
            // back 버튼을 누른 것과 동일한 역할 (= 입력 다했으니 메인으로 간다)
            finish(); // back 버튼으로 가느 것
        }
    };

    private String connectInsertData(){
        String result = null;
        try{
            NetworkTask networkTask = new NetworkTask(UpdateActivity.this, urlAddr, "insert");
            Object obj = networkTask.execute().get();
            result = (String) obj;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}