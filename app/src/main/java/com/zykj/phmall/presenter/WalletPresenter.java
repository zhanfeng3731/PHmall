package com.zykj.phmall.presenter;

import android.view.View;

import com.zykj.phmall.base.BaseApp;
import com.zykj.phmall.beans.ArrayBean;
import com.zykj.phmall.beans.WalletBean;
import com.zykj.phmall.network.HttpUtils;
import com.zykj.phmall.network.SubscriberRes;
import com.zykj.phmall.view.ArrayView;

import java.util.HashMap;

/**
 * Created by 徐学坤 on 2016/9/27.
 */
public class WalletPresenter extends ListPresenter<ArrayView> {
    @Override
    public void getList(View rootView, int page, int count) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("key", BaseApp.getModel().getKey());
        HttpUtils.SystemWallet(new SubscriberRes<ArrayBean<WalletBean>>(rootView) {
            @Override
            public void onSuccess(ArrayBean<WalletBean> walletList) {
                view.hideProgress();
                view.addNews(walletList.redpacket_list, walletList.redpacket_list.size());
            }

            @Override
            public void completeDialog() {
                view.hideProgress();
            }
        }, map);
    }
}
