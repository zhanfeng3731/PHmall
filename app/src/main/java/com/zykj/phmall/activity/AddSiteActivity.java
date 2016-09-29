package com.zykj.phmall.activity;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.AddSitePresenter;

/**
 * Created by 徐学坤 on 2016/9/20.
 */
public class AddSiteActivity extends ToolBarActivity<AddSitePresenter> {
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_addsite;
    }

    @Override
    protected String provideTitle() {
        return "新增地址";
    }

    @Override
    public AddSitePresenter createPresenter() {
        return null;
    }
}
