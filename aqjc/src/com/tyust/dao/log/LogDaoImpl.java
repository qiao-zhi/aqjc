package com.tyust.dao.log;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


import com.tyust.bean.log.Log;
import com.tyust.dao.log.LogDao;

public class LogDaoImpl extends SqlMapClientDaoSupport implements LogDao {
	public void insertLog(Log log) {
		this.getSqlMapClientTemplate().insert("Log.insertLog",log);
	}


/* sqlserver分页：
 	public List selLog(int pagec, int tiaoc, Date startTime, Date endTime,
			String actionType, String actionPeopre,String sortname,String sortorder) {
		HashMap<String, Comparable> paraMap= new HashMap<String, Comparable>();
		paraMap.put("limit", tiaoc);
		paraMap.put("start", tiaoc*(pagec-1));
		paraMap.put("startTime", startTime);
		paraMap.put("endTime", endTime);
		paraMap.put("actionType", actionType);
		paraMap.put("actionPeopre", actionPeopre);
		paraMap.put("sortname", sortname);
		paraMap.put("sortorder", sortorder);
		return this.getSqlMapClientTemplate().queryForList("Log.selLog",paraMap);
	}
*/
	public List selLog(int start, int end, Date startTime, Date endTime,
			String actionType, String actionPeopre,String sortname,String sortorder) {
		HashMap<String, Comparable> paraMap= new HashMap<String, Comparable>();
		paraMap.put("start", start);
		paraMap.put("end", end);
		paraMap.put("startTime", startTime);
		paraMap.put("endTime", endTime);
		paraMap.put("actionType", actionType);
		paraMap.put("actionPeopre", actionPeopre);
		paraMap.put("sortname", sortname);
		paraMap.put("sortorder", sortorder);
		return this.getSqlMapClientTemplate().queryForList("Log.selLog",paraMap);
	}

	public int countLog(Date startTime, Date endTime, String actionType,
			String actionPeopre) {
		HashMap<String, Comparable> paraMap= new HashMap<String, Comparable>();
		paraMap.put("startTime", startTime);
		paraMap.put("endTime", endTime);
		paraMap.put("actionType", actionType);
		paraMap.put("actionPeopre", actionPeopre);
		return (Integer)this.getSqlMapClientTemplate().queryForObject("Log.countLog", paraMap);
	}


	public int deleteLog(String logId) {
		return (Integer)this.getSqlMapClientTemplate().delete("Log.deleteLog",logId);
	}
}