package com.zykj.phmall.activity;

import com.zykj.phmall.R;
import com.zykj.phmall.base.BasePresenter;
import com.zykj.phmall.base.ToolBarActivity;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 预存款账户
 */
public class DepositActivity extends ToolBarActivity<BasePresenter> {

    private DepositListFragment leftFragment;         //账户余额
    private DepositListFragment middleFragment;       //充值明细
    private DepositListFragment rightFragment;        //余额提现

    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_deposit;
    }

    @Override
    protected String provideTitle() {
        return "预存款账户";
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}