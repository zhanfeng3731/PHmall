package com.zykj.phmall.activity;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.zykj.phmall.R;
import com.zykj.phmall.base.BaseApp;
import com.zykj.phmall.utils.NetManager;
import com.zykj.phmall.utils.StringUtil;

/**
 * Created by csh
 * Created date 2016/9/1.
 * Description 启动页
 */
public class WelcomeActivity extends Activity {
    private View view;
    private Context context;
    private NetManager netManager;
    private static int TIME = 1500; 										// 进入主程序的延迟时间

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = View.inflate(this, R.layout.ui_activity_welcome, null);
        setContentView(view);
        context = this;							//得到上下文
        netManager = new NetManager(context); 				// 得到网络管理器
    }

    @Override
    protected void onResume() {
        into();
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }
    // 进入主程序的方法
    private void into() {
        if (netManager.isOpenNetwork()) {

            // 设置动画效果是alpha，在anim目录下的alpha.xml文件中定义动画效果
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
            // 给view设置动画效果
            view.startAnimation(animation);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation arg0) {}
                @Override
                public void onAnimationRepeat(Animation arg0) {}
                // 这里监听动画结束的动作，在动画结束的时候开启一个线程，这个线程中绑定一个Handler,并
                // 在这个Handler中调用goHome方法，而通过postDelayed方法使这个方法延迟500毫秒执行，达到
                // 达到持续显示第一屏500毫秒的效果
                @Override
                public void onAnimationEnd(Animation arg0) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // 如果网络可用则判断是否第一次进入，如果是第一次则进入欢迎界面
                            String is_intro = BaseApp.getModel().getIsIntro();
                            String username = BaseApp.getModel().getUsername();
                            //如果第一次，则进入引导页WelcomeActivity
                            if (StringUtil.isEmpty(is_intro)) {
                                startActivityForAnim(IntroActivity.class);
                            } else if (!StringUtil.isEmpty(username)) {
                                againLogin();
                            } else {
                                startActivityForAnim(LoginActivity.class);
                            }
                        }
                    }, TIME);
                }
            });
        } else {
            // 如果网络不可用，则弹出对话框，对网络进行设置
            Builder builder = new Builder(context);
            builder.setTitle("没有可用的网络");
            builder.setMessage("是否对网络进行设置?");
            builder.setPositiveButton("确定",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = null;
                            try {
                                String sdkVersion = android.os.Build.VERSION.SDK;
                                if (Integer.valueOf(sdkVersion) > 10) {
                                    intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                                } else {
                                    intent = new Intent();
                                    ComponentName comp = new ComponentName(
                                            "com.android.settings",
                                            "com.android.settings.WirelessSettings");
                                    intent.setComponent(comp);
                                    intent.setAction("android.intent.action.VIEW");
                                }
                                WelcomeActivity.this.startActivity(intent);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
            builder.setNegativeButton("取消",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            WelcomeActivity.this.finish();
                        }
                    });
            builder.show();
        }
    }
    /**
     * 用户登录
     */
    public void againLogin(){
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("username", BaseApp.getModel().getUsername());
//        map.put("password", BaseApp.getModel().getPassword());
//        map.put("usertypeid", 1);
//        HttpUtils.Login(new SubscriberEntity<UserBean>(view){
//            @Override
//            public void onSuccess(UserBean userBean) {
//                BaseApp.getModel().setAvatar(userBean.ImagePath);//头像
//                BaseApp.getModel().setRealName(userBean.RealName);//真实姓名
//                BaseApp.getModel().setAddress(userBean.CompanyAddress);//真实姓名
//                BaseApp.getModel().setSpareSecond(userBean.SpareSecond);//是否接收推送
//                BaseApp.getModel().setSpareThird(userBean.SpareThird);//是否开启声音
//                ToolsUtils.toast(context, userBean.Id+"");
//                startActivityForAnim(MainActivity.class);
//            }
//            @Override
//            public void onNext(BaseEntityRes<Object> res) {
//                if (res.code != 200) {
//                    ToolsUtils.toast(context, res.error);
//                    startActivityForAnim(LoginActivity.class);
//                } else {
//                    String json = JsonUtils.serialize(res.data);
//                    onSuccess(JsonUtils.deserialize(json, UserBean.class));
//                }
//            }
//            @Override
//            public void onError(Throwable throwable) {
//                ToolsUtils.toast(context, "服务器繁忙");
//                startActivityForAnim(LoginActivity.class);
//            }
//        }, HttpUtils.getJSONParam("Logina", map));
    }

    private void startActivityForAnim(Class clazz){
        startActivity(new Intent(WelcomeActivity.this, clazz));
        // 设置Activity的切换效果
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        WelcomeActivity.this.finish();
    }
}