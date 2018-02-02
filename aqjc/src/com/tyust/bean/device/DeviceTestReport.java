package com.tyust.bean.device;

import java.util.Date;

public class DeviceTestReport {
    /**
     * 设备检测报告表，主键
     */
    private String reportId;

    /**
     * 申请ID
     */
    private String applyId;

    /**
     * 检测人
     */
    private String testUser;

    /**
     * 检测报告编号
     */
    private String testCode;

    /**
     * 样品名称
     */
    private String sampleName;

    /**
     * 检测日期
     */
    private Date testDate;

    /**
     * 检测结果
     */
    private String testResult;

    /**
     * 状态：1未提交，2已提交
     */
    private String state;

    /**
     * null
     */
    private String remark1;

    /**
     * null
     */
    private String remark2;

    /**
     * 获取 设备检测报告表，主键
     *
     * @return 
     */
    
    private String wtUnit;
    
    public String getWtUnit() {
		return wtUnit;
	}

	public void setWtUnit(String wtUnit) {
		this.wtUnit = wtUnit;
	}

	public String getReportId() {
        return reportId;
    }

    /**
     * 设置  设备检测报告表，主键
     *
     * @param reportId
     */
    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    /**
     * 获取 申请ID
     *
     * @return 
     */
    public String getApplyId() {
        return applyId;
    }

    /**
     * 设置  申请ID
     *
     * @param applyId
     */
    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    /**
     * 获取 检测人
     *
     * @return 
     */
    public String getTestUser() {
        return testUser;
    }

    /**
     * 设置  检测人
     *
     * @param testUser
     */
    public void setTestUser(String testUser) {
        this.testUser = testUser;
    }

    /**
     * 获取 检测报告编号
     *
     * @return 
     */
    public String getTestCode() {
        return testCode;
    }

    /**
     * 设置  检测报告编号
     *
     * @param testCode
     */
    public void setTestCode(String testCode) {
        this.testCode = testCode;
    }

    /**
     * 获取 样品名称
     *
     * @return 
     */
    public String getSampleName() {
        return sampleName;
    }

    /**
     * 设置  样品名称
     *
     * @param sampleName
     */
    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    /**
     * 获取 检测日期
     *
     * @return 
     */
    public Date getTestDate() {
        return testDate;
    }

    /**
     * 设置  检测日期
     *
     * @param testDate
     */
    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    /**
     * 获取 检测结果
     *
     * @return 
     */
    public String getTestResult() {
        return testResult;
    }

    /**
     * 设置  检测结果
     *
     * @param testResult
     */
    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    /**
     * 获取 状态：1未提交，2已提交
     *
     * @return 
     */
    public String getState() {
        return state;
    }

    /**
     * 设置  状态：1未提交，2已提交
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取 null
     *
     * @return 
     */
    public String getRemark1() {
        return remark1;
    }

    /**
     * 设置  null
     *
     * @param remark1
     */
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    /**
     * 获取 null
     *
     * @return 
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * 设置  null
     *
     * @param remark2
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }
}