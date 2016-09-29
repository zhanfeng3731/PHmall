package com.zykj.phmall.activity;

import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.RechargePresenter;
import butterknife.Bind;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 在线充值
 */
public class RechargeActivity extends ToolBarActivity<RechargePresenter>{

    @Bind(R.id.wv_recharge)
    WebView wv_recharge;
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_webview;
    }

    @Override
    protected String provideTitle() {
        return "在线充值";
    }

    @Override
    public RechargePresenter createPresenter() {
        return new RechargePresenter();
    }

    @Override
    protected void initAllMembersView() {
        super.initAllMembersView();
        // 设置WebView属性，能够执行Javascript脚本
        wv_recharge.getSettings().setJavaScriptEnabled(true);
        // 加载需要显示的网页
        wv_recharge.loadUrl("http://puhui.ofabao.com/wap/tmpl/member/pdrecharge_add.html");
        // 设置Web视图
        wv_recharge.setWebViewClient(new HelloWebViewClient());

        //pay_alipay.setText(Html.fromHtml("支付宝支付<br><small><font color=#707070>推荐有支付宝账号的使用</font></small>"));
        //pay_weixin.setText(Html.fromHtml("微信支付<br><small><font color=#707070>推荐微信5.0及以上版本使用</font></small>"));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 设置回退
        // 覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wv_recharge.canGoBack()) {
            wv_recharge.goBack(); // goBack()表示返回WebView的上一页面
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }

    // Web视图
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    //@OnClick({R.id.ll_message1,R.id.ll_message2})
    //protected void click(View v){
        //sel_weixin.setSelected(v.getId()==R.id.ll_message1);
        //sel_alipay.setSelected(v.getId()==R.id.ll_message2);
    //}
}