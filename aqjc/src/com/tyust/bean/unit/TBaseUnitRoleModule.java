package com.tyust.bean.unit;

import java.io.Serializable;

/**
 *机构权限
 */
public class TBaseUnitRoleModule implements Serializable{

	private String unitId;

	private String roleId;

	private String moduleId;

	 

	 

	public String getUnitId() {
		return unitId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

}
