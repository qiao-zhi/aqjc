package com.tyust.dao.device;

import com.tyust.bean.device.DeviceTestApply;
import com.tyust.bean.device.DeviceTestApplyExample;
import java.util.List;

public interface DeviceTestApplyDAO {
    /**
     * NT_DEVICE_TEST_APPLY countByExample
     */
    int countByExample(DeviceTestApplyExample example);

    /**
     * NT_DEVICE_TEST_APPLY deleteByExample
     */
    int deleteByExample(DeviceTestApplyExample example);

    /**
     * NT_DEVICE_TEST_APPLY deleteByPrimaryKey
     */
    int deleteByPrimaryKey(String applyId);

    /**
     * NT_DEVICE_TEST_APPLY insert
     */
    void insert(DeviceTestApply record);

    /**
     * NT_DEVICE_TEST_APPLY insertSelective
     */
    void insertSelective(DeviceTestApply record);

    /**
     * NT_DEVICE_TEST_APPLY selectByExample
     */
    List<DeviceTestApply> selectByExample(DeviceTestApplyExample example);

    /**
     * NT_DEVICE_TEST_APPLY selectByPrimaryKey
     */
    DeviceTestApply selectByPrimaryKey(String applyId);

    /**
     * NT_DEVICE_TEST_APPLY updateByExampleSelective
     */
    int updateByExampleSelective(DeviceTestApply record, DeviceTestApplyExample example);

    /**
     * NT_DEVICE_TEST_APPLY updateByExample
     */
    int updateByExample(DeviceTestApply record, DeviceTestApplyExample example);

    /**
     * NT_DEVICE_TEST_APPLY updateByPrimaryKeySelective
     */
    int updateByPrimaryKeySelective(DeviceTestApply record);

    /**
     * NT_DEVICE_TEST_APPLY updateByPrimaryKey
     */
    int updateByPrimaryKey(DeviceTestApply record);
    
    List<DeviceTestApply> selectByUnit(DeviceTestApplyExample example);
    
    int countByExampleAll(DeviceTestApplyExample example);
    
    DeviceTestApply selectById(String applyId);
    /*
     * 用于统计单位设备检测申请的个数
     * */
    int countByExampleAllApplies(DeviceTestApplyExample example);
}