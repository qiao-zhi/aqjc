package com.tyust.dao.user;

import java.util.List;

import com.tyust.bean.user.TBaseUnitUserRole;

public interface IuserRoleDao {
/**
 * 查询该机构下所有的角色
 */
public List selectRoleByUnitIds(String unitId);
/**
 * 给用户添加角色
 */
public boolean insertUserRole(TBaseUnitUserRole userrole);
/**
 * 清除角色
 */
public boolean deleteUserRole(String userId);
/**
 * 判断该用户是否已分配角色
 * @param userId
 * @return
 */
public int selectIsExistUserRole(String userId);


public List findRoleByUnitIds(String unitId);

public List findRoleByUnitId(TBaseUnitUserRole unitUserRole);
//查询权限
public List findRole(TBaseUnitUserRole userRole);

public List findRoleByUnitId(String unitId);


}
