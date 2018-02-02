package com.tyust.service.user;

import java.util.List;

import com.tyust.bean.unit.TBaseUnitRole;
import com.tyust.bean.unit.TBaseUnitRoleModule;
import com.tyust.bean.user.TBaseDefinedUrl;

public interface RoleService {
	//根据机构编号查询角色
	public List findAllUnitRole(String unitId);
	//根据角色编号查询权限
	public List findRoleModules(String roleId);
	//添加角色
	public int insertRole(TBaseUnitRole role);
	//更新角色
	public int updateRole(TBaseUnitRole role);
	//删除角色
	public int deleteRole(String roleId);
	//清除角色权限
	public int deleteRoleModule(String roleId);
	//查询所有权限
	public List selectModule(String flag);
	//分配权限
	public int insertRoleModule(TBaseUnitRoleModule rModule);
	public List<TBaseDefinedUrl> selectModuleByRoleId(String userId);
}
