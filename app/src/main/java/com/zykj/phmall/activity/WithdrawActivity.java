package com.zykj.phmall.activity;

import android.widget.EditText;
import android.widget.TextView;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.WithdrawPresenter;
import com.zykj.phmall.utils.ToolsUtils;
import com.zykj.phmall.view.EntityView;
import com.zykj.phmall.view.StateView;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 申请提现
 */
public class WithdrawActivity extends ToolBarActivity<WithdrawPresenter> implements StateView {

    @Bind(R.id.tv_point)
    TextView tv_point;
    @Bind(R.id.et_txt1)
    TextView et_txt1;//提现金额
    @Bind(R.id.et_txt2)
    EditText et_txt2;//收款银行
    @Bind(R.id.et_txt3)
    EditText et_txt3;//收款账户
    @Bind(R.id.et_txt4)
    EditText et_txt4;//开户姓名
    @Bind(R.id.et_txt5)
    EditText et_txt5;//支付密码
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

    @OnClick(R.id.tv_btn)
    protected void submit(){
        String txt1 = et_txt1.getText().toString();//提现金额
        String txt2 = et_txt2.getText().toString();//收款银行
        String txt3 = et_txt3.getText().toString();//收款账号
        String txt4 = et_txt4.getText().toString();//开户姓名
        String txt5 = et_txt5.getText().toString();//支付密码
        presenter.submit(rootView,txt1,txt2,txt3,txt4,txt5);//提交表单(申请提现)
    }

    @Override
    public void success() {
        ToolsUtils.toast(this, "申请提现成功");
        et_txt1.setText("");
        et_txt2.setText("");
        et_txt3.setText("");
        et_txt4.setText("");
        et_txt5.setText("");
    }

    @Override
    public void verification() {}
}