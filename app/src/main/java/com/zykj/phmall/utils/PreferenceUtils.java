package com.zykj.phmall.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author csh
 * @date 2016年8月8日
 * @describe 本地缓存
 */
public class PreferenceUtils {

    private static PreferenceUtils mUtil;
    private static final String PREFERENCE_NAME="_ZYKJMJ";
    private static SharedPreferences mSharedPreference;
    private SharedPreferences.Editor mEditor;

    private static final String LOGIN="login";//自动登录
    private static final String USERID="userid";//会员ID
    private static final String USERNAME="username";//登录账号
    private static final String PASSWORD="password";//登录密码
    private static final String AVATAR="avatar";//会员头像路径
    private static final String REALNAME="realname";//真实姓名
    private static final String KEY="key";//登陆token唯一标志
    private static final String VERSION="version";//app版本
    private static final String IS_INTRO="is_intro";//三张引导图
    private static final String SIGN="sign";
	
    private PreferenceUtils(Context context){
        mSharedPreference=context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        mEditor=mSharedPreference.edit();
    }
    
    public static synchronized PreferenceUtils init(Context context){
        if(mUtil==null){
            mUtil=new PreferenceUtils(context);
        }
        return mUtil;
    }

	public boolean isLogin() {
		return mSharedPreference.getBoolean(LOGIN, false);
	}

	public int getUserid() {
		return mSharedPreference.getInt(USERID, 0);
	}

	public String getUsername() {
		return mSharedPreference.getString(USERNAME, null);
	}

	public String getPassword() {
		return mSharedPreference.getString(PASSWORD, null);
	}

	public String getAvatar() {
		return mSharedPreference.getString(AVATAR, null);
	}

	public String getRealName() {
		return mSharedPreference.getString(REALNAME, null);
	}

	public String getKey() {
		return mSharedPreference.getString(KEY, null);
	}

	public String getVersion() {
		return mSharedPreference.getString(VERSION, null);
	}

	public String getIsIntro() {
		return mSharedPreference.getString(IS_INTRO, null);
	}

	public String getSign() {
		return mSharedPreference.getString(SIGN, null);
	}

    public void setLogin(boolean login){
        mEditor.putBoolean(LOGIN, login);
        mEditor.commit();
    }

    public void setUserid(int userid){
        mEditor.putInt(USERID, userid);
        mEditor.commit();
    }
    
    public void setUsername(String username){
        mEditor.putString(USERNAME, username);
        mEditor.commit();
    }

    public void setPassword(String password){
        mEditor.putString(PASSWORD, password);
        mEditor.commit();
    }

    public void setAvatar(String avatar){
        mEditor.putString(AVATAR,avatar);
        mEditor.commit();
    }

    public void setRealName(String realname){
        mEditor.putString(REALNAME,realname);
        mEditor.commit();
    }

    public void setKey(String key){
        mEditor.putString(KEY,key);
        mEditor.commit();
    }

    public void setVersion(String version){
        mEditor.putString(VERSION,version);
        mEditor.commit();
    }

    public void setIsIntro(String is_intro){
        mEditor.putString(IS_INTRO,is_intro);
        mEditor.commit();
    }

    public void setSign(String sign){
        mEditor.putString(SIGN,sign);
        mEditor.commit();
    }
    
    public void clear(){
        mEditor.clear();
    }
}