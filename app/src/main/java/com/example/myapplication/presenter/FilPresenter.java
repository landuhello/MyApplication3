package com.example.myapplication.presenter;

import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.model.bean.CommentBean;
import com.example.myapplication.model.bean.FilmReviewBean;
import com.example.myapplication.model.http.HttpUils;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.Map;
//
public class FilPresenter extends BasePresenter<MomInteface.IComment> {
    public void setComment(int movieId, Map<String,Integer> headMap){
        HttpUils.getHttpUils().getComment(movieId, headMap, new HttpUils.CallBack<FilmReviewBean>() {

            @Override
            public void success(FilmReviewBean filmReviewBean) {
                getT().success(filmReviewBean);
            }
        });
    }
}
