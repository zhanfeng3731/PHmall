package com.zykj.phmall.activity;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.zykj.phmall.R;
import com.zykj.phmall.base.BaseActivity;
import com.zykj.phmall.network.Const;
import com.zykj.phmall.presenter.RegisterPresenter;
import com.zykj.phmall.utils.ToolsUtils;
import com.zykj.phmall.view.StateView;

import butterknife.Bind;
import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

/**
 * Created by csh
 * Created date 2016/9/2.
 * Description 注册/忘记密码
 */
public class RegisterActivity extends BaseActivity<RegisterPresenter> implements StateView {

    @Bind(R.id.tv_head)
    TextView tv_head;
    @Bind(R.id.et_username)
    EditText et_username;
    @Bind(R.id.et_password)
    EditText et_password;
    @Bind(R.id.et_code)
    EditText et_code;
    @Bind(R.id.tv_code)
    TextView tv_code;
    @Bind(R.id.tv_register)
    TextView tv_register;

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
        tv_head.setText(provideTitle());
        tv_register.setText(p==0?"注册":"提交");
        SMSSDK.initSDK(this, Const.APPKEY, Const.APPSECRET);
        EventHandler eh=new EventHandler(){
            @Override
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        //提交验证码成功
                        //snb("提交验证码成功");
                        String username = et_username.getText().toString();
                        String password = et_password.getText().toString();
                        if(getIntent().getIntExtra("p", 0)==0){
                            presenter.register(rootView,username,password);
                        }else{
                            presenter.register(rootView,username,password);
                        }
                    }else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
                        //获取验证码成功
                        snb("验证码已经发送");
                    //}else if (event ==SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){
                        //返回支持发送验证码的国家列表
                    }
                }else{
                    String message = ((Throwable)data).getMessage();
                    snb(message);
                }
            }
        };
        SMSSDK.registerEventHandler(eh); //注册短信回调
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
                hideSoftMethod(et_username);
                presenter.validphone(username);
                break;
            case R.id.tv_register:
                /*注册、忘记密码*/
                hideSoftMethod(et_username);
                String code = et_code.getText().toString().trim();
                String password=et_password.getText().toString().trim();
                presenter.validDate(username, code, password);
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