package com.tyust.dao.user;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tyust.bean.user.TBaseDefinedUrl;
import com.tyust.dao.user.ImoduleDao;

public class ModuleDaoImpl extends SqlMapClientDaoSupport implements ImoduleDao{


	public List selectModule(String memo2) {
		List list = this.getSqlMapClientTemplate().queryForList("module.selectAllmodule", memo2);
		return list;
	}

	public int deleteModule(TBaseDefinedUrl tbasedefinedurl) {

		return this.getSqlMapClientTemplate().delete("module.deleteModule",tbasedefinedurl);
	}

	public int insertModule(TBaseDefinedUrl tbasedefinedurl) {
		Object obj = this.getSqlMapClientTemplate().insert("module.insertModule",tbasedefinedurl);
		if(obj!=null){
			return 1;
		}
		return 0;
	}

	public int updateModule(TBaseDefinedUrl tbasedefinedurl) {
		return this.getSqlMapClientTemplate().update("module.updateModule",tbasedefinedurl);
	}

	public List selectModuleByUpid(String upid) {
		List list = this.getSqlMapClientTemplate().queryForList("module.selectModuleByUpid",upid);
		if(list!=null){
			return list;
		}
		return null;
	}

	public List selectMenu() {
		List list = this.getSqlMapClientTemplate().queryForList("module.selectMenu",null);
		if(list!=null){
			return list;
		}
		return null;
	}

	public String selectMaxMenuId() {
		Object obj = this.getSqlMapClientTemplate().queryForObject("module.selectMaxMenuId");
		if(obj!=null){
			return obj.toString();
		}
		return null;
	}

	public String selectMaxModuleId(String upid) {
		Object obj = this.getSqlMapClientTemplate().queryForObject("module.selectMaxModuleId",upid);
		if(obj!=null){
			return obj.toString();
		}
		return null;
	}

	public List selectModuleByuserId(String userId) {
		List list = this.getSqlMapClientTemplate().queryForList("module.selectModuleByuserId",userId);
		if(list!=null){
			return list;
		}
		return null;
	}
	public List<TBaseDefinedUrl> selectVirtualModuleByuserId(String userId) {
		List<TBaseDefinedUrl> list = this.getSqlMapClientTemplate().queryForList("module.selectVirtualModuleByuserId",userId);
		return list;
	}
}
