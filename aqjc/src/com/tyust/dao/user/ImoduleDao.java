package com.tyust.dao.user;

import java.util.List;

import com.tyust.bean.user.TBaseDefinedUrl;

public interface ImoduleDao {
	/**
	 * 查询所有菜单项
	 * @return
	 */
	public List selectModule(String memo2);
	/**
	 * 添加菜单项
	 * @param tbasedefinedurl
	 * @return
	 */
	public int insertModule(TBaseDefinedUrl tbasedefinedurl);
	/**
	 * 修改菜单项
	 * @param tbasedefinedurl
	 * @return
	 */
	public int updateModule(TBaseDefinedUrl tbasedefinedurl);
	/**
	 * 删除菜单项
	 * @param tbasedefinedurl
	 * @return
	 */
	public int deleteModule(TBaseDefinedUrl tbasedefinedurl);
	/**
	 * 查询子菜单
	 * @param upid
	 * @return
	 */
	public List selectModuleByUpid(String upid);
	/**
	 * 查询一级菜单
	 * @return
	 */
	public List selectMenu();
	/**
	 * 获取一级菜单最大编号
	 * @return
	 */
	public String selectMaxMenuId();
	/**
	 *获取子菜单最大编号
	 * @param upid
	 * @return
	 */
	public String selectMaxModuleId(String upid);
	/**
	 * 根据用户ID查询菜单
	 * @param userId
	 * @return
	 */
	public List selectModuleByuserId(String userId);
	/**
	 * 根据用户ID查询菜单
	 * @param userId
	 * @return
	 */
	public List<TBaseDefinedUrl> selectVirtualModuleByuserId(String userId);
}
