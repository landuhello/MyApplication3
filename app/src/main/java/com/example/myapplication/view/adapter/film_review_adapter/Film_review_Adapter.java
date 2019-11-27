package com.example.myapplication.view.adapter.film_review_adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.model.bean.CommentBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Film_review_Adapter extends RecyclerView.Adapter<Film_review_Adapter.ViewHolder> {

    private List<CommentBean.ResultBean> filmList=new ArrayList<>();
    private Context context;

    public void setFilmList(List<CommentBean.ResultBean> filmList) {
        this.filmList = filmList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_film_review, viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(inflate1);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        ViewHolder viewHolder1 = viewHolder;
        viewHolder1.itemFilmTvCommentusername.setText(filmList.get(i).getCommentUserName());
        viewHolder1.itemFilmTvCommentcontent.setText(filmList.get(i).getCommentContent());
        viewHolder1.itemFilmTvGreatnum.setText(filmList.get(i).getGreatNum()+"");
        viewHolder1.itemFilmTvReplynum.setText("等"+filmList.get(i).getReplyNum()+"人进行了回复");
        long commentTime = filmList.get(i).getCommentTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
        String time1 = sdf.format(commentTime);
        viewHolder1.itemFilmTvCommenttime.setText(time1);
        final int isGreat = filmList.get(i).getIsGreat();
        if (isGreat==1){
            Glide.with(viewHolder1.itemView.getContext()).load(R.drawable.greats).into(viewHolder1.itemFilmIvIsgreat);
        }else{
            Glide.with(viewHolder1.itemView.getContext()).load(R.drawable.great).into(viewHolder1.itemFilmIvIsgreat);
        }

        List<String> replyHeadPic = filmList.get(i).getReplyHeadPic();
        for (int j = 0; j < replyHeadPic.size(); j++) {
            if (replyHeadPic.size()>=5){
                Glide.with(viewHolder1.itemView.getContext()).load(replyHeadPic.get(0)).apply(RequestOptions.circleCropTransform()).into(viewHolder1.itemFilmIvImage1);
                Glide.with(viewHolder1.itemView.getContext()).load(replyHeadPic.get(1)).apply(RequestOptions.circleCropTransform()).into(viewHolder1.itemFilmIvImage2);
                Glide.with(viewHolder1.itemView.getContext()).load(replyHeadPic.get(2)).apply(RequestOptions.circleCropTransform()).into(viewHolder1.itemFilmIvImage3);
                Glide.with(viewHolder1.itemView.getContext()).load(replyHeadPic.get(3)).apply(RequestOptions.circleCropTransform()).into(viewHolder1.itemFilmIvImage4);
                Glide.with(viewHolder1.itemView.getContext()).load(replyHeadPic.get(4)).apply(RequestOptions.circleCropTransform()).into(viewHolder1.itemFilmIvImage5);
            }else if (replyHeadPic.size()==4){
                Glide.with(viewHolder1.itemView.getContext()).load(replyHeadPic.get(0)).apply(RequestOptions.circleCropTransform()).into(viewHolder1.itemFilmIvImage1);
                Glide.with(viewHolder1.itemView.getContext()).load(replyHeadPic.get(1)).apply(RequestOptions.circleCropTransform()).into(viewHolder1.itemFilmIvImage2);
                Glide.with(viewHolder1.itemView.getContext()).load(replyHeadPic.get(2)).apply(RequestOptions.circleCropTransform()).into(viewHolder1.itemFilmIvImage3);
                Glide.with(viewHolder1.itemView.getContext()).load(replyHeadPic.get(3)).apply(RequestOptions.circleCropTransform()).into(viewHolder1.itemFilmIvImage4);
            }else if (replyHeadPic.size()==3){
                Glide.with(viewHolder1.itemView.getContext()).load(replyHeadPic.get(0)).apply(RequestOptions.circleCropTransform()).into(viewHolder1.itemFilmIvImage1);
                Glide.with(viewHolder1.itemView.getContext()).load(replyHeadPic.get(1)).apply(RequestOptions.circleCropTransform()).into(viewHolder1.itemFilmIvImage2);
                Glide.with(viewHolder1.itemView.getContext()).load(replyHeadPic.get(2)).apply(RequestOptions.circleCropTransform()).into(viewHolder1.itemFilmIvImage3);
            }else if (replyHeadPic.size()==2){
                Glide.with(viewHolder1.itemView.getContext()).load(replyHeadPic.get(0)).apply(RequestOptions.circleCropTransform()).into(viewHolder1.itemFilmIvImage1);
                Glide.with(viewHolder1.itemView.getContext()).load(replyHeadPic.get(1)).apply(RequestOptions.circleCropTransform()).into(viewHolder1.itemFilmIvImage2);
            }else if (replyHeadPic.size()==1){
                Glide.with(viewHolder1.itemView.getContext()).load(replyHeadPic.get(0)).apply(RequestOptions.circleCropTransform()).into(viewHolder1.itemFilmIvImage1);
            }
        }
       Glide.with(viewHolder1.itemView.getContext()).load(filmList.get(i).getCommentHeadPic()).apply(RequestOptions.circleCropTransform()).into(viewHolder1.itemFilmIvComment);
        viewHolder1.itemFilmIvIsgreat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setOnClick != null) {
                    setOnClick.setItemClick(i);
                }
            }
        });
        double score = filmList.get(i).getScore();
        double floor = Math.floor(score);
        float score1 = (float) (floor / 2);
        viewHolder1.itemFilmRbRatingbar.setRating(score1);
        viewHolder1.itemFilmTvScore.setText(score+"分");

    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_film_iv_comment)
        ImageView itemFilmIvComment;
        @BindView(R.id.item_film_tv_commentusername)
        TextView itemFilmTvCommentusername;
        @BindView(R.id.item_film_tv_commenttime)
        TextView itemFilmTvCommenttime;
        @BindView(R.id.item_film_tv_commentcontent)
        TextView itemFilmTvCommentcontent;
        @BindView(R.id.item_film_iv_isgreat)
        ImageView itemFilmIvIsgreat;
        @BindView(R.id.item_film_tv_greatnum)
        TextView itemFilmTvGreatnum;
        @BindView(R.id.item_film_iv_image1)
        ImageView itemFilmIvImage1;
        @BindView(R.id.item_film_iv_image2)
        ImageView itemFilmIvImage2;
        @BindView(R.id.item_film_iv_image3)
        ImageView itemFilmIvImage3;
        @BindView(R.id.item_film_iv_image4)
        ImageView itemFilmIvImage4;
        @BindView(R.id.item_film_iv_image5)
        ImageView itemFilmIvImage5;
        @BindView(R.id.item_film_tv_replynum)
        TextView itemFilmTvReplynum;
        @BindView(R.id.item_film_rb_ratingbar)
        RatingBar itemFilmRbRatingbar;
        @BindView(R.id.item_film_tv_score)
        TextView itemFilmTvScore;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public interface setOnClick {
        void setItemClick(int positon);
        void setClick(int positon);
    }

    private setOnClick setOnClick;

    public void setClick(setOnClick setOnClick) {
        this.setOnClick = setOnClick;
    }
}
