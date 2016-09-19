package com.zykj.phmall.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.zykj.phmall.R;
import com.zykj.phmall.adapter.CateAdapter;
import com.zykj.phmall.base.RecycleViewFragment;
import com.zykj.phmall.beans.DataBean;
import com.zykj.phmall.presenter.CatePresenter;

/**
 * Created by csh
 * Created date 2016/9/14.
 * Description 首页
 */
public class CateFragment extends RecycleViewFragment<CatePresenter,CateAdapter,DataBean> {
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_fragment_cate;
    }

    @Override
    protected String provideTitle() {
        return "分类";
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
    protected CateAdapter provideAdapter() {
        return new CateAdapter(getContext(), false);
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}