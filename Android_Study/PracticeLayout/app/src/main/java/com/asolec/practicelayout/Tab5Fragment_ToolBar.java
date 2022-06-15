package com.asolec.practicelayout;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;


public class Tab5Fragment_ToolBar extends Fragment {

    EditText editText = null;
    Button button = null;
    SeekBar seekBar = null;
    int seekValue = 10; // 초기값

    ToolbarListener activityCallback;

    // ------------------------------------
    // MainActivity와의 통신을 위해 interface를 사용
    // MainActivity에서는 implements를 사용
    // ------------------------------------

    public interface  ToolbarListener{
        public void onButtonClick(int position, String text);
    }

    //-------------------------------------
    // Fragment에서는 onAttach()가 제일 처음으로 실행
    //-------------------------------------

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            activityCallback = (ToolbarListener) context;
            //context = 현재 화면,위치를 알고 있음
            Log.v("Message","ToolBarFragement onAttach try activityCallback");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab5__tool_bar, container, false);
        // 그림 연결
        Log.v("Message","ToolBarFragement onCreateView start");

        editText = view.findViewById(R.id.f5_edit);
        button = view.findViewById(R.id.f5_button);
        seekBar = view.findViewById(R.id.f5_seekbar);

        button.setOnClickListener(mClickListener);
        seekBar.setOnSeekBarChangeListener(mSeekBarChangedListener);

        return view; // view 리턴
    }

    SeekBar.OnSeekBarChangeListener mSeekBarChangedListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            seekValue = progress;
            Log.v("Message","ToolBarFragement mSeekBarChangedListener event // " +
                    " fontsize : " + progress );
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    //------------------------------------
    //MainActivity의 onButtonClick()에서 실행
    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            activityCallback.onButtonClick(seekValue, editText.getText().toString());
            Log.v("Message","ToolBarFragement View.OnClickListener event");
        }
    };
}