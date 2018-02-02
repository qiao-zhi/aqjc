package com.tyust.web.action.unit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tyust.bean.unit.TBaseUnitInfo;

import com.tyust.common.CommonalityBean;
import com.tyust.service.dic.DicService;
import com.tyust.service.unit.UnitService;
/**
 * 获取机构
 * @author Administrator
 */
public class FindUnitAction{
	//机构服务层接口
	private UnitService unitService;
	//字典服务层接口
	private DicService dicService;

	public UnitService getUnitService() {
		return unitService;
	}

	public void setUnitService(UnitService unitService) {
		this.unitService = unitService;
	}


	public DicService getDicService() {
		return dicService;
	}

	public void setDicService(DicService dicService) {
		this.dicService = dicService;
	}

	public String execute() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String text1 = request.getParameter("text1").trim();
		int pagec = Integer.parseInt(request.getParameter("page")) ; //当前页
		int pagesize = Integer.parseInt(request.getParameter("rp")) ;//每页显示记录
		int yend = pagec*pagesize; //
		int ystart=0;
		if(pagec!=1){
			ystart = (pagec-1)*pagesize+1;
		}
		CommonalityBean comm = new CommonalityBean();
		comm.setStart(ystart);
		comm.setEnd(yend);
		comm.setId(request.getParameter("unitid"));
		if(!text1.equals("undefined")&& !text1.equals("")){
			comm.setText1(text1);
		}else{
			comm.setText1(null);
		}		
		String sortname = request.getParameter("sortname");
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("unitId", "UNIT_ID");
		map.put("upUnitId", "UP_UNIT_ID");
		map.put("unitClass", "UNIT_CLASS");
		map.put("unitName", "UNIT_NAME");
		map.put("address", "ADDRESS");
		map.put("telephone", "TELEPHONE");
		map.put("contactPerson", "CONTACT_PERSON");
		map.put("email", "EMAIL");
		map.put("header", "HEADER");
		map.put("CREATEDATE", "CREATE_DATE");
		
		comm.setSortname(map.get(sortname).toString());
		comm.setSortorder(request.getParameter("sortorder"));

		//HttpSession session=request.getSession();		
		//TBaseUserInfo user=(TBaseUserInfo)session.getAttribute("user");
		
		TBaseUnitInfo unitInfo=new TBaseUnitInfo();
		int count = unitService.selectCountByUpid(comm.getId());
		List list = unitService.findAllByUpid(comm);
		
		if( list != null){
			JSONArray jsonarraylist = new JSONArray();
			JSONObject json2 = new JSONObject();
			
			try {
				if(list.size() != 0){
				for (int i = 0; i < list.size(); i++) {
					unitInfo = (TBaseUnitInfo)list.get(i);
					JSONObject json = new JSONObject();
					json.put("num", i+1);
					json.put("unitName",unitInfo.getUnitName());
					json.put("unitClass",unitInfo.getUnitClass());
					json.put("telephone",unitInfo.getTelephone());
					json.put("contactPerson",unitInfo.getContactPerson());
					json.put("header",unitInfo.getHeader());
					json.put("address",unitInfo.getAddress());	
					json.put("unitId",unitInfo.getUnitId());
					json.put("email",unitInfo.getEmail());
					json.put("upUnitId",unitInfo.getUpUnitId());
					jsonarraylist.put(json);
				}
				json2.put("total", count);
				}else{
					json2.put("total",0);
				}
				json2.put("rows", jsonarraylist);
				
				json2.put("page", pagec);
				ServletActionContext.getResponse().getWriter().write(json2.toString());
				return null;
			} catch (JSONException e) {

				e.printStackTrace();
				
			}
			
		}
		
		 return null;
		 
	}
}
