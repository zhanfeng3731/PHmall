package com.zykj.phmall.presenter;

import android.view.View;
import android.widget.TextView;

import com.zykj.phmall.base.BaseApp;
import com.zykj.phmall.beans.ArrayBean;
import com.zykj.phmall.beans.FundBean;
import com.zykj.phmall.beans.HomeBean;
import com.zykj.phmall.network.HttpUtils;
import com.zykj.phmall.network.SubscriberRes;
import com.zykj.phmall.utils.TextUtil;
import com.zykj.phmall.view.ArrayView;

import java.util.HashMap;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 预存款列表
 */
public class DepositPresenter extends ListPresenter<ArrayView<FundBean>>{

    private int type = 0;

    public DepositPresenter(int type){
        this.type = type;//0-账户余额 1-充值明细 2-余额提现
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public void getList(View rootView, int page, int count) {
        if(page == 1){
            view.showProgress();
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("key", BaseApp.getModel().getKey());
        HttpUtils.Fund(new SubscriberRes<ArrayBean<FundBean>>(rootView){
            @Override
            public void onSuccess(ArrayBean<FundBean> predeList) {
                view.hideProgress();
                view.addNews(predeList.list, predeList.list.size());
            }
            @Override
            public void completeDialog() {
                view.hideProgress();
            }
        }, map, type);
    }

    //预存款余额
    public void getPoint(View rootView, final TextView tv_point){
        HashMap<String, Object> map = new HashMap<>();
        map.put("key", BaseApp.getModel().getKey());
        HttpUtils.SystemData(new SubscriberRes<HomeBean>(rootView){
            @Override
            public void onSuccess(HomeBean home) {
                tv_point.setText(TextUtil.all("￥", home.point));
            }
        }, map, 1);
    }
}