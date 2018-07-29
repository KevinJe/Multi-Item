package com.kevin.multiitem.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.kevin.multiitem.recyclerview.viewholder.BaseViewHolder;

import java.util.List;

public class MultiRecyclerAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    List<Visitable> mData;
    TypeFactory typeFactory;

    public MultiRecyclerAdapter(List<Visitable> data) {
        mData = data;
        typeFactory = new ItemTypeFactory();
    }
    public void setData(List<Visitable> data) {
        mData = data;
        notifyDataSetChanged();
    }
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return typeFactory.createViewHolder(viewType, view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bindViewData(mData.get(position));
    }
    @Override
    public int getItemViewType(int position) {
        return mData.get(position).type(typeFactory);
    }

    @Override
    public int getItemCount() {
        return (mData != null ? mData.size() : 0);
    }
}
