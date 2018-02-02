package com.tyust.dao.app;

import com.tyust.bean.app.DeviceBaseInfo;
import com.tyust.bean.app.DeviceBaseInfoExample;
import java.util.List;

public interface DeviceBaseInfoDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table T_DEVICE_BASE_INFO
     *
     * @ibatorgenerated
     */
    int countByExample(DeviceBaseInfoExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table T_DEVICE_BASE_INFO
     *
     * @ibatorgenerated
     */
    int deleteByExample(DeviceBaseInfoExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table T_DEVICE_BASE_INFO
     *
     * @ibatorgenerated
     */
    int deleteByPrimaryKey(String deviceId);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table T_DEVICE_BASE_INFO
     *
     * @ibatorgenerated
     */
    void insert(DeviceBaseInfo record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table T_DEVICE_BASE_INFO
     *
     * @ibatorgenerated
     */
    void insertSelective(DeviceBaseInfo record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table T_DEVICE_BASE_INFO
     *
     * @ibatorgenerated
     */
    List<DeviceBaseInfo> selectByExample(DeviceBaseInfoExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table T_DEVICE_BASE_INFO
     *
     * @ibatorgenerated
     */
    DeviceBaseInfo selectByPrimaryKey(String deviceId);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table T_DEVICE_BASE_INFO
     *
     * @ibatorgenerated
     */
    int updateByExampleSelective(DeviceBaseInfo record, DeviceBaseInfoExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table T_DEVICE_BASE_INFO
     *
     * @ibatorgenerated
     */
    int updateByExample(DeviceBaseInfo record, DeviceBaseInfoExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table T_DEVICE_BASE_INFO
     *
     * @ibatorgenerated
     */
    int updateByPrimaryKeySelective(DeviceBaseInfo record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table T_DEVICE_BASE_INFO
     *
     * @ibatorgenerated
     */
    int updateByPrimaryKey(DeviceBaseInfo record);
    
    public List<DeviceBaseInfo> selApplyDve(String applyId);
    public int delApplyDve(String applyId);
    
    public List<DeviceBaseInfo> selDevice(DeviceBaseInfo device);
    public int countDevice(DeviceBaseInfo device);
    
}