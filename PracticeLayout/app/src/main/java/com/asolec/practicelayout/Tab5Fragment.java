package com.asolec.practicelayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Tab5Fragment extends Fragment implements Tab5Fragment_ToolBar.ToolbarListener  {
    public Tab5Fragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v("Message","Tab5Fragment " );
        return inflater.inflate(R.layout.fragment_tab5, container,false);
    }


    @Override
    public void onButtonClick(int position, String text) {
        //ToolBar-interface에서 받아온값 -> TextFragment 전달
        Tab5Fragment_text textFragment = (Tab5Fragment_text) getFragmentManager().findFragmentById(R.id.fragment_2);
        textFragment.changedTextProperties(position, text);
        Log.v("Message","MainActivity onButtonClick // text : " + text);
    }



}