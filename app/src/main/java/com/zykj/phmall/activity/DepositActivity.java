package com.zykj.phmall.activity;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.zykj.phmall.R;
import com.zykj.phmall.base.BasePresenter;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.fragment.DepositListFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 预存款账户
 */
public class DepositActivity extends ToolBarActivity<BasePresenter> {

    @Bind(R.id.tv_left)
    TextView tv_left;//账户余额
    @Bind(R.id.tv_middle)
    TextView tv_middle;//充值明细
    @Bind(R.id.tv_right)
    TextView tv_right;//余额提现

    private DepositListFragment leftFragment;         //账户余额
    private DepositListFragment middleFragment;       //充值明细
    private DepositListFragment rightFragment;        //余额提现

    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_deposit;
    }

    @Override
    protected String provideTitle() {
        return "预存款账户";
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initAllMembersView() {
        super.initAllMembersView();
        setSelect(0);
    }

    @OnClick({R.id.tv_left,R.id.tv_middle,R.id.tv_right})
    protected void message(View v){
        int theme = ContextCompat.getColor(this,R.color.theme_color);
        int white = ContextCompat.getColor(this,android.R.color.white);
        tv_left.setBackgroundColor(v.getId()==R.id.tv_left?theme:white);
        tv_middle.setBackgroundColor(v.getId()==R.id.tv_middle?theme:white);
        tv_right.setBackgroundColor(v.getId()==R.id.tv_right?theme:white);
        setSelect(v.getId()==R.id.tv_left?0:v.getId()==R.id.tv_middle?1:2);
    }

    private void setSelect(int i){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                if (leftFragment == null) {
                    leftFragment = DepositListFragment.newInstance(0);
                    transaction.add(R.id.fl_detail, leftFragment);
                } else {
                    transaction.show(leftFragment);
                }
                break;
            case 1:
                if (middleFragment == null) {
                    middleFragment = DepositListFragment.newInstance(1);
                    transaction.add(R.id.fl_detail, middleFragment);
                } else {
                    transaction.show(middleFragment);
                }
                break;
            case 2:
                if (rightFragment == null) {
                    rightFragment = DepositListFragment.newInstance(1);
                    transaction.add(R.id.fl_detail, rightFragment);
                } else {
                    transaction.show(rightFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction){
        if (leftFragment != null) {
            transaction.hide(leftFragment);
        }
        if (middleFragment != null) {
            transaction.hide(middleFragment);
        }
        if (rightFragment != null)
        {
            transaction.hide(rightFragment);
        }
    }
}