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
import com.example.myapplication.model.bean.AllcimBean;
import com.example.myapplication.model.bean.NearbyBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class Fragmenttwoxiangtwoadapter extends RecyclerView.Adapter<Fragmenttwoxiangtwoadapter.Viewholder> {
    private List<AllcimBean.ResultBean> result;


    public void setResult(List<AllcimBean.ResultBean> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layoutfragmenttwopingrecy, viewGroup, false);
        Viewholder viewholder = new Viewholder(inflate);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int i) {
        viewholder.textView.setText(result.get(i).getCommentUserName());
        Date date = new Date(result.get(i).getCommentTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm");
        viewholder.textView1.setText(String.valueOf(simpleDateFormat.format(date)));
        viewholder.textView2.setText(result.get(i).getGreatNum()+"人觉得很赞");
        Glide.with(viewholder.itemView.getContext()).load(result.get(i).getCommentHeadPic()).into(viewholder.imageView);
        viewholder.textView3.setText(result.get(i).getCommentContent());
    }

    @Override
    public int getItemCount() {
        if (result!=null){
            return result.size();
        }else {
            return 0;
        }

    }

    class Viewholder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        TextView textView1;
        TextView textView2;
         TextView textView3;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.twoping_im);
            textView = itemView.findViewById(R.id.twopintg_text);
            textView1 = itemView.findViewById(R.id.twoping_time);
            textView3 = itemView.findViewById(R.id.twoping_long);
            textView2 = itemView.findViewById(R.id.twoping_zan);
        }
    }
}
