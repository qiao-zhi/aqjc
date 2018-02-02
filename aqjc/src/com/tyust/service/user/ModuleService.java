package com.tyust.service.user;

import java.util.List;

import com.tyust.bean.user.TBaseDefinedUrl;

public interface ModuleService {
	//查询全部菜单
  public List selectMenu();
  //根据上级菜单编号查询菜单
  public List selectModuleByUpid(String upModuleId);
  //查询最大菜单编号
  public String selectMaxMenuId();
  //根据上级编号，查询下级菜单最大编号
  public String selectMaxModuleId(String upId);
  //插入菜单
  public int insertModule(TBaseDefinedUrl tbasedefinedurl);
  //删除菜单
  public int deleteModule(TBaseDefinedUrl tbasedefinedurl);
  //修改菜单
  public int updateModule(TBaseDefinedUrl tbasedefinedurl);
}
