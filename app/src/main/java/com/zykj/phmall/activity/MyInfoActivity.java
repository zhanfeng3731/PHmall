package com.zykj.phmall.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.MyInfoPresenter;
import com.zykj.phmall.utils.TextUtil;
import com.zykj.phmall.view.EntityView;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by 徐学坤 on 2016/9/20.
 */
public class MyInfoActivity extends ToolBarActivity<MyInfoPresenter> implements EntityView<String> {

    @Bind(R.id.et_realname)
    EditText et_realname;//真实姓名
    @Bind(R.id.et_licence_number)
    EditText et_licence_number;//身份证号
    @Bind(R.id.et_telephone)
    EditText et_telephone;//手机号
    @Bind(R.id.tv_sure)
    TextView tv_sure;//提交

    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_myinfo;
    }

    @Override
    protected String provideTitle() {
        return "我的资料";
    }

    @Override
    public MyInfoPresenter createPresenter() {
        return new MyInfoPresenter();
    }

    @Override
    protected void initAllMembersView() {
        super.initAllMembersView();
        presenter.myInfo(rootView);//请求我的信息
        TextUtil.setText(et_realname, et_realname.getText().toString());
        TextUtil.setText(et_licence_number, et_licence_number.getText().toString());
        TextUtil.setText(et_telephone, et_telephone.getText().toString());

    }

    @OnClick(R.id.tv_sure)
    protected void submit() {
        String mobile = et_telephone.getText().toString();
        String truename = et_realname.getText().toString();
        String licence_number = et_licence_number.getText().toString();
        presenter.submit(rootView, mobile, truename, licence_number);//提交表单(我的信息)
    }

    @Override
    public void model(String data) {
        if ("success".equals(data)) {
            snb("提交成功");
        } else {
            snb("提交失败");
        }
    }

    @OnClick({R.id.rl_amend_password})
    protected void message(View v) {
        switch (v.getId()) {
            case R.id.rl_amend_password:
                startActivity(RegisterActivity.class);
                break;
        }
    }
}
