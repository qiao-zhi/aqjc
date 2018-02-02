package com.tyust.service.app;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang.xwork.StringUtils;

import com.tyust.bean.app.DeviceBaseInfo;
import com.tyust.bean.app.DeviceBaseInfoExample;
import com.tyust.bean.app.InstrumentInfo;
import com.tyust.bean.user.TBaseUserInfo;
import com.tyust.dao.app.DeviceBaseInfoDAO;
import com.tyust.dao.app.InstrumentInfoDAO;
import com.tyust.dao.app.ReportInstrumentDAO;
import com.tyust.dao.device.ApplyDeviceDAO;

/**
 * 
 * 
 * 类名称：DeviceTestService
 * 类描述：
 * 创建人：章霞光
 * 修改人：章霞光
 * 修改时间：2014-8-18 下午03:06:21
 * 修改备注：
 * @version 1.0.0
 *
 */
public class TestService {
	private DeviceBaseInfoDAO deviceBaseInfoDAO;
	private InstrumentInfoDAO instrumentInfoDAO;
	private ReportInstrumentDAO reportInstrumentDAO;
	private ApplyDeviceDAO applyDeviceDAO;
	
	public ReportInstrumentDAO getReportInstrumentDAO() {
		return reportInstrumentDAO;
	}
	public void setReportInstrumentDAO(ReportInstrumentDAO reportInstrumentDAO) {
		this.reportInstrumentDAO = reportInstrumentDAO;
	}
	public ApplyDeviceDAO getApplyDeviceDAO() {
		return applyDeviceDAO;
	}
	public void setApplyDeviceDAO(ApplyDeviceDAO applyDeviceDAO) {
		this.applyDeviceDAO = applyDeviceDAO;
	}
	public InstrumentInfoDAO getInstrumentInfoDAO() {
		return instrumentInfoDAO;
	}
	public void setInstrumentInfoDAO(InstrumentInfoDAO instrumentInfoDAO) {
		this.instrumentInfoDAO = instrumentInfoDAO;
	}
	public DeviceBaseInfoDAO getDeviceBaseInfoDAO() {
		return deviceBaseInfoDAO;
	}
	public void setDeviceBaseInfoDAO(DeviceBaseInfoDAO deviceBaseInfoDAO) {
		this.deviceBaseInfoDAO = deviceBaseInfoDAO;
	}
	
	/**
	 * 保存设备信息
	 */
	public String manageSaveDeviceInfo(DeviceBaseInfo deviceBaseInfo,TBaseUserInfo user) {
//		deviceBaseInfo.setUnitId(user.getUnitId());
//		deviceBaseInfo.setUnitName(user.getUnitName());
		if(StringUtils.isNotEmpty(deviceBaseInfo.getDeviceId())){
			deviceBaseInfoDAO.updateByPrimaryKeySelective(deviceBaseInfo);
		}else{
			deviceBaseInfo.setDeviceId(UUID.randomUUID().toString());
			deviceBaseInfoDAO.insertSelective(deviceBaseInfo);
		}
		return deviceBaseInfo.getDeviceId();
	}
	
	/**
	 * 删除设备信息
	 */
	public int manageDelDeviceInfo(String deviceIds) {
		String[] ids=deviceIds.trim().split(","); 
		for(int i=0;i<ids.length;i++){
			deviceBaseInfoDAO.deleteByPrimaryKey(ids[i]);
		}
		return 10;
	}
	/**
	 * 删除申请的所属的设备信息
	 * @param applyId
	 * @return
	 */
	public int manageDelDevInfoByApplyId(String applyId){
		int res = 0;
		
		res = deviceBaseInfoDAO.delApplyDve(applyId);
		return res;
	}
	/**
	 * 
	 * manageEditDeviceTestState(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param testIds type
	 * @return 
	 *int
	 * @exception 
	 * @since  1.0.0
	 * type:10 添加  --加入
	 * 		20：添加--删除
	 * 		30：修改--加入
	 * 		40：修改--删除
	 */
	public int manageEditDeviceState(String deviceIds,String type,String testId) {
		String[] ids=deviceIds.trim().split(","); 
		for(int i=0;i<ids.length;i++){
			DeviceBaseInfo record = new DeviceBaseInfo();
			record.setDeviceId(ids[i]);
//			if("10".equals(type)){
//				record.setState("1");
//			}else if("20".equals(type)){
//				record.setState("0");
//			}else if("30".equals(type)){
//				record.setState("1");
//				record.setTestId(testId);
//			}else if("40".equals(type)){
//				record.setState("0");
//				record.setTestId(null);
//			}
			deviceBaseInfoDAO.updateByPrimaryKeySelective(record);
		}
		return 10;
	}
	
	public int saveInstrument(InstrumentInfo instrumentInfo,String operate){
		int res = 0;
		if("add".equals(operate)){
			instrumentInfo.setInstrumentId(UUID.randomUUID().toString());
			instrumentInfoDAO.insertSelective(instrumentInfo);
			res = 1;
		}
		if("upd".equals(operate)){
			instrumentInfoDAO.updateByPrimaryKeySelective(instrumentInfo);
			res = 2;
		}
		return res;
	} 
	
	public int delInstrument(String idsStr) {
		String[] ids=idsStr.trim().split(","); 
		for(int i=0;i<ids.length;i++){
			instrumentInfoDAO.deleteByPrimaryKey(ids[i]);
		}
		return 10;
	}
}
