package com.tyust.web.action.unit;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.tyust.bean.unit.TBaseUnitInfo;
import com.tyust.service.unit.UnitService;

public class FindUnitTree{
	//机构服务层接口
	private UnitService unitService;
	
	public UnitService getUnitService() {
		return unitService;
	}

	public void setUnitService(UnitService unitService) {
		this.unitService = unitService;
	}
	//jsp名称
	private String jspName;
	//上级机构ID
	private String upId;
	
	private String unitId;

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	
	public String getJspName() {
		return jspName;
	}

	public void setJspName(String jspName) {
		this.jspName = jspName;
	}

	public String getUpId() {
		return upId;
	}

	public void setUpId(String upId) {
		this.upId = upId;
	}
	public String findUpUnit(){
		ActionContext ctx = ActionContext.getContext();
		//List unit = unitService.selectMaxUnit();
		ArrayList list = new ArrayList();
		//for(int i=0;i<unit.size();i++){
		//	TBaseUnitInfo un = (TBaseUnitInfo)unit.get(i);
		//	list.add(un);
		//}
		if("0".equals(unitId)){
			List unit = unitService.selectMaxUnit();
			for(int i=0;i<unit.size();i++){
				TBaseUnitInfo un = (TBaseUnitInfo)unit.get(i);
				list.add(un);
			}
		}else{
			list.add(unitService.findUnit(unitId));
		}
		ctx.put("unit", list);
		return "tree";
	}
	
	public String findUnitByUpId(){
		ActionContext ctx = ActionContext.getContext();
		List unitList = unitService.findByUpid(upId);
		ctx.put("unitList", unitList);
		return "downUnit";
	}
}
