package com.zykj.phmall.activity;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.GetVoucherPresenter;

/**
 * Created by 徐学坤 on 2016/9/26.
 */
public class GetVoucherActivity extends ToolBarActivity<GetVoucherPresenter> {
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_getvoucher;
    }

    @Override
    protected String provideTitle() {
        return "店铺代金券";
    }

    @Override
    public GetVoucherPresenter createPresenter() {
        return null;
    }
}
