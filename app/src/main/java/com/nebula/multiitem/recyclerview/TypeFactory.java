package com.nebula.multiitem.recyclerview;

import android.view.View;

import com.nebula.multiitem.recyclerview.bean.BottemCellBean;
import com.nebula.multiitem.recyclerview.bean.ContentBean;
import com.nebula.multiitem.recyclerview.bean.DividerBean;
import com.nebula.multiitem.recyclerview.bean.FooterBean;
import com.nebula.multiitem.recyclerview.bean.HeaderBean;
import com.nebula.multiitem.recyclerview.bean.SearchBean;
import com.nebula.multiitem.recyclerview.viewholder.BaseViewHolder;

public interface TypeFactory {
    int type(ContentBean contentBean);

    int type(DividerBean dividerBean);

    int type(SearchBean searchBean);

    int type(BottemCellBean bottemCellBean);

    int type(HeaderBean headerBean);

    BaseViewHolder createViewHolder(int type, View itemView);

    int type(FooterBean footerBean);
}
