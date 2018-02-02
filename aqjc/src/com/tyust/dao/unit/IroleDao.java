package com.tyust.dao.unit;

import java.util.List;

import com.tyust.bean.unit.TBaseUnitRole;
import com.tyust.bean.unit.TBaseUnitRoleModule;
import com.tyust.bean.user.TBaseDefinedUrl;

/**、
 * TODO 这里有些问题， 主键是(unitId,roleId) 更新，删除的参数却是 roleId
 * 并且，role应该可以复用。不是一个单位一个角色
 * @author Administrator
 *
 */
public interface IroleDao {
	//增加角色
	public int insertRole(TBaseUnitRole tbaseUnitRole);
	//编辑角色信息
	public int updateRole(TBaseUnitRole tbaseUnitRole);
	//删除角色
	public int deleteRole(String roleId);
	//查看某机构的所有角色
	public List  findAllUnitRole(String unitId);
	//查询某角色所拥有的权限
	public List<TBaseDefinedUrl>  findRoleModules(String roleId);
	//为角色分配权限
	public  int insertRoleModule(TBaseUnitRoleModule tbaseUnitRoleModule);
	//清除权限
	public int deleteRoleModule(String roleId);

	public List<TBaseDefinedUrl> selectModuleByRoleId(String userId);

}
