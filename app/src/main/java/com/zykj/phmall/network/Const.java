package com.zykj.phmall.network;

/**
 * Created by csh
 * Created date 2016/9/5.
 * Description 服务器配置
 */
public class Const {

    public static final String BASE_URL = "http://120.55.66.80:8010/Webserver/";//服务器地址

    public static final String IMGBASE = "http://120.55.66.80:8010/%s";//图片路径

    public static final String APPKEY = "16d9daacb885f";						//短信key
    public static final String APPSECRET = "7d0f3ef18030009356c3cb199403ba7b";	//短信secret

    public static final String KEY = "7066D609-8311-4CA5-B74B-FA3E3B5E9253";	//加密VID
    public static final String UID = "6E9007D4-95DF-418B-ABE9-D8619431323F";	//加密UID

    public static final String AESKEY = "1A97436200F342AC";					 	//加密key
    public static final String AESIV = "948564A9FF0C4856";					 	//加密siv

    public static final String LOGIN = "Login.asmx/Entry";		 			 	//登录
    public static final String UPLOADPHOTO = "Login.asmx/UpLoadPhoto";			//头像
    public static final String UPLOADIMAGE = "RepairOrder.asmx/UpLoadImage";	//图片
    public static final String REPAIRORDER = "RepairOrder.asmx/Entry";			//订单
    public static final String SUGGESTION = "Suggestion.asmx/Entry";			//建议

    public static final int OK = 200;

    public static String getUrl(String token){
        if(token==null || token.equals("")){
            return "";
        }
        return String.format(IMGBASE, token);
    }
}