package com.aoslec.db_crud.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aoslec.db_crud.Bean.Student;
import com.aoslec.db_crud.R;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {
    private Context mContext = null;
    private int layout = 0;
    private ArrayList<Student> data = null;
    private LayoutInflater inflater = null;

    public StudentAdapter(Context mContext, int layout, ArrayList<Student> data) {
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflater는 변함없이 이 값만 씀
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
        return position; // 위치
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //1줄씩 생성하여 출력
        convertView = inflater.inflate(this.layout, parent, false);
        TextView tv_code = convertView.findViewById(R.id.tv_code);
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_dept = convertView.findViewById(R.id.tv_dept);
        TextView tv_phone = convertView.findViewById(R.id.tv_phone);

        tv_code.setText("학번 : " + data.get(position).getCode());
        tv_name.setText("성명 : " + data.get(position).getName());
        tv_dept.setText("전공 : " + data.get(position).getDept());
        tv_phone.setText("전화번호 : " + data.get(position).getPhone());
        return convertView;
    }
}
