package com.example.wek3.activity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.wek3.R;
import com.example.wek3.bean.News;
import com.example.wek3.adapter.MyAdapter;
import com.example.wek3.persent.NPersent;
import com.example.wek3.view.IView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IView<News> {

    private ImageView img;
    private ImageView img1;
    private RecyclerView rv;
    private List<News.DataBean> list;
    private MyAdapter adapter;
    private NPersent nPersent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        list = new ArrayList<>();
        adapter = new MyAdapter(list,this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


    }

    private void initData() {
         nPersent = new NPersent();
         nPersent.attach(this);
         nPersent.getCatgory();
         //list = new ArrayList<>();
         //adapter = new MyAdapter(list,this);
         //rv.setAdapter(adapter);
         //rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }


    private void initView() {
        img = findViewById(R.id.img);
        img1 = findViewById(R.id.img1);
        rv = findViewById(R.id.rv);
        img.setOnClickListener(this);
        img1.setOnClickListener(this);;

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img:
                if(true) {
                    img.setImageResource(R.drawable.s2);
                    Animator dh = AnimatorInflater.loadAnimator(this, R.animator.objectanimator);
                    dh.setTarget(img);
                    dh.start();
                }else {
                    img.setImageResource(R.drawable.s1);
                    Animator dh = AnimatorInflater.loadAnimator(this, R.animator.objectanimator);
                    dh.setTarget(img);
                    dh.start();
            }
               break;


        }
    }




    @Override
    public void getCatgory(News news) {
        List<News.DataBean> data = news.getData();
        if(data!=null){
            list.clear();

            list.addAll(data);

            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void failed(Exception e) {
        Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        HttpUtils =null;
    }
}
