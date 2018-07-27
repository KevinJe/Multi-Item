package com.nebula.multiitem.recyclerview.viewholder;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.nebula.multiitem.R;
import com.nebula.multiitem.recyclerview.OnBottomCellClick;
import com.nebula.multiitem.recyclerview.bean.BottemCellBean;

public class BottomCellViewHolder extends BaseViewHolder<BottemCellBean> {
    private OnBottomCellClick cellClick;

    public BottomCellViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindViewData(BottemCellBean data) {
        TextView textView = (TextView) getView(R.id.tv_bottom);
        textView.setText(data.getContent());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cellClick != null) {
                    cellClick.onCellClick();
                    Log.d("BottomCell ", "onClick: ");
                }
            }
        });
    }

}
