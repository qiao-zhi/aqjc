package com.tyust.dao.unit;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tyust.bean.unit.TBaseUnitRoleModule;
import com.tyust.dao.unit.IunitRoleModuleDao;

public class UnitRoleModuleImpl extends SqlMapClientDaoSupport implements IunitRoleModuleDao {

	//根据机构删除权限
	public int delUnitRoleModule(String unitId) {
		Object i = this.getSqlMapClientTemplate().delete("rolemodule.delUnitRoleModule", unitId);
		if(i!=null){
			return 1;
		}else{
			return 0;
		}
	}
	//根据机构和用户查询权限
	public List findUnitModule(TBaseUnitRoleModule unitRoleModule) {

		return this.getSqlMapClientTemplate().queryForList("rolemodule.selectrm",unitRoleModule);
	}
}
