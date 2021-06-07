package com.asolec.practicelayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Tab5Fragment_text extends Fragment {

    TextView textView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab5_text, container, false);

        //TextView 연결
        textView = view.findViewById(R.id.f5_text);
        return view;
    }

    public void  changedTextProperties(int fontSize, String str){
        textView.setTextSize(fontSize);
        textView.setText(str);
        Log.v("Message","changedTextProperties fontsize : " + fontSize + " text : " + str);
    }

}