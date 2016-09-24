package com.zykj.phmall.activity;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.CardBalancePresenter;

/**
 * Created by 徐学坤 on 2016/9/22.
 */
public class CardBalanceActivity extends ToolBarActivity<CardBalancePresenter> {


    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_cardbalance;
    }

    @Override
    protected String provideTitle() {
        return "充值卡余额";
    }

    @Override
    public CardBalancePresenter createPresenter() {
        return null;
    }
}
