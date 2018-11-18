package com.example.wek3.model;

import com.example.wek3.net.HttpUtils;
import com.example.wek3.net.ICallBack;

import java.lang.reflect.Type;

/**
 * Created by 轩少 on 2018/11/18.
 */

public class NewsModel {
    public  void getData(String url, ICallBack callBack, Type type){
        HttpUtils.getInstance().get(url,callBack,type);
    }
}
