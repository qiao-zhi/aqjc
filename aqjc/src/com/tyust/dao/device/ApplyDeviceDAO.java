package com.tyust.dao.device;

import com.tyust.bean.device.ApplyDevice;
import com.tyust.bean.device.ApplyDeviceExample;
import java.util.List;

public interface ApplyDeviceDAO {
    /**
     * NT_APPLY_DEVICE countByExample
     */
    int countByExample(ApplyDeviceExample example);

    /**
     * NT_APPLY_DEVICE deleteByExample
     */
    int deleteByExample(ApplyDeviceExample example);

    /**
     * NT_APPLY_DEVICE deleteByPrimaryKey
     */
    int deleteByPrimaryKey(String id);

    /**
     * NT_APPLY_DEVICE insert
     */
    void insert(ApplyDevice record);

    /**
     * NT_APPLY_DEVICE insertSelective
     */
    void insertSelective(ApplyDevice record);

    /**
     * NT_APPLY_DEVICE selectByExample
     */
    List<ApplyDevice> selectByExample(ApplyDeviceExample example);

    /**
     * NT_APPLY_DEVICE selectByPrimaryKey
     */
    ApplyDevice selectByPrimaryKey(String id);

    /**
     * NT_APPLY_DEVICE updateByExampleSelective
     */
    int updateByExampleSelective(ApplyDevice record, ApplyDeviceExample example);

    /**
     * NT_APPLY_DEVICE updateByExample
     */
    int updateByExample(ApplyDevice record, ApplyDeviceExample example);

    /**
     * NT_APPLY_DEVICE updateByPrimaryKeySelective
     */
    int updateByPrimaryKeySelective(ApplyDevice record);

    /**
     * NT_APPLY_DEVICE updateByPrimaryKey
     */
    int updateByPrimaryKey(ApplyDevice record);
}