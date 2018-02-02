package com.tyust.web.action.user;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.tyust.bean.user.TBaseUnitUserRole;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.common.OpertionType;
import com.tyust.common.SaveLog;
import com.tyust.service.user.UserService;

public class AddUnitAdminAction {

	/**
	 * 添加部门管理员
	 * 
	 * 功能：1.新建部门管理员用户 2.为新用户分配管理员角色
	 */

	private UserService userService;

	// 参数
	private String userName;
	private String password;
	private String unitId;
	private String inuse;
	private String roleId;

	public String execute() {
		TBaseUserInfo userInfo = new TBaseUserInfo();
		HttpServletRequest request = ServletActionContext.getRequest();
		// 用户名是否存在
		if (userService.selectUserIsExist(userName.trim().toUpperCase())) {
			request.setAttribute("message", "用户名已存在，请重新输入");
			return "input";
		}
		String userId = UUID.randomUUID().toString();
		userInfo.setUserId(userId);
		userInfo.setUserName(userName.toUpperCase().trim());
		userInfo.setPassword(password);
		userInfo.setUnitId(unitId);
		userInfo.setInuse(new Integer(inuse));
		userInfo.setCreateTime(new Date());

		TBaseUnitUserRole userRole = new TBaseUnitUserRole();
		userRole.setRoleId(roleId);
		userRole.setUserId(userId);
		userRole.setUnitId(unitId);
		try {
			userService.insertUser(userInfo);
			userService.insertUserRole(userRole);
			SaveLog.saveLog(request, "分配部门管理员", OpertionType.State.ADD, "分配部门管理员:" + userInfo.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
			SaveLog.saveLog(request, "分配部门管理员", OpertionType.State.ADD, "添加失败：" + e.toString());
		}
		request.setAttribute("message", "添加用户成功");
		return "success";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getInuse() {
		return inuse;
	}

	public void setInuse(String inuse) {
		this.inuse = inuse;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
