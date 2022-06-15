package com.aoslec.db_crud.NetworkTask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.aoslec.db_crud.Bean.Student;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class NetworkTask extends AsyncTask<Integer, String, Object> {

    final static String TAG = "Status";

    Context context = null;
    String mAddr = null;
    ProgressDialog progressDialog = null;
    ArrayList<Student> members;

    //Network Task를 검색, 입력, 수정, 삭제 구분없이 하나로 사용하기 위해 생성자 변수 추가.
    String where = null;

    public NetworkTask(Context context, String mAddr, String where) {
        this.context = context;
        this.mAddr = mAddr;
        this.members = new ArrayList<Student>();
        this.where = where;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Dialog");
        progressDialog.setMessage("Get....");
        progressDialog.show();
    }


    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        progressDialog.dismiss();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        progressDialog.dismiss();
    }

    @Override
    protected Object doInBackground(Integer... integers) {
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        String result = null;

        try{
            URL url = new URL(mAddr);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000);
            if(httpURLConnection.getResponseCode() == httpURLConnection.HTTP_OK){
                inputStream = httpURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);
                while(true){
                    String strline = bufferedReader.readLine();
                    if(strline == null) break;
                    stringBuffer.append(strline + "\n");
                }
                if(where.equals("select")){
                    parserSelect(stringBuffer.toString());
                    Log.v(TAG, "Networktask : doInBackground parser Select (execute)");
                }else {
                    result = parserAction(stringBuffer.toString());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(bufferedReader != null) bufferedReader.close();
                if(inputStream != null) inputStream.close();
                if(inputStreamReader != null) inputStreamReader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(where.equals("select")){
            return members; //arrayList
        }else {
            return result; // JSON
        }
    }


    //List에 넣을 Data를 불러오기 위한 NetworkTesk
    private String parserAction(String str) { // 입력, 수정, 삭제
        String returnValue = null;
        try {
            JSONObject jsonObject = new JSONObject(str); // 중괄호 시작부터 불러옴
            returnValue = jsonObject.getString("result");// result에 해당하는 값을 불러옴

        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    private void parserSelect(String str) { // 검색만 가능
        try {
            JSONObject jsonObject = new JSONObject(str);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("students_info"));
            Log.v(TAG, "NetworkTask : parserSelect() students_info (execute)");
            members.clear(); // data가 있을 경우 지우고 다시 재구성

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                String code = jsonObject1.getString("code");
                String name = jsonObject1.getString("name");
                String dept = jsonObject1.getString("dept");
                String phone = jsonObject1.getString("phone");
                Log.v(TAG,code + ", " + name + ", " + dept + ", " + phone);

                Student member = new Student(code, name, dept, phone);
                members.add(member);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}//NetworkTask
