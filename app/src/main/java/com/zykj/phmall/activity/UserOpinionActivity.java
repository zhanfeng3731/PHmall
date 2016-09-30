package com.zykj.phmall.activity;

import android.widget.EditText;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.UserOpinionPresenter;
import com.zykj.phmall.utils.ToolsUtils;
import com.zykj.phmall.view.StateView;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by 徐学坤 on 2016/9/30.
 */
public class UserOpinionActivity extends ToolBarActivity<UserOpinionPresenter> implements StateView {
    @Bind(R.id.et_opinion)
    EditText et_opinion;//用户反馈

    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_user_opinion;
    }

    @Override
    protected String provideTitle() {
        return "用户反馈";
    }

    @Override
    public UserOpinionPresenter createPresenter() {
        return new UserOpinionPresenter();
    }

    @Override
    public void success() {
        ToolsUtils.toast(this,"提交成功");
        finish();
    }

    @Override
    public void verification() {

    }

    @OnClick(R.id.tv_submit)
    protected void submit() {
        String feedback = et_opinion.getText().toString();
        presenter.submit(rootView, feedback);//提交表单(用户反馈)
    }
}
