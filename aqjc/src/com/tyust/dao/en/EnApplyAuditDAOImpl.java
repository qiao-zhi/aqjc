package com.tyust.dao.en;

import com.tyust.bean.en.EnApplyAudit;
import com.tyust.bean.en.EnApplyAuditExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EnApplyAuditDAOImpl extends SqlMapClientDaoSupport implements EnApplyAuditDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_APPLY_AUDIT
     *
     * @ibatorgenerated
     */
    public EnApplyAuditDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_APPLY_AUDIT
     *
     * @ibatorgenerated
     */
    public int countByExample(EnApplyAuditExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("ENVIRONMENT_APPLY_AUDIT.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_APPLY_AUDIT
     *
     * @ibatorgenerated
     */
    public int deleteByExample(EnApplyAuditExample example) {
        int rows = getSqlMapClientTemplate().delete("ENVIRONMENT_APPLY_AUDIT.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_APPLY_AUDIT
     *
     * @ibatorgenerated
     */
    public void insert(EnApplyAudit record) {
        getSqlMapClientTemplate().insert("ENVIRONMENT_APPLY_AUDIT.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_APPLY_AUDIT
     *
     * @ibatorgenerated
     */
    public void insertSelective(EnApplyAudit record) {
        getSqlMapClientTemplate().insert("ENVIRONMENT_APPLY_AUDIT.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_APPLY_AUDIT
     *
     * @ibatorgenerated
     */
    @SuppressWarnings("unchecked")
    public List<EnApplyAudit> selectByExample(EnApplyAuditExample example) {
        List<EnApplyAudit> list = getSqlMapClientTemplate().queryForList("ENVIRONMENT_APPLY_AUDIT.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_APPLY_AUDIT
     *
     * @ibatorgenerated
     */
    public int updateByExampleSelective(EnApplyAudit record, EnApplyAuditExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ENVIRONMENT_APPLY_AUDIT.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_APPLY_AUDIT
     *
     * @ibatorgenerated
     */
    public int updateByExample(EnApplyAudit record, EnApplyAuditExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ENVIRONMENT_APPLY_AUDIT.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table ENVIRONMENT_APPLY_AUDIT
     *
     * @ibatorgenerated
     */
    private static class UpdateByExampleParms extends EnApplyAuditExample {
        private Object record;

        public UpdateByExampleParms(Object record, EnApplyAuditExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}