package com.zykj.phmall.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.zykj.phmall.beans.AppModel;
import com.zykj.phmall.utils.ToolsUtils;

import java.util.Stack;

/**
 * Created by csh
 * Created date 2016/8/27.
 * Description 应用
 */
public class BaseApp extends Application {

	// ===========常量==========
	//public static final String FILE_DIR = "heer_dir";

	private static Context context;
	private static Stack<Activity> activityStack;
	private static BaseApp instance;
    private static AppModel model;
	
	public BaseApp() {}

	public synchronized static BaseApp getInstance() {
		if (null == instance) {
			instance = new BaseApp();
		}
		return instance;
	}
	
    private void initModel() {
    	/*初始化用户Model*/
        model= AppModel.init(this);
    }
    
    /**
	 * 获取用户信息
	 */
    public static AppModel getModel(){
        if(model == null){
            Log.e("application","appmodel is null");
        }
        return model;
    }
    
    /**
	 * 验证用户是否登录
	 */
    public static boolean validateUserLogin(){
    	return model.isLogin();
    }
    
    /**
	 * 打开Activity
	 */
	public void addActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		activityStack.add(activity);
	}

	/**
	 * 获取当前Activity
	 */
	public Activity currentActivity() {
		Activity activity = activityStack.lastElement();
		return activity;
	}

	/**
	 * 关闭Activity
	 */
	public void finishActivity() {
		Activity activity = activityStack.lastElement();
		finishActivity(activity);
	}

	/**
	 * 关闭指定Activity
	 */
	public void finishActivity(Activity activity) {
		if (activity != null) {
			activityStack.remove(activity);
			activity.finish();
		}
	}

	/**
	 * 关闭所有的Activity
	 */
	public void finishAllActivity() {
		for (int i = 0, size = activityStack.size(); i < size; i++) {
			if (null != activityStack.get(i)) {
				activityStack.get(i).finish();
			}
		}
		activityStack.clear();
	}

	/**
	 * 当前界面恢复时的操作
	 */
	public void resumeActivity(Activity activity) {
		if (activityStack.lastElement() == activity) {
			return;
		}
		activityStack.remove(activity);
		activityStack.push(activity);
		//Log.d(TAG, "最后一个参数:" + activityStack.lastElement());
	}

	public void exit() {
		finishAllActivity();
		System.exit(0);
	}

	public void onLowMemory() {
		super.onLowMemory();
		System.gc();
	}
	
	@Override
	public void onCreate() {
		context = getApplicationContext();
		super.onCreate();

		WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics metrics = new DisplayMetrics();
		windowManager.getDefaultDisplay().getMetrics(metrics);
		ToolsUtils.M_SCREEN_WIDTH = metrics.widthPixels;
		ToolsUtils.M_SCREEN_HEIGHT = metrics.heightPixels;
		
        initModel();//初始化 数据
	}
	
	/**
	 * 获取全局Context
	 */
	public static Context getContext() {
		return context;
	}
}