package com.tyust.service.user;

import java.util.List;

import com.tyust.bean.user.TBaseDefinedUrl;
import com.tyust.dao.user.ImoduleDao;
import com.tyust.service.user.ModuleService;

public class ModuleServiceImpl implements ModuleService {
	private ImoduleDao moduleDao;
	public ImoduleDao getModuleDao() {
		return moduleDao;
	}
	public void setModuleDao(ImoduleDao moduleDao) {
		this.moduleDao = moduleDao;
	}
	//查询全部菜单
	public List selectMenu() {
		return moduleDao.selectMenu();
	}
	 //根据上级菜单编号查询菜单
	public List selectModuleByUpid(String upModuleId) {
		return moduleDao.selectModuleByUpid(upModuleId);
	}
	 //查询最大菜单编号
	  public String selectMaxMenuId() {
		return moduleDao.selectMaxMenuId();
	}
	  //根据上级编号，查询下级菜单最大编号
	  public String selectMaxModuleId(String upId) {
		return moduleDao.selectMaxModuleId(upId);
	}
	  //插入菜单
	  public int insertModule(TBaseDefinedUrl tbasedefinedurl) {
		return moduleDao.insertModule(tbasedefinedurl);
	}
	  //删除菜单
	  public int deleteModule(TBaseDefinedUrl tbasedefinedurl) {
		return moduleDao.deleteModule(tbasedefinedurl);
	}
	  //修改菜单
	  public int updateModule(TBaseDefinedUrl tbasedefinedurl) {
		return moduleDao.updateModule(tbasedefinedurl);
	}
}
