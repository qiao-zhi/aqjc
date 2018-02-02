package com.tyust.dao.pbs;

import com.tyust.bean.pbs.PbsDevice;
import com.tyust.bean.pbs.PbsDeviceExample;
import java.util.List;

public interface PbsDeviceDAO {
    /**
     * NT_PBS_DEVICE countByExample
     */
    int countByExample(PbsDeviceExample example);

    /**
     * NT_PBS_DEVICE deleteByExample
     */
    int deleteByExample(PbsDeviceExample example);

    /**
     * NT_PBS_DEVICE deleteByPrimaryKey
     */
    int deleteByPrimaryKey(String id);

    /**
     * NT_PBS_DEVICE insert
     */
    void insert(PbsDevice record);

    /**
     * NT_PBS_DEVICE insertSelective
     */
    void insertSelective(PbsDevice record);

    /**
     * NT_PBS_DEVICE selectByExample
     */
    List<PbsDevice> selectByExample(PbsDeviceExample example);

    /**
     * NT_PBS_DEVICE selectByPrimaryKey
     */
    PbsDevice selectByPrimaryKey(String id);

    /**
     * NT_PBS_DEVICE updateByExampleSelective
     */
    int updateByExampleSelective(PbsDevice record, PbsDeviceExample example);

    /**
     * NT_PBS_DEVICE updateByExample
     */
    int updateByExample(PbsDevice record, PbsDeviceExample example);

    /**
     * NT_PBS_DEVICE updateByPrimaryKeySelective
     */
    int updateByPrimaryKeySelective(PbsDevice record);

    /**
     * NT_PBS_DEVICE updateByPrimaryKey
     */
    int updateByPrimaryKey(PbsDevice record);
}