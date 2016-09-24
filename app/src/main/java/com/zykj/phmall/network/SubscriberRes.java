package com.zykj.phmall.network;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.zykj.phmall.beans.ErrorBean;
import com.zykj.phmall.utils.JsonUtils;
import com.zykj.phmall.utils.ToolsUtils;

import rx.Subscriber;

/**
 * Created by csh
 * Created date 2016/9/5.
 * Description 实体列表数据
 * T 实体
 */
public abstract class SubscriberRes<T> extends Subscriber<BaseEntityRes<T>> {

    protected View rootView;

    public SubscriberRes(View rootView){
        this.rootView=rootView;
    }

    @Override
    public void onNext(BaseEntityRes<T> res) {
        if (res.code != 200) {
            completeDialog();
            String json = JsonUtils.serialize(res.datas);
            String error = JsonUtils.deserialize(json, ErrorBean.class).error;
            Snackbar.make(rootView, error, Snackbar.LENGTH_SHORT).show();
        } else {
            onSuccess(res.datas);
        }
    }

    @Override
    public void onCompleted() {}

    @Override
    public void onError(Throwable throwable) {
        completeDialog();
        Snackbar.make(rootView, "服务器繁忙，请稍后重试！", Snackbar.LENGTH_SHORT).show();
    }

    public abstract void onSuccess(T t);

    public void completeDialog(){}
}