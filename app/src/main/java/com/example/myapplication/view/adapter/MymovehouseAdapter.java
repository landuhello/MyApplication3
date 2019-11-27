package com.example.myapplication.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.bean.CommentBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class MymovehouseAdapter extends RecyclerView.Adapter<MymovehouseAdapter.Myviewholder> {

    private List<CommentBean.ResultBean> result;

    public void setResult(List<CommentBean.ResultBean> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mymovehouseitemlayout, viewGroup, false);
        Myviewholder myviewholder = new Myviewholder(inflate);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder myviewholder, int i) {
        myviewholder.textView1.setText(result.get(i).getCinemaName());
        myviewholder.textView2.setText(result.get(i).getAddress());
        int distance = result.get(i).getDistance();
        double i1 = distance / 1000;
        myviewholder.textView4.setText(i1+"km");
        myviewholder.textView5.setText(result.get(i).getMyCommentContent());
        Date currentTime = new Date(result.get(i).getCommentTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        myviewholder.textView3.setText(formatter.format(currentTime));
        Glide.with(myviewholder.itemView.getContext()).load(result.get(i).getLogo()).into(myviewholder.imageView);
    }

    @Override
    public int getItemCount() {
        if (result != null) {
            return result.size();
        } else {
            return 0;
        }
    }

    class Myviewholder extends RecyclerView.ViewHolder {

         ImageView imageView;
         TextView textView1;
         TextView textView2;

         TextView textView4;
         TextView textView5;
         TextView textView3;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.movehouse_im);
            textView1 = itemView.findViewById(R.id.myhouse_name);
            textView2 = itemView.findViewById(R.id.myhouse_daoyan);
            textView3 = itemView.findViewById(R.id.mymovehouse_time);
            textView4 = itemView.findViewById(R.id.myhouse_pinfen);
            textView5 = itemView.findViewById(R.id.myhouse_pinglun);
        }
    }
}
