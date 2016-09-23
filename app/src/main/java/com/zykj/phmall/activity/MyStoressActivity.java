package com.zykj.phmall.activity;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.MyStoressPresenter;

/**
 * Created by 徐学坤 on 2016/9/21.
 */
public class MyStoressActivity extends ToolBarActivity<MyStoressPresenter> {
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_mystoress;
    }

    @Override
    protected String provideTitle() {
        return "我要开店";
    }

    @Override
    public MyStoressPresenter createPresenter() {
        return null;
    }
}
