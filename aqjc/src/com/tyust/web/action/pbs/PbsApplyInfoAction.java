package com.tyust.web.action.pbs;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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

import com.tyust.bean.pbs.PbsApplyAudit;
import com.tyust.bean.pbs.PbsApplyAuditExample;
import com.tyust.bean.pbs.PbsApplyInfo;
import com.tyust.bean.pbs.PbsApplyInfoExample;
import com.tyust.bean.pbs.PbsAttach;
import com.tyust.bean.pbs.PbsAttachExample;
import com.tyust.bean.pbs.PbsPic;
import com.tyust.bean.pbs.PbsPicExample;
import com.tyust.bean.pbs.PbsTestReportExample;
import com.tyust.bean.unit.TBaseUnitInfo;
import com.tyust.common.DateHandler;
import com.tyust.dao.unit.IunitDao;
import com.tyust.service.pbs.PbsApplyInfoService;
import com.tyust.service.pbs.PbsTestReportService;
import com.tyust.service.unit.UnitService;
import com.tyust.service.user.UserService;

/**
 * 屏蔽室申请信息action
 * 
 * @author sunwei
 *
 */
public class PbsApplyInfoAction {

	// 屏蔽室申请信息
	private PbsApplyInfo pbsApplyInfo;
	// 屏蔽室附件信息
	private PbsAttach pbsAttach;
	// 屏蔽室审核表
	private PbsApplyAudit pbsApplyAudit;
	// 屏蔽室申请ID
	private String pbsApplyId;	
	
	private Map<String, Object> jsonStr;

	// 屏蔽室申请服务类
	private PbsApplyInfoService pbsApplyInfoService;
	// 屏蔽室检测服务类
	private PbsTestReportService pbsTestReportService;
	// 用户服务类
	private UserService userService;
	//单位服务类
	private UnitService unitService;
	// 图片
	private File pbsApplyImage;

	private String pbsApplyImageFileName;

	// 附件
	private File pbsApplyInfoAttach;

	private String pbsApplyInfoAttachFileName;

	// 文件下载
	private String filename;

	private InputStream inStream;

	// 文件下载
	public String downAttach() throws Exception {
		return "success";
	}

	public InputStream getInStream() {
		inStream = ServletActionContext.getServletContext().getResourceAsStream("/uploads/pbsAttach/" + filename);
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

	// 保存与更新屏蔽室申请信息
	public String savePbsApplyInfo() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		// 获取操作 判断是保存与提交
		String operate = request.getParameter("operate");
		String pbsApplyId = pbsApplyInfo.getPbsApplyId();
		try {
			if (operate.equals("save")) {
				pbsApplyInfo.setPbsApplyStatus("1");
			} else if (operate.equals("submit")) {
				pbsApplyInfo.setPbsApplyStatus("2");
			} else {
				out.println("<script>alert('操作失败，请刷新重试！');</script>");
			}
			if (pbsApplyId == null || pbsApplyId.equals("")) {
				pbsApplyId = pbsApplyInfoService.insertPbsApplyInfo(pbsApplyInfo);
			} else {
				pbsApplyId = pbsApplyInfoService.updatePbsApplyInfo(pbsApplyInfo);
			}
			// 将屏蔽室申请ID 返回给前台
			jsonStr = new HashMap<String, Object>();
			jsonStr.put("pbsApplyId", pbsApplyId);
			jsonStr.put("result", "success");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("<script>alert('操作发生异常！');</script>");
		}
		return "success";
	}

	// 保存图片
	public String saveImage() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String pbsApplyId = request.getParameter("pbsApplyId");
		// 上传屏蔽室申请书图片 所以图片类型为:1
		String picType = "1";
		pbsApplyInfoService.uploadPbsPic(pbsApplyId, picType, pbsApplyImage, pbsApplyImageFileName);
		jsonStr = new HashMap<String, Object>();
		String result = "success";
		jsonStr.put("result", result);
		return "success";
	}

	// 删除图片
	public String delImage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String pbsPicId = request.getParameter("pbsPicId");
		jsonStr = new HashMap<String, Object>();
		String result = "success";
		System.out.println(pbsPicId);
		try {
			pbsApplyInfoService.delPbsPic(pbsPicId);
		} catch (Exception e) {
			e.printStackTrace();
			result = "error";
			return null;
		}
		jsonStr.put("result", result);
		return "success";
	}

	// 保存附件
	public String saveAttach() {
		String pbsApplyId = pbsApplyInfo.getPbsApplyId();
		if (pbsApplyId == null || pbsApplyInfoAttach == null) {
			return null;
		} else if (pbsApplyInfoAttach.length() == 0) {
			return null;
		} else {
			PbsAttach record = new PbsAttach();
			record.setPbsApplyId(pbsApplyId);
			String pbsAttachType = pbsAttach.getPbsAttachType();
			record.setPbsAttachType(pbsAttachType);
			pbsApplyInfoService.insertPbsAttach(record, pbsApplyInfoAttach, pbsApplyInfoAttachFileName);
		}
		return null;
	}

	// 删除附件
	public String delAttach() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String pbsAttachId = request.getParameter("pbsAttachId");
		String result = "success";
		jsonStr = new HashMap<String, Object>();
		try {
			pbsApplyInfoService.delPbsAttach(pbsAttachId);
		} catch (Exception e) {
			e.printStackTrace();
			result = "error";
			return null;
		}
		jsonStr.put("result", result);
		return "success";
	}

	// 删除屏蔽室信息
	public String delApply() {
		String pbsApplyId = pbsApplyInfo.getPbsApplyId();
		jsonStr = new HashMap<String, Object>();
		String result = "success";
		if (pbsApplyId == null || pbsApplyId.equals("")) {
			jsonStr.put("result", "删除错误");
		} else {
			try {
				PbsAttachExample attex = new PbsAttachExample();
				PbsAttachExample.Criteria attcri = attex.createCriteria();
				attcri.andPbsApplyIdEqualTo(pbsApplyId);
				pbsApplyInfoService.getPbsAttachDAO().deleteByExample(attex);

				PbsPicExample picex = new PbsPicExample();
				PbsPicExample.Criteria piccri = picex.createCriteria();
				piccri.andPbsApplyIdEqualTo(pbsApplyId);
				pbsApplyInfoService.getPbsPicDAO().deleteByExample(picex);

				PbsTestReportExample reex = new PbsTestReportExample();
				PbsTestReportExample.Criteria recri = reex.createCriteria();
				recri.andPbsApplyIdEqualTo(pbsApplyId);
				pbsTestReportService.getPbsTestReportDAO().deleteByExample(reex);

				pbsApplyInfoService.getPbsApplyInfoDAO().deleteByPrimaryKey(pbsApplyId);
				jsonStr.put("result", result);
			} catch (Exception e) {
				e.printStackTrace();
				result = "错误";
				jsonStr.put("result", result);
			}
		}
		return "success";
	}

	// 根据申请编号查询单个屏蔽室申请信息
	public String selPbsApplyInfoById() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String pbsApplyId = request.getParameter("pbsApplyId");
		PbsApplyInfo info = pbsApplyInfoService.getPbsApplyInfoDAO().selectByPrimaryKey(pbsApplyId);
		JSONObject json = new JSONObject();
		if (info != null) {
			json.put("pbsApplyDate", DateHandler.dateToString(info.getPbsApplyDate()));
			json.put("pbsApplyUserName", info.getPbsApplyUserName());
			json.put("pbsApplyTel", info.getPbsApplyTel());
			json.put("pbsApplyProduction", info.getPbsApplyProduction());
			json.put("pbsApplyGrade", info.getPbsApplyGrade());
			json.put("pbsApplyOpinion", info.getPbsApplyOpinion());
			json.put("pbsApplyUnitId", info.getPbsApplyUnitId());
		}
		ServletActionContext.getResponse().getWriter().write(json.toString());
		return null;
	}

	// 根据申请编号查询图片
	public String selPbsPic() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String pbsApplyId = request.getParameter("pbsApplyId");
		String pbsPicType = request.getParameter("pbsPicType");
		PbsPicExample example = new PbsPicExample();
		PbsPicExample.Criteria cri = example.createCriteria();
		cri.andPbsApplyIdEqualTo(pbsApplyId);
		cri.andPbsPicTypeEqualTo(pbsPicType);
		List<PbsPic> pbsPicList = pbsApplyInfoService.getPbsPicDAO().selectByExample(example);
		JSONArray jsonArray = new JSONArray();
		if (pbsPicList != null) {
			if (pbsPicList.size() > 0) {
				for (PbsPic pic : pbsPicList) {
					JSONObject json = new JSONObject();
					json.put("pbsPicUrl", pic.getPbsPicUrl());
					json.put("pbsPicId", pic.getPbsPicId());
					jsonArray.put(json);
				}
			}
		}
		ServletActionContext.getResponse().getWriter().write(jsonArray.toString());
		return null;
	}

	// 根据申请编号获取申请书附件信息
	public String selPbsAttach() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String pbsApplyId = request.getParameter("pbsApplyId");
		String pbsAttachType = request.getParameter("pbsAttachType");
		PbsAttachExample example = new PbsAttachExample();
		PbsAttachExample.Criteria cri = example.createCriteria();
		cri.andPbsApplyIdEqualTo(pbsApplyId);
		cri.andPbsAttachTypeEqualTo(pbsAttachType);
		List<PbsAttach> list = pbsApplyInfoService.getPbsAttachDAO().selectByExample(example);
		JSONArray jsonArray = new JSONArray();
		if (list != null) {
			if (list.size() == 1) {
				for (PbsAttach attach : list) {
					JSONObject json = new JSONObject();
					json.put("fileUrl", attach.getPbsAttachUrl());
					json.put("fileName", attach.getPbsAttachName());
					json.put("pbsAttachId", attach.getPbsAttachId());
					json.put("pbsAttachUrl", attach.getPbsAttachUrl());
					jsonArray.put(json);
				}
			}
		}
		ServletActionContext.getResponse().getWriter().write(jsonArray.toString());
		return null;
	}

	// 获取屏蔽申请列表
	public String selPbsApplyInfoListByUnit() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int pageNum = Integer.parseInt(request.getParameter("page"));
		int rp = Integer.parseInt(request.getParameter("rp"));
		int start = (pageNum - 1) * rp;
		int limit = pageNum * rp;
		String unitId = request.getParameter("unitId");
		PbsApplyInfoExample ex = new PbsApplyInfoExample();
		ex.setLimit(limit);
		ex.setStart(start);
		ex.enablePagination();
		ex.setOrderByClause("pbs_apply_date desc");
		PbsApplyInfoExample.Criteria cri = ex.createCriteria();
		// 根据部门查询申请列表
		if (!unitId.equals("1")) {
			cri.andPbsApplyUnitIdEqualTo(unitId);
		}
		String state = request.getParameter("state");
		if (state != null) {
			if (state.equals("1")) {
				cri.andPbsApplyStatusEqualTo(state);
			} else if (state.equals("2")) {
				cri.andPbsApplyStatusEqualTo(state);
			}else if (state.equals("3")) {
				cri.andPbsApplyStatusEqualTo(state);
			}else if (state.equals("4")) {				
				List<String> values = new ArrayList<String>();
				values.add("4");
				values.add("6");
				cri.andPbsApplyStatusIn(values);
			}else if(state.equals("5")){
				cri.andPbsApplyStatusEqualTo(state);
			}
		}
		List<PbsApplyInfo> list = pbsApplyInfoService.getPbsApplyInfoDAO().selectByExample(ex);
		int count = pbsApplyInfoService.getPbsApplyInfoDAO().countByExample(ex);
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		int i = 1;
		try {
			if (list.size() > 0) {
				for (PbsApplyInfo info : list) {
					JSONObject json = new JSONObject();
					json.put("num", i++);
					json.put("pbsApplyId", info.getPbsApplyId());
					json.put("userName", info.getPbsApplyUserName());
					json.put("unitName", "NO");
					json.put("pbsApplyDate", DateHandler.dateToString(info.getPbsApplyDate()));
					json.put("pbsApplyGrade",info.getPbsApplyGrade()+"级");
					json.put("pbsApplyUnitName", unitService.findUnit(info.getPbsApplyUnitId()).getUnitName());
					if (unitId.equals("1")) {
						if (info.getPbsApplyStatus().equals("1")) {
							// 未提交
							json.put("state", "未提交");
							json.put("operate",
									"<a href='pbsApplyInfo_select.jsp?pbsApplyUnitId=" + info.getPbsApplyUnitId()
											+ "&pbsApplyUserId=" + info.getPbsApplyUserId() + "&pbsApplyId="
											+ info.getPbsApplyId() + "'>编辑</a>");
							jsonArray.put(json);
						} else if (info.getPbsApplyStatus().equals("2")) {
							// 已提交
							// 没有填写过检测报告
							json.put("state", "待审核");
							json.put("operate",
									"<a href='pbsApplyInfo.jsp?pbsApplyUnitId=" + info.getPbsApplyUnitId()
											+ "&pbsApplyUserId=" + info.getPbsApplyUserId() + "&pbsApplyId="
											+ info.getPbsApplyId() + "'>查看</a>");
							jsonArray.put(json);
						} else if (info.getPbsApplyStatus().equals("3")) {
							json.put("state", "审核未通过");
							json.put("operate","<a href='pbsApplyInfo_select.jsp?pbsApplyUnitId=" + info.getPbsApplyUnitId()
											+ "&pbsApplyUserId=" + info.getPbsApplyUserId() + "&pbsApplyId="
											+ info.getPbsApplyId() + "'>修改 | </a>"
											+"<a href='apply_audit_info.jsp?pbsApplyUnitId=" + info.getPbsApplyUnitId()
											+ "&pbsApplyUserId=" + info.getPbsApplyUserId() + "&pbsApplyId="
											+ info.getPbsApplyId() + "'>查看</a>");
							jsonArray.put(json);
						} else if (info.getPbsApplyStatus().equals("4")) {
							
							json.put("state", "审核通过");
							json.put("operate",
									"<a href='apply_audit_info.jsp?pbsApplyUnitId=" + info.getPbsApplyUnitId()
											+ "&pbsApplyUserId=" + info.getPbsApplyUserId() + "&pbsApplyId="
											+ info.getPbsApplyId() + "'>查看</a>");
							jsonArray.put(json);
						}else if (info.getPbsApplyStatus().equals("6")) {
							
							json.put("state", "审核通过");
							json.put("operate",
									"<a href='apply_audit_info.jsp?pbsApplyUnitId=" + info.getPbsApplyUnitId()
											+ "&pbsApplyUserId=" + info.getPbsApplyUserId() + "&pbsApplyId="
											+ info.getPbsApplyId() + "'>查看</a>");
							jsonArray.put(json);
						}else if (info.getPbsApplyStatus().equals("5")) {
							
							json.put("state", "已检测");
							json.put("operate",
									"<a href='report.jsp?pbsTestReportId=" 
											+ pbsTestReportService.getPbsTestReportIdByApplyId(info.getPbsApplyId()) + "'>查看检测报告</a>");
							jsonArray.put(json);
						} 					
						
					} else {
						if (info.getPbsApplyStatus().equals("2")) {
							json.put("state", "已提交");
							json.put("operate",
									"<a href='pbsApplyInfo.jsp?pbsApplyUnitId=" + info.getPbsApplyUnitId()
											+ "&pbsApplyUserId=" + info.getPbsApplyUserId() + "&pbsApplyId="
											+ info.getPbsApplyId() + "'>查看</a>");
							jsonArray.put(json);
						} else if (info.getPbsApplyStatus().equals("1")) {
							count = count - 1;
						}
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
		return null;
	}

	// 证书

	private File image;
	private String imageFileName;

	public String saveZSPbsPic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String pbsApplyId = request.getParameter("pbsApplyId");
		String picType = "3";
		pbsApplyInfoService.uploadPbsPic(pbsApplyId, picType, image, imageFileName);
		jsonStr = new HashMap<String, Object>();
		jsonStr.put("result", "success");
		return "success";
	}

	public String updateZSPbsPic() {
		jsonStr = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String pbsApplyId = request.getParameter("pbsApplyId");
		String pbsPicType = "3";
		try {
			pbsApplyInfoService.updatePbsPic(pbsApplyId, pbsPicType, image, imageFileName);
			jsonStr.put("result", "success");
		} catch (Exception e) {
			e.printStackTrace();
			jsonStr.put("result", "error");
		}
		return "success";
	}

	public String selZSPbsPic() {
		jsonStr = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String pbsApplyId = request.getParameter("pbsApplyId");
		String pbsPicType = request.getParameter("pbsPicType");
		PbsPicExample example = new PbsPicExample();
		PbsPicExample.Criteria cri = example.createCriteria();
		cri.andPbsApplyIdEqualTo(pbsApplyId);
		cri.andPbsPicTypeEqualTo(pbsPicType);
		try {
			List<PbsPic> picList = pbsApplyInfoService.getPbsPicDAO().selectByExample(example);
			if (picList != null && picList.size() == 1) {
				PbsPic pic = picList.get(0);
				jsonStr.put("enPicUrl", pic.getPbsPicUrl());
				jsonStr.put("result", "success");
			} else {
				jsonStr.put("result", "error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String delZSPbsPic() {
		jsonStr = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String pbsApplyId = request.getParameter("pbsApplyId");
		String pbsPicType = request.getParameter("pbsPicType");
		try {
			pbsApplyInfoService.delPbsPic2(pbsApplyId, pbsPicType);
			jsonStr.put("result", "success");
		} catch (Exception e) {
			e.printStackTrace();
			jsonStr.put("result", "error");
		}
		return "success";
	}
	
	/********ll S*********/
	/**************************审核***********************************/
	
	//初始化申请审核列表，查询所有已经提交的申请信息
	public String selAllApplyInfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int pageNum = Integer.parseInt(request.getParameter("page"));
		int rp = Integer.parseInt(request.getParameter("rp"));
		int start = (pageNum - 1) * rp;
		int limit = pageNum * rp;
		String unitId = request.getParameter("unitId");
		PbsApplyInfoExample ex = new PbsApplyInfoExample();
		ex.setLimit(limit);
		ex.setStart(start);
		ex.enablePagination();
		ex.setOrderByClause("pbs_apply_date desc");
		PbsApplyInfoExample.Criteria cri = ex.createCriteria();
		// 根据部门查询申请列表
		if (!unitId.equals("1")) {
			cri.andPbsApplyUnitIdEqualTo(unitId);
		}
		String state = request.getParameter("state");
		/*if (state != null) {
			if (state.equals("1")) {
				cri.andPbsApplyStatusEqualTo(state);
			} else if (state.equals("2")) {
				cri.andPbsApplyStatusEqualTo(state);
			}
		}*/
		
		if (state != null && !"all".equals(state)) {
			if (state.equals("4")) {
				String[] s = { "4", "6" };
				List<String> str = Arrays.asList(s);
				cri.andPbsApplyStatusIn(str);
			} else {
				cri.andPbsApplyStatusEqualTo(state);
			}
		} else {
			String[] s = { "2", "3", "4", "5", "6" };
			List<String> str = Arrays.asList(s);
			cri.andPbsApplyStatusIn(str);
		}
		
		ApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(request.getSession().getServletContext());
		IunitDao unitDao = (IunitDao) context.getBean("Unit");
		TBaseUnitInfo unit = new TBaseUnitInfo();
		
		List<PbsApplyInfo> list = pbsApplyInfoService.getPbsApplyInfoDAO().selectByExample(ex);
		int count = pbsApplyInfoService.getPbsApplyInfoDAO().countByExample(ex);
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		int i = 1;
		try {
			if (list.size() > 0) {
				for (PbsApplyInfo info : list) {
					JSONObject json = new JSONObject();
					json.put("num", i++);
					json.put("pbsApplyId", info.getPbsApplyId());
					unit = unitDao.findUnit(info.getPbsApplyUnitId());
					json.put("unitName", unit.getUnitName());
					json.put("pbsApplyGrade",info.getPbsApplyGrade()+"级");
					json.put("userName", info.getPbsApplyUserName());
					json.put("pbsApplyDate", DateHandler.dateToString(info.getPbsApplyDate()));
					if (unitId.equals("1")) {
						if (info.getPbsApplyStatus().equals("2")) {
							// 待审核
							json.put("state", "待审核");
							json.put("operate",
									"<a href='apply_audit_add.jsp?pbsApplyUnitId=" + info.getPbsApplyUnitId()
											+ "&pbsApplyUserId=" + info.getPbsApplyUserId() + "&pbsApplyId="
											+ info.getPbsApplyId() + "'>审核</a>");
							jsonArray.put(json);
						} else if (info.getPbsApplyStatus().equals("3")) {						
							json.put("state", "审核未通过");
							json.put("operate",
									"<a href='apply_audit_info.jsp?pbsApplyUnitId=" + info.getPbsApplyUnitId()
									+ "&pbsApplyUserId=" + info.getPbsApplyUserId() + "&pbsApplyId="
									+ info.getPbsApplyId() + "'>查看</a>");
							jsonArray.put(json);
						} else if(info.getPbsApplyStatus().equals("4")){
							json.put("state", "审核已通过");
							json.put("operate",									
								"<a href='report_add.jsp?pbsApplyId=" + info.getPbsApplyId() +"&pbsApplyUnitId=" + info.getPbsApplyUnitId()+ "'>填写检测报告</a>");
							jsonArray.put(json);
						}else if(info.getPbsApplyStatus().equals("6")){
							//审核已通过且填写检测报告未提交
							json.put("state", "审核已通过");
							json.put("operate",									
								"<a href='report_update.jsp?pbsTestReportId=" + pbsTestReportService.getPbsTestReportIdByApplyId(info.getPbsApplyId())+ "'>填写检测报告</a>");
							jsonArray.put(json);
						}else if(info.getPbsApplyStatus().equals("5")){
							json.put("state", "已检测");
							json.put("operate",
									"<a href='report.jsp?pbsTestReportId=" 
											+ pbsTestReportService.getPbsTestReportIdByApplyId(info.getPbsApplyId()) + "'>查看检测报告</a>");
							jsonArray.put(json);
						}
						
					} else {
						if (info.getPbsApplyStatus().equals("2")) {
							json.put("state", "已提交");
							json.put("operate",
									"<a href='pbsApplyInfo.jsp?pbsApplyUnitId=" + info.getPbsApplyUnitId()
											+ "&pbsApplyUserId=" + info.getPbsApplyUserId() + "&pbsApplyId="
											+ info.getPbsApplyId() + "'>查看</a>");
							jsonArray.put(json);
						} else if (info.getPbsApplyStatus().equals("1")) {
							count = count - 1;
						}
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//保存审核信息
	public String savePbsApplyAudit(){
		//保存屏蔽室申请审核信息
		pbsApplyInfoService.insertPbsApplyInfo(pbsApplyAudit);
		
		//同步检测申请的审核状态
		PbsApplyInfo pbsApplyInfo = new PbsApplyInfo();
		pbsApplyInfo.setPbsApplyId(pbsApplyAudit.getPbsApplyId());
		String auditResult = pbsApplyAudit.getAuditResult();
		if ("1".equals(auditResult)) {
			//审核通过
			pbsApplyInfo.setPbsApplyStatus("4");
		} else if ("2".equals(auditResult)) {
			//审核不通过
			pbsApplyInfo.setPbsApplyStatus("3");
		}		
		pbsApplyInfoService.getPbsApplyInfoDAO().updateByPrimaryKeySelective(pbsApplyInfo);
		jsonStr = new HashMap<String, Object>();
		String result = "success";
		jsonStr.put("result", result);
		return "success";
	}
	
	//根据申请ID查看该申请书的审核信息
	public String selEnApplyAudit(){
		String result = "success";
		jsonStr = new HashMap<String, Object>();	
		PbsApplyAuditExample pbsApplyAuditExample = new PbsApplyAuditExample();
		PbsApplyAuditExample.Criteria criteria = pbsApplyAuditExample.createCriteria();
		criteria.andPbsApplyIdEqualTo(pbsApplyId);		
		List<PbsApplyAudit> list = pbsApplyInfoService.getPbsApplyAuditDAO().selectByExample(pbsApplyAuditExample);
		if (list != null && list.size() >= 1) {
			PbsApplyAudit pbsApplyAuditInfo = list.get(0);
			jsonStr.put("auditOppinion", pbsApplyAuditInfo.getAuditOppinon());
			jsonStr.put("auditUser", pbsApplyAuditInfo.getAuditUser());
			jsonStr.put("auditResult", pbsApplyAuditInfo.getAuditResult());
			jsonStr.put("auditDate", DateHandler.dateToString(pbsApplyAuditInfo.getAuditDate()));
		}
		jsonStr.put("result",result);
		return "success";		
	}
	
	/********ll E*********/
	
	public PbsApplyInfo getPbsApplyInfo() {
		return pbsApplyInfo;
	}

	public void setPbsApplyInfo(PbsApplyInfo pbsApplyInfo) {
		this.pbsApplyInfo = pbsApplyInfo;
	}

	public PbsApplyInfoService getPbsApplyInfoService() {
		return pbsApplyInfoService;
	}

	public void setPbsApplyInfoService(PbsApplyInfoService pbsApplyInfoService) {
		this.pbsApplyInfoService = pbsApplyInfoService;
	}

	public PbsAttach getPbsAttach() {
		return pbsAttach;
	}

	public void setPbsAttach(PbsAttach pbsAttach) {
		this.pbsAttach = pbsAttach;
	}

	public File getPbsApplyInfoAttach() {
		return pbsApplyInfoAttach;
	}

	public void setPbsApplyInfoAttach(File pbsApplyInfoAttach) {
		this.pbsApplyInfoAttach = pbsApplyInfoAttach;
	}

	public String getPbsApplyInfoAttachFileName() {
		return pbsApplyInfoAttachFileName;
	}

	public void setPbsApplyInfoAttachFileName(String pbsApplyInfoAttachFileName) {
		this.pbsApplyInfoAttachFileName = pbsApplyInfoAttachFileName;
	}

	public PbsTestReportService getPbsTestReportService() {
		return pbsTestReportService;
	}

	public void setPbsTestReportService(PbsTestReportService pbsTestReportService) {
		this.pbsTestReportService = pbsTestReportService;
	}

	public Map<String, Object> getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(Map<String, Object> jsonStr) {
		this.jsonStr = jsonStr;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public File getPbsApplyImage() {
		return pbsApplyImage;
	}

	public void setPbsApplyImage(File pbsApplyImage) {
		this.pbsApplyImage = pbsApplyImage;
	}

	public String getPbsApplyImageFileName() {
		return pbsApplyImageFileName;
	}

	public void setPbsApplyImageFileName(String pbsApplyImageFileName) {
		this.pbsApplyImageFileName = pbsApplyImageFileName;
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

	public PbsApplyAudit getPbsApplyAudit() {
		return pbsApplyAudit;
	}

	public void setPbsApplyAudit(PbsApplyAudit pbsApplyAudit) {
		this.pbsApplyAudit = pbsApplyAudit;
	}

	public String getPbsApplyId() {
		return pbsApplyId;
	}

	public void setPbsApplyId(String pbsApplyId) {
		this.pbsApplyId = pbsApplyId;
	}

	public UnitService getUnitService() {
		return unitService;
	}

	public void setUnitService(UnitService unitService) {
		this.unitService = unitService;
	}

	
	

}
