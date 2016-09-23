package com.zykj.phmall.activity;

import android.view.View;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.MyStoresPresenter;

import butterknife.OnClick;

/**
 * Created by 徐学坤 on 2016/9/21.
 */
public class MyStoresActivity extends ToolBarActivity<MyStoresPresenter> {
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_mystores;
    }

    @Override
    protected String provideTitle() {
        return "我要开店";
    }

    @Override
    public MyStoresPresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.tv_next})
    protected void message(View v) {
        switch (v.getId()) {
            case R.id.tv_next:
                startActivity(MyStoressActivity.class);
                break;

        }
    }
}
