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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class ReTwoAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<JiBean.ResultBean> list2 = new ArrayList<>();

    public ReTwoAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.retwoitem, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder1 = (ViewHolder) viewHolder;
        viewHolder1.tv_jione.setText(list2.get(i).getName());

        final long releaseTime = list2.get(i).getReleaseTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
        String format = sdf.format(releaseTime);
        viewHolder1.tv_jitwo.setText(format + "上映");
        viewHolder1.tv_jithree.setText(list2.get(i).getWantSeeNum() + "" + "人想看");
        Glide.with(context).load(list2.get(i).getImageUrl())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(viewHolder1.iv_ji);
    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

    public void getDa(List<JiBean.ResultBean> result) {
        if (result != null && result.size() > 0) {
            list2.addAll(result);
        }
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_jione, tv_jitwo, tv_jithree;
        ImageView iv_ji;
        Button but_ji;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_jione = itemView.findViewById(R.id.tv_jione);
            tv_jitwo = itemView.findViewById(R.id.tv_jitwo);
            tv_jithree = itemView.findViewById(R.id.tv_jithree);
            iv_ji = itemView.findViewById(R.id.iv_ji);
            but_ji = itemView.findViewById(R.id.but_ji);
        }
    }
}
