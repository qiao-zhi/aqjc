package com.tyust.dao.device;

import com.tyust.bean.device.DeviceTestReport;
import com.tyust.bean.device.DeviceTestReportExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DeviceTestReportDAOImpl extends SqlMapClientDaoSupport implements DeviceTestReportDAO {

    /**
     * NT_DEVICE_TEST_REPORT DeviceTestReportDAOImpl
     */
    public DeviceTestReportDAOImpl() {
        super();
    }

    /**
     * NT_DEVICE_TEST_REPORT countByExample
     */
    public int countByExample(DeviceTestReportExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("NT_DEVICE_TEST_REPORT.countByExample", example);
        return count;
    }

    public int countByExample2(DeviceTestReportExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("NT_DEVICE_TEST_REPORT.countByExample2", example);
        return count;
    }
    
    /**
     * NT_DEVICE_TEST_REPORT deleteByExample
     */
    public int deleteByExample(DeviceTestReportExample example) {
        int rows = getSqlMapClientTemplate().delete("NT_DEVICE_TEST_REPORT.deleteByExample", example);
        return rows;
    }

    /**
     * NT_DEVICE_TEST_REPORT deleteByPrimaryKey
     */
    public int deleteByPrimaryKey(String reportId) {
        DeviceTestReport _key = new DeviceTestReport();
        _key.setReportId(reportId);
        int rows = getSqlMapClientTemplate().delete("NT_DEVICE_TEST_REPORT.deleteByPrimaryKey", _key);
        return rows;
    }

    /**
     * NT_DEVICE_TEST_REPORT insert
     */
    public void insert(DeviceTestReport record) {
        getSqlMapClientTemplate().insert("NT_DEVICE_TEST_REPORT.insert", record);
    }

    /**
     * NT_DEVICE_TEST_REPORT insertSelective
     */
    public void insertSelective(DeviceTestReport record) {
        getSqlMapClientTemplate().insert("NT_DEVICE_TEST_REPORT.insertSelective", record);
    }

    /**
     * NT_DEVICE_TEST_REPORT selectByExample
     */
    @SuppressWarnings("unchecked")
    public List<DeviceTestReport> selectByExample(DeviceTestReportExample example) {
        List<DeviceTestReport> list = getSqlMapClientTemplate().queryForList("NT_DEVICE_TEST_REPORT.selectByExample", example);
        return list;
    }

    /**
     * NT_DEVICE_TEST_REPORT selectByPrimaryKey
     */
    public DeviceTestReport selectByPrimaryKey(String reportId) {
        DeviceTestReport _key = new DeviceTestReport();
        _key.setReportId(reportId);
        DeviceTestReport record = (DeviceTestReport) getSqlMapClientTemplate().queryForObject("NT_DEVICE_TEST_REPORT.selectByPrimaryKey", _key);
        return record;
    }

    /**
     * NT_DEVICE_TEST_REPORT updateByExampleSelective
     */
    public int updateByExampleSelective(DeviceTestReport record, DeviceTestReportExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_DEVICE_TEST_REPORT.updateByExampleSelective", parms);
        return rows;
    }

    /**
     * NT_DEVICE_TEST_REPORT updateByExample
     */
    public int updateByExample(DeviceTestReport record, DeviceTestReportExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_DEVICE_TEST_REPORT.updateByExample", parms);
        return rows;
    }

    /**
     * NT_DEVICE_TEST_REPORT updateByPrimaryKeySelective
     */
    public int updateByPrimaryKeySelective(DeviceTestReport record) {
        int rows = getSqlMapClientTemplate().update("NT_DEVICE_TEST_REPORT.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * NT_DEVICE_TEST_REPORT updateByPrimaryKey
     */
    public int updateByPrimaryKey(DeviceTestReport record) {
        int rows = getSqlMapClientTemplate().update("NT_DEVICE_TEST_REPORT.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * NT_DEVICE_TEST_REPORT
     */
    protected static class UpdateByExampleParms extends DeviceTestReportExample {
        private Object record;

        public UpdateByExampleParms(Object record, DeviceTestReportExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
    public String selMaxCode (String year){
    	String num = (String)  getSqlMapClientTemplate().queryForObject("NT_DEVICE_TEST_REPORT.selMaxCode", year);
        return num;
    }
    
    public String selectRptIdByApplyId(String applyId){
    	System.out.println("My applyId:"+applyId);
    	Object o = getSqlMapClientTemplate().queryForObject("NT_DEVICE_TEST_REPORT.selectRptIdByApplyId", applyId);
    	System.out.println(o);
        return o == null? "":(String)o;
    }
}