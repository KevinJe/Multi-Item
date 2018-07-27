package com.nebula.multiitem.recyclerview.bean;

import com.nebula.multiitem.recyclerview.TypeFactory;
import com.nebula.multiitem.recyclerview.Visitable;

public class DividerBean implements Visitable {

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }
}
