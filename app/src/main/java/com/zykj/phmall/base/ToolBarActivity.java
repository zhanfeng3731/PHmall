package com.zykj.phmall.base;

import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zykj.phmall.R;

/**
 * Created by csh
 * Created date 2016/8/30.
 * Description 标题
 */
public abstract class ToolBarActivity<P extends BasePresenter> extends BaseActivity<P> {
    protected Toolbar toolBar;
    protected ImageView iv_back;
    protected TextView tv_head;
    protected ImageView iv_col;
    protected TextView tv_edit;
    protected AppBarLayout appBar;
    private boolean mIsHidden = false;

    @Override
    protected void initAllMembersView() {
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        if (toolBar != null) {
            setSupportActionBar(toolBar);
            iv_back = (ImageView) findViewById(R.id.iv_back);
            tv_head = (TextView) findViewById(R.id.tv_head);
            iv_col = (ImageView) findViewById(R.id.iv_col);
            tv_edit = (TextView) findViewById(R.id.tv_edit);
            appBar = (AppBarLayout) findViewById(R.id.app_bar_layout);
            tv_head.setText(provideTitle());
            iv_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
}