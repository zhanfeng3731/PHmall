package com.zykj.phmall.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.zykj.phmall.R;
import com.zykj.phmall.base.BaseActivity;
import com.zykj.phmall.beans.DataBean;
import com.zykj.phmall.presenter.LoginPresenter;
import com.zykj.phmall.view.EntityView;
import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by csh
 * Created date 2016/9/2.
 * Description
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements EntityView<DataBean> {

    @Bind(R.id.iv_col)
    ImageView iv_col;
    @Bind(R.id.et_username)
    EditText et_username;
    @Bind(R.id.et_password)
    EditText et_password;
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_login;
    }

    @Override
    protected String provideTitle() {
        return null;
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @OnClick({R.id.iv_col,R.id.tv_auto,R.id.tv_login,R.id.tv_forget,R.id.tv_register})
    protected void button(View view){
        switch (view.getId()){
            case R.id.iv_col:
                /*七天内自动登录*/
                iv_col.setSelected(!iv_col.isSelected());
                break;
            case R.id.tv_auto:
                /*七天内自动登录*/
                iv_col.setSelected(!iv_col.isSelected());
                break;
            case R.id.tv_login:
                /*登录*/
                hideSoftMethod(et_username);
                startActivity(MainActivity.class);
                //presenter.login(et_username,et_username.getText().toString(),et_password.getText().toString());
                break;
            case R.id.tv_forget:
                /*忘记密码*/
                startActivity(new Intent(this, RegisterActivity.class).putExtra("p", 1));
                break;
            case R.id.tv_register:
                /*注册*/
                startActivity(new Intent(this, RegisterActivity.class).putExtra("p", 0));
                break;
        }
    }

    @Override
    protected void initAllMembersView() {}

    @Override
    public void model(DataBean user) {
        //snb("登录成功");
//        String password = et_password.getText().toString().trim();
//        BaseApp.getModel().setLogin(true);//是否已登录
//        BaseApp.getModel().setUserid(user.Id);//用户Id
//        BaseApp.getModel().setUsername(user.UserName);//手机号
//        BaseApp.getModel().setRealName(user.RealName);//真实姓名
//        BaseApp.getModel().setAddress(user.CompanyAddress);//工作地
//        BaseApp.getModel().setPassword(password);//密码
//        BaseApp.getModel().setAvatar(user.ImagePath);//头像
//        BaseApp.getModel().setSpareSecond(user.SpareSecond);//是否接收推送
//        BaseApp.getModel().setSpareThird(user.SpareThird);//是否开启声音
//        ToolsUtils.toast(this, user.Id+"");
//        startActivity(MainActivity.class);
//        finish();
    }
}