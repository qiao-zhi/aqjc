package com.tyust.dao.app;

import com.tyust.bean.app.ReportInstrument;
import com.tyust.bean.app.ReportInstrumentExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class ReportInstrumentDAOImpl extends SqlMapClientDaoSupport implements ReportInstrumentDAO {

    /**
     * NT_REPORT_INSTRUMENT ReportInstrumentDAOImpl
     */
    public ReportInstrumentDAOImpl() {
        super();
    }

    /**
     * NT_REPORT_INSTRUMENT countByExample
     */
    public int countByExample(ReportInstrumentExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("NT_REPORT_INSTRUMENT.countByExample", example);
        return count;
    }

    /**
     * NT_REPORT_INSTRUMENT deleteByExample
     */
    public int deleteByExample(ReportInstrumentExample example) {
        int rows = getSqlMapClientTemplate().delete("NT_REPORT_INSTRUMENT.deleteByExample", example);
        return rows;
    }

    /**
     * NT_REPORT_INSTRUMENT deleteByPrimaryKey
     */
    public int deleteByPrimaryKey(String id) {
        ReportInstrument _key = new ReportInstrument();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("NT_REPORT_INSTRUMENT.deleteByPrimaryKey", _key);
        return rows;
    }

    /**
     * NT_REPORT_INSTRUMENT insert
     */
    public void insert(ReportInstrument record) {
        getSqlMapClientTemplate().insert("NT_REPORT_INSTRUMENT.insert", record);
    }

    /**
     * NT_REPORT_INSTRUMENT insertSelective
     */
    public void insertSelective(ReportInstrument record) {
        getSqlMapClientTemplate().insert("NT_REPORT_INSTRUMENT.insertSelective", record);
    }

    /**
     * NT_REPORT_INSTRUMENT selectByExample
     */
    @SuppressWarnings("unchecked")
    public List<ReportInstrument> selectByExample(ReportInstrumentExample example) {
        List<ReportInstrument> list = getSqlMapClientTemplate().queryForList("NT_REPORT_INSTRUMENT.selectByExample", example);
        return list;
    }

    /**
     * NT_REPORT_INSTRUMENT selectByPrimaryKey
     */
    public ReportInstrument selectByPrimaryKey(String id) {
        ReportInstrument _key = new ReportInstrument();
        _key.setId(id);
        ReportInstrument record = (ReportInstrument) getSqlMapClientTemplate().queryForObject("NT_REPORT_INSTRUMENT.selectByPrimaryKey", _key);
        return record;
    }

    /**
     * NT_REPORT_INSTRUMENT updateByExampleSelective
     */
    public int updateByExampleSelective(ReportInstrument record, ReportInstrumentExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_REPORT_INSTRUMENT.updateByExampleSelective", parms);
        return rows;
    }

    /**
     * NT_REPORT_INSTRUMENT updateByExample
     */
    public int updateByExample(ReportInstrument record, ReportInstrumentExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_REPORT_INSTRUMENT.updateByExample", parms);
        return rows;
    }

    /**
     * NT_REPORT_INSTRUMENT updateByPrimaryKeySelective
     */
    public int updateByPrimaryKeySelective(ReportInstrument record) {
        int rows = getSqlMapClientTemplate().update("NT_REPORT_INSTRUMENT.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * NT_REPORT_INSTRUMENT updateByPrimaryKey
     */
    public int updateByPrimaryKey(ReportInstrument record) {
        int rows = getSqlMapClientTemplate().update("NT_REPORT_INSTRUMENT.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * NT_REPORT_INSTRUMENT
     */
    protected static class UpdateByExampleParms extends ReportInstrumentExample {
        private Object record;

        public UpdateByExampleParms(Object record, ReportInstrumentExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}