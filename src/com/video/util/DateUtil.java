package com.video.util;

import java.text.SimpleDateFormat;

public class DateUtil {

	private static SimpleDateFormat df;
	private static final String date = "yyyy-MM-dd";
	private static final String time = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 获取当前的日期
	 * 
	 * @return
	 */
	public static String getNowDate() {
		
		df = new SimpleDateFormat(date);
		return df.format(System.currentTimeMillis());
	}
	
	/**
	 * 获取当前的时间
	 * 
	 * @return
	 */
	public static String getNowTime() {

		df = new SimpleDateFormat(time);
		return df.format(System.currentTimeMillis());
	}
	
	public static void main(String[] args) {

		System.out.println(getNowDate());
		System.out.println(getNowTime());
	}
}
