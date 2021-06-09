package com.asolec.network_json_student;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {

    private Context mContext = null;
    private int layout = 0;
    private ArrayList<JsonStudent> data = null;
    private LayoutInflater inflater = null;
    public String log = "MESSAGE";

    public StudentAdapter(Context context, int layout, ArrayList<JsonStudent> data) {
        this.mContext = context;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getCode();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Layout 연결
        convertView = inflater.inflate(this.layout, parent, false);
        TextView tv_code = convertView.findViewById(R.id.tv_code);
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_dept = convertView.findViewById(R.id.tv_dept);
        TextView tv_phone = convertView.findViewById(R.id.tv_phone);
        Log.v(log, "StudentAdapter Layout Connect");


        //data 연결
        tv_code.setText(data.get(position).getCode());
        tv_name.setText(data.get(position).getName());
        tv_dept.setText(data.get(position).getDept());
        tv_phone.setText(data.get(position).getPhone());

        if((position % 2) == 1){
            convertView.setBackgroundColor(0x5000ff00);
        }else {
            convertView.setBackgroundColor(0x500000ff);
        }


        return convertView; // 셀 1개씩 반환
    }
}
