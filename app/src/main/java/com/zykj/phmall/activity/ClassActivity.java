package com.zykj.phmall.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zykj.phmall.R;
import com.zykj.phmall.adapter.CateAdapter;
import com.zykj.phmall.base.RecycleViewActivity;
import com.zykj.phmall.beans.CateBean;
import com.zykj.phmall.presenter.CatePresenter;

/**
 * Created by csh
 * Created date 2016/9/30.
 * Description 二级分类
 */

public class ClassActivity extends RecycleViewActivity<CatePresenter, CateAdapter, CateBean> {

    @Override
    protected int provideContentViewId() {
        return R.layout.ui_fragment_cate;
    }

    @Override
    protected CateAdapter provideAdapter() {
        return new CateAdapter(getContext(), false, 1);
    }

    @Override
    protected String provideTitle() {
        return getIntent().getStringExtra("title");
    }

    @Override
    public CatePresenter createPresenter() {
        return new CatePresenter();
    }

    @Override
    protected RecyclerView.LayoutManager provideLayoutManager() {
        return new GridLayoutManager(getContext(), 3);
    }

    @Override
    protected void initAllMembersView() {
        super.initAllMembersView();
        presenter.getSecond(rootView, getIntent().getStringExtra("id"));
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}