package com.zykj.phmall.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zykj.phmall.R;
import com.zykj.phmall.activity.ClassActivity;
import com.zykj.phmall.adapter.CateAdapter;
import com.zykj.phmall.base.RecycleViewFragment;
import com.zykj.phmall.beans.CateBean;
import com.zykj.phmall.presenter.CatePresenter;

/**
 * Created by csh
 * Created date 2016/9/14.
 * Description 分类
 */
public class CateFragment extends RecycleViewFragment<CatePresenter, CateAdapter, CateBean> {
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
        return new CateAdapter(getContext(), false, 0);
    }

    @Override
    protected void initAllMembersView(View view) {
        super.initAllMembersView(view);
        iv_back.setVisibility(View.GONE);
        loadData();
    }

    @Override
    public void onItemClick(View view, int position) {
        CateBean cate = adapter.mData.get(position);
        startActivity(new Intent(getContext(), ClassActivity.class)
                .putExtra("title", cate.gc_name)
                .putExtra("id", cate.gc_id));
    }
}