package com.tyust.service.pbs;

import java.io.File;
import java.util.Date;
import java.util.UUID;

import com.tyust.bean.pbs.PbsApplyAudit;
import com.tyust.bean.pbs.PbsApplyInfo;
import com.tyust.bean.pbs.PbsAttach;
import com.tyust.bean.pbs.PbsPic;
import com.tyust.bean.pbs.PbsPicExample;
import com.tyust.common.FileHandler;
import com.tyust.common.FileNameUtil;
import com.tyust.common.UUIDUtil;
import com.tyust.dao.pbs.PbsApplyAuditDAO;
import com.tyust.dao.pbs.PbsApplyInfoDAO;
import com.tyust.dao.pbs.PbsAttachDAO;
import com.tyust.dao.pbs.PbsPicDAO;

/**
 * 屏蔽室申请信息服务类
 * 
 * @author sunwei
 *
 */
public class PbsApplyInfoService {

	private PbsApplyInfoDAO pbsApplyInfoDAO;

	private PbsPicDAO pbsPicDAO;

	private PbsAttachDAO pbsAttachDAO;
	
	//屏蔽室审核DAO
	private PbsApplyAuditDAO pbsApplyAuditDAO;

	/**
	 * 插入屏蔽室申请信息
	 * 
	 * 1.随机为记录生成UUID作为主键 并插入到数据库中
	 * 
	 * @param record
	 * @return 插入屏蔽室申请信息记录的主键
	 */
	public String insertPbsApplyInfo(PbsApplyInfo record) {
		// 为记录随机生成UUID
		String pbsApplyId = UUID.randomUUID().toString();
		record.setPbsApplyId(pbsApplyId);
		pbsApplyInfoDAO.insertSelective(record);
		return pbsApplyId;
	}

	/**
	 * 更新屏蔽室申请信息
	 * 
	 * 
	 * @param record
	 * @return 更新记录的主键
	 */
	public String updatePbsApplyInfo(PbsApplyInfo record) {
		String pbsApplyId = record.getPbsApplyId();
		pbsApplyInfoDAO.updateByPrimaryKeySelective(record);
		return pbsApplyId;
	}

	/**
	 * 功能说明：屏蔽室图片上传 详细说明：保存屏蔽室申请与检测的图片信息记录和保存文件
	 * 
	 * @param rptId
	 * @param picType
	 * @param pic
	 * @param picName
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

	// 更新
	public void updatePbsPic(String pbsApplyId, String picType, File pic, String picName) {
		// 删除文件
		PbsPicExample ex = new PbsPicExample();
		PbsPicExample.Criteria cri = ex.createCriteria();
		cri.andPbsApplyIdEqualTo(pbsApplyId);
		cri.andPbsPicTypeEqualTo(picType);
		PbsPic pbsPic = pbsPicDAO.selectByExample(ex).get(0);
		String pbsPicId = "";
		if (pbsPic != null) {
			FileHandler.deleteFile(pbsPic.getPbsPicUrl(), "pbsPic");
			pbsPicId = pbsPic.getPbsPicId();
		}
		// 更新记录
		PbsPic record = new PbsPic();
		// 生成系统时间
		Date dt = new Date();
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
		pbsPicDAO.updateByPrimaryKey(record);
	}

	/**
	 * 功能说明：删除屏蔽室申请与检测的图片
	 * 
	 * @param pbsPicId
	 */
	public void delPbsPic(String pbsPicId) {
		// 根据文件ID 获取文件存储路径中的文件名（url）
		String picUrl = pbsPicDAO.selectByPrimaryKey(pbsPicId).getPbsPicUrl();
		pbsPicDAO.deleteByPrimaryKey(pbsPicId);
		FileHandler.deleteFile(picUrl, "pbsPic");
	}

	public void delPbsPic2(String pbsApplyId,String picType) {
		PbsPicExample ex = new PbsPicExample();
		PbsPicExample.Criteria cri = ex.createCriteria();
		cri.andPbsApplyIdEqualTo(pbsApplyId);
		cri.andPbsPicTypeEqualTo(picType);
		PbsPic pic = pbsPicDAO.selectByExample(ex).get(0);
		if(pic != null){
			FileHandler.deleteFile(pic.getPbsPicUrl(), "pbsPic");
		}
		pbsPicDAO.deleteByPrimaryKey(pic.getPbsPicId());
	}
	
	// 屏蔽室附件上传
	public void insertPbsAttach(PbsAttach record, File pbsApplyInfoAttach, String pbsApplyInfoAttachFileName) {
		String pbsAttachId = UUID.randomUUID().toString();
		//获取文件类型
		String fileType = FileNameUtil.getFileSufix(pbsApplyInfoAttachFileName);
		String pbsAttachUrl = pbsAttachId +"."+ fileType;
		// 保存文件
		//FileHandler.uploadFile(pbsApplyInfoAttach, pbsAttachUrl, "pbsAttach");
		FileHandler.uploadFileToDisk(pbsApplyInfoAttach, pbsAttachUrl, "pbsfile");
		record.setPbsAttachId(pbsAttachId);
		record.setPbsAttachName(pbsApplyInfoAttachFileName);
		//数据库中保存PDF格式的文件
		record.setPbsAttachUrl(pbsAttachId+".pdf");
		Date pbsAttachDate = new Date();
		record.setPbsAttachDate(pbsAttachDate);
		// 保存记录
		pbsAttachDAO.insertSelective(record);
	}

	// 屏蔽室附件删除
	public void delPbsAttach(String pbsAttachId) {
		// 获取附件url
		String pbsAttachUrl = pbsAttachDAO.selectByPrimaryKey(pbsAttachId).getPbsAttachUrl();
		//FileHandler.deleteFile(pbsAttachUrl, "pbsAttach");
		//删除磁盘中的文件
		FileHandler.deleteFileFromDisk(pbsAttachUrl, "pbsfile");
		pbsAttachDAO.deleteByPrimaryKey(pbsAttachId);
	}
	
	// 屏蔽室审核信息的保存
	public void insertPbsApplyInfo(PbsApplyAudit pbsApplyAudit) {
		pbsApplyAudit.setAuditId(UUIDUtil.getUUID2());
		pbsApplyAudit.setRemark1("11");
		pbsApplyAudit.setRemark2("22");
		pbsApplyAuditDAO.insertSelective(pbsApplyAudit);
	}
	
	
	public PbsApplyInfoDAO getPbsApplyInfoDAO() {
		return pbsApplyInfoDAO;
	}

	public void setPbsApplyInfoDAO(PbsApplyInfoDAO pbsApplyInfoDAO) {
		this.pbsApplyInfoDAO = pbsApplyInfoDAO;
	}

	public PbsAttachDAO getPbsAttachDAO() {
		return pbsAttachDAO;
	}

	public void setPbsAttachDAO(PbsAttachDAO pbsAttachDAO) {
		this.pbsAttachDAO = pbsAttachDAO;
	}

	public PbsPicDAO getPbsPicDAO() {
		return pbsPicDAO;
	}

	public void setPbsPicDAO(PbsPicDAO pbsPicDAO) {
		this.pbsPicDAO = pbsPicDAO;
	}

	public PbsApplyAuditDAO getPbsApplyAuditDAO() {
		return pbsApplyAuditDAO;
	}

	public void setPbsApplyAuditDAO(PbsApplyAuditDAO pbsApplyAuditDAO) {
		this.pbsApplyAuditDAO = pbsApplyAuditDAO;
	}

	
	
}
