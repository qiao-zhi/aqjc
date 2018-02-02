package com.tyust.web.action.dic;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.tyust.bean.dic.DicSystemDictionary;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.common.OpertionType;
import com.tyust.common.SaveLog;
import com.tyust.service.dic.DicService;

public class EditdicAction {
	private DicService dicService;
	private String upid;
	private String dicname;
	private String descriptions;
	private int sortno;
	private int inuse;
	private String englishname;
	private String datatype;
	private String matchdicid;
	private String ids;
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public DicService getDicService() {
		return dicService;
	}
	public void setDicService(DicService dicService) {
		this.dicService = dicService;
	}
	public String getUpid() {
		return upid;
	}
	public void setUpid(String upid) {
		this.upid = upid;
	}
	public String getDicname() {
		return dicname;
	}
	public void setDicname(String dicname) {
		this.dicname = dicname;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public int getSortno() {
		return sortno;
	}
	public void setSortno(int sortno) {
		this.sortno = sortno;
	}
	public int getInuse() {
		return inuse;
	}
	public void setInuse(int inuse) {
		this.inuse = inuse;
	}
	public String getEnglishname() {
		return englishname;
	}
	public void setEnglishname(String englishname) {
		this.englishname = englishname;
	}
	public String getDatatype() {
		return datatype;
	}
	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
	public String getMatchdicid() {
		return matchdicid;
	}
	public void setMatchdicid(String matchdicid) {
		this.matchdicid = matchdicid;
	}
	/**
	 * 添加字典项
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String addDic(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String maxid = dicService.selectMaxidByUpid(upid);
		String id = "";
		if(maxid!=null){
		maxid = maxid.substring(maxid.length()-3,maxid.length());
		//获取optionId
	     id = "00"+(Integer.parseInt(maxid)+1);
		}else{
			id="001";
		}
		String optionId;
		if(upid.equals("0")){
			optionId = id.substring(id.length()-3,id.length()); 
		}else{
			optionId = upid+id.substring(id.length()-3,id.length()); 
		}
		                                                                 //获取字典项编号
		DicSystemDictionary dic = new DicSystemDictionary();
		dic.setDictionaryOptionId(optionId.trim());
		dic.setDictionaryOptionName(dicname.trim());
		dic.setUpDictionaryOptionId(upid);
		dic.setDescriptions(descriptions.trim());
		dic.setIsUse(inuse);
		dic.setSortNo(sortno);
		dic.setFlag(0);
		dic.setDataType(datatype);
		dic.setEnglishName(englishname.trim());
	//	dic.setMatchDicId(matchdicid.trim());
		TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
		dic.setRemark2(user.getUnitId());
		
		dicService.insertDic(dic);
		SaveLog.saveLog(request, "字典管理", OpertionType.State.ADD,"添加成功");
		
		return "success";
	}
	/**
	 * 删除字典项
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public String delDic(){
		HttpServletRequest request=ServletActionContext.getRequest();
		     String optionid[] = ids.split(",");
				
				DicSystemDictionary dic = new DicSystemDictionary();
				for(int i=0;i<optionid.length;i++){
					dic.setDictionaryOptionId(optionid[i]);
					dicService.deleteDic(dic);
					SaveLog.saveLog(request, "字典管理", OpertionType.State.DELETE,"删除成功");
				}
				
		return "success";
	}
    /**
     * 修改字典项
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     */	
	public String updateDic(){
		HttpServletRequest request=ServletActionContext.getRequest();
		
			DicSystemDictionary dic = new DicSystemDictionary();
			
			dic.setDescriptions(request.getParameter("update_descriptions").trim());
			dic.setDictionaryOptionName(request.getParameter("update_dicname").trim());
			dic.setIsUse(Integer.parseInt(request.getParameter("update_inuse")));
			dic.setSortNo(Integer.parseInt(request.getParameter("update_sortno")));
			dic.setDictionaryOptionId(request.getParameter("update_id"));
			dic.setDataType(request.getParameter("update_datatype"));
			dic.setEnglishName(request.getParameter("update_englishname").trim());
		//	dic.setMatchDicId(request.getParameter("update_matchdicid").trim());
			dicService.updateDic(dic);
			SaveLog.saveLog(request, "字典管理", OpertionType.State.UPDATE,"修改成功");
		return "success";
	}
	
}
