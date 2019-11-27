package com.example.myapplication.view.inteface;

import com.example.myapplication.base.Baseinteface;

import com.example.myapplication.model.bean.AllcimBean;
import com.example.myapplication.model.bean.BannerBean;
import com.example.myapplication.model.bean.CindizhiBean;
import com.example.myapplication.model.bean.CinemaBean;
import com.example.myapplication.model.bean.CinemaByRegionBean;
import com.example.myapplication.model.bean.CinemadetailsBean;
import com.example.myapplication.model.bean.CommentBean;
import com.example.myapplication.model.bean.DayBean;
import com.example.myapplication.model.bean.DetilBean;
import com.example.myapplication.model.bean.JiBean;
import com.example.myapplication.model.bean.LoginBean;
import com.example.myapplication.model.bean.MhmoveyBean;
import com.example.myapplication.model.bean.NearbyBean;
import com.example.myapplication.model.bean.PaiqiBean;
import com.example.myapplication.model.bean.QuyuchaxBean;
import com.example.myapplication.model.bean.RegBean;
import com.example.myapplication.model.bean.RegionListBean;
import com.example.myapplication.model.bean.RmenBean;
import com.example.myapplication.model.bean.SeatleBean;
import com.example.myapplication.model.bean.ToolBean;
import com.example.myapplication.model.bean.YanzhengBean;
import com.example.myapplication.model.bean.ZhengBean;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public interface MomInteface  {
     //登陆
     interface dologin extends Baseinteface{
         void success(LoginBean bean);
     }
     //推荐影院
     interface docin extends Baseinteface{
         void success(CinemaBean bean);
     }
     //附近影院
    interface donear extends Baseinteface{
         void success(NearbyBean nearbyBean);
     }
     //影院评论
     interface doallcin extends Baseinteface{
         void success(AllcimBean allcimBean);
     }
     //影院排期
    interface dopaiqi extends Baseinteface{
         void success(PaiqiBean bean);
     }
     //首页
    interface IBanner extends Baseinteface{
        void ok(BannerBean bannerBean);
        void no(String mag);
        void rey(ZhengBean zhengBean);
        void reyji(JiBean jiBean);
        void remen(RmenBean rmenBean);
    }
    //电影评论
    interface IComment extends Baseinteface{
         void success(CommentBean commentBean);
    }
    //根据影厅id 查询座位信息
    interface ISeate extends Baseinteface{
         void success(SeatleBean seatleBean);
    }
    //电影详情
    interface IDetail extends Baseinteface{
         void ok(DetilBean detilBean);
         void no(String msg);
    }
    //查询区域列表
    interface IRegionListView extends Baseinteface{
        void regionSuccess(RegionListBean regionListBean);
        void cinemaByRegionSuccess(CinemaByRegionBean cinemaByRegionBean);
    }
    //地址
    interface docindizhi extends Baseinteface{
         void success(CindizhiBean bean);
    }
    //查询区域列表
    interface dotool extends Baseinteface{
         void success(ToolBean toolBean);
    }
    //区域查询
    interface doquyucx extends Baseinteface{
         void success(QuyuchaxBean bean);
    }
    //日期
    interface doday extends Baseinteface{
         void success(DayBean bean);
    }
    //电影明细
    interface domx extends Baseinteface{
         void success(CinemadetailsBean bean);
    }
    //模糊查询电影院
    interface domhmovey extends Baseinteface{
         void success(MhmoveyBean bean);
    }
    //注册
    interface doreg extends Baseinteface{
         void success(RegBean bean);
    }
    //验证码
    interface doyan extends Baseinteface{
         void success(YanzhengBean bean);
    }
}
