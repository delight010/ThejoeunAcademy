package com.asolec.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ToolBarFragment.ToolbarListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("Message","MainActivity onCreate");
    }

    @Override
    public void onButtonClick(int position, String text) {
        //ToolBar-interface에서 받아온값 -> TextFragment 전달
        TextFragment textFragment = (TextFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_2);
        textFragment.changedTextProperties(position, text);
        Log.v("Message","MainActivity onButtonClick // text : " + text);
    }
}