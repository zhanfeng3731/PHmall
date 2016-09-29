package com.zykj.phmall.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.zykj.phmall.R;
import com.zykj.phmall.adapter.DepositAdapter;
import com.zykj.phmall.base.DividerItemDecoration;
import com.zykj.phmall.base.SwipeRefreshActivity;
import com.zykj.phmall.beans.FundBean;
import com.zykj.phmall.presenter.DepositPresenter;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 预存款账户
 */
public class DepositActivity extends SwipeRefreshActivity<DepositPresenter, DepositAdapter, FundBean> implements OnClickListener{

    private View tv_left;//账户余额
    private View tv_middle;//充值明细
    private View tv_right;//余额提现

    private View header;

    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_list;
    }

    @Override
    protected String provideTitle() {
        return "预存款账户";
    }

    @Override
    public DepositPresenter createPresenter() {
        return new DepositPresenter(R.id.tv_left);//0-账户余额 1-充值明细 2-余额提现
    }

    @Override
    protected DepositAdapter provideAdapter() {
        header = getLayoutInflater().inflate(R.layout.ui_activity_deposit, null);
        return new DepositAdapter(this, header);
    }

    @Override
    protected RecyclerView.LayoutManager provideLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    @Override
    protected RecyclerView.ItemDecoration provideItemDecoration() {
        return new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
    }

    @Override
    protected void initAllMembersView() {
        super.initAllMembersView();
        tv_left = header.findViewById(R.id.tv_left);
        tv_middle = header.findViewById(R.id.tv_middle);
        tv_right = header.findViewById(R.id.tv_right);
        tv_left.setSelected(true);
        tv_left.setOnClickListener(this);
        tv_middle.setOnClickListener(this);
        tv_right.setOnClickListener(this);
        TextView tv_point = (TextView)header.findViewById(R.id.tv_point);
        presenter.getPoint(rootView, tv_point);
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onClick(View v) {
        if(presenter.getType() != v.getId()){
            presenter.setType(v.getId());
            tv_left.setSelected(v.getId() == R.id.tv_left);
            tv_middle.setSelected(v.getId() == R.id.tv_middle);
            tv_right.setSelected(v.getId() == R.id.tv_right);
            adapter.setType(v.getId());
            presenter.getList(rootView, page, count);
        }
    }
}