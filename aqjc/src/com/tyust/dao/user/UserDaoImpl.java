package com.tyust.dao.user;

import java.util.HashMap;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.common.CommonalityBean;
import com.tyust.dao.user.IuserDao;

public class UserDaoImpl extends SqlMapClientDaoSupport implements IuserDao {

	// 用户登录
	public TBaseUserInfo selectLogin(String username, String password) {
		TBaseUserInfo userinfo = new TBaseUserInfo();
		userinfo.setUserName(username);
		userinfo.setPassword(password);
		List list = this.getSqlMapClientTemplate().queryForList("UserInfo.login", userinfo);
		if (list.size() == 1) {
			TBaseUserInfo user = (TBaseUserInfo) list.get(0);
			return user;
		} else {
			return null;
		}
	}

	// 添加用户
	public int insertUser(TBaseUserInfo tbaseuserinfo) {
		Object i = this.getSqlMapClientTemplate().insert("UserInfo.addUser", tbaseuserinfo);
		if (i == null) {
			return 1;
		} else {
			return 0;
		}
	}

	// 删除用户
	public int deleteUser(String userId) {
		Object i = this.getSqlMapClientTemplate().delete("UserInfo.delUser", userId);
		if (i != null) {
			return 1;
		} else {
			return 0;
		}
	}

	// 修改用户
	public int updateUser(TBaseUserInfo tbaseuserinfo) {
		Object i = this.getSqlMapClientTemplate().update("UserInfo.updateUser", tbaseuserinfo);
		if (i != null) {
			return 1;
		} else {
			return 0;
		}
	}

	// 修改密码
	public int updatePwd(String userId, String password) {
		TBaseUserInfo tbaseuserinfo = new TBaseUserInfo();
		tbaseuserinfo.setUserId(userId);
		tbaseuserinfo.setPassword(password);
		Object i = this.getSqlMapClientTemplate().update("UserInfo.updatePwd", tbaseuserinfo);
		if (i != null) {
			return 1;
		} else {
			return 0;
		}
	}

	// 根据用户id查询用户
	public List<TBaseUserInfo> selectUserInfoById(String userId) {
		List<TBaseUserInfo> list = this.getSqlMapClientTemplate().queryForList("UserInfo.selUserInfoById", userId);
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	/**
	 * 根据条件查询用户信息
	 */
	public List selectUserInfo(CommonalityBean commonality) {
		List list = this.getSqlMapClientTemplate().queryForList("UserInfo.selUserInfo", commonality);
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	/**
	 * 根据机构ID查询用户
	 */
	public List<TBaseUserInfo> selectUserInfoByUnitId(String UnitId) {
		List<TBaseUserInfo> list = this.getSqlMapClientTemplate().queryForList("UserInfo.selUserInfoByUnitId", UnitId);
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	/**
	 * 判断用户名是否存在 存在返回0 不存在返回1
	 */
	public boolean selectUserIsExist(String username) {
		List list = this.getSqlMapClientTemplate().queryForList("UserInfo.userIsExist", username);
		if (list == null || list.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 数据总记录数（分页用的）
	 */
	public int selectUserAllCount(String unitId) {

		return (Integer) this.getSqlMapClientTemplate().queryForObject("UserInfo.userAllCount", unitId);
	}

	/**
	 * 用户的启用/停用
	 */
	public int updateUserInuse(TBaseUserInfo tbaseuserinfo) {
		return this.getSqlMapClientTemplate().update("UserInfo.updateUserInuse", tbaseuserinfo);
	}

	/**
	 * 更新用户登录时间
	 */
	public int updateUserLastLoginTime(TBaseUserInfo tbaseuserinfo) {
		return this.getSqlMapClientTemplate().update("UserInfo.updateUserLastLoginTime", tbaseuserinfo);
	}

	// 田皓怿加，登录页面修改密码
	public int updatePassword(String username, String oldPwd, String newPwd) {
		HashMap map = new HashMap();
		map.put("username", username);
		map.put("oldPwd", oldPwd);
		map.put("newPwd", newPwd);
		return this.getSqlMapClientTemplate().update("UserInfo.updatepassword", map);
	}

	// 田皓怿加，判断用户是否存在
	public int selectUser(String username, String password) {
		HashMap map = new HashMap();
		map.put("username", username);
		map.put("password", password);
		return (Integer) (this.getSqlMapClientTemplate().queryForObject("UserInfo.selectUser", map));
	}

}
