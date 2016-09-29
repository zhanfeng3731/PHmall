package com.zykj.phmall.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	
	// date类型转换为String类型
 	// formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
 	// data Date类型的时间
 	public static String dateToString(Date data, String formatType) {
 		return new SimpleDateFormat(formatType, new Locale("zh_CN")).format(data);
 	}
 
 	// long类型转换为String类型
 	// currentTime要转换的long类型的时间
 	// formatType要转换的string类型的时间格式
 	public static String longToString(long currentTime, String formatType) {
 		Date date = longToDate(currentTime, formatType); // long类型转成Date类型
 		String strTime = dateToString(date, formatType); // date类型转成String
 		return strTime;
 	}
 
 	// string类型转换为date类型
 	// strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
 	// HH时mm分ss秒，
 	// strTime的时间格式必须要与formatType的时间格式相同
 	public static Date stringToDate(String strTime, String formatType){
 		SimpleDateFormat formatter = new SimpleDateFormat(formatType,new Locale("zh_CN"));
 		Date date = null;
		try {
			date = formatter.parse(strTime);
		} catch (ParseException e) {
			date = new Date(0);
		}
		return date;
 	}
 
 	// long转换为Date类型
 	// currentTime要转换的long类型的时间
 	// formatType要转换的时间格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
 	public static Date longToDate(long currentTime, String formatType) {
 		//Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
 		//String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
 		//Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
 		return new Date(currentTime);
 	}
 
 	// string类型转换为long类型
 	// strTime要转换的String类型的时间
 	// formatType时间格式
 	// strTime的时间格式和formatType的时间格式必须相同
 	public static long stringToLong(String strTime, String formatType) {
 		Date date = stringToDate(strTime, formatType); // String类型转成date类型
		return dateToLong(date); // date类型转成long类型
 	}
 
 	// date类型转换为long类型
 	// date要转换的date类型的时间
 	public static long dateToLong(Date date) {
 		return date.getTime();
 	}
}
