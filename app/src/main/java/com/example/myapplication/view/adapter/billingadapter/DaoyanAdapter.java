package com.example.myapplication.view.adapter.billingadapter;


import android.content.Context;
import android.support.annotation.NonNull;
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
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class DaoyanAdapter extends XRecyclerView.Adapter {
    private List<DetilBean.ResultBean.MovieDirectorBean> daoyanlist;
    private Context context;

    public DaoyanAdapter(List<DetilBean.ResultBean.MovieDirectorBean> daoyanlist, Context context) {
        this.daoyanlist = daoyanlist;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_daoyan, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder1 = (ViewHolder) viewHolder;
        viewHolder1.item_tv_daoyan_score.setText(daoyanlist.get(i).name);
        Glide.with(viewHolder1.itemView.getContext())
                .load(daoyanlist.get(i).photo)
                .error(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(viewHolder1.item_iv_daoyan_photo);
    }

    @Override
    public int getItemCount() {
        return daoyanlist.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView item_iv_daoyan_photo;
        TextView item_tv_daoyan_score;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           item_iv_daoyan_photo=itemView.findViewById(R.id.item_iv_daoyan_photo);
            item_tv_daoyan_score=itemView.findViewById(R.id.item_tv_daoyan_score);
        }
    }

}
