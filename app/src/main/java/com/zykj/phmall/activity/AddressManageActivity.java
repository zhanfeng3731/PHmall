package com.zykj.phmall.activity;

import android.view.View;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.AddressManagePresenter;

import butterknife.OnClick;

/**
 * Created by 徐学坤 on 2016/9/20.
 */
public class AddressManageActivity extends ToolBarActivity<AddressManagePresenter> {

//    @Bind(R.id.iv_img1)
//    ImageView iv_img1;
//    @Bind(R.id.iv_img2)
//    ImageView iv_img2;
//    @Bind(R.id.iv_img3)
//    ImageView iv_img3;
//    @Bind(R.id.iv_img4)
//    ImageView iv_img4;

    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_addressmanage;
    }

    @Override
    protected String provideTitle() {
        return "收货地址";
    }

    @Override
    public AddressManagePresenter createPresenter() {
        return null;
    }

    @OnClick({R.id.ll_addnewaddress})
    protected void message(View v) {
        switch (v.getId()) {
            case R.id.ll_addnewaddress:
                startActivity(AddSiteActivity.class);
                break;
        }
    }
}
