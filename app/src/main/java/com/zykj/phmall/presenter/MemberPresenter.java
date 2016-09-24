package com.zykj.phmall.presenter;

import android.view.View;
import com.zykj.phmall.base.BaseApp;
import com.zykj.phmall.base.BasePresenter;
import com.zykj.phmall.beans.UserBean;
import com.zykj.phmall.network.HttpUtils;
import com.zykj.phmall.network.SubscriberRes;
import com.zykj.phmall.view.EntityView;
import java.util.HashMap;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 会员计划
 */
public class MemberPresenter extends BasePresenter<EntityView>{
    public void getMember(View rootView){
        view.showDialog();
        HashMap<String, Object> map = new HashMap<>();
        map.put("key", BaseApp.getModel().getKey());
        HttpUtils.GetMember(new SubscriberRes<UserBean>(rootView){
            @Override
            public void onSuccess(UserBean user) {
                view.dismissDialog();
                view.model(user.member_info);
            }
            @Override
            public void completeDialog() {
                view.dismissDialog();
            }
        }, map);
    }
}