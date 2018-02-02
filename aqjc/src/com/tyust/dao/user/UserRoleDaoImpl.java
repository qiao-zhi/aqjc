package com.tyust.dao.user;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tyust.bean.user.TBaseUnitUserRole;
import com.tyust.dao.user.IuserRoleDao;

public class UserRoleDaoImpl extends SqlMapClientDaoSupport implements IuserRoleDao {


	public boolean insertUserRole(TBaseUnitUserRole userrole) {
		Object o = this.getSqlMapClientTemplate().insert("UnitUserRole.addUserRole",userrole);
		if(o==null){
			return true;
		}else{
			return false;
		}
	}

	public boolean deleteUserRole(String userId) {
		Object o = this.getSqlMapClientTemplate().delete("UnitUserRole.delUserRole",userId);
		if(o==null){
			return true;
		}else{
			return false;
		}
	}

	public List findRoleByUnitId(TBaseUnitUserRole unitUserRole) {
		  List list = this.getSqlMapClientTemplate().queryForList("UnitUserRole.selUserRoles",unitUserRole);
		  if(list.size()>0){
			  return list;
		  }else{
			  return null;
		  }
	}

	public List findRole(TBaseUnitUserRole userRole) {
		return this.getSqlMapClientTemplate().queryForList("UnitUserRole.findRoleByUnitId",userRole);
	}



	public List selectRoleByUnitIds(String unitId) {
		 List list = this.getSqlMapClientTemplate().queryForList("UnitUserRole.findRoleByUnitIds",unitId);
		  if(list.size()>0){
			  return list;
		  }else{
			  return null;
		  }
	}

	public int selectIsExistUserRole(String userId) {

		return (Integer)this.getSqlMapClientTemplate().queryForObject("UnitUserRole.selectIsExistUserRole",userId);
	}

	public List findRoleByUnitId(String unitId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findRoleByUnitIds(String unitId) {
		// TODO Auto-generated method stub
		return null;
	}
}
