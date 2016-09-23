package com.zykj.phmall.activity;

import android.view.View;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.MyPropertyPresenter;

import butterknife.OnClick;

/**
 * Created by 徐学坤 on 2016/9/21.
 */
public class MyPropertyActivity extends ToolBarActivity<MyPropertyPresenter> {
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_myproperty;
    }

    @Override
    protected String provideTitle() {
        return "我的财产";
    }

    @Override
    public MyPropertyPresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.ll_accountbalance, R.id.ll_cardbalance, R.id.ll_puscore, R.id.ll_huiscore, R.id.ll_repertoryscore, R.id.ll_voucher, R.id.ll_wallet})
    protected void message(View v) {
        switch (v.getId()) {
            case R.id.ll_accountbalance:
                startActivity(AccountActivity.class);
                break;
            case R.id.ll_cardbalance:
                startActivity(PersonalSettingActivity.class);
                break;
            case R.id.ll_puscore:
                startActivity(PuScoreActivity.class);
                break;
            case R.id.ll_huiscore:
                startActivity(ManagerActivity.class);
                break;
            case R.id.ll_repertoryscore:
                startActivity(CashActivity.class);
                break;
            case R.id.ll_voucher:
                startActivity(MyStoresActivity.class);
                break;
            case R.id.ll_wallet:
                startActivity(MyPropertyActivity.class);
                break;
        }

    }
}
