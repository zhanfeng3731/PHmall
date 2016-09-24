package com.zykj.phmall.activity;

import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.zykj.phmall.R;
import com.zykj.phmall.base.BaseApp;
import com.zykj.phmall.base.ToolBarActivity;
import com.zykj.phmall.beans.MemberBean;
import com.zykj.phmall.network.Const;
import com.zykj.phmall.presenter.MemberPresenter;
import com.zykj.phmall.utils.GlideCircle;
import com.zykj.phmall.utils.StringUtil;
import com.zykj.phmall.utils.ToolsUtils;
import com.zykj.phmall.view.EntityView;
import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by csh
 * Created date 2016/9/19.
 * Description 会员计划
 */
public class MemberActivity extends ToolBarActivity<MemberPresenter> implements EntityView<MemberBean>{

    @Bind(R.id.iv_avatar)
    ImageView iv_avatar;//头像
    @Bind(R.id.tv_name)
    TextView tv_name;//姓名，电话
    @Bind(R.id.tv_level)
    TextView tv_level;//会员等级
    @Bind(R.id.tv_intro)
    TextView tv_intro;//说明
    @Bind(R.id.iv_img1)
    ImageView iv_img1;//普通会员
    @Bind(R.id.iv_img2)
    ImageView iv_img2;//创业会员
    @Bind(R.id.iv_img3)
    ImageView iv_img3;//董事会员
    @Bind(R.id.iv_img4)
    ImageView iv_img4;//代理商
    @Bind(R.id.tv_btn)
    TextView tv_btn;//升级

    private int level = 1;
    private String[] l = new String[]{"普通会员","创业会员","董事会员","代理商"};

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
        return new MemberPresenter();
    }

    @Override
    protected void initAllMembersView() {
        super.initAllMembersView();
        tv_intro.setText(Html.fromHtml("充值<font color=#FF0000>2000元</font>(享受积分全返)，" +
                "即可成为<font color=#FF0000>代理商</font>！与公司签署协议后，享受更高的回报。"));
        presenter.getMember(rootView);
    }

    @Override
    public void model(MemberBean member) {
        tv_name.setText(StringUtil.toString(member.member_truename,"Hi")+"，"+member.member_mobile);
        level = Integer.valueOf(member.level_name.substring(1));
        tv_level.setText("当前等级："+member.level_name+l[level]);
        iv_img1.setSelected(level>=0);
        iv_img2.setSelected(level>=1);
        iv_img3.setSelected(level>=2);
        iv_img4.setSelected(level>=3);

        Glide.with(this).load(Const.getUrl(BaseApp.getModel().getAvatar()))
                .fitCenter().crossFade()
                .transform(new GlideCircle(this))
                .placeholder(R.mipmap.ico_avatar)
                .into(iv_avatar);
    }

    @OnClick({R.id.ll_message1,R.id.ll_message2,R.id.ll_message3,R.id.ll_message4,R.id.tv_btn})
    protected void message(View v){
        if(v.getId() == R.id.tv_btn){
            if(tv_btn.isSelected())
                ToolsUtils.toast(this, "升级");
        }else{
            int position = v.getId()==R.id.ll_message1?0:v.getId()==R.id.ll_message2?1:v.getId()==R.id.ll_message3?2:3;
            iv_img1.setSelected(true);
            iv_img2.setSelected(v.getId()!=R.id.ll_message1);
            iv_img3.setSelected(v.getId()==R.id.ll_message3 || v.getId()==R.id.ll_message4);
            iv_img4.setSelected(v.getId()==R.id.ll_message4);
            tv_btn.setSelected(position > level);
        }
    }
}