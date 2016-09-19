package com.zykj.phmall.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zykj.phmall.R;
import com.zykj.phmall.base.BaseApp;
import com.zykj.phmall.fragment.CartFragment;
import com.zykj.phmall.fragment.CateFragment;
import com.zykj.phmall.fragment.HomeFragment;
import com.zykj.phmall.fragment.SelfFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private Fragment mTab01;
    private Fragment mTab02;
    private Fragment mTab03;
    private Fragment mTab04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_activity_main);
        ButterKnife.bind(this);
        setSelect(0);
    }

    @OnClick({R.id.rb_tab1,R.id.rb_tab2,R.id.rb_tab3,R.id.rb_tab4})
    public void tab(View v)
    {
        switch (v.getId())
        {
            case R.id.rb_tab1:
                setSelect(0);
                break;
            case R.id.rb_tab2:
                setSelect(1);
                break;
            case R.id.rb_tab3:
                setSelect(2);
                break;
            case R.id.rb_tab4:
                setSelect(3);
                break;
            default:
                break;
        }
    }

    private void setSelect(int i)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        // 把图片设置为亮的
        // 设置内容区域
        switch (i)
        {
            case 0:
                if (mTab01 == null)
                {
                    mTab01 = new HomeFragment();
                    transaction.add(R.id.fl_content, mTab01);
                } else
                {
                    transaction.show(mTab01);
                }
                break;
            case 1:
                if (mTab02 == null)
                {
                    mTab02 = new CateFragment();
                    transaction.add(R.id.fl_content, mTab02);
                } else
                {
                    transaction.show(mTab02);

                }
                break;
            case 2:
                if (mTab03 == null)
                {
                    mTab03 = new CartFragment();
                    transaction.add(R.id.fl_content, mTab03);
                } else
                {
                    transaction.show(mTab03);
                }
                break;
            case 3:
                if (mTab04 == null)
                {
                    mTab04 = new SelfFragment();
                    transaction.add(R.id.fl_content, mTab04);
                } else
                {
                    transaction.show(mTab04);
                }
                break;
            default:
                break;
        }

        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction)
    {
        if (mTab01 != null)
        {
            transaction.hide(mTab01);
        }
        if (mTab02 != null)
        {
            transaction.hide(mTab02);
        }
        if (mTab03 != null)
        {
            transaction.hide(mTab03);
        }
        if (mTab04 != null)
        {
            transaction.hide(mTab04);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);//解绑
        BaseApp.getInstance().finishActivity(this);
    }
}