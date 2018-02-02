/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.tyust.web.action.user;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.common.OpertionType;
import com.tyust.common.SaveLog;
import com.tyust.service.user.UserService;

public class AddUserAction {
	// 用户服务层接口
	private UserService userService;
	// 用户接受页面传过来的参数
	private String sex;
	private String userName;
	private String cardId;
	private String mobile;
	private String tecduty;
	private String inuse;
	private String telephone;
	private String duty;
	private String email;
	private String name;
	private String userComment;
	private String unitId;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTecduty() {
		return tecduty;
	}

	public void setTecduty(String tecduty) {
		this.tecduty = tecduty;
	}

	public String getInuse() {
		return inuse;
	}

	public void setInuse(String inuse) {
		this.inuse = inuse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String execute() {
		TBaseUserInfo tbaseuserinfo = new TBaseUserInfo();
		HttpServletRequest request = ServletActionContext.getRequest();
		// 用户名是否存在
		if (userService.selectUserIsExist(userName.trim().toUpperCase())) {
			request.setAttribute("message", "用户名已存在，请重新输入");
			return "input";
		}

		tbaseuserinfo.setUserId(UUID.randomUUID().toString());
		tbaseuserinfo.setUserName(userName.trim().toUpperCase());
		tbaseuserinfo.setSex(sex);
		tbaseuserinfo.setDuty(duty.trim());
		tbaseuserinfo.setTecduty(tecduty.trim());
		tbaseuserinfo.setTelephone(telephone.trim());
		tbaseuserinfo.setEmail(email.trim());
		tbaseuserinfo.setName(name.trim());
		tbaseuserinfo.setUserComment(userComment.trim());
		tbaseuserinfo.setInuse(new Integer(inuse));
		tbaseuserinfo.setPassword(userName.trim());
		tbaseuserinfo.setUnitId(unitId);
		tbaseuserinfo.setCreateTime(new Date());
		tbaseuserinfo.setCreateUnitId(unitId);

		try {
			userService.insertUser(tbaseuserinfo);
			SaveLog.saveLog(request, "添加用户", OpertionType.State.ADD, "成功添加用户:" + tbaseuserinfo.getUnitName());
		} catch (Exception e) {
			e.printStackTrace();
			SaveLog.saveLog(request, "添加用户", OpertionType.State.ADD, "添加失败：" + e.toString());
		}
		request.setAttribute("message", "添加用户成功");
		return "success";
	}
}