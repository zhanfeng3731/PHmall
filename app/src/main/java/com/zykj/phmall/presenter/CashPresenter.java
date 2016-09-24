package com.zykj.phmall.presenter;

import android.view.View;
import com.zykj.phmall.base.BasePresenter;
import com.zykj.phmall.network.HttpUtils;
import com.zykj.phmall.network.SubscriberRes;
import com.zykj.phmall.utils.StringUtil;
import com.zykj.phmall.utils.ToolsUtils;
import com.zykj.phmall.view.StateView;
import java.util.HashMap;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 线下收银
 */
public class CashPresenter extends BasePresenter<StateView>{
    public void submit(View rootView, String merchant, String password, String admin, String money, String suggest) {
        if(StringUtil.isEmpty(merchant)){
            view.snb("门店账号不能为空!");
        }else if(StringUtil.isEmpty(password)){
            view.snb("门店密码不能为空!");
        }else if(StringUtil.isEmpty(admin)){
            view.snb("会员账号不能为空!");
        }else if(StringUtil.isEmpty(money)){
            view.snb("收款金额不能为空!");
        }else if(StringUtil.isEmpty(suggest)){
            view.snb("收款说明不能为空!");
        }else{
            view.showDialog();
            HashMap<String, Object> map = new HashMap<>();
            map.put("chain_name", merchant);
            map.put("chain_pwd", password);
            map.put("member_name", admin);
            map.put("member_amount", money);
            map.put("member_shuming", suggest);
            HttpUtils.ShouKuan(new SubscriberRes<Object>(rootView){
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