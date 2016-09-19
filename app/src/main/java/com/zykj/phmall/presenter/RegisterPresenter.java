package com.zykj.phmall.presenter;

import android.view.View;

import com.zykj.phmall.base.BasePresenter;
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

    public void register(View rootView, String username, String password) {
        if(StringUtil.isEmpty(username)){
            view.snb("手机号不能为空!");
        }else if(!TextUtil.isMobile(username)){
            view.snb("手机号格式无效!");
        }else if(StringUtil.isEmpty(password)){
            view.snb("密码不能为空!");
        }else{
            HashMap<String, Object> map = new HashMap<>();
            map.put("phone", username);
            map.put("password", password);
            map.put("usertypeid", "1");
//            HttpUtils.Login(new SubscriberEntity<String>(rootView){
//                @Override
//                public void onSuccess(String res) {
//                    view.success();
//                }
//            }, HttpUtils.getJSONParam(StringUtil.isEmpty(realname)?"ForgetPassword":"Register", map));
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

    public void validDate(String username, String code, String password){
        if(StringUtil.isEmpty(username)){
            view.snb("手机号不能为空!");
        }else if(!TextUtil.isMobile(username)){
            view.snb("手机号格式无效!");
        }else if(code.length() != 4){
            view.snb("验证码格式无效!");
        }else if(StringUtil.isEmpty(password)){
            view.snb("密码不能为空!");
        }else if(password.length()<6){
            view.snb("密码长度不能少于6位!");
        }else{
            SMSSDK.submitVerificationCode("86", username, code);
        }
    }
}