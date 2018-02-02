package com.tyust.service.user;

import java.util.List;

import com.tyust.bean.user.TBaseDefinedUrl;
import com.tyust.bean.user.TBaseUnitUserRole;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.common.CommonalityBean;

public interface UserService {
	//根据用户名和密码查询用户
	public TBaseUserInfo login(String username,String password);
	//如果登录成功，则修改登录时间
	public void updateLoginDate(TBaseUserInfo user);
	//root登录时查询全部菜单
	public List selectModule(String memo2);
	//根据用户ID查询相应的菜单
	public List selectModuleByuserId(String userId);
	//根据用户ID查询相应的虚拟菜单
	public boolean haveVirtualModule(String userId,String moduleId) ;
	//查询用户
	public List selectUserInfo(CommonalityBean comm);
	//查询用户数
	public int selectUserAllCount(String unitId);
	//判断用户名是否存在
	public boolean selectUserIsExist(String username);
	//添加用户
	public void insertUser(TBaseUserInfo tbaseuserinfo);
	//修改密码
	public int updatePwd(String userId,String newPwd);
	//修改用户基本信息
	public void updateUser(TBaseUserInfo userInfo);
	//判断该用户是否已分配角色
	public int selectIsExistUserRole(String userId);
	//清除角色
	public boolean deleteUserRole(String userId);
	//给用户分配角色
	public boolean insertUserRole(TBaseUnitUserRole userrole);
	//删除用户
	public int deleteUser(String userId);
	public String selectUserByUnitId(String unitId);
	
	public List<TBaseUserInfo> selectUserById(String userId);
}
