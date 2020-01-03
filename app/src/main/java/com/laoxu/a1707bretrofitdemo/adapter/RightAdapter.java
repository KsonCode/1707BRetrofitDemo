package com.laoxu.a1707bretrofitdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.laoxu.a1707bretrofitdemo.R;
import com.laoxu.a1707bretrofitdemo.entity.ClsEntity;
import com.laoxu.a1707bretrofitdemo.entity.RightEntity;

import java.util.List;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.MyViewHolder> {

    private Context context;
    private List<RightEntity.Right> list;

    public RightAdapter(Context context, List<RightEntity.Right> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.right_item_layout,null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv.setText(list.get(position).commodityName);

        Glide.with(context).load(list.get(position).masterPic)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.iv);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;
        private ImageView iv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            iv = itemView.findViewById(R.id.iv);
        }
    }

}
