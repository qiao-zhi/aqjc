package com.tyust.service.pbs;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.tyust.bean.app.InstrumentInfo;
import com.tyust.bean.pbs.PbsPic;
import com.tyust.bean.pbs.PbsTestDatas;
import com.tyust.bean.pbs.PbsTestInstrument;
import com.tyust.bean.pbs.PbsTestReport;
import com.tyust.bean.pbs.PbsTestReportExample;
import com.tyust.common.FileHandler;
import com.tyust.dao.pbs.PbsPicDAO;
import com.tyust.dao.pbs.PbsTestReportDAO;

public class PbsTestReportService {

	/**
	 * 屏蔽室检测报告
	 */
	private PbsTestReportDAO pbsTestReportDAO;

	private PbsPicDAO pbsPicDAO;

	// 保存屏蔽室检测报告记录
	public String insertPbsTestReport(PbsTestReport record) {
		String pbsTestReportId = UUID.randomUUID().toString();
		record.setPbsTestReportId(pbsTestReportId);
		pbsTestReportDAO.insert(record);
		return pbsTestReportId;
	}

	// 更新屏蔽室检测信息
	public void updatePbsTestReport(PbsTestReport record){
		pbsTestReportDAO.updateByPrimaryKey(record);
	}
	
	// 查询
	public PbsTestReport queryPbsTestReportById(String pbsTestReportId){
		return pbsTestReportDAO.selectByPrimaryKey(pbsTestReportId);
	}
	
	// 条件查询
	public List<PbsTestReport> listPbsTestReport(PbsTestReportExample example){
		return pbsTestReportDAO.selectByExample(example);
	}
	
	/**
	 * 获取全部填写了检测报告的记录
	 */
	public List<PbsTestReport> listAllPbsTestReport(){
		List<PbsTestReport> list = new ArrayList<PbsTestReport>();
		list = pbsTestReportDAO.selectByExample(null);
		return list;
	}
	/**
	 * 屏蔽室检测报告扫描图片上传
	 * 
	 */
	public void uploadPbsPic(String pbsApplyId, String picType, File pic, String picName) {
		PbsPic record = new PbsPic();
		// 生成系统时间
		Date dt = new Date();
		// 生成随机编号
		String pbsPicId = UUID.randomUUID().toString();
		String fileType = picName.substring(picName.indexOf("."));
		String newFileName = pbsPicId + fileType;
		// 上传文件
		FileHandler.uploadFile(pic, newFileName, "pbsPic");
		record.setPbsPicId(pbsPicId);
		record.setPbsPicName(picName);
		record.setPbsPicType(picType);
		record.setPbsApplyId(pbsApplyId);
		record.setPbsPicDate(dt);
		record.setPbsPicUrl(newFileName);
		// 保存记录
		pbsPicDAO.insertSelective(record);
	}
	
	/******ll 增加的方法 S******/
	//获取屏蔽室检测报告编号用于生成新的编号
	public String getPbsTestReportNumber(){
		return pbsTestReportDAO.getPbsTestReportNumber();
	}
	
	//保存屏蔽室检测报告中的设备信息
	public boolean savePbsTestInsInfo(PbsTestInstrument pbsTestInstrument){
		String pbsTestInsId = UUID.randomUUID().toString();
		pbsTestInstrument.setPtiId(pbsTestInsId);
		pbsTestReportDAO.insertTestInstrument(pbsTestInstrument);
		return true;
	}
	
	//根据检测报告ID删除屏蔽室设备检测信息
	public boolean deletePbsTestInsInfo(String pbsReportId){
		pbsTestReportDAO.deleteTestInsByReportId(pbsReportId);
		return true;
	}
	
	//保存屏蔽室检测报告中的数据检测信息
	public boolean savePbsTestDatasInfo(PbsTestDatas pbsTestDatas){
		String pbsTestDatasId = UUID.randomUUID().toString();
		pbsTestDatas.setDatasId(pbsTestDatasId);
		pbsTestReportDAO.insertTestDatas(pbsTestDatas);
		return true;
	}
	
	//根据检测报告ID删除屏蔽室检测数据信息
	public boolean deletePbsTestDatasInfo(String pbsReportId){
		pbsTestReportDAO.deleteTestDatasByReportId(pbsReportId);
		return true;
	}
	
	//根据检测报告ID查询屏蔽室检测仪器信息
	public List<InstrumentInfo> getPbsInsInfoListByReportId(String testReportId){
		return pbsTestReportDAO.getPbsInsInfoListByReportId(testReportId);
		
	}
	
	//根据检测报告ID查询屏蔽室检测数据信息
	public List<PbsTestDatas> getPbsTestDatasByReportId(String testReportId){
		return pbsTestReportDAO.getPbsTestDatasByReportId(testReportId);
	}
	
	//根据屏蔽室申请ID查询屏蔽室检测报告ID
	public String getPbsTestReportIdByApplyId(String pbsApplyId){
		PbsTestReportExample pbsTestReportExample = new PbsTestReportExample();
		PbsTestReportExample.Criteria criteria = pbsTestReportExample.createCriteria();
		criteria.andPbsApplyIdEqualTo(pbsApplyId);
		List<PbsTestReport> list = pbsTestReportDAO.selectByExample(pbsTestReportExample);
		return list.get(0).getPbsTestReportId();
	}
	
	//根据屏蔽室申请ID查询申请单位名称
	public String getPbsApplyUnitNameByApplyId(String applyId){
		return pbsTestReportDAO.getPbsApplyUnitNameByApplyId(applyId);
	}
	
	/******ll 增加的方法 E******/
	
	
	public PbsTestReportDAO getPbsTestReportDAO() {
		return pbsTestReportDAO;
	}

	public void setPbsTestReportDAO(PbsTestReportDAO pbsTestReportDAO) {
		this.pbsTestReportDAO = pbsTestReportDAO;
	}

	public PbsPicDAO getPbsPicDAO() {
		return pbsPicDAO;
	}

	public void setPbsPicDAO(PbsPicDAO pbsPicDAO) {
		this.pbsPicDAO = pbsPicDAO;
	}

}
