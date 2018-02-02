package com.tyust.dao.pbs;

import com.tyust.bean.pbs.PbsBuilder;
import com.tyust.bean.pbs.PbsBuilderExample;
import java.util.List;

public interface PbsBuilderDAO {
    /**
     * NT_PBS_BUILDER countByExample
     */
    int countByExample(PbsBuilderExample example);

    /**
     * NT_PBS_BUILDER deleteByExample
     */
    int deleteByExample(PbsBuilderExample example);

    /**
     * NT_PBS_BUILDER deleteByPrimaryKey
     */
    int deleteByPrimaryKey(String id);

    /**
     * NT_PBS_BUILDER insert
     */
    void insert(PbsBuilder record);

    /**
     * NT_PBS_BUILDER insertSelective
     */
    void insertSelective(PbsBuilder record);

    /**
     * NT_PBS_BUILDER selectByExample
     */
    List<PbsBuilder> selectByExample(PbsBuilderExample example);

    /**
     * NT_PBS_BUILDER selectByPrimaryKey
     */
    PbsBuilder selectByPrimaryKey(String id);

    /**
     * NT_PBS_BUILDER updateByExampleSelective
     */
    int updateByExampleSelective(PbsBuilder record, PbsBuilderExample example);

    /**
     * NT_PBS_BUILDER updateByExample
     */
    int updateByExample(PbsBuilder record, PbsBuilderExample example);

    /**
     * NT_PBS_BUILDER updateByPrimaryKeySelective
     */
    int updateByPrimaryKeySelective(PbsBuilder record);

    /**
     * NT_PBS_BUILDER updateByPrimaryKey
     */
    int updateByPrimaryKey(PbsBuilder record);
}