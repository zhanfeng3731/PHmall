package com.zykj.phmall.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author  lc 
 * @date 创建时间：2016-1-13 上午10:13:27 
 * @version 1.0 
 * @Description 打印工具类
 */
public class ToolsUtils {
	
	static private Toast mToast = null;
	public static int M_SCREEN_WIDTH;
	public static int M_SCREEN_HEIGHT;

	
	// 打印方法
	public static void print(String tag, String msg) {
		if(true){
			Log.i(tag, msg);
		}
	}
	
	/**
	 * Toast提醒
	 * @param msg
	 */
	public static void toast (Context context,String msg) {
		// 防止Toast重复显示
		if (mToast == null) {  
            mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);  
        } else {  
            mToast.setText(msg);  
            mToast.setDuration(Toast.LENGTH_SHORT);  
        }  
        mToast.show(); 
	}
	
	/**
	 * 获取当前时间
	 * @param formatType
	 * @return
	 */
 	public static String getNowStr(String formatType) {
 		return new SimpleDateFormat(formatType, new Locale("zh_CN")).format(new Date());
 	}
 	
	/**
	 * 获取当前应用的版本号
	 */
	public static int getAppVersion(Context context) {
		int version = 0;
		try {
			PackageInfo packinfo = context.getPackageManager().getPackageInfo(
					context.getPackageName(), 0);
			version = packinfo.versionCode;
		} catch (Exception e) {
			e.printStackTrace();
			return version;
		}
		return version;
	}

	/**
	 *
	 * @param strDate
	 * @param formatType
	 * @return
     */
 	public static boolean isOverdue(String strDate, String formatType){
 		if(StringUtil.isEmpty(strDate)){
 	 		return true;//已过期
 		}else{
 	 		SimpleDateFormat formatter = new SimpleDateFormat(formatType,new Locale("zh_CN"));
			try {
				long time = formatter.parse(strDate).getTime();
	 	 		return time < System.currentTimeMillis();
			} catch (ParseException e) {
				e.printStackTrace();
	 	 		return false;
			}
 		}
 	}
 	
	/**
	 * 将dp转化为像素值
	 */
	public static int dp2px(Context context, int dp) {
		float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dp * scale + 0.5f);
	}

	public static int Px2Dp(Context context, float px) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (px / scale + 0.5f);
	}
	
	/**
	 * @param uri
	 * @param imageUri
	 * @return 意图
	 */
	public static Intent getDefaultIntent(Uri uri, Uri imageUri){
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		intent.putExtra("crop", "true");
		intent.putExtra("aspectX", 2);
		intent.putExtra("aspectY", 2);
		intent.putExtra("outputX", 200);
		intent.putExtra("outputY", 200);
		intent.putExtra("scale", true);
		intent.putExtra("return-data", false);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);//Uri.parse("file:///sdcard/temp.jpg")
		intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
		intent.putExtra("noFaceDetection", false); // no face detection
		return intent;
	}
	
    /**
     * @param path 图片路径
     * @return 图片流
     * @Description 图片转化成base64字符串
     */
//    public static String GetImageStr(String path){
//    	//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
//    	//String imgFile = "d://test.jpg";//待处理的图片
//        InputStream in = null;
//        byte[] data = null;
//        //读取图片字节数组
//        try{
//            in = new FileInputStream(path);
//            data = new byte[in.available()];
//            in.read(data);
//            in.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        //对字节数组Base64编码
//        BASE64Encoder encoder = new BASE64Encoder();
//        return encoder.encode(data);//返回Base64编码过的字节数组字符串
//    }
}