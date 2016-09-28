package com.zykj.phmall.presenter;

import android.util.Log;
import android.view.View;

import com.zykj.phmall.base.BaseApp;
import com.zykj.phmall.beans.AddressBean;
import com.zykj.phmall.beans.ArrayBean;
import com.zykj.phmall.network.HttpUtils;
import com.zykj.phmall.network.SubscriberRes;
import com.zykj.phmall.view.ArrayView;

import java.util.HashMap;


/**
 * Created by 徐学坤 on 2016/9/20.
 */
public class AddressManagePresenter extends ListPresenter<ArrayView> {
    @Override
    public void getList(View rootView, int page, int count) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("key", BaseApp.getModel().getKey());
        HttpUtils.SystemAddress(new SubscriberRes<ArrayBean<AddressBean>>(rootView) {
            @Override
            public void onSuccess(ArrayBean<AddressBean> addressList) {
                view.addNews(addressList.address_list, addressList.address_list.size());
                Log.e("TAG", addressList.address_list.size() + "");
            }
        }, map);
    }
}
