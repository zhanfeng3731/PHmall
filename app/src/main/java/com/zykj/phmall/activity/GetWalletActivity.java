package com.zykj.phmall.activity;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.GetWalletPresenter;

/**
 * Created by 徐学坤 on 2016/9/23.
 */
public class GetWalletActivity extends ToolBarActivity<GetWalletPresenter> {
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_getwallet;
    }

    @Override
    protected String provideTitle() {
        return "领取平台红包";
    }

    @Override
    public GetWalletPresenter createPresenter() {
        return null;
    }
}
