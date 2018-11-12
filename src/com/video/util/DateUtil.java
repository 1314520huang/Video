package com.video.util;

import java.text.SimpleDateFormat;

public class DateUtil {

	private static SimpleDateFormat df;
	private static final String date = "yyyy-MM-dd";
	private static final String time = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * ��ȡ��ǰ������
	 * 
	 * @return
	 */
	public static String getNowDate() {
		
		df = new SimpleDateFormat(date);
		return df.format(System.currentTimeMillis());
	}
	
	/**
	 * ��ȡ��ǰ��ʱ��
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
