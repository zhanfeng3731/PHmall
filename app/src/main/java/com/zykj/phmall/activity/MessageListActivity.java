package com.zykj.phmall.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.zykj.phmall.R;
import com.zykj.phmall.adapter.MessageAdapter;
import com.zykj.phmall.base.SwipeRefreshActivity;
import com.zykj.phmall.beans.DataBean;
import com.zykj.phmall.beans.MessageBean;
import com.zykj.phmall.presenter.MessagePresenter;

/**
 * Created by csh
 * Created date 2016/9/18.
 * Description 消息列表
 */
public class MessageListActivity extends SwipeRefreshActivity<MessagePresenter,MessageAdapter,MessageBean>{

    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_list;
    }

    @Override
    protected String provideTitle() {
        return "消息中心";
    }

    @Override
    public MessagePresenter createPresenter() {
        return new MessagePresenter();
    }

    @Override
    protected MessageAdapter provideAdapter() {
        return new MessageAdapter(getContext());
    }

    @Override
    protected RecyclerView.LayoutManager provideLayoutManager() {
        return new LinearLayoutManager(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        if("".equals(adapter.mData.get(position).url_type)){
            snb("余额");
        }else{
            snb("订单");
        }
    }
}