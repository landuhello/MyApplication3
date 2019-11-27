package com.example.myapplication.view.adapter.stage_photo_Adapter;

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
import com.example.myapplication.view.adapter.billingadapter.DaoyanAdapter;

import java.util.List;

public class Stage_photo_Adapter extends RecyclerView.Adapter {

    private List<String> posterlist;
    private Context context;

    public Stage_photo_Adapter(List<String> posterlist, Context context) {
        this.posterlist = posterlist;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_stage_photo, viewGroup, false);
        ViewHolder viewHolder = new Stage_photo_Adapter.ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder1 = (Stage_photo_Adapter.ViewHolder) viewHolder;

        Glide.with(viewHolder1.itemView.getContext())
                .load(posterlist.get(i))
                .error(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(viewHolder1.item_iv_juzhao_photo);
    }

    @Override
    public int getItemCount() {
        return posterlist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView item_iv_juzhao_photo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_iv_juzhao_photo = itemView.findViewById(R.id.item_iv_juzhao_photo);
        }
    }
}
