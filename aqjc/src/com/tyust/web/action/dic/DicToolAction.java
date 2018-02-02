package com.tyust.web.action.dic;

import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.tyust.bean.dic.SystemDictionary;
import com.tyust.bean.dic.SystemDictionaryExample;
import com.tyust.bean.dic.SystemDictionaryExample.Criteria;
import com.tyust.service.dic.DicToolService;

/**
 * 
 * 
 * 类名称：DicToolAction 
 * 类描述： 
 * 创建人：章霞光 
 * 修改人：章霞光 
 * 修改时间：2012-9-17 下午05:05:42 
 * 修改备注：
 * 
 * @version 1.0.0
 * 
 */
public class DicToolAction {
	private DicToolService dicToolService;

	public DicToolService getDicToolService() {
		return dicToolService;
	}

	public void setDicToolService(DicToolService dicToolService) {
		this.dicToolService = dicToolService;
	}

	/**
	 * 获取全部国标行政区划数据 
	 * showGbArea(这里用一句话描述这个方法的作用) 
	 * (这里描述这个方法适用条件 – 可选)
	 * 
	 * @return String
	 * @exception
	 * @since 1.0.0
	 */
//	public String showGbArea() {
//		String upAreaId = ServletActionContext.getRequest().getParameter("upAreaId");
//		System.out.println("upAreaId"+upAreaId);
//		DicGbAreaExample example = new DicGbAreaExample();
//		example.createCriteria().andFlagEqualTo("1").andUpAreaIdEqualTo(upAreaId);
//		List<DicGbArea> dicList = dicToolService.getDicGbAreaDAO().selectByExample(example);
//		try {
//			JSONArray jsonList = new JSONArray();
//			JSONObject jsonObject = new JSONObject();
//			if (dicList.size() > 0) {
//				for (int i = 0; i < dicList.size(); i++) {
//					JSONObject json = new JSONObject();
//					DicGbArea info = (DicGbArea) dicList.get(i);
//					json.put("areaId", info.getAreaId());
//					json.put("areaName", info.getAreaName());
//					json.put("upAreaId", info.getUpAreaId());
//					jsonList.put(json);
//				}
//			}
//			jsonObject.put("root", jsonList);
//			ServletActionContext.getResponse().getWriter()
//					.write(jsonObject.toString());
//			return null;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "input";
//		}
//	}
	/**
	 * 根据上级编号获取下级list
	 * showDicList(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @return 
	 *String
	 * @exception 
	 * @since  1.0.0
	 */
	public String showDicListByUp() {
		String upDicId = ServletActionContext.getRequest().getParameter("upDicId");
		SystemDictionaryExample example = new SystemDictionaryExample();
		Criteria c = example.createCriteria();
		c.andIsUseEqualTo(new Short("1")).andFlagEqualTo(new Short("0"));
		if(StringUtils.isNotEmpty(upDicId)){
			c.andUpDictionaryOptionIdEqualTo(upDicId);
		}
		List<SystemDictionary> dicList = dicToolService.getSystemDictionaryDAO()
				.selectByExample(example);
		try {
			JSONArray jsonList = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			if (dicList.size() > 0) {
				for (int i = 0; i < dicList.size(); i++) {
					JSONObject json = new JSONObject();
					SystemDictionary info = (SystemDictionary) dicList.get(i);
					json.put("dictionaryOptionId", info.getDictionaryOptionId());
					json.put("dictionaryOptionName", info.getDictionaryOptionName());
					json.put("upDictionaryOptionId", info.getUpDictionaryOptionId());
					SystemDictionaryExample examChild = new SystemDictionaryExample();
					examChild.createCriteria().andUpDictionaryOptionIdEqualTo(info.getDictionaryOptionId());
					List<SystemDictionary> dicChildList = dicToolService.getSystemDictionaryDAO().selectByExample(examChild );
					if(dicChildList.size()>0){
						json.put("isHaveChild","1");
						JSONArray jsonList1 = new JSONArray();
						for (int n = 0; n < dicChildList.size(); n++) {
							JSONObject json1 = new JSONObject();
							SystemDictionary info1 = (SystemDictionary) dicChildList.get(n);
							json1.put("dictionaryOptionId", info1.getDictionaryOptionId());
							json1.put("dictionaryOptionName", info1.getDictionaryOptionName());
							json1.put("upDictionaryOptionId", info1.getUpDictionaryOptionId());
							json1.put("isHaveChild","0");
							jsonList1.put(json1);
						}
						json.put("childRoot", jsonList1);
					}else{
						json.put("isHaveChild","0");
					}
					jsonList.put(json);
				}
			}
			jsonObject.put("root", jsonList);
			ServletActionContext.getResponse().getWriter()
					.write(jsonObject.toString());
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "input";
		}
	}
}
