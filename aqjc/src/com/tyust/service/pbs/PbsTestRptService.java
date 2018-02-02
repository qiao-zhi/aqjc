package com.tyust.service.pbs;

import java.io.File;
import java.util.Date;
import java.util.UUID;

import com.tyust.bean.app.ReportInstrument;
import com.tyust.bean.app.TestReportPic;
import com.tyust.bean.device.DeviceTestApply;
import com.tyust.bean.device.DeviceTestReport;
import com.tyust.bean.pbs.PbsTestApply;
import com.tyust.bean.pbs.PbsTestRpt;
import com.tyust.common.FileHandler;
import com.tyust.dao.app.ReportInstrumentDAO;
import com.tyust.dao.app.TestReportPicDAO;
import com.tyust.dao.device.DeviceTestApplyDAO;
import com.tyust.dao.device.DeviceTestReportDAO;
import com.tyust.dao.pbs.PbsTestApplyDAO;
import com.tyust.dao.pbs.PbsTestRptDAO;

public class PbsTestRptService {
	private PbsTestRptDAO pbsTestRptDAO;
	private ReportInstrumentDAO reportInstrumentDAO;
	private TestReportPicDAO testReportPicDAO;
	private PbsTestApplyDAO pbsTestApplyDAO;
	
	public PbsTestApplyDAO getPbsTestApplyDAO() {
		return pbsTestApplyDAO;
	}
	public void setPbsTestApplyDAO(PbsTestApplyDAO pbsTestApplyDAO) {
		this.pbsTestApplyDAO = pbsTestApplyDAO;
	}
	public PbsTestRptDAO getPbsTestRptDAO() {
		return pbsTestRptDAO;
	}
	public void setPbsTestRptDAO(PbsTestRptDAO pbsTestRptDAO) {
		this.pbsTestRptDAO = pbsTestRptDAO;
	}
	public ReportInstrumentDAO getReportInstrumentDAO() {
		return reportInstrumentDAO;
	}
	public void setReportInstrumentDAO(ReportInstrumentDAO reportInstrumentDAO) {
		this.reportInstrumentDAO = reportInstrumentDAO;
	}
	public TestReportPicDAO getTestReportPicDAO() {
		return testReportPicDAO;
	}
	public void setTestReportPicDAO(TestReportPicDAO testReportPicDAO) {
		this.testReportPicDAO = testReportPicDAO;
	}
	
	public int addTestReport(PbsTestRpt rpt,String rptInsId,File[] testPic,String[] testPicName){
		
		rpt.setTestRptId(UUID.randomUUID().toString());
		pbsTestRptDAO.insertSelective(rpt);
		
		if(rpt.getRptState().equals("2")){
			PbsTestApply app = new PbsTestApply();
			app.setTestApplyId(rpt.getApplyId());
			app.setApplyState("5");
			pbsTestApplyDAO.updateByPrimaryKeySelective(app);
		}
		
		String[] ids=rptInsId.trim().split(","); 
		for(int i=0;i<ids.length;i++){
			ReportInstrument rptIns = new ReportInstrument();
			rptIns.setId(UUID.randomUUID().toString());
			rptIns.setInstrumentId(ids[i]);
			rptIns.setReportId(rpt.getTestRptId());
			reportInstrumentDAO.insertSelective(rptIns);
		}
		
		if(testPic!=null&&testPic.length>0){
			uploadPic(rpt.getTestRptId(),"1",testPic,testPicName);
		}
		return 10;
	}
	
//	public int updateTestReport(DeviceTestReport dveReport,String rptInsId,String delInsId,String delPicId,
//			File[] testPic,String[] testPicName,File[] pinpuPic,String[] pinpuPicName){
//
//		deviceTestReportDAO.updateByPrimaryKeySelective(dveReport);
//		
//		if(dveReport.getState().equals("2")){
//			DeviceTestApply app = new DeviceTestApply();
//			app.setApplyId(deviceTestReportDAO.selectByPrimaryKey(dveReport.getReportId()).getApplyId());
//			app.setState("5");
//			deviceTestApplyDAO.updateByPrimaryKeySelective(app);
//		}
//		
//		if(delInsId!=null&&!"".equals(delInsId)){
//			String[] delids=delInsId.trim().split(","); 
//			for(int i=0;i<delids.length;i++){
//				reportInstrumentDAO.deleteByPrimaryKey(delids[i]);
//			}
//		}
//		if(rptInsId!=null&&!"".equals(rptInsId)){
//			String[] ids=rptInsId.trim().split(","); 
//			for(int i=0;i<ids.length;i++){
//				ReportInstrument rptIns = new ReportInstrument();
//				rptIns.setId(UUID.randomUUID().toString());
//				rptIns.setInstrumentId(ids[i]);
//				rptIns.setReportId(dveReport.getReportId());
//				reportInstrumentDAO.insertSelective(rptIns);
//			}
//		}
//		
//		if(delPicId!=null&&!"".equals(delPicId)){
//			String[] picids=delPicId.trim().split(","); 
//			for(int i=0;i<picids.length;i++){
//				String url = testReportPicDAO.selectByPrimaryKey(picids[i]).getPicUrl();
//				FileHandler.deleteFile(url, "pic");
//				testReportPicDAO.deleteByPrimaryKey(picids[i]);
//			}
//		}
//		
//		if(testPic!=null&&testPic.length>0){
//			uploadPic(dveReport.getReportId(),"1",testPic,testPicName);
//		}
//		if(pinpuPic!=null&&pinpuPic.length>0){
//			uploadPic(dveReport.getReportId(),"2",pinpuPic,pinpuPicName);
//		}
//		return 10;
//	}
	
	private void uploadPic(String rptId,String picType,File[] pic,String[] picName){
		TestReportPic record = new TestReportPic();
		Date dt = new Date(); 
		for(int i=0;i<pic.length;i++){
			String id = UUID.randomUUID().toString();
			String fileType = picName[i].substring(picName[i].indexOf("."));
			String newFileName = id + fileType;
			FileHandler.uploadFile(pic[i], newFileName, "pic");
			record.setPicId(id);
			record.setPicName(picName[i]);
			record.setPicType(picType);
			record.setReportId(rptId);
			record.setUploadDate(dt);
			record.setPicUrl(newFileName);
			testReportPicDAO.insertSelective(record);
		}
	}
	
}
