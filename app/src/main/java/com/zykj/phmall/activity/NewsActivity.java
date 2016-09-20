package com.zykj.phmall.activity;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.NewsPresenter;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 资讯中心
 */
public class NewsActivity extends ToolBarActivity<NewsPresenter> {
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_news;
    }

    @Override
    protected String provideTitle() {
        return "资讯中心";
    }

    @Override
    public NewsPresenter createPresenter() {
        return new NewsPresenter();
    }
}