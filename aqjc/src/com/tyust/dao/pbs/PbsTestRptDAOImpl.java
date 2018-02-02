package com.tyust.dao.pbs;

import com.tyust.bean.pbs.PbsTestRpt;
import com.tyust.bean.pbs.PbsTestRptExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class PbsTestRptDAOImpl extends SqlMapClientDaoSupport implements PbsTestRptDAO {

    /**
     * NT_PBS_TEST_RPT PbsTestRptDAOImpl
     */
    public PbsTestRptDAOImpl() {
        super();
    }

    /**
     * NT_PBS_TEST_RPT countByExample
     */
    public int countByExample(PbsTestRptExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("NT_PBS_TEST_RPT.countByExample", example);
        return count;
    }

    /**
     * NT_PBS_TEST_RPT deleteByExample
     */
    public int deleteByExample(PbsTestRptExample example) {
        int rows = getSqlMapClientTemplate().delete("NT_PBS_TEST_RPT.deleteByExample", example);
        return rows;
    }

    /**
     * NT_PBS_TEST_RPT deleteByPrimaryKey
     */
    public int deleteByPrimaryKey(String testRptId) {
        PbsTestRpt _key = new PbsTestRpt();
        _key.setTestRptId(testRptId);
        int rows = getSqlMapClientTemplate().delete("NT_PBS_TEST_RPT.deleteByPrimaryKey", _key);
        return rows;
    }

    /**
     * NT_PBS_TEST_RPT insert
     */
    public void insert(PbsTestRpt record) {
        getSqlMapClientTemplate().insert("NT_PBS_TEST_RPT.insert", record);
    }

    /**
     * NT_PBS_TEST_RPT insertSelective
     */
    public void insertSelective(PbsTestRpt record) {
        getSqlMapClientTemplate().insert("NT_PBS_TEST_RPT.insertSelective", record);
    }

    /**
     * NT_PBS_TEST_RPT selectByExample
     */
    @SuppressWarnings("unchecked")
    public List<PbsTestRpt> selectByExample(PbsTestRptExample example) {
        List<PbsTestRpt> list = getSqlMapClientTemplate().queryForList("NT_PBS_TEST_RPT.selectByExample", example);
        return list;
    }

    /**
     * NT_PBS_TEST_RPT selectByPrimaryKey
     */
    public PbsTestRpt selectByPrimaryKey(String testRptId) {
        PbsTestRpt _key = new PbsTestRpt();
        _key.setTestRptId(testRptId);
        PbsTestRpt record = (PbsTestRpt) getSqlMapClientTemplate().queryForObject("NT_PBS_TEST_RPT.selectByPrimaryKey", _key);
        return record;
    }

    /**
     * NT_PBS_TEST_RPT updateByExampleSelective
     */
    public int updateByExampleSelective(PbsTestRpt record, PbsTestRptExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_PBS_TEST_RPT.updateByExampleSelective", parms);
        return rows;
    }

    /**
     * NT_PBS_TEST_RPT updateByExample
     */
    public int updateByExample(PbsTestRpt record, PbsTestRptExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_PBS_TEST_RPT.updateByExample", parms);
        return rows;
    }

    /**
     * NT_PBS_TEST_RPT updateByPrimaryKeySelective
     */
    public int updateByPrimaryKeySelective(PbsTestRpt record) {
        int rows = getSqlMapClientTemplate().update("NT_PBS_TEST_RPT.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * NT_PBS_TEST_RPT updateByPrimaryKey
     */
    public int updateByPrimaryKey(PbsTestRpt record) {
        int rows = getSqlMapClientTemplate().update("NT_PBS_TEST_RPT.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * NT_PBS_TEST_RPT
     */
    protected static class UpdateByExampleParms extends PbsTestRptExample {
        private Object record;

        public UpdateByExampleParms(Object record, PbsTestRptExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}