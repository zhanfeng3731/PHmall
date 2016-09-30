package com.zykj.phmall.presenter;

import android.view.View;

import com.zykj.phmall.beans.ArrayBean;
import com.zykj.phmall.beans.CateBean;
import com.zykj.phmall.network.HttpUtils;
import com.zykj.phmall.network.SubscriberRes;
import com.zykj.phmall.view.ArrayView;

import java.util.HashMap;

/**
 * Created by csh
 * Created date 2016/9/14.
 * Description 分类
 */
public class CatePresenter extends ListPresenter<ArrayView<CateBean>> {
    @Override
    public void getList(View rootView, int page, int count) {
        view.showDialog();
        HttpUtils.CateList(new SubscriberRes<ArrayBean<CateBean>>(rootView) {
            @Override
            public void onSuccess(ArrayBean<CateBean> list) {
                view.dismissDialog();
                view.addNews(list.class_list, list.class_list.size());
            }

            @Override
            public void onCompleted() {
                view.dismissDialog();
            }
        }, null);
    }

    public void getSecond(View rootView, String id) {
        view.showDialog();
        HashMap<String, Object> map = new HashMap<>();
        map.put("gc_id", id);
        HttpUtils.getSecond(new SubscriberRes<ArrayBean<CateBean>>(rootView) {
            @Override
            public void onSuccess(ArrayBean<CateBean> list) {
                view.dismissDialog();
                view.addNews(list.class_list, list.class_list.size());
            }

            @Override
            public void onCompleted() {
                view.dismissDialog();
            }
        }, map);
    }

}