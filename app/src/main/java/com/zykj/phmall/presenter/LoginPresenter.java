package com.zykj.phmall.presenter;

import android.view.View;
import com.zykj.phmall.base.BaseApp;
import com.zykj.phmall.base.BasePresenter;
import com.zykj.phmall.beans.UserBean;
import com.zykj.phmall.network.HttpUtils;
import com.zykj.phmall.network.SubscriberRes;
import com.zykj.phmall.utils.StringUtil;
import com.zykj.phmall.utils.TextUtil;
import com.zykj.phmall.utils.ToolsUtils;
import com.zykj.phmall.view.EntityView;
import java.util.HashMap;

/**
 * Created by csh
 * Created date 2016/9/14.
 * Description 登录
 */
public class LoginPresenter extends BasePresenter<EntityView<UserBean>> {
    public void login(View rootview, String username, final String password) {
        if(StringUtil.isEmpty(username)){
            view.snb("手机号不能为空!");
        }else if(!TextUtil.isMobile(username)){
            view.snb("手机号格式无效!");
        }else if(StringUtil.isEmpty(password)){
            view.snb("密码不能为空!");
        }else{
            view.showDialog();
            HashMap<String, Object> map = new HashMap<>();
            map.put("username", username);
            map.put("password", password);
            map.put("client", "android");
            HttpUtils.Login(new SubscriberRes<UserBean>(rootview){
                @Override
                public void onSuccess(UserBean user) {
                    BaseApp.getModel().setLogin(true);//是否已登录
                    BaseApp.getModel().setUserid(Integer.valueOf(user.userid));//用户Id
                    BaseApp.getModel().setUsername(user.username);//账号
                    BaseApp.getModel().setKey(user.key);//登陆token唯一标志
                    BaseApp.getModel().setPassword(password);//密码
                    //BaseApp.getModel().setAvatar(user.ImagePath);//头像
                    ToolsUtils.toast(view.getContext(), user.userid);
                    view.dismissDialog();
                    view.model(user);
                }
                @Override
                public void completeDialog() {
                    view.dismissDialog();
                }
            }, map);
        }
    }
}