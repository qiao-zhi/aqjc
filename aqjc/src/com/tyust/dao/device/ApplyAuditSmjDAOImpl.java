package com.tyust.dao.device;

import com.tyust.bean.device.ApplyAuditSmj;
import com.tyust.bean.device.ApplyAuditSmjExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class ApplyAuditSmjDAOImpl extends SqlMapClientDaoSupport implements ApplyAuditSmjDAO {

    /**
     * NT_APPLY_AUDIT_SMJ ApplyAuditSmjDAOImpl
     */
    public ApplyAuditSmjDAOImpl() {
        super();
    }

    /**
     * NT_APPLY_AUDIT_SMJ countByExample
     */
    public int countByExample(ApplyAuditSmjExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("NT_APPLY_AUDIT_SMJ.countByExample", example);
        return count;
    }

    /**
     * NT_APPLY_AUDIT_SMJ deleteByExample
     */
    public int deleteByExample(ApplyAuditSmjExample example) {
        int rows = getSqlMapClientTemplate().delete("NT_APPLY_AUDIT_SMJ.deleteByExample", example);
        return rows;
    }

    /**
     * NT_APPLY_AUDIT_SMJ deleteByPrimaryKey
     */
    public int deleteByPrimaryKey(String id) {
        ApplyAuditSmj _key = new ApplyAuditSmj();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("NT_APPLY_AUDIT_SMJ.deleteByPrimaryKey", _key);
        return rows;
    }

    /**
     * NT_APPLY_AUDIT_SMJ insert
     */
    public void insert(ApplyAuditSmj record) {
        getSqlMapClientTemplate().insert("NT_APPLY_AUDIT_SMJ.insert", record);
    }

    /**
     * NT_APPLY_AUDIT_SMJ insertSelective
     */
    public void insertSelective(ApplyAuditSmj record) {
        getSqlMapClientTemplate().insert("NT_APPLY_AUDIT_SMJ.insertSelective", record);
    }

    /**
     * NT_APPLY_AUDIT_SMJ selectByExample
     */
    @SuppressWarnings("unchecked")
    public List<ApplyAuditSmj> selectByExample(ApplyAuditSmjExample example) {
        List<ApplyAuditSmj> list = getSqlMapClientTemplate().queryForList("NT_APPLY_AUDIT_SMJ.selectByExample", example);
        return list;
    }

    /**
     * NT_APPLY_AUDIT_SMJ selectByPrimaryKey
     */
    public ApplyAuditSmj selectByPrimaryKey(String id) {
        ApplyAuditSmj _key = new ApplyAuditSmj();
        _key.setId(id);
        ApplyAuditSmj record = (ApplyAuditSmj) getSqlMapClientTemplate().queryForObject("NT_APPLY_AUDIT_SMJ.selectByPrimaryKey", _key);
        return record;
    }

    /**
     * NT_APPLY_AUDIT_SMJ updateByExampleSelective
     */
    public int updateByExampleSelective(ApplyAuditSmj record, ApplyAuditSmjExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_APPLY_AUDIT_SMJ.updateByExampleSelective", parms);
        return rows;
    }

    /**
     * NT_APPLY_AUDIT_SMJ updateByExample
     */
    public int updateByExample(ApplyAuditSmj record, ApplyAuditSmjExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_APPLY_AUDIT_SMJ.updateByExample", parms);
        return rows;
    }

    /**
     * NT_APPLY_AUDIT_SMJ updateByPrimaryKeySelective
     */
    public int updateByPrimaryKeySelective(ApplyAuditSmj record) {
        int rows = getSqlMapClientTemplate().update("NT_APPLY_AUDIT_SMJ.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * NT_APPLY_AUDIT_SMJ updateByPrimaryKey
     */
    public int updateByPrimaryKey(ApplyAuditSmj record) {
        int rows = getSqlMapClientTemplate().update("NT_APPLY_AUDIT_SMJ.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * NT_APPLY_AUDIT_SMJ
     */
    protected static class UpdateByExampleParms extends ApplyAuditSmjExample {
        private Object record;

        public UpdateByExampleParms(Object record, ApplyAuditSmjExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}