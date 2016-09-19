package com.zykj.phmall.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zykj.phmall.R;
import com.zykj.phmall.adapter.BasePagerAdapter;
import com.zykj.phmall.base.BaseApp;

import java.util.ArrayList;

//第一次运行的引导页代码
public class IntroActivity extends Activity implements OnPageChangeListener,View.OnTouchListener {
	private Context context;
	private ImageView[] indicators = null;
	private int[] images;
	private boolean flag = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_activity_intro);
		context = this;
		// 创建桌面快捷方式
		//new CreateShut(this);
		// 设置引导图片
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  仅需在这设置图片 指示器和page自动添加
		images = new int[] {R.mipmap.pic_1, R.mipmap.pic_2, R.mipmap.pic_3};
		initView();
	}

	// 初始化视图
	private void initView() {
		// 实例化视图控件
		ViewPager viewPager = (ViewPager) findViewById(R.id.viewpage);
		LinearLayout indicatorLayout = (LinearLayout) findViewById(R.id.indicator);
		ArrayList<View> views = new ArrayList<>();

		indicators = new ImageView[images.length]; // 定义指示器数组大小
		for (int i = 0; i < images.length; i++) {
			// 循环加入图片
			ImageView imageView = new ImageView(context);
			imageView.setBackgroundResource(images[i]);
			views.add(imageView);
			// 循环加入指示器
			indicators[i] = new ImageView(context);
			indicators[i].setBackgroundResource(R.mipmap.ic_page_indicator);
			if (i == 0) {
				indicators[i].setBackgroundResource(R.mipmap.ic_page_indicator_focused);
			}
			indicatorLayout.addView(indicators[i]);
		}
		PagerAdapter pagerAdapter = new BasePagerAdapter(views);
		viewPager.setAdapter(pagerAdapter); // 设置适配器
		viewPager.addOnPageChangeListener(this);
		viewPager.setOnTouchListener(this);
	}

	private float mLastX = -1; // save event y

	@Override
	public void onPageScrollStateChanged(int arg0) {}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {}

	// 监听viewpage
	@Override
	public void onPageSelected(int arg0) {
		flag = arg0 == indicators.length - 1;
		// 更改指示器图片
		for (int i = 0; i < indicators.length; i++) {
			indicators[arg0].setBackgroundResource(R.mipmap.ic_page_indicator_focused);
			if (arg0 != i) {
				indicators[i].setBackgroundResource(R.mipmap.ic_page_indicator);
			}
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent ev) {
		if (mLastX == -1) {
			mLastX = ev.getRawX();
		}

		switch (ev.getAction()) {
			case MotionEvent.ACTION_DOWN:
				mLastX = ev.getRawX();
				break;
			case MotionEvent.ACTION_UP:
				//ToolsUtils.toast(this, "start="+mLastX+",distance="+(mLastX - ev.getRawX()));
				if(flag && mLastX - ev.getRawX() > 120){
					BaseApp.getModel().setIsIntro("ok");

					startActivity(new Intent(this, LoginActivity.class));
					overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
					this.finish();
				}
				break;
		}
		return super.onTouchEvent(ev);
	}
}