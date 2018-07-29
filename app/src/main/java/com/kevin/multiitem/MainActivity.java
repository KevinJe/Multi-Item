package com.kevin.multiitem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.kevin.multiitem.recyclerview.MultiRecyclerAdapter;
import com.kevin.multiitem.recyclerview.OnBottomCellClickListener;
import com.kevin.multiitem.recyclerview.Visitable;
import com.kevin.multiitem.recyclerview.bean.BottemCellBean;
import com.kevin.multiitem.recyclerview.bean.ContentBean;
import com.kevin.multiitem.recyclerview.bean.DividerBean;
import com.kevin.multiitem.recyclerview.bean.FooterBean;
import com.kevin.multiitem.recyclerview.bean.HeaderBean;
import com.kevin.multiitem.recyclerview.bean.SearchBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnBottomCellClickListener {
    private List<Visitable> mDatas = new ArrayList<>();
    private List<ContentBean> mContentList = new ArrayList<>();
    private List<ContentBean> mContentList1 = new ArrayList<>();
    private List<ContentBean> mContentList2 = new ArrayList<>();
    private MultiRecyclerAdapter adapter;
    private BottemCellBean mBottemCellBean;
    private BottemCellBean mBottemCellBean1;
    private boolean isFirstLoad = true;
    private boolean isPackUp = true;
    private boolean isShowAll = false;
    private int mType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        mDatas.add(new HeaderBean());
        mDatas.add(new SearchBean("这里可以输入搜索内容"));
        mDatas.add(new DividerBean());
        mContentList1.add(new ContentBean("one"));
        mContentList1.add(new ContentBean("one"));
        mContentList1.add(new ContentBean("one"));
        mContentList1.add(new ContentBean("one"));
        mContentList1.add(new ContentBean("one"));
        mDatas.addAll(mContentList1);
        if (mBottemCellBean1 == null) {
            mBottemCellBean1 = new BottemCellBean(1, this);
            mContentList2.add(new ContentBean("four"));
            mContentList2.add(new ContentBean("four"));
            mContentList2.add(new ContentBean("four"));
            mContentList2.add(new ContentBean("four"));
            mContentList2.add(new ContentBean("four"));
        }
        mDatas.add(mBottemCellBean1);
        mDatas.add(new DividerBean());
        mDatas.add(new ContentBean("two"));
        mDatas.add(new ContentBean("two"));
        mDatas.add(new ContentBean("two"));
        mDatas.add(new DividerBean());
        mDatas.add(new ContentBean("three"));
        mDatas.add(new ContentBean("three"));
        mDatas.add(new ContentBean("three"));
        mDatas.add(new DividerBean());
        mDatas.add(new ContentBean("four"));
        mDatas.add(new ContentBean("four"));
        mDatas.add(new ContentBean("four"));
        if (mBottemCellBean == null) {
            mBottemCellBean = new BottemCellBean(2, this);
            mContentList.add(new ContentBean("four"));
            mContentList.add(new ContentBean("four"));
            mContentList.add(new ContentBean("four"));
            mContentList.add(new ContentBean("four"));
            mContentList.add(new ContentBean("four"));
        }
        mDatas.add(mBottemCellBean);
        mDatas.add(new FooterBean());

        adapter = new MultiRecyclerAdapter(mDatas);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!isFirstLoad && !isPackUp && isShowAll) {
            if (mType == 1) {
                mDatas.removeAll(mContentList2);
                onShowALLClick(1);
            }else if (mType == 2) {
                mDatas.removeAll(mContentList);
                onShowALLClick(2);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        isFirstLoad = false;
    }

    @Override
    public void onShowALLClick(int type) {
        isPackUp = false;
        isShowAll = true;
        switch (type) {
            case 1:
                mDatas.remove(mBottemCellBean1);
                mDatas.addAll(3 + mContentList1.size(), mContentList2);
                mDatas.add(3 + mContentList1.size() + mContentList2.size(), mBottemCellBean1);
                mType = 1;
                break;
            case 2:
                mDatas.remove(mBottemCellBean);
                mDatas.addAll(mDatas.size() - 1, mContentList);
                mDatas.add(mDatas.size() - 1, mBottemCellBean);
                mType = 2;
                break;
        }


        adapter.notifyDataSetChanged();
        Toast.makeText(this, "你点击了加载更多", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPackUpClick(int type) {
        isPackUp = true;
        isShowAll = false;
        switch (type) {
            case 1:
                mDatas.remove(mBottemCellBean1);
                mDatas.removeAll(mContentList2);
                mDatas.add(3 + mContentList1.size(), mBottemCellBean1);
                break;
            case 2:
                mDatas.remove(mBottemCellBean);
                mDatas.removeAll(mContentList);
                mDatas.add(mDatas.size() - 1, mBottemCellBean);
                break;
        }
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "你点击了收起", Toast.LENGTH_SHORT).show();
    }
}
