package com.tyust.web.action.device;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tyust.bean.app.DeviceBaseInfo;
import com.tyust.bean.app.TestReportPic;
import com.tyust.bean.app.TestReportPicExample;
import com.tyust.bean.device.DeviceTestReport;
import com.tyust.bean.device.DeviceTestReportExample;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.common.DateHandler;
import com.tyust.common.OpertionType;
import com.tyust.common.SaveLog;
import com.tyust.service.app.TestService;
import com.tyust.service.device.DveTestApplyService;
import com.tyust.service.device.DveTestReportService;

public class DveTestReportAction {
	private DveTestReportService dveTestReportService;
	private DveTestApplyService dveTestApplyService;
	
	private TestService testService;
	
	private File[] testPic;
	private String[] testPicFileName;
	
	private File[] pinpuPic;
	private String[] pinpuPicFileName;
	
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

	public File[] getPinpuPic() {
		return pinpuPic;
	}

	public void setPinpuPic(File[] pinpuPic) {
		this.pinpuPic = pinpuPic;
	}

	public String[] getPinpuPicFileName() {
		return pinpuPicFileName;
	}

	public void setPinpuPicFileName(String[] pinpuPicFileName) {
		this.pinpuPicFileName = pinpuPicFileName;
	}

	public DveTestApplyService getDveTestApplyService() {
		return dveTestApplyService;
	}

	public void setDveTestApplyService(DveTestApplyService dveTestApplyService) {
		this.dveTestApplyService = dveTestApplyService;
	}

	public DveTestReportService getDveTestReportService() {
		return dveTestReportService;
	}

	public void setDveTestReportService(DveTestReportService dveTestReportService) {
		this.dveTestReportService = dveTestReportService;
	}

	//生成检测报告编号
	public String showReportCode() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String unitSx = request.getParameter("unitSx").toUpperCase();
		String dveCount = request.getParameter("dveCount");
		Date dt = new Date();
		String rptYear = DateHandler.dateToString(dt,"yyyy");
		String code = dveTestReportService.getDeviceTestReportDAO().selMaxCode(rptYear);
		int codeSerial;
		System.out.println("数据库中最大的编号"+code);
		if(code==null){
			codeSerial = 1;
			System.out.println("数据库无最大编号");
		}
		else{
			
			codeSerial = Integer.parseInt(code)+1;
		}
		String format = "%s%s%02d%s%04d";
		String rptCode = String.format(format, "SXJYAJ",rptYear,Integer.parseInt(dveCount),unitSx,codeSerial);
		System.out.println("生产的报告编号"+rptCode);
		JSONObject json = new JSONObject();
		json.put("rptCode", rptCode);
		ServletActionContext.getResponse().getWriter().write(json.toString());
		return null;
	}
	
	//新增检测报告
	public String addTestReport() throws Exception{
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		//1、获取请求参数
		HttpServletRequest request=ServletActionContext.getRequest();
		String selectedInsId = request.getParameter("selectedInsId");
		String operate = request.getParameter("operate");
		String testResult = request.getParameter("testResult");
		String sampleState = request.getParameter("sampleState");
		String testCode = request.getParameter("testCode");
		String testDate = request.getParameter("testDate");
		String sampleName= request.getParameter("sampleName");
		String applyId= request.getParameter("applyId");
		String wtUnit= request.getParameter("wtUnit");
		
		String testDeviceId = request.getParameter("testDeviceId");
		String testDeviceLabel = request.getParameter("testDeviceLabel");
		String [] deviceId = testDeviceId.trim().split(",");
		String [] deviceLabel = testDeviceLabel.trim().split(",");
		
		for(int i = 0; i < deviceLabel.length; i++){
			System.out.println(i+" :"+deviceLabel[i]);
		}
		TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
		DeviceTestReport dveReport = new DeviceTestReport();
		//2、设置需要保存的检测报告信息
		dveReport.setApplyId(applyId);
		dveReport.setSampleName(sampleName);
		dveReport.setTestCode(testCode);
		String str = "";
		if("save".equals(operate)){
			dveReport.setState("1");
			str="保存";
		}
		if("sub".equals(operate)){
			dveReport.setState("2");
			str="提交";
		}
		//获取用户输入的图片名称
		String [] testPicName1 = request.getParameterValues("testPicName1");
		String [] pintuPicName1 = request.getParameterValues("pintuPicName1");
		
		dveReport.setTestDate(DateHandler.changeStringToDate(testDate));
		dveReport.setTestResult(testResult);
		dveReport.setTestUser(user.getUserId());
		dveReport.setRemark1(wtUnit);
		dveReport.setRemark2(sampleState);
		
		int res = 0;
		try{
			//3、更新设备标签信息
			//2017-5-23修改：设备标签的值不一定都为空
			for(int i = 0;i<deviceLabel.length; i++){
				String devLabel = deviceLabel[i];
				if(devLabel != ""){
					DeviceBaseInfo record = new DeviceBaseInfo();
					record.setDeviceId(deviceId[i]);
					record.setDeviceLabel(deviceLabel[i]);
					testService.getDeviceBaseInfoDAO().updateByPrimaryKeySelective(record);
				}
			}
			//4、保存检测报告信息
			res = dveTestReportService.addTestReport(dveReport, selectedInsId, testPic, testPicFileName, pinpuPic, pinpuPicFileName,testPicName1,pintuPicName1);
		}catch (Exception e){
			e.printStackTrace();
			SaveLog.saveLog(request, "检测报告",OpertionType.State.ADD , "操作异常");
			out.println("<script>alert('操作异常！');</script>");
			//request.setAttribute("message", "操作异常");
			return null;
		}
		//5、写日志，返回跳转的页面；
		if(res==10){
			SaveLog.saveLog(request, "检测报告",OpertionType.State.ADD , "新增成功");
			out.println("<script>alert('"+str+"成功！');window.location='admin/device/apply_audit_list.jsp'</script>");
			//request.setAttribute("message", "上传成功");
			//request.setAttribute("message", str+"成功");
			return null;
		}else{
			//request.setAttribute("message", "操作失败");
			out.println("<script>alert('操作失败！');</script>");
			return null;
		}	
	}

	public String updRptState(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String rptId = request.getParameter("rptId");
		
		DeviceTestReport dveReport = new DeviceTestReport();
		dveReport.setReportId(rptId);
		dveReport.setState("1");
		int res = dveTestReportService.updateTestReport(dveReport);
		if(res > 0){
			request.setAttribute("message", "修改成功");
			return "success";
		}else{
			request.setAttribute("message", "修改失败");
			return "input";
		}
	}
	
	//修改检测报告
	public String updTestReport() throws Exception{
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		//1、获取请求参数
		HttpServletRequest request=ServletActionContext.getRequest();
		String selectedInsId = request.getParameter("newSelInsId");
		String operate = request.getParameter("operate");
		String testResult = request.getParameter("testResult");
		String sampleState = request.getParameter("sampleState");
		
		String testDate = request.getParameter("testDate");
		String sampleName= request.getParameter("sampleName");
		String rptId= request.getParameter("testRptId");
		String wtUnit= request.getParameter("wtUnit");
		//删除的检测仪器、图片的编号
		String delInsId = request.getParameter("delInsId");
		String delPicId = request.getParameter("delPicId");
		
		//待测设备的编号和对应的标签
		String testDeviceId = request.getParameter("testDeviceId");
		String testDeviceLabel = request.getParameter("testDeviceLabel");
		String [] deviceId = testDeviceId.trim().split(",");
		String [] deviceLabel = testDeviceLabel.trim().split(",");
		
		//用户输入的检测过程和频谱图片名称
		String [] testPicName1 = request.getParameterValues("testPicName1");
		String [] pintuPicName1 = request.getParameterValues("pintuPicName1");

		//2、设置检测报告基本信息
		DeviceTestReport dveReport = new DeviceTestReport();
		dveReport.setReportId(rptId);
		dveReport.setSampleName(sampleName);
		String str = "";
		if("save".equals(operate)){
			dveReport.setState("1");
			str="保存";
		}
		if("sub".equals(operate)){
			dveReport.setState("2");
			str="提交";
		}
//		DateHandler.dateToString(time, fomat)
		dveReport.setTestDate(DateHandler.changeStringToDate(testDate));
		dveReport.setTestResult(testResult);
		dveReport.setRemark2(sampleState);
		dveReport.setRemark1(wtUnit);
	//	System.out.println("ope==="+operate+"sta==="+dveReport.getState());
		int res = 0;
		try{
			//3、更新设备标签
			//2017-5-24修改：设备标签的值不一定都为空
			for(int i = 0;i<deviceLabel.length; i++){
				String devLabel = deviceLabel[i];
				if(devLabel != ""){
					DeviceBaseInfo record = new DeviceBaseInfo();
					record.setDeviceId(deviceId[i]);
					record.setDeviceLabel(deviceLabel[i]);
					testService.getDeviceBaseInfoDAO().updateByPrimaryKeySelective(record);
				}
			}
			//4、更新检测报告
			/*
			 * 
			 */
			res = dveTestReportService.updateTestReport(dveReport, selectedInsId, delInsId,delPicId,
					testPic, testPicFileName, pinpuPic, pinpuPicFileName,testPicName1,pintuPicName1);
		}catch (Exception e){
			e.printStackTrace();
			SaveLog.saveLog(request, "检测报告",OpertionType.State.ADD , "操作异常");
			out.println("<script>alert('操作异常！');</script>");
			//request.setAttribute("message", "操作异常");
			 out.flush();
             out.close();
			return null;
		}
		//5、记录操作日志,跳转页面
		if(res==10){
			SaveLog.saveLog(request, "检测报告",OpertionType.State.ADD , "新增成功");
			
			
//			out.println("<script>alert('"+str+"成功！');window.location='admin/device/apply_audit_list.jsp'</script>");
			String toHref = "";
			out.println("<script>alert('"+str+"成功！')</script>");
			if("sub".equals(operate)){
				
				toHref = "window.location='admin/device/apply_audit_list.jsp'";
			}
			if("save".equals(operate)){
				String unitId =  request.getParameter("unitId");
				String applyId= request.getParameter("applyId");
				toHref = "window.location='admin/device/test_report_upd.jsp?applyId="+applyId+"&unitId="+unitId+"&testRptId="+rptId+"' ";
			}
						
//			out.println(toHref);
			out.println("<script>"+toHref+"</script>");
//			window.location.href='test_report_upd.jsp?applyId='+appId+'&unitId='+unitId+'&testRptId='+json.rptId;
			out.flush();
            out.close();
			//request.setAttribute("message", str+"成功");
			return null;
		}else{
			//request.setAttribute("message", "操作失败");
			out.println("<script>alert('操作失败！');</script>");
			 out.flush();
             out.close();
			return null;
		}	
	}
	
	//检测报告列表
	public String selTestRptList()throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		int pageNum = Integer.parseInt(request.getParameter("page"));
		int rp = Integer.parseInt(request.getParameter("rp"));
		int start = (pageNum - 1) * rp;
		int limit = pageNum * rp;
		String state = request.getParameter("state");
		DeviceTestReportExample ex = new DeviceTestReportExample();
		ex.setStart(start);
		ex.setLimit(limit);
		ex.setOrderByClause("test_date");
		ex.enablePagination();
		//DeviceTestReportExample.Criteria cri = ex.createCriteria();
		if(!"all".equals(state)){
			//cri.andStateEqualTo(state);
			ex.setStateValue(state);
		}
		List<DeviceTestReport> list = dveTestReportService.getDeviceTestReportDAO().selectByExample(ex);
		int total = dveTestReportService.getDeviceTestReportDAO().countByExample(ex);
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		DeviceTestReport info = new DeviceTestReport();
		try {
			for (int i = 0; i < list.size(); i++) {
				JSONObject json = new JSONObject();
				info = (DeviceTestReport)list.get(i);
				json.put("num", i+1);
				json.put("ReportId", info.getReportId());
				json.put("ApplyId", info.getApplyId());
				json.put("WtUnit", info.getWtUnit());
				json.put("SampleName", info.getSampleName());		
				
				
				json.put("TestDate", DateHandler.dateToString(info.getTestDate()));
				json.put("TestResult", info.getTestResult());
				json.put("TestUser", info.getRemark2());
				if("1".equals(info.getState())){
					json.put("State", "未提交");
					json.put("TestCode", info.getTestCode());
					json.put("operate",
							"<a href='test_report_upd.jsp?testRptId="+info.getReportId()+"&applyId="+info.getApplyId()+"&unitId="+info.getRemark1()+"'>修改</a> | "+
							"<a href='javascript:void(0)' onclick=\"delRpt('"+info.getApplyId()+"','"+info.getReportId()+"')\">删除</a>");
					
				}else{
					json.put("State", "已提交");
					json.put("TestCode", 
							"<a title='点击修改报告状态' href='javascript:void(0)' onclick=\"updRptState('"+info.getReportId()+"')\">"+info.getTestCode()+"</a>");
					
					//json.put("operate","<a href='../../reportJsp/test_rpt.jsp?testRptId="+info.getReportId()+"&applyId="+info.getApplyId()+"&unitId="+info.getRemark1()+"'>打印</a>");
//					json.put("operate","<a target='_blank' href='/aqjc/ReportServer?reportlet=DEVICE_TEST_REPORT.cpt&rptId="+info.getReportId()+"&applyId="+info.getApplyId()+"'>打印</a>");
					json.put("operate",
							"<a target='_blank' href='/ReportServer?reportlet=DEVICE_TEST_REPORT.cpt&rptId="+info.getReportId()+"&applyId="+info.getApplyId()+"'>打印</a> | "+
							"<a href='javascript:void(0)' onclick=\"delRpt('"+info.getApplyId()+"','"+info.getReportId()+"')\">删除</a>");
				}
				jsonArray.put(json);
			}
			jsonObject.put("rows", jsonArray);
			jsonObject.put("page", pageNum);
			jsonObject.put("total", total);
			ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
			return null;
		}catch (JSONException e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	//查询检测报告详情
	public String selRptDetail() throws IOException{
		HttpServletRequest request=ServletActionContext.getRequest();
		String testRptId = request.getParameter("testRptId");
		DeviceTestReport info = dveTestReportService.getDeviceTestReportDAO().selectByPrimaryKey(testRptId);
		TestReportPicExample example = new TestReportPicExample();
		example.createCriteria().andReportIdEqualTo(testRptId);
		example.setOrderByClause("upload_date");
		List<TestReportPic> list = dveTestReportService.getTestReportPicDAO().selectByExample(example);
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		TestReportPic rp = new TestReportPic();
		try {
			for (int i = 0; i < list.size(); i++) {
				JSONObject json = new JSONObject();
				rp = (TestReportPic)list.get(i);
				json.put("PicId", rp.getPicId());
				json.put("PicType", rp.getPicType());
				json.put("PicUrl", rp.getPicUrl());
				json.put("picName", rp.getPicName());
				jsonArray.put(json);
			}
			jsonObject.put("picData", jsonArray);
			jsonObject.put("SampleName", info.getSampleName());
			jsonObject.put("TestCode", info.getTestCode());
			jsonObject.put("TestDate", DateHandler.dateToString(info.getTestDate()));
			jsonObject.put("TestResult", info.getTestResult());
			jsonObject.put("SampleState", info.getRemark2());
			
			jsonObject.put("wtUnit", info.getRemark1());
			ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
			return null;
		}catch(JSONException e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	//查询是否填写过检测报告
	public String selRptByApp() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String applyId = request.getParameter("applyId");
		DeviceTestReportExample ex = new DeviceTestReportExample();
		ex.disablePagination();
		ex.createCriteria().andApplyIdEqualTo(applyId);
		int count = dveTestReportService.getDeviceTestReportDAO().countByExample2(ex);
		String rptId = "";
		if(count>0){
			List<DeviceTestReport> list = dveTestReportService.getDeviceTestReportDAO().selectByExample(ex);
//			rptId = list.get(0).getReportId();
			for(DeviceTestReport rpt :list){
				if (rpt.getApplyId().equalsIgnoreCase(applyId)){
					rptId = rpt.getReportId();
					break;
				}
			}
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("count", count);
		jsonObject.put("rptId", rptId);
		ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
		return null;
	}
	
	
	// 删除设备检测报告
	public String delRpt() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String applyId = request.getParameter("applyId");
		String rptId = request.getParameter("rptId");
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
//		String rptId = "";
//		rptId = dveTestRptService.getRptId(applyId);
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

	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}
}
