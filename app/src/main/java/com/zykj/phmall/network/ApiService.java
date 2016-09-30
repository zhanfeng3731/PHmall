package com.zykj.phmall.network;

import com.zykj.phmall.beans.AddressBean;
import com.zykj.phmall.beans.AnnounceBean;
import com.zykj.phmall.beans.ArrayBean;
import com.zykj.phmall.beans.AssetBean;
import com.zykj.phmall.beans.BannerBean;
import com.zykj.phmall.beans.CateBean;
import com.zykj.phmall.beans.FundBean;
import com.zykj.phmall.beans.HomeBean;
import com.zykj.phmall.beans.ManagerBean;
import com.zykj.phmall.beans.MessageBean;
import com.zykj.phmall.beans.PuScoreBean;
import com.zykj.phmall.beans.UserBean;
import com.zykj.phmall.beans.VoucherBean;
import com.zykj.phmall.beans.WalletBean;

import java.util.ArrayList;
import java.util.Map;

import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
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

	//获取库存积分
	@FormUrlEncoded
	@POST(Const.MYASSET)
	Observable<BaseEntityRes<AssetBean>> MyAsset(@FieldMap Map<String, Object> params);

	//余额消费记录
	@FormUrlEncoded
	@POST(Const.PREDEPOSIT)
	Observable<BaseEntityRes<ArrayBean<FundBean>>> Predepositlog(@FieldMap Map<String, Object> params);

	//充值记录
	@FormUrlEncoded
	@POST(Const.RECHARGE)
	Observable<BaseEntityRes<ArrayBean<FundBean>>> Recharge(@FieldMap Map<String, Object> params);

	//余额提现
	@FormUrlEncoded
	@POST(Const.CASHLIST)
	Observable<BaseEntityRes<ArrayBean<FundBean>>> Cashlist(@FieldMap Map<String, Object> params);

	//系统积分
	@FormUrlEncoded
	@POST(Const.SYSTEMDATA)
	Observable<BaseEntityRes<HomeBean>> SystemData(@FieldMap Map<String, Object> params);

	//用户积分
	@FormUrlEncoded
	@POST(Const.USERDATA)
	Observable<BaseEntityRes<HomeBean>> UserData(@FieldMap Map<String, Object> params);

	//最新公告、资讯中心
	@FormUrlEncoded
	@POST(Const.ANNOUNCE)
	Observable<BaseEntityRes<ArrayBean<AnnounceBean>>> Announce(@FieldMap Map<String, Object> params);

	//红包
	@FormUrlEncoded
	@POST(Const.WALLET)
	Observable<BaseEntityRes<ArrayBean<WalletBean>>> SystemWallet(@FieldMap Map<String, Object> params);

	//地址管理
	@FormUrlEncoded
	@POST(Const.ADDRESS)
	Observable<BaseEntityRes<ArrayBean<AddressBean>>> SystemAddress(@FieldMap Map<String, Object> params);

	//普积分
	@FormUrlEncoded
	@POST(Const.PUSCORE)
	Observable<BaseEntityRes<ArrayBean<PuScoreBean>>> SystemPuScore(@FieldMap Map<String, Object> params);

	//惠积分
	@FormUrlEncoded
	@POST(Const.MANAGER)
	Observable<BaseEntityRes<ArrayBean<ManagerBean>>> SystemManager(@FieldMap Map<String, Object> params);

	//店铺代金券
	@FormUrlEncoded
	@POST(Const.VOUCHER)
	Observable<BaseEntityRes<ArrayBean<VoucherBean>>> SystemVoucher(@FieldMap Map<String, Object> params);

	//申请提现
	@FormUrlEncoded
	@POST(Const.WITHDRAW)
	Observable<BaseEntityRes<Object>> Withdraw(@FieldMap Map<String, Object> params);

	//轮播图
	@FormUrlEncoded
	@POST(Const.IMGBANNER)
	Observable<BaseEntityRes<ArrayBean<BannerBean>>> ImgBanner(@FieldMap Map<String, Object> params);

	//一级分类
	@FormUrlEncoded
	@POST(Const.GOODCATE)
	Observable<BaseEntityRes<ArrayBean<CateBean>>> CateList(@FieldMap Map<String, Object> params);

	//二级分类
	@FormUrlEncoded
	@POST(Const.TWOCATE)
	Observable<BaseEntityRes<ArrayBean<CateBean>>> getSecond(@FieldMap Map<String, Object> params);
}