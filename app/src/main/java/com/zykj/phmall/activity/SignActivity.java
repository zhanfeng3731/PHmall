package com.zykj.phmall.activity;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.SignPresenter;

import butterknife.OnClick;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description
 */
public class SignActivity extends ToolBarActivity<SignPresenter>{
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_sign;
    }

    @Override
    protected String provideTitle() {
        return "每日签到";
    }

    @Override
    public SignPresenter createPresenter() {
        return null;
    }

    @OnClick(R.id.ll_score)
    protected void score(){
        startActivity(ScoreActivity.class);
    }
}