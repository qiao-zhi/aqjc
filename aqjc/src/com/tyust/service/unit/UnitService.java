package com.tyust.service.unit;

import java.util.List;

import com.tyust.bean.unit.TBaseUnitInfo;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.common.CommonalityBean;

public interface UnitService {
	//查询最高机构
	public List selectMaxUnit();
	//查询下级机构
	public List findByUpid(String upId);
	//
	public int selectCountByUpid(String upid);
	//
	public List findAllByUpid(CommonalityBean comm);
	public List<TBaseUnitInfo> findAll();
	//添加机构
	public int savaUnit(TBaseUnitInfo unitInfo);
	//更新机构
	public int updateUnit(TBaseUnitInfo unitInfo);
	//判断有没有同名机构
	public List findUnit(TBaseUnitInfo unitInfo);
	//根据机构编号，查询该机构下有没有用户
	public List selectUserInfoByUnitId(String unitId);
	//根据机构编号删除权限
	public int delUnitRoleModule(String unitId);
	//根据机构编号删除角色
	public int delUnitRoleByUnitId(String unitId);
	//删除机构
	public int delUnit(String unitId);
	//查询救助类型
	//public List selectDicByupid(String upId);
	//
	public TBaseUnitInfo findUnit(String unitId);
	
	public int registerUser(TBaseUserInfo user,TBaseUnitInfo unitInfo);	//注册用户
}
