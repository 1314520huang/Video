package com.video.util;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordUtil {

	/**
	 * ��������м���
	 * 
	 * @param password
	 *            ǰ̨���ݵ�����
	 * @param salt
	 *            ������ļ��β���
	 * @return
	 */
	public static String encode(String password, String salt) {

		return blend(password + " - " + salt);
	}

	/**
	 * ����������������ܽ��к����ݵ��е�������бȶ�
	 * 
	 * @param password
	 *            ǰ̨���ݵ�����
	 * @param salt
	 *            ��ǰ�����Ӧ�ļ��ܲ���
	 * @param datapass
	 *            ���ݿ��ŵļ�������
	 * @return
	 */
	public static boolean decode(String password, String salt, String datapass) {

		String nowPassword = blend(password + " - " + salt);
		return StringUtil.isSame(nowPassword, datapass);
	}

	public static String blend(String text) {

		// ������MD5 ����
		for (int i = 0; i < 8; i++)
			text = DigestUtils.md5Hex(text);
		return text;
	}

	public static void main(String[] args) {

		System.out.println(encode("123", "a67cb6"));
	}
}
