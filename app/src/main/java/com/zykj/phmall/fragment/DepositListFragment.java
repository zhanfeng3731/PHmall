package com.zykj.phmall.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.zykj.phmall.R;
import com.zykj.phmall.adapter.DepositAdapter;
import com.zykj.phmall.base.SwipeRefreshFragment;
import com.zykj.phmall.beans.DataBean;
import com.zykj.phmall.presenter.DepositPresenter;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 预存款列表
 */
public class DepositListFragment extends SwipeRefreshFragment<DepositPresenter, DepositAdapter, DataBean> {

    public static DepositListFragment newInstance(int type) {
        Bundle args = new Bundle();
        DepositListFragment fragment = new DepositListFragment();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.ui_public_list;
    }

    @Override
    protected String provideTitle() {
        return null;
    }

    @Override
    public DepositPresenter createPresenter() {
        return new DepositPresenter();
    }

    @Override
    protected RecyclerView.LayoutManager provideLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    @Override
    protected DepositAdapter provideAdapter() {
        return new DepositAdapter(getContext());
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}