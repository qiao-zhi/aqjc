package com.tyust.dao.device;

import com.tyust.bean.device.DeviceApplyAudit;
import com.tyust.bean.device.DeviceApplyAuditExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DeviceApplyAuditDAOImpl extends SqlMapClientDaoSupport implements DeviceApplyAuditDAO {

    /**
     * NT_DEVICE_APPLY_AUDIT DeviceApplyAuditDAOImpl
     */
    public DeviceApplyAuditDAOImpl() {
        super();
    }

    /**
     * NT_DEVICE_APPLY_AUDIT countByExample
     */
    public int countByExample(DeviceApplyAuditExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("NT_DEVICE_APPLY_AUDIT.countByExample", example);
        return count;
    }

    /**
     * NT_DEVICE_APPLY_AUDIT deleteByExample
     */
    public int deleteByExample(DeviceApplyAuditExample example) {
        int rows = getSqlMapClientTemplate().delete("NT_DEVICE_APPLY_AUDIT.deleteByExample", example);
        return rows;
    }

    /**
     * NT_DEVICE_APPLY_AUDIT deleteByPrimaryKey
     */
    public int deleteByPrimaryKey(String auditId) {
        DeviceApplyAudit _key = new DeviceApplyAudit();
        _key.setAuditId(auditId);
        int rows = getSqlMapClientTemplate().delete("NT_DEVICE_APPLY_AUDIT.deleteByPrimaryKey", _key);
        return rows;
    }

    /**
     * NT_DEVICE_APPLY_AUDIT insert
     */
    public void insert(DeviceApplyAudit record) {
        getSqlMapClientTemplate().insert("NT_DEVICE_APPLY_AUDIT.insert", record);
    }

    /**
     * NT_DEVICE_APPLY_AUDIT insertSelective
     */
    public void insertSelective(DeviceApplyAudit record) {
        getSqlMapClientTemplate().insert("NT_DEVICE_APPLY_AUDIT.insertSelective", record);
    }

    /**
     * NT_DEVICE_APPLY_AUDIT selectByExample
     */
    @SuppressWarnings("unchecked")
    public List<DeviceApplyAudit> selectByExample(DeviceApplyAuditExample example) {
        List<DeviceApplyAudit> list = getSqlMapClientTemplate().queryForList("NT_DEVICE_APPLY_AUDIT.selectByExample", example);
        return list;
    }

    /**
     * NT_DEVICE_APPLY_AUDIT selectByPrimaryKey
     */
    public DeviceApplyAudit selectByPrimaryKey(String auditId) {
        DeviceApplyAudit _key = new DeviceApplyAudit();
        _key.setAuditId(auditId);
        DeviceApplyAudit record = (DeviceApplyAudit) getSqlMapClientTemplate().queryForObject("NT_DEVICE_APPLY_AUDIT.selectByPrimaryKey", _key);
        return record;
    }

    /**
     * NT_DEVICE_APPLY_AUDIT updateByExampleSelective
     */
    public int updateByExampleSelective(DeviceApplyAudit record, DeviceApplyAuditExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_DEVICE_APPLY_AUDIT.updateByExampleSelective", parms);
        return rows;
    }

    /**
     * NT_DEVICE_APPLY_AUDIT updateByExample
     */
    public int updateByExample(DeviceApplyAudit record, DeviceApplyAuditExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_DEVICE_APPLY_AUDIT.updateByExample", parms);
        return rows;
    }

    /**
     * NT_DEVICE_APPLY_AUDIT updateByPrimaryKeySelective
     */
    public int updateByPrimaryKeySelective(DeviceApplyAudit record) {
        int rows = getSqlMapClientTemplate().update("NT_DEVICE_APPLY_AUDIT.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * NT_DEVICE_APPLY_AUDIT updateByPrimaryKey
     */
    public int updateByPrimaryKey(DeviceApplyAudit record) {
        int rows = getSqlMapClientTemplate().update("NT_DEVICE_APPLY_AUDIT.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * NT_DEVICE_APPLY_AUDIT
     */
    protected static class UpdateByExampleParms extends DeviceApplyAuditExample {
        private Object record;

        public UpdateByExampleParms(Object record, DeviceApplyAuditExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
    public DeviceApplyAudit selNewAuditInfo(String applyId){
    	DeviceApplyAudit record = (DeviceApplyAudit) getSqlMapClientTemplate().queryForObject("NT_DEVICE_APPLY_AUDIT.selNewAuditInfo", applyId);
        return record;
    }
}