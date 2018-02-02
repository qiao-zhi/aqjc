package com.tyust.web.action.en;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.mozilla.javascript.edu.emory.mathcs.backport.java.util.Arrays;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tyust.bean.en.EnApplyAudit;
import com.tyust.bean.en.EnApplyAuditExample;
import com.tyust.bean.en.EnApplyInfo;
import com.tyust.bean.en.EnApplyInfoExample;
import com.tyust.bean.en.EnAttach;
import com.tyust.bean.en.EnAttachExample;
import com.tyust.bean.en.EnPic;
import com.tyust.bean.en.EnPicExample;
import com.tyust.bean.unit.TBaseUnitInfo;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.common.DateHandler;
import com.tyust.dao.unit.IunitDao;
import com.tyust.service.en.EnApplyInfoService;
import com.tyust.service.en.EnTestReportService;

public class EnApplyInfoAction {

	private EnApplyInfo enApplyInfo;

	private EnAttach enAttach;

	private Map<String, Object> jsonStr;

	private File image;

	private String imageFileName;

	private File attach;

	private String attachFileName;

	private EnApplyInfoService enApplyInfoService;

	private EnTestReportService enTestReportService;

	// 文件下载
	private String filename;

	private InputStream inStream;

	// 文件下载
	public String downAttach() throws Exception {
		return "success";
	}

	public InputStream getInStream() {
		inStream = ServletActionContext.getServletContext().getResourceAsStream("/uploads/enAttach/" + filename);
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

	public String selEnApplyInfoList() throws IOException {
		String result = "success";
		HttpServletRequest request = ServletActionContext.getRequest();
		String unitId = request.getParameter("unitId");
		int pageNum = Integer.parseInt(request.getParameter("page"));
		int rp = Integer.parseInt(request.getParameter("rp"));
		int start = (pageNum - 1) * rp;
		int limit = pageNum * rp;
		EnApplyInfoExample example = new EnApplyInfoExample();
		example.setLimit(limit);
		example.setStart(start);
		example.enablePagination();
		example.setOrderByClause("environment_apply_date desc");
		EnApplyInfoExample.Criteria cri = example.createCriteria();
		cri.andEnvironmentApplyUnitIdEqualTo(unitId);
		String state = request.getParameter("state");
		if (state != null && !state.equals("all")) {
			cri.andEnvironmentApplyStatusEqualTo(state);
		}

		List<EnApplyInfo> list = enApplyInfoService.getEnApplyInfoDAO().selectByExample(example);
		int count = list.size();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		int i = 1;
		try {
			if (list.size() > 0) {
				for (EnApplyInfo info : list) {
					JSONObject json = new JSONObject();
					json.put("num", i++);
					json.put("enApplyId", info.getEnvironmentApplyId());
					json.put("userName", info.getEnvironmentApplyUserName());
					json.put("unitName", "NO");
					json.put("enApplyDate", DateHandler.dateToString(info.getEnvironmentApplyDate()));
					if (info.getEnvironmentApplyStatus().equals("1")) {
						// 未提交
						json.put("state", "未提交");
						json.put("operate",
								"<a href='enApplyInfo_update.jsp?enApplyUnitId=" + info.getEnvironmentApplyUnitId()
										+ "&enApplyUserId=" + info.getEnvironmentApplyUserId() + "&enApplyId="
										+ info.getEnvironmentApplyId() + "'>修改</a>");
						jsonArray.put(json);
					}
					if (info.getEnvironmentApplyStatus().equals("2")) {
						json.put("state", "待审核");
						json.put("operate",
								"<a href='enApplyInfo.jsp?enApplyUnitId=" + info.getEnvironmentApplyUnitId()
										+ "&enApplyUserId=" + info.getEnvironmentApplyUserId() + "&enApplyId="
										+ info.getEnvironmentApplyId() + "'>查看</a>");
						jsonArray.put(json);
					}
					if ("3".equals(info.getEnvironmentApplyStatus())) {
						json.put("state", "审核未通过");
						json.put("operate",
								"<a href='enApplyInfo_update.jsp?enApplyUnitId=" + info.getEnvironmentApplyUnitId()
										+ "&enApplyUserId=" + info.getEnvironmentApplyUserId() + "&enApplyId="
										+ info.getEnvironmentApplyId() + "'>修改</a> | "
										+ "<a href='enApplyAudit_info.jsp?enApplyId=" + info.getEnvironmentApplyId()
										+ "&enApplyUnitId=" + info.getEnvironmentApplyUnitId() + "&enApplyUserId="
										+ info.getEnvironmentApplyUserId() + "'>查看</a>");
						jsonArray.put(json);
					}
					if ("4".equals(info.getEnvironmentApplyStatus())) {
						json.put("state", "审核通过");
						json.put("operate",
								"<a href='enApplyAudit_info.jsp?enApplyId=" + info.getEnvironmentApplyId()
										+ "&enApplyUnitId=" + info.getEnvironmentApplyUnitId() + "&enApplyUserId="
										+ info.getEnvironmentApplyUserId() + "'>查看</a>");
						jsonArray.put(json);
					}
					if (info.getEnvironmentApplyStatus().equals("6")) {
						json.put("state", "检测完成");
						json.put("operate",
								"<a href='enTestReport.jsp?enApplyId=" + info.getEnvironmentApplyId()
										+ "&enTestReportId="
										+ enTestReportService.selTestReportIdByApplyId(info.getEnvironmentApplyId())
										+ "'>查看检测报告</a> | <a href='javascript:void(0)' onclick='selZS(this)'>查看证书</a>");
						jsonArray.put(json);
					}
					if ("5".equals(info.getEnvironmentApplyStatus())) {
						json.put("state", "审核通过");
						json.put("operate",
								"<a href='enApplyAudit_info.jsp?enApplyId=" + info.getEnvironmentApplyId()
										+ "&enApplyUnitId=" + info.getEnvironmentApplyUnitId() + "&enApplyUserId="
										+ info.getEnvironmentApplyUserId() + "'>查看</a>");
						jsonArray.put(json);
					}
				}
			}
			jsonObject.put("rows", jsonArray);
			jsonObject.put("page", pageNum);
			jsonObject.put("total", count);
			ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
			return null;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		jsonStr = new HashMap<String, Object>();
		jsonStr.put("result", result);
		return "success";
	}

	public String saveEnApplyInfo() {
		PrintWriter out = null;
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			out = ServletActionContext.getResponse().getWriter();
			// 获取操作 判断是保存与提交
			String operate = request.getParameter("operate");
			String enApplyId = enApplyInfo.getEnvironmentApplyId();
			if (operate.equals("save")) {
				enApplyInfo.setEnvironmentApplyStatus("1");
			} else if (operate.equals("submit")) {
				enApplyInfo.setEnvironmentApplyStatus("2");
			} else {
				out.println("<script>alert('操作失败，请刷新重试！');</script>");
			}
			if (enApplyId == null || enApplyId.equals("")) {
				enApplyId = enApplyInfoService.insertEnApplyInfo(enApplyInfo);
			} else {
				enApplyId = enApplyInfoService.updateEnApplyInfo(enApplyInfo);
			}
			jsonStr = new HashMap<String, Object>();
			jsonStr.put("result", "success");
			jsonStr.put("enApplyId", enApplyId);
		} catch (Exception e) {
			e.printStackTrace();
			out.println("<script>alert('操作发生异常！');</script>");
		}
		return "success";
	}

	public String selEnApplyInfoById() {
		jsonStr = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String enApplyId = request.getParameter("enApplyId");
		EnApplyInfo info = enApplyInfoService.getEnApplyInfoDAO().selectByPrimaryKey(enApplyId);
		jsonStr.put("enApplyDate", DateHandler.dateToString(info.getEnvironmentApplyDate()));
		jsonStr.put("enApplyUserName", info.getEnvironmentApplyUserName());
		jsonStr.put("enApplyTel", info.getEnvironmentApplyTel());
		jsonStr.put("enApplySamply", info.getEnvironmentApplySamply());
		jsonStr.put("enApplyProduction", info.getEnvironmentApplyProduction());
		jsonStr.put("enApplyOpinion", info.getEnvironmentApplyOpinion());
		return "success";
	}

	public String delEnApplyInfo() {
		String result = "success";
		jsonStr = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String enApplyId = request.getParameter("enApplyId");
		try {
			EnApplyInfo info = enApplyInfoService.getEnApplyInfoDAO().selectByPrimaryKey(enApplyId);
			if (info.getEnvironmentApplyStatus().equals("1")) {
				enApplyInfoService.delEnApply(enApplyId);
			} else {
				result = "不可删除";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "error";
		}
		jsonStr.put("result", result);
		return "success";
	}

	public String saveEnPic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String enApplyId = request.getParameter("enApplyId");
		String picType = "1";
		enApplyInfoService.uploadEnPic(enApplyId, picType, image, imageFileName);
		jsonStr = new HashMap<String, Object>();
		jsonStr.put("result", "success");
		return "success";
	}

	public String selEnPic() {
		jsonStr = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String enApplyId = request.getParameter("enApplyId");
		String enPicType = request.getParameter("enPicType");
		EnPicExample example = new EnPicExample();
		EnPicExample.Criteria cri = example.createCriteria();
		cri.andEnApplyIdEqualTo(enApplyId);
		cri.andEnPicTypeEqualTo(enPicType);
		JSONArray jsonArray = new JSONArray();
		try {
			List<EnPic> picList = enApplyInfoService.getEnPicDAO().selectByExample(example);
			if (picList != null && picList.size() > 0) {
				for (EnPic pic : picList) {
					JSONObject json = new JSONObject();
					json.put("enPicUrl", pic.getEnPicUrl());
					json.put("enPicId", pic.getEnPicId());
					jsonArray.put(json);
				}
			}
			ServletActionContext.getResponse().getWriter().write(jsonArray.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String delEnPic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String enPicId = request.getParameter("enPicId");
		enApplyInfoService.delEnPic(enPicId);
		jsonStr = new HashMap<String, Object>();
		jsonStr.put("result", "success");
		return "success";
	}

	public String saveEnAttach() {
		String enApplyId = enAttach.getEnvironmentApplyId();
		String result = "success";
		if (attach.length() == 0) {
			result = "error";
		}
		if (enApplyId.equals("") || enApplyId == null) {
			result = "error";
		} else {
			EnAttach record = enAttach;
			enApplyInfoService.uploadEnAttach(record, attach, attachFileName);
		}
		jsonStr = new HashMap<String, Object>();
		jsonStr.put("result", result);
		return "success";
	}

	public String selEnAttach() {
		jsonStr = new HashMap<String, Object>();
		String result = "success";
		HttpServletRequest request = ServletActionContext.getRequest();
		String enApplyId = request.getParameter("enApplyId");
		EnAttachExample example = new EnAttachExample();
		EnAttachExample.Criteria cri = example.createCriteria();
		cri.andEnvironmentApplyIdEqualTo(enApplyId);
		int flag = 0;
		try {
			List<EnAttach> list = enApplyInfoService.getEnAttachDAO().selectByExample(example);
			if (list != null && list.size() > 0) {
				jsonStr.put("fileName", list.get(0).getEnvironmentAttachName());
				jsonStr.put("fileUrl", list.get(0).getEnvironmentAttachUrl());
				jsonStr.put("enAttachId", list.get(0).getEnvironmentAttachId());
				flag = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "error";
		}
		jsonStr.put("isNull", flag);
		jsonStr.put("result", result);
		return "success";
	}

	public String delEnAttach() {
		String result = "success";
		HttpServletRequest request = ServletActionContext.getRequest();
		String enAttachId = request.getParameter("enAttachId");
		enApplyInfoService.delEnAttach(enAttachId);
		jsonStr = new HashMap<String, Object>();
		jsonStr.put("result", result);
		return "success";
	}

	// ------------------------------------------审核------------------------------------
	// 审核时查询全部单位的申请
	public String selAllApplyList() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int pageNum = Integer.parseInt(request.getParameter("page"));
		int rp = Integer.parseInt(request.getParameter("rp"));
		int start = (pageNum - 1) * rp;
		int limit = pageNum * rp;
		String state = request.getParameter("state");
		EnApplyInfoExample ex = new EnApplyInfoExample();
		ex.setStart(start);
		ex.setLimit(limit);
		ex.enablePagination();
		ex.setOrderByClause("environment_apply_date desc");
		EnApplyInfoExample.Criteria cri = ex.createCriteria();
		if (state != null && !"all".equals(state)) {
			if (state.equals("4")) {
				String[] s = { "4", "5" };
				List<String> str = Arrays.asList(s);
				cri.andEnvironmentApplyStatusIn(str);
			} else {
				cri.andEnvironmentApplyStatusEqualTo(state);
			}
		} else {
			String[] s = { "2", "3", "4", "5", "6" };
			List<String> str = Arrays.asList(s);
			cri.andEnvironmentApplyStatusIn(str);
		}

		ApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(request.getSession().getServletContext());
		IunitDao unitDao = (IunitDao) context.getBean("Unit");
		TBaseUnitInfo unit = new TBaseUnitInfo();

		List<EnApplyInfo> list = enApplyInfoService.getEnApplyInfoDAO().selectByExample(ex);
		int total = list.size();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		EnApplyInfo info = new EnApplyInfo();

		try {
			for (int i = 0; i < list.size(); i++) {
				JSONObject json = new JSONObject();
				info = list.get(i);
				json.put("num", i + 1);
				json.put("ApplyId", info.getEnvironmentApplyId());
				unit = unitDao.findUnit(info.getEnvironmentApplyUnitId());
				json.put("Unit", unit.getUnitName());
				json.put("User", info.getEnvironmentApplyUserName());
				json.put("Apply_Date", DateHandler.dateToString(info.getEnvironmentApplyDate()));
				String stateStr = info.getEnvironmentApplyStatus().trim();
				if (stateStr.equals("2")) {
					json.put("State", "待审核");
					json.put("operate",
							"<a href='enApplyAudit.jsp?enApplyId=" + info.getEnvironmentApplyId() + "&enApplyUnitId="
									+ info.getEnvironmentApplyUnitId() + "&enApplyUserId="
									+ info.getEnvironmentApplyUserId() + "'>审核</a>");
					jsonArray.put(json);
				} else if (stateStr.equals("3")) {
					json.put("State", "审核未通过");
					json.put("operate",
							"<a href='enApplyAudit_info.jsp?enApplyId=" + info.getEnvironmentApplyId()
									+ "&enApplyUnitId=" + info.getEnvironmentApplyUnitId() + "&enApplyUserId="
									+ info.getEnvironmentApplyUserId() + "'>查看</a>");
					jsonArray.put(json);
				} else if (stateStr.equals("4")) {
					json.put("State", "审核通过");
					json.put("operate",
							"<a href='enTestReport_add.jsp?enApplyId=" + info.getEnvironmentApplyId() + "'>填写检测报告</a>");
					jsonArray.put(json);
				} else if (stateStr.equals("5")) {
					json.put("State", "审核通过");
					json.put("operate",
							"<a href='enTestReport_update.jsp?enTestReportId="
									+ enTestReportService.selTestReportIdByApplyId(info.getEnvironmentApplyId())
									+ "&enApplyId=" + info.getEnvironmentApplyId() + "'>填写检测报告</a>");
					jsonArray.put(json);
				} else if (stateStr.equals("6")) {
					json.put("State", "检测完成");
					json.put("operate",
							"<a href='enTestReport.jsp?enApplyId=" + info.getEnvironmentApplyId() + "&enTestReportId="
									+ enTestReportService.selTestReportIdByApplyId(info.getEnvironmentApplyId())
									+ "'>查看检测报告</a>");
					jsonArray.put(json);
				}
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

	public String saveEnApplyAudit() {
		String result = "success";
		HttpServletRequest request = ServletActionContext.getRequest();
		String enApplyId = request.getParameter("enApplyId");
		String auditResult = request.getParameter("auditResult");
		String auditOppinion = request.getParameter("auditOppinion");
		try {
			EnApplyInfo applyInfo = new EnApplyInfo();
			applyInfo.setEnvironmentApplyId(enApplyId);
			if ("0".equals(auditResult)) {
				applyInfo.setEnvironmentApplyStatus("3");
			} else if ("1".equals(auditResult)) {
				applyInfo.setEnvironmentApplyStatus("4");
			}

			enApplyInfoService.getEnApplyInfoDAO().updateByPrimaryKeySelective(applyInfo);

			TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
			EnApplyAudit enApplyAudit = new EnApplyAudit();
			enApplyAudit.setAuditDate(new Date());
			enApplyAudit.setApplyId(enApplyId);
			enApplyAudit.setAuditResult(auditResult);
			enApplyAudit.setAuditOppinion(auditOppinion);
			enApplyAudit.setAuditUser(user.getUserName());

			enApplyInfoService.insertEnApplyAudit(enApplyAudit);
		} catch (Exception e) {
			e.printStackTrace();
			result = "error";
		}
		jsonStr = new HashMap<String, Object>();
		jsonStr.put("result", result);
		return "success";
	}

	public String selEnApplyAudit() {
		String result = "success";
		jsonStr = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String enApplyId = request.getParameter("enApplyId");
		EnApplyAuditExample ex = new EnApplyAuditExample();
		EnApplyAuditExample.Criteria cri = ex.createCriteria();
		cri.andApplyIdEqualTo(enApplyId);
		List<EnApplyAudit> list = enApplyInfoService.getEnApplyAuditDAO().selectByExample(ex);
		if (list != null && list.size() >= 1) {
			EnApplyAudit audit = list.get(0);
			jsonStr.put("auditOppinion", audit.getAuditOppinion());
			jsonStr.put("auditUser", audit.getAuditUser());
			jsonStr.put("auditResult", audit.getAuditResult());
			jsonStr.put("auditDate", DateHandler.dateToString(audit.getAuditDate()));
		}
		jsonStr.put("result", result);
		return "success";
	}

	public String saveZSEnPic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String enApplyId = request.getParameter("enApplyId");
		String picType = "3";
		System.out.println(image + imageFileName);
		enApplyInfoService.uploadEnPic(enApplyId, picType, image, imageFileName);
		jsonStr = new HashMap<String, Object>();
		jsonStr.put("result", "success");
		return "success";
	}

	public String updateZSEnPic() {
		jsonStr = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String enApplyId = request.getParameter("enApplyId");
		String enPicType = "3";
		try {
			enApplyInfoService.updateEnPic(enApplyId, enPicType, image, imageFileName);
			jsonStr.put("result", "success");
		} catch (Exception e) {
			e.printStackTrace();
			jsonStr.put("result", "error");
		}
		return "success";
	}

	public String selEnZSPic() {
		jsonStr = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String enApplyId = request.getParameter("enApplyId");
		String enPicType = request.getParameter("enPicType");
		EnPicExample example = new EnPicExample();
		EnPicExample.Criteria cri = example.createCriteria();
		cri.andEnApplyIdEqualTo(enApplyId);
		cri.andEnPicTypeEqualTo(enPicType);
		try {
			List<EnPic> picList = enApplyInfoService.getEnPicDAO().selectByExample(example);
			if (picList != null && picList.size() == 1) {
				EnPic pic = picList.get(0);
				jsonStr.put("enPicUrl", pic.getEnPicUrl());
				jsonStr.put("result", "success");
			} else {
				jsonStr.put("result", "error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String delEnZSPic() {
		jsonStr = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String enApplyId = request.getParameter("enApplyId");
		String enPicType = request.getParameter("enPicType");
		try {
			enApplyInfoService.delEnPic2(enApplyId, enPicType);
			jsonStr.put("result", "success");
		} catch (Exception e) {
			e.printStackTrace();
			jsonStr.put("result", "error");
		}
		return "success";
	}

	public EnApplyInfo getEnApplyInfo() {
		return enApplyInfo;
	}

	public void setEnApplyInfo(EnApplyInfo enApplyInfo) {
		this.enApplyInfo = enApplyInfo;
	}

	public EnAttach getEnAttach() {
		return enAttach;
	}

	public void setEnAttach(EnAttach enAttach) {
		this.enAttach = enAttach;
	}

	public Map<String, Object> getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(Map<String, Object> jsonStr) {
		this.jsonStr = jsonStr;
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

	public File getAttach() {
		return attach;
	}

	public void setAttach(File attach) {
		this.attach = attach;
	}

	public String getAttachFileName() {
		return attachFileName;
	}

	public void setAttachFileName(String attachFileName) {
		this.attachFileName = attachFileName;
	}

	public EnApplyInfoService getEnApplyInfoService() {
		return enApplyInfoService;
	}

	public void setEnApplyInfoService(EnApplyInfoService enApplyInfoService) {
		this.enApplyInfoService = enApplyInfoService;
	}

	public EnTestReportService getEnTestReportService() {
		return enTestReportService;
	}

	public void setEnTestReportService(EnTestReportService enTestReportService) {
		this.enTestReportService = enTestReportService;
	}

}
