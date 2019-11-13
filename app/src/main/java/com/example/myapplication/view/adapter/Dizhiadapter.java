package com.example.myapplication.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.bean.ToolBean;

import java.util.List;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class Dizhiadapter extends RecyclerView.Adapter<Dizhiadapter.Viewholder> {
    private List<ToolBean.ResultBean> result;
    private int id;

    public void setResult(List<ToolBean.ResultBean> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dizhilayout,viewGroup, false);
        Viewholder viewholder = new Viewholder(inflate);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, final int i) {
        viewholder.textView.setText(result.get(i).getRegionName());
        id = result.get(i).getRegionId();
        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onclicklisten!=null){
                    onclicklisten.success(id,i);
                }
            }
        });
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

         TextView textView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.dizhi_te);

        }
    }
    //条目点击接口回调
    private Fragmenttwofujinadapter.Onclicklisten onclicklisten;

    public interface Onclicklisten{
        void success(int id,int i);
    }

    public void setOnclicklisten(Fragmenttwofujinadapter.Onclicklisten onclicklisten) {
        this.onclicklisten = onclicklisten;
    }
}
