package com.tyust.web.action.dic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import com.tyust.bean.dic.DicSystemDictionary;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.service.dic.DicService;

//直接得到该字典的内容
public class FinddicAction {
	private DicService dicService;
	private String id;

	public DicService getDicService() {
		return dicService;
	}

	public void setDicService(DicService dicService) {
		this.dicService = dicService;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 根据上级ID查询子项
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String getItemById() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = ServletActionContext.getRequest();
		TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
		List<?> dicList = dicService.selectDicByupid(user.getUnitId(), id);
		ctx.put("dicList", dicList);
		if (id.equals("0")) {
			return "success";
		}
		return "succ";
	}

	/**
	 * 根据上级ID查询该项的子项 没有部门限制
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String getElementByUpId() throws Exception {
		if (id.equals("")) {
			return null;
		}
		List<?> list = dicService.selectItemsByupid(id);
		JSONObject json2 = new JSONObject();
		JSONArray array = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			DicSystemDictionary dic = (DicSystemDictionary) list.get(i);
			JSONObject json = new JSONObject();
			json.put("dictionaryOptionId", dic.getDictionaryOptionId());
			json.put("dictionaryOptionName", dic.getDictionaryOptionName());
			json.put("upDictionaryOptionId", dic.getUpDictionaryOptionId());
			json.put("descriptions", dic.getDescriptions());
			json.put("inuseCode", dic.getIsUse());
			if (dic.getIsUse() == 1) {
				json.put("inuse", "启用");
			} else {
				json.put("inuse", "停用");
			}
			json.put("sortno", dic.getSortNo());
			json.put("englishname", dic.getEnglishName());
			json.put("datatypeCode", dic.getDataType());
			if (dic.getDataType() == null) {
				json.put("datatype", dic.getDataType());
			}
			if ("1".equals(dic.getDataType())) {
				json.put("datatype", "数字型");
			}
			if ("2".equals(dic.getDataType())) {
				json.put("datatype", "字符型");
			}
			if ("3".equals(dic.getDataType())) {
				json.put("datatype", "日期型");
			}
			if ("4".equals(dic.getDataType())) {
				json.put("datatype", "数据字典");
			}
			if (dic.getMatchDicId() != null && !"".equals(dic.getMatchDicId())) {
				json.put("matchdicid", dic.getMatchDicId());
			} else {
				json.put("matchdicid", "无");
			}
			array.put(json);
		}

		json2.put("rows", array);
		ServletActionContext.getResponse().getWriter().write(json2.toString());
		return null;
	}

	/**
	 * 根据ID查询该项详细信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String getElementById() throws Exception {
		if (id.equals("")) {
			return null;
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
		List<?> list = dicService.selectDicByupid(user.getUnitId(), id);
		JSONObject json2 = new JSONObject();
		JSONArray array = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			DicSystemDictionary dic = (DicSystemDictionary) list.get(i);
			JSONObject json = new JSONObject();
			json.put("dictionaryOptionId", dic.getDictionaryOptionId());
			json.put("dictionaryOptionName", dic.getDictionaryOptionName());
			json.put("upDictionaryOptionId", dic.getUpDictionaryOptionId());
			json.put("descriptions", dic.getDescriptions());
			json.put("inuseCode", dic.getIsUse());
			if (dic.getIsUse() == 1) {
				json.put("inuse", "启用");
			} else {
				json.put("inuse", "停用");
			}
			json.put("sortno", dic.getSortNo());
			json.put("englishname", dic.getEnglishName());
			json.put("datatypeCode", dic.getDataType());
			if (dic.getDataType() == null) {
				json.put("datatype", dic.getDataType());
			}
			if ("1".equals(dic.getDataType())) {
				json.put("datatype", "数字型");
			}
			if ("2".equals(dic.getDataType())) {
				json.put("datatype", "字符型");
			}
			if ("3".equals(dic.getDataType())) {
				json.put("datatype", "日期型");
			}
			if ("4".equals(dic.getDataType())) {
				json.put("datatype", "数据字典");
			}
			if (dic.getMatchDicId() != null && !"".equals(dic.getMatchDicId())) {
				json.put("matchdicid", dic.getMatchDicId());
			} else {
				json.put("matchdicid", "无");
			}
			array.put(json);
		}

		json2.put("rows", array);
		ServletActionContext.getResponse().getWriter().write(json2.toString());
		return null;
	}
}
