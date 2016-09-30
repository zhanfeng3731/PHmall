package com.zykj.phmall.fragment;

import android.view.View;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.zykj.phmall.R;
import com.zykj.phmall.activity.AddressManageActivity;
import com.zykj.phmall.activity.CashActivity;
import com.zykj.phmall.activity.MyInfoActivity;
import com.zykj.phmall.activity.MyPropertyActivity;
import com.zykj.phmall.activity.MyStoresActivity;
import com.zykj.phmall.activity.PersonalSettingActivity;
import com.zykj.phmall.adapter.BannerHolderView;
import com.zykj.phmall.adapter.CommonAdapter;
import com.zykj.phmall.adapter.ViewHolder;
import com.zykj.phmall.base.BaseFragment;
import com.zykj.phmall.beans.SystemDataBean;
import com.zykj.phmall.presenter.SelfPresenter;
import com.zykj.phmall.view.EntityView;
import com.zykj.phmall.widget.MyGridView;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by csh
 * Created date 2016/9/14.
 * Description 个人中心
 */
public class SelfFragment extends BaseFragment<SelfPresenter> implements EntityView<SystemDataBean> {
    @Bind(R.id.tv_head)
    TextView tv_head;
    @Bind(R.id.gd_order)
    MyGridView gd_order;
    @Bind(R.id.tv_rpoints)
    TextView tv_rpoints;//新增普积分总量
    @Bind(R.id.tv_avpoints)
    TextView tv_avpoints;//惠积分总量
    @Bind(R.id.tv_allpoints)
    TextView tv_allpoints;//全返单元总量
    @Bind(R.id.tv_back_point)
    TextView tv_back_point;//单元返还积分数
    @Bind(R.id.gd_finance)
    MyGridView gd_finance;
    @Bind(R.id.cb_banner)

    ConvenientBanner<String> cb_banner;//顶部广告栏控件
    private String[] images = {
            "http://img2.3lian.com/2014/f2/37/d/39.jpg",
            "http://f.hiphotos.baidu.com/image/h%3D200/sign=1478eb74d5a20cf45990f9df460b4b0c/d058ccbf6c81800a5422e5fdb43533fa838b4779.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/09fa513d269759ee50f1971ab6fb43166c22dfba.jpg"
    };
    private String[] top = {"待付款","待收货","待自提","待评价","退款/退货"};
    private int[] topImgs = new int[]{R.mipmap.daifukuan,R.mipmap.daishouhuo,
            R.mipmap.daiziti,R.mipmap.daipingjia,R.mipmap.tuikuantuihuo};
    private String[] bottom = {"余额","普积分","惠积分","库存积分","充值卡","代金券"};
    private int[] bottomImgs = new int[]{R.mipmap.yue,R.mipmap.kucunjifen,R.mipmap.kucunjifen,
            R.mipmap.kucunjifen,R.mipmap.chcongzhika,R.mipmap.daijinquan};
    @Override
    protected int provideContentViewId() {
        return R.layout.ui_fragment_self;
    }

    @Override
    protected String provideTitle() {
        return "个人中心";
    }

    @Override
    protected void initAllMembersView(View view) {
        tv_head.setText(provideTitle());
        presenter.SystemData(rootView);
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
        //全部订单
        gd_order.setAdapter(new CommonAdapter<String>(getContext(), R.layout.ui_item_cate, Arrays.asList(top)) {
            @Override
            public void convert(ViewHolder holder, String str) {
                holder.setImageView(R.id.iv_img, topImgs[holder.getPosition()%5]).setText(R.id.tv_name, str);
            }
        });
        //我的财产
        gd_finance.setAdapter(new CommonAdapter<String>(getContext(), R.layout.ui_item_cate, Arrays.asList(bottom)) {
            @Override
            public void convert(ViewHolder holder, String str) {
                holder.setImageView(R.id.iv_img, bottomImgs[holder.getPosition()%6]).setText(R.id.tv_name, str);
            }
        });
    }

    @Override
    public SelfPresenter createPresenter() {
        return new SelfPresenter();
    }

    @OnClick({R.id.ll_myposter, R.id.ll_myplan, R.id.ll_mysetting, R.id.ll_myaddress, R.id.ll_mymoney,
            R.id.ll_myshop, R.id.ll_myasset, R.id.iv_back, R.id.ll_myinfo})
    protected void message(View v) {
        switch (v.getId()) {
            case R.id.ll_myposter:
                startActivity(PersonalSettingActivity.class);
                break;
            case R.id.ll_myplan:
                startActivity(PersonalSettingActivity.class);
                break;
            case R.id.ll_mysetting:
                startActivity(PersonalSettingActivity.class);
                break;
            case R.id.ll_myaddress:
                startActivity(AddressManageActivity.class);
                break;
            case R.id.ll_mymoney:
                startActivity(CashActivity.class);
                break;
            case R.id.ll_myshop:
                startActivity(MyStoresActivity.class);
                break;
            case R.id.ll_myasset:
                startActivity(MyPropertyActivity.class);
                break;
            case R.id.iv_back:
                startActivity(MyInfoActivity.class);
                break;
            case R.id.ll_myinfo:
                startActivity(MyInfoActivity.class);
                break;
        }

    }

    @Override
    public void model(SystemDataBean data) {
        tv_rpoints.setText(String.valueOf(data.allpoints));
        tv_avpoints.setText(String.valueOf(data.rpoints));
        tv_allpoints.setText(String.valueOf(data.back_point));
        tv_back_point.setText(String.valueOf(data.avpoints));
    }
}