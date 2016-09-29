package com.zykj.phmall.presenter;

import android.view.View;
import com.zykj.phmall.base.BaseApp;
import com.zykj.phmall.base.BasePresenter;
import com.zykj.phmall.beans.HomeBean;
import com.zykj.phmall.network.HttpUtils;
import com.zykj.phmall.network.SubscriberRes;
import com.zykj.phmall.view.EntityView;
import java.util.HashMap;

/**
 * Created by csh
 * Created date 2016/9/14.
 * Description 首页Presenter
 */
public class HomePresenter extends BasePresenter<EntityView<HomeBean>>{
    //系统数据(type=0系统数据，type=1用户数据)
    public void SystemData(View rootView,final int type){
        HashMap<String, Object> map = new HashMap<>();
        map.put("key", BaseApp.getModel().getKey());
        HttpUtils.SystemData(new SubscriberRes<HomeBean>(rootView){
            @Override
            public void onSuccess(HomeBean home) {
                home.type = type;
                view.model(home);
            }
        }, map, type);
    }
}