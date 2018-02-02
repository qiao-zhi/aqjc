package com.tyust.dao.pbs;

import com.tyust.bean.pbs.PbsBaseInfo;
import com.tyust.bean.pbs.PbsBaseInfoExample;
import java.util.List;

public interface PbsBaseInfoDAO {
    /**
     * NT_PBS_BASE_INFO countByExample
     */
    int countByExample(PbsBaseInfoExample example);

    /**
     * NT_PBS_BASE_INFO deleteByExample
     */
    int deleteByExample(PbsBaseInfoExample example);

    /**
     * NT_PBS_BASE_INFO deleteByPrimaryKey
     */
    int deleteByPrimaryKey(String pbsId);

    /**
     * NT_PBS_BASE_INFO insert
     */
    void insert(PbsBaseInfo record);

    /**
     * NT_PBS_BASE_INFO insertSelective
     */
    void insertSelective(PbsBaseInfo record);

    /**
     * NT_PBS_BASE_INFO selectByExample
     */
    List<PbsBaseInfo> selectByExample(PbsBaseInfoExample example);

    /**
     * NT_PBS_BASE_INFO selectByPrimaryKey
     */
    PbsBaseInfo selectByPrimaryKey(String pbsId);

    /**
     * NT_PBS_BASE_INFO updateByExampleSelective
     */
    int updateByExampleSelective(PbsBaseInfo record, PbsBaseInfoExample example);

    /**
     * NT_PBS_BASE_INFO updateByExample
     */
    int updateByExample(PbsBaseInfo record, PbsBaseInfoExample example);

    /**
     * NT_PBS_BASE_INFO updateByPrimaryKeySelective
     */
    int updateByPrimaryKeySelective(PbsBaseInfo record);

    /**
     * NT_PBS_BASE_INFO updateByPrimaryKey
     */
    int updateByPrimaryKey(PbsBaseInfo record);
}