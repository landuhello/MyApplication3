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

import java.util.ArrayList;
import java.util.List;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class Fragmentoneadapter extends RecyclerView.Adapter<Fragmentoneadapter.Viewholder> {
    private List<CinemaBean.ResultBean> result = new ArrayList<>();
    private String name;
    private String address;
    private int id;


    public void setResult(List<CinemaBean.ResultBean> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layoutfragmentonerecy, viewGroup, false);
        Viewholder viewholder = new Viewholder(inflate);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, final int i) {
        viewholder.textView.setText(result.get(i).getName());
        viewholder.textView1.setText(result.get(i).getAddress());
        Glide.with(viewholder.itemView.getContext()).load(result.get(i).getLogo()).into(viewholder.imageView);
        name = result.get(i).getName();
        address = result.get(i).getAddress();
        id = result.get(i).getId();
        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (domove != null) {
                    domove.onclick(name, address, id, i);
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

        private final ImageView imageView;
        private final TextView textView;
        private final TextView textView1;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.one_im);
            textView = itemView.findViewById(R.id.one_te);
            textView1 = itemView.findViewById(R.id.one_te1);
        }
    }

    //条目点击接口回调
    private Domove domove;

    public interface Domove {
        void onclick(String name, String address, int id, int i);
    }


    public void setDomove(Domove domove) {
        this.domove = domove;
    }
}
