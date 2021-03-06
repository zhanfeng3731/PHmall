package com.zykj.phmall.activity;

import android.view.View;
import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.AccountPresenter;

import butterknife.OnClick;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 账户余额
 */
public class AccountActivity extends ToolBarActivity<AccountPresenter>{

    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_account;
    }

    @Override
    protected String provideTitle() {
        return "账户余额";
    }

    @Override
    public AccountPresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.ll_message1,R.id.ll_message2,R.id.ll_message3})
    protected void message(View v){
        switch (v.getId()){
            case R.id.ll_message1:
                startActivity(DepositActivity.class);
                break;
            case R.id.ll_message2:
                startActivity(RechargeActivity.class);
                break;
            case R.id.ll_message3:
                startActivity(WithdrawActivity.class);
                break;
        }
    }
}