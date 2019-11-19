package com.example.myapplication.view.adapter.advance_notice_adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.bean.DetilBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class Advance_notice_Adapter extends RecyclerView.Adapter<Advance_notice_Adapter.ViewHolder> {
    private List<DetilBean.ResultBean.ShortFilmListBean> shortlist;
    private Context context;

    public Advance_notice_Adapter(List<DetilBean.ResultBean.ShortFilmListBean> shortlist, Context context) {
        this.shortlist = shortlist;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.item_advance, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ViewHolder viewHolder1 = viewHolder;
        viewHolder1.videoJcv.setUp(shortlist.get(i).videoUrl, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "");
        Glide.with(context).load(shortlist.get(i).imageUrl).into(viewHolder1.videoJcv.thumbImageView);
    }

    @Override
    public int getItemCount() {
        return shortlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.video_jcv)
        JCVideoPlayerStandard videoJcv;
        @BindView(R.id.advance_lin)
        LinearLayout advanceLin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
