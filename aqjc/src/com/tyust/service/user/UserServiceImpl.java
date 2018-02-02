package com.tyust.service.user;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tyust.bean.user.TBaseDefinedUrl;
import com.tyust.bean.user.TBaseUnitUserRole;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.common.CommonalityBean;
import com.tyust.dao.user.ImoduleDao;
import com.tyust.dao.user.IuserDao;
import com.tyust.dao.user.IuserRoleDao;
import com.tyust.service.user.UserService;

public class UserServiceImpl implements UserService {
	//用户DAO接口
	private IuserDao userDao;
	//用户角色DAO接口
	private IuserRoleDao userRoleDao;
	 
	public IuserRoleDao getUserRoleDao() {
		return userRoleDao;
	}
	public void setUserRoleDao(IuserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}
	public IuserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(IuserDao userDao) {
		this.userDao = userDao;
	}
	//菜单DAO接口
	private ImoduleDao moduleDao;
	
	public ImoduleDao getModuleDao() {
		return moduleDao;
	}
	public void setModuleDao(ImoduleDao moduleDao) {
		this.moduleDao = moduleDao;
	}
	//根据用户名和密码查询用户
	public TBaseUserInfo login(String username, String password) {
		return userDao.selectLogin(username.toUpperCase().trim(),password.trim());
	}
	//如果登录成功，则修改登录时间
	public void updateLoginDate(TBaseUserInfo user) {
		TBaseUserInfo tbaseuserinfo = new TBaseUserInfo();
        tbaseuserinfo.setUserId(user.getUserId());
        tbaseuserinfo.setLastLoginTime(new Date());
        userDao.updateUserLastLoginTime(tbaseuserinfo);
	}

	//root登录时查询全部菜单
	public List selectModule(String memo2) {
		return moduleDao.selectModule(memo2);
	}
	//根据用户ID查询相应的菜单
	public List selectModuleByuserId(String userId) {
		return moduleDao.selectModuleByuserId(userId);
	}
	//根据用户ID查询相应的虚拟菜单
	public boolean haveVirtualModule(String userId,String moduleId) {
		boolean isHave = false;
		List<TBaseDefinedUrl> list =  moduleDao.selectVirtualModuleByuserId(userId);
		if(list!=null&&list.size()>0){
			for(int i=0;i<list.size();i++){
				TBaseDefinedUrl url = list.get(i);
				if(moduleId.equals(url.getModuleId())){
					isHave = true;
					return isHave;
				}
			}
		}
		return isHave;
	}
	//查询用户
	public List selectUserInfo(CommonalityBean comm) {
		return userDao.selectUserInfo(comm);
	}
	//查询用户数
	public int selectUserAllCount(String unitId) {
		return userDao.selectUserAllCount(unitId);
	}
	//判断用户名是否存在
	public boolean selectUserIsExist(String username) {
		return userDao.selectUserIsExist(username);
	}
	//添加用户
	public void insertUser(TBaseUserInfo tbaseuserinfo) {
		userDao.insertUser(tbaseuserinfo);
	}
	//修改密码
	public int updatePwd(String userId,String newPwd) {
		return userDao.updatePwd(userId, newPwd);
	}
	//修改用户基本信息
	public void updateUser(TBaseUserInfo userInfo) {
		userDao.updateUser(userInfo);
	}
	//判断该用户是否已分配角色
	public int selectIsExistUserRole(String userId) {
		return userRoleDao.selectIsExistUserRole(userId);
	}
	//清除角色
	public boolean deleteUserRole(String userId) {
		return userRoleDao.deleteUserRole(userId);
	}
	//给用户分配角色
	public boolean insertUserRole(TBaseUnitUserRole userrole) {
		return userRoleDao.insertUserRole(userrole);
	}
	//删除用户
	public int deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}
	
	/**
	 * 通过部门id查询用户信息
	 * @return
	 */
		public String selectUserByUnitId(String unitId){
			TBaseUserInfo userInfo = new TBaseUserInfo();
			JSONArray jsonList = new JSONArray();
			@SuppressWarnings("unchecked")
			List<TBaseUserInfo> list = userDao.selectUserInfoByUnitId(unitId);
			if(list != null && list.size() != 0){			
				for(int i = 0; i < list.size(); i++){
					JSONObject json = new JSONObject();
					userInfo = list.get(i);
					try {
						json.put("id", userInfo.getUserId());
						json.put("text", userInfo.getName());
						 
					} catch (JSONException e) {
						e.printStackTrace();
					}
					jsonList.put(json);
				}
			}
			return jsonList.toString();
		}
	@Override
	public List<TBaseUserInfo> selectUserById(String userId) {
		return userDao.selectUserInfoById(userId);
	}
}
