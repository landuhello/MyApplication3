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



public class ReOneAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ZhengBean.ResultBean> list1=new ArrayList<>();

    public ReOneAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.reoneitem, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder1 = (ViewHolder) viewHolder;
        viewHolder1.tv_zhengyi.setText(list1.get(i).getName());
        viewHolder1.tv_fen.setText(list1.get(i).getScore()+""+"分");
        Glide.with(context)
                .load(list1.get(i).getImageUrl())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(viewHolder1.iv_zhengyi);
    }

    public void getad(List<ZhengBean.ResultBean> result) {
        if (result!=null&&result.size()>0){
            list1.addAll(result);
        }
        notifyDataSetChanged();
    }

    class  ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_zhengyi;
        TextView tv_zhengyi,tv_fen;
        Button but_zhengyi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_zhengyi=itemView.findViewById(R.id.iv_zhengyi);
            tv_zhengyi=itemView.findViewById(R.id.tv_zhengyi);
            tv_fen=itemView.findViewById(R.id.tv_fen);
            but_zhengyi=itemView.findViewById(R.id.but_zhengyi);
        }
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }
}
