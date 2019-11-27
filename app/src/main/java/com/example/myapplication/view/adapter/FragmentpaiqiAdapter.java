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
import com.example.myapplication.model.bean.NearbyBean;
import com.example.myapplication.model.bean.PaiqiBean;

import java.util.List;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class FragmentpaiqiAdapter extends RecyclerView.Adapter<FragmentpaiqiAdapter.Viewholder> {
    private List<PaiqiBean.ResultBean> result;

    public void setResult(List<PaiqiBean.ResultBean> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.paiqiitemlayout, viewGroup, false);
        Viewholder viewholder = new Viewholder(inflate);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int i) {
        viewholder.textView.setText(result.get(i).getName());
        viewholder.textView1.setText("导演：" + result.get(i).getDirector());
        viewholder.textView2.setText("主演：" + result.get(i).getStarring());
        viewholder.textView3.setText("评分：" + result.get(i).getScore() + "分");
        Glide.with(viewholder.itemView.getContext()).load(result.get(i).getImageUrl()).into(viewholder.imageView);


    }

    @Override
    public int getItemCount() {
        if (result != null) {
            return result.size();
        } else {
            return 0;
        }

    }

    class Viewholder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        TextView textView1;
        TextView textView2;
        TextView textView3;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.paiqi_im);
            textView = itemView.findViewById(R.id.paiqi_te1);
            textView1 = itemView.findViewById(R.id.paiqi_te2);
            textView2 = itemView.findViewById(R.id.paiqi_te3);
            textView3 = itemView.findViewById(R.id.paiqi_te4);
        }
    }
}
