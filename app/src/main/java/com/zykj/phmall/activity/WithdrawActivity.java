package com.zykj.phmall.activity;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.WithdrawPresenter;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 申请提现
 */
public class WithdrawActivity extends ToolBarActivity<WithdrawPresenter> {
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_withdraw;
    }

    @Override
    protected String provideTitle() {
        return "申请提现";
    }

    @Override
    public WithdrawPresenter createPresenter() {
        return new WithdrawPresenter();
    }
}