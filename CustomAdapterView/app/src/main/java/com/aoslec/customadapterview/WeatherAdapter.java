package com.aoslec.customadapterview;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WeatherAdapter extends BaseAdapter {

    private Context mcontext = null;
    private int layout = 0;
    private ArrayList<Weather> data = null;
    private LayoutInflater inflater = null;

    //Constructor
    public WeatherAdapter(Context mcontext, int layout, ArrayList<Weather> data) {
        this.mcontext = mcontext;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getDay();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //1행씩 추가
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(this.layout, parent, false);
        }
        // 변수 - view 연결
        TextView tv_day = convertView.findViewById(R.id.tv_day);
        ImageView iv_icon = convertView.findViewById(R.id.iv_weather);
        TextView tv_comment = convertView.findViewById(R.id.tv_comment);

        //position:ArrayList의 번호
        tv_day.setText(data.get(position).getDay() + "  ");
        iv_icon.setImageResource(data.get(position).getIcon());
        tv_comment.setText(data.get(position).getComment());

        //홀수 행에만 background 색깔넣기
        if(position%2 == 1){
            convertView.setBackgroundColor(0x5000ff00);//16진수
        }else{
            convertView.setBackgroundColor(0x200ff00);
        }
        return convertView; // 1행씩 화면 출력
    }
}
