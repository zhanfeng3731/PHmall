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
    public static final String MYASSET = "?act=member_index&op=my_asset";		//库存积分
    public static final String PREDEPOSIT = "?act=member_fund&op=predepositlog";//余额消费记录
    public static final String RECHARGE = "?act=member_fund&op=index";			//充值明细
    public static final String CASHLIST = "?act=member_fund&op=pdcashlist";		//余额提现
    public static final String SYSTEMDATA = "?act=index&op=count_number";		//系统数据
    public static final String USERDATA = "?act=member_index&op=count_member";	//用户数据
    public static final String ANNOUNCE = "?act=article&op=index";				//最新公告、资讯中心
    public static final String VOUCHER = "?act=member_voucher&op=voucher_list";  //代金券
    public static final String WALLET = "?act=member_redpacket&op=redpacket_list";  //红包
    public static final String ADDRESS = "?act=member_address&op=address_list";  //收货地址
    public static final String PUSCORE = "?act=member_points&op=pointslog";  //普积分
    public static final String MANAGER = "?act=member_points&op=reds_pointslog";  //惠积分
    public static final String WITHDRAW = "?act=member_fund&op=pd_cash_add";	//申请提现
    public static final String IMGBANNER = "?act=index&op=img_index";			//轮播图
    public static final String GOODCATE = "?act=goods_class&op=index";			//一级分类
    public static final String TWOCATE = "?act=goods_class&op=_get_class_list";	//二级分类
    public static final String MYINFO = "?act=member_index&op=member_information";	//二级分类
    public static final String MYOPINION = "?act=member_feedback&op=feedback_add";	//二级分类
    public static final int OK = 200;

    public static String getUrl(String token){
        if(token==null || token.equals("")){
            return "";
        }
        return String.format(IMGBASE, token);
    }
}