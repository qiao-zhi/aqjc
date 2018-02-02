package com.tyust.web.action.pbs;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tyust.bean.pbs.PbsApplyAudit;
import com.tyust.bean.pbs.PbsTestApply;
import com.tyust.bean.pbs.PbsTestApplyExample;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.common.DateHandler;
import com.tyust.common.OpertionType;
import com.tyust.common.SaveLog;
import com.tyust.common.UtilTools;
import com.tyust.service.pbs.PbsTestApplyService;

public class PbsTestApplyAction {
	private PbsTestApplyService pbsTestApplyService;
	private PbsTestApply pbsTestApply;
	
	private File zzzsFile;
	private File yyzzFile;
	private String zzzsFileFileName;
	private String yyzzFileFileName;
	
	public PbsTestApply getPbsTestApply() {
		return pbsTestApply;
	}

	public void setPbsTestApply(PbsTestApply pbsTestApply) {
		this.pbsTestApply = pbsTestApply;
	}

	public PbsTestApplyService getPbsTestApplyService() {
		return pbsTestApplyService;
	}

	public void setPbsTestApplyService(PbsTestApplyService pbsTestApplyService) {
		this.pbsTestApplyService = pbsTestApplyService;
	}

	public File getZzzsFile() {
		return zzzsFile;
	}

	public void setZzzsFile(File zzzsFile) {
		this.zzzsFile = zzzsFile;
	}

	public File getYyzzFile() {
		return yyzzFile;
	}

	public void setYyzzFile(File yyzzFile) {
		this.yyzzFile = yyzzFile;
	}

	public String getZzzsFileFileName() {
		return zzzsFileFileName;
	}

	public void setZzzsFileFileName(String zzzsFileFileName) {
		this.zzzsFileFileName = zzzsFileFileName;
	}

	public String getYyzzFileFileName() {
		return yyzzFileFileName;
	}

	public void setYyzzFileFileName(String yyzzFileFileName) {
		this.yyzzFileFileName = yyzzFileFileName;
	}
	
	public String selListByUnit()throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		int pageNum = Integer.parseInt(request.getParameter("page"));
		int rp = Integer.parseInt(request.getParameter("rp"));
		int start = (pageNum - 1) * rp;
		int limit = pageNum * rp;
		String unitId = request.getParameter("unitId");
		String state = request.getParameter("state");
		PbsTestApplyExample ex = new PbsTestApplyExample();
		ex.setLimit(limit);
		ex.setStart(start);
		ex.enablePagination();
		PbsTestApplyExample.Criteria cri = ex.createCriteria();
		cri.andApplyUnitEqualTo(unitId);
		if(!"all".equals(state)){
			cri.andApplyStateEqualTo(state);
		}
		List<PbsTestApply> list = pbsTestApplyService.getPbsTestApplyDAO().selectByExample(ex);
		int count = pbsTestApplyService.getPbsTestApplyDAO().countByExample(ex);
		
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		PbsTestApply info = new PbsTestApply();
		int i = 1;
		try {
			if(list.size()>0){
				for (PbsTestApply appInfo:list) {
					JSONObject json = new JSONObject();
					info = appInfo;
					json.put("num", i++);
					json.put("TestApplyId", info.getTestApplyId());
					json.put("User", info.getRemark1());
					json.put("Apply_Date", DateHandler.dateToString(info.getApplyDate()));
					if(info.getApplyTestGrade().equals("1")){
						json.put("ApplyTestGrade", "A级");
					}
					if(info.getApplyTestGrade().equals("2")){
						json.put("ApplyTestGrade", "B级");
					}
					if(info.getApplyTestGrade().equals("3")){
						json.put("ApplyTestGrade", "C级");
					}
					json.put("ApplyTestType", info.getApplyTestType().equals("1")?"初检":"复检");
					json.put("PbsName", info.getRemark2());
					json.put("State", "");
					json.put("operate","<a href='report_add.jsp'>填写检测报告</a> | "+
							"<a href='apply_select.jsp'>查看</a>");

//					if("1".equals(info.getApplyState())){
//						json.put("State", "待提交");
//						json.put("operate","<a href='test_apply_upd.jsp?applyId="+info.getTestApplyId()+"&pbsId="+info.getPbsId()+"&pbsBuilderId="+info.getPbsBuilderId()+"'>修改</a>");
//					}
//					if("2".equals(info.getApplyState())){
//						json.put("State", "待审核");
//						json.put("operate","<a href='test_apply_info.jsp?applyId="+info.getTestApplyId()+"&pbsId="+info.getPbsId()+"&pbsBuilderId="+info.getPbsBuilderId()+"'>查看</a>");
//					}
//					if("3".equals(info.getApplyState())){
//						json.put("State", "审核未通过");
//						json.put("operate","<a href='test_apply_upd.jsp?applyId="+info.getTestApplyId()+"&pbsId="+info.getPbsId()+"&pbsBuilderId="+info.getPbsBuilderId()+"'>修改</a> | "+
//								"<a href='apply_audit_info.jsp?applyId="+info.getTestApplyId()+"&pbsId="+info.getPbsId()+"&pbsBuilderId="+info.getPbsBuilderId()+"&unitId="+info.getApplyUnit()+"'>查看</a>");
//					}
//					if("4".equals(info.getApplyState())){
//						json.put("State", "审核通过");
//						json.put("operate","<a href='apply_audit_info.jsp?applyId="+info.getTestApplyId()+"&pbsId="+info.getPbsId()+"&pbsBuilderId="+info.getPbsBuilderId()+"&unitId="+info.getApplyUnit()+"'>查看</a>");
//					}
//					if("5".equals(info.getApplyState())){
//						json.put("State", "检测完成");
//						//json.put("operate","<a href='test_report_info.jsp?applyId="+info.getTestApplyId()+"&unitId="+info.getApplyUnit()+"&testRptId="+info.getRemark2()+"'>查看检测报告</a>");
//					}
					jsonArray.put(json);
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
	
	
	public String selSubList() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		int pageNum = Integer.parseInt(request.getParameter("page"));
		int rp = Integer.parseInt(request.getParameter("rp"));
		int start = (pageNum - 1) * rp;
		int limit = pageNum * rp;
		String state = request.getParameter("state");
		
		PbsTestApplyExample ex = new PbsTestApplyExample();
		ex.setLimit(limit);
		ex.setStart(start);
		ex.enablePagination();
		PbsTestApplyExample.Criteria cri = ex.createCriteria();
		if("all".equals(state)){
			cri.andApplyStateNotEqualTo("1");
		}else{
			cri.andApplyStateEqualTo(state);
		}
		List<PbsTestApply> list = pbsTestApplyService.getPbsTestApplyDAO().selSubList(ex);
		int count = pbsTestApplyService.getPbsTestApplyDAO().countByExample(ex);
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		PbsTestApply info = new PbsTestApply();
		try {
			if(list.size()>0){
				for (int i = 0; i < list.size(); i++) {
					JSONObject json = new JSONObject();
					info = (PbsTestApply)list.get(i);
					json.put("num", i+1);
					json.put("Id", info);
					json.put("Unit", info.getRemark1());
					json.put("Apply_Date", DateHandler.dateToString(info.getApplyDate()));
					json.put("PbsName", info.getRemark2());	
					if(info.getApplyTestGrade().equals("1")){
						json.put("ApplyTestGrade", "A级");
					}
					if(info.getApplyTestGrade().equals("2")){
						json.put("ApplyTestGrade", "B级");
					}
					if(info.getApplyTestGrade().equals("3")){
						json.put("ApplyTestGrade", "C级");
					}
					json.put("ApplyTestType", info.getApplyTestType().equals("1")?"初检":"复检");
					if("2".equals(info.getApplyState())){
						json.put("State", "待审核");
						json.put("operate","<a href='test_apply_audit.jsp?applyId="+info.getTestApplyId()+"&pbsId="+info.getPbsId()+"&pbsBuilderId="+info.getPbsBuilderId()+"&unitId="+info.getApplyUnit()+"'>审核</a>");
					}
					if("3".equals(info.getApplyState())){
						json.put("State", "审核未通过");
						json.put("operate","<a href='apply_audit_info.jsp?applyId="+info.getTestApplyId()+"&pbsId="+info.getPbsId()+"&pbsBuilderId="+info.getPbsBuilderId()+"&unitId="+info.getApplyUnit()+"'>查看</a>");
					}
					if("4".equals(info.getApplyState())){
						json.put("State", "审核通过");
						json.put("operate","<a href='test_rpt_add.jsp?applyId="+info.getTestApplyId()+"&pbsId="+info.getPbsId()+"&pbsBuilderId="+info.getPbsBuilderId()+"'>填写检测报告</a>");
					}
					if("5".equals(info.getApplyState())){
						json.put("State", "检测完成");
						//json.put("operate","<a href='test_report_info.jsp?applyId="+info.getTestApplyId()+"&unitId="+info.getApplyUnit()+"&testRptId="+info.getRemark2()+"'>查看检测报告</a>");
					}
					jsonArray.put(json);
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
	
	public String addApply() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		String operate = request.getParameter("operate");
		pbsTestApply.setTestApplyId(UUID.randomUUID().toString());
		pbsTestApply.setApplyDate(new Date());
		TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
		pbsTestApply.setApplyUser(user.getUserId());
		pbsTestApply.setApplyUnit(user.getUnitId());
		String msg = "";
		if("save".equals(operate)){
			pbsTestApply.setApplyState("1");
			msg="保存";
		}
		if("sub".equals(operate)){
			pbsTestApply.setApplyState("2");
			msg="提交";
		}
		int res = 0;
		try {
			res =  pbsTestApplyService.addApply(pbsTestApply);
		} catch (Exception e) {
			e.printStackTrace();
			SaveLog.saveLog(request, "屏蔽室检测申请",OpertionType.State.ADD , "操作异常");
			out.println("<script>alert('操作异常！');</script>");
			return null;
		}
		if(res==1){
			SaveLog.saveLog(request, "屏蔽室检测申请",OpertionType.State.ADD , "新增成功");
			out.println("<script>alert('"+msg+"成功！');window.location='admin/pbs/apply_list.jsp'</script>");
			return null;
		}else{
			out.println("<script>alert('操作失败！');</script>");
			return null;
		}
	}
	
	public String updApply() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		String operate = request.getParameter("operate");
		String msg = "";
		if("save".equals(operate)){
			pbsTestApply.setApplyState("1");
			msg="保存";
		}
		if("sub".equals(operate)){
			pbsTestApply.setApplyState("2");
			msg="提交";
		}
		int res = 0;
		try {
			res =  pbsTestApplyService.getPbsTestApplyDAO().updateByPrimaryKeySelective(pbsTestApply);
		} catch (Exception e) {
			e.printStackTrace();
			SaveLog.saveLog(request, "屏蔽室检测申请",OpertionType.State.ADD , "操作异常");
			out.println("<script>alert('操作异常！');</script>");
			return null;
		}
		if(res>0){
			SaveLog.saveLog(request, "屏蔽室检测申请",OpertionType.State.UPDATE , "修改成功");
			out.println("<script>alert('"+msg+"成功！');window.location='admin/pbs/apply_list.jsp'</script>");
			return null;
		}else{
			out.println("<script>alert('操作失败！');</script>");
			return null;
		}
	}
	
	public String auditApply() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		String auditRes = request.getParameter("auditRes");
		String applyId = request.getParameter("applyId");
		String auditOpinion = request.getParameter("auditOpinion");
		TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
		PbsApplyAudit aud = new PbsApplyAudit();
		aud.setAuditDate(new Date());
		aud.setAuditId(UUID.randomUUID().toString());
		aud.setAuditOppinon(auditOpinion);
		aud.setAuditResult(auditRes);
		aud.setAuditUser(user.getUserId());
		aud.setPbsApplyId(applyId);
		
		PbsTestApply app = new PbsTestApply();
		app.setTestApplyId(applyId);
		if("0".equals(auditRes)){
			app.setApplyState("3");
		}
		if("1".equals(auditRes)){
			app.setApplyState("4");
		}
		int res = 0;
		try {
			res =  pbsTestApplyService.manageApply(app, aud);
		} catch (Exception e) {
			e.printStackTrace();
			SaveLog.saveLog(request, "屏蔽室检测申请审核",OpertionType.State.ADD , "操作异常");
			//out.println("<script>alert('操作异常！');</script>");
			request.setAttribute("message", "操作异常");
			return "input";
		}
		if(res==10){
			SaveLog.saveLog(request, "屏蔽室检测申请审核",OpertionType.State.UPDATE , "修改成功");
			//out.println("<script>alert('审核成功！');window.location='admin/pbs/apply_audit_list.jsp'</script>");
			request.setAttribute("message", "审核成功");
			return "success";
		}else{
			//out.println("<script>alert('操作失败！');</script>");
			request.setAttribute("message", "审核失败");
			return "input";
		}
	}
	
	public String selAppInfo() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String appId = request.getParameter("appId");
		PbsTestApply info = pbsTestApplyService.getPbsTestApplyDAO().selectByPrimaryKey(appId);
		JSONObject json = new JSONObject();
		if(info!=null){
			json.put("TestApplyId", info.getTestApplyId());
			json.put("ApplyTestGrade", info.getApplyTestGrade());
			json.put("ApplyTestType", info.getApplyTestType());
			if(info.getApplyTestGrade().equals("1")){
				json.put("ApplyTestGradeNm", "A级");
			}
			if(info.getApplyTestGrade().equals("2")){
				json.put("ApplyTestGradeNm", "B级");
			}
			if(info.getApplyTestGrade().equals("3")){
				json.put("ApplyTestGradeNm", "C级");
			}
			json.put("ApplyTestTypeNm", info.getApplyTestType().equals("1")?"初检":"复检");
		}
		ServletActionContext.getResponse().getWriter().write(json.toString());
		return null;
	}
	
	public String selAuditInfo() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String appId = request.getParameter("appId");
		PbsApplyAudit info = pbsTestApplyService.getPbsApplyAuditDAO().selNewAuditInfo(appId);
		JSONObject json = new JSONObject();
		json.put("AuditId", info.getAuditId());
		json.put("AuditDate", DateHandler.dateToString(info.getAuditDate()));
		json.put("AuditOppinion", info.getAuditOppinon());
		json.put("AuditResult", info.getAuditResult().equals("0")?"未通过":"已通过");
		json.put("user", info.getRemark1());
		ServletActionContext.getResponse().getWriter().write(json.toString());
		return null;
	}
}
