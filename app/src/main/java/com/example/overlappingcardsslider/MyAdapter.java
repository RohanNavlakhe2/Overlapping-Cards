package com.example.overlappingcardsslider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.overlappingcardsslider.bean.SlideBean;
import com.example.overlappingcardsslider.databinding.ItemSlideBinding;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterInner> {
    private ItemSlideBinding itemSlideBinding;
    private List<SlideBean> mList;

    public MyAdapter(List<SlideBean> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyAdapterInner onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemSlideBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.item_slide,parent,false);
         return new MyAdapterInner(itemSlideBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterInner holder, int position) {
        SlideBean bean = mList.get(position);
        holder.imgBg.setImageResource(bean.getItemBg());
        holder.tvTitle.setText(bean.getTitle());
        holder.userIcon.setImageResource(bean.getUserIcon());
        holder.userSay.setText(bean.getUserSay());
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class MyAdapterInner extends RecyclerView.ViewHolder {
        ImageView imgBg;
        ImageView userIcon;
        TextView tvTitle;
        TextView userSay;
        public MyAdapterInner(@NonNull View itemView) {
            super(itemView);

            imgBg = itemView.findViewById(R.id.img_bg);
            userIcon = itemView.findViewById(R.id.img_user);
            tvTitle = itemView.findViewById(R.id.tv_title);
            userSay = itemView.findViewById(R.id.tv_user_say);
        }
    }
}
