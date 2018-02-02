package com.tyust.dao.pbs;

import com.tyust.bean.pbs.PbsBaseInfo;
import com.tyust.bean.pbs.PbsBaseInfoExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class PbsBaseInfoDAOImpl extends SqlMapClientDaoSupport implements PbsBaseInfoDAO {

    /**
     * NT_PBS_BASE_INFO PbsBaseInfoDAOImpl
     */
    public PbsBaseInfoDAOImpl() {
        super();
    }

    /**
     * NT_PBS_BASE_INFO countByExample
     */
    public int countByExample(PbsBaseInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("NT_PBS_BASE_INFO.countByExample", example);
        return count;
    }

    /**
     * NT_PBS_BASE_INFO deleteByExample
     */
    public int deleteByExample(PbsBaseInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("NT_PBS_BASE_INFO.deleteByExample", example);
        return rows;
    }

    /**
     * NT_PBS_BASE_INFO deleteByPrimaryKey
     */
    public int deleteByPrimaryKey(String pbsId) {
        PbsBaseInfo _key = new PbsBaseInfo();
        _key.setPbsId(pbsId);
        int rows = getSqlMapClientTemplate().delete("NT_PBS_BASE_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    /**
     * NT_PBS_BASE_INFO insert
     */
    public void insert(PbsBaseInfo record) {
        getSqlMapClientTemplate().insert("NT_PBS_BASE_INFO.insert", record);
    }

    /**
     * NT_PBS_BASE_INFO insertSelective
     */
    public void insertSelective(PbsBaseInfo record) {
        getSqlMapClientTemplate().insert("NT_PBS_BASE_INFO.insertSelective", record);
    }

    /**
     * NT_PBS_BASE_INFO selectByExample
     */
    @SuppressWarnings("unchecked")
    public List<PbsBaseInfo> selectByExample(PbsBaseInfoExample example) {
        List<PbsBaseInfo> list = getSqlMapClientTemplate().queryForList("NT_PBS_BASE_INFO.selectByExample", example);
        return list;
    }

    /**
     * NT_PBS_BASE_INFO selectByPrimaryKey
     */
    public PbsBaseInfo selectByPrimaryKey(String pbsId) {
        PbsBaseInfo _key = new PbsBaseInfo();
        _key.setPbsId(pbsId);
        PbsBaseInfo record = (PbsBaseInfo) getSqlMapClientTemplate().queryForObject("NT_PBS_BASE_INFO.selectByPrimaryKey", _key);
        return record;
    }

    /**
     * NT_PBS_BASE_INFO updateByExampleSelective
     */
    public int updateByExampleSelective(PbsBaseInfo record, PbsBaseInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_PBS_BASE_INFO.updateByExampleSelective", parms);
        return rows;
    }

    /**
     * NT_PBS_BASE_INFO updateByExample
     */
    public int updateByExample(PbsBaseInfo record, PbsBaseInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_PBS_BASE_INFO.updateByExample", parms);
        return rows;
    }

    /**
     * NT_PBS_BASE_INFO updateByPrimaryKeySelective
     */
    public int updateByPrimaryKeySelective(PbsBaseInfo record) {
        int rows = getSqlMapClientTemplate().update("NT_PBS_BASE_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * NT_PBS_BASE_INFO updateByPrimaryKey
     */
    public int updateByPrimaryKey(PbsBaseInfo record) {
        int rows = getSqlMapClientTemplate().update("NT_PBS_BASE_INFO.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * NT_PBS_BASE_INFO
     */
    protected static class UpdateByExampleParms extends PbsBaseInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, PbsBaseInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}