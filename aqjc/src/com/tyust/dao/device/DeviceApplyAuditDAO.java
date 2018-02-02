package com.tyust.dao.device;

import com.tyust.bean.device.DeviceApplyAudit;
import com.tyust.bean.device.DeviceApplyAuditExample;
import java.util.List;

public interface DeviceApplyAuditDAO {
    /**
     * NT_DEVICE_APPLY_AUDIT countByExample
     */
    int countByExample(DeviceApplyAuditExample example);

    /**
     * NT_DEVICE_APPLY_AUDIT deleteByExample
     */
    int deleteByExample(DeviceApplyAuditExample example);

    /**
     * NT_DEVICE_APPLY_AUDIT deleteByPrimaryKey
     */
    int deleteByPrimaryKey(String auditId);

    /**
     * NT_DEVICE_APPLY_AUDIT insert
     */
    void insert(DeviceApplyAudit record);

    /**
     * NT_DEVICE_APPLY_AUDIT insertSelective
     */
    void insertSelective(DeviceApplyAudit record);

    /**
     * NT_DEVICE_APPLY_AUDIT selectByExample
     */
    List<DeviceApplyAudit> selectByExample(DeviceApplyAuditExample example);

    /**
     * NT_DEVICE_APPLY_AUDIT selectByPrimaryKey
     */
    DeviceApplyAudit selectByPrimaryKey(String auditId);

    /**
     * NT_DEVICE_APPLY_AUDIT updateByExampleSelective
     */
    int updateByExampleSelective(DeviceApplyAudit record, DeviceApplyAuditExample example);

    /**
     * NT_DEVICE_APPLY_AUDIT updateByExample
     */
    int updateByExample(DeviceApplyAudit record, DeviceApplyAuditExample example);

    /**
     * NT_DEVICE_APPLY_AUDIT updateByPrimaryKeySelective
     */
    int updateByPrimaryKeySelective(DeviceApplyAudit record);

    /**
     * NT_DEVICE_APPLY_AUDIT updateByPrimaryKey
     */
    int updateByPrimaryKey(DeviceApplyAudit record);
    
    DeviceApplyAudit selNewAuditInfo(String applyId);
}