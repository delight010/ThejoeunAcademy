package com.aoslec.json_student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    final static String LogMessage = "Message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parser();
    }

    private void parser(){
        Log.v(LogMessage,"parser()");
        InputStream inputStream = getResources().openRawResource(R.raw.jsonstudent); // file connecting
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuffer stringBuffer = new StringBuffer(); // arrayList와 비슷함
        String line = null;

        try{
            while((line = bufferedReader.readLine())!=null){
                stringBuffer.append(line); //한줄씩 추가
            }
            Log.v(LogMessage,"String Buffer : " + stringBuffer.toString());


            //Json 시작
            JSONObject jsonObject = new JSONObject(stringBuffer.toString());
            JSONArray jsonArray = new JSONArray(jsonObject.getString("students_info"));
            // json의 내용 주의
            //대괄호를 구분하여 확인함(1세트, 2세트...)
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject1 = (JSONObject)jsonArray.get(i);
                String code = jsonObject1.getString("code");
                Log.v(LogMessage,"code : " + code);

                String name = jsonObject1.getString("name");
                Log.v(LogMessage,"name : " + name);

                String dept = jsonObject1.getString("dept");
                Log.v(LogMessage,"dept : " + dept);

                String phone = jsonObject1.getString("phone");
                Log.v(LogMessage,"phone : " + phone);

            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(inputStream != null) inputStream.close(); //
                if(inputStreamReader !=null) inputStreamReader.close();//
                if(bufferedReader!=null) bufferedReader.close();//
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }



}