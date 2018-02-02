package com.tyust.dao.pbs;

import com.tyust.bean.pbs.PbsTestApply;
import com.tyust.bean.pbs.PbsTestApplyExample;
import java.util.List;

public interface PbsTestApplyDAO {
    /**
     * NT_PBS_TEST_APPLY countByExample
     */
    int countByExample(PbsTestApplyExample example);

    /**
     * NT_PBS_TEST_APPLY deleteByExample
     */
    int deleteByExample(PbsTestApplyExample example);

    /**
     * NT_PBS_TEST_APPLY deleteByPrimaryKey
     */
    int deleteByPrimaryKey(String testApplyId);

    /**
     * NT_PBS_TEST_APPLY insert
     */
    void insert(PbsTestApply record);

    /**
     * NT_PBS_TEST_APPLY insertSelective
     */
    void insertSelective(PbsTestApply record);

    /**
     * NT_PBS_TEST_APPLY selectByExample
     */
    List<PbsTestApply> selectByExample(PbsTestApplyExample example);

    /**
     * NT_PBS_TEST_APPLY selectByPrimaryKey
     */
    PbsTestApply selectByPrimaryKey(String testApplyId);

    /**
     * NT_PBS_TEST_APPLY updateByExampleSelective
     */
    int updateByExampleSelective(PbsTestApply record, PbsTestApplyExample example);

    /**
     * NT_PBS_TEST_APPLY updateByExample
     */
    int updateByExample(PbsTestApply record, PbsTestApplyExample example);

    /**
     * NT_PBS_TEST_APPLY updateByPrimaryKeySelective
     */
    int updateByPrimaryKeySelective(PbsTestApply record);

    /**
     * NT_PBS_TEST_APPLY updateByPrimaryKey
     */
    int updateByPrimaryKey(PbsTestApply record);
    
    List<PbsTestApply> selSubList(PbsTestApplyExample example);
}