package com.zykj.phmall.activity;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.MyInfoPresenter;

/**
 * Created by 徐学坤 on 2016/9/20.
 */
public class MyInfoActivity extends ToolBarActivity<MyInfoPresenter> {
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_myinfo;
    }

    @Override
    protected String provideTitle() {
        return "我的资料";
    }

    @Override
    public MyInfoPresenter createPresenter() {
        return null;
    }
}
