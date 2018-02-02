package com.tyust.bean.user;

import java.io.Serializable;
import java.util.Date;
/**
 * �û���Ϣ��
 * @author admin
 *
 */
public class TBaseUserInfo implements Serializable {

	private String userId;

	private String userName;

	private String sex;

	private Date birthday;

	private String unitId;
	
	private String unitName;
	
	private String areaId;
	
	private int inuse;

	private String duty;

	private String tecduty;

	private String password;

	private String telephone;

	private String email;

	private String createUnitId;

	private String cardId;

	private String name;

	private String mobile;
	
	private Date createTime;

	private String userComment;

	private Date lastLoginTime;
    
	private String roleId;

	public String getUserName() {
		System.out.println("+++"+userName+"+++");
		return (userName.isEmpty()? "":userName);
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getDuty() {
		return duty==null? "":duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getTecduty() {
		return tecduty;
	}

	public void setTecduty(String tecduty) {
		this.tecduty = tecduty;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getTelephone() {
		return telephone == null? "":telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email== null? "":email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getName() {
//		System.out.println("***"+name+"+++");
		return (name == null? "":name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getCreateUnitId() {
		return createUnitId;
	}

	public void setCreateUnitId(String createUnitId) {
		this.createUnitId = createUnitId;
	}

	public String getUserComment() {
		return userComment== null? "":userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	public int getInuse() {
		return inuse;
	}

	public void setInuse(int inuse) {
		this.inuse = inuse;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

}
