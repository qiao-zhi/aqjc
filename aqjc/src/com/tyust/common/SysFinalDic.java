package com.tyust.common;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

/**
 * 常量类
	* 类名称：SysFinalDic
	* 类描述：
	* 创建人：章霞光
	* 修改人：章霞光
	* 修改时间：2013-8-12 下午04:47:32
	* 修改备注：
	* @version 1.0.0
 */
public final class SysFinalDic {
	/**
	 * 存放库存图片的目录
	 */
	public static final String STOCKS_IMAGE_PATH=FilenameUtils.separatorsToSystem(ServletActionContext.getServletContext().getRealPath("/uploads/image/"));
	/**
	 * 采购入库
	 */
	public static final String PURCHASE_ENTRY="CGRK";
	/**
	 * 采购入库
	 */
	public static final String RETURN_ENTRY="GHRK";
	/**
	 * 报废入库
	 */
	public static final String BAD_ENTRY="BFRK";
	/**
	 * 领料出库
	 */
	public static final String REQ_OUT="LLCK";
	/**
	 * 借用出库
	 */
	public static final String LEND_OUT="JYCK";
	/**
	 * 报废入库
	 */
	public static final String BAD_OUT="BFCK";
	/**
	 * 工具编号前缀
	 */
	public static final String TOOL_CODE_PRE="002022";
	
	
	
}
