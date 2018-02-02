package com.tyust.service.user;

import java.util.List;

import com.tyust.bean.unit.TBaseUnitRole;
import com.tyust.bean.unit.TBaseUnitRoleModule;
import com.tyust.bean.user.TBaseDefinedUrl;
import com.tyust.dao.unit.IroleDao;
import com.tyust.dao.user.ImoduleDao;
import com.tyust.service.user.RoleService;

public class RoleServiceImpl implements RoleService {
	//角色DAO接口
	private IroleDao roleDao;
	//菜单DAO接口
	private ImoduleDao moduleDao;
	
	public ImoduleDao getModuleDao() {
		return moduleDao;
	}
	public void setModuleDao(ImoduleDao moduleDao) {
		this.moduleDao = moduleDao;
	}
	public IroleDao getRoleDao() {
		return roleDao;
	}
	public void setRoleDao(IroleDao roleDao) {
		this.roleDao = roleDao;
	}
	//根据机构编号查询角色
	public List findAllUnitRole(String unitId) {
		return roleDao.findAllUnitRole(unitId);
	}
	//根据角色编号查询权限
	public List findRoleModules(String roleId) {
		return roleDao.findRoleModules(roleId);
	}
	//添加角色
	public int insertRole(TBaseUnitRole role) {
		return roleDao.insertRole(role);
	}
	//更新角色
	public int updateRole(TBaseUnitRole role) {
		return roleDao.updateRole(role);
	}
	//删除角色
	public int deleteRole(String roleId) {
		return roleDao.deleteRole(roleId);
	}
	//清除角色权限
	public int deleteRoleModule(String roleId) {
		return roleDao.deleteRoleModule(roleId);
	}
	
	// 根据角色ID查询权限
	public List<TBaseDefinedUrl> selectModuleByRoleId(String userId){
		return roleDao.selectModuleByRoleId(userId);
	}
	
	//查询权限
	public List selectModule(String flag) {
		String str = "";
		if("0".equals(flag)){
			str = "-1";
		}
		if("1".equals(flag)){
			str = "2";
		}
		if("2".equals(flag)){
			str = "1";
		}
		return moduleDao.selectModule(str);
	}
	//分配权限
	public int insertRoleModule(TBaseUnitRoleModule rModule) {
		return roleDao.insertRoleModule(rModule);
	}
}
