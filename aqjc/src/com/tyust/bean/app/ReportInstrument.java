package com.tyust.bean.app;

public class ReportInstrument {
    /**
     * 检测报告检测仪器表，主键
     */
    private String id;

    /**
     * 检测报告ID
     */
    private String reportId;

    /**
     * 仪器ID
     */
    private String instrumentId;

    /**
     * null
     */
    private String remark;

    /**
     * 获取 检测报告检测仪器表，主键
     *
     * @return 
     */
    public String getId() {
        return id;
    }

    /**
     * 设置  检测报告检测仪器表，主键
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取 检测报告ID
     *
     * @return 
     */
    public String getReportId() {
        return reportId;
    }

    /**
     * 设置  检测报告ID
     *
     * @param reportId
     */
    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    /**
     * 获取 仪器ID
     *
     * @return 
     */
    public String getInstrumentId() {
        return instrumentId;
    }

    /**
     * 设置  仪器ID
     *
     * @param instrumentId
     */
    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    /**
     * 获取 null
     *
     * @return 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置  null
     *
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}