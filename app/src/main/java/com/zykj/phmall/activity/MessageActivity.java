package com.zykj.phmall.activity;

import android.content.Intent;
import android.view.View;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.fragment.MessagePresenter;

import butterknife.OnClick;

/**
 * Created by csh
 * Created date 2016/9/18.
 * Description
 */
public class MessageActivity extends ToolBarActivity<MessagePresenter>{
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_message;
    }

    @Override
    protected String provideTitle() {
        return "消息中心";
    }

    @Override
    public MessagePresenter createPresenter() {
        return new MessagePresenter();
    }

    @OnClick({R.id.ll_message1,R.id.ll_message2,R.id.ll_message3,R.id.ll_message4})
    protected void message(View v){
        switch (v.getId()){
            case R.id.ll_message1:
                break;
            case R.id.ll_message2:
                startActivity(new Intent(this,MessageListActivity.class).putExtra("title","交易信息"));
                break;
            case R.id.ll_message3:
                break;
            case R.id.ll_message4:
                break;
        }
    }
}