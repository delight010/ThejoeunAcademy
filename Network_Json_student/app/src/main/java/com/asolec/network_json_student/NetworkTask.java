package com.asolec.network_json_student;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class NetworkTask extends AsyncTask<Integer, String , Object> {

    Context context = null;
    String mAddr = null;
    ProgressDialog progressDialog = null;
    ArrayList<JsonStudent> students;
    String log = "MESSAGE ";


    public NetworkTask(Context context, String mAddr){
        this.context = context;
        this.mAddr = mAddr;
        this.students = new ArrayList<JsonStudent>();
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Dialog");//title 설정
        progressDialog.setMessage("down ...");
        progressDialog.show(); // 모양 실행
    }

    @Override
    protected void onPostExecute(Object o) { // 끝났다는 신호
        super.onPostExecute(o);
        progressDialog.dismiss(); // progressDialog 없앰
    }

    @Override
    protected Object doInBackground(Integer... integers) { // 여러개의 값 가능
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            URL url = new URL(mAddr);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000); // 연결대기시간

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                //HttpURLConnection.HTTP_OK 연결됬을 시,
                inputStream = httpURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);

                while (true){ //무조건 반복
                    String strLine = bufferedReader.readLine(); // 1줄씩 읽음
                     if(strLine == null) break; // 읽을 것이 없을 시 break;
                    stringBuffer.append(strLine + "\n");
                }
                Log.v(log, "NetworkTask : " + stringBuffer.toString());
                parser(stringBuffer.toString()); // String 으로 받음
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(bufferedReader !=null) bufferedReader.close();
                if(inputStreamReader !=null) inputStreamReader.close();
                if(inputStream != null) inputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return students; // arrayList에 추가
    }

    private void parser(String str){
        try {
            JSONObject jsonObject = new JSONObject(str);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("students_info"));
            students.clear(); // 기존 arrayList를 지움

            //배열 작업(데이터 넣기)
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i); // i번째를 받아옴
                String code = jsonObject1.getString("code");
                Log.v(log, "NetworkTask JSONArray code : " + code);
                String name = jsonObject1.getString("name");
                Log.v(log, "NetworkTask JSONArray code : " + name);
                String dept = jsonObject1.getString("dept");
                Log.v(log, "NetworkTask JSONArray code : " + dept);
                String phone = jsonObject1.getString("phone");
                Log.v(log, "NetworkTask JSONArray code : " + phone);

                JsonStudent student = new JsonStudent(code, name, dept, phone); // 1줄씩 넣기
                students.add(student);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }




}
