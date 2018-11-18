package com.example.wek3.persent;

import com.example.wek3.bean.News;
import com.example.wek3.model.NewsModel;
import com.example.wek3.net.ICallBack;
import com.example.wek3.view.IView;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by 轩少 on 2018/11/17.
 */

public class NPersent {
    private IView iv;
    private NewsModel mModel;
    public void attach(IView iv){
         this.iv = iv;
         mModel = new NewsModel();
    }
    public  void getCatgory(){
        Type type = new TypeToken<News>(){
        }.getType();
        String url = "http://www.xieast.com/api/news/news.php";
        mModel.getData(url, new ICallBack() {
            @Override
            public void onsucces(Object object) {
                iv.getCatgory(object);
            }

            @Override
            public void failed(Exception e) {
                iv.failed(e);
            }
        },type);
    }


}
