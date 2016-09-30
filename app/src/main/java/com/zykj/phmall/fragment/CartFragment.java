package com.zykj.phmall.fragment;

import android.view.View;

import com.zykj.phmall.R;
import com.zykj.phmall.base.BasePresenter;
import com.zykj.phmall.base.ToolBarFragment;
import com.zykj.phmall.beans.DataBean;
import com.zykj.phmall.presenter.HomePresenter;
import com.zykj.phmall.view.EntityView;

/**
 * Created by csh
 * Created date 2016/9/14.
 * Description 首页
 */
public class CartFragment extends ToolBarFragment<BasePresenter<EntityView<DataBean>>> {
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_fragment_cart;
    }

    @Override
    protected String provideTitle() {
        return "购物车";
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initAllMembersView(View view) {
        super.initAllMembersView(view);
        iv_back.setVisibility(View.GONE);
    }
}