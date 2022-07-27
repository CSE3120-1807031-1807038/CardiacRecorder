package com.example.cardiacrecorder;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    List<Values> valuesList;

    public MyAdapter(Context context, List<Values> valuesList) {
        this.context = context;
        this.valuesList = valuesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Values data = valuesList.get(position);
        holder.sp_id.setText(data.getS_pressure());
        int temp = Integer.parseInt(holder.sp_id.getText().toString());
        if(temp<90 || temp>140){
            holder.sp_id.setTextColor(Color.RED);
        }
        holder.dp_id.setText(data.getD_pressure());
        temp=Integer.parseInt(holder.dp_id.getText().toString());
        if(temp<60 || temp>90){
            holder.dp_id.setTextColor(Color.RED);
        }
        holder.bpm_id.setText(data.getHeart_rate());
        holder.date_id.setText(data.getDate());


    }

    @Override
    public int getItemCount() {
        return valuesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView sp_id,dp_id,bpm_id,date_id,time_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sp_id = itemView.findViewById(R.id.spShow);
            dp_id = itemView.findViewById(R.id.dpShow);
            bpm_id = itemView.findViewById(R.id.bpmShow);
            date_id = itemView.findViewById(R.id.dateShow);
            time_id = itemView.findViewById(R.id.timeShow);
        }
    }
}
