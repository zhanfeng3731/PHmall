package com.zykj.phmall.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.rey.material.app.Dialog;
import com.zykj.phmall.R;
import com.zykj.phmall.utils.ToolsUtils;

import butterknife.ButterKnife;

/**
 * Created by csh
 * Created date 2016/8/29.
 * Description 基类
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
    public P presenter;

    private Dialog dialog;

    public View rootView;
	
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
    	View mRootView =inflater.inflate(provideContentViewId(), container, false);
        ButterKnife.bind(this, mRootView);//绑定framgent
        //this.context = getActivity();
        return mRootView;
    }

    @Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
        this.presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
        rootView = getActivity().findViewById(R.id.snack_layout);
        initAllMembersView(view);
	}
    
    protected abstract int provideContentViewId();

    protected abstract String provideTitle();
    
    protected abstract void initAllMembersView(View view);

    public abstract P createPresenter();
	
    @Override  
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);//解绑
    }

    public void toast(String text) {
        ToolsUtils.toast(getActivity(), text);
    }

    public void snb(String text) {
        View view = getActivity().findViewById(R.id.snack_layout);
        Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show();
    }

    public void snb(String text, String actionText, View.OnClickListener action) {
        View view = getActivity().findViewById(R.id.snack_layout);
        Snackbar.make(view, text, Snackbar.LENGTH_SHORT).setAction(actionText, action).show();
    }

    @Override
    public void showDialog() {
        dialog = new Dialog(getContext()).backgroundColor(Color.parseColor("#fffaee"))
                .titleColor(Color.parseColor("#877652")).contentView(R.layout.ui_dialog_circular)
                .cancelable(false);
        dialog.show();
    }

    @Override
    public void showDialog(String title,int layoutId) {
        dialog = new Dialog(getContext()).backgroundColor(Color.parseColor("#fffaee"))
                .titleColor(Color.parseColor("#877652")).contentView(layoutId).cancelable(false);
        dialog.show();
    }

    @Override
    public void showDialog(String title,String positive,String negative) {
        dialog = new Dialog(getContext()).title(title)
                .positiveAction(positive)
                .negativeAction(negative)
                .backgroundColor(Color.parseColor("#fffaee"))
                .titleColor(Color.parseColor("#877652"));
        dialog.show();
    }

    @Override
    public void showDialog(String title, int layoutId ,String positive,String negative) {
        dialog = new Dialog(getContext()).title(title)
                .positiveAction(positive)
                .negativeAction(negative)
                .backgroundColor(Color.parseColor("#fffaee"))
                .titleColor(Color.parseColor("#877652"));
        dialog.show();
    }

    @Override
    public void showDialog(String title,View view ,String positive,String negative) {
        dialog = new Dialog(getContext()).title(title)
                .positiveAction(positive)
                .negativeAction(negative)
                .backgroundColor(Color.parseColor("#fffaee"))
                .titleColor(Color.parseColor("#877652"))
                .contentView(view);
        dialog.show();
    }

    @Override
    public void dismissDialog() {
        dialog.dismiss();
    }

    @Override
    public void startActivity(Class clazz) {
        startActivity(new Intent(getContext(), clazz));
    }

    @Override
    public void startActivityForResult(Class clazz, int requestCode) {
        startActivityForResult(new Intent(getContext(), clazz), requestCode);
    }

    @Override
    public void startActivity(Class clazz, Bundle bundle) {
        startActivity(new Intent(getContext(), clazz).putExtra("data", bundle));
    }

    @Override
    public void showSoftInput(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(v, InputMethodManager.SHOW_FORCED);
    }

    @Override
    public void hideSoftMethod(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    @Override
    public void startActivityForResult(Class clazz, Bundle bundle, int requestCode) {
        Intent intent = new Intent(getContext(), clazz);
        intent.putExtra("data", bundle);
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void finishActivity() {
        getActivity().finish();
    }


    @Override
    public Context getContext() {
        return getActivity();
    }
}