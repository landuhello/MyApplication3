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


public class ReThreeAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<RmenBean.ResultBean> list3 = new ArrayList<>();

    public ReThreeAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.rethreeitem, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder1 = (ViewHolder) viewHolder;
        viewHolder1.tv_rmenyi.setText(list3.get(i).getName());
        viewHolder1.tv_rmenfen.setText(list3.get(i).getScore() + "" + "分");
        Glide.with(context)
                .load(list3.get(i).getImageUrl())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(viewHolder1.iv_rmenyi);
    }

    public void getDat(List<RmenBean.ResultBean> result) {
        if (result != null && result.size() > 0) {
            list3.addAll(result);
        }
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_rmenfen, tv_rmenyi;
        ImageView iv_rmenyi;
        Button but_rmenyi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_rmenfen = itemView.findViewById(R.id.tv_rmenfen);
            tv_rmenyi = itemView.findViewById(R.id.tv_rmenyi);
            iv_rmenyi = itemView.findViewById(R.id.iv_rmenyi);
            but_rmenyi = itemView.findViewById(R.id.but_rmenyi);
        }
    }

    @Override
    public int getItemCount() {
        return list3.size();
    }


}
