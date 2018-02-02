/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.tyust.web.action.user;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.tyust.bean.unit.TBaseUnitInfo;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.common.OpertionType;
import com.tyust.common.SaveLog;
import com.tyust.service.unit.UnitService;
import com.tyust.service.user.UserService;

public class RegisterAction {
	
	private UnitService unitService;
	private UserService userService;
	
	private String username;
	private String unit;
	private String password;
	private String tel;

	public UnitService getUnitService() {
		return unitService;
	}

	public void setUnitService(UnitService unitService) {
		this.unitService = unitService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String execute() {
		TBaseUserInfo tbaseuserinfo = new TBaseUserInfo();
		TBaseUnitInfo unitInfo = new TBaseUnitInfo();
		HttpServletRequest request=ServletActionContext.getRequest();
		//用户名是否存在
		if(userService.selectUserIsExist(username.trim().toUpperCase())){
			request.setAttribute("message", "用户名已存在，请重新输入");
			return "input";
		}
		String unitid = UUID.randomUUID().toString();
		unitInfo.setUnitId(unitid);
		unitInfo.setUnitName(unit);
		unitInfo.setUpUnitId("-1");
		unitInfo.setCreateDate(new Date());
		
		tbaseuserinfo.setUserId(UUID.randomUUID().toString());
		tbaseuserinfo.setUserName(username.trim().toUpperCase());
		tbaseuserinfo.setTelephone(tel.trim());
		tbaseuserinfo.setPassword(password.trim());
		tbaseuserinfo.setUnitId(unitid);
		tbaseuserinfo.setTecduty("2");
		tbaseuserinfo.setCreateTime(new Date());
		tbaseuserinfo.setInuse(1);
		
		int res = 0;
		try{
			res = unitService.registerUser(tbaseuserinfo, unitInfo);
		}catch(Exception e){
			e.printStackTrace();
			SaveLog.saveLog(request, "注册用户", OpertionType.State.ADD, "注册失败："+e.toString());
		}
		if(res>0){
			request.setAttribute("message", "注册成功，请进行登录");
			SaveLog.saveLog(request, "注册用户", OpertionType.State.ADD,"成功注册用户:"+username);
			return "success";
		}else{
			request.setAttribute("message", "注册失败");
			return "input";
		}
		
	}
}