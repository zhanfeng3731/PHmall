package com.zykj.phmall.presenter;

import android.view.View;

import com.zykj.phmall.base.BaseApp;
import com.zykj.phmall.base.BasePresenter;
import com.zykj.phmall.network.HttpUtils;
import com.zykj.phmall.network.SubscriberRes;
import com.zykj.phmall.utils.StringUtil;
import com.zykj.phmall.utils.TextUtil;
import com.zykj.phmall.view.EntityView;

import java.util.HashMap;


/**
 * Created by 徐学坤 on 2016/9/20.
 */
public class MyInfoPresenter extends BasePresenter<EntityView<String>> {

    public void myInfo(View rootView) {
//        view.showDialog();
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("key", BaseApp.getModel().getKey());
//        HttpUtils.MyInfo(new SubscriberRes<MyInfoBean>(rootView){
//            @Override
//            public void onSuccess(MyInfoBean myInfo) {
//                view.dismissDialog();
////                view.model(myInfo.truename);
//            }
//            @Override
//            public void onCompleted() {
//                view.dismissDialog();
//            }
//        }, map);
    }

    public void submit(View rootView, String mobile, String truename, String licence_number) {
        if (!TextUtil.isMobile(mobile)) {
            view.snb("手机号格式无效!");
        } else if (StringUtil.isEmpty(truename)) {
            view.snb("真实姓名不能为空!");
        } else if (StringUtil.isEmpty(licence_number)) {
            view.snb("身份证号不能为空!");
        } else {
            view.showDialog();
            HashMap<String, Object> map = new HashMap<>();
            map.put("key", BaseApp.getModel().getKey());
            map.put("mobile", mobile);
            map.put("truename", truename);
            map.put("licence_number", licence_number);
            HttpUtils.MyInfo(new SubscriberRes<String>(rootView) {
                @Override
                public void onSuccess(String mib) {
                    view.dismissDialog();
                    view.model("success");
                }

                @Override
                public void onCompleted() {
                    view.dismissDialog();
                }
            }, map);
        }
    }
}
