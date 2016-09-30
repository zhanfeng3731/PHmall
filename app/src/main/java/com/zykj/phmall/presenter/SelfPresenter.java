package com.zykj.phmall.presenter;

import android.view.View;

import com.zykj.phmall.base.BaseApp;
import com.zykj.phmall.base.BasePresenter;
import com.zykj.phmall.beans.SystemDataBean;
import com.zykj.phmall.network.HttpUtils;
import com.zykj.phmall.network.SubscriberRes;
import com.zykj.phmall.view.EntityView;

import java.util.HashMap;

/**
 * Created by csh
 * Created date 2016/9/14.
 * Description
 */
public class SelfPresenter extends BasePresenter<EntityView<SystemDataBean>> {
    public void SystemData(View rootView) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("key", BaseApp.getModel().getKey());
        HttpUtils.SelfSystemData(new SubscriberRes<SystemDataBean>(rootView) {
            @Override
            public void onSuccess(SystemDataBean sdb) {
                view.model(sdb);
            }
        }, map);
    }

}
