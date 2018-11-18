package com.example.wek3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wek3.R;
import com.example.wek3.bean.News;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by 轩少 on 2018/11/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private List<News.DataBean> mList;
    private Context context;

    public MyAdapter(List<News.DataBean> list, Context context) {
        mList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, null, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyHolder holder, final int position) {
        ImageLoader.getInstance().displayImage(mList.get(position).getThumbnail_pic_s(),holder.imgs);
        holder.names.setText(mList.get(position).getAuthor_name());
        holder.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dele(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private Button b1;
        private TextView names;
        private ImageView imgs;

        public MyHolder(View itemView) {
            super(itemView);
            imgs = itemView.findViewById(R.id.imgs);
            names = itemView.findViewById(R.id.names);
            b1 =  itemView.findViewById(R.id.remove1);
        }
    }
    public void dele(int position){

        mList.remove(position);

        notifyItemRemoved(position);

        notifyItemChanged(position);

    }

}
