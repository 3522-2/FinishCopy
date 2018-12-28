package com.example.yuan.RecycleView;

/**
 * create by YUAN
 * on 2018/12/25
 */
import android.content.ClipData;
import android.support.annotation.NonNull;
 import android.support.v7.widget.RecyclerView;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.ImageView;
 import android.widget.TextView;

import com.example.yuan.R;

import java.util.List;

       public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ItemHolder> {

            private List<Item> mItems;






           public RecycleViewAdapter(List<Item> mData) {
           }

           @Override
    public int getItemCount() {
                 return mItems.size();
             }

             @Override
     public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
                 //设置Item图片
                 holder.image.setImageResource(mItems.get(position).getImageResId());
                 //设置Item文字
                 holder.title.setText(mItems.get(position).getTitle());
             }

            @NonNull
            @Override
     public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                 return new ItemHolder(LayoutInflater
                                 .from(parent.getContext()).inflate(R.layout.item, parent, false));
             }

             class ItemHolder extends RecyclerView.ViewHolder {

                 ImageView image;
         TextView title;

                 ItemHolder(View item) {
                         super(item);
                         image = item.findViewById(R.id.image_view);
                         title = item.findViewById(R.id.text_title);
                    }
    }
 }
