package com.tyust.dao.user;

import java.util.List;

import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.common.CommonalityBean;

public interface IuserDao {
	/**
	 * �û���¼
	 */
 public TBaseUserInfo selectLogin(String username,String password);
 /**
  * ����û�
  */
 public int insertUser(TBaseUserInfo tbaseuserinfo);
 /**
  * ɾ���û�
  * @param userId
  * @return
  */
 public int deleteUser(String userId);
 /**
  * �޸��û�
  * @param tbaseuserinfo
  * @return
  */
 public int updateUser(TBaseUserInfo tbaseuserinfo);
 /**
  * �޸�����
  * @param userId
  * @param password
  * @return
  */
 public int updatePwd(String userId,String password);
// /**
//  * ���ID��ѯ�û�
//  * @param userId
//  * @return
//  */
 public List selectUserInfoById(String userId);
 /**
  * ���������ѯ�û���Ϣ
  * @param commonality
  * @return
  */
 public List selectUserInfo(CommonalityBean commonality);
 /**
  * ��ݻ�ID��ѯ�û�
  */
 public List selectUserInfoByUnitId(String UnitId);
 /**
  * �ж��û����Ƿ����
  */
 public boolean selectUserIsExist(String username);
 /**
  * ��ѯ�ܼ�¼��
  */
 public int selectUserAllCount(String unitId);
 /**
  * �û�����/ͣ��
  */
 public int updateUserInuse(TBaseUserInfo tbaseuserinfo);
 /**
  * �����û���¼ʱ��
  */
 public int updateUserLastLoginTime(TBaseUserInfo tbaseuserinfo);
 //�����ӣ��ж��û��Ƿ����
 public int selectUser(String username,String password);
 //�����ӣ���¼ҳ���޸�����
 public int updatePassword(String username,String oldPwd,String newPwd);
}