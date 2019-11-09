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
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.paiqilayoutone, viewGroup, false);
        Viewholder viewholder = new Viewholder(inflate);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int i) {
        viewholder.textView.setText(result.get(i).getName());
//        viewholder.textView1.setText(result.get(i).getAddress());
//        viewholder.textView2.setText(Double.valueOf(result.get(i).getDistance()/1000)+"km");
//        Glide.with(viewholder.itemView.getContext()).load(result.get(i).getLogo()).into(viewholder.imageView);
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

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.two_im);
            textView = itemView.findViewById(R.id.two_te);
            textView1 = itemView.findViewById(R.id.two_te1);
            textView2 = itemView.findViewById(R.id.two_te2);
        }
    }
}
