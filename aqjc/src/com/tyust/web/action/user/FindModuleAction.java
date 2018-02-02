package com.tyust.web.action.user;

import java.util.List;
import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;
import com.opensymphony.xwork2.ActionContext;
import com.tyust.bean.user.TBaseDefinedUrl;
import com.tyust.service.user.ModuleService;

public class FindModuleAction{
	private ModuleService moduleService;
	private String id;
	public ModuleService getModuleService() {
		return moduleService;
	}

	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
     /**
      * 查询菜单 显示在tree上
      * @param mapping
      * @param form
      * @param request
      * @param response
      * @return
      */
	public String findModuleByUpid(){
		ActionContext ctx = ActionContext.getContext();
		
		List list = null;
	 
		if(id.equals("0")){
			 list = moduleService.selectMenu();
			 ctx.put("moduleList", list);
			 return "success";
		}
		list = moduleService.selectModuleByUpid(id);
		ctx.put("moduleList", list);
		return "succ";
	}
	
	/**
	 * 根据上级菜单查询菜单列表
	 * @throws Exception 
	 */
	public String findModuleList() throws Exception{
		
		List list = null;
		if(id.equals("0")){
			list = moduleService.selectMenu();
		}else{
			 list = moduleService.selectModuleByUpid(id);
		}
		if(list==null){
			return null;
		}
		  JSONObject json = new JSONObject();
		  JSONArray array = new JSONArray();
		  for(int i=0;i<list.size();i++){
			  TBaseDefinedUrl url = (TBaseDefinedUrl)list.get(i);
			  JSONObject obj = new JSONObject();
			  obj.put("id", url.getId());
			  obj.put("moduleid", url.getModuleId());
			  obj.put("modulename", url.getModuleName());
			  obj.put("moduleurl", url.getModuleUrl());
			  if(url.getInuse()==1){
				  obj.put("inuse", "启用");
			  }else{
				  obj.put("inuse", "停用");
			  }
			 
			  obj.put("menuclass", url.getMenuClass());
			  obj.put("descriptions", url.getMemo1());
			  obj.put("sortno", url.getSortNo());
			  array.put(obj);
		  }
		  json.put("rows", array);
		  
		  ServletActionContext.getResponse().getWriter().write(json.toString());
		return null;
	}
}
