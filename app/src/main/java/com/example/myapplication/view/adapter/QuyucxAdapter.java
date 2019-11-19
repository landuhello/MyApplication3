package com.example.myapplication.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.bean.QuyuchaxBean;

import java.util.ArrayList;
import java.util.List;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public class QuyucxAdapter extends RecyclerView.Adapter<QuyucxAdapter.Viewholder> {
    private List<QuyuchaxBean.ResultBean> result1 = new ArrayList<>();
    private int id;

    public void setResult1(List<QuyuchaxBean.ResultBean> result1) {
        this.result1 = result1;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.quyucxlayoutright, viewGroup, false);
        Viewholder viewholder = new Viewholder(inflate);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, final int i) {
        viewholder.textView.setText(result1.get(i).getName());
        id = result1.get(i).getId();
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
        if (result1 != null) {
            return result1.size();
        } else {
            return 0;
        }
    }

    public void clear() {
        result1.clear();
    }

    class Viewholder extends RecyclerView.ViewHolder {

        TextView textView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.dizhicx_te);
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
