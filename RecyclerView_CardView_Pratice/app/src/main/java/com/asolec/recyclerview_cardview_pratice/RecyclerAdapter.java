package com.asolec.recyclerview_cardview_pratice;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView iv_cardimg;
        public TextView tv_title;
        public TextView tv_content;

        public ViewHolder(View itemView){
            super(itemView);
            iv_cardimg = itemView.findViewById(R.id.iv_cardview); // 1개의 셀 모양 세팅
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_content = itemView.findViewById(R.id.tv_content);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition(); // 현재 위치를 반환
                    Snackbar.make(v, "클릭하셨습니다",
                            Snackbar.LENGTH_LONG).setAction("", null).show();
                    //스낵바 생성
                }
            });
        }

    }


    //화면 보여주기(초기화)
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    //재사용하기 위한 메소드(새로운 값을 넣어줌)
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }




}
