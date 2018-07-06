package com.believexin.wage.common;

import java.util.UUID;

/**
 * <p>
 * Title: CommonUtils
 * </p>
 * <p>
 * Description: 公用工具类
 * </p>
 * <p>
 * Company: thunisoft
 * </p>
 * 
 * @author zhangxin
 * @date 2018年5月6日 下午4:07:40
 */
public class CommonUtils {
	/**
	 * <p>Title: getUUID</p>
	 * <p>Description: 生成uuid</p>
	 * <p>Company: thunisoft </p> 
	 * @return
	 * @author zhangxin
	 * @date 2018年5月6日 下午4:08:59
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
