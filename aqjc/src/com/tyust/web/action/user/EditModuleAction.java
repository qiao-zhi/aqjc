package com.tyust.web.action.user;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;


import org.apache.struts2.ServletActionContext;

import com.tyust.bean.user.TBaseDefinedUrl;
import com.tyust.service.user.ModuleService;

import org.apache.commons.lang.StringUtils;

public class EditModuleAction{
	private ModuleService moduleService;
	public ModuleService getModuleService() {
		return moduleService;
	}
	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}
	/**
	 * 增加菜单
	 */
	public String addModule(){
		HttpServletRequest request=ServletActionContext.getRequest();
		Random rd = new Random();//得到随机数给id赋值
		String id = String.valueOf(rd.nextLong());
		String descriptions = request.getParameter("descriptions").trim();
		String upid = request.getParameter("moduleid");
		String modulename = request.getParameter("modulename").trim();
		String moduleurl = request.getParameter("moduleurl").trim();
		int sortno = Integer.parseInt(request.getParameter("sortno").trim());
		int inuse = Integer.parseInt(request.getParameter("inuse"));
		String maxid = "";
		if(upid.equals("0")){
			maxid = moduleService.selectMaxMenuId();
		}else{
			maxid = moduleService.selectMaxModuleId(upid);
		}
		
		if(!StringUtils.isEmpty(maxid)){
			maxid = maxid.substring(maxid.length()-3,maxid.length());
			maxid = "00"+(Integer.parseInt(maxid)+1);
		}else{
			maxid="001";
		}
		String moduleid;
		if(upid.equals("0")){
			moduleid = maxid.substring(maxid.length()-3,maxid.length());
		}else{
			moduleid = upid+maxid.substring(maxid.length()-3,maxid.length());
		}
		
		TBaseDefinedUrl tbasedefinedurl = new TBaseDefinedUrl();
		tbasedefinedurl.setId(id);
		tbasedefinedurl.setModuleId(moduleid);
		tbasedefinedurl.setModuleName(modulename);
		tbasedefinedurl.setModuleUrl(moduleurl);
		tbasedefinedurl.setMemo1(descriptions);
		tbasedefinedurl.setSortNo(sortno);
		tbasedefinedurl.setInuse(inuse);
		tbasedefinedurl.setMenuClass(moduleid.length()/3);
		tbasedefinedurl.setFlag(0);
		moduleService.insertModule(tbasedefinedurl);
		return "success";
	}
	/**
	 * 删除菜单
	 */
	public String delModule(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String[] id = request.getParameter("ids").split(",");
		TBaseDefinedUrl tbasedefinedurl = new TBaseDefinedUrl();
		
		for(int i=0;i<id.length;i++){
			tbasedefinedurl.setModuleId(id[i]);
			moduleService.deleteModule(tbasedefinedurl);
		}
		return "success";
	}
	/**
	 * 修改菜单
	 */
	public String updateModule(){
		HttpServletRequest request=ServletActionContext.getRequest();
			
		String moduleid = request.getParameter("update_moduleid");
		String modulename = request.getParameter("update_modulename");
		String moduleurl = request.getParameter("update_moduleurl");
		String descriptions = request.getParameter("update_descriptions");
		int sortno = Integer.parseInt(request.getParameter("update_sortno"));
		int inuse = Integer.parseInt(request.getParameter("update_inuse"));
		
		TBaseDefinedUrl tbasedefinedurl = new TBaseDefinedUrl();
		tbasedefinedurl.setModuleId(moduleid);
		tbasedefinedurl.setModuleName(modulename);
		tbasedefinedurl.setModuleUrl(moduleurl);
		tbasedefinedurl.setMemo1(descriptions);
		tbasedefinedurl.setSortNo(sortno);
		tbasedefinedurl.setInuse(inuse);
		
		moduleService.updateModule(tbasedefinedurl);
		return "success";
	}
}
