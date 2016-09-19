package com.zykj.phmall.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zykj.phmall.R;
import com.zykj.phmall.presenter.ListPresenter;

import java.util.List;

/**
 * Created by csh
 * Created date 2016/9/1.
 * Description
 */
public abstract class SwipeRefreshActivity<P extends ListPresenter, A extends BaseAdapter, M> extends RecycleViewActivity<P,A,M>{

    SwipeRefreshLayout mSwipeRefreshWidget;

    public int page = 1;
    public int count = 10;

    @Override
    protected void initAllMembersView() {
        super.initAllMembersView();
        mSwipeRefreshWidget = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh_widget);
        if (mSwipeRefreshWidget != null) {
            mSwipeRefreshWidget.setColorSchemeResources(R.color.refresh_progress_3,
                    R.color.refresh_progress_2, R.color.refresh_progress_1);
            mSwipeRefreshWidget.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    requestDataRefresh();
                }
            });
        }
        if (layoutManager instanceof LinearLayoutManager) {
            recyclerView.addOnScrollListener(mOnScrollListener);
        }
        presenter.getList(rootView, page, count);
        //mSwipeRefreshWidget.setRefreshing(true);
        //setProgressViewOffset(false, 0, ToolsUtils.dp2px(getContext(), 24));
    }

    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {

        private int lastVisibleItem;

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if(layoutManager instanceof LinearLayoutManager){
                lastVisibleItem = ((LinearLayoutManager)layoutManager).findLastVisibleItemPosition();
            }
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE
                    && lastVisibleItem + 1 == adapter.getItemCount()
                    && adapter.isShowFooter()) {
                //加载更多
                //LogUtils.d(TAG, "loading more data");
                //mNewsPresenter.loadNews(mType, pageIndex + Urls.PAZE_SIZE);
                loadData();
                //mNewsPresenter.loadOrder(mType, pageIndex + 20);
            }
        }
    };

    public void requestDataRefresh() {
        page = 1;
        presenter.getList(rootView, page, count);
    }

    @Override
    public void loadData() {
        page++;
        presenter.getList(rootView, page, count);
    }

    @Override
    public void addNews(List<M> data, int recordcount) {
        adapter.addDatas(data, page);
        if(adapter.mData.size() >= recordcount){
            adapter.setShowFooter(false);
        }
    }

    public void showProgress() {
        mSwipeRefreshWidget.setRefreshing(true);
    }

    public void hideProgress() {
        mSwipeRefreshWidget.setRefreshing(false);
    }
}