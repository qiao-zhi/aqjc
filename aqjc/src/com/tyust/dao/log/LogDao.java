package com.tyust.dao.log;

import java.util.Date;
import java.util.List;

import com.tyust.bean.log.Log;

public interface LogDao {
	//插入操作日志
	public void insertLog(Log log);
	//查询日志
	public List selLog(int start, int end,Date startTime,Date endTime,String actionType,String actionPeopre,String sortname,String sortorder);
	//计算日志记录数
	public int countLog(Date startTime,Date endTime,String actionType,String actionPeopre);
	//删除日志
	public int deleteLog(String logId);
}
