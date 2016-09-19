package com.zykj.phmall.activity;

import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zykj.phmall.R;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.presenter.MemberPresenter;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 会员计划
 */
public class MemberActivity extends ToolBarActivity<MemberPresenter>{

    @Bind(R.id.tv_intro)
    TextView tv_intro;
    @Bind(R.id.iv_img1)
    ImageView iv_img1;
    @Bind(R.id.iv_img2)
    ImageView iv_img2;
    @Bind(R.id.iv_img3)
    ImageView iv_img3;
    @Bind(R.id.iv_img4)
    ImageView iv_img4;
    @Bind(R.id.tv_btn)
    TextView tv_btn;

    private int level = 1;
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_activity_member;
    }

    @Override
    protected String provideTitle() {
        return "会员计划";
    }

    @Override
    public MemberPresenter createPresenter() {
        return null;
    }

    @Override
    protected void initAllMembersView() {
        super.initAllMembersView();
        tv_intro.setText(Html.fromHtml("充值<font color=#FF0000>2000元</font>(享受积分全返)，" +
                "即可成为<font color=#FF0000>代理商</font>！与公司签署协议后，享受更高的回报。"));
        iv_img1.setSelected(true);
        iv_img2.setSelected(true);
    }

    @OnClick({R.id.ll_message1,R.id.ll_message2,R.id.ll_message3,R.id.ll_message4})
    protected void message(View v){
        int position = v.getId()==R.id.ll_message1?0:v.getId()==R.id.ll_message2?1:v.getId()==R.id.ll_message3?2:3;
        iv_img1.setSelected(true);
        iv_img2.setSelected(v.getId()!=R.id.ll_message1);
        iv_img3.setSelected(v.getId()==R.id.ll_message3 || v.getId()==R.id.ll_message4);
        iv_img4.setSelected(v.getId()==R.id.ll_message4);
        tv_btn.setSelected(position > level);
    }
}