package com.zykj.phmall.base;

import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zykj.phmall.R;
import com.zykj.phmall.activity.MainActivity;

/**
 * Created by csh
 * Created date 2016/8/27.
 * Description 标题Fragment
 */
public abstract class ToolBarFragment<P extends BasePresenter> extends BaseFragment<P> {
    protected Toolbar toolBar;
    protected ImageView iv_back;
    protected TextView tv_head;
    protected ImageView iv_col;
    protected TextView tv_edit;
    protected AppBarLayout appBar;

    @Override
    protected void initAllMembersView(View view) {
        toolBar = (Toolbar) view.findViewById(R.id.toolbar);
        if(toolBar != null){
            ((MainActivity)getActivity()).setSupportActionBar(toolBar);
            iv_back = (ImageView) view.findViewById(R.id.iv_back);
            tv_head = (TextView) view.findViewById(R.id.tv_head);
            iv_col = (ImageView) view.findViewById(R.id.iv_col);
            tv_edit = (TextView) view.findViewById(R.id.tv_edit);
            appBar = (AppBarLayout) view.findViewById(R.id.app_bar_layout);
            tv_head.setText(provideTitle());
        }
    }
}