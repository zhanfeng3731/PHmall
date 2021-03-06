package com.zykj.phmall.fragment;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zykj.phmall.R;
import com.zykj.phmall.base.BasePresenter;
import com.zykj.phmall.base.ToolBarFragment;
import com.zykj.phmall.beans.DataBean;
import com.zykj.phmall.view.EntityView;

import butterknife.Bind;

/**
 * Created by csh
 * Created date 2016/9/14.
 * Description 购物车
 */
public class CartFragment extends ToolBarFragment<BasePresenter<EntityView<DataBean>>> {
    @Bind(R.id.wv_recharge)
    WebView wv_recharge;

    @Override
    protected int provideContentViewId() {
        return R.layout.ui_fragment_cart;
    }

    @Override
    protected String provideTitle() {
        return "购物车";
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initAllMembersView(View view) {
        super.initAllMembersView(view);
        // 设置WebView属性，能够执行Javascript脚本
        wv_recharge.getSettings().setJavaScriptEnabled(true);
        // 加载需要显示的网页
        wv_recharge.loadUrl("http://puhui.ofabao.com/wap/tmpl/cart_list.html");
        // 设置Web视图
        wv_recharge.setWebViewClient(new HelloWebViewClient());

        //pay_alipay.setText(Html.fromHtml("支付宝支付<br><small><font color=#707070>推荐有支付宝账号的使用</font></small>"));
        //pay_weixin.setText(Html.fromHtml("微信支付<br><small><font color=#707070>推荐微信5.0及以上版本使用</font></small>"));
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
