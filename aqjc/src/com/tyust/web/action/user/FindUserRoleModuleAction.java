package com.tyust.web.action.user;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.tyust.bean.user.TBaseDefinedUrl;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.service.user.UserService;

public class FindUserRoleModuleAction {
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private String result = "";

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 生成导航页面
	 */
	public String findModule() {
		ActionContext ctx = ActionContext.getContext();
		TBaseUserInfo user = (TBaseUserInfo) ctx.getSession().get("user");

		List list = null;
		if (user.getUserName().equals("root") || user.getUserName().equals("ROOT")) {
			list = userService.selectModule("-1");
//		} else if ("1".equals(user.getTecduty()) && "0".equals(user.getCreateUnitId())) {
//			list = userService.selectModule("2");
//		} else if ("2".equals(user.getTecduty()) && "0".equals(user.getCreateUnitId())) {
//			list = userService.selectModule("1");
		} else {
			list = userService.selectModuleByuserId(user.getUserId());
		}

		int div = 0;
		for (int i = 0; i < list.size(); i++) {
			TBaseDefinedUrl url = (TBaseDefinedUrl) list.get(i);
			TBaseDefinedUrl prurl = new TBaseDefinedUrl();
			if (i > 0) {
				prurl = (TBaseDefinedUrl) list.get(i - 1);
			}
			// System.out.println("url.getModuleName():"+url.getModuleName()+";url.getModuleUrl():"+url.getModuleUrl()+";url.getMenuClass():"+url.getMenuClass());
			if (url.getMenuClass() == prurl.getMenuClass()) { // 与上一条记录级别一样
				if (prurl.getModuleUrl() == null || prurl.getModuleUrl().trim().equals("")) {
					result += "</div>";
					div -= 1;
				}
			}
			if (url.getMenuClass() < prurl.getMenuClass()) { // 比上一条记录的级别小
				if (prurl.getModuleUrl() == null || prurl.getModuleUrl().trim().equals("")) {
					result += "</div>";
					div -= 1;
				}
				for (int k = 0; k < prurl.getMenuClass() - url.getMenuClass(); k++) {
					result += "</div>";
					div -= 1;
				}
			}

			if (url.getModuleUrl() != null && !url.getModuleUrl().trim().equals("")) { // 如果链接地址不为空，用链接class
				// result += "<div class='NavURL'><a href="+url.getModuleUrl()+"
				// target='rightframe'>"+url.getModuleName()+"</a></div>";
				result += "<div class='NavURL'><a href='javascript:void(0)' onclick=\"showPage('" + url.getModuleUrl()
						+ "')\">" + url.getModuleName() + "</a></div>";
			}
			if (url.getModuleUrl() == null || url.getModuleUrl().trim().equals("")) { // 链接为空
				if (url.getMenuClass() == 1) {
					result += "<div class='NavTitle' status='closed'>" + url.getModuleName()
							+ "</div><div class='NavDisplay'>";
					div += 1;
				} else {
					result += "<div class='thr_nav'>" + url.getModuleName() + "</div><div class='for_nav'>";
					div += 1;
				}
			}
		}
		for (int j = 0; j < div; j++) {
			result += "</div>";
		}
		ctx.put("result", result);
		return "left";
	}
}
