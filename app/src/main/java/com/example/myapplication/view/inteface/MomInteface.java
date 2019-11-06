package com.example.myapplication.view.inteface;

import com.example.myapplication.base.Baseinteface;
import com.example.myapplication.model.bean.LoginBean;

/*
 *@Auther:刘炳良
 *@Date: 时间
 *@Description:功能
 * */public interface MomInteface  {
     interface dologin extends Baseinteface{
         void success(LoginBean bean);
     }
}
