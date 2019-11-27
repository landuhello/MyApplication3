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
import com.example.myapplication.model.bean.CinemaBean;
import com.example.myapplication.model.bean.NearbyBean;

import java.util.ArrayList;
import java.util.List;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class Fragmenttwofujinadapter extends RecyclerView.Adapter<Fragmenttwofujinadapter.Viewholder> {
    private List<NearbyBean.ResultBean> result = new ArrayList<>();
    private double km = 0;
    private int id;

    public void setResult(List<NearbyBean.ResultBean> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layoutfragmenttworecy, viewGroup, false);
        Viewholder viewholder = new Viewholder(inflate);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, final int i) {
        viewholder.textView.setText(result.get(i).getName());
        viewholder.textView1.setText(result.get(i).getAddress());
        viewholder.textView2.setText(Double.valueOf(result.get(i).getDistance() / 1000) + "km");
        Glide.with(viewholder.itemView.getContext()).load(result.get(i).getLogo()).into(viewholder.imageView);
        id = result.get(i).getId();
        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onclicklisten != null) {
                    onclicklisten.success(id, i);
                }
            }
        });
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

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.two_im);
            textView = itemView.findViewById(R.id.two_te);
            textView1 = itemView.findViewById(R.id.two_te1);
            textView2 = itemView.findViewById(R.id.two_te2);
        }
    }

    //条目点击接口回调
    private Onclicklisten onclicklisten;

    public interface Onclicklisten {
        void success(int id, int i);
    }

    public void setOnclicklisten(Onclicklisten onclicklisten) {
        this.onclicklisten = onclicklisten;
    }
}
