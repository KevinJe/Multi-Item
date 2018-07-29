package com.kevin.multiitem.recyclerview.bean;

import com.kevin.multiitem.recyclerview.OnBottomCellClickListener;
import com.kevin.multiitem.recyclerview.TypeFactory;
import com.kevin.multiitem.recyclerview.Visitable;

public class BottemCellBean implements Visitable {
    private String content;
    private OnBottomCellClickListener mListener;
    private int type;


    public BottemCellBean(int type ,OnBottomCellClickListener listener) {
        this.type = type;
        this.mListener = listener;
    }

    public BottemCellBean(String content, OnBottomCellClickListener listener) {
        this.content = content;
        this.mListener = listener;
    }

    public OnBottomCellClickListener getClick() {
        return mListener;
    }

    public int getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }
}
