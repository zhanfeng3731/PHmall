package com.zykj.phmall.presenter;

import android.view.View;

import com.zykj.phmall.base.BaseApp;
import com.zykj.phmall.base.BasePresenter;
import com.zykj.phmall.network.HttpUtils;
import com.zykj.phmall.network.SubscriberRes;
import com.zykj.phmall.utils.StringUtil;
import com.zykj.phmall.view.StateView;

import java.util.HashMap;

/**
 * Created by 徐学坤 on 2016/9/30.
 */
public class UserOpinionPresenter extends BasePresenter<StateView> {

    public void submit(View rootView, String opinion) {
        if (StringUtil.isEmpty(opinion)) {
            view.snb("意见不能为空!");
        } else {
            view.showDialog();
            HashMap<String, Object> map = new HashMap<>();
            map.put("key", BaseApp.getModel().getKey());
            map.put("feedback", opinion);
            HttpUtils.MyOpinion(new SubscriberRes<String>(rootView) {
                @Override
                public void onSuccess(String mib) {
                    view.dismissDialog();
                    view.success();
                }

                @Override
                public void onCompleted() {
                    view.dismissDialog();
                }
            }, map);
        }
    }
}
