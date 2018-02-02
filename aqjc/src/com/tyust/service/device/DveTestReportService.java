package com.tyust.service.device;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import com.tyust.bean.app.ReportInstrument;
import com.tyust.bean.app.ReportInstrumentExample;
import com.tyust.bean.app.TestReportPic;
import com.tyust.bean.app.TestReportPicExample;
import com.tyust.bean.device.DeviceTestApply;
import com.tyust.bean.device.DeviceTestReport;
import com.tyust.bean.device.DeviceTestReportExample;
import com.tyust.common.FileHandler;
import com.tyust.common.image.ImageScale;
import com.tyust.dao.app.ReportInstrumentDAO;
import com.tyust.dao.app.TestReportPicDAO;
import com.tyust.dao.device.DeviceTestApplyDAO;
import com.tyust.dao.device.DeviceTestReportDAO;

public class DveTestReportService {
	private DeviceTestReportDAO deviceTestReportDAO;
	private ReportInstrumentDAO reportInstrumentDAO;
	private TestReportPicDAO testReportPicDAO;
	private DeviceTestApplyDAO deviceTestApplyDAO;
	
	public DeviceTestApplyDAO getDeviceTestApplyDAO() {
		return deviceTestApplyDAO;
	}
	public void setDeviceTestApplyDAO(DeviceTestApplyDAO deviceTestApplyDAO) {
		this.deviceTestApplyDAO = deviceTestApplyDAO;
	}
	public DeviceTestReportDAO getDeviceTestReportDAO() {
		return deviceTestReportDAO;
	}
	public void setDeviceTestReportDAO(DeviceTestReportDAO deviceTestReportDAO) {
		this.deviceTestReportDAO = deviceTestReportDAO;
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
	
	/*
	 * 添加检测报告信息
	 */
	public int addTestReport(DeviceTestReport dveReport,String rptInsId,File[] testPic,String[] testPicName,
							File[] pinpuPic,String[] pinpuPicName,String [] testPicName1,String [] pinpuPicName1){
		
		/*
		 * 1、保存检测报告基本信息
		 */
		dveReport.setReportId(UUID.randomUUID().toString());
		deviceTestReportDAO.insertSelective(dveReport);
		
		/* 2、修改设备申请的状态
		 * 如果是“提交”检测报告，则将设备检测申请的状态修改为“已检测”
		 * 申请状态：1待提交，2待审核，3审核未通过，4审核通过，5已检测
		 */
		if(dveReport.getState().equals("2")){
			DeviceTestApply app = new DeviceTestApply();
			app.setApplyId(dveReport.getApplyId());
			app.setState("5");
			deviceTestApplyDAO.updateByPrimaryKeySelective(app);
		}
		
		//3、保存检测仪器		
		String[] ids=rptInsId.trim().split(","); 
		for(int i=0;i<ids.length;i++){
			ReportInstrument rptIns = new ReportInstrument();
			rptIns.setId(UUID.randomUUID().toString());
			rptIns.setInstrumentId(ids[i]);
			rptIns.setReportId(dveReport.getReportId());
			reportInstrumentDAO.insertSelective(rptIns);
		}
		
		/*
		 *4、 保存检测过程图片
		 * 
		 */
		if(testPic!=null&&testPic.length>0){
			uploadPic(dveReport.getReportId(),"1",testPic,testPicName,testPicName1);
		}
		/*
		 * 5、保存频谱照片
		 */
		if(pinpuPic!=null&&pinpuPic.length>0){
			uploadPic(dveReport.getReportId(),"2",pinpuPic,pinpuPicName,pinpuPicName1);
		}
		return 10;
	}
	
	public int updateTestReport(DeviceTestReport dveReport){
		return deviceTestReportDAO.updateByPrimaryKeySelective(dveReport);
	}
		/**
		 * 
		 * @param dveReport
		 * @param rptInsId
		 * @param delInsId
		 * @param delPicId
		 * @param testPic
		 * @param testPicName
		 * @param pinpuPic
		 * @param pinpuPicName
		 * @param testPicName1
		 * @param pinpuPicName1
		 * @return
		 */
	public int updateTestReport(DeviceTestReport dveReport,String rptInsId,String delInsId,String delPicId,
			File[] testPic,String[] testPicName,File[] pinpuPic,String[] pinpuPicName,String [] testPicName1,String [] pinpuPicName1){
		//1、更新检测报告基本信息		
		deviceTestReportDAO.updateByPrimaryKeySelective(dveReport);
		
		/* 2、修改设备申请的状态
		 * 如果是“提交”检测报告，则将设备检测申请的状态修改为“已检测”
		 * 申请状态：1待提交，2待审核，3审核未通过，4审核通过，5已检测
		 */
		if(dveReport.getState().equals("2")){
			DeviceTestApply app = new DeviceTestApply();
			app.setApplyId(deviceTestReportDAO.selectByPrimaryKey(dveReport.getReportId()).getApplyId());
			app.setState("5");
			deviceTestApplyDAO.updateByPrimaryKeySelective(app);
		}
		//3、将删除的检测仪器从数据库删除
		if(delInsId!=null && !"".equals(delInsId)){
			String[] delids=delInsId.trim().split(","); 
			for(int i=0;i<delids.length;i++){
				reportInstrumentDAO.deleteByPrimaryKey(delids[i]);
			}
		}
		//4、将新增的的检测仪器信息保存到数据库中
		if(rptInsId!=null && !"".equals(rptInsId)){
			String[] ids=rptInsId.trim().split(","); 
			for(int i=0;i<ids.length;i++){
				ReportInstrument rptIns = new ReportInstrument();
				rptIns.setId(UUID.randomUUID().toString());
				rptIns.setInstrumentId(ids[i]);
				rptIns.setReportId(dveReport.getReportId());
				reportInstrumentDAO.insertSelective(rptIns);
			}
		}
		
		//5、将删除的图片从数据库删除
		if(delPicId!=null&&!"".equals(delPicId)){
			String[] picids=delPicId.trim().split(","); 
			for(int i=0;i<picids.length;i++){
				String url = testReportPicDAO.selectByPrimaryKey(picids[i]).getPicUrl();
				FileHandler.deleteFile(url, "pic");
				testReportPicDAO.deleteByPrimaryKey(picids[i]);
			}
		}
		//6、上传最新的图片
		if(testPic!=null&&testPic.length>0){
			uploadPic(dveReport.getReportId(),"1",testPic,testPicName,testPicName1);
		}
		if(pinpuPic!=null&&pinpuPic.length>0){
			uploadPic(dveReport.getReportId(),"2",pinpuPic,pinpuPicName,pinpuPicName1);
		}
		return 10;
	}
	
	/**
	 * 上传图片
	 * @param rptId 报表编号
	 * @param picType：图片类型
	 * @param pic 需要上传的图片
	 * @param picName 图片文件原始名字
	 * @param picName1：用户输入图片名称
	 */
	private void uploadPic(String rptId,String picType,File[] pic,String[] picName,String [] picName1){
		TestReportPic record = new TestReportPic();
		Date dt = new Date();
		Calendar c = new GregorianCalendar();
		c.setTime(dt);
		
		
//		图片伸缩的宽度、高度
		int scaledWidth,scaledHeight;
//		设置图片伸缩大小 1：检测图片  2：频谱图片
		if (picType.equals("1")) {
			scaledWidth = 280;
			scaledHeight = 280;
		}else{
			scaledWidth = 590;
			scaledHeight = 190;
		}
		for(int i=0;i<pic.length;i++){
			String id = UUID.randomUUID().toString();
			String fileType = picName[i].substring(picName[i].indexOf("."));
			String newFileName = id + fileType;
			FileHandler.uploadFile(pic[i], newFileName, "pic");
//			对图片进行伸缩
			ImageScale.scale(newFileName, "uploads/pic",scaledWidth, scaledHeight);
			record.setPicId(id);
			record.setPicName(picName1[i]);
			record.setPicType(picType);
			record.setReportId(rptId);
//			为了设置图片的显示顺序，通过设置其上传
			c.add(Calendar.SECOND, 1);
			record.setUploadDate(c.getTime());
			
			record.setPicUrl(newFileName);
			testReportPicDAO.insertSelective(record);
		}
	}
	/**
	 * 根据检测报告编号删除检测报告
	 * @param rptId
	 * @return
	 */
	public int delRept(String rptId){
		int res = 0;
		res = deviceTestReportDAO.deleteByPrimaryKey(rptId);
		
		return res;
	}
	/**
	 * 根据检测报告编号删除对应的检测图片
	 * @param rptId
	 * @return
	 */
	public int delReptPics(String rptId){
		int res = 0;
		TestReportPicExample example = new TestReportPicExample();
		TestReportPicExample.Criteria criteria = example.createCriteria();
		criteria.andReportIdEqualTo(rptId);
		res = testReportPicDAO.deleteByExample(example);
		
		return res;
	}
	
	/**
	 * 根据检测报告编号删除检测所需仪器
	 * @param rptId
	 * @return
	 */
	public int delReptInstrument(String rptId){
		int res = 0;
		ReportInstrumentExample example = new ReportInstrumentExample();
		ReportInstrumentExample.Criteria criteria = example.createCriteria();
		criteria.andReportIdEqualTo(rptId);
		res = reportInstrumentDAO.deleteByExample(example);
		
		return res;
	}
	
	public String getApplyId(String rptId){
		String applyId = "";
		applyId =  deviceTestReportDAO.selectByPrimaryKey(rptId).getApplyId();
		return applyId;
	}
	
	public String getRptId(String applyId){
		String rptId = "";
		rptId = deviceTestReportDAO.selectRptIdByApplyId(applyId);
		return rptId;
	}
}
