package com.tyust.service.en;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.tyust.bean.en.EnPic;
import com.tyust.bean.en.EnPicExample;
import com.tyust.bean.en.EnTestInstrument;
import com.tyust.bean.en.EnTestInstrumentExample;
import com.tyust.bean.en.EnTestReport;
import com.tyust.bean.en.EnTestReportExample;
import com.tyust.common.DeleteFileUtil;
import com.tyust.common.FileHandler;
import com.tyust.dao.en.EnPicDAO;
import com.tyust.dao.en.EnTestInstrumentDAO;
import com.tyust.dao.en.EnTestReportDAO;

public class EnTestReportService {

	private EnTestReportDAO enTestReportDAO;

	private EnTestInstrumentDAO enTestInstrumentDAO;

	private EnPicDAO enPicDAO;

	public String insertEnTestReport(EnTestReport record) {
		String enTestReportId = UUID.randomUUID().toString();
		record.setEnvironmentTestReportId(enTestReportId);
		enTestReportDAO.insert(record);
		return enTestReportId;
	}

	public void delEnTestReport(String enTestReportId, String enApplyId) {
		EnPicExample pic = new EnPicExample();
		EnPicExample.Criteria cri = pic.createCriteria();
		cri.andEnApplyIdEqualTo(enApplyId);
		cri.andEnPicTypeEqualTo("2");
		enPicDAO.deleteByExample(pic);
		enTestReportDAO.deleteByPrimaryKey(enTestReportId);
	}

	// 根据申请ID查询检测报告id
	public String selTestReportIdByApplyId(String applyId) {
		EnTestReportExample example = new EnTestReportExample();
		EnTestReportExample.Criteria cri = example.createCriteria();
		cri.andEnvironmentApplyIdEqualTo(applyId);
		List<EnTestReport> list = enTestReportDAO.selectByExample(example);
		return list.get(0).getEnvironmentTestReportId();
	}

	public void uploadEnTestPic(String enApplyId, String picType, File pic, String picName) {
		EnPic record = new EnPic();
		// 生成系统时间
		Date dt = new Date();
		// 生成随机编号
		String enPicId = UUID.randomUUID().toString();
		String fileType = picName.substring(picName.indexOf("."));
		String newFileName = enPicId + fileType;
		// 上传文件
		FileHandler.uploadFile(pic, newFileName, "enPic");
		record.setEnPicId(enPicId);
		record.setEnPicName(picName);
		record.setEnPicType(picType);
		record.setEnApplyId(enApplyId);
		record.setEnPicDate(dt);
		record.setEnPicUrl(newFileName);
		enPicDAO.insert(record);
	}

	public void delEnTestPic(String enPicId) {
		String url = enPicDAO.selectByPrimaryKey(enPicId).getEnPicUrl();
		DeleteFileUtil.deletePicture(url);//删除图片
		enPicDAO.deleteByPrimaryKey(enPicId);//删除记录
	}

	// 保存检测报告和检测仪器之间的关系
	public void insertReportAndIns(EnTestInstrument record) {
		String etiId = UUID.randomUUID().toString();
		record.setEtiId(etiId);
		enTestInstrumentDAO.insert(record);
	}

	// 根据检测报告ID删除
	public void delByReportId(String enTestReportId) {
		EnTestInstrumentExample example = new EnTestInstrumentExample();
		EnTestInstrumentExample.Criteria cri = example.createCriteria();
		cri.andEnvironmentTestReportIdEqualTo(enTestReportId);
		enTestInstrumentDAO.deleteByExample(example);
	}

	
	/*************S    QLQ加的********************/
	public String selEnviromentId() {
		return enTestReportDAO.selEnviromentId();
	}
	/*************E    QLQ加的********************/
	
	
	
	public EnTestReportDAO getEnTestReportDAO() {
		return enTestReportDAO;
	}

	public void setEnTestReportDAO(EnTestReportDAO enTestReportDAO) {
		this.enTestReportDAO = enTestReportDAO;
	}

	public EnTestInstrumentDAO getEnTestInstrumentDAO() {
		return enTestInstrumentDAO;
	}

	public void setEnTestInstrumentDAO(EnTestInstrumentDAO enTestInstrumentDAO) {
		this.enTestInstrumentDAO = enTestInstrumentDAO;
	}

	public EnPicDAO getEnPicDAO() {
		return enPicDAO;
	}

	public void setEnPicDAO(EnPicDAO enPicDAO) {
		this.enPicDAO = enPicDAO;
	}

}
