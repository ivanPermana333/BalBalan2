package com.example.balbalan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {



    private ArrayList<ModelJadwal> dataList;

    public ScheduleAdapter(ArrayList<ModelJadwal> dataList) {
        this.dataList = dataList;

    }


    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_view, parent, false);
        return new ScheduleViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        holder.txtHome.setText(dataList.get(position).getStrHomeTeam());


        holder.txtAway.setText(dataList.get(position).getStrAwayTeam());
        holder.txtDate.setText(dataList.get(position).getStrDate());
        holder.txtTime.setText(dataList.get(position). getStrTime());

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder{
        private TextView txtHome, txtAway, txtDate, txtTime;

        public ScheduleViewHolder(View itemView) {
            super(itemView);
            txtHome = (TextView) itemView.findViewById(R.id.txtstrHomeTeam);
            txtAway = (TextView) itemView.findViewById(R.id.txtstrAwayTeam);
            txtDate = (TextView) itemView.findViewById(R.id.txtstrDate);
            txtTime = (TextView) itemView.findViewById(R.id.txtTime);
        }
    }


}
