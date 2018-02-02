package com.tyust.web.action.device;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tyust.bean.device.ApplyAuditSmj;
import com.tyust.bean.device.ApplyAuditSmjExample;
import com.tyust.bean.device.DeviceApplyAudit;
import com.tyust.bean.device.DeviceTestApply;
import com.tyust.bean.device.DeviceTestApplyAttach;
import com.tyust.bean.device.DeviceTestApplyAttachExample;
import com.tyust.bean.device.DeviceTestApplyExample;
import com.tyust.bean.device.DeviceTestReport;
import com.tyust.bean.unit.TBaseUnitInfo;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.common.DateHandler;
import com.tyust.common.OpertionType;
import com.tyust.common.SaveLog;
import com.tyust.dao.unit.IunitDao;
import com.tyust.service.app.TestService;
import com.tyust.service.device.DveTestApplyService;
import com.tyust.service.device.DveTestReportService;

public class DveTestApplyAction {
	private DveTestApplyService dveTestApplyService;
	private DeviceTestApply deviceTestApply;
	private DeviceApplyAudit deviceApplyAudit;
	
	private TestService testService;
	private DveTestReportService dveTestReportService;

	
	public DveTestReportService getDveTestReportService() {
		return dveTestReportService;
	}

	public void setDveTestReportService(DveTestReportService dveTestReportService) {
		this.dveTestReportService = dveTestReportService;
	}

	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	// 设备检测附件
	private DeviceTestApplyAttach deviceTestApplyAttach;

	// 附件上传
	private File applyAttach;
	private String applyAttachFileName;

	// 附件下载
	// 文件下载
	private String filename;

	private InputStream inStream;
	
//	private 

	// 文件下载
	public String downAttach() throws Exception {
		return "success";
	}

	public InputStream getInStream() {
		inStream = ServletActionContext.getServletContext().getResourceAsStream("/uploads/deviceAttach/" + filename);
		if (inStream == null) {
			inStream = new ByteArrayInputStream("Sorry,File not found !".getBytes());
		}
		return inStream;
	}

	public void setFilename(String filename) {
		try {
			this.filename = new String(filename.getBytes("ISO8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public String getFilename() {
		try {
			return new String(filename.getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			return this.filename;
		}
	}

	private File[] testPic;
	private String[] testPicFileName;

	/*
	 * 根据单位ID查询该单位所有的检测申请
	 */
	
	public String selApplyList() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		ApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(request.getSession().getServletContext());
		IunitDao unitDao = (IunitDao) context.getBean("Unit");
		int pageNum = Integer.parseInt(request.getParameter("page"));
		int rp = Integer.parseInt(request.getParameter("rp"));
		int start = (pageNum - 1) * rp ;
		int limit = pageNum * rp;
		String unitId = request.getParameter("unitId");
		String state = request.getParameter("state");
		DeviceTestApplyExample ex = new DeviceTestApplyExample();
		ex.setStart(start);
		ex.setLimit(limit);
		ex.enablePagination();
		ex.setOrderByClause("apply_date desc");
		DeviceTestApplyExample.Criteria cri = ex.createCriteria();

		if (!state.equals("all")) {
			ex.setStateValue(state);
			cri.andStateEqualTo(state);
		}
		// 查询代替填写信息
		if (unitId.equals("1")) {
			ex.setName2("1");
		} else {
			ex.setName1(unitId);
		}
		List<DeviceTestApply> list = dveTestApplyService.getDeviceTestApplyDAO().selectByUnit(ex);
		
		//int total = list.size();
		int total = dveTestApplyService.getDeviceTestApplyDAO().countByExampleAllApplies(ex);
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		DeviceTestApply info = new DeviceTestApply();
		try {
			for (int i = 0; i < list.size(); i++) {
				JSONObject json = new JSONObject();
				info = (DeviceTestApply) list.get(i);
				json.put("num", i + 1);
				json.put("ApplyId", info.getApplyId());
				json.put("User", info.getRemark1());
	
				json.put("Apply_Date", DateHandler.dateToString(info.getApplyDate()));
				json.put("DeviceNum", info.getDeviceNum());
				json.put("ApplyOpinion", info.getApplyOpinion());
				
//				申请状态：1待提交，2待审核，3审核未通过，4审核通过，5已检测
				
				if ("1".equals(info.getState())) {
					json.put("UnitName", unitDao.findUnit(info.getUnitId()).getUnitName());
					json.put("State", "待提交");
					json.put("operate",
							// "<a href='javascript:void(0)'
							// onclick=\"subApply('"+info.getApplyId()+"')\">提交</a>
							// | " +
							"<a href='apply_upd.jsp?applyId=" + info.getApplyId() + "'>修改</a> | "
					 +"<a href='javascript:void(0)' onclick=\"delApply('"+info.getApplyId()+"')\">删除</a>"
					);
				}
				if ("2".equals(info.getState())) {
					json.put("UnitName", unitDao.findUnit(info.getUnitId()).getUnitName());
					json.put("State", "待审核");
					json.put("operate", "<a href='apply_info.jsp?applyId=" + info.getApplyId() + "'>查看</a>");
				}
				if ("3".equals(info.getState())) {
					json.put("UnitName", unitDao.findUnit(info.getUnitId()).getUnitName());
					json.put("State", "审核未通过");
					json.put("operate",
							// "<a href='javascript:void(0)'
							// onclick=\"subApply('"+info.getApplyId()+"')\">提交</a>
							// | " +
							"<a href='apply_upd.jsp?applyId=" + info.getApplyId() + "'>修改</a> | "
									+ "<a href='apply_audit_info.jsp?applyId=" + info.getApplyId() + "'>查看</a>");
				}
				if ("4".equals(info.getState())) {
					json.put("State", "审核通过");
					json.put("operate", "<a href='apply_audit_info.jsp?applyId=" + info.getApplyId() + "&unitId="
							+ info.getUnitId() + "'>查看</a>");
//					json.put("UnitName", unitDao.findUnit(info.getUnitId()).getUnitName());
					json.put("UnitName", 
							"<a title='点击修改申请报告状态' href='javascript:void(0)' onclick=\"updApplyState('"+info.getApplyId()+"')\">"+unitDao.findUnit(info.getUnitId()).getUnitName()+"</a>");
					
				}
				if ("5".equals(info.getState())) {
					json.put("UnitName", 
							"<a title='点击修改申请报告状态' href='javascript:void(0)' onclick=\"updApplyState('"+info.getApplyId()+"')\">"+unitDao.findUnit(info.getUnitId()).getUnitName()+"</a>");
					
					json.put("State", "检测完成");
					json.put("operate", "<a href='test_report_info.jsp?applyId=" + info.getApplyId() + "&unitId="
							+ info.getUnitId() + "&testRptId=" + info.getRemark2() + "'>查看检测报告</a>");
				}
				jsonArray.put(json);
			}
			jsonObject.put("rows", jsonArray);
			jsonObject.put("page", pageNum);
			jsonObject.put("total", total);
			ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
			return null;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String updApplyState(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String applyId = request.getParameter("applyId");
		
		DeviceTestApply devApply = new DeviceTestApply();
		devApply.setApplyId(applyId);
//		申请状态：1待提交，2待审核，3审核未通过，4审核通过，5已检测
		devApply.setState("1");
		int res = dveTestApplyService.updateApply(devApply);
		if(res > 0){
			request.setAttribute("message", "修改成功");
			return "success";
		}else{
			request.setAttribute("message", "修改失败");
			return "input";
		}
	}
	
	// 审核时查询全部单位的申请
	public String selAllApplyList() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int pageNum = Integer.parseInt(request.getParameter("page"));
		int rp = Integer.parseInt(request.getParameter("rp"));
		int start = (pageNum - 1) * rp ;
		int limit = pageNum * rp;
		String state = request.getParameter("state");
		DeviceTestApplyExample ex = new DeviceTestApplyExample();
		ex.setStart(start);
		ex.setLimit(limit);
		ex.enablePagination();
		ex.setOrderByClause("apply_date desc");
		// DeviceTestApplyExample.Criteria cri = ex.createCriteria();
		if (!"all".equals(state)) {
			ex.setStateValue(state);
			// cri.andStateNotEqualTo("1");
		}
		// else{
		// cri.andStateEqualTo(state);
		// }

		List<DeviceTestApply> list = dveTestApplyService.getDeviceTestApplyDAO().selectByExample(ex);
		int total = dveTestApplyService.getDeviceTestApplyDAO().countByExampleAll(ex);
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		DeviceTestApply info = new DeviceTestApply();
		try {
			for (int i = 0; i < list.size(); i++) {
				JSONObject json = new JSONObject();
				info = (DeviceTestApply) list.get(i);
				json.put("num", i + 1);
				json.put("ApplyId", info.getApplyId());
				json.put("Unit", info.getRemark1());
				json.put("User", info.getRemark2());
				json.put("Apply_Date", DateHandler.dateToString(info.getApplyDate()));
				json.put("DeviceNum", info.getDeviceNum());
				json.put("ApplyOpinion", info.getApplyOpinion());
				if ("2".equals(info.getState())) {
					json.put("State", "待审核");
					json.put("operate", "<a href='apply_audit.jsp?applyId=" + info.getApplyId() + "'>审核</a>");
				}
				if ("3".equals(info.getState())) {
					json.put("State", "审核未通过");
					json.put("operate", "<a href='apply_audit_info.jsp?applyId=" + info.getApplyId() + "'>查看</a>");
				}
				if ("4".equals(info.getState())) {
					json.put("State", "审核通过");
					// json.put("operate","<a
					// href='test_report.jsp?applyId="+info.getApplyId()+"&unitId="+info.getUnitId()+"'>填写检测报告</a>");
					json.put("operate", "<a href='javascript:void(0)' onclick=\"selRptByApp('" + info.getApplyId()
							+ "','" + info.getUnitId() + "')\">填写检测报告</a>");
				}
				if ("5".equals(info.getState())) {
					json.put("State", "检测完成");
					json.put("operate", "<a href='test_report_info.jsp?applyId=" + info.getApplyId() + "&unitId="
							+ info.getUnitId() + "&testRptId=" + info.getUserId() + "'>查看检测报告</a>");
				}
				jsonArray.put(json);
			}
			jsonObject.put("rows", jsonArray);
			jsonObject.put("page", pageNum);
			jsonObject.put("total", total);
			ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
			return null;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 查询申请详情
	public String selApplyDetail() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String applyId = request.getParameter("applyId");
		DeviceTestApply info = dveTestApplyService.getDeviceTestApplyDAO().selectById(applyId);
		JSONObject json = new JSONObject();
		json.put("ApplyId", info.getApplyId());
		json.put("ApplyOpinion", info.getApplyOpinion());
		json.put("DeviceNum", info.getDeviceNum());
		json.put("User", info.getRemark1());
		json.put("Tel", info.getRemark2());
		String unitId = info.getUnitId();
		ApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(request.getSession().getServletContext());
		IunitDao unitDao = (IunitDao) context.getBean("Unit");
		TBaseUnitInfo unit = unitDao.findUnit(unitId);
		json.put("Unit", unit.getUnitName());
		// 将申请单位编号传入前台
		json.put("ApplyUnitId", unitId);
		json.put("applyDate", DateHandler.dateToString(info.getApplyDate()));

		ServletActionContext.getResponse().getWriter().write(json.toString());
		return null;
	}

	// 新增设备检测申请
	public String addApply() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String selectedDve = request.getParameter("selectedDve");
		String operate = request.getParameter("operate");
		// deviceTestApply.setApplyId(UUID.randomUUID().toString());
		String message = "";
		if ("save".equals(operate)) {
			deviceTestApply.setState("1");
			message = "保存";
		}
		if ("sub".equals(operate)) {
			deviceTestApply.setState("2");
			deviceTestApply.setApplyDate(new Date());
			message = "提交";
		}
//		System.out.println(deviceTestApply.getApplyDate());
		
		String applyId = "";
		try {
			applyId = dveTestApplyService.addApply(deviceTestApply, selectedDve);
		} catch (Exception e) {
			e.printStackTrace();
			SaveLog.saveLog(request, "新增设备检测申请", OpertionType.State.ADD, "操作异常");
			request.setAttribute("message", message + "操作异常");
			return "input";
		}
		if (applyId != null) {
			SaveLog.saveLog(request, "新增设备检测申请", OpertionType.State.ADD, "新增成功");
			request.setAttribute("message", applyId);
			return "success";
		} else {
			request.setAttribute("message", message + "操作失败");
			return "input";
		}
	}

	/*修改设备检测申请
	 * 过程：
	 * 1、获取新增的设备编号
	 * 2、获取界面中已删除的设备编号；
	 * 
	 */
	public String updApply() {
		HttpServletRequest request = ServletActionContext.getRequest();
//		获取新添加的设备编号，以逗号为分隔符的字符串
		String newChooseDve = request.getParameter("newChooseDve");
//		获取界面已经删除的设备编号（即NT_APPLY_DEVICE中的ID主键值），格式为：以逗号为分隔符的字符串
		String delExsitDve = request.getParameter("delExsitDve");
//		获取界面已经删除的设备（即T_DEVICE_BASE_INFO中的DEVICE_ID的值），格式为：以逗号为分隔符的字符串
		String delDeviceId = request.getParameter("delDeviceId");
		String operate = request.getParameter("operate");
		
		// System.out.println("newChooseDve==========="+newChooseDve);
		// System.out.println("delExsitDve==========="+delExsitDve);
		// System.out.println("operate==========="+operate);
		   System.out.println("delDeviceId==========="+delDeviceId);
		
		String message = "";
		if ("save".equals(operate)) {
			deviceTestApply.setState("1");
			message = "保存";
		}
		if ("sub".equals(operate)) {
			deviceTestApply.setState("2");
//			deviceTestApply.setApplyDate(new Date());
			message = "提交";
		}
		int res = 0;
		try {
			res = dveTestApplyService.updateApply(deviceTestApply, newChooseDve, delExsitDve, delDeviceId);
		} catch (Exception e) {
			e.printStackTrace();
			SaveLog.saveLog(request, " 修改设备检测申请", OpertionType.State.ADD, "操作异常");
			request.setAttribute("message", "操作异常");
			return "input";
		}
		if (res == 10) {
			SaveLog.saveLog(request, "修改设备检测申请", OpertionType.State.ADD, "修改成功");
			request.setAttribute("message", message + "成功");
			return "success";
		} else {
			request.setAttribute("message", "操作失败");
			return "input";
		}
	}

	// 删除设备检测申请
	public String delApply() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String applyId = request.getParameter("id");
		
//		1、删除申请设备对应设备基本信息
		testService.manageDelDevInfoByApplyId(applyId);
//		2、删除申请设备信息
		dveTestApplyService.delApplyDevices(applyId);
//		3、删除申请信息
		dveTestApplyService.delApply(applyId);
//		4 删除申请审批信息
		dveTestApplyService.delApplyAudit(applyId);
//		5 删除申请表附件
		dveTestApplyService.deleteAttachByApplyId(applyId);
		
		//获取检测报告编号
		String rptId = "";
		rptId = dveTestReportService.getRptId(applyId);
		if(rptId != null && rptId != ""){
//			6 删除申请对应的检测报告的图片		
			dveTestReportService.delReptPics(rptId);
//			7 删除检测报告所需的仪器
			dveTestReportService.delReptInstrument(applyId);
//			8 删除申请对应的检测报告
			dveTestReportService.delRept(rptId);
		}else{
			System.out.println("rptId ==  null");
		}
		request.setAttribute("message", "删除成功");
		return "success";
	}

	// 提交设备检测申请
	public String subApply() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String applyId = request.getParameter("applyId");
		DeviceTestApply testApply = new DeviceTestApply();
		testApply.setApplyId(applyId);
		testApply.setState("2");
		testApply.setApplyDate(new Date());
		int res = 0;
		try {
			res = dveTestApplyService.getDeviceTestApplyDAO().updateByPrimaryKeySelective(testApply);
		} catch (Exception e) {
			e.printStackTrace();
			SaveLog.saveLog(request, "提交设备检测申请", OpertionType.State.ADD, "操作异常");
			request.setAttribute("message", "操作异常");
			return "input";
		}
		if (res > 0) {
			SaveLog.saveLog(request, "提交设备检测申请", OpertionType.State.ADD, "审核成功");
			request.setAttribute("message", "提交成功");
			return "success";
		} else {
			request.setAttribute("message", "操作失败");
			return "input";
		}
	}

	// 审核设备检测申请
	public String auditApply() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		String auditRes = request.getParameter("auditRes");
		String applyId = request.getParameter("applyId");
		String auditOpinion = request.getParameter("auditOpinion");
		DeviceTestApply testApply = new DeviceTestApply();
		testApply.setApplyId(applyId);
		if ("0".equals(auditRes)) {
			testApply.setState("3");
		}
		if ("1".equals(auditRes)) {
			testApply.setState("4");
		}
		TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
		DeviceApplyAudit applyAudit = new DeviceApplyAudit();
		applyAudit.setAuditId(UUID.randomUUID().toString());
		applyAudit.setAuditDate(new Date());
		applyAudit.setApplyId(applyId);
		applyAudit.setAuditResult(auditRes);
		applyAudit.setAuditUser(user.getUserId());
		applyAudit.setAuditOppinion(auditOpinion);
		int res = 0;
		try {
			res = dveTestApplyService.manageApply(applyAudit, testApply, testPic, testPicFileName);
		} catch (Exception e) {
			e.printStackTrace();
			SaveLog.saveLog(request, "审核设备检测申请", OpertionType.State.ADD, "操作异常");
			out.println("<script>alert('操作异常！');</script>");
			// request.setAttribute("message", "操作异常");
			return null;
		}
		if (res == 10) {
			SaveLog.saveLog(request, "审核设备检测申请", OpertionType.State.ADD, "审核成功");
			out.println("<script>alert('审核成功！');window.location='admin/device/apply_audit_list.jsp'</script>");
			// request.setAttribute("message", "审核成功");
			return null;
		} else {
			out.println("<script>alert('审核失败！');</script>");
			return null;
		}
	}

	public String selApplyAuditInfo() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String applyId = request.getParameter("applyId");
		DeviceApplyAudit info = dveTestApplyService.getDeviceApplyAuditDAO().selNewAuditInfo(applyId);

		ApplyAuditSmjExample example = new ApplyAuditSmjExample();
		example.createCriteria().andAuditIdEqualTo(info.getAuditId());
		List<ApplyAuditSmj> list = dveTestApplyService.getApplyAuditSmjDAO().selectByExample(example);
		JSONObject json = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		ApplyAuditSmj smj = new ApplyAuditSmj();
		try {
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					JSONObject jn = new JSONObject();
					smj = (ApplyAuditSmj) list.get(i);
					jn.put("Id", smj.getId());
					jn.put("SmjName", smj.getSmjName());
					jn.put("SmjUrl", smj.getSmjUrl());
					jsonArray.put(jn);
				}
			}
			json.put("picData", jsonArray);
			json.put("AuditId", info.getAuditId());
			json.put("AuditDate", DateHandler.dateToString(info.getAuditDate()));
			json.put("AuditOppinion", info.getAuditOppinion());
			json.put("AuditResult", info.getAuditResult().equals("0") ? "未通过" : "已通过");
			json.put("user", info.getRemark1());
			ServletActionContext.getResponse().getWriter().write(json.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String saveApplyAttach() {
		String applyId = deviceTestApply.getApplyId();
		if (applyId == null || applyAttach == null) {
			return null;
		} else {
			DeviceTestApplyAttach record = new DeviceTestApplyAttach();
			record.setDevApplyId(applyId);
			dveTestApplyService.saveAttach(record, applyAttach, applyAttachFileName);
		}
		return null;
	}
/**
 * 删除申请的附件
 * @return
 */
	public String deleteApplyAttach() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String devAttachId = request.getParameter("devAttachId");
		JSONObject json = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		try {
			dveTestApplyService.deleteAttach(devAttachId);
			json.put("result", "success");
			jsonArray.put(json);
			ServletActionContext.getResponse().getWriter().write(jsonArray.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String selApplyAttach() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String devApplyId = request.getParameter("devApplyId");
		DeviceTestApplyAttachExample ex = new DeviceTestApplyAttachExample();
		DeviceTestApplyAttachExample.Criteria cri = ex.createCriteria();
		cri.andDevApplyIdEqualTo(devApplyId);
		try {
			List<DeviceTestApplyAttach> list = dveTestApplyService.getDeviceTestApplyAttachDAO().selectByExample(ex);
			JSONArray jsonArray = new JSONArray();
			if (list != null && list.size() == 1) {
				for (DeviceTestApplyAttach attach : list) {
					JSONObject json = new JSONObject();
					json.put("fileUrl", attach.getDevAttachUrl());
					json.put("fileName", attach.getDevAttachName());
					json.put("devAttachId", attach.getDevAttachId());
					jsonArray.put(json);
				}
			}
			ServletActionContext.getResponse().getWriter().write(jsonArray.toString());
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "操作异常");
			return "input";
		}
	}

	public DeviceTestApplyAttach getDeviceTestApplyAttach() {
		return deviceTestApplyAttach;
	}

	public void setDeviceTestApplyAttach(DeviceTestApplyAttach deviceTestApplyAttach) {
		this.deviceTestApplyAttach = deviceTestApplyAttach;
	}

	public File getApplyAttach() {
		return applyAttach;
	}

	public void setApplyAttach(File applyAttach) {
		this.applyAttach = applyAttach;
	}

	public String getApplyAttachFileName() {
		return applyAttachFileName;
	}

	public void setApplyAttachFileName(String applyAttachFileName) {
		this.applyAttachFileName = applyAttachFileName;
	}

	public File[] getTestPic() {
		return testPic;
	}

	public void setTestPic(File[] testPic) {
		this.testPic = testPic;
	}

	public String[] getTestPicFileName() {
		return testPicFileName;
	}

	public void setTestPicFileName(String[] testPicFileName) {
		this.testPicFileName = testPicFileName;
	}

	public DeviceApplyAudit getDeviceApplyAudit() {
		return deviceApplyAudit;
	}

	public void setDeviceApplyAudit(DeviceApplyAudit deviceApplyAudit) {
		this.deviceApplyAudit = deviceApplyAudit;
	}

	public DeviceTestApply getDeviceTestApply() {
		return deviceTestApply;
	}

	public void setDeviceTestApply(DeviceTestApply deviceTestApply) {
		this.deviceTestApply = deviceTestApply;
	}

	public DveTestApplyService getDveTestApplyService() {
		return dveTestApplyService;
	}

	public void setDveTestApplyService(DveTestApplyService dveTestApplyService) {
		this.dveTestApplyService = dveTestApplyService;
	}
}
