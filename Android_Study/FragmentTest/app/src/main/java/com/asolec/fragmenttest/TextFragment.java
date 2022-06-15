package com.asolec.fragmenttest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TextFragment extends Fragment {

    TextView textView = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        Log.v("Message","TextFragment onCreateView start");

        //TextView 연결
        textView = view.findViewById(R.id.f2_text);
        return view;

    }

    public void  changedTextProperties(int fontSize, String str){
        textView.setTextSize(fontSize);
        textView.setText(str);
        Log.v("Message","changedTextProperties fontsize : " + fontSize + " text : " + str);
    }
}