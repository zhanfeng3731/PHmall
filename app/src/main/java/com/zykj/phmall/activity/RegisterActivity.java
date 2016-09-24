package com.zykj.phmall.activity;

import android.app.Activity;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.zykj.phmall.R;
import com.zykj.phmall.base.BaseActivity;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.network.Const;
import com.zykj.phmall.presenter.RegisterPresenter;
import com.zykj.phmall.utils.ToolsUtils;
import com.zykj.phmall.view.StateView;

import org.json.JSONObject;

import butterknife.Bind;
import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

/**
 * Created by csh
 * Created date 2016/9/2.
 * Description 注册/忘记密码
 */
public class RegisterActivity extends ToolBarActivity<RegisterPresenter> implements StateView {

    @Bind(R.id.et_username)
    EditText et_username;//手机号
    @Bind(R.id.et_password)
    EditText et_password;//密码
    @Bind(R.id.et_repassword)
    EditText et_repassword;//确认密码
    @Bind(R.id.et_code)
    EditText et_code;//验证码
    @Bind(R.id.tv_code)
    TextView tv_code;//发送验证码
    @Bind(R.id.tv_register)
    TextView tv_register;//提交

    private boolean flag = false;
    private int p = 0;

    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_register;
    }

    @Override
    protected String provideTitle() {
        p = getIntent().getIntExtra("p", 0);
        return p==0?"注册":"忘记密码";
    }

    @Override
    protected void initAllMembersView() {
        flag = true;
        tv_register.setText(p==0?"注册":"提交");
        SMSSDK.initSDK(this, Const.APPKEY, Const.APPSECRET);
        EventHandler eh=new EventHandler(){
            @Override
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        //提交验证码成功
                        updateUIPostAsyncTask();
                    }else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
                        //获取验证码成功
                        snb("验证码已经发送");
                    //}else if (event ==SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){
                        //返回支持发送验证码的国家列表
                    }
                }else{
                    try {
                        //根据服务器返回的网络错误，给toast提示
                        JSONObject object = new JSONObject(((Throwable)data).getMessage());
                        String des = object.optString("detail");//错误描述
                        int status = object.optInt("status");//错误代码
                        if (status > 0 && !TextUtils.isEmpty(des)) {
                            snb(des);
                        }
                    } catch (Exception e) {
                        snb("发送端新验证码失败，请稍后再试！");
                    }
                }
            }
        };
        SMSSDK.registerEventHandler(eh); //注册短信回调
    }

    //请求注册或者忘记密码接口
    private void updateUIPostAsyncTask(){
        rootView.post(new Runnable() {
            @Override
            public void run() {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                String repassword = et_repassword.getText().toString();
                if(getIntent().getIntExtra("p", 0)==0){
                    //注册
                    presenter.register(rootView,username,password,repassword, 0);
                }else{
                    //忘记密码
                    presenter.register(rootView,username,password,repassword, 1);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterAllEventHandler();
    }

    @OnClick({R.id.iv_back,R.id.tv_code,R.id.tv_register})
    protected void button(View view){
        String username=et_username.getText().toString().trim();
        switch (view.getId()){
            case R.id.iv_back:
                /*返回*/
                finish();
                break;
            case R.id.tv_code:
                /*获取验证码*/
                if(flag){
                    hideSoftMethod(et_username);
                    presenter.validphone(username);
                }
                break;
            case R.id.tv_register:
                /*注册、忘记密码*/
                hideSoftMethod(et_username);
                String code = et_code.getText().toString().trim();
                String password=et_password.getText().toString().trim();
                String repassword=et_repassword.getText().toString().trim();
                presenter.validDate(username, code, password, repassword);
                break;
        }
    }

    @Override
    public RegisterPresenter createPresenter() {
        return new RegisterPresenter();
    }

    @Override
    public void success() {
        ToolsUtils.toast(this,getIntent().getIntExtra("p", 0)==0?"注册成功":"密码重置成功");
        //snb(getIntent().getIntExtra("p", 0)==0?"注册成功":"密码重置成功");
        finish();
    }

    @Override
    public void verification() {
        flag = false;
        new MyCount(60000, 1000).start();//一分钟倒计时
    }

    /* 定义一个倒计时的内部类 */
    class MyCount extends CountDownTimer {
        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            flag = true;
            if(tv_code != null)
                tv_code.setText("获取验证码");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            if(tv_code != null)
                tv_code.setText(millisUntilFinished / 1000 + "秒");
        }
    }
}