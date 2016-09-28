package com.zykj.phmall.network;

/**
 * Created by csh
 * Created date 2016/9/5.
 * Description 服务器配置
 */
public class Const {

    public static final String BASE_URL = "http://puhui.ofabao.com/android/index.php";//服务器地址

    public static final String IMGBASE = "http://120.55.66.80:8010/%s";//图片路径

    public static final String APPKEY = "1760ad4984208";						//短信key
    public static final String APPSECRET = "ff2c407bbd8c2a6d324eec1bbc3da812";	//短信secret

    public static final String REGISTER = "?act=login&op=register";		 		//注册
    public static final String UPDPWD = "?act=login&op=update_password";		//忘记密码
    public static final String LOGIN = "?act=login&op=index";		 			//登录
    public static final String SYSTEMMSG = "?act=member_message&op=systemmsg";	//消息中心
    public static final String GETMEMBER = "?act=member_index&op=index";		//会员计划
    public static final String SHOUKUAN = "?act=seller_order&op=shoukuan";		//线下收银
    public static final String VOUCHER = "?act=member_voucher&op=voucher_list";  //代金券
    public static final String WALLET = "?act=member_redpacket&op=redpacket_list";  //红包
    public static final String ADDRESS = "?act=member_address&op=address_list";  //收货地址
    public static final int OK = 200;

    public static String getUrl(String token){
        if(token==null || token.equals("")){
            return "";
        }
        return String.format(IMGBASE, token);
    }
}