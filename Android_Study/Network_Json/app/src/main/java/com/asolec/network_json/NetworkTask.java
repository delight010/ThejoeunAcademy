package com.asolec.network_json;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class NetworkTask extends AsyncTask<Integer, String, Object> {

    Context context = null;
    String mAddr = null;
    ProgressDialog progressDialog = null;
    ArrayList<JsonMember> members;

    public NetworkTask(Context context, String mAddr){
        this.context = context;
        this.mAddr = mAddr;
        this.members = new ArrayList<JsonMember>();
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Dialog"); //title 설정
        progressDialog.setMessage("down ...");
        progressDialog.show(); // 모양 실행
    }

    @Override
    protected void onProgressUpdate(String... values) { // 업데이트
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Object o) { // 끝났다는 신호
        super.onPostExecute(o);
        progressDialog.dismiss(); // progressDialog 없앰
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected Object doInBackground(Integer... integers) { // 여러개의 값 가능
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try{
            URL url = new URL(mAddr);
            HttpURLConnection httpURLConnection  = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000); // 연결대기시간


            if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                //HttpURLConnection.HTTP_OK 연결됬을 시,
                inputStream = httpURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);

                while (true){ // 무조건 반복
                    String strLine = bufferedReader.readLine(); // 1줄씩 읽음
                    if(strLine == null) break; // 읽을 것이 없을 시 break;
                    stringBuffer.append(strLine + "\n");

                }
                parser(stringBuffer.toString()); // String 으로 받음
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader != null) bufferedReader.close();
                if(inputStreamReader != null) inputStream.close();
                if(inputStream !=null) inputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return members;
    }

    private void parser(String str){
        try {
            JSONObject jsonObject = new JSONObject(str);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("members_info"));
            members.clear(); // 기존 arrayList를 지움

            //배열 작업(데이터 넣기)
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i); // i번째를 받아옴
                String name = jsonObject1.getString("name");
                int age = jsonObject1.getInt("age");


                ArrayList<String> hobbies = new ArrayList<String >();
                JSONArray jsonArray1 = jsonObject1.getJSONArray("hobbies");
                for(int j=0; j<jsonArray1.length(); j++){
                    String hobby = jsonArray1.getString(j);
                    hobbies.add(hobby);
                }

                JSONObject jsonObject2 = jsonObject1.getJSONObject("info");
                int no = jsonObject2.getInt("no");
                String id = jsonObject2.getString("id");
                String pw = jsonObject2.getString("pw");

                JsonMember member = new JsonMember(name, age, hobbies, no, id, pw);
                members.add(member);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }




}//
