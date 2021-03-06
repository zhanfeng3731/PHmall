package com.zykj.phmall.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zykj.phmall.R;
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
import com.zykj.phmall.beans.SystemDataBean;
import com.zykj.phmall.beans.UserBean;
import com.zykj.phmall.beans.VoucherBean;
import com.zykj.phmall.beans.WalletBean;

import java.util.ArrayList;
import java.util.Map;

import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by csh
 * Created date 2016/9/5.
 * Description 接口
 */
public class HttpUtils {

    private static Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    protected static CompositeSubscription mCompositeSubscription = new CompositeSubscription();
    private static Scheduler sc1 = Schedulers.io();
    private static Scheduler sc2 = AndroidSchedulers.mainThread();

    /**注册*/
    public static void Register(Subscriber<BaseEntityRes<UserBean>> callback, int action, Map<String, Object> map){
        if(action == 0){//0-注册 1-忘记密码
            addSubscription(Net.getService().Register(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
        }else{
            addSubscription(Net.getService().UpdPwd(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
        }
    }

    /**登录*/
    public static void Login(Subscriber<BaseEntityRes<UserBean>> callback, Map<String, Object> map){
        addSubscription(Net.getService().Login(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
    }

    /**消息中心*/
    public static void SystemMsg(SubscriberRes<ArrayList<MessageBean>> callback, Map<String, Object> map) {
        addSubscription(Net.getService().SystemMsg(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
    }

    /**会员计划*/
    public static void GetMember(Subscriber<BaseEntityRes<UserBean>> callback, Map<String, Object> map){
        addSubscription(Net.getService().GetMember(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
    }

    /**线下收银*/
    public static void ShouKuan(Subscriber<BaseEntityRes<Object>> callback, Map<String, Object> map){
        addSubscription(Net.getService().ShouKuan(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
    }

    /**库存积分*/
    public static void MyAsset(Subscriber<BaseEntityRes<AssetBean>> callback, Map<String, Object> map){
        addSubscription(Net.getService().MyAsset(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
    }

    /**余额消费记录*/
    public static void Fund(Subscriber<BaseEntityRes<ArrayBean<FundBean>>> callback, Map<String, Object> map, int type){
        if(type == R.id.tv_left){//账户余额
            addSubscription(Net.getService().Predepositlog(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
        }else if(type == R.id.tv_middle){//充值明细
            addSubscription(Net.getService().Recharge(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
        }else{//余额提现
            addSubscription(Net.getService().Cashlist(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
        }
    }

    /**系统积分*/
    public static void SystemData(Subscriber<BaseEntityRes<HomeBean>> callback, Map<String, Object> map, int type){
        if(type == 0){//0-系统数据 1-用户数据
            addSubscription(Net.getService().SystemData(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
        }else{
            addSubscription(Net.getService().UserData(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
        }
    }

    /**最新公告、资讯中心*/
    public static void Announce(Subscriber<BaseEntityRes<ArrayBean<AnnounceBean>>> callback, Map<String, Object> map){
        addSubscription(Net.getService().Announce(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
    }


    /**执行请求*/
    public static void addSubscription(Subscription s) {
        mCompositeSubscription.add(s);
    }

    /**
     * 店铺代金券
     */
    public static void SystemVoucher(SubscriberRes<ArrayBean<VoucherBean>> callback, Map<String, Object> map) {
        addSubscription(Net.getService().SystemVoucher(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
    }

    /**
     * 红包
     */
    public static void SystemWallet(SubscriberRes<ArrayBean<WalletBean>> callback, Map<String, Object> map) {
        addSubscription(Net.getService().SystemWallet(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
    }

    /**
     * 收货地址
     */
    public static void SystemAddress(SubscriberRes<ArrayBean<AddressBean>> callback, Map<String, Object> map) {
        addSubscription(Net.getService().SystemAddress(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
    }

    /**
     * 普积分
     */
    public static void SystemPuScore(SubscriberRes<ArrayBean<PuScoreBean>> callback, Map<String, Object> map) {
        addSubscription(Net.getService().SystemPuScore(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
    }

    /**
     * 惠积分
     */
    public static void SystemManager(SubscriberRes<ArrayBean<ManagerBean>> callback, Map<String, Object> map) {
        addSubscription(Net.getService().SystemManager(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
    }

    /**
     * 申请提现
     */
    public static void Withdraw(SubscriberRes<Object> callback, Map<String, Object> map) {
        addSubscription(Net.getService().Withdraw(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
    }

    /**
     * 轮播图
     */
    public static void ImgBanner(SubscriberRes<ArrayBean<BannerBean>> callback, Map<String, Object> map) {
        addSubscription(Net.getService().ImgBanner(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
    }

    /**
     * 一级分类
     */
    public static void CateList(SubscriberRes<ArrayBean<CateBean>> callback, Map<String, Object> map) {
        addSubscription(Net.getService().CateList(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
    }

    /**
     * 二级分类
     */
    public static void getSecond(SubscriberRes<ArrayBean<CateBean>> callback, Map<String, Object> map) {
        addSubscription(Net.getService().getSecond(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
    }

    /**
     * 我的资料
     */
    public static void MyInfo(Subscriber<BaseEntityRes<String>> callback, Map<String, Object> map) {
        addSubscription(Net.getService().MyInfo(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
    }

    /**
     * 我的资料
     */
    public static void MyOpinion(Subscriber<BaseEntityRes<String>> callback, Map<String, Object> map) {
        addSubscription(Net.getService().MyOpinion(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
    }

    /**
     * 系统数据
     */
    public static void SelfSystemData(Subscriber<BaseEntityRes<SystemDataBean>> callback, Map<String, Object> map) {
        addSubscription(Net.getService().SelfSystemData(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));

    }
}