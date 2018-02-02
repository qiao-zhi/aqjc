package com.tyust.web.action.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.common.OpertionType;
import com.tyust.common.SaveLog;
import com.tyust.service.user.UserService;

public class LoginAction {
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private String username; 
	private String userpsd;
	 
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpsd() {
		return userpsd;
	}
	public void setUserpsd(String userpsd) {
		this.userpsd = userpsd;
	}
	public String execute() throws Exception{
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println(username+"+++++++"+userpsd);
		TBaseUserInfo user = userService.login(username, userpsd);
		 if(user==null){
			 request.setAttribute("message", "用户名或密码不正确");
			 SaveLog.saveLog(request, "用户登录",OpertionType.State.LOGIN , "用户名或密码不正确",username);
			 return "input";
		 }else{
                if(user.getInuse()==0){
                	request.setAttribute("message", "用户名已锁定");
                    return "input";
                }
                userService.updateLoginDate(user);
                ctx.getSession().put("user", user);
			 /**
		         * @author 梁磊新
		         * 思路：
		         *      1、ServletContext对象（对于整个项目是全局的）中存放一个HashMap对象，这个对象存放着格式为："用户名,密码",所对应的sessionId。
		         *      每登录一个用户就覆盖HashMap对象中"用户名,密码"对应的sessionId。
		         *      2、在过滤器中通过user对象的"用户名,密码"取出HashMap中的sessionId。如果和自己客户端的sessionId相同，就能正常操作。否则，将session中的user删除。
		         */
//			 ServletContext application=request.getSession().getServletContext();
//			 HashMap<String,String> userMap=null;
//			 if(application.getAttribute("userMap")==null){
//				 userMap=new HashMap<String,String>();
//				 userMap.put(user.getUserName()+","+user.getPassword(), ((ApplicationContext) ctx.getSession()).getId());
//			 }else{
//				 userMap=(HashMap<String,String>)application.getAttribute("userMap");
//				 application.removeAttribute("userMap");
//				 String userSessionId=userMap.get(user.getUserName()+","+user.getPassword());
//				 if(userSessionId!=null){
//					 userMap.remove(user.getUserName()+","+user.getPassword());
//					 String sessionId=((ApplicationContext) ctx.getSession()).getId();
//					 userMap.put(user.getUserName()+","+user.getPassword(),sessionId);
//				 }else{
//					 userMap.put(user.getUserName()+","+user.getPassword(), ((ApplicationContext) ctx.getSession()).getId());
//				 }
//			 }
//			 application.setAttribute("userMap", userMap);
			 SaveLog.saveLog(request, "用户登录",OpertionType.State.LOGIN , "登录成功");
			 request.setAttribute("success", true);
		     return "success";
	 }
}
}
