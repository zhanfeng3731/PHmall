package com.zykj.phmall.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.zykj.phmall.R;
import com.zykj.phmall.activity.AccountActivity;
import com.zykj.phmall.activity.AnnounceActivity;
import com.zykj.phmall.activity.CashActivity;
import com.zykj.phmall.activity.MainActivity;
import com.zykj.phmall.activity.ManagerActivity;
import com.zykj.phmall.activity.MemberActivity;
import com.zykj.phmall.activity.MessageActivity;
import com.zykj.phmall.activity.NewsActivity;
import com.zykj.phmall.activity.SignActivity;
import com.zykj.phmall.activity.WithdrawActivity;
import com.zykj.phmall.adapter.BannerHolderView;
import com.zykj.phmall.adapter.CommonAdapter;
import com.zykj.phmall.adapter.ViewHolder;
import com.zykj.phmall.base.BaseFragment;
import com.zykj.phmall.presenter.HomePresenter;
import com.zykj.phmall.utils.StringUtil;
import java.util.Arrays;
import java.util.List;
import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by csh
 * Created date 2016/9/14.
 * Description 首页
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements OnItemClickListener{

    @Bind(R.id.tv_head)
    TextView tv_head;
    @Bind(R.id.gd_data)
    GridView gd_data;
    @Bind(R.id.cb_banner)
    ConvenientBanner<String> cb_banner;//顶部广告栏控件
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
            R.mipmap.tixian,R.mipmap.tuijianguanli,R.mipmap.gerenzhongxin,R.mipmap.tubiao};

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
        tv_head.setText(provideTitle());
        //轮播图
        List<String> networkImages = Arrays.asList(images);
        cb_banner.setPages(new CBViewHolderCreator<BannerHolderView>() {
            @Override
            public BannerHolderView createHolder() {
                return new BannerHolderView();
            }
        }, networkImages);
        cb_banner.setManualPageable(networkImages.size() > 1);//设置不能手动影响
        if (networkImages.size() > 1) {
            //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
            cb_banner.setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused});
            cb_banner.startTurning(5000);
        }
        //八个图标
        CommonAdapter<String> adapter = new CommonAdapter<String>(getContext(), R.layout.ui_item_cate, Arrays.asList(ico)) {
            @Override
            public void convert(ViewHolder holder, String str) {
                holder.setImageView(R.id.iv_img, imgs[holder.getPosition()%8]).setText(R.id.tv_name, str);
            }
        };
        gd_data.setAdapter(adapter);
        gd_data.setOnItemClickListener(this);
    }

    @OnClick({R.id.tv_sign,R.id.ll_camera,R.id.ll_spread,R.id.ll_message,R.id.ll_shake,R.id.ll_message1,R.id.ll_message2})
    protected void door(View view){
        switch (view.getId()){
            case R.id.tv_sign:
                //签到
                startActivity(SignActivity.class);
                break;
            case R.id.ll_camera:
                startActivityForResult(CaptureActivity.class, 99);
                break;
            case R.id.ll_spread:
                break;
            case R.id.ll_message:
                startActivity(MessageActivity.class);
                break;
            case R.id.ll_shake:
                break;
            case R.id.ll_message1:
                startActivity(NewsActivity.class);
                break;
            case R.id.ll_message2:
                startActivity(AnnounceActivity.class);
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

    private Class[] activitys = new Class[]{MemberActivity.class,CashActivity.class,
            AccountActivity.class,ManagerActivity.class,WithdrawActivity.class,
            MemberActivity.class,MemberActivity.class,MemberActivity.class,};

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position == 6){
            Activity.clickFragment();
        }else{
            startActivity(activitys[position]);
        }
    }
}