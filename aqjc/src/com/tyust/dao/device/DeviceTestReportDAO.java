package com.tyust.dao.device;

import com.tyust.bean.device.DeviceTestReport;
import com.tyust.bean.device.DeviceTestReportExample;

import java.util.List;

public interface DeviceTestReportDAO {
    /**
     * NT_DEVICE_TEST_REPORT countByExample
     */
    int countByExample(DeviceTestReportExample example);
    int countByExample2(DeviceTestReportExample example);
    

    /**
     * NT_DEVICE_TEST_REPORT deleteByExample
     */
    int deleteByExample(DeviceTestReportExample example);

    /**
     * NT_DEVICE_TEST_REPORT deleteByPrimaryKey
     */
    int deleteByPrimaryKey(String reportId);

    /**
     * NT_DEVICE_TEST_REPORT insert
     */
    void insert(DeviceTestReport record);

    /**
     * NT_DEVICE_TEST_REPORT insertSelective
     */
    void insertSelective(DeviceTestReport record);

    /**
     * NT_DEVICE_TEST_REPORT selectByExample
     */
    List<DeviceTestReport> selectByExample(DeviceTestReportExample example);

    /**
     * NT_DEVICE_TEST_REPORT selectByPrimaryKey
     */
    DeviceTestReport selectByPrimaryKey(String reportId);

    /**
     * NT_DEVICE_TEST_REPORT updateByExampleSelective
     */
    int updateByExampleSelective(DeviceTestReport record, DeviceTestReportExample example);

    /**
     * NT_DEVICE_TEST_REPORT updateByExample
     */
    int updateByExample(DeviceTestReport record, DeviceTestReportExample example);

    /**
     * NT_DEVICE_TEST_REPORT updateByPrimaryKeySelective
     */
    int updateByPrimaryKeySelective(DeviceTestReport record);

    /**
     * NT_DEVICE_TEST_REPORT updateByPrimaryKey
     */
    int updateByPrimaryKey(DeviceTestReport record);
    
    String selMaxCode (String year);
    public String selectRptIdByApplyId(String applyId);
}