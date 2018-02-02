package com.tyust.web.action.unit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tyust.bean.unit.TBaseUnitInfo;
import com.tyust.service.unit.UnitService;

public class LoadUnitNameAction {
	// 机构服务层接口
	private UnitService unitService;

	public String loadUnitName() throws JSONException {
		List<TBaseUnitInfo> list = new ArrayList<TBaseUnitInfo>();
		list = unitService.findAll();
		JSONArray jsonlist = new JSONArray();
		for(TBaseUnitInfo unit : list){
			JSONObject json = new JSONObject();
			json.put("unitId", unit.getUnitId());
			json.put("unitName",unit.getUnitName());
			jsonlist.put(json);
		}
		try {
			ServletActionContext.getResponse().getWriter().write(jsonlist.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public UnitService getUnitService() {
		return unitService;
	}

	public void setUnitService(UnitService unitService) {
		this.unitService = unitService;
	}

}
