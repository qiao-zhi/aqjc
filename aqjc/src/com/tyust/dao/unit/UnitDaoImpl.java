package com.tyust.dao.unit;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tyust.bean.unit.TBaseUnitInfo;
import com.tyust.common.CommonalityBean;
import com.tyust.dao.unit.IunitDao;

public class UnitDaoImpl extends SqlMapClientDaoSupport implements IunitDao {
	public int delUnit(String id) {
		Object i = this.getSqlMapClientTemplate().delete("UnitInfo.delUnit", id);
		int result = 0;
		if (i != null) {
			result = 1;
		}
		return result;
	}

	public int delUnitRoleByUnitId(String id) {
		Object i = this.getSqlMapClientTemplate().delete("UnitInfo.delRoleByUnit", id);
		int result = 0;
		if (i != null) {
			result = 1;
		}
		return result;
	}

	public List<TBaseUnitInfo> findAllByUpid(CommonalityBean comm) {
		List<TBaseUnitInfo> list = this.getSqlMapClientTemplate().queryForList("UnitInfo.findAllByUpid", comm);
		return list;
	}

	public List<TBaseUnitInfo> findByUpid(String pid) {
		List<TBaseUnitInfo> list = this.getSqlMapClientTemplate().queryForList("UnitInfo.findByUpid", pid);
		return list;
	}

	public List<TBaseUnitInfo> findAll() {
		List<TBaseUnitInfo> list = this.getSqlMapClientTemplate().queryForList("UnitInfo.findAll",null);
		return list;
	}

	/**
	 * TODO //要求返回一个单位，但是却用了List来作为返回值 返回一个单位，返回值为TBaseUnitInfo
	 */
	public TBaseUnitInfo findUnit(String id) {
		TBaseUnitInfo unit = (TBaseUnitInfo) this.getSqlMapClientTemplate().queryForObject("UnitInfo.selectUnitInfo",
				id);
		return unit;
	}

	public List<TBaseUnitInfo> findUnit(TBaseUnitInfo tbaseUnitInfo) {
		return this.getSqlMapClientTemplate().queryForList("UnitInfo.selUnitInfo", tbaseUnitInfo);
	}

	public int savaUnit(TBaseUnitInfo tbaseUnitInfo) {
		Object i = this.getSqlMapClientTemplate().insert("UnitInfo.savaUnit", tbaseUnitInfo);
		if (i != null) {
			return 1;
		} else {
			return 0;
		}
	}

	public int updateUnit(TBaseUnitInfo tbaseUnitInfo) {
		Object i = this.getSqlMapClientTemplate().insert("UnitInfo.updateUnit", tbaseUnitInfo);
		if (i != null) {
			return 1;
		} else {
			return 0;
		}
	}

	public List<TBaseUnitInfo> selectMaxUnit() {
		List<TBaseUnitInfo> list = this.getSqlMapClientTemplate().queryForList("UnitInfo.maxUnit", null);
		if (list != null) {
			return list;
		}
		return null;
	}

	public int selectCountByUpid(String upid) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("UnitInfo.selectCountByUpid", upid);
	}

	public int registerUnit(TBaseUnitInfo tbaseUnitInfo) {
		Object i = this.getSqlMapClientTemplate().insert("UnitInfo.registerUnit", tbaseUnitInfo);
		if (i != null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public List<TBaseUnitInfo> selectUnitInfoByUnitName(String unitName) {
		return this.getSqlMapClientTemplate().queryForList("UnitInfo.selectUnitInfoByUnitName", unitName);
	}

}
