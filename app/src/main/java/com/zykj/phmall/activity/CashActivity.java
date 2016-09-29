package com.zykj.phmall.activity;

import android.widget.EditText;
import android.widget.TextView;
import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.CashPresenter;
import com.zykj.phmall.utils.ToolsUtils;
import com.zykj.phmall.view.EntityView;
import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 线下收银
 */
public class CashActivity extends ToolBarActivity<CashPresenter> implements EntityView<String>{

    @Bind(R.id.tv_kucun)
    TextView tv_kucun;
    @Bind(R.id.et_merchant)
    EditText et_merchant;//门店账号
    @Bind(R.id.et_password)
    EditText et_password;//门店密码
    @Bind(R.id.et_admin)
    EditText et_admin;//会员账号
    @Bind(R.id.et_money)
    EditText et_money;//收款金额
    @Bind(R.id.et_suggest)
    EditText et_suggest;//收款说明
    @Bind(R.id.tv_btn)
    TextView tv_btn;//提交
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_cash;
    }

    @Override
    protected String provideTitle() {
        return "线下收银";
    }

    @Override
    public CashPresenter createPresenter() {
        return new CashPresenter();
    }

    @Override
    protected void initAllMembersView() {
        super.initAllMembersView();
        presenter.myAsset(rootView);//请求库存积分
    }

    @OnClick(R.id.tv_btn)
    protected void submit(){
        String merchant = et_merchant.getText().toString();
        String password = et_password.getText().toString();
        String admin = et_admin.getText().toString();
        String money = et_money.getText().toString();
        String suggest = et_suggest.getText().toString();
        presenter.submit(rootView,merchant,password,admin,money,suggest);//提交表单(收银)
    }

    @Override
    public void model(String data) {
        if("success".equals(data)){
            ToolsUtils.toast(this, "充值成功！");
        }else{
            tv_kucun.setText(data);
        }
    }
}