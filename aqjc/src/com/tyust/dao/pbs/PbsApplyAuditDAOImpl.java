package com.tyust.dao.pbs;

import com.tyust.bean.pbs.PbsApplyAudit;
import com.tyust.bean.pbs.PbsApplyAuditExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class PbsApplyAuditDAOImpl extends SqlMapClientDaoSupport implements PbsApplyAuditDAO {

    /**
     * NT_PBS_APPLY_AUDIT PbsApplyAuditDAOImpl
     */
    public PbsApplyAuditDAOImpl() {
        super();
    }

    /**
     * NT_PBS_APPLY_AUDIT countByExample
     */
    public int countByExample(PbsApplyAuditExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("NT_PBS_APPLY_AUDIT.countByExample", example);
        return count;
    }

    /**
     * NT_PBS_APPLY_AUDIT deleteByExample
     */
    public int deleteByExample(PbsApplyAuditExample example) {
        int rows = getSqlMapClientTemplate().delete("NT_PBS_APPLY_AUDIT.deleteByExample", example);
        return rows;
    }

    /**
     * NT_PBS_APPLY_AUDIT deleteByPrimaryKey
     */
    public int deleteByPrimaryKey(String auditId) {
        PbsApplyAudit _key = new PbsApplyAudit();
        _key.setAuditId(auditId);
        int rows = getSqlMapClientTemplate().delete("NT_PBS_APPLY_AUDIT.deleteByPrimaryKey", _key);
        return rows;
    }

    /**
     * NT_PBS_APPLY_AUDIT insert
     */
    public void insert(PbsApplyAudit record) {
        getSqlMapClientTemplate().insert("NT_PBS_APPLY_AUDIT.insert", record);
    }

    /**
     * NT_PBS_APPLY_AUDIT insertSelective
     */
    public void insertSelective(PbsApplyAudit record) {
        getSqlMapClientTemplate().insert("NT_PBS_APPLY_AUDIT.insertSelective", record);
    }

    /**
     * NT_PBS_APPLY_AUDIT selectByExample
     */
    @SuppressWarnings("unchecked")
    public List<PbsApplyAudit> selectByExample(PbsApplyAuditExample example) {
        List<PbsApplyAudit> list = getSqlMapClientTemplate().queryForList("NT_PBS_APPLY_AUDIT.selectByExample", example);
        return list;
    }

    /**
     * NT_PBS_APPLY_AUDIT selectByPrimaryKey
     */
    public PbsApplyAudit selectByPrimaryKey(String auditId) {
        PbsApplyAudit _key = new PbsApplyAudit();
        _key.setAuditId(auditId);
        PbsApplyAudit record = (PbsApplyAudit) getSqlMapClientTemplate().queryForObject("NT_PBS_APPLY_AUDIT.selectByPrimaryKey", _key);
        return record;
    }

    /**
     * NT_PBS_APPLY_AUDIT updateByExampleSelective
     */
    public int updateByExampleSelective(PbsApplyAudit record, PbsApplyAuditExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_PBS_APPLY_AUDIT.updateByExampleSelective", parms);
        return rows;
    }

    /**
     * NT_PBS_APPLY_AUDIT updateByExample
     */
    public int updateByExample(PbsApplyAudit record, PbsApplyAuditExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_PBS_APPLY_AUDIT.updateByExample", parms);
        return rows;
    }

    /**
     * NT_PBS_APPLY_AUDIT updateByPrimaryKeySelective
     */
    public int updateByPrimaryKeySelective(PbsApplyAudit record) {
        int rows = getSqlMapClientTemplate().update("NT_PBS_APPLY_AUDIT.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * NT_PBS_APPLY_AUDIT updateByPrimaryKey
     */
    public int updateByPrimaryKey(PbsApplyAudit record) {
        int rows = getSqlMapClientTemplate().update("NT_PBS_APPLY_AUDIT.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * NT_PBS_APPLY_AUDIT
     */
    protected static class UpdateByExampleParms extends PbsApplyAuditExample {
        private Object record;

        public UpdateByExampleParms(Object record, PbsApplyAuditExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
    public PbsApplyAudit selNewAuditInfo(String appId){
   	 	PbsApplyAudit record = (PbsApplyAudit) getSqlMapClientTemplate().queryForObject("NT_PBS_APPLY_AUDIT.selNewAuditInfo", appId);
        return record;
   }
}