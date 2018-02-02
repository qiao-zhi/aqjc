package com.tyust.web.action.log;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tyust.bean.log.Log;
import com.tyust.common.DateHandler;
import com.tyust.service.log.LogService;

public class LogAction{
private LogService logService;
	public LogService getLogService() {
	return logService;
}

public void setLogService(LogService logService) {
	this.logService = logService;
}

	//查询，显示日志
	public String selLog() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		int pagec = Integer.parseInt(request.getParameter("page")) ;
		int tiaoc = Integer.parseInt(request.getParameter("rp")) ;

		String startTimeStr =request.getParameter("text1").trim();
		String endTimeStr =request.getParameter("text2").trim();
		String actionType =request.getParameter("text3").trim();
		String actionPeopre =request.getParameter("text4").trim();
		String sortname = request.getParameter("sortname");
		String sortorder = request.getParameter("sortorder");
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("actionUnit", "ACTION_UNIT");
		map.put("actionPeopre", "ACTION_PEOPRE");
		map.put("opeprateObject", "OPERATE_OBJECT");
		map.put("actionType", "ACTION_TYPE");
		map.put("ip", "IP");
		map.put("actionDate", "ACTION_DATE");
		map.put("actionResult", "ACTION_RESULT");
		map.put("logId", "ID");
		sortname = map.get(sortname).toString();
		Date startTime = null;
		Date endTime = null;
		if(startTimeStr!=null && !startTimeStr.equals("undefined")){
			startTime = DateHandler.changeStringToDate(startTimeStr,"yyyy-MM-dd HH:mm:ss");
		}
		if(endTimeStr!=null && !endTimeStr.equals("undefined")){
			endTime = DateHandler.changeStringToDate(endTimeStr,"yyyy-MM-dd HH:mm:ss");
		}
		if(actionType.equals("undefined")||actionType.equals("")){
			actionType = null;
		}
		if(actionPeopre.equals("actionPeopre")||actionPeopre.equals("")){
			actionPeopre = null;
		}
		int end = pagec*tiaoc; // 每页的记录数
		int start = (pagec-1)*tiaoc;
		
		int count = logService.countLog(startTime, endTime, actionType, actionPeopre);
		List logList = logService.selLog( start,end, startTime, endTime, actionType, actionPeopre, sortname, sortorder);
		System.out.println("++++++++++++++++++++++++"+logList.size());
		Log log = new Log();
		JSONArray jsonarraylist = new JSONArray();
		JSONObject json2 = new JSONObject();
		try {
			for (int i = 0; i < logList.size(); i++) {
				log = (Log)logList.get(i);
				JSONObject json = new JSONObject();

				json.put("logId",log.getLogId());
				json.put("actionUnit",log.getActionUnit());
				json.put("actionPeopre",log.getActionPeopre());
				json.put("actionDate", DateHandler.dateToString(log.getActionDate(),"yyyy-MM-dd HH:mm:ss"));
				json.put("actionType", log.getActionType());
				json.put("actionResult",log.getActionResult());
				json.put("ip",log.getIp());
				json.put("opeprateObject",log.getOpeprateObject());

				jsonarraylist.put(json);
			}
			json2.put("rows", jsonarraylist);
			json2.put("page", pagec);

			json2.put("total", count);
			
			ServletActionContext.getResponse().getWriter().write(json2.toString());
			return null;
		} catch (JSONException e) {

			e.printStackTrace();
		}
		return null;
	}
	
	//删除日志
	public String deleteLog(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String ids = request.getParameter("ids");
		String[] logId = ids.split(",");
		
		for(int i=0;i<logId.length;i++){
			logService.deleteLog(logId[i]);
		}
		return "success";
	}
}
