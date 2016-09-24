package com.zykj.phmall.presenter;

import android.os.Looper;
import android.view.View;
import com.zykj.phmall.base.BasePresenter;
import com.zykj.phmall.beans.UserBean;
import com.zykj.phmall.network.HttpUtils;
import com.zykj.phmall.network.SubscriberRes;
import com.zykj.phmall.utils.StringUtil;
import com.zykj.phmall.utils.TextUtil;
import com.zykj.phmall.view.StateView;

import java.util.HashMap;

import cn.smssdk.SMSSDK;

/**
 * Created by csh
 * Created date 2016/9/2.
 * Description 注册/忘记密码
 */
public class RegisterPresenter extends BasePresenter<StateView> {

    public void register(View rootView, String username, String password, String repassword, int action) {
        if(StringUtil.isEmpty(username)){
            view.snb("手机号不能为空!");
        }else if(!TextUtil.isMobile(username)){
            view.snb("手机号格式无效!");
        }else if(StringUtil.isEmpty(password)){
            view.snb("密码不能为空!");
        }else if(!password.equals(repassword)){
            view.snb("两次密码不一致!");
        }else{
            view.showDialog();
            HashMap<String, Object> map = new HashMap<>();
            map.put("mobile", username);
            map.put("password", password);
            map.put("password_confirm", password);
            map.put("client", "android");
            HttpUtils.Register(new SubscriberRes<UserBean>(rootView){
                @Override
                public void onSuccess(UserBean res) {
                    view.dismissDialog();
                    view.success();
                }
                @Override
                public void completeDialog() {
                    view.dismissDialog();
                }
            }, action, map);//action(0-注册 1-忘记密码)
        }
    }

    public void validphone(String username){
        if(StringUtil.isEmpty(username)){
            view.snb("手机号不能为空!");
        }else if(!TextUtil.isMobile(username)){
            view.snb("手机号格式无效!");
        }else{
            SMSSDK.getVerificationCode("86",username);
            view.verification();
        }
    }

    public void validDate(String username, String code, String password, String repassword){
        if(StringUtil.isEmpty(username)){
            view.snb("手机号不能为空!");
        }else if(!TextUtil.isMobile(username)){
            view.snb("手机号格式无效!");
        }else if(code.length() != 4){
            view.snb("验证码格式无效!");
        }else if(StringUtil.isEmpty(password)){
            view.snb("密码不能为空!");
        }else if(!password.equals(repassword)){
            view.snb("两次密码不一致!");
        }else if(password.length()<6){
            view.snb("密码长度不能少于6位!");
        }else{
            SMSSDK.submitVerificationCode("86", username, code);
        }
    }
}