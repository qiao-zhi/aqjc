package com.tyust.dao.pbs;

import com.tyust.bean.pbs.PbsTestRpt;
import com.tyust.bean.pbs.PbsTestRptExample;
import java.util.List;

public interface PbsTestRptDAO {
    /**
     * NT_PBS_TEST_RPT countByExample
     */
    int countByExample(PbsTestRptExample example);

    /**
     * NT_PBS_TEST_RPT deleteByExample
     */
    int deleteByExample(PbsTestRptExample example);

    /**
     * NT_PBS_TEST_RPT deleteByPrimaryKey
     */
    int deleteByPrimaryKey(String testRptId);

    /**
     * NT_PBS_TEST_RPT insert
     */
    void insert(PbsTestRpt record);

    /**
     * NT_PBS_TEST_RPT insertSelective
     */
    void insertSelective(PbsTestRpt record);

    /**
     * NT_PBS_TEST_RPT selectByExample
     */
    List<PbsTestRpt> selectByExample(PbsTestRptExample example);

    /**
     * NT_PBS_TEST_RPT selectByPrimaryKey
     */
    PbsTestRpt selectByPrimaryKey(String testRptId);

    /**
     * NT_PBS_TEST_RPT updateByExampleSelective
     */
    int updateByExampleSelective(PbsTestRpt record, PbsTestRptExample example);

    /**
     * NT_PBS_TEST_RPT updateByExample
     */
    int updateByExample(PbsTestRpt record, PbsTestRptExample example);

    /**
     * NT_PBS_TEST_RPT updateByPrimaryKeySelective
     */
    int updateByPrimaryKeySelective(PbsTestRpt record);

    /**
     * NT_PBS_TEST_RPT updateByPrimaryKey
     */
    int updateByPrimaryKey(PbsTestRpt record);
}