package com.zykj.phmall.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zykj.phmall.R;
import com.zykj.phmall.adapter.AddressAdapter;
import com.zykj.phmall.base.RecycleViewActivity;
import com.zykj.phmall.beans.AddressBean;
import com.zykj.phmall.presenter.AddressManagePresenter;

import java.util.List;

import butterknife.OnClick;

/**
 * Created by 徐学坤 on 2016/9/20.
 */
public class AddressManageActivity extends RecycleViewActivity<AddressManagePresenter, AddressAdapter, AddressBean> {

    public int page = 1;

    @Override
    protected RecyclerView.LayoutManager provideLayoutManager() {
        return new LinearLayoutManager(this);
    }

    @Override
    protected AddressAdapter provideAdapter() {
        return new AddressAdapter(getContext());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_addressmanage;
    }

    @Override
    protected String provideTitle() {
        return "收货地址";
    }

    @Override
    public AddressManagePresenter createPresenter() {
        return new AddressManagePresenter();
    }


    @Override
    protected void initAllMembersView() {
        super.initAllMembersView();
        presenter.getList(rootView, page, 0);
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void addNews(List<AddressBean> data, int count) {
        adapter.addDatas(data, page);
        if (adapter.mData.size() >= count) {
            adapter.setShowFooter(false);
        }
    }

    @OnClick({R.id.ll_addnewaddress})
    protected void message(View v) {
        switch (v.getId()) {
            case R.id.ll_addnewaddress:
                startActivity(AddSiteActivity.class);
                break;
        }
    }
}
