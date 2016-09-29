package com.zykj.phmall.presenter;

import android.view.View;
import android.widget.TextView;
import com.zykj.phmall.base.BaseApp;
import com.zykj.phmall.base.BasePresenter;
import com.zykj.phmall.beans.HomeBean;
import com.zykj.phmall.network.HttpUtils;
import com.zykj.phmall.network.SubscriberRes;
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
}