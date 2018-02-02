package com.tyust.web.action.pbs;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tyust.bean.pbs.PbsBaseInfo;
import com.tyust.bean.pbs.PbsBaseInfoExample;
import com.tyust.bean.pbs.PbsBuilder;
import com.tyust.bean.pbs.PbsDevice;
import com.tyust.bean.pbs.PbsDeviceExample;
import com.tyust.common.OpertionType;
import com.tyust.common.SaveLog;
import com.tyust.common.UtilTools;
import com.tyust.service.pbs.PbsInfoService;

public class PbsInfoAction {
	private PbsInfoService pbsInfoService;
	private PbsBaseInfo pbsBaseInfo;
	private PbsBuilder pbsBuilder;
	private PbsDevice pbsDevice;
	
	private File zzzsFile;
	private File yyzzFile;
	private String zzzsFileFileName;
	private String yyzzFileFileName;
	
	private File pmPic;
	private String pmPicFileName;
	
	public File getPmPic() {
		return pmPic;
	}

	public void setPmPic(File pmPic) {
		this.pmPic = pmPic;
	}

	public String getPmPicFileName() {
		return pmPicFileName;
	}

	public void setPmPicFileName(String pmPicFileName) {
		this.pmPicFileName = pmPicFileName;
	}

	public PbsDevice getPbsDevice() {
		return pbsDevice;
	}

	public void setPbsDevice(PbsDevice pbsDevice) {
		this.pbsDevice = pbsDevice;
	}

	public PbsBuilder getPbsBuilder() {
		return pbsBuilder;
	}

	public void setPbsBuilder(PbsBuilder pbsBuilder) {
		this.pbsBuilder = pbsBuilder;
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

	public PbsBaseInfo getPbsBaseInfo() {
		return pbsBaseInfo;
	}

	public void setPbsBaseInfo(PbsBaseInfo pbsBaseInfo) {
		this.pbsBaseInfo = pbsBaseInfo;
	}

	public PbsInfoService getPbsInfoService() {
		return pbsInfoService;
	}

	public void setPbsInfoService(PbsInfoService pbsInfoService) {
		this.pbsInfoService = pbsInfoService;
	}
	
	public String selPbsList()throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String unitId = request.getParameter("unitId");
		PbsBaseInfoExample ex = new PbsBaseInfoExample();
		ex.createCriteria().andPbsUnitIdEqualTo(unitId);
		List<PbsBaseInfo> list = pbsInfoService.getPbsBaseInfoDAO().selectByExample(ex);
		int count = pbsInfoService.getPbsBaseInfoDAO().countByExample(ex);
		
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		PbsBaseInfo info = new PbsBaseInfo();
		int i = 1;
		try {
			if(list.size()>0){
				for (PbsBaseInfo pbsInfo:list) {
					JSONObject json = new JSONObject();
					info = pbsInfo;
					json.put("num", i++);
					json.put("PbsName", info.getPbsName());
					json.put("PbsAddress", info.getPbsAddress());
					json.put("PbsId", info.getPbsId());
					json.put("DoorNums", info.getDoorNums());
					json.put("DeviceNum", "<a href='pbs_device_list.jsp?pbsId="+info.getPbsId()+"'>"+info.getDeviceNum()+"</a>");
					json.put("Model", info.getModel());
					if(UtilTools.isNull(info.getBuilderUnitId())){
						json.put("Builder", "<a href='pbs_builder_add.jsp?pbsId="+info.getPbsId()+"'>未填写</a>");
					}else{
						json.put("Builder", "<a href='pbs_builder_upd.jsp?id="+info.getBuilderUnitId()+"'>"+info.getRemark()+"</a>");
					}
					json.put("operate", "<a href='pbs_info_upd.jsp?pbsId="+info.getPbsId()+"'>修改</a> | "+
										"<a href='test_apply_add.jsp?pbsId="+info.getPbsId()+"&unitId="+info.getPbsUnitId()+"&pbsBuilderId="+info.getBuilderUnitId()+"'>申请检测</a>"
							);
					jsonArray.put(json);
				}
			}	
			jsonObject.put("rows", jsonArray);
			//jsonObject.put("page", pageNum);
			jsonObject.put("total", count);
			ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
			return null;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String savePbsInfo() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		String operate = request.getParameter("operate");
		int res = 0;
		try {
			res =  pbsInfoService.savePbsInfo(pbsBaseInfo, operate,pmPic,pmPicFileName);
		} catch (Exception e) {
			e.printStackTrace();
			SaveLog.saveLog(request, "屏蔽室信息",OpertionType.State.ADD , "操作异常");
			out.println("<script>alert('操作异常！');</script>");
			return null;
		}
		if(res==1){
			SaveLog.saveLog(request, "屏蔽室信息",OpertionType.State.ADD , "新增成功");
			out.println("<script>alert('新增成功！');window.location='admin/pbs/pbs_list.jsp'</script>");
			return null;
		}else if(res==2){
			SaveLog.saveLog(request, "屏蔽室信息",OpertionType.State.UPDATE , "修改成功");
			out.println("<script>alert('修改成功！');window.location='admin/pbs/pbs_list.jsp'</script>");
			return null;
		}else{
			out.println("<script>alert('保存失败！');</script>");
			return null;
		}
	}
	
	public String selPbsInfo() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String pbsId = request.getParameter("pbsId");
		PbsBaseInfo info = pbsInfoService.getPbsBaseInfoDAO().selectByPrimaryKey(pbsId);
		JSONObject json = new JSONObject();
		if(info!=null){
			json.put("completionInfo", info.getCompletionInfo());
			json.put("doorModel", info.getDoorModel());
			json.put("doorNums", info.getDoorNums());
			json.put("groundResistance", info.getGroundResistance());
			json.put("insulationResistance", info.getInsulationResistance());
			json.put("maintenanceInfo", info.getMaintenanceInfo());
			json.put("pbsName", info.getPbsName());
			json.put("pbsAddress", info.getPbsAddress());
			json.put("model", info.getModel());
			json.put("usage", info.getUsage());
			json.put("telcomCableCrossWall", info.getTelcomCableCrossWall());
			json.put("pbsSize", info.getPbsSize());
			if(!UtilTools.isNull(info.getPmPic())){
				json.put("pmPic", info.getPmPic());
			}else{
				json.put("pmPic", "0");
			}
		}
		ServletActionContext.getResponse().getWriter().write(json.toString());
		return null;
	}
	
	public String saveBuilderUnit() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		String operate = request.getParameter("operate");
		int res = 0;
		try {
			pbsBuilder.setZzzsUrl(zzzsFileFileName);
			pbsBuilder.setYyzzUrl(yyzzFileFileName);
			res =  pbsInfoService.savePbsBuilder(pbsBuilder, operate,zzzsFile,yyzzFile);
		} catch (Exception e) {
			e.printStackTrace();
			SaveLog.saveLog(request, "屏蔽室信息",OpertionType.State.ADD , "操作异常");
			out.println("<script>alert('操作异常！');</script>");
			return null;
		}
		if(res==1){
			SaveLog.saveLog(request, "屏蔽室信息",OpertionType.State.ADD , "新增承建单位成功");
			out.println("<script>alert('保存成功！');window.location='admin/pbs/pbs_list.jsp'</script>");
			return null;
		}else if(res==2){
			SaveLog.saveLog(request, "屏蔽室信息",OpertionType.State.UPDATE , "修改承建单位成功");
			out.println("<script>alert('保存成功！');window.location='admin/pbs/pbs_list.jsp'</script>");
			return null;
		}else{
			out.println("<script>alert('保存失败！');</script>");
			return null;
		}
	}
	
	public String selBuilderUnit() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String id = request.getParameter("id");
		PbsBuilder info = pbsInfoService.getPbsBuilderDAO().selectByPrimaryKey(id);
		JSONObject json = new JSONObject();
		if(info!=null){
			json.put("unitName", info.getUnitName());
			json.put("unitAddress", info.getUnitAddress());
			json.put("unitTel", info.getUnitTel());
			json.put("businessScope", info.getBusinessScope());
			json.put("postCode", info.getPostCode());
			json.put("unitType", info.getUnitType());
			json.put("unitEmail", info.getUnitEmail());
			json.put("legalPerson", info.getLegalPerson());
			json.put("lpPosition", info.getLpPosition());
			json.put("lpTelphone", info.getLpTelphone());
			json.put("lpTax", info.getLpTax());
			json.put("lpEmail", info.getLpEmail());
			json.put("zzzsUrl", info.getZzzsUrl()==null?"":info.getZzzsUrl());
			json.put("yyzzUrl", info.getYyzzUrl()==null?"":info.getYyzzUrl());
			json.put("builderIntro", info.getBuilderIntro());
			json.put("researchAbility", info.getResearchAbility());
			json.put("qualityManage", info.getQualityManage());
			json.put("afterService", info.getAfterService());
			json.put("employeeManage", info.getEmployeeManage());
		}
		ServletActionContext.getResponse().getWriter().write(json.toString());
		return null;
	}
	
	public String selPbsDveList() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		int pageNum = Integer.parseInt(request.getParameter("page"));
		int rp = Integer.parseInt(request.getParameter("rp"));
		int start = (pageNum - 1) * rp;
		int limit = pageNum * rp;
		String pbsId = request.getParameter("pbsId");
		String dName = request.getParameter("dName");
		String dType = request.getParameter("dType");
		
		PbsDeviceExample ex = new PbsDeviceExample();
		ex.setLimit(limit);
		ex.setStart(start);
		ex.enablePagination();
		PbsDeviceExample.Criteria cri = ex.createCriteria();
		cri.andPbsIdEqualTo(pbsId);
		if(!UtilTools.isNull(dName)){
			cri.andDveNameLike("%"+dName+"%");
		}
		if(!"all".equals(dType)){
			cri.andDevTypeEqualTo(dType);
		}
		List<PbsDevice> list = pbsInfoService.getPbsDeviceDAO().selectByExample(ex);
		int total = pbsInfoService.getPbsDeviceDAO().countByExample(ex);
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		PbsDevice info = new PbsDevice();
		try {
			if(list.size()>0){
				for (int i = 0; i < list.size(); i++) {
					JSONObject json = new JSONObject();
					info = (PbsDevice)list.get(i);
					json.put("number", i+1);
					json.put("Id", info.getId());
					json.put("DveName", info.getDveName());
					json.put("DevType", info.getDevType());
					if("1".equals(info.getDevType())){
						json.put("DevTypeName","电磁滤波器");
					}
					if("2".equals(info.getDevType())){
						json.put("DevTypeName","电话滤波器");
					}
					if("3".equals(info.getDevType())){
						json.put("DevTypeName","信号滤波器");
					}
					if("4".equals(info.getDevType())){
						json.put("DevTypeName","通风波导窗");
					}
					if("5".equals(info.getDevType())){
						json.put("DevTypeName","空调设备");
					}
					if("6".equals(info.getDevType())){
						json.put("DevTypeName","消防设备");
					}
					if("7".equals(info.getDevType())){
						json.put("DevTypeName","光纤");
					}
					json.put("DevModel", info.getDevModel());
					json.put("DevFactory", info.getDevFactory());
					json.put("Band", info.getBand());
					json.put("HasMetalFirmware", info.getHasMetalFirmware());
					json.put("InsertionLoss", info.getInsertionLoss());
					json.put("KtbdgNum", info.getKtbdgNum());
					json.put("PbEfficiency", info.getPbEfficiency());
					json.put("Remark1", info.getRemark1());
					json.put("Remark2", info.getRemark2());
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
	
	public String savePbsDve(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String operate = request.getParameter("operate");
		String flagId = request.getParameter("flagId");
		int res = 0;
		try {
			res =  pbsInfoService.savePbsDve(pbsDevice, operate,flagId );
		} catch (Exception e) {
			e.printStackTrace();
			SaveLog.saveLog(request, "屏蔽室信息",OpertionType.State.ADD , "操作异常");
			request.setAttribute("message", "操作异常");
			return "input";
		}
		if(res==1){
			SaveLog.saveLog(request, "屏蔽室信息",OpertionType.State.ADD , "新增设备成功");
			request.setAttribute("message", "保存成功");
			return "success";
		}else if(res==2){
			SaveLog.saveLog(request, "屏蔽室信息",OpertionType.State.UPDATE , "修改设备成功");
			request.setAttribute("message", "保存成功");
			return "success";
		}else{
			request.setAttribute("message", "保存失败");
			return "input";
		}
	}
	
	public String delPbsDve(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String dveIds = request.getParameter("dveIds");
		String pbsId = request.getParameter("pbsId");
		int res = 0;
		try {
			res =  pbsInfoService.deletePbsDve(dveIds,pbsId);
		} catch (Exception e) {
			e.printStackTrace();
			SaveLog.saveLog(request, "屏蔽室信息",OpertionType.State.DELETE , "删除设备异常");
			request.setAttribute("message", "操作异常");
			return "input";
		}
		if(res>0){
			SaveLog.saveLog(request, "屏蔽室信息",OpertionType.State.DELETE , "删除设备成功");
			request.setAttribute("message", "删除成功");
			return "success";
		}else{
			request.setAttribute("message", "删除失败");
			return "input";
		}
	}
	
	public String showPbsDve() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String pbsId = request.getParameter("pbsId");
		
		PbsDeviceExample ex = new PbsDeviceExample();
		PbsDeviceExample.Criteria cri = ex.createCriteria();
		cri.andPbsIdEqualTo(pbsId);
		List<PbsDevice> list = pbsInfoService.getPbsDeviceDAO().selectByExample(ex);
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		PbsDevice info = new PbsDevice();
		try {
			if(list.size()>0){
				for (int i = 0; i < list.size(); i++) {
					JSONObject json = new JSONObject();
					info = (PbsDevice)list.get(i);
					json.put("number", i+1);
					json.put("Id", info.getId());
					json.put("DveName", info.getDveName());
					json.put("DevType", info.getDevType());
					json.put("DevModel", info.getDevModel());
					json.put("DevFactory", info.getDevFactory());
					json.put("Band", info.getBand());
					json.put("HasMetalFirmware", info.getHasMetalFirmware());
					json.put("InsertionLoss", info.getInsertionLoss());
					json.put("KtbdgNum", info.getKtbdgNum());
					json.put("PbEfficiency", info.getPbEfficiency());
					json.put("Remark1", info.getRemark1());
					json.put("Remark2", info.getRemark2());
					jsonArray.put(json);
				}
			}
			jsonObject.put("data", jsonArray);
			ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
			return null;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
}
