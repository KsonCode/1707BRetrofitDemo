package com.laoxu.a1707bretrofitdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.laoxu.a1707bretrofitdemo.R;
import com.laoxu.a1707bretrofitdemo.entity.ClsEntity;

import java.util.List;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.MyViewHolder> {

    private Context context;
    private List<ClsEntity.Cls.Category> categoryList;

    public LeftAdapter(Context context, List<ClsEntity.Cls.Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.left_item_layout,null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv.setText(categoryList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                leftClick.leftItemClick(categoryList.get(position).id);

            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }

    private LeftClick leftClick;

    public void setLeftClick(LeftClick leftClick) {
        this.leftClick = leftClick;
    }

    public interface LeftClick{
        void leftItemClick(String id);
    }
}
