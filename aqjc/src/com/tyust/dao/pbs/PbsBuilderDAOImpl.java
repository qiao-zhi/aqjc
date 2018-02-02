package com.tyust.dao.pbs;

import com.tyust.bean.pbs.PbsBuilder;
import com.tyust.bean.pbs.PbsBuilderExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class PbsBuilderDAOImpl extends SqlMapClientDaoSupport implements PbsBuilderDAO {

    /**
     * NT_PBS_BUILDER PbsBuilderDAOImpl
     */
    public PbsBuilderDAOImpl() {
        super();
    }

    /**
     * NT_PBS_BUILDER countByExample
     */
    public int countByExample(PbsBuilderExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("NT_PBS_BUILDER.countByExample", example);
        return count;
    }

    /**
     * NT_PBS_BUILDER deleteByExample
     */
    public int deleteByExample(PbsBuilderExample example) {
        int rows = getSqlMapClientTemplate().delete("NT_PBS_BUILDER.deleteByExample", example);
        return rows;
    }

    /**
     * NT_PBS_BUILDER deleteByPrimaryKey
     */
    public int deleteByPrimaryKey(String id) {
        PbsBuilder _key = new PbsBuilder();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("NT_PBS_BUILDER.deleteByPrimaryKey", _key);
        return rows;
    }

    /**
     * NT_PBS_BUILDER insert
     */
    public void insert(PbsBuilder record) {
        getSqlMapClientTemplate().insert("NT_PBS_BUILDER.insert", record);
    }

    /**
     * NT_PBS_BUILDER insertSelective
     */
    public void insertSelective(PbsBuilder record) {
        getSqlMapClientTemplate().insert("NT_PBS_BUILDER.insertSelective", record);
    }

    /**
     * NT_PBS_BUILDER selectByExample
     */
    @SuppressWarnings("unchecked")
    public List<PbsBuilder> selectByExample(PbsBuilderExample example) {
        List<PbsBuilder> list = getSqlMapClientTemplate().queryForList("NT_PBS_BUILDER.selectByExample", example);
        return list;
    }

    /**
     * NT_PBS_BUILDER selectByPrimaryKey
     */
    public PbsBuilder selectByPrimaryKey(String id) {
        PbsBuilder _key = new PbsBuilder();
        _key.setId(id);
        PbsBuilder record = (PbsBuilder) getSqlMapClientTemplate().queryForObject("NT_PBS_BUILDER.selectByPrimaryKey", _key);
        return record;
    }

    /**
     * NT_PBS_BUILDER updateByExampleSelective
     */
    public int updateByExampleSelective(PbsBuilder record, PbsBuilderExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_PBS_BUILDER.updateByExampleSelective", parms);
        return rows;
    }

    /**
     * NT_PBS_BUILDER updateByExample
     */
    public int updateByExample(PbsBuilder record, PbsBuilderExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_PBS_BUILDER.updateByExample", parms);
        return rows;
    }

    /**
     * NT_PBS_BUILDER updateByPrimaryKeySelective
     */
    public int updateByPrimaryKeySelective(PbsBuilder record) {
        int rows = getSqlMapClientTemplate().update("NT_PBS_BUILDER.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * NT_PBS_BUILDER updateByPrimaryKey
     */
    public int updateByPrimaryKey(PbsBuilder record) {
        int rows = getSqlMapClientTemplate().update("NT_PBS_BUILDER.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * NT_PBS_BUILDER
     */
    protected static class UpdateByExampleParms extends PbsBuilderExample {
        private Object record;

        public UpdateByExampleParms(Object record, PbsBuilderExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}