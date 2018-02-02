package com.tyust.dao.device;

import com.tyust.bean.device.ApplyDevice;
import com.tyust.bean.device.ApplyDeviceExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class ApplyDeviceDAOImpl extends SqlMapClientDaoSupport implements ApplyDeviceDAO {

    /**
     * NT_APPLY_DEVICE ApplyDeviceDAOImpl
     */
    public ApplyDeviceDAOImpl() {
        super();
    }

    /**
     * NT_APPLY_DEVICE countByExample
     */
    public int countByExample(ApplyDeviceExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("NT_APPLY_DEVICE.countByExample", example);
        return count;
    }

    /**
     * NT_APPLY_DEVICE deleteByExample
     */
    public int deleteByExample(ApplyDeviceExample example) {
        int rows = getSqlMapClientTemplate().delete("NT_APPLY_DEVICE.deleteByExample", example);
        return rows;
    }

    /**
     * NT_APPLY_DEVICE deleteByPrimaryKey
     */
    public int deleteByPrimaryKey(String id) {
        ApplyDevice _key = new ApplyDevice();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("NT_APPLY_DEVICE.deleteByPrimaryKey", _key);
        return rows;
    }

    /**
     * NT_APPLY_DEVICE insert
     */
    public void insert(ApplyDevice record) {
        getSqlMapClientTemplate().insert("NT_APPLY_DEVICE.insert", record);
    }

    /**
     * NT_APPLY_DEVICE insertSelective
     */
    public void insertSelective(ApplyDevice record) {
        getSqlMapClientTemplate().insert("NT_APPLY_DEVICE.insertSelective", record);
    }

    /**
     * NT_APPLY_DEVICE selectByExample
     */
    @SuppressWarnings("unchecked")
    public List<ApplyDevice> selectByExample(ApplyDeviceExample example) {
        List<ApplyDevice> list = getSqlMapClientTemplate().queryForList("NT_APPLY_DEVICE.selectByExample", example);
        return list;
    }

    /**
     * NT_APPLY_DEVICE selectByPrimaryKey
     */
    public ApplyDevice selectByPrimaryKey(String id) {
        ApplyDevice _key = new ApplyDevice();
        _key.setId(id);
        ApplyDevice record = (ApplyDevice) getSqlMapClientTemplate().queryForObject("NT_APPLY_DEVICE.selectByPrimaryKey", _key);
        return record;
    }

    /**
     * NT_APPLY_DEVICE updateByExampleSelective
     */
    public int updateByExampleSelective(ApplyDevice record, ApplyDeviceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_APPLY_DEVICE.updateByExampleSelective", parms);
        return rows;
    }

    /**
     * NT_APPLY_DEVICE updateByExample
     */
    public int updateByExample(ApplyDevice record, ApplyDeviceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_APPLY_DEVICE.updateByExample", parms);
        return rows;
    }

    /**
     * NT_APPLY_DEVICE updateByPrimaryKeySelective
     */
    public int updateByPrimaryKeySelective(ApplyDevice record) {
        int rows = getSqlMapClientTemplate().update("NT_APPLY_DEVICE.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * NT_APPLY_DEVICE updateByPrimaryKey
     */
    public int updateByPrimaryKey(ApplyDevice record) {
        int rows = getSqlMapClientTemplate().update("NT_APPLY_DEVICE.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * NT_APPLY_DEVICE
     */
    protected static class UpdateByExampleParms extends ApplyDeviceExample {
        private Object record;

        public UpdateByExampleParms(Object record, ApplyDeviceExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}