package com.example.myapplication.view.inteface;

import com.example.myapplication.base.Baseinteface;
import com.example.myapplication.model.bean.CinemaBean;
import com.example.myapplication.model.bean.LoginBean;

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
}
