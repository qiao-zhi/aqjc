package com.tyust.dao.app;

import com.tyust.bean.app.TestReportPic;
import com.tyust.bean.app.TestReportPicExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class TestReportPicDAOImpl extends SqlMapClientDaoSupport implements TestReportPicDAO {

    /**
     * NT_TEST_REPORT_PIC TestReportPicDAOImpl
     */
    public TestReportPicDAOImpl() {
        super();
    }

    /**
     * NT_TEST_REPORT_PIC countByExample
     */
    public int countByExample(TestReportPicExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("NT_TEST_REPORT_PIC.countByExample", example);
        return count;
    }

    /**
     * NT_TEST_REPORT_PIC deleteByExample
     */
    public int deleteByExample(TestReportPicExample example) {
        int rows = getSqlMapClientTemplate().delete("NT_TEST_REPORT_PIC.deleteByExample", example);
        return rows;
    }

    /**
     * NT_TEST_REPORT_PIC deleteByPrimaryKey
     */
    public int deleteByPrimaryKey(String picId) {
        TestReportPic _key = new TestReportPic();
        _key.setPicId(picId);
        int rows = getSqlMapClientTemplate().delete("NT_TEST_REPORT_PIC.deleteByPrimaryKey", _key);
        return rows;
    }

    /**
     * NT_TEST_REPORT_PIC insert
     */
    public void insert(TestReportPic record) {
        getSqlMapClientTemplate().insert("NT_TEST_REPORT_PIC.insert", record);
    }

    /**
     * NT_TEST_REPORT_PIC insertSelective
     */
    public void insertSelective(TestReportPic record) {
        getSqlMapClientTemplate().insert("NT_TEST_REPORT_PIC.insertSelective", record);
    }

    /**
     * NT_TEST_REPORT_PIC selectByExample
     */
    @SuppressWarnings("unchecked")
    public List<TestReportPic> selectByExample(TestReportPicExample example) {
        List<TestReportPic> list = getSqlMapClientTemplate().queryForList("NT_TEST_REPORT_PIC.selectByExample", example);
        return list;
    }

    /**
     * NT_TEST_REPORT_PIC selectByPrimaryKey
     */
    public TestReportPic selectByPrimaryKey(String picId) {
        TestReportPic _key = new TestReportPic();
        _key.setPicId(picId);
        TestReportPic record = (TestReportPic) getSqlMapClientTemplate().queryForObject("NT_TEST_REPORT_PIC.selectByPrimaryKey", _key);
        return record;
    }

    /**
     * NT_TEST_REPORT_PIC updateByExampleSelective
     */
    public int updateByExampleSelective(TestReportPic record, TestReportPicExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_TEST_REPORT_PIC.updateByExampleSelective", parms);
        return rows;
    }

    /**
     * NT_TEST_REPORT_PIC updateByExample
     */
    public int updateByExample(TestReportPic record, TestReportPicExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_TEST_REPORT_PIC.updateByExample", parms);
        return rows;
    }

    /**
     * NT_TEST_REPORT_PIC updateByPrimaryKeySelective
     */
    public int updateByPrimaryKeySelective(TestReportPic record) {
        int rows = getSqlMapClientTemplate().update("NT_TEST_REPORT_PIC.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * NT_TEST_REPORT_PIC updateByPrimaryKey
     */
    public int updateByPrimaryKey(TestReportPic record) {
        int rows = getSqlMapClientTemplate().update("NT_TEST_REPORT_PIC.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * NT_TEST_REPORT_PIC
     */
    protected static class UpdateByExampleParms extends TestReportPicExample {
        private Object record;

        public UpdateByExampleParms(Object record, TestReportPicExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}