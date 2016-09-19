package com.zykj.phmall.beans;

import android.content.Context;
import com.zykj.phmall.utils.PreferenceUtils;

/**
 * @author csh
 * @date 2016年8月8日
 * @describe 登录用户信息
 */
public class AppModel {
    /**
     * 当前帐号是否已经登录的标识
     */
	private boolean login = false;
    private int userid;//用户Id
    private String username;//登录账号
    private String password;//登录密码
    private String avatar;//头像
    private String realname;//手机
//    private String money;//我的钱包
//    private String integral;//积分
    private String version;//版本号
    private String is_intro;//是否引导
    private String sign;//备注

    private static PreferenceUtils utils;
    
    public static AppModel init(Context context){
        AppModel model =new AppModel();
        utils = PreferenceUtils.init(context);

        model.login= utils.isLogin();
        model.userid= utils.getUserid();

        if(utils.getUsername()!=null){
            model.username = utils.getUsername();
        }

        if(utils.getPassword() != null){
            model.password= utils.getPassword();
        }

        if(utils.getAvatar() != null){
            model.avatar= utils.getAvatar();
        }

        if(utils.getRealName() != null){
            model.realname= utils.getRealName();
        }
//
//        if(utils.getMoney() != null){
//            model.money= utils.getMoney();
//        }
//
//        if(utils.getIntegral() != null){
//            model.integral= utils.getIntegral();
//        }
//
        if(utils.getVersion() != null){
            model.version= utils.getVersion();
        }

        if(utils.getIsIntro() != null){
            model.is_intro= utils.getIsIntro();
        }

        if(utils.getSign() != null){
            model.sign= utils.getSign();
        }

        return model;
    }
    
	public boolean isLogin() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
        utils.setLogin(login);
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
        utils.setUserid(userid);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
        utils.setUsername(username);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
        utils.setPassword(password);
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
        utils.setAvatar(avatar);
	}
	public String getRealName() {
		return realname;
	}
	public void setRealName(String realname) {
		this.realname = realname;
        utils.setRealName(realname);
	}
//	public String getMoney() {
//		return money;
//	}
//	public void setMoney(String money) {
//		this.money = money;
//        utils.setMoney(money);
//	}
//	public String getIntegral() {
//		return integral;
//	}
//	public void setIntegral(String integral) {
//		this.integral = integral;
//        utils.setIntegral(integral);
//	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
        utils.setVersion(version);
	}
	public String getIsIntro() {
		return is_intro;
	}
	public void setIsIntro(String is_intro) {
		this.is_intro = is_intro;
        utils.setIsIntro(is_intro);
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
        utils.setSign(sign);
	}
	public void clear(){
		this.setLogin(false);
		this.setUserid(0);
		this.setUsername("");
		this.setPassword("");
		this.setAvatar("");
		this.setSign("");
		this.setRealName("");
//		this.setMoney("");
//		this.setIntegral("");
		utils.clear();
	}
}