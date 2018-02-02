package com.tyust.common;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.tyust.bean.log.Log;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.dao.log.LogDao;
/**
 *  增加系统配置，设置记录级别，级别之上的才能入库，设置全局变量，开启或者关闭记录
 * @author lxb
 *
 */
public class SaveLog {
 private static LogDao logDao;
	public LogDao getLogDao() {
	return logDao;
}

public void setLogDao(LogDao logDao) {
	this.logDao = logDao;
}

	//记录日志
	/**
	 * Method execute
	 * @param request
	 * @param opeprateObject 操作模块
	 * @param actionType 操作类型
	 * @param actionResult 操作结果
	 */
	public static void saveLog(HttpServletRequest request,String opeprateObject,OpertionType.State state,String actionResult){
		Log log = new Log();
		//获得session中的user对象
		TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
		//得到随机数给id赋值
			Random rd = new Random();
			String id = String.valueOf(rd.nextLong());
			log.setLogId(id);
		//ip有两中获取方式第一种就是getip
			log.setIp(request == null ?null:request.getRemoteAddr());//没有代理服务器，直接获得IP
		//中间有代理服务器，获得IP
	        if(request.getHeader("x-forwarded-for") !=null){
	        	log.setIp(request.getHeader("x-forwarded-for"));
	        }
	        log.setOpeprateObject(opeprateObject);
	        log.setActionType(OpertionType.OpertionEnum(state));
	        log.setActionResult(actionResult);
	        if(user !=null){
	        log.setActionPeopre(user.getUserName());
	        log.setActionUnit(user.getUnitName());
	        }
	        logDao.insertLog(log);
	}

	//获取不到用户时，记录日志
	public static void saveLog(HttpServletRequest request,String opeprateObject,OpertionType.State state,String actionResult,String userName){
		Log log = new Log();
		//得到随机数给id赋值
			Random rd = new Random();
			String id = String.valueOf(rd.nextLong());
			log.setLogId(id);
		//ip有两中获取方式第一种就是getip
			log.setIp(request == null ?null:request.getRemoteAddr());//没有代理服务器，直接获得IP
		//中间有代理服务器，获得IP
	        if(request != null && request.getHeader("x-forwarded-for") !=null){
	        	log.setIp(request.getHeader("x-forwarded-for"));
	        }
	        log.setOpeprateObject(opeprateObject);
	        log.setActionType(OpertionType.OpertionEnum(state));
	        log.setActionResult(actionResult);
	        log.setActionPeopre(userName);
	        logDao.insertLog(log);
	}
}
