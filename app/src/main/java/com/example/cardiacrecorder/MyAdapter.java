package com.example.cardiacrecorder;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList sp_id,dp_id,bpm_id,date_id,time_id,comment_id;

    Database DB;



    public MyAdapter(Context context, ArrayList sp_id, ArrayList dp_id, ArrayList bpm_id, ArrayList date_id, ArrayList time_id, ArrayList comment_id) {
        this.context = context;
        this.sp_id = sp_id;
        this.dp_id = dp_id;
        this.bpm_id = bpm_id;
        this.date_id = date_id;
        this.time_id = time_id;
        this.comment_id = comment_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.sp_id.setText(String.valueOf(sp_id.get(position)));
        holder.dp_id.setText(String.valueOf(dp_id.get(position)));
        holder.bpm_id.setText(String.valueOf(bpm_id.get(position)));
        holder.date_id.setText(String.valueOf(date_id.get(position)));
        holder.time_id.setText(String.valueOf(time_id.get(position)));
        holder.comment_id.setText(String.valueOf(comment_id.get(position)));

        int temp = Integer.parseInt(holder.sp_id.getText().toString());
        if(temp<90 || temp>140){
            holder.sp_id.setTextColor(Color.RED);
        }

        temp=Integer.parseInt(holder.dp_id.getText().toString());
        if(temp<60 || temp>90){
            holder.dp_id.setTextColor(Color.RED);
        }



    }

    @Override
    public int getItemCount() {
        return sp_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private MyAdapter adapter;
        TextView sp_id,dp_id,bpm_id,date_id,time_id,comment_id;
        Button delete;
        public MyViewHolder(View itemView) {
            super(itemView);
            sp_id = itemView.findViewById(R.id.spShow);
            dp_id = itemView.findViewById(R.id.dpShow);
            bpm_id = itemView.findViewById(R.id.bpmShow);
            date_id = itemView.findViewById(R.id.dateShow);
            time_id = itemView.findViewById(R.id.timeShow);
            comment_id = itemView.findViewById(R.id.commentShow);
            delete = (Button) itemView.findViewById(R.id.deleteButton);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

    }
}
