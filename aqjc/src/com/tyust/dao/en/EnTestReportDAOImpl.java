package com.tyust.dao.en;

import com.tyust.bean.en.EnTestReport;
import com.tyust.bean.en.EnTestReportExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EnTestReportDAOImpl extends SqlMapClientDaoSupport implements EnTestReportDAO {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_TEST_REPORT
     *
     * @ibatorgenerated
     */
    public EnTestReportDAOImpl() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_TEST_REPORT
     *
     * @ibatorgenerated
     */
    public int countByExample(EnTestReportExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("ENVIRONMENT_TEST_REPORT.ibatorgenerated_countByExample", example);
        return count;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_TEST_REPORT
     *
     * @ibatorgenerated
     */
    public int deleteByExample(EnTestReportExample example) {
        int rows = getSqlMapClientTemplate().delete("ENVIRONMENT_TEST_REPORT.ibatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_TEST_REPORT
     *
     * @ibatorgenerated
     */
    public int deleteByPrimaryKey(String environmentTestReportId) {
        EnTestReport key = new EnTestReport();
        key.setEnvironmentTestReportId(environmentTestReportId);
        int rows = getSqlMapClientTemplate().delete("ENVIRONMENT_TEST_REPORT.ibatorgenerated_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_TEST_REPORT
     *
     * @ibatorgenerated
     */
    public void insert(EnTestReport record) {
        getSqlMapClientTemplate().insert("ENVIRONMENT_TEST_REPORT.ibatorgenerated_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_TEST_REPORT
     *
     * @ibatorgenerated
     */
    public void insertSelective(EnTestReport record) {
        getSqlMapClientTemplate().insert("ENVIRONMENT_TEST_REPORT.ibatorgenerated_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_TEST_REPORT
     *
     * @ibatorgenerated
     */
    @SuppressWarnings("unchecked")
    public List<EnTestReport> selectByExample(EnTestReportExample example) {
        List<EnTestReport> list = getSqlMapClientTemplate().queryForList("ENVIRONMENT_TEST_REPORT.ibatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_TEST_REPORT
     *
     * @ibatorgenerated
     */
    public EnTestReport selectByPrimaryKey(String environmentTestReportId) {
        EnTestReport key = new EnTestReport();
        key.setEnvironmentTestReportId(environmentTestReportId);
        EnTestReport record = (EnTestReport) getSqlMapClientTemplate().queryForObject("ENVIRONMENT_TEST_REPORT.ibatorgenerated_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_TEST_REPORT
     *
     * @ibatorgenerated
     */
    public int updateByExampleSelective(EnTestReport record, EnTestReportExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ENVIRONMENT_TEST_REPORT.ibatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_TEST_REPORT
     *
     * @ibatorgenerated
     */
    public int updateByExample(EnTestReport record, EnTestReportExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("ENVIRONMENT_TEST_REPORT.ibatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_TEST_REPORT
     *
     * @ibatorgenerated
     */
    public int updateByPrimaryKeySelective(EnTestReport record) {
        int rows = getSqlMapClientTemplate().update("ENVIRONMENT_TEST_REPORT.ibatorgenerated_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_TEST_REPORT
     *
     * @ibatorgenerated
     */
    public int updateByPrimaryKey(EnTestReport record) {
        int rows = getSqlMapClientTemplate().update("ENVIRONMENT_TEST_REPORT.ibatorgenerated_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table ENVIRONMENT_TEST_REPORT
     *
     * @ibatorgenerated
     */
    private static class UpdateByExampleParms extends EnTestReportExample {
        private Object record;

        public UpdateByExampleParms(Object record, EnTestReportExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}