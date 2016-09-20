package com.zykj.phmall.activity;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.ManagerPresenter;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 积分管理
 */
public class ManagerActivity extends ToolBarActivity<ManagerPresenter> {
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
}