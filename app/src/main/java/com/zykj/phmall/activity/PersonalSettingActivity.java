package com.zykj.phmall.activity;

import android.view.View;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.PersonalSettingPresenter;

import butterknife.OnClick;

/**
 * Created by 徐学坤 on 2016/9/20.
 */
public class PersonalSettingActivity extends ToolBarActivity<PersonalSettingPresenter> {
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_personalsetting;
    }

    @Override
    protected String provideTitle() {
        return "个人设置";
    }

    @Override
    public PersonalSettingPresenter createPresenter() {
        return new PersonalSettingPresenter();
    }

    @OnClick({R.id.ll_message1, R.id.ll_message2, R.id.ll_message3, R.id.ll_message4, R.id.tv_exit})
    protected void message(View v) {
        switch (v.getId()) {
            case R.id.ll_message1:
                startActivity(DepositActivity.class);
                break;
            case R.id.ll_message2:
                startActivity(RechargeActivity.class);
                break;
            case R.id.ll_message3:
                startActivity(WithdrawActivity.class);
                break;
            case R.id.ll_message4:
                startActivity(WithdrawActivity.class);
                break;
            case R.id.tv_exit:
                startActivity(WithdrawActivity.class);
                break;
        }
    }
}
