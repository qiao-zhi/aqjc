package com.tyust.dao.pbs;

import com.tyust.bean.pbs.PbsApplyInfo;
import com.tyust.bean.pbs.PbsApplyInfoExample;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class PbsApplyInfoDAOImpl extends SqlMapClientDaoSupport implements PbsApplyInfoDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    public PbsApplyInfoDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    public int countByExample(PbsApplyInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("PBS_APPLY_INFO.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    public int deleteByExample(PbsApplyInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("PBS_APPLY_INFO.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    public int deleteByPrimaryKey(String pbsApplyId) {
        PbsApplyInfo key = new PbsApplyInfo();
        key.setPbsApplyId(pbsApplyId);
        int rows = getSqlMapClientTemplate().delete("PBS_APPLY_INFO.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    public void insert(PbsApplyInfo record) {
        getSqlMapClientTemplate().insert("PBS_APPLY_INFO.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    public void insertSelective(PbsApplyInfo record) {
        getSqlMapClientTemplate().insert("PBS_APPLY_INFO.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    @SuppressWarnings("unchecked")
    public List<PbsApplyInfo> selectByExample(PbsApplyInfoExample example) {
        List<PbsApplyInfo> list = getSqlMapClientTemplate().queryForList("PBS_APPLY_INFO.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    public PbsApplyInfo selectByPrimaryKey(String pbsApplyId) {
        PbsApplyInfo key = new PbsApplyInfo();
        key.setPbsApplyId(pbsApplyId);
        PbsApplyInfo record = (PbsApplyInfo) getSqlMapClientTemplate().queryForObject("PBS_APPLY_INFO.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    public int updateByExampleSelective(PbsApplyInfo record, PbsApplyInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("PBS_APPLY_INFO.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    public int updateByExample(PbsApplyInfo record, PbsApplyInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("PBS_APPLY_INFO.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    public int updateByPrimaryKeySelective(PbsApplyInfo record) {
        int rows = getSqlMapClientTemplate().update("PBS_APPLY_INFO.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    public int updateByPrimaryKey(PbsApplyInfo record) {
        int rows = getSqlMapClientTemplate().update("PBS_APPLY_INFO.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    private static class UpdateByExampleParms extends PbsApplyInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, PbsApplyInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }

	
}