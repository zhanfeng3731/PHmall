package com.zykj.phmall.presenter;

import android.view.View;

import com.zykj.phmall.base.BaseApp;
import com.zykj.phmall.beans.AnnounceBean;
import com.zykj.phmall.beans.ArrayBean;
import com.zykj.phmall.beans.MessageBean;
import com.zykj.phmall.network.HttpUtils;
import com.zykj.phmall.network.SubscriberRes;
import com.zykj.phmall.view.ArrayView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 最新资讯
 */
public class NewsPresenter extends ListPresenter<ArrayView>{

    private int type = 0;

    public NewsPresenter(int type){
        this.type = type;
    }

    @Override
    public void getList(View rootView, int page, int count) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("ac_id", type==0?1:8);
        HttpUtils.Announce(new SubscriberRes<ArrayBean<AnnounceBean>>(rootView){
            @Override
            public void onSuccess(ArrayBean<AnnounceBean> AnnounceList) {
                view.hideProgress();
                view.addNews(AnnounceList.article_list, AnnounceList.article_list.size());
            }
            @Override
            public void completeDialog() {
                view.hideProgress();
            }
        }, map);
    }
}