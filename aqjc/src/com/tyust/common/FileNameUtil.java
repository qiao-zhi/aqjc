package com.tyust.common;

import org.junit.Test;

/**
 * 获取文件后缀前缀的工具类
 * 
 * @author QiaoLiQiang
 * @time 2018年2月5日下午4:38:20
 */
public class FileNameUtil {

	/**
	 * 获取文件前缀
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getFilePrefix(String fileName) {
		if(fileName == null || "".equals(fileName)){
			return null;
		}
		return fileName.substring(0, fileName.lastIndexOf("."));
	}

	/**
	 * 获取文件后缀
	 * 
	 * @param fileName
	 *            文件名称
	 * @return
	 */
	public static String getFileSufix(String fileName) {
		if(fileName == null || "".equals(fileName)){
			return null;
		}
		return fileName.substring(fileName.lastIndexOf(".")+1);//从最后一个点之后截取字符串
	}
	//测试
	public static void main(String[] args) {
		System.out.println(FileNameUtil.getFilePrefix("wwwww.pdf"));
		System.out.println(FileNameUtil.getFileSufix("wwwww.pdf"));
		System.out.println(FileNameUtil.getFilePrefix("qlq.wwwww.pdf"));
		System.out.println(FileNameUtil.getFileSufix("qlq.wwwww.pdf"));
	}
}
