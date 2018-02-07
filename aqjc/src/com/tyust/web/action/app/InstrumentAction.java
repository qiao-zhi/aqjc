package com.tyust.web.action.app;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.tyust.bean.app.InstrumentInfo;
import com.tyust.bean.app.InstrumentInfoExample;
import com.tyust.bean.app.ReportInstrumentExample;
import com.tyust.common.DateHandler;
import com.tyust.common.OpertionType;
import com.tyust.common.SaveLog;
import com.tyust.common.UtilTools;
import com.tyust.service.app.TestService;

public class InstrumentAction {
	private InstrumentInfo instrumentInfo;
	private TestService testService;

	public InstrumentInfo getInstrumentInfo() {
		return instrumentInfo;
	}

	public void setInstrumentInfo(InstrumentInfo instrumentInfo) {
		this.instrumentInfo = instrumentInfo;
	}

	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	/**
	 * 设备信息列表
	 */
	public String showInstrumentList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int pageCount = Integer.parseInt(request.getParameter("page"));
		int limit = Integer.parseInt(request.getParameter("rp"));
		int start = (pageCount - 1) * limit;
		String insName = request.getParameter("insName");
		String insType = request.getParameter("insType");

		InstrumentInfoExample ex = new InstrumentInfoExample();
		ex.setStart(start);
		ex.setLimit(limit);
		ex.enablePagination();
		InstrumentInfoExample.Criteria cri = ex.createCriteria();
		if (!UtilTools.isNull(insName)) {
			cri.andNameLike("%" + insName + "%");
		}
		if (!UtilTools.isNull(insType)) {
			cri.andUseTypeEqualTo(insType);
		}

		int total = testService.getInstrumentInfoDAO().countByExample(ex);
		List<InstrumentInfo> resList = testService.getInstrumentInfoDAO().selectByExample(ex);
		try {
			JSONArray jsonList = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			InstrumentInfo info = new InstrumentInfo();
			if (resList.size() > 0) {
				for (int i = 0; i < resList.size(); i++) {
					JSONObject json = new JSONObject();
					info = (InstrumentInfo) resList.get(i);
					json.put("number", i + 1);
					json.put("InstrumentId", info.getInstrumentId());
					json.put("Name", info.getName());
					json.put("Model", info.getModel());
					json.put("UseType", info.getUseType());
					json.put("Code", info.getCode());
					json.put("Manufacturer", info.getManufacturer());
					json.put("StartTime", DateHandler.dateToString(info.getStartTime()));
					json.put("EndTime", DateHandler.dateToString(info.getEndTime()));
					json.put("FixTime",DateHandler.dateToString(info.getStartTime())+" 至 "+ DateHandler.dateToString(info.getEndTime()));
					// json.put("Remark", info.getRemark());
					if (info.getUseType().equals("1")) {
						json.put("Remark", "设备检测仪器");
					}
					if (info.getUseType().equals("2")) {
						json.put("Remark", "屏蔽室检测仪器");
					}
					if (info.getUseType().equals("3")) {
						json.put("Remark", "环境检测仪器");
					}
					jsonList.put(json);
				}
			}
			jsonObject.put("rows", jsonList);
			jsonObject.put("total", total);
			// jsonObject.put("pageTotal", Math.ceil((double)total/limit));
			jsonObject.put("page", pageCount);
			ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "input";
		}
	}

	/**
	 * 根据id查询设备信息
	 */
	public String showDeviceInfoById() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String insId = request.getParameter("insId");
		InstrumentInfo info = testService.getInstrumentInfoDAO().selectByPrimaryKey(insId);
		try {
			JSONObject json = new JSONObject();
			json.put("InstrumentId", info.getInstrumentId());
			json.put("Name", info.getName());
			json.put("Model", info.getModel());
			if (info.getUseType().equals("1")) {
				json.put("Remark", "设备检测仪器");
			}
			if (info.getUseType().equals("2")) {
				json.put("Remark", "屏蔽室检测仪器");
			}
			if (info.getUseType().equals("3")) {
				json.put("Remark", "环境检测仪器");
			}
			json.put("UseType", info.getUseType());
			json.put("Code", info.getCode());
			json.put("Manufacturer", info.getManufacturer());
			// json.put("Remark", info.getRemark());
			ServletActionContext.getResponse().getWriter().write(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 保存设备信息
	 */
	public String saveInstrument() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String operate = request.getParameter("operate");
		int i = 0;
		try {
			i = testService.saveInstrument(instrumentInfo, operate);
		} catch (Exception e) {
			e.printStackTrace();
			SaveLog.saveLog(request, "检测仪器", OpertionType.State.ADD, "操作异常");
			request.setAttribute("message", "操作异常");
			return "input";
		}
		if (i > 0) {
			SaveLog.saveLog(request, "检测仪器", OpertionType.State.ADD, "保存成功");
			request.setAttribute("message", "保存成功");
			return "success";
		} else {
			request.setAttribute("message", "保存失败");
			return "input";
		}
	}

	/**
	 * 删除设备信息
	 */
	public String delInstrument() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String idsStr = request.getParameter("idsStr");
		ReportInstrumentExample ex = new ReportInstrumentExample();
		String[] ids = idsStr.trim().split(",");
		int res = 0;
		for (int i = 0; i < ids.length; i++) {
			ex.createCriteria().andInstrumentIdEqualTo(ids[i]);
			int c = testService.getReportInstrumentDAO().countByExample(ex);
			if (c > 0) {
				res++;
			}
		}
		if (res > 0) {
			request.setAttribute("message", "所选仪器之中有" + res + "个已被用于填写检测报告，无法删除");
			return "input";
		} else {
			int a = 0;
			try {
				a = testService.delInstrument(idsStr);
			} catch (Exception e) {
				e.printStackTrace();
				SaveLog.saveLog(request, "检测仪器", OpertionType.State.DELETE, "删除信息异常");
				request.setAttribute("message", "删除设备信息发生异常");
				return "input";
			}
			if (a == 10) {
				SaveLog.saveLog(request, "检测仪器", OpertionType.State.DELETE, "删除成功");
				request.setAttribute("message", "删除成功");
				return "success";
			} else {
				request.setAttribute("message", "删除失败");
				return "input";
			}
		}
	}

	// 填写检测报告时选择仪器的列表，过滤掉已选择的仪器
	public String chooseInsList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String existInsIds = request.getParameter("existInsIds");
		String useType = request.getParameter("useType");
		List<InstrumentInfo> resList = null;
		int total = 0;
		if (!"0".equals(existInsIds)) {
			System.out.println("==========" + existInsIds);
			InstrumentInfoExample example = new InstrumentInfoExample();
			example.createCriteria().andUseTypeEqualTo(useType);
			example.disablePagination();
			resList = testService.getInstrumentInfoDAO().selectByExample(example);
			total = testService.getInstrumentInfoDAO().countByExample(example);
		}
		JSONArray jsonList = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		InstrumentInfo info = new InstrumentInfo();
		try {
			if (resList != null && resList.size() > 0) {
				for (int i = 0; i < resList.size(); i++) {
					JSONObject json = new JSONObject();
					info = (InstrumentInfo) resList.get(i);
					if (!"".equals(existInsIds)) {
						String[] ids = existInsIds.trim().split(",");
						List<String> idList = Arrays.asList(ids);
						if (!idList.contains(info.getInstrumentId())) {
							json.put("number", i + 1);
							json.put("InstrumentId", info.getInstrumentId());
							json.put("Name", info.getName());
							json.put("Model", info.getModel());
							json.put("UseType", info.getUseType());
							json.put("Code", info.getCode());
							json.put("Manufacturer", info.getManufacturer());
							json.put("Remark", info.getRemark());
							jsonList.put(json);
						}
					} else {
						json.put("number", i + 1);
						json.put("InstrumentId", info.getInstrumentId());
						json.put("Name", info.getName());
						json.put("Model", info.getModel());
						json.put("UseType", info.getUseType());
						json.put("Code", info.getCode());
						json.put("Manufacturer", info.getManufacturer());
						json.put("Remark", info.getRemark());
						jsonList.put(json);
					}
				}
			}
			jsonObject.put("rows", jsonList);
			jsonObject.put("total", total);
			ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "input";
		}
	}

	public String showInsTab() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String useType = request.getParameter("useType");
		InstrumentInfoExample example = new InstrumentInfoExample();
		example.createCriteria().andUseTypeEqualTo(useType);
		example.disablePagination();
		List<InstrumentInfo> resList = testService.getInstrumentInfoDAO().selectByExample(example);
		JSONArray jsonList = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		InstrumentInfo info = new InstrumentInfo();
		try {
			if (resList != null && resList.size() > 0) {
				for (int i = 0; i < resList.size(); i++) {
					JSONObject json = new JSONObject();
					info = (InstrumentInfo) resList.get(i);
					json.put("number", i + 1);
					json.put("InstrumentId", info.getInstrumentId());
					json.put("Name", info.getName());
					json.put("Model", info.getModel());
					json.put("UseType", info.getUseType());
					json.put("Code", info.getCode());
					json.put("Manufacturer", info.getManufacturer());
					json.put("Remark", info.getRemark());
					jsonList.put(json);
				}
			}
			jsonObject.put("data", jsonList);
			ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "input";
		}
	}

	// 修改检测报告时显示已选择的仪器
	public String showRptInstrument() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String rptId = request.getParameter("rptId");
		List<InstrumentInfo> resList = testService.getInstrumentInfoDAO().selRptInstrument(rptId);
		JSONArray jsonList = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		InstrumentInfo info = new InstrumentInfo();
		try {
			if (resList.size() > 0) {
				for (int i = 0; i < resList.size(); i++) {
					JSONObject json = new JSONObject();
					info = (InstrumentInfo) resList.get(i);
					json.put("number", i + 1);
					json.put("InstrumentId", info.getInstrumentId());
					json.put("Name", info.getName());
					json.put("Model", info.getModel());
					json.put("UseType", info.getUseType());
					json.put("Code", info.getCode());
					json.put("Manufacturer", info.getManufacturer());
					json.put("Remark", info.getRemark());
					jsonList.put(json);
				}
			}
			jsonObject.put("data", jsonList);
			ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "input";
		}
	}

	// 修改检测报告时显示已选择的仪器
	public String showEnTestReportInstrument() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String enTestReportId = request.getParameter("enTestReportId");
		List<InstrumentInfo> resList = testService.getInstrumentInfoDAO().selEnReportInstrument(enTestReportId);
		JSONArray jsonList = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		InstrumentInfo info = new InstrumentInfo();
		try {
			if (resList.size() > 0) {
				for (int i = 0; i < resList.size(); i++) {
					JSONObject json = new JSONObject();
					info = (InstrumentInfo) resList.get(i);
					json.put("number", i + 1);
					json.put("InstrumentId", info.getInstrumentId());
					json.put("Name", info.getName());
					json.put("Model", info.getModel());
					json.put("UseType", info.getUseType());
					json.put("Code", info.getCode());
					json.put("Manufacturer", info.getManufacturer());
					json.put("Remark", info.getRemark());
					jsonList.put(json);
				}
			}
			jsonObject.put("data", jsonList);
			ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "input";
		}
	}
}
