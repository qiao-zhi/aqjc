package com.tyust.web.action.app;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.tyust.bean.app.DeviceBaseInfo;
import com.tyust.bean.app.DeviceBaseInfoExample;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.common.OpertionType;
import com.tyust.common.SaveLog;
import com.tyust.service.app.TestService;
import com.tyust.service.common.ImportExcelUtil;

/**
 * 
 * 
 * 类名称：DeviceTestAction 类描述： 创建人：章霞光 修改人：章霞光 修改时间：2014-8-18 下午03:06:56 修改备注：
 * 
 * @version 1.0.0
 *
 */
public class TestAction {
	private DeviceBaseInfo deviceBaseInfo;
	private TestService testService;

	public DeviceBaseInfo getDeviceBaseInfo() {
		return deviceBaseInfo;
	}

	public void setDeviceBaseInfo(DeviceBaseInfo deviceBaseInfo) {
		this.deviceBaseInfo = deviceBaseInfo;
	}

	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	/*
	 * 
	 */
	
	
	/**
	 * 保存设备信息 saveDeviceInfo(这里用一句话描述这个方法的作用) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @return String
	 * @exception @since
	 *                1.0.0
	 */
	public String saveDeviceInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
		String res = "";
		try {
			res = testService.manageSaveDeviceInfo(deviceBaseInfo, user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加设备异常");
			return "input";
		}
		if (res != null && !res.equals("")) {
			// SaveLog.saveLog(request, "保存设备信息成功",OpertionType.State.ADD ,
			// "保存设备信息成功");
			request.setAttribute("message", res);
			return "success";
		} else {
			request.setAttribute("message", "添加设备失败");
			return "input";
		}
	}

	/**
	 * 删除设备信息 delDeviceInfo(这里用一句话描述这个方法的作用) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @return String
	 * @exception @since
	 *                1.0.0
	 */
	public String delDeviceInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id").trim();
		int a = 0;
		try {
			a = testService.manageDelDeviceInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
			// SaveLog.saveLog(request, "删除设备信息",OpertionType.State.DELETE ,
			// "删除设备信息异常");
			request.setAttribute("message", "删除设备信息发生异常");
			return "input";
		}
		if (a == 10) {
			// SaveLog.saveLog(request, "删除设备信息",OpertionType.State.DELETE ,
			// "删除设备信息成功");
			request.setAttribute("message", "删除设备信息成功");
			return "success";
		} else {
			request.setAttribute("message", "删除设备信息失败");
			return "input";
		}
	}

	/**
	 * 设备信息列表 showDeviceInfoList(这里用一句话描述这个方法的作用) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @return String
	 * @exception @since
	 *                1.0.0
	 */
	public String showDeviceInfoList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int pageCount = Integer.parseInt(request.getParameter("page"));
		int limit = Integer.parseInt(request.getParameter("rp"));
		int start = (pageCount - 1) * limit;
		String deviceName = request.getParameter("deviceName");
		String deviceType = request.getParameter("deviceType");
		String unitId = request.getParameter("unitId");

		DeviceBaseInfoExample example = new DeviceBaseInfoExample();
		example.setStart(start);
		example.setLimit(limit);
		example.enablePagination();
		com.tyust.bean.app.DeviceBaseInfoExample.Criteria cri = example.createCriteria();
		if (StringUtils.isNotEmpty(deviceName)) {
			cri.andDeviceNameLike("%" + deviceName + "%");
		}
		if (StringUtils.isNotEmpty(deviceType)) {
			cri.andDeviceTypeEqualTo(deviceType);
		}
		if (StringUtils.isNotEmpty(unitId)) {
			cri.andUnitIdEqualTo(unitId);
		}
		int total = testService.getDeviceBaseInfoDAO().countByExample(example);
		List<DeviceBaseInfo> resList = testService.getDeviceBaseInfoDAO().selectByExample(example);
		try {
			JSONArray jsonList = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			if (resList.size() > 0) {
				for (int i = 0; i < resList.size(); i++) {
					JSONObject json = new JSONObject();
					DeviceBaseInfo info = (DeviceBaseInfo) resList.get(i);
					json.put("number", i + 1);
					json.put("deviceId", info.getDeviceId());
					json.put("deviceName", info.getDeviceName());
					json.put("deviceModel", info.getDeviceModel());
					json.put("deviceNum", info.getDeviceNum());
					json.put("deviceType", info.getDeviceType());
					json.put("deviceTypeName", info.getDeviceTypeName());
					jsonList.put(json);
				}
			}
			jsonObject.put("rows", jsonList);
			jsonObject.put("total", total);
			jsonObject.put("pageTotal", Math.ceil((double) total / limit));
			jsonObject.put("page", pageCount);
			ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "input";
		}
	}

	/**
	 * 已经检测的设备信息列表
	 */
	public String showTestDeviceInfoList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int pageCount = Integer.parseInt(request.getParameter("page"));
		int limit = Integer.parseInt(request.getParameter("rp"));
		int start = (pageCount - 1) * limit;
		String deviceName = request.getParameter("deviceName");
		String deviceType = request.getParameter("deviceType");
		String unitId = request.getParameter("unitId");

		DeviceBaseInfoExample example = new DeviceBaseInfoExample();
		example.setStart(start);
		example.setLimit(limit);
		example.enablePagination();
		com.tyust.bean.app.DeviceBaseInfoExample.Criteria cri = example.createCriteria();
		if (StringUtils.isNotEmpty(deviceName)) {
			cri.andDeviceNameLike("%" + deviceName + "%");
		}
		if (StringUtils.isNotEmpty(deviceType)) {
			cri.andDeviceTypeEqualTo(deviceType);
		}
		if (StringUtils.isNotEmpty(unitId)) {
			cri.andUnitIdEqualTo(unitId);
		}
		int total = testService.getDeviceBaseInfoDAO().countByExample(example);
		List<DeviceBaseInfo> resList = testService.getDeviceBaseInfoDAO().selectByExample(example);
		try {
			JSONArray jsonList = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			if (resList.size() > 0) {
				for (int i = 0; i < resList.size(); i++) {
					JSONObject json = new JSONObject();
					DeviceBaseInfo info = (DeviceBaseInfo) resList.get(i);
					json.put("number", i + 1);
					json.put("deviceId", info.getDeviceId());
					json.put("deviceName", info.getDeviceName());
					json.put("deviceModel", info.getDeviceModel());
					json.put("deviceNum", info.getDeviceNum());
					json.put("deviceType", info.getDeviceType());
					json.put("deviceTypeName", info.getDeviceTypeName());
					jsonList.put(json);
				}
			}
			jsonObject.put("rows", jsonList);
			jsonObject.put("total", total);
			jsonObject.put("pageTotal", Math.ceil((double) total / limit));
			jsonObject.put("page", pageCount);
			ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "input";
		}
	}

	/**
	 * 根据id查询设备信息 showDeviceInfoById(这里用一句话描述这个方法的作用) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @return String
	 * @exception @since
	 *                1.0.0
	 */
	public String showDeviceInfoById() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String materialId = request.getParameter("id");
		DeviceBaseInfo info = testService.getDeviceBaseInfoDAO().selectByPrimaryKey(materialId);
		try {
			JSONObject json = new JSONObject();
			json.put("deviceId", info.getDeviceId());
			json.put("deviceName", info.getDeviceName());
			json.put("deviceModel", info.getDeviceModel());
			json.put("deviceNum", info.getDeviceNum());
			json.put("deviceType", info.getDeviceType());
			json.put("deviceTypeName", info.getDeviceTypeName());
			ServletActionContext.getResponse().getWriter().write(json.toString());
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * 
	 * editDeviceTestState(这里用一句话描述这个方法的作用) (这里描述这个方法适用条件 – 可选)
	 * 
	 * @return String
	 * @exception @since
	 *                1.0.0
	 */
	public String editDeviceState() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id").trim();
		String type = request.getParameter("type");
		String testId = request.getParameter("testId");
		int a = 0;
		try {
			a = testService.manageEditDeviceState(id, type, testId);
		} catch (Exception e) {
			e.printStackTrace();
			SaveLog.saveLog(request, "删除设备安全检测申请信息", OpertionType.State.DELETE, "删除设备安全检测申请信息异常");
			request.setAttribute("message", "操作失败发生异常");
			return "input";
		}
		if (a == 10) {
			SaveLog.saveLog(request, "删除设备安全检测申请信息", OpertionType.State.DELETE, "删除设备安全检测申请信息成功");
			request.setAttribute("message", "操作成功");
			return "success";
		} else {
			request.setAttribute("message", "操作失败");
			return "input";
		}
	}

	// 录入申请时选择设备的列表，过滤掉已选择的设备
	public String chooseDeviceList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String unitId = request.getParameter("unitId");
		String existDveIds = request.getParameter("existDveIds");
		System.out.println("==========" + existDveIds);
		DeviceBaseInfoExample example = new DeviceBaseInfoExample();
		example.disablePagination();
		example.createCriteria().andUnitIdEqualTo(unitId);
		List<DeviceBaseInfo> resList = testService.getDeviceBaseInfoDAO().selectByExample(example);
		int total = testService.getDeviceBaseInfoDAO().countByExample(example);
		JSONArray jsonList = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		DeviceBaseInfo info = new DeviceBaseInfo();
		try {
			if (resList.size() > 0) {
				for (int i = 0; i < resList.size(); i++) {
					JSONObject json = new JSONObject();
					info = (DeviceBaseInfo) resList.get(i);
					if (!"all".equals(existDveIds)) {
						String[] ids = existDveIds.trim().split(",");
						List<String> idList = Arrays.asList(ids);
						if (!idList.contains(info.getDeviceId())) {
							json.put("number", i + 1);
							json.put("deviceId", info.getDeviceId());
							json.put("deviceName", info.getDeviceName());
							json.put("deviceModel", info.getDeviceModel());
							json.put("deviceNum", info.getDeviceNum());
							json.put("deviceType", info.getDeviceType());
							json.put("deviceTypeName", info.getDeviceTypeName());
							jsonList.put(json);
						}
					} else {
						json.put("number", i + 1);
						json.put("deviceId", info.getDeviceId());
						json.put("deviceName", info.getDeviceName());
						json.put("deviceModel", info.getDeviceModel());
						json.put("deviceNum", info.getDeviceNum());
						json.put("deviceType", info.getDeviceType());
						json.put("deviceTypeName", info.getDeviceTypeName());
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

	// 修改申请时显示该申请已选择的设备
	public String showApplyDve() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String applyId = request.getParameter("applyId");
		List<DeviceBaseInfo> dveList = testService.getDeviceBaseInfoDAO().selApplyDve(applyId);
		JSONArray jsonList = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		DeviceBaseInfo info = new DeviceBaseInfo();
		try {
			if (dveList.size() > 0) {
				for (int i = 0; i < dveList.size(); i++) {
					JSONObject json = new JSONObject();
					info = (DeviceBaseInfo) dveList.get(i);
					json.put("number", i + 1);
					json.put("deviceId", info.getDeviceId());
					json.put("deviceName", info.getDeviceName());
					json.put("deviceModel", info.getDeviceModel());
					json.put("deviceNum", info.getDeviceNum());
					json.put("deviceType", info.getDeviceType());
					json.put("deviceTypeName", info.getDeviceTypeName());
					if (info.getDeviceLabel() == null || info.getDeviceLabel().equals("")) {
						json.put("deviceLabel", "");
					} else {
						json.put("deviceLabel", info.getDeviceLabel());
					}
//					NT_APPLY_DEVICE primary Key ,删除设备的依据
					json.put("id", info.getMemo());
					json.put("deviceClass",info.getDeviceClass());
					json.put("deviceSeqId",info.getRemark());
					
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

	// 查询已经申请检测过的设备
	public String showTestDevice() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int pageCount = Integer.parseInt(request.getParameter("page"));
		int rp = Integer.parseInt(request.getParameter("rp"));
		int start = (pageCount - 1) * rp + 1;
		int limit = rp * pageCount;
		String unitName = request.getParameter("unitName");
		String deviceType = request.getParameter("deviceType");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String deviceClass = request.getParameter("deviceClass");

		DeviceBaseInfo device = new DeviceBaseInfo();

		device.setMemo(String.valueOf(start));
		device.setRemark(String.valueOf(limit));
		if (unitName != null && !unitName.equals("")) {
			device.setUnitName(unitName);
		}
		if (deviceType != null && !deviceType.equals("")) {
			device.setDeviceType(deviceType);
		}
		if (startDate != null && !startDate.equals("")) {
			device.setDeviceLabel(startDate);
		}
		if (endDate != null && !endDate.equals("")) {
			device.setDeviceTypeName(endDate);
		}
		if (deviceClass != null && !deviceClass.equals("")) {
			device.setDeviceClass(deviceClass);
		}
		List<DeviceBaseInfo> dveList = testService.getDeviceBaseInfoDAO().selDevice(device);
		int total = testService.getDeviceBaseInfoDAO().countDevice(device);
		JSONArray jsonList = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		DeviceBaseInfo info = new DeviceBaseInfo();
		try {
			if (dveList.size() > 0) {
				for (int i = 0; i < dveList.size(); i++) {
					JSONObject json = new JSONObject();
					info = (DeviceBaseInfo) dveList.get(i);
					json.put("number", i + 1);
					json.put("deviceId", info.getDeviceId());
					json.put("deviceName", info.getDeviceName());
					json.put("deviceModel", info.getDeviceModel());
					json.put("deviceNum", info.getDeviceNum());
					if (info.getDeviceType().equals("1")) {
						json.put("deviceType", "新购");
					} else {
						json.put("deviceType", "维修");
					}
					json.put("deviceClass", info.getDeviceClass());
					json.put("unitName", info.getUnitName());
					if (info.getDeviceLabel() == null || info.getDeviceLabel().equals("")) {
						json.put("deviceLabel", "");
					} else {
						json.put("deviceLabel", info.getDeviceLabel());
					}
					json.put("testDate", info.getRemark());
					jsonList.put(json);
				}
			}
			jsonObject.put("rows", jsonList);
			jsonObject.put("page", pageCount);
			jsonObject.put("total", total);
//			jsonObject.put("total", "50");
			
			ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// excel导出
	private InputStream excelFile;

	private String downloadFileName;

	public String getDownloadFileName() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd ");
		this.downloadFileName = (sf.format(new Date()).toString().trim()) + "设备信息表.txt";
		try {
			this.downloadFileName = new String(downloadFileName.getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return this.downloadFileName;
	}

	// 导出
	public String export() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String unitName = request.getParameter("unitName");
		String deviceType = request.getParameter("deviceType");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String deviceClass = request.getParameter("deviceClass");
		DeviceBaseInfo device = new DeviceBaseInfo();
		if (unitName != null && !unitName.equals("")) {
			device.setUnitName(unitName);
		}
		if (deviceType != null && !deviceType.equals("")) {
			device.setDeviceType(deviceType);
		}
		if (startDate != null && !startDate.equals("")) {
			device.setDeviceLabel(startDate);
		}
		if (endDate != null && !endDate.equals("")) {
			device.setDeviceTypeName(endDate);
		}
		if (deviceClass != null && !deviceClass.equals("")) {
			device.setDeviceClass(deviceClass);
		}
		List<DeviceBaseInfo> dveList = testService.getDeviceBaseInfoDAO().selDevice(device);
		InputStream is = null;
		try {
			is = export(dveList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		excelFile = is;
		return "success";
	}

	public InputStream export(List<DeviceBaseInfo> dataList) {
		StringBuilder builder = new StringBuilder();
		if (dataList != null && dataList.size() > 0) {
			String obj = "";
			for (DeviceBaseInfo device : dataList) {
				obj = device.getDeviceId() + "," + device.getDeviceName() + "," + device.getDeviceClass() + ",";
				if (device.getDeviceType().equals("1")) {
					obj += "新购,";
				} else {
					obj += "维修,";
				}
				obj += device.getDeviceLabel() + "," + device.getUnitName() + "," + device.getRemark()
						+ System.getProperty("line.separator");
				builder.append(obj);
			}
		}
		InputStream in = new ByteArrayInputStream(builder.toString().getBytes());
		return in;
	}

	public InputStream getExcelFile() {
		return excelFile;
	}

	public void setExcelFile(InputStream excelFile) {
		this.excelFile = excelFile;
	}

	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}

	// 导入
	private File excel;
	private String excelFileName;

	private Map<String, Object> jsonStr;

	public String readExcel() {
		jsonStr = new HashMap<String, Object>();
		String result = "success";
		if (excel == null) {
			result = "error";
			jsonStr.put("result", result);
			return "success";
		}
		InputStream in = null;
		try {
			in = new FileInputStream(excel);
			InputStreamReader read = new InputStreamReader(in);
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			while ((lineTxt = bufferedReader.readLine()) != null) {
				String [] dev = lineTxt.split(",");
				DeviceBaseInfo device = new DeviceBaseInfo();
				device.setDeviceId(dev[0]);
				device.setDeviceLabel(dev[4]);
				testService.getDeviceBaseInfoDAO().updateByPrimaryKeySelective(device);
			}
			read.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			result = "error";
		} catch (IOException e) {
			result = "error";
			e.printStackTrace();
		}
		jsonStr.put("result", result);
		return "success";
	}

	public String getExcelFileName() {
		return excelFileName;
	}

	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}

	public File getExcel() {
		return excel;
	}

	public void setExcel(File excel) {
		this.excel = excel;
	}

	public Map<String, Object> getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(Map<String, Object> jsonStr) {
		this.jsonStr = jsonStr;
	}
}
