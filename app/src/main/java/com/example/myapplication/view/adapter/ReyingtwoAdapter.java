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
import com.example.myapplication.model.bean.JiBean;
import com.example.myapplication.model.bean.ZhengBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class ReyingtwoAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<JiBean.ResultBean> jilist=new ArrayList<>();

    public ReyingtwoAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.reyingtwoitem, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder1 = (ViewHolder) viewHolder;
        viewHolder1.tv_yingjione.setText(jilist.get(i).getName());
        final long releaseTime = jilist.get(i).getReleaseTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
        String format = sdf.format(releaseTime);
        viewHolder1.tv_yingjitwo.setText(format+"上映");
        viewHolder1.tv_yingjithree.setText(jilist.get(i).getWantSeeNum()+""+"人想看");
        Glide.with(context)
                .load(jilist.get(i).getImageUrl())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(viewHolder1.iv_yingji);
    }

    public void getyingji(List<JiBean.ResultBean> result) {
        if (result!=null&&result.size()>0){
            jilist.addAll(result);
        }
        notifyDataSetChanged();
    }


    class  ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_yingji;
        TextView tv_yingjione,tv_yingjitwo,tv_yingjithree;
        Button but_yingjigou;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_yingji=itemView.findViewById(R.id.iv_yingji);
            tv_yingjione=itemView.findViewById(R.id.tv_yingjione);
            tv_yingjitwo=itemView.findViewById(R.id.tv_yingjitwo);
            tv_yingjithree=itemView.findViewById(R.id.tv_yingjithree);
            but_yingjigou=itemView.findViewById(R.id.but_yingjigou);
        }
    }

    @Override
    public int getItemCount() {
        return jilist.size();
    }
}
