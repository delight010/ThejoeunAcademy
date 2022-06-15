package com.asolec.network_json_student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder> {

    private Context context;
    private ArrayList<JsonStudent> data  = null;
    private LayoutInflater inflater = null;

    public RecyclerAdapter(Context context, ArrayList<JsonStudent> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_layout, parent, false  );
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.Holder holder, int position) {
        holder.tv_code.setText(data.get(position).getCode());
        holder.tv_name.setText(data.get(position).getName());
        holder.tv_dept.setText(data.get(position).getDept());
        holder.tv_phone.setText(data.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    //view holder
    public static class Holder extends RecyclerView.ViewHolder{
       TextView tv_code;
       TextView tv_name;
       TextView tv_dept;
       TextView tv_phone;

        public Holder(View view){
            super(view);
            this.tv_code = view.findViewById(R.id.tv_code);
            this.tv_name = view.findViewById(R.id.tv_name);
            this.tv_dept = view.findViewById(R.id.tv_dept);
            this.tv_phone = view.findViewById(R.id.tv_phone);
        }
    }


}
