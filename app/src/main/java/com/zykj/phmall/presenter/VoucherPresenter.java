package com.zykj.phmall.presenter;

import android.view.View;

import com.zykj.phmall.base.BaseApp;
import com.zykj.phmall.beans.ArrayBean;
import com.zykj.phmall.beans.VoucherBean;
import com.zykj.phmall.network.HttpUtils;
import com.zykj.phmall.network.SubscriberRes;
import com.zykj.phmall.view.ArrayView;

import java.util.HashMap;

/**
 * Created by 徐学坤 on 2016/9/24.
 */
public class VoucherPresenter extends ListPresenter<ArrayView> {
    @Override
    public void getList(View rootView, int page, int count) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("key", BaseApp.getModel().getKey());
        HttpUtils.SystemVoucher(new SubscriberRes<ArrayBean<VoucherBean>>(rootView) {
            @Override
            public void onSuccess(ArrayBean<VoucherBean> VoucherList) {
                view.hideProgress();
                view.addNews(VoucherList.voucher_list, VoucherList.voucher_list.size());
            }

            @Override
            public void completeDialog() {
                view.hideProgress();
            }
        }, map);
    }
}
