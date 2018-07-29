package com.kevin.multiitem.recyclerview;

import android.view.View;

import com.kevin.multiitem.recyclerview.bean.BottemCellBean;
import com.kevin.multiitem.recyclerview.bean.ContentBean;
import com.kevin.multiitem.recyclerview.bean.DividerBean;
import com.kevin.multiitem.recyclerview.bean.FooterBean;
import com.kevin.multiitem.recyclerview.bean.HeaderBean;
import com.kevin.multiitem.recyclerview.bean.SearchBean;
import com.kevin.multiitem.recyclerview.viewholder.BaseViewHolder;

public interface TypeFactory {
    int type(ContentBean contentBean);

    int type(DividerBean dividerBean);

    int type(SearchBean searchBean);

    int type(BottemCellBean bottemCellBean);

    int type(HeaderBean headerBean);

    BaseViewHolder createViewHolder(int type, View itemView);

    int type(FooterBean footerBean);
}
