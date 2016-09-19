package com.zykj.phmall.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/**
 * Created by csh
 * Created date 2016/8/25.
 * Description 视图
 */
public interface BaseView {

    Context getContext();

    void toast(String text);

    void snb(String text);

    void snb(String text, String actionText, View.OnClickListener action);

    void showDialog();

    void showDialog(String title, int layoutId);

    void showDialog(String title, String positive, String negative);

    void showDialog(String title, int layoutId, String positive, String negative);

    void showDialog(String title, View view, String positive, String negative);

    void dismissDialog();

    void showSoftInput(View v);

    void hideSoftMethod(View v);

    void startActivity(Class clazz);

    void startActivityForResult(Class clazz, int requestCode);

    void startActivity(Class clazz, Bundle bundle);

    void startActivityForResult(Class clazz, Bundle bundle, int requestCode);

    void finishActivity();
}