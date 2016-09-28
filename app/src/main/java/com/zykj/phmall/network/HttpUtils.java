package com.zykj.phmall.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zykj.phmall.beans.AddressBean;
import com.zykj.phmall.beans.ArrayBean;
import com.zykj.phmall.beans.MessageBean;
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

    /**会员计划*/
    public static void ShouKuan(Subscriber<BaseEntityRes<Object>> callback, Map<String, Object> map){
        addSubscription(Net.getService().ShouKuan(map).subscribeOn(sc1).observeOn(sc2).subscribe(callback));
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
}