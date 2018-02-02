package com.tyust.service.device;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.tyust.bean.device.ApplyAuditSmj;
import com.tyust.bean.device.ApplyDevice;
import com.tyust.bean.device.ApplyDeviceExample;
import com.tyust.bean.device.DeviceApplyAudit;
import com.tyust.bean.device.DeviceApplyAuditExample;
import com.tyust.bean.device.DeviceTestApply;
import com.tyust.bean.device.DeviceTestApplyAttach;
import com.tyust.bean.device.DeviceTestApplyAttachExample;
import com.tyust.common.FileHandler;
import com.tyust.dao.app.DeviceBaseInfoDAO;
import com.tyust.dao.device.ApplyAuditSmjDAO;
import com.tyust.dao.device.ApplyDeviceDAO;
import com.tyust.dao.device.DeviceApplyAuditDAO;
import com.tyust.dao.device.DeviceTestApplyAttachDAO;
import com.tyust.dao.device.DeviceTestApplyDAO;

public class DveTestApplyService {
	private DeviceTestApplyDAO deviceTestApplyDAO;
	private ApplyDeviceDAO applyDeviceDAO;
	private DeviceApplyAuditDAO deviceApplyAuditDAO;
	private ApplyAuditSmjDAO applyAuditSmjDAO;
	private DeviceTestApplyAttachDAO deviceTestApplyAttachDAO;
	private DeviceBaseInfoDAO deviceBaseInfoDAO;

	public DeviceBaseInfoDAO getDeviceBaseInfoDAO() {
		return deviceBaseInfoDAO;
	}

	public void setDeviceBaseInfoDAO(DeviceBaseInfoDAO deviceBaseInfoDAO) {
		this.deviceBaseInfoDAO = deviceBaseInfoDAO;
	}

	public ApplyAuditSmjDAO getApplyAuditSmjDAO() {
		return applyAuditSmjDAO;
	}

	public void setApplyAuditSmjDAO(ApplyAuditSmjDAO applyAuditSmjDAO) {
		this.applyAuditSmjDAO = applyAuditSmjDAO;
	}

	public DeviceTestApplyDAO getDeviceTestApplyDAO() {
		return deviceTestApplyDAO;
	}

	public void setDeviceTestApplyDAO(DeviceTestApplyDAO deviceTestApplyDAO) {
		this.deviceTestApplyDAO = deviceTestApplyDAO;
	}

	public ApplyDeviceDAO getApplyDeviceDAO() {
		return applyDeviceDAO;
	}

	public void setApplyDeviceDAO(ApplyDeviceDAO applyDeviceDAO) {
		this.applyDeviceDAO = applyDeviceDAO;
	}

	public DeviceApplyAuditDAO getDeviceApplyAuditDAO() {
		return deviceApplyAuditDAO;
	}

	public void setDeviceApplyAuditDAO(DeviceApplyAuditDAO deviceApplyAuditDAO) {
		this.deviceApplyAuditDAO = deviceApplyAuditDAO;
	}
	/**
	 * 添加一个设备检测申请信息
	 * @param deviceTestApply：申请信息
	 * @param selectedDve：申请包含的设备编号，多个设备编号用"," 作为分隔符
	 * @return
	 */
	public String addApply(DeviceTestApply deviceTestApply, String selectedDve) {
		String applyId = UUID.randomUUID().toString();
		deviceTestApply.setApplyId(applyId);
//		deviceTestApply.setApplyDate(new Date());
		deviceTestApplyDAO.insertSelective(deviceTestApply);
		
		String[] ids = selectedDve.trim().split(",");
		ApplyDevice applyDevice = new ApplyDevice();
		applyDevice.setApplyId(deviceTestApply.getApplyId());
		for (int i = 0; i < ids.length; i++) {
			applyDevice.setId(UUID.randomUUID().toString());
			applyDevice.setDeviceId(ids[i]);
			applyDeviceDAO.insertSelective(applyDevice);
		}
		return applyId;
	}
	 /**
	  * 修改设备检测申请，具体过程如下：
	  * 1、修改设备检测申请基本信息；
	  * 2、向NT_APPLY_DEVICE表中添加新增加的设备信息；
	  * 3、根据ID，从NT_APPLY_DEVICE表中删除界面中已删除的设备
	  * 4、根据DIVECE_ID，从T_DEVICE_BASE_INFO表中删除已删除的设备
	  * 
	  * @param deviceTestApply
	  * @param newChooseDve
	  * @param delExsitDve
	  * @param 
	  * @return
	  */
	public int updateApply(DeviceTestApply deviceTestApply, String newChooseDve, String delExsitDve,String delDeviceId) {
//1、修改设备检测申请基本信息；		
		deviceTestApplyDAO.updateByPrimaryKeySelective(deviceTestApply);
		
//2、向NT_APPLY_DEVICE表中添加新增加的设备信息；		
		if (newChooseDve != null && !"".equals(newChooseDve)) {
			String[] ids = newChooseDve.trim().split(",");
			ApplyDevice applyDevice = new ApplyDevice();
			applyDevice.setApplyId(deviceTestApply.getApplyId());
			for (int i = 0; i < ids.length; i++) {
				applyDevice.setId(UUID.randomUUID().toString());
				String id = ids[i];
				if (id.trim().equals("")) 
					continue;
				applyDevice.setDeviceId(ids[i]);
				applyDeviceDAO.insertSelective(applyDevice);
			}
		}
//3、根据ID，从NT_APPLY_DEVICE表中删除界面中已删除的设备
		if (delExsitDve != null && !"".equals(delExsitDve)) {
			String[] ids2 = delExsitDve.trim().split(",");
			for (int j = 0; j < ids2.length; j++) {
				
				applyDeviceDAO.deleteByPrimaryKey(ids2[j]);
			}
		}
		
//4、根据DIVECE_ID，从T_DEVICE_BASE_INFO表中删除已删除的设备
		if (delDeviceId != null && !"".equals(delDeviceId)) {
			String[] deviceIds = delDeviceId.trim().split(",");
			for (int j = 0; j < deviceIds.length; j++) {
				System.out.println(deviceIds[j]);
				deviceBaseInfoDAO.deleteByPrimaryKey(deviceIds[j]);
			}
		}
		
		return 10;
	}
	/**
	 * 根据申请编号删除申请表信息
	 * @param applyId
	 * @return
	 */
	public int delApply(String applyId){
		int res = 0;
		res = this.deviceTestApplyDAO.deleteByPrimaryKey(applyId);
		return res;
	}
	/**
	 * 根据申请编号删除所有设备信息
	 * @param applyId
	 * @return
	 */
	public int delApplyDevices(String applyId){
		int res = 0;
		ApplyDeviceExample example =  new ApplyDeviceExample();
		ApplyDeviceExample.Criteria criteria =  example.createCriteria();
		System.out.println("applyId: "+applyId);
		criteria.andApplyIdEqualTo(applyId);
		res = applyDeviceDAO.deleteByExample(example);
		
		return res;
	}
	
	// 审核
	public int manageApply(DeviceApplyAudit info, DeviceTestApply deviceTestApply, File[] testPic,
			String[] testPicName) {
		deviceApplyAuditDAO.insertSelective(info);
		deviceTestApplyDAO.updateByPrimaryKeySelective(deviceTestApply);
		if (testPic != null && testPic.length > 0) {
			uploadPic(info.getAuditId(), testPic, testPicName);
		}
		return 10;
	}
	/**
	 * 根据申请编号删除审批信息
	 * @param applyId
	 * @return
	 */
	public int delApplyAudit(String applyId){
		int res = 0;
		
		DeviceApplyAuditExample example =  new DeviceApplyAuditExample();
		DeviceApplyAuditExample.Criteria criteria =  example.createCriteria();
		criteria.andApplyIdEqualTo(applyId);
		res = deviceApplyAuditDAO.deleteByExample(example);
		return res;
	}
	/**
	 * 
	 * @param auditId
	 * @param pic
	 * @param picName
	 */
	private void uploadPic(String auditId, File[] pic, String[] picName) {
		ApplyAuditSmj record = new ApplyAuditSmj();
		Date dt = new Date();
		for (int i = 0; i < pic.length; i++) {
			String id = UUID.randomUUID().toString();
			String fileType = picName[i].substring(picName[i].indexOf("."));
			String newFileName = id + fileType;
			FileHandler.uploadFile(pic[i], newFileName, "smj");
			record.setId(id);
			record.setSmjName(picName[i]);
			record.setAuditId(auditId);
			record.setUploadDate(dt);
			record.setSmjUrl(newFileName);
			applyAuditSmjDAO.insertSelective(record);
		}
	}

	public void saveAttach(DeviceTestApplyAttach record, File applyAttach, String applyAttachFileName) {
		String devAttachId = UUID.randomUUID().toString();
		String fileType = applyAttachFileName.substring(applyAttachFileName.indexOf("."));
		String devAttachUrl = devAttachId + fileType;
		FileHandler.uploadFile(applyAttach, devAttachUrl, "deviceAttach");

		record.setDevAttachId(devAttachId);
		record.setDevAttachUrl(devAttachUrl);
		record.setDevAttachName(applyAttachFileName);
		record.setDevAttachDate(new Date());
		record.setDevAttachType("1");
		deviceTestApplyAttachDAO.insert(record);
	}
	
	/**
	 * 删除设备申请对应的申请表附件：1、数据库对应记录		 2、磁盘对应的附件
	 * @param devAttachId
	 */
	public void deleteAttach(String devAttachId) {
		String attachUrl = deviceTestApplyAttachDAO.selectByPrimaryKey(devAttachId).getDevAttachUrl();
		FileHandler.deleteFile(attachUrl, "deviceAttach");
		deviceTestApplyAttachDAO.deleteByPrimaryKey(devAttachId);
	}
	/**
	 * 根据applyId删除对应的附件
	 * @param applyId
	 */
	public int deleteAttachByApplyId(String applyId){
		int res = 0;
		DeviceTestApplyAttachExample example = new DeviceTestApplyAttachExample();
		
		DeviceTestApplyAttachExample.Criteria criteria = example.createCriteria();
		criteria.andDevApplyIdEqualTo(applyId);
		res = deviceTestApplyAttachDAO.deleteByExample(example);
		return res;
	}
	
	public DeviceTestApplyAttachDAO getDeviceTestApplyAttachDAO() {
		return deviceTestApplyAttachDAO;
	}

	public void setDeviceTestApplyAttachDAO(DeviceTestApplyAttachDAO deviceTestApplyAttachDAO) {
		this.deviceTestApplyAttachDAO = deviceTestApplyAttachDAO;
	}

	public int updateApply(DeviceTestApply devApply) {
		// TODO Auto-generated method stub
		return this.deviceTestApplyDAO.updateByPrimaryKeySelective(devApply);
	}

}
