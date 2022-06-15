package com.aoslec.atsumori.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aoslec.atsumori.Bean.MoriList;
import com.aoslec.atsumori.R;

import java.util.ArrayList;

public class MoriListAdapter extends BaseAdapter {
    private Context mContext = null;
    private int layout = 0;
    private ArrayList<MoriList> data = null;
    private LayoutInflater inflater = null;

    public MoriListAdapter(Context mContext, int layout, ArrayList<MoriList> data) {
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
        return data.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //1줄씩 생성하여 출력
        convertView = inflater.inflate(this.layout, parent, false);
//        ImageView img_profile = convertView.findViewById(R.id.list_img);
        TextView tv_name = convertView.findViewById(R.id.list_tv_name);
        TextView tv_gender = convertView.findViewById(R.id.list_tv_gender);
        TextView tv_chara = convertView.findViewById(R.id.list_tv_chara);
        TextView tv_birth = convertView.findViewById(R.id.list_tv_birth);

//        img_profile.setImageResource(data.get(position).getProfile());
        tv_name.setText(data.get(position).getName());
        tv_gender.setText(data.get(position).getGender());
        tv_chara.setText(data.get(position).getChara());
        tv_birth.setText(data.get(position).getBirth());


        return convertView;
    }
}
