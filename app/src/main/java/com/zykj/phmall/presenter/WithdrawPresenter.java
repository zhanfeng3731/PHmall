package com.zykj.phmall.presenter;

import android.view.View;
import android.widget.TextView;

import com.zykj.phmall.base.BaseApp;
import com.zykj.phmall.base.BasePresenter;
import com.zykj.phmall.beans.HomeBean;
import com.zykj.phmall.network.HttpUtils;
import com.zykj.phmall.network.SubscriberRes;
import com.zykj.phmall.utils.StringUtil;
import com.zykj.phmall.utils.TextUtil;
import com.zykj.phmall.view.StateView;

import java.util.HashMap;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 申请提现
 */
public class WithdrawPresenter extends BasePresenter<StateView>{
    //账户余额
    public void getPoint(View rootView, final TextView tv_point){
        view.showDialog();
        HashMap<String, Object> map = new HashMap<>();
        map.put("key", BaseApp.getModel().getKey());
        HttpUtils.SystemData(new SubscriberRes<HomeBean>(rootView){
            @Override
            public void onSuccess(HomeBean home) {
                view.dismissDialog();
                tv_point.setText(TextUtil.all("账户余额：", home.point));
            }
            @Override
            public void completeDialog() {
                view.dismissDialog();
            }
        }, map, 1);
    }

    public void submit(View rootView, String txt1, String txt2, String txt3, String txt4, String txt5) {
        if (StringUtil.isEmpty(txt1)) {
            view.snb("提现金额不能为空!");
        } else if (StringUtil.isEmpty(txt2)) {
            view.snb("收款银行不能为空!");
        } else if (StringUtil.isEmpty(txt3)) {
            view.snb("收款账号不能为空!");
        } else if (StringUtil.isEmpty(txt4)) {
            view.snb("开户姓名不能为空!");
        } else if (StringUtil.isEmpty(txt5)) {
            view.snb("支付密码不能为空!");
        } else {
            view.showDialog();
            HashMap<String, Object> map = new HashMap<>();
            map.put("key", BaseApp.getModel().getKey());
            map.put("pdc_amount", txt1);
            map.put("pdc_bank_name", txt2);
            map.put("pdc_bank_no", txt3);
            map.put("pdc_bank_user", txt4);
            map.put("password", txt5);
            HttpUtils.Withdraw(new SubscriberRes<Object>(rootView) {
                @Override
                public void onSuccess(Object res) {
                    view.dismissDialog();
                    view.success();
                }

                @Override
                public void onCompleted() {
                    view.dismissDialog();
                }
            }, map);
        }
    }
}