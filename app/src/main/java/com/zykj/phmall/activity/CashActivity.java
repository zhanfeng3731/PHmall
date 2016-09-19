package com.zykj.phmall.activity;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.CashPresenter;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 线下收银
 */
public class CashActivity extends ToolBarActivity<CashPresenter> {
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_cash;
    }

    @Override
    protected String provideTitle() {
        return "线下收银";
    }

    @Override
    public CashPresenter createPresenter() {
        return null;
    }
}