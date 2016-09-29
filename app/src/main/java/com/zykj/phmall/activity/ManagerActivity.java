package com.zykj.phmall.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zykj.phmall.R;
import com.zykj.phmall.adapter.ManagerAdapter;
import com.zykj.phmall.base.SwipeRefreshActivity;
import com.zykj.phmall.beans.DataBean;
import com.zykj.phmall.presenter.ManagerPresenter;


/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 积分管理
 */
public class ManagerActivity extends SwipeRefreshActivity<ManagerPresenter, ManagerAdapter, DataBean> {

    @Override
    protected RecyclerView.LayoutManager provideLayoutManager() {
        return new LinearLayoutManager(this);
    }

    @Override
    protected ManagerAdapter provideAdapter() {
        return new ManagerAdapter(getContext());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_manager;
    }

    @Override
    protected String provideTitle() {
        return "惠积分";
    }

    @Override
    public ManagerPresenter createPresenter() {
        return new ManagerPresenter();
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}