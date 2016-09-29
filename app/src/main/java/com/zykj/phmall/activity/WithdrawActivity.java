package com.zykj.phmall.activity;

import android.widget.EditText;
import android.widget.TextView;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.WithdrawPresenter;

import butterknife.Bind;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 申请提现
 */
public class WithdrawActivity extends ToolBarActivity<WithdrawPresenter> {

    @Bind(R.id.tv_point)
    TextView tv_point;
    @Bind(R.id.tv_txt1)
    TextView tv_txt1;//提现金额
    @Bind(R.id.tv_txt2)
    EditText tv_txt2;//收款银行
    @Bind(R.id.tv_txt3)
    EditText tv_txt3;//收款账户
    @Bind(R.id.tv_txt4)
    EditText tv_txt4;//开户姓名
    @Bind(R.id.tv_txt5)
    EditText tv_txt5;//支付密码
    @Bind(R.id.tv_btn)
    TextView tv_btn;//提交
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_withdraw;
    }

    @Override
    protected String provideTitle() {
        return "申请提现";
    }

    @Override
    public WithdrawPresenter createPresenter() {
        return new WithdrawPresenter();
    }

    @Override
    protected void initAllMembersView() {
        super.initAllMembersView();
        presenter.getPoint(rootView, tv_point);
    }
}