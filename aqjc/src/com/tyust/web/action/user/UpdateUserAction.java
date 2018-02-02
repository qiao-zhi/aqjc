package com.tyust.web.action.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.common.OpertionType;
import com.tyust.common.SaveLog;
import com.tyust.service.user.UserService;

/**
 * MyEclipse Struts Creation date: 07-16-2010
 *
 * XDoclet definition:
 * 
 * @struts.action path="/updateUser" name="updateUserForm"
 *                input="/form/updateUser.jsp" parameter="param" scope="request"
 *                validate="true"
 */
public class UpdateUserAction {
	private UserService userService;
	private String oldpwd;
	private String newpwd;

	private String userId;
	private String userName;
	private String sex;
	private String name;
	private String cardId;
	private String tecduty;
	private String duty;
	private String telephone;
	private String mobile;
	private String email;
	private String userComment;
	private int inuse;

	private String resetpwd_userid;
	private String pwd;

	public String getResetpwd_userid() {
		return resetpwd_userid;
	}

	public void setResetpwd_userid(String resetpwdUserid) {
		resetpwd_userid = resetpwdUserid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getTecduty() {
		return tecduty;
	}

	public void setTecduty(String tecduty) {
		this.tecduty = tecduty;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserComment() {
		return userComment;
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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getOldpwd() {
		return oldpwd;
	}

	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

	public String getNewpwd() {
		return newpwd;
	}

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

	/**
	 * @throws IOException
	 */
	public String updatePwd() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		oldpwd = request.getParameter("oldpwd").trim().toUpperCase();
		newpwd = request.getParameter("newpwd").trim().toUpperCase();
		HttpSession session = request.getSession();
		TBaseUserInfo user = (TBaseUserInfo) session.getAttribute("user");
		if (!(user.getPassword().equalsIgnoreCase(oldpwd))) {
			request.setAttribute("message", "原密码不正确！");
			SaveLog.saveLog(request, "修改密码", OpertionType.State.UPDATE, "原密码不正确！");
			return "success";
		}
		int i = userService.updatePwd(user.getUserId(), newpwd);
		if (i > 0) {
			user.setPassword(newpwd);
			session.setAttribute("user", user);
			request.setAttribute("message", "修改成功！");
			SaveLog.saveLog(request, "修改密码", OpertionType.State.UPDATE, "修改成功！");
			return "success";
		} else {
			request.setAttribute("message", "修改失败！");
		}
		return "success";
	}

	public String updateUser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		TBaseUserInfo tbaseuserinfo = new TBaseUserInfo();
		tbaseuserinfo.setUserId(userId.trim());
		tbaseuserinfo.setUserName(userName.trim());
		tbaseuserinfo.setName(name.trim());
		tbaseuserinfo.setSex(sex);
		tbaseuserinfo.setDuty(duty.trim());
		tbaseuserinfo.setTelephone(telephone.trim());
		tbaseuserinfo.setEmail(email.trim());
		tbaseuserinfo.setUserComment(userComment.trim());
		tbaseuserinfo.setInuse(inuse);
		try {
			userService.updateUser(tbaseuserinfo);
			SaveLog.saveLog(request, "用户管理", OpertionType.State.UPDATE, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			SaveLog.saveLog(request, "用户管理", OpertionType.State.UPDATE, e.toString());
		}
		request.setAttribute("message", "用户修改成功");
		return "success";
	}

	/**
	 * 更新用户信息 并更新session中的用户
	 * @return
	 */
	public String updateUserInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext ctx = ActionContext.getContext();
		TBaseUserInfo tbaseuserinfo = new TBaseUserInfo();
		tbaseuserinfo.setUserId(userId.trim());
		tbaseuserinfo.setUserName(userName.trim());
		tbaseuserinfo.setName(name.trim());
		tbaseuserinfo.setSex(sex);
		tbaseuserinfo.setDuty(duty.trim());
		tbaseuserinfo.setTelephone(telephone.trim());
		tbaseuserinfo.setEmail(email.trim());
		tbaseuserinfo.setUserComment(userComment.trim());
		tbaseuserinfo.setInuse(inuse);
		try {
			userService.updateUser(tbaseuserinfo);
			TBaseUserInfo user = userService.selectUserById(userId).get(0);
			ctx.getSession().put("user", user);
			SaveLog.saveLog(request, "用户信息", OpertionType.State.UPDATE, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			SaveLog.saveLog(request, "用户信息", OpertionType.State.UPDATE, e.toString());
		}
		request.setAttribute("message", "用户修改成功");
		return "success";
	}

	public String adminUpdatePwd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if (userService.updatePwd(resetpwd_userid, pwd.trim().toUpperCase()) > 0) {
			SaveLog.saveLog(request, "用户管理", OpertionType.State.UPDATE, "修改成功");
		}
		return "success";
	}
}