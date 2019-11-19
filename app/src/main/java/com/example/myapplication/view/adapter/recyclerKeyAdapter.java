package com.example.myapplication.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.bean.KeywordsBean;
import com.example.myapplication.model.bean.MhmoveyBean;

import java.util.ArrayList;
import java.util.List;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class recyclerKeyAdapter extends RecyclerView.Adapter {
    private List<KeywordsBean.ResultBean> result=new ArrayList<>();

    public void setResult(List<KeywordsBean.ResultBean> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_movie, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        myViewHolder.tv_more_name.setText(result.get(i).getName());
        myViewHolder.tv_more_director.setText("导演："+result.get(i).getDirector());
        myViewHolder.tv_more_score.setText("评分："+result.get(i).getScore());
        myViewHolder.tv_more_starring.setText("主演："+result.get(i).getStarring());
        Glide.with(myViewHolder.itemView.getContext()).load(result.get(i).getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .into(myViewHolder.iv_more_imageUrl);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_more_name;
        private final TextView tv_more_director;
        private final TextView tv_more_score;
        private final TextView tv_more_starring;
        private final ImageView iv_more_imageUrl;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_more_name = itemView.findViewById(R.id.tv_more_name);
            tv_more_director = itemView.findViewById(R.id.tv_more_director);
            tv_more_score = itemView.findViewById(R.id.tv_more_score);
            tv_more_starring = itemView.findViewById(R.id.tv_more_starring);
            iv_more_imageUrl = itemView.findViewById(R.id.iv_more_imageUrl);
        }
    }
}
