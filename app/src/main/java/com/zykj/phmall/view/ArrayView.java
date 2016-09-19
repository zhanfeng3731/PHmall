package com.zykj.phmall.view;

import com.zykj.phmall.base.BaseView;
import java.util.List;

/**
 * Created by csh
 * Created date 2016/8/29.
 * Description 列表页
 */
public interface ArrayView<M> extends BaseView {

    void loadData();

    void addNews(List<M> data, int count);

    void showProgress();

    void hideProgress();

}