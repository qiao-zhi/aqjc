package com.tyust.service.log;

import java.util.Date;
import java.util.List;

public interface LogService {
	//查询日志条数
	public int countLog(Date startTime,Date endTime,String actionType,String actionPeopre);
	//查询日志内容
	public List selLog(int start, int end,Date startTime,Date endTime,String actionType,String actionPeopre,String sortname,String sortorder);
	//删除日志
	public int deleteLog(String logId);
}
