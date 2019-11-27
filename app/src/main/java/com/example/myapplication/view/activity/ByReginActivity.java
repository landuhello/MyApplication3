package com.example.myapplication.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.base.SyLinearLayoutManager;
import com.example.myapplication.model.bean.CinemaByRegionBean;
import com.example.myapplication.model.bean.RegionListBean;
import com.example.myapplication.presenter.ChaXuanQuPresenter;
import com.example.myapplication.view.adapter.RecyclerRegionAdapter;
import com.example.myapplication.view.adapter.RecyclerRegionCinemaAdapter;
import com.example.myapplication.view.fragment.RegionCinemaFragment;
import com.example.myapplication.view.inteface.MomInteface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class ByReginActivity extends BaseActivity<ChaXuanQuPresenter> implements MomInteface.IRegionListView {


    @BindView(R.id.by_jcv_video)
    JCVideoPlayerStandard byJcvVideo;
    @BindView(R.id.by_iv_back)
    ImageView byIvBack;
    @BindView(R.id.by_tv_name)
    TextView byTvName;
    @BindView(R.id.by_tv_shichang)
    TextView byTvShichang;
    @BindView(R.id.by_tv_score)
    TextView byTvScore;
    @BindView(R.id.by_tv_director)
    TextView byTvDirector;
    @BindView(R.id.by_btn_chose_region)
    Button byBtnChoseRegion;
    @BindView(R.id.by_recycler_cinema)
    RecyclerView byRecyclerCinema;
    @BindView(R.id.by_iv_xiang)
    ImageView byIvXiang;
    private String videoUrl;
    private String imageUrl;
    private String movieName;
    private int movieId;
    private RecyclerRegionAdapter recyclerRegionAdapter;

    @Override
    protected int initview() {
        return R.layout.activity_by_regin;
    }

    @Override
    protected ChaXuanQuPresenter setpresenter() {
        return new ChaXuanQuPresenter();
    }

    @Override
    protected void initdata() {
        Intent intent = getIntent();
        videoUrl = intent.getStringExtra("videoUrl");
        imageUrl = intent.getStringExtra("imageUrl");
        movieName = intent.getStringExtra("movieName");
        movieId = intent.getIntExtra("movieId", 0);
        double movieScore = intent.getDoubleExtra("movieScore", 0);
        String movieDuration = intent.getStringExtra("movieDuration");
        String movieDirector = intent.getStringExtra("movieDirector");

        //设电影名字
        byTvName.setText(movieName);
        //电影评分
        byTvScore.setText(movieScore + "分");
        //电影时长
        byTvShichang.setText(movieDuration);
        //导演
        byTvDirector.setText(movieDirector);
        //设置视频
        byJcvVideo.setUp(videoUrl, 0);
        //加载视频第一针图片
        Glide.with(this).load(imageUrl).into(byJcvVideo.thumbImageView);

    }

    @Override
    public void regionSuccess(RegionListBean regionListBean) {
        final List<RegionListBean.ResultBean> reresult = regionListBean.getResult();
        recyclerRegionAdapter = new RecyclerRegionAdapter(this);
        recyclerRegionAdapter.addData(reresult);
        byRecyclerCinema.setLayoutManager(new SyLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        byRecyclerCinema.setAdapter(recyclerRegionAdapter);
        recyclerRegionAdapter.onItemClickListener(new RecyclerRegionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int regionId) {
                byBtnChoseRegion.setText(reresult.get(position).getRegionName());
                t.cinemaByRegion(regionId);
            }
        });
    }

    @Override
    public void cinemaByRegionSuccess(CinemaByRegionBean cinemaByRegionBean) {
        List<CinemaByRegionBean.ResultBean> cinresult = cinemaByRegionBean.getResult();
        RecyclerRegionCinemaAdapter recyclerRegionCinemaAdapter = new RecyclerRegionCinemaAdapter(this);
        recyclerRegionCinemaAdapter.addData(cinresult);
        byRecyclerCinema.setLayoutManager(new SyLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        byRecyclerCinema.setAdapter(recyclerRegionCinemaAdapter);
        recyclerRegionCinemaAdapter.onItemClickListener(new RecyclerRegionCinemaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int cinemaId) {
                Intent intent = new Intent(ByReginActivity.this, Choose_seatActivity.class);
                intent.putExtra("videoUrl", videoUrl);
                intent.putExtra("imageUrl", imageUrl);
                intent.putExtra("movieName", movieName);
                intent.putExtra("movieId", movieId);
                intent.putExtra("cinemaId", cinemaId);
                startActivity(intent);
            }
        });
    }

    @OnClick(R.id.by_btn_chose_region)
    public void onClick() {
        t.regionList();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
