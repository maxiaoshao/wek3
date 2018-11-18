package com.example.wek3.view;

import android.content.Context;

import com.example.wek3.bean.News;

import java.util.List;

/**
 * Created by 轩少 on 2018/11/18.
 */

public interface IView<T> {
    void getCatgory(T t);

    void failed(Exception e);


}
