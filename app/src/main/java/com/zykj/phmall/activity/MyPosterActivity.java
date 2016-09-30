package com.zykj.phmall.activity;

import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.MyPosterPresenter;

import butterknife.Bind;

/**
 * Created by 徐学坤 on 2016/9/30.
 */
public class MyPosterActivity extends ToolBarActivity<MyPosterPresenter> {
    @Bind(R.id.wv_recharge)
    WebView wv_recharge;

    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_webview;
    }

    @Override
    protected String provideTitle() {
        return "我的推广海报";
    }

    @Override
    public MyPosterPresenter createPresenter() {
        return new MyPosterPresenter();
    }

    @Override
    protected void initAllMembersView() {
        super.initAllMembersView();
        // 设置WebView属性，能够执行Javascript脚本
        wv_recharge.getSettings().setJavaScriptEnabled(true);
        // 加载需要显示的网页
        wv_recharge.loadUrl("http://puhui.ofabao.com/wap/tmpl/member/member_tg.html");
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
        return super.onKeyDown(keyCode, event);
    }

    // Web视图
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
