package com.example.myapplication.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.myapplication.R;
import com.example.myapplication.model.bean.RegionListBean;

import java.util.ArrayList;
import java.util.List;

public class RecyclerRegionAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<RegionListBean.ResultBean> datas ;

    public RecyclerRegionAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_region, viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        myViewHolder.tv_regionName.setText(datas.get(i).getRegionName());
        myViewHolder.tv_regionName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(i,datas.get(i).getRegionId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    private OnItemClickListener mOnItemClickListener;

    public void onItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }


    public interface OnItemClickListener{
        void onItemClick(int position, int regionId);
    }

    public void addData(List<RegionListBean.ResultBean> result) {
        if (result.size()>0 && result != null){
            datas.addAll(result);
        }
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
         TextView tv_regionName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_regionName = itemView.findViewById(R.id.tv_regionName);
        }
    }
}
