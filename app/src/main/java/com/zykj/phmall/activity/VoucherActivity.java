package com.zykj.phmall.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zykj.phmall.R;
import com.zykj.phmall.adapter.VoucherAdapter;
import com.zykj.phmall.base.SwipeRefreshActivity;
import com.zykj.phmall.beans.DataBean;
import com.zykj.phmall.presenter.VoucherPresenter;

import butterknife.OnClick;

/**
 * Created by 徐学坤 on 2016/9/24.
 */
public class VoucherActivity extends SwipeRefreshActivity<VoucherPresenter, VoucherAdapter, DataBean> {

    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_voucher;
    }

    @Override
    protected String provideTitle() {
        return "店铺代金券";
    }

    @Override
    protected VoucherAdapter provideAdapter() {
        return new VoucherAdapter(getContext());
    }

    @Override
    public VoucherPresenter createPresenter() {
        return new VoucherPresenter();
    }

    @Override
    protected RecyclerView.LayoutManager provideLayoutManager() {
        return new LinearLayoutManager(this);
    }

    @OnClick({R.id.ll_getdisc})
    protected void message(View v) {
        switch (v.getId()) {
            case R.id.ll_getdisc:
                startActivity(GetVoucherActivity.class);
                break;
        }
    }

    @Override
    public void onItemClick(View view, int position) {

    }

}
