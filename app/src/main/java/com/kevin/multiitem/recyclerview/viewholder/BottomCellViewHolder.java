package com.kevin.multiitem.recyclerview.viewholder;

import android.view.View;
import android.widget.TextView;

import com.kevin.multiitem.R;
import com.kevin.multiitem.recyclerview.OnBottomCellClickListener;
import com.kevin.multiitem.recyclerview.bean.BottemCellBean;

public class BottomCellViewHolder extends BaseViewHolder<BottemCellBean> {
    private OnBottomCellClickListener mListener;
    private boolean isShowAllClick = false;

    public BottomCellViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindViewData(final BottemCellBean data) {
        final TextView textView = getView(R.id.tv_bottom);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (data.getType()) {
                    case 1:
                        bottomCellClick(data, textView, 1);
                        break;
                    case 2:
                        bottomCellClick(data, textView, 2);
                        break;
                }

            }
        });
    }

    private void bottomCellClick(BottemCellBean data, TextView textView, int type) {
        if (data.getClick() != null) {
            if (!isShowAllClick) {
                textView.setText("收起");
                data.getClick().onShowALLClick(type);
                isShowAllClick = true;
            } else {
                textView.setText("展开全部");
                data.getClick().onPackUpClick(type);
                isShowAllClick = false;
            }
        }
    }

}
