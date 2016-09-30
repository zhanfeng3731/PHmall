package com.zykj.phmall.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.zykj.phmall.R;
import com.zykj.phmall.activity.AccountActivity;
import com.zykj.phmall.activity.AnnounceActivity;
import com.zykj.phmall.activity.CashActivity;
import com.zykj.phmall.activity.MainActivity;
import com.zykj.phmall.activity.ManagerActivity;
import com.zykj.phmall.activity.MemberActivity;
import com.zykj.phmall.activity.MessageListActivity;
import com.zykj.phmall.activity.MyPlanActivity;
import com.zykj.phmall.activity.MyPosterActivity;
import com.zykj.phmall.activity.MyPropertyActivity;
import com.zykj.phmall.activity.NewsActivity;
import com.zykj.phmall.activity.RechargeActivity;
import com.zykj.phmall.activity.SignActivity;
import com.zykj.phmall.activity.WithdrawActivity;
import com.zykj.phmall.adapter.CommonAdapter;
import com.zykj.phmall.adapter.ViewHolder;
import com.zykj.phmall.base.BaseFragment;
import com.zykj.phmall.beans.HomeBean;
import com.zykj.phmall.presenter.HomePresenter;
import com.zykj.phmall.utils.StringUtil;
import com.zykj.phmall.view.EntityView;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by csh
 * Created date 2016/9/14.
 * Description 首页
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements OnItemClickListener,EntityView<HomeBean> {

    @Bind(R.id.tv_head)
    TextView tv_head;//标题
    @Bind(R.id.gd_data)
    GridView gd_data;//首页八个图标
    @Bind(R.id.cb_banner)
    ConvenientBanner<String> cb_banner;//顶部广告栏控件
    @Bind(R.id.tv_txt1)
    TextView tv_txt1;//新增普积分总量
    @Bind(R.id.tv_txt2)
    TextView tv_txt2;//惠积分总量
    @Bind(R.id.tv_txt3)
    TextView tv_txt3;//全返单元总量
    @Bind(R.id.tv_txt4)
    TextView tv_txt4;//单元返还积分数
    @Bind(R.id.tv_txt5)
    TextView tv_txt5;//预存款总额
    @Bind(R.id.tv_txt6)
    TextView tv_txt6;//普积分总数
    @Bind(R.id.tv_txt7)
    TextView tv_txt7;//惠积分总数
    public static MainActivity Activity;
    public static HomeFragment newInstance(MainActivity mianActivity) {
        Activity = mianActivity;
        return new HomeFragment();
    }
    private String[] images = {
            "http://img2.imgtn.bdimg.com/it/u=3093785514,1341050958&fm=21&gp=0.jpg",
            "http://img2.3lian.com/2014/f2/37/d/40.jpg",
            "http://d.3987.com/sqmy_131219/001.jpg",
    };
    private String[] ico = {"会员升级","商家收银","账户资金","积分管理","提现","推荐管理","个人中心","普惠商城"};
    private int[] imgs = new int[]{R.mipmap.huiyuanshengji,R.mipmap.money,R.mipmap.zhanghuzijin,R.mipmap.jifenguanli,
            R.mipmap.tixian,R.mipmap.tuijianguanli,R.mipmap.gerenzhongxin,R.mipmap.tubiao};//首页八个图标
    private Class[] activitys = new Class[]{MemberActivity.class,CashActivity.class,
            AccountActivity.class,ManagerActivity.class,WithdrawActivity.class,
            MyPlanActivity.class, MemberActivity.class, MemberActivity.class};//首页八个图标

    @Override
    protected int provideContentViewId() {
        return R.layout.ui_fragment_home;
    }

    @Override
    protected String provideTitle() {
        return "普惠商城";
    }

    @Override
    public HomePresenter createPresenter(){
        return new HomePresenter();
    }

    @Override
    protected void initAllMembersView(View view) {
        tv_head.setText(provideTitle());//标题
        setEightIconModule();//八个图标

        presenter.ImgBanner(cb_banner, rootView);//轮播图
        presenter.SystemData(rootView,0);//系统数据
        presenter.SystemData(rootView,1);//用户数据
    }

    @OnClick({R.id.tv_sign, R.id.ll_camera, R.id.ll_spread, R.id.ll_message, R.id.ll_user,
            R.id.ll_message1, R.id.ll_message2, R.id.tv_recharge, R.id.tv_withdraw, R.id.tv_detail})
    protected void door(View view){
        switch (view.getId()){
            case R.id.tv_sign://签到
                startActivity(SignActivity.class);
                break;
            case R.id.ll_camera://扫一扫
                startActivityForResult(CaptureActivity.class, 99);
                break;
            case R.id.ll_spread://推广码
                startActivity(MyPosterActivity.class);
                break;
            case R.id.ll_message://消息中心
                startActivity(MessageListActivity.class);
                break;
            case R.id.ll_message1://最新公告
                startActivity(AnnounceActivity.class);
                break;
            case R.id.ll_message2://资讯中心
                startActivity(NewsActivity.class);
                break;
            case R.id.ll_user://用户数据
                startActivity(MyPropertyActivity.class);
                break;
            case R.id.tv_recharge://充值
                startActivity(RechargeActivity.class);
                break;
            case R.id.tv_withdraw://提现
                startActivity(WithdrawActivity.class);
                break;
            case R.id.tv_detail://查看明细
                startActivity(AccountActivity.class);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 99 && resultCode == Activity.RESULT_OK){
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            if(StringUtil.toString(result).startsWith("http")){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(result));
                startActivity(intent);
            }else{
                snb(StringUtil.toString(result));
            }
        }
    }

    @Override
    public void model(HomeBean home) {
        if(home.type == 0){//系统数据
            tv_txt1.setText(String.valueOf(home.allpoints));
            tv_txt2.setText(String.valueOf(home.rpoints));
            tv_txt3.setText(home.back_point);
            tv_txt4.setText(String.valueOf(home.avpoints));
        }else{//用户数据
            tv_txt5.setText(home.point);
            tv_txt6.setText(home.predepoit);
            tv_txt7.setText(home.red_points);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position == 6){
            Activity.clickFragment();
        }else{
            startActivity(activitys[position]);
        }
    }

    //首页八个图标
    private void setEightIconModule(){
        CommonAdapter<String> adapter = new CommonAdapter<String>(getContext(), R.layout.ui_item_cate, Arrays.asList(ico)) {
            @Override
            public void convert(ViewHolder holder, String str) {
                holder.setImageView(R.id.iv_img, imgs[holder.getPosition()%8]).setText(R.id.tv_name, str);
            }
        };
        gd_data.setAdapter(adapter);
        gd_data.setOnItemClickListener(this);
    }
}