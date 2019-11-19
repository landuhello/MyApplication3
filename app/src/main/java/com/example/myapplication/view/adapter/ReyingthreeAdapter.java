package com.example.myapplication.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.model.bean.RmenBean;


import java.util.ArrayList;
import java.util.List;


public class ReyingthreeAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<RmenBean.ResultBean> rmenlist;

    public ReyingthreeAdapter(Context context, List<RmenBean.ResultBean> rmenlist) {
        this.context = context;
        this.rmenlist = rmenlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.reyingthreeitem, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder1 = (ViewHolder) viewHolder;
        viewHolder1.tv_yingrmenfive.setText(rmenlist.get(i).getName());
        viewHolder1.tv_yingrmenone.setText(rmenlist.get(i).getDirector());
        viewHolder1.tv_yingrmentwo.setText(rmenlist.get(i).getStarring());
        viewHolder1.tv_yingrmenthree.setText(rmenlist.get(i).getScore() + "" + "分");
        Glide.with(context)
                .load(rmenlist.get(i).getImageUrl())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(viewHolder1.iv_yingrmen);
    }

    public void getyingrmen(List<RmenBean.ResultBean> result) {
        if (result != null && result.size() > 0) {
            rmenlist.addAll(result);
        }
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_yingrmen;
        TextView tv_yingrmenfive, tv_yingrmenone, tv_yingrmentwo, tv_yingrmenthree;
        Button but_yingrmengou;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_yingrmen = itemView.findViewById(R.id.iv_yingrmen);
            tv_yingrmenfive = itemView.findViewById(R.id.tv_yingrmenfive);
            tv_yingrmenone = itemView.findViewById(R.id.tv_yingrmenone);
            tv_yingrmentwo = itemView.findViewById(R.id.tv_yingrmentwo);
            tv_yingrmenthree = itemView.findViewById(R.id.tv_yingrmenthree);
            but_yingrmengou = itemView.findViewById(R.id.but_yingrmengou);
        }
    }

    @Override
    public int getItemCount() {
        return rmenlist.size();
    }
}
