package com.nebula.multiitem.recyclerview;

import android.view.View;

import com.nebula.multiitem.R;
import com.nebula.multiitem.recyclerview.bean.BottemCellBean;
import com.nebula.multiitem.recyclerview.bean.ContentBean;
import com.nebula.multiitem.recyclerview.bean.DividerBean;
import com.nebula.multiitem.recyclerview.bean.FooterBean;
import com.nebula.multiitem.recyclerview.bean.HeaderBean;
import com.nebula.multiitem.recyclerview.bean.SearchBean;
import com.nebula.multiitem.recyclerview.viewholder.BaseViewHolder;
import com.nebula.multiitem.recyclerview.viewholder.BottomCellViewHolder;
import com.nebula.multiitem.recyclerview.viewholder.ContentViewHolder;
import com.nebula.multiitem.recyclerview.viewholder.DividerViewHolder;
import com.nebula.multiitem.recyclerview.viewholder.FooterViewHolder;
import com.nebula.multiitem.recyclerview.viewholder.HeaderViewHolder;
import com.nebula.multiitem.recyclerview.viewholder.SearchViewHolder;


public class ItemTypeFactory implements TypeFactory {
    public static final int CONTENT_ITEM_LAYOUT = R.layout.item_content;
    public static final int DIVIDER_ITEM_LAYOUT = R.layout.item_divider;
    public static final int SEARCH_ITEM_LAYOUT = R.layout.item_search;
    public static final int BOTTOM_ITEM_LAYOUT = R.layout.item_bottom_cell;
    public static final int HEADER_ITEM_LAYOUT = R.layout.item_header;
    public static final int FOOTER_ITEM_LAYOUT = R.layout.item_footer;

    @Override
    public int type(ContentBean courseBean) {
        return CONTENT_ITEM_LAYOUT;
    }


    @Override
    public int type(DividerBean taskBean) {
        return DIVIDER_ITEM_LAYOUT;
    }

    @Override
    public int type(SearchBean searchBean) {
        return SEARCH_ITEM_LAYOUT;
    }

    @Override
    public int type(BottemCellBean bottemCellBean) {
        return BOTTOM_ITEM_LAYOUT;
    }

    @Override
    public int type(HeaderBean headerBean) {
        return HEADER_ITEM_LAYOUT;
    }

    @Override
    public int type(FooterBean footerBean) {
        return FOOTER_ITEM_LAYOUT;
    }


    @Override
    public BaseViewHolder createViewHolder(int type, View itemView) {
        switch (type) {
            case CONTENT_ITEM_LAYOUT:
                return new ContentViewHolder(itemView);
            case DIVIDER_ITEM_LAYOUT:
                return new DividerViewHolder(itemView);
            case SEARCH_ITEM_LAYOUT:
                return new SearchViewHolder(itemView);
            case BOTTOM_ITEM_LAYOUT:
                return new BottomCellViewHolder(itemView);
            case HEADER_ITEM_LAYOUT:
                return new HeaderViewHolder(itemView);
            case FOOTER_ITEM_LAYOUT:
                return new FooterViewHolder(itemView);
            default:
                return null;
        }
    }


}
