package com.example.myapplication.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.SupportActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.model.bean.DetilBean;
import com.example.myapplication.view.activity.DetailActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter {
    private Context context;
    public List<DetilBean.ResultBean> detaillist;

    public DetailAdapter(Context context, List<DetilBean.ResultBean> detaillist) {
        this.context = context;
        this.detaillist = detaillist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.detail_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
       ViewHolder viewHolder1 = (ViewHolder) viewHolder;
       viewHolder1.tv_xiangone.setText(detaillist.get(i).score+""+"分");
       viewHolder1.tv_xiangtwo.setText(detaillist.get(i).commentNum+"万条");
       viewHolder1.tv_xiangthree.setText(detaillist.get(i).name);
       viewHolder1.tv_xianglei.setText(detaillist.get(i).movieType);
       viewHolder1.tv_xiangbo.setText(detaillist.get(i).duration);
        Date date = new Date(detaillist.get(i).releaseTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        String format = sdf.format(date);
       viewHolder1.tv_xiangtime.setText(format);
       viewHolder1.tv_xiangguo.setText(detaillist.get(i).placeOrigin);
        Glide.with(context).load(detaillist.get(i).imageUrl)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(viewHolder1.iv_xiangtwo);

    }

    @Override
    public int getItemCount() {
        return detaillist.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_xiangtwo;
        TextView tv_xiangone,tv_xiangtwo,tv_xiangthree,tv_xianglei,tv_xiangbo,tv_xiangtime,tv_xiangguo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_xiangtwo=itemView.findViewById(R.id.iv_xiangtwo);
            tv_xiangone=itemView.findViewById(R.id.tv_xiangone);
            tv_xiangtwo=itemView.findViewById(R.id.tv_xiangtwo);
            tv_xiangthree=itemView.findViewById(R.id.tv_xiangthree);
            tv_xianglei=itemView.findViewById(R.id.tv_xianglei);
            tv_xiangbo=itemView.findViewById(R.id.tv_xiangbo);
            tv_xiangtime=itemView.findViewById(R.id.tv_xiangtime);
            tv_xiangguo=itemView.findViewById(R.id.tv_xiangguo);

        }
    }
}
