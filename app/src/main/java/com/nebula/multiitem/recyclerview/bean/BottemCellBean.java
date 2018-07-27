package com.nebula.multiitem.recyclerview.bean;

import com.nebula.multiitem.recyclerview.TypeFactory;
import com.nebula.multiitem.recyclerview.Visitable;

public class BottemCellBean implements Visitable {
    private String content;

    public BottemCellBean(String content) {
        this.content = content;
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
