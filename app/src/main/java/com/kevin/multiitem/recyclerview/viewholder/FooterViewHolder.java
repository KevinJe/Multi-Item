package com.kevin.multiitem.recyclerview.viewholder;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.kevin.multiitem.R;
import com.kevin.multiitem.recyclerview.SecondActivity;
import com.kevin.multiitem.recyclerview.bean.FooterBean;

public class FooterViewHolder extends BaseViewHolder<FooterBean> {


    public FooterViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindViewData(FooterBean data) {
        final TextView footerView = getView(R.id.footer_view);
        footerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(footerView.getContext(), SecondActivity.class);
                footerView.getContext().startActivity(intent);
            }
        });
    }
}
