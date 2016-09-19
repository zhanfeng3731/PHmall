package com.zykj.phmall.activity;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.ScorePresenter;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 我的积分
 */
public class ScoreActivity extends ToolBarActivity<ScorePresenter> {
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_score;
    }

    @Override
    protected String provideTitle() {
        return "我的积分";
    }

    @Override
    public ScorePresenter createPresenter() {
        return null;
    }
}