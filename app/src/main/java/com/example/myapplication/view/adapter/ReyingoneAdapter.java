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
import com.example.myapplication.model.bean.ZhengBean;

import java.util.ArrayList;
import java.util.List;


public class ReyingoneAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ZhengBean.ResultBean> zhenglist=new ArrayList<>();

    public ReyingoneAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.reyingoneitem, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder1 = (ViewHolder) viewHolder;
        viewHolder1.tv_yingzhangfive.setText(zhenglist.get(i).getName());
        viewHolder1.tv_yingzhangone.setText(zhenglist.get(i).getDirector());
        viewHolder1.tv_yingzhangtwo.setText(zhenglist.get(i).getStarring());
        viewHolder1.tv_yingzhangthree.setText(zhenglist.get(i).getScore()+""+"分");
        Glide.with(context)
                .load(zhenglist.get(i).getImageUrl())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(viewHolder1.iv_yingzhang);
    }

    public void getying(List<ZhengBean.ResultBean> result) {
        if (result!=null&&result.size()>0){
            zhenglist.addAll(result);
        }
        notifyDataSetChanged();
    }


    class  ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_yingzhang;
        TextView tv_yingzhangfive,tv_yingzhangone,tv_yingzhangtwo,tv_yingzhangthree;
        Button but_yinggou;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_yingzhang=itemView.findViewById(R.id.iv_yingzhang);
            tv_yingzhangfive=itemView.findViewById(R.id.tv_yingzhangfive);
            tv_yingzhangone=itemView.findViewById(R.id.tv_yingzhangone);
            tv_yingzhangtwo=itemView.findViewById(R.id.tv_yingzhangtwo);
            tv_yingzhangthree=itemView.findViewById(R.id.tv_yingzhangthree);
            but_yinggou=itemView.findViewById(R.id.but_yinggou);
        }
    }

    @Override
    public int getItemCount() {
        return zhenglist.size();
    }
}
