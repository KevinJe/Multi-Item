package com.kevin.multiitem.recyclerview.viewholder;

import android.view.View;
import android.widget.EditText;

import com.kevin.multiitem.R;
import com.kevin.multiitem.recyclerview.bean.SearchBean;

public class SearchViewHolder extends BaseViewHolder<SearchBean> {

    public SearchViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindViewData(SearchBean data) {
        EditText editText = (EditText) getView(R.id.et_search);
        editText.setText(data.getContent());
    }
}
