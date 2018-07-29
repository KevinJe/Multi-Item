package com.kevin.multiitem.recyclerview.viewholder;

import android.view.View;
import android.widget.TextView;

import com.kevin.multiitem.R;
import com.kevin.multiitem.recyclerview.bean.ContentBean;

public class ContentViewHolder extends BaseViewHolder<ContentBean> {


    public ContentViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindViewData(ContentBean data) {
        TextView textView = (TextView) getView(R.id.tv_content);
        textView.setText(data.getContent());
    }
}
