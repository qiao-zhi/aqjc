package com.tyust.web.action.user;


import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


import com.tyust.bean.unit.TBaseUnitRole;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.common.OpertionType;
import com.tyust.common.SaveLog;
import com.tyust.service.user.RoleService;

public class AddRoleAction{
	//角色服务层接口
	private RoleService roleService;
	
	private String roleName;

	private int inuse;
	
	private String unitId;
	
	private String description;
	
	public RoleService getRoleService() {
		return roleService;
	}


	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public int getInuse() {
		return inuse;
	}


	public void setInuse(int inuse) {
		this.inuse = inuse;
	}


	public String getUnitId() {
		return unitId;
	}


	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String execute(){
		HttpServletRequest request=ServletActionContext.getRequest();
		  TBaseUnitRole role=new TBaseUnitRole();
		 role.setRoleName(roleName);
		 role.setUnitId(unitId);
		 request.setAttribute("unitid", unitId);
		 Random rd = new Random();
			String id = String.valueOf(rd.nextLong());
			role.setRoleId(id);
			role.setInuse(inuse);
			TBaseUserInfo user=(TBaseUserInfo)request.getSession().getAttribute("user");
			role.setDescription(description);
			role.setCreateUnitId(user.getUnitId());

			roleService.insertRole(role);
			 SaveLog.saveLog(request, "添加角色", OpertionType.State.ADD, "添加成功");
			    

		       return "success";
	}
}
