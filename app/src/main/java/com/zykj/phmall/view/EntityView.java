package com.zykj.phmall.view;

import com.zykj.phmall.base.BaseView;

/**
 * Created by csh
 * Created date 2016/9/13.
 * Description
 */
public interface EntityView<M> extends BaseView {

    void model(M data);

}