package com.zykj.phmall.activity;

import android.content.Intent;
import android.view.View;

import com.zykj.phmall.R;
import com.zykj.phmall.base.BaseApp;
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

    @OnClick({R.id.ll_message1, R.id.ll_message3, R.id.ll_message4, R.id.tv_exit})
    protected void message(View v) {
        switch (v.getId()) {
            case R.id.ll_message1:
                /*登录密码*/
                Intent intent = new Intent(this, RegisterActivity.class);
                intent.putExtra("p", 2);
                startActivity(intent);
                break;
            case R.id.ll_message3:
                /*支付密码*/
                startActivity(new Intent(this, RegisterActivity.class).putExtra("p", 3));
                ;
                break;
            case R.id.ll_message4:
                startActivity(WithdrawActivity.class);
                break;
            case R.id.tv_exit:
                BaseApp.getModel().clear();
                startActivity(LoginActivity.class);
                finish();
                break;
        }
    }
}
