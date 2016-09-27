package com.zykj.phmall.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zykj.phmall.R;
import com.zykj.phmall.adapter.WalletAdapter;
import com.zykj.phmall.base.SwipeRefreshActivity;
import com.zykj.phmall.beans.DataBean;
import com.zykj.phmall.presenter.WalletPresenter;

import butterknife.OnClick;

/**
 * Created by 徐学坤 on 2016/9/27.
 */
public class WalletActivity extends SwipeRefreshActivity<WalletPresenter, WalletAdapter, DataBean> {
    @Override
    protected RecyclerView.LayoutManager provideLayoutManager() {
        return new LinearLayoutManager(this);
    }

    @Override
    protected WalletAdapter provideAdapter() {
        return new WalletAdapter(getContext());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_wallet;
    }

    @Override
    protected String provideTitle() {
        return "平台红包";
    }

    @Override
    public WalletPresenter createPresenter() {
        return new WalletPresenter();
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @OnClick({R.id.ll_getwlt})
    protected void message(View v) {
        switch (v.getId()) {
            case R.id.ll_getwlt:
                startActivity(GetWalletActivity.class);
                break;
        }
    }
}
