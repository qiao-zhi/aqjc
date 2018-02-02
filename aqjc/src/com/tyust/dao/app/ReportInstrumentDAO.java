package com.tyust.dao.app;

import com.tyust.bean.app.ReportInstrument;
import com.tyust.bean.app.ReportInstrumentExample;
import java.util.List;

public interface ReportInstrumentDAO {
    /**
     * NT_REPORT_INSTRUMENT countByExample
     */
    int countByExample(ReportInstrumentExample example);

    /**
     * NT_REPORT_INSTRUMENT deleteByExample
     */
    int deleteByExample(ReportInstrumentExample example);

    /**
     * NT_REPORT_INSTRUMENT deleteByPrimaryKey
     */
    int deleteByPrimaryKey(String id);

    /**
     * NT_REPORT_INSTRUMENT insert
     */
    void insert(ReportInstrument record);

    /**
     * NT_REPORT_INSTRUMENT insertSelective
     */
    void insertSelective(ReportInstrument record);

    /**
     * NT_REPORT_INSTRUMENT selectByExample
     */
    List<ReportInstrument> selectByExample(ReportInstrumentExample example);

    /**
     * NT_REPORT_INSTRUMENT selectByPrimaryKey
     */
    ReportInstrument selectByPrimaryKey(String id);

    /**
     * NT_REPORT_INSTRUMENT updateByExampleSelective
     */
    int updateByExampleSelective(ReportInstrument record, ReportInstrumentExample example);

    /**
     * NT_REPORT_INSTRUMENT updateByExample
     */
    int updateByExample(ReportInstrument record, ReportInstrumentExample example);

    /**
     * NT_REPORT_INSTRUMENT updateByPrimaryKeySelective
     */
    int updateByPrimaryKeySelective(ReportInstrument record);

    /**
     * NT_REPORT_INSTRUMENT updateByPrimaryKey
     */
    int updateByPrimaryKey(ReportInstrument record);
}