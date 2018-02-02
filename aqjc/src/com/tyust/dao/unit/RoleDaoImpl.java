package com.tyust.dao.unit;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tyust.bean.unit.TBaseUnitRole;
import com.tyust.bean.unit.TBaseUnitRoleModule;
import com.tyust.bean.user.TBaseDefinedUrl;
import com.tyust.dao.unit.IroleDao;

public class RoleDaoImpl extends SqlMapClientDaoSupport implements IroleDao {

	public int deleteRole(String roleId) {
		// System.out.println("delete:roleid"+roleId);
		int i = this.getSqlMapClientTemplate().delete("UnitRole.deleteRole", roleId);
		// System.out.println("deleeterole: i*******"+i);
		if (i == 1) {
			// System.out.println(i+"delete:1");
			return 1;
		} else {
			// System.out.println("delete:0");
			return 0;
		}
	}

	public List<TBaseUnitRole> findAllUnitRole(String unitId) {
		return this.getSqlMapClientTemplate().queryForList("UnitRole.findUnitRole", unitId);
	}

	public List findRoleModules(String roleId) {
		return this.getSqlMapClientTemplate().queryForList("UnitRole.findRoleModules", roleId);
	}

	public int insertRoleModule(TBaseUnitRoleModule tbaseUnitRoleModule) {
		Object i = this.getSqlMapClientTemplate().insert("UnitRole.addRoleModule", tbaseUnitRoleModule);

		if (i != null) {
			return 1;
		} else {
			return 0;
		}
	}

	public int insertRole(TBaseUnitRole tbaseUnitRole) {
		Object i = this.getSqlMapClientTemplate().insert("UnitRole.saveRole", tbaseUnitRole);
		// System.out.println("insertrole:i---"+i);
		if (i == null) {
			return 1;
		} else {
			return 0;
		}
	}

	public int updateRole(TBaseUnitRole tbaseUnitRole) {
		Object i = this.getSqlMapClientTemplate().update("UnitRole.updateRole", tbaseUnitRole);
		if (i == null) {
			return 1;
		} else {
			return 0;
		}
	}

	// 清除角色权限
	public int deleteRoleModule(String roleId) {
		Object i = this.getSqlMapClientTemplate().delete("UnitRole.delRoleModule", roleId);
		if (i == null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public List<TBaseDefinedUrl> selectModuleByRoleId(String userId) {
		return this.getSqlMapClientTemplate().queryForList("module.selectModuleByRoleId", userId);
	}

}
