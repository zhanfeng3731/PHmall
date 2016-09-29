package com.zykj.phmall.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zykj.phmall.R;
import com.zykj.phmall.adapter.PuScoreAdapter;
import com.zykj.phmall.base.SwipeRefreshActivity;
import com.zykj.phmall.beans.DataBean;
import com.zykj.phmall.presenter.PuScorePresenter;

/**
 * Created by 徐学坤 on 2016/9/21.
 */
public class PuScoreActivity extends SwipeRefreshActivity<PuScorePresenter, PuScoreAdapter, DataBean> {

    @Override
    protected RecyclerView.LayoutManager provideLayoutManager() {
        return new LinearLayoutManager(this);
    }

    @Override
    protected PuScoreAdapter provideAdapter() {
        return new PuScoreAdapter(getContext());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_puscore;
    }

    @Override
    protected String provideTitle() {
        return "普积分";
    }

    @Override
    public PuScorePresenter createPresenter() {
        return new PuScorePresenter();
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
