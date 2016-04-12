package com.itheima.estore.utils;

import java.util.UUID;

/**
 * 随机字符串工具类
 * @author jiangtao
 *
 */
public class UUIDUtils {

	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
