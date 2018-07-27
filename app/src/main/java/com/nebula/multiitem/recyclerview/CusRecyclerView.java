package com.nebula.multiitem.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.nebula.multiitem.R;

public class CusRecyclerView extends RecyclerView {
    private static final String TAG = "CusRecyclerView";
    // 头部View
    private View mHeaderView;
    // normal
    private static final int VIEW_TYPE_NORMAL = 0;
    // header
    private static final int VIEW_TYPE_HEADER = 100;
    // footer
    private static final int VIEW_TYPE_FOOTER = 200;
    //是否允许加载更多
    private boolean isCanLoadMore;
    // 是否允许点击重新加载
    private boolean isCanReLoadMore;
    // 底部View
    private View mFooterView;
    // BaseAdapter
    private BaseAdapter mAdapter;


    public CusRecyclerView(Context context) {
        this(context, null);
    }

    public CusRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CusRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //添加监听
        addOnScrollListener(mScrollListener);
    }

    /**
     * 添加头部View
     *
     * @param headerView
     */
    public void addHeaderView(View headerView) {
        mHeaderView = headerView;
    }

    /**
     * 移除头部View
     */
    public void removeHeaderView() {
        mHeaderView = null;
    }

    /**
     * 添加底部View
     *
     * @param footerView
     */
    public void addFooterView(View footerView) {
        this.mFooterView = footerView;
    }

    public void removeFooterView() {
        mFooterView = null;
    }


    @Override
    public void setAdapter(Adapter adapter) {
        if (adapter != null) {
            mAdapter = new BaseAdapter(adapter);
        }
        super.swapAdapter(mAdapter, true);
    }

    private OnScrollListener mScrollListener = new OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

    };


    private class BaseAdapter extends Adapter<ViewHolder> {
        private Adapter mAdapter;

        public BaseAdapter(Adapter adapter) {
            mAdapter = adapter;
        }

        @Override
        public int getItemViewType(int position) {
            if (mHeaderView != null && position == 0) {
                return VIEW_TYPE_HEADER;
            }
            if (mHeaderView != null && position == getItemCount() - 1) {
                return VIEW_TYPE_FOOTER;
            }
            return VIEW_TYPE_NORMAL;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == VIEW_TYPE_HEADER) {
                return createHeaderFooterViewHolder(mHeaderView);
            }
            if (viewType == VIEW_TYPE_FOOTER) {
                return createHeaderFooterViewHolder(mFooterView);
            }
            if (viewType == VIEW_TYPE_NORMAL) {
                return mAdapter.onCreateViewHolder(parent, getItemViewType(viewType));
            }
            return null;
        }

        /**
         * 创建头部以及底部的ViewHolder
         *
         * @param view
         * @return
         */
        private RecyclerView.ViewHolder createHeaderFooterViewHolder(View view) {
            return new RecyclerView.ViewHolder(view) {

            };
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            int viewType = getItemViewType(position);
            if (viewType == VIEW_TYPE_NORMAL) {
                if (mHeaderView != null) {
                    position--;
                }
                mAdapter.onBindViewHolder(holder, position);
            } else if (viewType == VIEW_TYPE_FOOTER) {
                showFooterView();
            }
        }

        @Override
        public int getItemCount() {
            int count = mAdapter.getItemCount();
            if (mHeaderView != null) {
                count++;
            }
            if (isCanLoadMore) {
                count++;
            }
            return count;
        }
    }

    private void showFooterView() {

    }


    public void notifyDataSetChanged() {
        getAdapter().notifyDataSetChanged();
    }

    public void notifyItemRemoved(int position) {
        getAdapter().notifyItemRemoved(position);
    }


}
