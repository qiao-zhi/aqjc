package com.tyust.bean.log;

import java.util.Date;

//日志javabean
public class Log {
	private String logId;
	private String actionType;//日志类型
	private String actionPeopre;//操作人
	private String actionUnit;//操作单位
	private Date actionDate;//操作时间
	private String actionResult;//操作结果
	private String ip;
	private String opeprateObject;//操作对象
	
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getActionPeopre() {
		return actionPeopre;
	}
	public void setActionPeopre(String actionPeopre) {
		this.actionPeopre = actionPeopre;
	}
	public String getActionUnit() {
		return actionUnit;
	}
	public void setActionUnit(String actionUnit) {
		this.actionUnit = actionUnit;
	}
	public Date getActionDate() {
		return actionDate;
	}
	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}
	public String getActionResult() {
		return actionResult;
	}
	public void setActionResult(String actionResult) {
		this.actionResult = actionResult;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getOpeprateObject() {
		return opeprateObject;
	}
	public void setOpeprateObject(String opeprateObject) {
		this.opeprateObject = opeprateObject;
	}
	
}
