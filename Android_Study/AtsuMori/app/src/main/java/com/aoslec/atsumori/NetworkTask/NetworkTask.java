package com.aoslec.atsumori.NetworkTask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.aoslec.atsumori.Bean.MoriList;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class NetworkTask extends AsyncTask<Integer, String, Object> {
    Context context = null;
    String mAddr = null;
    ProgressDialog progressDialog= null;
    ArrayList<MoriList> members;

    //Network Task를 검색, 입력, 수정, 삭제 구분없이 하나로 사용하기 위해 생성자 변수 추가.
    String where = null;

    public NetworkTask(Context context, String mAddr, String where) {
        this.context = context;
        this.mAddr = mAddr;
        this.members = new ArrayList<MoriList>();
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
    }@Override
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

        return members; // arrayList에 추가
    }

    private void parser(String str){
        try {
            JSONObject jsonObject = new JSONObject(str);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("moriList_info"));
            members.clear(); // 기존 arrayList를 지움

            //배열 작업(데이터 넣기)
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i); // i번째를 받아옴
                int code = jsonObject1.getInt("code");
                String name = jsonObject1.getString("name");
                String gender = jsonObject1.getString("gender");
                String chara = jsonObject1.getString("chara");
                String birth = jsonObject1.getString("birth");

                MoriList member = new MoriList(code, name, gender, chara, birth); // 1줄씩 넣기
                members.add(member);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}//
