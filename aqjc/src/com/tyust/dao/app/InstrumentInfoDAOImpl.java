package com.tyust.dao.app;

import com.tyust.bean.app.InstrumentInfo;
import com.tyust.bean.app.InstrumentInfoExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class InstrumentInfoDAOImpl extends SqlMapClientDaoSupport implements InstrumentInfoDAO {

    /**
     * NT_INSTRUMENT_INFO InstrumentInfoDAOImpl
     */
    public InstrumentInfoDAOImpl() {
        super();
    }

    /**
     * NT_INSTRUMENT_INFO countByExample
     */
    public int countByExample(InstrumentInfoExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("NT_INSTRUMENT_INFO.countByExample", example);
        return count;
    }

    /**
     * NT_INSTRUMENT_INFO deleteByExample
     */
    public int deleteByExample(InstrumentInfoExample example) {
        int rows = getSqlMapClientTemplate().delete("NT_INSTRUMENT_INFO.deleteByExample", example);
        return rows;
    }

    /**
     * NT_INSTRUMENT_INFO deleteByPrimaryKey
     */
    public int deleteByPrimaryKey(String instrumentId) {
        InstrumentInfo _key = new InstrumentInfo();
        _key.setInstrumentId(instrumentId);
        int rows = getSqlMapClientTemplate().delete("NT_INSTRUMENT_INFO.deleteByPrimaryKey", _key);
        return rows;
    }

    /**
     * NT_INSTRUMENT_INFO insert
     */
    public void insert(InstrumentInfo record) {
        getSqlMapClientTemplate().insert("NT_INSTRUMENT_INFO.insert", record);
    }

    /**
     * NT_INSTRUMENT_INFO insertSelective
     */
    public void insertSelective(InstrumentInfo record) {
        getSqlMapClientTemplate().insert("NT_INSTRUMENT_INFO.insertSelective", record);
    }

    /**
     * NT_INSTRUMENT_INFO selectByExample
     */
    @SuppressWarnings("unchecked")
    public List<InstrumentInfo> selectByExample(InstrumentInfoExample example) {
        List<InstrumentInfo> list = getSqlMapClientTemplate().queryForList("NT_INSTRUMENT_INFO.selectByExample", example);
        return list;
    }

    /**
     * NT_INSTRUMENT_INFO selectByPrimaryKey
     */
    public InstrumentInfo selectByPrimaryKey(String instrumentId) {
        InstrumentInfo _key = new InstrumentInfo();
        _key.setInstrumentId(instrumentId);
        InstrumentInfo record = (InstrumentInfo) getSqlMapClientTemplate().queryForObject("NT_INSTRUMENT_INFO.selectByPrimaryKey", _key);
        return record;
    }

    /**
     * NT_INSTRUMENT_INFO updateByExampleSelective
     */
    public int updateByExampleSelective(InstrumentInfo record, InstrumentInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_INSTRUMENT_INFO.updateByExampleSelective", parms);
        return rows;
    }

    /**
     * NT_INSTRUMENT_INFO updateByExample
     */
    public int updateByExample(InstrumentInfo record, InstrumentInfoExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("NT_INSTRUMENT_INFO.updateByExample", parms);
        return rows;
    }

    /**
     * NT_INSTRUMENT_INFO updateByPrimaryKeySelective
     */
    public int updateByPrimaryKeySelective(InstrumentInfo record) {
        int rows = getSqlMapClientTemplate().update("NT_INSTRUMENT_INFO.updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * NT_INSTRUMENT_INFO updateByPrimaryKey
     */
    public int updateByPrimaryKey(InstrumentInfo record) {
        int rows = getSqlMapClientTemplate().update("NT_INSTRUMENT_INFO.updateByPrimaryKey", record);
        return rows;
    }

    /**
     * NT_INSTRUMENT_INFO
     */
    protected static class UpdateByExampleParms extends InstrumentInfoExample {
        private Object record;

        public UpdateByExampleParms(Object record, InstrumentInfoExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
    
    public List<InstrumentInfo> selRptInstrument(String rptId){
    	 List<InstrumentInfo> list = getSqlMapClientTemplate().queryForList("NT_INSTRUMENT_INFO.selRptInstrument", rptId);
         return list;
    }
    
    public List<InstrumentInfo> selEnReportInstrument(String enrTestReportId){
   	 	List<InstrumentInfo> list = getSqlMapClientTemplate().queryForList("NT_INSTRUMENT_INFO.selEnReportInstrument", enrTestReportId);
        return list;
   }
}