package com.zykj.phmall.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.zykj.phmall.R;
import com.zykj.phmall.adapter.NewsAdapter;
import com.zykj.phmall.base.SwipeRefreshActivity;
import com.zykj.phmall.beans.AnnounceBean;
import com.zykj.phmall.presenter.NewsPresenter;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 资讯中心
 */
public class NewsActivity extends SwipeRefreshActivity<NewsPresenter,NewsAdapter,AnnounceBean> {

    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_list;
    }

    @Override
    protected String provideTitle() {
        return "资讯中心";
    }

    @Override
    public NewsPresenter createPresenter() {
        return new NewsPresenter(1);
    }

    @Override
    protected RecyclerView.LayoutManager provideLayoutManager() {
        return new LinearLayoutManager(this);
    }

    @Override
    protected NewsAdapter provideAdapter() {
        return new NewsAdapter(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        AnnounceBean ann = adapter.mData.get(position);
        startActivity(new Intent(this, WebUrlActivity.class)
                .putExtra("title",ann.article_title).putExtra("url", ann.article_url));
    }
}