package com.tyust.service.en;

import java.io.File;
import java.util.Date;
import java.util.UUID;

import com.tyust.bean.en.EnApplyAudit;
import com.tyust.bean.en.EnApplyInfo;
import com.tyust.bean.en.EnAttach;
import com.tyust.bean.en.EnAttachExample;
import com.tyust.bean.en.EnPic;
import com.tyust.bean.en.EnPicExample;
import com.tyust.common.FileHandler;
import com.tyust.dao.en.EnApplyAuditDAO;
import com.tyust.dao.en.EnApplyInfoDAO;
import com.tyust.dao.en.EnAttachDAO;
import com.tyust.dao.en.EnPicDAO;

public class EnApplyInfoService {

	private EnApplyInfoDAO enApplyInfoDAO;

	private EnPicDAO enPicDAO;

	private EnAttachDAO enAttachDAO;
	
	private EnApplyAuditDAO enApplyAuditDAO;

	public String insertEnApplyInfo(EnApplyInfo record) {
		String enApplyId = UUID.randomUUID().toString();
		record.setEnvironmentApplyId(enApplyId);
		enApplyInfoDAO.insert(record);
		return enApplyId;
	}

	public String updateEnApplyInfo(EnApplyInfo record) {
		String enApplyId = record.getEnvironmentApplyId();
		enApplyInfoDAO.updateByPrimaryKey(record);
		return enApplyId;
	}

	public void delEnApply(String enApplyId){
		EnAttachExample attach = new EnAttachExample();
		EnAttachExample.Criteria attachCri = attach.createCriteria();
		attachCri.andEnvironmentApplyIdEqualTo(enApplyId);
		enAttachDAO.deleteByExample(attach);
		
		EnPicExample pic = new EnPicExample();
		EnPicExample.Criteria picCri = pic.createCriteria();
		picCri.andEnApplyIdEqualTo(enApplyId);
		enPicDAO.deleteByExample(pic);
		
		enApplyInfoDAO.deleteByPrimaryKey(enApplyId);
	}
	public void uploadEnPic(String enApplyId, String picType, File pic, String picName) {
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

	// 根据主键删除
	public void delEnPic(String enPicId) {
		String url = enPicDAO.selectByPrimaryKey(enPicId).getEnPicUrl();
		FileHandler.deleteFile(url, "enPic");
		enPicDAO.deleteByPrimaryKey(enPicId);
	}
	
	public void delEnPic2(String enApplyId,String picType) {
		EnPicExample ex = new EnPicExample();
		EnPicExample.Criteria cri = ex.createCriteria();
		cri.andEnApplyIdEqualTo(enApplyId);
		cri.andEnPicTypeEqualTo(picType);
		EnPic enPic = enPicDAO.selectByExample(ex).get(0);
		if(enPic != null){
			FileHandler.deleteFile(enPic.getEnPicUrl(), "enPic");
		}
		// 删除记录
		enPicDAO.deleteByPrimaryKey(enPic.getEnPicId());
	}
	
	public void updateEnPic(String enApplyId, String picType, File pic, String picName) {
		// 删除文件
		EnPicExample ex = new EnPicExample();
		EnPicExample.Criteria cri = ex.createCriteria();
		cri.andEnApplyIdEqualTo(enApplyId);
		cri.andEnPicTypeEqualTo(picType);
		EnPic enPic = enPicDAO.selectByExample(ex).get(0);
		String enPicId = "";
		if(enPic != null){
			FileHandler.deleteFile(enPic.getEnPicUrl(), "enPic");
			enPicId = enPic.getEnPicId();
		}
		
		// 更新记录
		EnPic record = new EnPic();
		// 生成系统时间
		Date dt = new Date();
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
		enPicDAO.updateByPrimaryKey(record);
	}

	public void uploadEnAttach(EnAttach record, File enAttach, String enAttachFileName) {
		Date dt = new Date();
		String enAttachId = UUID.randomUUID().toString();
		String fileType = enAttachFileName.substring(enAttachFileName.indexOf("."));
		String enAttachUrl = enAttachId + fileType;
		FileHandler.uploadFile(enAttach, enAttachUrl, "enAttach");
		record.setEnvironmentAttachId(enAttachId);
		record.setEnvironmentAttachDate(dt);
		record.setEnvironmentAttachUrl(enAttachUrl);
		record.setEnvironmentAttachName(enAttachFileName);
		enAttachDAO.insert(record);
	}

	public void delEnAttach(String enAttachId) {
		String url = enAttachDAO.selectByPrimaryKey(enAttachId).getEnvironmentAttachUrl();
		FileHandler.deleteFile(url, "enAttach");
		enAttachDAO.deleteByPrimaryKey(enAttachId);
	}

	// 保存审核信息
	public void insertEnApplyAudit(EnApplyAudit record) {
		String auditId = UUID.randomUUID().toString();
		record.setAuditId(auditId);
		enApplyAuditDAO.insert(record);
	}
	
	public EnApplyInfoDAO getEnApplyInfoDAO() {
		return enApplyInfoDAO;
	}

	public void setEnApplyInfoDAO(EnApplyInfoDAO enApplyInfoDAO) {
		this.enApplyInfoDAO = enApplyInfoDAO;
	}

	public EnPicDAO getEnPicDAO() {
		return enPicDAO;
	}

	public void setEnPicDAO(EnPicDAO enPicDAO) {
		this.enPicDAO = enPicDAO;
	}

	public EnAttachDAO getEnAttachDAO() {
		return enAttachDAO;
	}

	public void setEnAttachDAO(EnAttachDAO enAttachDAO) {
		this.enAttachDAO = enAttachDAO;
	}

	public EnApplyAuditDAO getEnApplyAuditDAO() {
		return enApplyAuditDAO;
	}

	public void setEnApplyAuditDAO(EnApplyAuditDAO enApplyAuditDAO) {
		this.enApplyAuditDAO = enApplyAuditDAO;
	}

}
