package com.zykj.phmall.activity;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.PuScorePresenter;

/**
 * Created by 徐学坤 on 2016/9/21.
 */
public class PuScoreActivity extends ToolBarActivity<PuScorePresenter> {
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_puscore;
    }

    @Override
    protected String provideTitle() {
        return "普积分";
    }

    @Override
    public PuScorePresenter createPresenter() {
        return null;
    }
}
