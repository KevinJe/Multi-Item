package com.nebula.multiitem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nebula.multiitem.recyclerview.CusRecyclerView;
import com.nebula.multiitem.recyclerview.OnBottomCellClick;
import com.nebula.multiitem.recyclerview.bean.BottemCellBean;
import com.nebula.multiitem.recyclerview.bean.ContentBean;
import com.nebula.multiitem.recyclerview.bean.DividerBean;
import com.nebula.multiitem.recyclerview.MultiRecyclerAdapter;
import com.nebula.multiitem.recyclerview.bean.FooterBean;
import com.nebula.multiitem.recyclerview.bean.HeaderBean;
import com.nebula.multiitem.recyclerview.bean.SearchBean;
import com.nebula.multiitem.recyclerview.Visitable;
import com.nebula.multiitem.recyclerview.viewholder.BottomCellViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnBottomCellClick {
    private List<Visitable> mDatas = new ArrayList<>();
    private MultiRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        List<Visitable> beans = new ArrayList<>();
        beans.add(new HeaderBean());
        beans.add(new SearchBean("这里可以输入搜索内容"));
        beans.add(new DividerBean());
        beans.add(new ContentBean("one"));
        beans.add(new ContentBean("one"));
        beans.add(new ContentBean("one"));
        beans.add(new DividerBean());
        beans.add(new ContentBean("two"));
        beans.add(new ContentBean("two"));
        beans.add(new ContentBean("two"));
        beans.add(new DividerBean());
        beans.add(new ContentBean("three"));
        beans.add(new ContentBean("three"));
        beans.add(new ContentBean("three"));
        beans.add(new DividerBean());
        beans.add(new ContentBean("four"));
        beans.add(new ContentBean("four"));
        beans.add(new ContentBean("four"));
        beans.add(new FooterBean());


        adapter = new MultiRecyclerAdapter(beans);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCellClick() {
        mDatas.add(new ContentBean("four"));
        mDatas.add(new ContentBean("four"));
        mDatas.add(new ContentBean("four"));
        mDatas.add(new ContentBean("four"));
        mDatas.add(new ContentBean("four"));
        mDatas.add(new ContentBean("four"));
        mDatas.add(new ContentBean("four"));
    }
}
