package com.tyust.service.log;

import java.util.Date;
import java.util.List;

import com.tyust.dao.log.LogDao;
import com.tyust.service.log.LogService;

public class LogServiceImpl implements LogService {
	private LogDao logDao;
	public LogDao getLogDao() {
		return logDao;
	}
	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}
	//查询日志条数
	public int countLog(Date startTime, Date endTime, String actionType,
			String actionPeopre) {
		return logDao.countLog(startTime, endTime, actionType, actionPeopre);
	}
	//查询日志内容
	public List selLog(int start, int end, Date startTime, Date endTime,
			String actionType, String actionPeopre, String sortname,
			String sortorder) {
		return logDao.selLog(start, end, startTime, endTime, actionType, actionPeopre, sortname, sortorder);
	}
	//删除日志
	public int deleteLog(String logId) {
		return logDao.deleteLog(logId);
	}
}
