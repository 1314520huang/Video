package com.video.util;

import java.util.UUID;

public class StringUtil {

	/**
	 * ��ȡ�������
	 * 
	 * @return
	 */
	public static String getUUID() {

		return getStr(32);
	}

	/**
	 * ��ȡ���β���
	 * 
	 * @return
	 */
	public static String getSalt() {

		return getStr(6);
	}

	/**
	 * �жϵ�ǰ���ݹ����Ŀɱ䳤�����Ƿ���ڿ��ַ���
	 * 
	 * @param strs
	 * @return
	 */
	public static boolean isNotNull(String... strs) {

		for (String str : strs)
			if (str == null || str.length() == 0)
				return false;
		return true;
	}

	/**
	 * �ж������ַ����Ƿ�һ��
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isSame(String str1, String str2) {
		
		return str1.compareTo(str2) == 0;
	}
	
	public static int[] getInt(String index, String size) {
		
		int pageIndex = 1, pageSize = 10;
		if(StringUtil.isNotNull(index))	pageIndex = Integer.parseInt(index);
		if(StringUtil.isNotNull(size))	pageSize = Integer.parseInt(size);
		int[] value = new int[2];
		value[0] = pageIndex;
		value[1] = pageSize;
		return value;
	}
	
	/**
	 * ��ȡָ�����ȵ��ַ���
	 * 
	 * @param len ָ������ַ�������
	 * @return
	 */
	private static String getStr(int len) {

		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, len);
	}

	public static void main(String[] args) {

		System.out.println(getUUID());
	}
}
