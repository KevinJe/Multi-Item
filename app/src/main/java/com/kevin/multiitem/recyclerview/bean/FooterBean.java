package com.kevin.multiitem.recyclerview.bean;

import com.kevin.multiitem.recyclerview.TypeFactory;
import com.kevin.multiitem.recyclerview.Visitable;

public class FooterBean implements Visitable {

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }
}
