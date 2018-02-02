package com.tyust.web.action.pbs;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tyust.bean.pbs.PbsApplyInfo;
import com.tyust.bean.pbs.PbsApplyInfoExample;
import com.tyust.bean.pbs.PbsPicExample;
import com.tyust.bean.pbs.PbsTestReport;
import com.tyust.bean.pbs.PbsTestReportExample;
import com.tyust.bean.unit.TBaseUnitInfo;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.common.DateHandler;
import com.tyust.common.OpertionType;
import com.tyust.common.SaveLog;
import com.tyust.dao.unit.IunitDao;
import com.tyust.service.pbs.PbsApplyInfoService;
import com.tyust.service.pbs.PbsTestReportService;

public class PbsTestReportAction {

	private PbsTestReportService pbsTestReportService;

	private PbsApplyInfoService pbsApplyInfoService;

	private PbsTestReport pbsTestReport;

	private File image;

	private String imageFileName;

	private Map<String, Object> resultJson;

	public String selPbsTestReportList() throws JSONException, IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		int pageNum = Integer.parseInt(request.getParameter("page"));
		int rp = Integer.parseInt(request.getParameter("rp"));
		int start = (pageNum - 1) * rp;
		int limit = pageNum * rp;
		PbsTestReportExample example = new PbsTestReportExample();
		example.setLimit(limit);
		example.setStart(start);
		example.enablePagination();
		example.setOrderByClause("test_date desc");
		PbsTestReportExample.Criteria cri = example.createCriteria();
		// 检测信息的申请状态
		String state = request.getParameter("state");
		if (state != null && !state.equals("all")) {
			cri.andTestStatusEqualTo(state);
		}

		boolean flag = true;
		// 检测信息的申请部门
		String pbsApplyUnitName = request.getParameter("applyUnitName");
		if (pbsApplyUnitName != null && !pbsApplyUnitName.trim().equals("")) {
			ApplicationContext context = WebApplicationContextUtils
					.getRequiredWebApplicationContext(request.getSession().getServletContext());
			IunitDao unitDao = (IunitDao) context.getBean("Unit");
			List<TBaseUnitInfo> unitList = unitDao.selectUnitInfoByUnitName(pbsApplyUnitName);
			// 部门id集合
			List<String> unitIdList = new ArrayList<String>();
			if (unitList != null && unitList.size() > 0) {
				for (TBaseUnitInfo unit : unitList) {
					unitIdList.add(unit.getUnitId());
				}
			} else {
				flag = false;
			}
			if (unitIdList != null && unitIdList.size() > 0) {
				// 获取部门申请列表
				PbsApplyInfoExample applyex = new PbsApplyInfoExample();
				PbsApplyInfoExample.Criteria applycri = applyex.createCriteria();
				applycri.andPbsApplyUnitIdIn(unitIdList);
				List<PbsApplyInfo> applyList = pbsApplyInfoService.getPbsApplyInfoDAO().selectByExample(applyex);
				// 生成屏蔽室申请ID集合
				List<String> applyIdList = new ArrayList<String>();
				if (applyList != null && applyList.size() != 0) {
					for (PbsApplyInfo apply : applyList) {
						applyIdList.add(apply.getPbsApplyId());
					}
				} else {
					flag = false;
				}
				// 检索屏蔽室申请ID
				if (applyIdList != null && applyIdList.size() > 0) {
					cri.andPbsApplyIdIn(applyIdList);
				}
			}
		}
		if (flag == true) {
			String startDateStr = request.getParameter("startDate");
			String endDateStr = request.getParameter("endDate");
			if ((startDateStr != null && !startDateStr.equals("")) && (endDateStr != null && !endDateStr.equals(""))) {
				Date startDate = null;
				Date endDate = null;
				try {
					startDate = DateHandler.changeStringToDate(startDateStr);
					endDate = DateHandler.changeStringToDate(endDateStr);
				} catch (ParseException e) {
					e.printStackTrace();
					out.println("<script>alert('日期操作异常！');</script>");
				}
				// 检索日期
				if (cri != null) {
					cri.andTestDateBetween(startDate, endDate);
				}

			}
		}

		// 如果是地区用户 需要检索他所在部门的检测信息
		TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
		String unitId = user.getUnitId();
		if (!unitId.equals("1")) {
			if (flag) {
				PbsApplyInfoExample pbsex = new PbsApplyInfoExample();
				PbsApplyInfoExample.Criteria pbscri = pbsex.createCriteria();
				pbscri.andPbsApplyUnitIdEqualTo(unitId);
				List<PbsApplyInfo> pbs = pbsApplyInfoService.getPbsApplyInfoDAO().selectByExample(pbsex);
				if (pbs != null && pbs.size() > 0) {
					List<String> pbsApplyIds = new ArrayList<String>();
					for (PbsApplyInfo info : pbs) {
						pbsApplyIds.add(info.getPbsApplyId());
					}
					cri.andPbsApplyIdIn(pbsApplyIds);
				}
			}
		}

		List<PbsTestReport> list = new ArrayList<PbsTestReport>();
		if (flag == true) {
			list = pbsTestReportService.listPbsTestReport(example);
		}
		int total = list.size();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		PbsTestReport report = new PbsTestReport();
		for (int i = 0; i < list.size(); i++) {
			JSONObject json = new JSONObject();
			report = list.get(i);
			json.put("num", i + 1);
			json.put("ReportId", report.getPbsTestReportId());
			json.put("ApplyId", report.getPbsApplyId());
			json.put("TestCode", report.getTestReportNumber());
			json.put("TestUser", report.getTestUserName());
			json.put("TestDate", DateHandler.dateToString(report.getTestDate()));
			json.put("pbsApplyId", report.getPbsApplyId());
			if (unitId.equals("1")) {
				if (report.getTestStatus().equals("2")) {
					json.put("State", "已提交");
					// 保存与提交
					json.put("Operate", "<a href='report.jsp?pbsTestReportId=" + report.getPbsTestReportId()
							+ "'>查看检测报告</a>| <a href='javascript:void(0)' onclick='zs_add(this)'>添加证书</a> | "
							+ "<a href='javascript:void(0)' onclick='zs_update(this)'>更新证书</a> | <a href='javascript:void(0)' onclick='zs_delete(this)'>证书删除</a>");
					jsonArray.put(json);
				} else {
					json.put("State", "未提交");
					// 保存与提交
					json.put("Operate", "<a href='report_update.jsp?pbsTestReportId=" + report.getPbsTestReportId()
							+ "'>修改检测报告</a>");
					jsonArray.put(json);
				}
			} else {
				if (report.getTestStatus().equals("2")) {
					json.put("State", "已提交");
					// 保存与提交
					json.put("Operate",
							"<a href='report.jsp?pbsTestReportId=" + report.getPbsTestReportId() + "'>查看检测报告</a>| <a href='javascript:void(0)' onclick='selZS(this)'>查看证书</a>");
					jsonArray.put(json);
				}
			}
		}
		jsonObject.put("rows", jsonArray);
		jsonObject.put("page", pageNum);
		jsonObject.put("total", total);
		ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
		return null;
	}

	// 保存屏蔽室检测报告
	public String savePbsTestReport() throws IOException {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		HttpServletRequest request = ServletActionContext.getRequest();
		resultJson = new HashMap<String, Object>();
		// 申请信息
		PbsApplyInfo pbsApplyInfo = new PbsApplyInfo();
		pbsApplyInfo.setPbsApplyId(pbsTestReport.getPbsApplyId());
		String operate = request.getParameter("operate");
		if ("save".equals(operate)) {
			pbsTestReport.setTestStatus("1");
			pbsApplyInfo.setPbsApplyStatus("3");
		}
		if ("submit".equals(operate)) {
			pbsTestReport.setTestStatus("2");
			pbsApplyInfo.setPbsApplyStatus("4");
		}
		String result = "success";
		try {
			pbsTestReportService.insertPbsTestReport(pbsTestReport);
			pbsApplyInfoService.getPbsApplyInfoDAO().updateByPrimaryKeySelective(pbsApplyInfo);
		} catch (Exception e) {
			result = "error";
			e.printStackTrace();
			SaveLog.saveLog(request, "屏蔽室检测报告", OpertionType.State.ADD, "操作异常");
			out.println("<script>alert('操作异常！');</script>");
		}
		resultJson.put("result", result);
		return "success";
	}

	// 更新屏蔽室检测信息
	public String updatePbsTestReport() throws IOException {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		HttpServletRequest request = ServletActionContext.getRequest();
		resultJson = new HashMap<String, Object>();
		// 申请信息
		PbsApplyInfo pbsApplyInfo = new PbsApplyInfo();
		pbsApplyInfo.setPbsApplyId(pbsTestReport.getPbsApplyId());
		String operate = request.getParameter("operate");
		if ("save".equals(operate)) {
			pbsTestReport.setTestStatus("1");
			pbsApplyInfo.setPbsApplyStatus("3");
		}
		if ("submit".equals(operate)) {
			pbsTestReport.setTestStatus("2");
			pbsApplyInfo.setPbsApplyStatus("4");
		}
		String result = "success";
		try {
			pbsTestReportService.updatePbsTestReport(pbsTestReport);
			pbsApplyInfoService.getPbsApplyInfoDAO().updateByPrimaryKeySelective(pbsApplyInfo);
		} catch (Exception e) {
			result = "error";
			e.printStackTrace();
			SaveLog.saveLog(request, "屏蔽室检测报告", OpertionType.State.ADD, "操作异常");
			out.println("<script>alert('操作异常！');</script>");
		}
		resultJson.put("result", result);
		return "success";
	}

	// 查询
	public String queryPbsTestReport() throws IOException {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		HttpServletRequest request = ServletActionContext.getRequest();
		resultJson = new HashMap<String, Object>();
		String pbsTestReportId = request.getParameter("pbsTestReportId");
		if (pbsTestReportId == null || pbsTestReportId.equals("")) {
			out.println("<script>alert('操作异常！');</script>");
			return null;
		} else {
			PbsTestReport report = pbsTestReportService.queryPbsTestReportById(pbsTestReportId);
			if (report != null) {
				resultJson.put("pbsTestReportId", report.getPbsTestReportId());
				resultJson.put("pbsApplyId", report.getPbsApplyId());
				resultJson.put("testUserName", report.getTestUserName());
				resultJson.put("testReportNumber", report.getTestReportNumber());
				resultJson.put("testDate", DateHandler.dateToString(report.getTestDate()));
			}
		}
		return "success";
	}

	// 删除检测信息
	public String delPbsTestReport() {
		HttpServletRequest request = ServletActionContext.getRequest();
		resultJson = new HashMap<String, Object>();
		String pbsTestReportId = request.getParameter("pbsTestReportId");
		String pbsApplyId = request.getParameter("pbsApplyId");
		String result = "success";
		if (pbsTestReportId == "" || pbsTestReportId == null || pbsTestReportId.equals("")) {
			resultJson.put("result", "删除失败！");
		} else {
			try {

				PbsPicExample picex = new PbsPicExample();
				PbsPicExample.Criteria piccri = picex.createCriteria();
				piccri.andPbsApplyIdEqualTo(pbsApplyId);
				piccri.andPbsPicTypeEqualTo("2");
				pbsTestReportService.getPbsPicDAO().deleteByExample(picex);

				pbsTestReportService.getPbsTestReportDAO().deleteByPrimaryKey(pbsTestReportId);

				// 申请信息
				PbsApplyInfo pbsApplyInfo = new PbsApplyInfo();
				pbsApplyInfo.setPbsApplyId(pbsTestReport.getPbsApplyId());
				pbsApplyInfo.setPbsApplyStatus("2");
				pbsApplyInfoService.getPbsApplyInfoDAO().updateByPrimaryKeySelective(pbsApplyInfo);
				resultJson.put("result", result);
			} catch (Exception e) {
				e.printStackTrace();
				result = "error";
				resultJson.put("result", result);
			}
		}
		return "success";
	}

	// 保存图片
	public String saveImage() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String pbsApplyId = request.getParameter("pbsApplyId");
		// 上传屏蔽室检测图片 所以图片类型为:2
		String picType = "2";
		pbsTestReportService.uploadPbsPic(pbsApplyId, picType, image, imageFileName);
		resultJson = new HashMap<String, Object>();
		String result = "success";
		resultJson.put("result", result);
		return "success";
	}

	public PbsTestReportService getPbsTestReportService() {
		return pbsTestReportService;
	}

	public void setPbsTestReportService(PbsTestReportService pbsTestReportService) {
		this.pbsTestReportService = pbsTestReportService;
	}

	public PbsTestReport getPbsTestReport() {
		return pbsTestReport;
	}

	public void setPbsTestReport(PbsTestReport pbsTestReport) {
		this.pbsTestReport = pbsTestReport;
	}

	public Map<String, Object> getResultJson() {
		return resultJson;
	}

	public void setResultJson(Map<String, Object> resultJson) {
		this.resultJson = resultJson;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public PbsApplyInfoService getPbsApplyInfoService() {
		return pbsApplyInfoService;
	}

	public void setPbsApplyInfoService(PbsApplyInfoService pbsApplyInfoService) {
		this.pbsApplyInfoService = pbsApplyInfoService;
	}

}
