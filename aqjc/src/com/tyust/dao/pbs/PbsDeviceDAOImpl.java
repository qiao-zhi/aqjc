package com.tyust.dao.pbs;

import com.tyust.bean.pbs.PbsDevice;
import com.tyust.bean.pbs.PbsDeviceExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class PbsDeviceDAOImpl extends SqlMapClientDaoSupport implements PbsDeviceDAO {

    /**
     * NT_PBS_DEVICE PbsDeviceDAOImpl
     */
    public PbsDeviceDAOImpl() {
        super();
    }

    /**
     * NT_PBS_DEVICE countByExample
     */
    public int countByExample(PbsDeviceExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("NT_PBS_DEVICE.countByExample", example);
        return count;
    }

    /**
     * NT_PBS_DEVICE deleteByExample
     */
    public int deleteByExample(PbsDeviceExample example) {
        int rows = getSqlMapClientTemplate().delete("NT_PBS_DEVICE.deleteByExample", example);
        return rows;
    }

    /**
     * NT_PBS_DEVICE deleteByPrimaryKey
     */
    public int deleteByPrimaryKey(String id) {
        PbsDevice _key = new PbsDevice();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("NT_PBS_DEVICE.deleteByPrimaryKey", _key);
        return rows;
    }

    /**
     * NT_PBS_DEVICE insert
     */
    public void insert(PbsDevice record) {
        getSqlMapClientTemplate().insert("NT_PBS_DEVICE.insert", record);
    }

    /**
     * NT_PBS_DEVICE insertSelective
     */
    public void insertSelective(PbsDevice record) {
        getSqlMapClientTemplate().insert("NT_PBS_DEVICE.insertSelective", record);
    }

    /**
     * NT_PBS_DEVICE selectByExample
     */
    @SuppressWarnings("unchecked")
    public List<PbsDevice> selectByExample(PbsDeviceExample example) {
        List<PbsDevice> list = getSqlMapClientTemplate().queryForList("NT_PBS_DEVICE.selectByExample", example);
        return list;
    }

    /**
     * NT_PBS_DEVICE selectByPrimaryKey
     */
    public PbsDevice selectByPrimaryKey(String id) {
        PbsDevice _key = new PbsDevice();
        _key.setId(id);
        PbsDevice record = (PbsDevice) getSqlMapClientTemplate().queryForObject("NT_PBS_DEVICE.selectByPrimaryKey", _key);
        return record;
    }

    /**
     * NT_PBS_DEVICE updateByExampleSelective
     */
    public int updateByExampleSelective(PbsDevice record, PbsDeviceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_PBS_DEVICE.updateByExampleSelective", parms);
        return rows;
    }

    /**
     * NT_PBS_DEVICE updateByExample
     */
    public int updateByExample(PbsDevice record, PbsDeviceExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_PBS_DEVICE.updateByExample", parms);
        return rows;
    }

    /**
     * NT_PBS_DEVICE updateByPrimaryKeySelective
     */
    public int updateByPrimaryKeySelective(PbsDevice record) {
        int rows = getSqlMapClientTemplate().update("NT_PBS_DEVICE.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * NT_PBS_DEVICE updateByPrimaryKey
     */
    public int updateByPrimaryKey(PbsDevice record) {
        int rows = getSqlMapClientTemplate().update("NT_PBS_DEVICE.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * NT_PBS_DEVICE
     */
    protected static class UpdateByExampleParms extends PbsDeviceExample {
        private Object record;

        public UpdateByExampleParms(Object record, PbsDeviceExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}