package com.tyust.dao.pbs;

import com.tyust.bean.pbs.PbsTestApply;
import com.tyust.bean.pbs.PbsTestApplyExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class PbsTestApplyDAOImpl extends SqlMapClientDaoSupport implements PbsTestApplyDAO {

    /**
     * NT_PBS_TEST_APPLY PbsTestApplyDAOImpl
     */
    public PbsTestApplyDAOImpl() {
        super();
    }

    /**
     * NT_PBS_TEST_APPLY countByExample
     */
    public int countByExample(PbsTestApplyExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("NT_PBS_TEST_APPLY.countByExample", example);
        return count;
    }

    /**
     * NT_PBS_TEST_APPLY deleteByExample
     */
    public int deleteByExample(PbsTestApplyExample example) {
        int rows = getSqlMapClientTemplate().delete("NT_PBS_TEST_APPLY.deleteByExample", example);
        return rows;
    }

    /**
     * NT_PBS_TEST_APPLY deleteByPrimaryKey
     */
    public int deleteByPrimaryKey(String testApplyId) {
        PbsTestApply _key = new PbsTestApply();
        _key.setTestApplyId(testApplyId);
        int rows = getSqlMapClientTemplate().delete("NT_PBS_TEST_APPLY.deleteByPrimaryKey", _key);
        return rows;
    }

    /**
     * NT_PBS_TEST_APPLY insert
     */
    public void insert(PbsTestApply record) {
        getSqlMapClientTemplate().insert("NT_PBS_TEST_APPLY.insert", record);
    }

    /**
     * NT_PBS_TEST_APPLY insertSelective
     */
    public void insertSelective(PbsTestApply record) {
        getSqlMapClientTemplate().insert("NT_PBS_TEST_APPLY.insertSelective", record);
    }

    /**
     * NT_PBS_TEST_APPLY selectByExample
     */
    @SuppressWarnings("unchecked")
    public List<PbsTestApply> selectByExample(PbsTestApplyExample example) {
        List<PbsTestApply> list = getSqlMapClientTemplate().queryForList("NT_PBS_TEST_APPLY.selectByExample", example);
        return list;
    }

    /**
     * NT_PBS_TEST_APPLY selectByPrimaryKey
     */
    public PbsTestApply selectByPrimaryKey(String testApplyId) {
        PbsTestApply _key = new PbsTestApply();
        _key.setTestApplyId(testApplyId);
        PbsTestApply record = (PbsTestApply) getSqlMapClientTemplate().queryForObject("NT_PBS_TEST_APPLY.selectByPrimaryKey", _key);
        return record;
    }

    /**
     * NT_PBS_TEST_APPLY updateByExampleSelective
     */
    public int updateByExampleSelective(PbsTestApply record, PbsTestApplyExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_PBS_TEST_APPLY.updateByExampleSelective", parms);
        return rows;
    }

    /**
     * NT_PBS_TEST_APPLY updateByExample
     */
    public int updateByExample(PbsTestApply record, PbsTestApplyExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_PBS_TEST_APPLY.updateByExample", parms);
        return rows;
    }

    /**
     * NT_PBS_TEST_APPLY updateByPrimaryKeySelective
     */
    public int updateByPrimaryKeySelective(PbsTestApply record) {
        int rows = getSqlMapClientTemplate().update("NT_PBS_TEST_APPLY.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * NT_PBS_TEST_APPLY updateByPrimaryKey
     */
    public int updateByPrimaryKey(PbsTestApply record) {
        int rows = getSqlMapClientTemplate().update("NT_PBS_TEST_APPLY.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * NT_PBS_TEST_APPLY
     */
    protected static class UpdateByExampleParms extends PbsTestApplyExample {
        private Object record;

        public UpdateByExampleParms(Object record, PbsTestApplyExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<PbsTestApply> selSubList(PbsTestApplyExample example) {
        List<PbsTestApply> list = getSqlMapClientTemplate().queryForList("NT_PBS_TEST_APPLY.selSubList", example);
        return list;
    }
}