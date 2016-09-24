package com.zykj.phmall.activity;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.AddressUpdatePresenter;

/**
 * Created by 徐学坤 on 2016/9/23.
 */
public class AddressUpdateActivity extends ToolBarActivity<AddressUpdatePresenter> {
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_addressupdate;
    }

    @Override
    protected String provideTitle() {
        return "地址管理";
    }

    @Override
    public AddressUpdatePresenter createPresenter() {
        return null;
    }
}
