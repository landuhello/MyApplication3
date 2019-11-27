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

import java.util.List;

public class YanyuanAdapter extends RecyclerView.Adapter {
    private List<DetilBean.ResultBean.MovieActorBean> yanyuanlist;
    private Context context;

    public YanyuanAdapter(List<DetilBean.ResultBean.MovieActorBean> yanyuanlist, Context context) {
        this.yanyuanlist = yanyuanlist;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_yanyuan, viewGroup, false);
        YanyuanAdapter.ViewHolder viewHolder = new YanyuanAdapter.ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        YanyuanAdapter.ViewHolder viewHolder1 = (YanyuanAdapter.ViewHolder) viewHolder;
        viewHolder1.item_tv_yanyuan_score.setText(yanyuanlist.get(i).name);
        Glide.with(viewHolder1.itemView.getContext())
                .load(yanyuanlist.get(i).photo)
                .error(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(viewHolder1.item_iv_yanyuan_photo);
    }

    @Override
    public int getItemCount() {
        return yanyuanlist.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView item_iv_yanyuan_photo;
        TextView item_tv_yanyuan_score;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_iv_yanyuan_photo = itemView.findViewById(R.id.item_iv_yanyuan_photo);
            item_tv_yanyuan_score = itemView.findViewById(R.id.item_tv_yanyuan_score);
        }
    }
}
