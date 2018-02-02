package com.tyust.common;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 公共方法工具类
	* 类名称：UtilTools
	* 类描述：
	* 创建人：章霞光
	* 修改人：章霞光
	* 修改时间：2012-4-13 上午10:30:26
	* 修改备注：
	* @version 1.0.0
 */
public class UtilTools {
	/**
	 * 
		* getIp(获取操作端ip)  
		* (这里描述这个方法适用条件 – 可选)  
	    * @return   
	    * String  
	    * @exception   
	    * @since  1.0.0
	 */
	public static String getIp(){
		String ip="";
//		try {
//			ip = java.net.InetAddress.getLocalHost().getHostAddress();
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ExternalIpAddressFetcher fetcher=new ExternalIpAddressFetcher("http://checkip.dyndns.org/");  
        //System.out.println(fetcher.getMyExternalIpAddress());
		ip = fetcher.getMyExternalIpAddress();
		return ip;
	}
	/**
	 * 获取随机数
		* getIdUtil(这里用一句话描述这个方法的作用)  
		* (这里描述这个方法适用条件 – 可选)  
	    * @return   
	    * String  
	    * @exception   
	    * @since  1.0.0
	 */
	public static String getIdUtil(){
		String id=UUID.randomUUID().toString();
		return id;
	}
	/**
	 * 返回boolean值 
	 */
	public static boolean isNull(String str){
		if(str == null || "".equals(str) || "null".equals(str)) {  
            return true;  
        } else {  
            return false;  
        }  
	}
	/**
	 * 返回字符串或者空值
	 */
	public static String nvl(String str) {  
        if(str == null || "null".equals(str)) {  
            return "";  
        } else {  
            return str;  
        }  
    }
	/** 
     * @param pwd_len 生成的密码的总长度 
     * @return 密码的字符串 
     */  
    public static String genRandomNum(int pwd_len) {  
        // 35是因为数组是从0开始的，26个字母+10个数字  
        final int maxNum = 10;  
        int i; // 生成的随机数  
        int count = 0; // 生成的密码的长度  
        char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };  
  
        StringBuffer pwd = new StringBuffer("");  
        Random r = new Random();  
        while (count < pwd_len) {  
            // 生成随机数，取绝对值，防止生成负数，  
  
            i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1  
  
            if (i >= 0 && i < str.length) {  
                pwd.append(str[i]);  
                count++;  
            }  
        }  
  
        return pwd.toString();  
    }  
	
	
	
	
	
	
	
	
	
	
	
	
}
