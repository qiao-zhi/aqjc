package com.tyust.common;

import java.util.UUID;

/**
 * UUID工具类生成两种UUID
 * @author QiaoLiQiang
 * @time 2018年2月5日下午3:52:54
 */
public class UUIDUtil {
	/**
	 * 带-的UUID
	 * 
	 * @return 36位的字符串
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 去掉-的UUID
	 * 
	 * @return 32位的字符串
	 */
	public static String getUUID2() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
