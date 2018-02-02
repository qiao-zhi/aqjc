package com.tyust.dao.app;

import com.tyust.bean.app.InstrumentInfo;
import com.tyust.bean.app.InstrumentInfoExample;
import java.util.List;

public interface InstrumentInfoDAO {
    /**
     * NT_INSTRUMENT_INFO countByExample
     */
    int countByExample(InstrumentInfoExample example);

    /**
     * NT_INSTRUMENT_INFO deleteByExample
     */
    int deleteByExample(InstrumentInfoExample example);

    /**
     * NT_INSTRUMENT_INFO deleteByPrimaryKey
     */
    int deleteByPrimaryKey(String instrumentId);

    /**
     * NT_INSTRUMENT_INFO insert
     */
    void insert(InstrumentInfo record);

    /**
     * NT_INSTRUMENT_INFO insertSelective
     */
    void insertSelective(InstrumentInfo record);

    /**
     * NT_INSTRUMENT_INFO selectByExample
     */
    List<InstrumentInfo> selectByExample(InstrumentInfoExample example);

    /**
     * NT_INSTRUMENT_INFO selectByPrimaryKey
     */
    InstrumentInfo selectByPrimaryKey(String instrumentId);

    /**
     * NT_INSTRUMENT_INFO updateByExampleSelective
     */
    int updateByExampleSelective(InstrumentInfo record, InstrumentInfoExample example);

    /**
     * NT_INSTRUMENT_INFO updateByExample
     */
    int updateByExample(InstrumentInfo record, InstrumentInfoExample example);

    /**
     * NT_INSTRUMENT_INFO updateByPrimaryKeySelective
     */
    int updateByPrimaryKeySelective(InstrumentInfo record);

    /**
     * NT_INSTRUMENT_INFO updateByPrimaryKey
     */
    int updateByPrimaryKey(InstrumentInfo record);
    
    List<InstrumentInfo> selRptInstrument(String rptId); 
    
    public List<InstrumentInfo> selEnReportInstrument(String enrTestReportId);
}