package com.tyust.service.unit;

import java.util.List;

import com.tyust.bean.unit.TBaseUnitInfo;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.common.CommonalityBean;
import com.tyust.dao.dic.DictionaryDaoImpl;
import com.tyust.dao.unit.IunitDao;
import com.tyust.dao.unit.IunitRoleModuleDao;
import com.tyust.dao.user.IuserDao;
import com.tyust.service.unit.UnitService;

public class UnitServiceImpl implements UnitService {
	//机构DAO接口
	private IunitDao unitDao;
	//用户DAO接口
	private IuserDao userDao;
	//机构权限DAO接口
	private IunitRoleModuleDao unitRoleModuleDao;
	//字典DAO接口
	private DictionaryDaoImpl dicDao;
	
	public DictionaryDaoImpl getDicDao() {
		return dicDao;
	}
	public void setDicDao(DictionaryDaoImpl dicDao) {
		this.dicDao = dicDao;
	}
	public IunitRoleModuleDao getUnitRoleModuleDao() {
		return unitRoleModuleDao;
	}
	public void setUnitRoleModuleDao(IunitRoleModuleDao unitRoleModuleDao) {
		this.unitRoleModuleDao = unitRoleModuleDao;
	}
	public IuserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(IuserDao userDao) {
		this.userDao = userDao;
	}
	public IunitDao getUnitDao() {
		return unitDao;
	}
	public void setUnitDao(IunitDao unitDao) {
		this.unitDao = unitDao;
	}
	//查询最高机构
	public List selectMaxUnit() {
		return unitDao.selectMaxUnit();
	}
	//查询下级机构
	public List findByUpid(String upId) {
		return unitDao.findByUpid(upId);
	}
	//
	public int selectCountByUpid(String upid) {
		return unitDao.selectCountByUpid(upid);
	}
	//
	public List findAllByUpid(CommonalityBean comm) {
		return unitDao.findAllByUpid(comm);
	}
	// 查询全部部门信息
	public List<TBaseUnitInfo> findAll(){
		return unitDao.findAll();
	}
	//添加机构
	public int savaUnit(TBaseUnitInfo unitInfo) {
		return unitDao.savaUnit(unitInfo);
	}
	//更新机构
	public int updateUnit(TBaseUnitInfo unitInfo) {
		return unitDao.updateUnit(unitInfo);
	}
	//判断有没有同名机构
	public List findUnit(TBaseUnitInfo unitInfo) {
		return unitDao.findUnit(unitInfo);
	}
	//根据机构编号，查询该机构下有没有用户
	public List selectUserInfoByUnitId(String unitId) {
		return userDao.selectUserInfoByUnitId(unitId);
	}
	//根据机构编号删除权限
	public int delUnitRoleModule(String unitId) {
		return unitRoleModuleDao.delUnitRoleModule(unitId);
	}
	//根据机构编号删除角色
	public int delUnitRoleByUnitId(String unitId) {
		return unitDao.delUnitRoleByUnitId(unitId);
	}
	//删除机构
	public int delUnit(String unitId) {
		return unitDao.delUnit(unitId);
	}
	//查询救助类型
	//public List selectDicByupid(String upId) {
	//	return dicDao.selectDicByupid(upId);
	//}
	//
	public TBaseUnitInfo findUnit(String unitId) {
		return unitDao.findUnit(unitId);
	}
	
	public int registerUser(TBaseUserInfo user,TBaseUnitInfo unitInfo){
		int res = 0;
		if(unitDao.registerUnit(unitInfo)>0){
			res = userDao.insertUser(user);
		}
		return res;
	}
}
