package com.zykj.phmall.activity;

import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.RechargePresenter;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 在线充值
 */
public class RechargeActivity extends ToolBarActivity<RechargePresenter>{

    @Bind(R.id.pay_weixin)
    TextView pay_weixin;
    @Bind(R.id.sel_weixin)
    ImageView sel_weixin;
    @Bind(R.id.pay_alipay)
    TextView pay_alipay;
    @Bind(R.id.sel_alipay)
    ImageView sel_alipay;
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_recharge;
    }

    @Override
    protected String provideTitle() {
        return "在线充值";
    }

    @Override
    public RechargePresenter createPresenter() {
        return new RechargePresenter();
    }

    @Override
    protected void initAllMembersView() {
        super.initAllMembersView();
        pay_alipay.setText(Html.fromHtml("支付宝支付<br><small><font color=#707070>推荐有支付宝账号的使用</font></small>"));
        pay_weixin.setText(Html.fromHtml("微信支付<br><small><font color=#707070>推荐微信5.0及以上版本使用</font></small>"));
    }

    @OnClick({R.id.ll_message1,R.id.ll_message2})
    protected void click(View v){
        sel_weixin.setSelected(v.getId()==R.id.ll_message1);
        sel_alipay.setSelected(v.getId()==R.id.ll_message2);
    }
}