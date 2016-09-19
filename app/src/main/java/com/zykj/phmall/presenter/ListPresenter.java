package com.zykj.phmall.presenter;

import android.view.View;
import com.zykj.phmall.base.BasePresenter;
import com.zykj.phmall.view.ArrayView;

/**
 * Created by csh
 * Created date 2016/8/29.
 * Description 列表主导器
 */
public abstract class ListPresenter<V extends ArrayView> extends BasePresenter<V> {

    /**
     * 获取数据
     * @param page
     * @param count
     */
    public abstract void getList(View rootView, int page, int count);

}