package com.tyust.dao.device;

import com.tyust.bean.device.DeviceTestApply;
import com.tyust.bean.device.DeviceTestApplyExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DeviceTestApplyDAOImpl extends SqlMapClientDaoSupport implements DeviceTestApplyDAO {

    /**
     * NT_DEVICE_TEST_APPLY DeviceTestApplyDAOImpl
     */
    public DeviceTestApplyDAOImpl() {
        super();
    }

    /**
     * NT_DEVICE_TEST_APPLY countByExample
     */
    public int countByExample(DeviceTestApplyExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("NT_DEVICE_TEST_APPLY.countByExample", example);
        return count;
    }

    /**
     * NT_DEVICE_TEST_APPLY deleteByExample
     */
    public int deleteByExample(DeviceTestApplyExample example) {
        int rows = getSqlMapClientTemplate().delete("NT_DEVICE_TEST_APPLY.deleteByExample", example);
        return rows;
    }

    /**
     * NT_DEVICE_TEST_APPLY deleteByPrimaryKey
     */
    public int deleteByPrimaryKey(String applyId) {
        DeviceTestApply _key = new DeviceTestApply();
        _key.setApplyId(applyId);
        int rows = getSqlMapClientTemplate().delete("NT_DEVICE_TEST_APPLY.deleteByPrimaryKey", _key);
        return rows;
    }

    /**
     * NT_DEVICE_TEST_APPLY insert
     */
    public void insert(DeviceTestApply record) {
        getSqlMapClientTemplate().insert("NT_DEVICE_TEST_APPLY.insert", record);
    }

    /**
     * NT_DEVICE_TEST_APPLY insertSelective
     */
    public void insertSelective(DeviceTestApply record) {
        getSqlMapClientTemplate().insert("NT_DEVICE_TEST_APPLY.insertSelective", record);
    }

    /**
     * NT_DEVICE_TEST_APPLY selectByExample
     */
    @SuppressWarnings("unchecked")
    public List<DeviceTestApply> selectByExample(DeviceTestApplyExample example) {
        List<DeviceTestApply> list = getSqlMapClientTemplate().queryForList("NT_DEVICE_TEST_APPLY.selectByExample", example);
        return list;
    }

    /**
     * NT_DEVICE_TEST_APPLY selectByPrimaryKey
     */
    public DeviceTestApply selectByPrimaryKey(String applyId) {
        DeviceTestApply _key = new DeviceTestApply();
        _key.setApplyId(applyId);
        DeviceTestApply record = (DeviceTestApply) getSqlMapClientTemplate().queryForObject("NT_DEVICE_TEST_APPLY.selectByPrimaryKey", _key);
        return record;
    }

    /**
     * NT_DEVICE_TEST_APPLY updateByExampleSelective
     */
    public int updateByExampleSelective(DeviceTestApply record, DeviceTestApplyExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_DEVICE_TEST_APPLY.updateByExampleSelective", parms);
        return rows;
    }

    /**
     * NT_DEVICE_TEST_APPLY updateByExample
     */
    public int updateByExample(DeviceTestApply record, DeviceTestApplyExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_DEVICE_TEST_APPLY.updateByExample", parms);
        return rows;
    }

    /**
     * NT_DEVICE_TEST_APPLY updateByPrimaryKeySelective
     */
    public int updateByPrimaryKeySelective(DeviceTestApply record) {
        int rows = getSqlMapClientTemplate().update("NT_DEVICE_TEST_APPLY.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * NT_DEVICE_TEST_APPLY updateByPrimaryKey
     */
    public int updateByPrimaryKey(DeviceTestApply record) {
        int rows = getSqlMapClientTemplate().update("NT_DEVICE_TEST_APPLY.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * NT_DEVICE_TEST_APPLY
     */
    protected static class UpdateByExampleParms extends DeviceTestApplyExample {
        private Object record;

        public UpdateByExampleParms(Object record, DeviceTestApplyExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
    public List<DeviceTestApply> selectByUnit(DeviceTestApplyExample example){
    	 List<DeviceTestApply> list = getSqlMapClientTemplate().queryForList("NT_DEVICE_TEST_APPLY.selectByUnit", example);
         return list;
    }
    /*
     * 根据申请状态，统计所有已提交的设备检测申请的个数【申请查看】
     * */
    public int countByExampleAll(DeviceTestApplyExample example){
    	 Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("NT_DEVICE_TEST_APPLY.countByExampleAll", example);
         return count;
    }

	@Override
	public DeviceTestApply selectById(String applyId) {
		 DeviceTestApply _key = new DeviceTestApply();
	        _key.setApplyId(applyId);
	        DeviceTestApply record = (DeviceTestApply) getSqlMapClientTemplate().queryForObject("NT_DEVICE_TEST_APPLY.selectById", _key);
	        return record;
	}
/*
 * 用于统计单位申请的设备检测申请个数：【查看申请】
 */
	@Override
	public int countByExampleAllApplies(DeviceTestApplyExample example) {
		// TODO Auto-generated method stub
		Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("NT_DEVICE_TEST_APPLY.countByExampleNew", example);
        return count;
	}
}