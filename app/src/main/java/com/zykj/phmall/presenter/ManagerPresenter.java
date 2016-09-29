package com.zykj.phmall.presenter;

import android.view.View;

import com.zykj.phmall.base.BaseApp;
import com.zykj.phmall.beans.ArrayBean;
import com.zykj.phmall.beans.ManagerBean;
import com.zykj.phmall.network.HttpUtils;
import com.zykj.phmall.network.SubscriberRes;
import com.zykj.phmall.view.ArrayView;

import java.util.HashMap;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 积分管理
 */
public class ManagerPresenter extends ListPresenter<ArrayView> {
    @Override
    public void getList(View rootView, int page, int count) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("key", BaseApp.getModel().getKey());
        HttpUtils.SystemManager(new SubscriberRes<ArrayBean<ManagerBean>>(rootView) {
            @Override
            public void onSuccess(ArrayBean<ManagerBean> puscoreList) {
                view.hideProgress();
                view.addNews(puscoreList.log_list, puscoreList.log_list.size());
            }

            @Override
            public void completeDialog() {
                view.hideProgress();
            }
        }, map);
    }
}