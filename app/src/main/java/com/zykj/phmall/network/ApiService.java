package com.zykj.phmall.network;

import com.zykj.phmall.beans.MemberBean;
import com.zykj.phmall.beans.MessageBean;
import com.zykj.phmall.beans.UserBean;

import java.util.ArrayList;
import java.util.Map;

import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import retrofit.http.Path;
import rx.Observable;

/**
 ******************************************************
 *                                                    *
 *                                                    *
 *                       _oo0oo_                      *
 *                      o8888888o                     *
 *                      88" . "88                     *
 *                      (| -_- |)                     *
 *                      0\  =  /0                     *
 *                    ___/`---'\___                   *
 *                  .' \\|     |# '.                  *
 *                 / \\|||  :  |||# \                 *
 *                / _||||| -:- |||||- \               *
 *               |   | \\\  -  #/ |   |               *
 *               | \_|  ''\---/''  |_/ |              *
 *               \  .-\__  '-'  ___/-. /              *
 *             ___'. .'  /--.--\  `. .'___            *
 *          ."" '<  `.___\_<|>_/___.' >' "".          *
 *         | | :  `- \`.;`\ _ /`;.`/ - ` : | |        *
 *         \  \ `_.   \_ __\ /__ _/   .-` /  /        *
 *     =====`-.____`.___ \_____/___.-`___.-'=====     *
 *                       `=---='                      *
 *                                                    *
 *                                                    *
 *     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    *
 *                                                    *
 *               佛祖保佑         永无BUG               *
 *                                                    *
 *                                                    *
 ******************************************************
 *
 * Created by csh on 2016/09/23.
 *
 */
public interface ApiService {

	//注册
	@FormUrlEncoded
	@POST(Const.REGISTER)
	Observable<BaseEntityRes<UserBean>> Register(@FieldMap Map<String, Object> params);

	//忘记密码
	@FormUrlEncoded
	@POST(Const.UPDPWD)
	Observable<BaseEntityRes<UserBean>> UpdPwd(@FieldMap Map<String, Object> params);

	//登录
	@FormUrlEncoded
	@POST(Const.LOGIN)
	Observable<BaseEntityRes<UserBean>> Login(@FieldMap Map<String, Object> params);

	//消息中心
	@FormUrlEncoded
	@POST(Const.SYSTEMMSG)
	Observable<BaseEntityRes<ArrayList<MessageBean>>> SystemMsg(@FieldMap Map<String, Object> params);

	//消息中心
	@FormUrlEncoded
	@POST(Const.GETMEMBER)
	Observable<BaseEntityRes<UserBean>> GetMember(@FieldMap Map<String, Object> params);

	//线下收银
	@FormUrlEncoded
	@POST(Const.SHOUKUAN)
	Observable<BaseEntityRes<Object>> ShouKuan(@FieldMap Map<String, Object> params);
}