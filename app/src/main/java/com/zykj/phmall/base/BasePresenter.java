package com.zykj.phmall.base;

/**
 * Created by csh
 * Created date 2016/8/25.
 * Description 主导器
 */
public abstract class BasePresenter<V> {

    protected V view;

    public void attachView(V view) {
        this.view = view;
    }
}