package com.zykj.phmall.presenter;

import android.view.View;

import com.zykj.phmall.base.BaseApp;
import com.zykj.phmall.beans.MessageBean;
import com.zykj.phmall.network.HttpUtils;
import com.zykj.phmall.network.SubscriberRes;
import com.zykj.phmall.view.ArrayView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by csh
 * Created date 2016/9/18.
 * Description 消息中心
 */
public class MessagePresenter extends ListPresenter<ArrayView> {
    @Override
    public void getList(View rootView, int page, int count) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("key", BaseApp.getModel().getKey());
        HttpUtils.SystemMsg(new SubscriberRes<ArrayList<MessageBean>>(rootView){

            @Override
            public void onSuccess(ArrayList<MessageBean> messageList) {
                view.hideProgress();
                view.addNews(messageList, messageList.size());
            }
            @Override
            public void completeDialog() {
                view.hideProgress();
            }
        }, map);
    }
}