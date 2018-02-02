package com.tyust.bean.pbs;

import java.util.Date;

public class PbsTestRpt {
    /**
     * 屏蔽室检测报告，主键
     */
    private String testRptId;

    /**
     * 检测报告编号
     */
    private String rptCode;

    /**
     * 屏蔽室申请编号
     */
    private String applyId;

    /**
     * 检测人
     */
    private String testPerson;

    /**
     * 检测日期
     */
    private Date testDate;

    /**
     * 样品名称
     */
    private String sampleName;

    /**
     * 检查项目
     */
    private String testItem;

    /**
     * 依据标准
     */
    private String testStandards;

    /**
     * 检测位置
     */
    private String testPos;

    /**
     * 性能判据
     */
    private String xnpj;

    /**
     * 检测结果
     */
    private String testResult;

    /**
     * 检测报告状态：1：未提交 2：已提交
     */
    private String rptState;

    /**
     * 被测屏蔽室状态
     */
    private String pbsState;

    /**
     * 委托单位
     */
    private String delegateUnit;

    /**
     * 审核人
     */
    private String shPerson;

    /**
     * 审核日期
     */
    private Date shDate;

    /**
     * 批准人
     */
    private String pzPerson;

    /**
     * 批准日期
     */
    private Date pzDate;

    /**
     * null
     */
    private String remark;

    /**
     * 获取 屏蔽室检测报告，主键
     *
     * @return 
     */
    public String getTestRptId() {
        return testRptId;
    }

    /**
     * 设置  屏蔽室检测报告，主键
     *
     * @param testRptId
     */
    public void setTestRptId(String testRptId) {
        this.testRptId = testRptId;
    }

    /**
     * 获取 检测报告编号
     *
     * @return 
     */
    public String getRptCode() {
        return rptCode;
    }

    /**
     * 设置  检测报告编号
     *
     * @param rptCode
     */
    public void setRptCode(String rptCode) {
        this.rptCode = rptCode;
    }

    /**
     * 获取 屏蔽室申请编号
     *
     * @return 
     */
    public String getApplyId() {
        return applyId;
    }

    /**
     * 设置  屏蔽室申请编号
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
    public String getTestPerson() {
        return testPerson;
    }

    /**
     * 设置  检测人
     *
     * @param testPerson
     */
    public void setTestPerson(String testPerson) {
        this.testPerson = testPerson;
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
     * 获取 检查项目
     *
     * @return 
     */
    public String getTestItem() {
        return testItem;
    }

    /**
     * 设置  检查项目
     *
     * @param testItem
     */
    public void setTestItem(String testItem) {
        this.testItem = testItem;
    }

    /**
     * 获取 依据标准
     *
     * @return 
     */
    public String getTestStandards() {
        return testStandards;
    }

    /**
     * 设置  依据标准
     *
     * @param testStandards
     */
    public void setTestStandards(String testStandards) {
        this.testStandards = testStandards;
    }

    /**
     * 获取 检测位置
     *
     * @return 
     */
    public String getTestPos() {
        return testPos;
    }

    /**
     * 设置  检测位置
     *
     * @param testPos
     */
    public void setTestPos(String testPos) {
        this.testPos = testPos;
    }

    /**
     * 获取 性能判据
     *
     * @return 
     */
    public String getXnpj() {
        return xnpj;
    }

    /**
     * 设置  性能判据
     *
     * @param xnpj
     */
    public void setXnpj(String xnpj) {
        this.xnpj = xnpj;
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
     * 获取 检测报告状态：1：未提交 2：已提交
     *
     * @return 
     */
    public String getRptState() {
        return rptState;
    }

    /**
     * 设置  检测报告状态：1：未提交 2：已提交
     *
     * @param rptState
     */
    public void setRptState(String rptState) {
        this.rptState = rptState;
    }

    /**
     * 获取 被测屏蔽室状态
     *
     * @return 
     */
    public String getPbsState() {
        return pbsState;
    }

    /**
     * 设置  被测屏蔽室状态
     *
     * @param pbsState
     */
    public void setPbsState(String pbsState) {
        this.pbsState = pbsState;
    }

    /**
     * 获取 委托单位
     *
     * @return 
     */
    public String getDelegateUnit() {
        return delegateUnit;
    }

    /**
     * 设置  委托单位
     *
     * @param delegateUnit
     */
    public void setDelegateUnit(String delegateUnit) {
        this.delegateUnit = delegateUnit;
    }

    /**
     * 获取 审核人
     *
     * @return 
     */
    public String getShPerson() {
        return shPerson;
    }

    /**
     * 设置  审核人
     *
     * @param shPerson
     */
    public void setShPerson(String shPerson) {
        this.shPerson = shPerson;
    }

    /**
     * 获取 审核日期
     *
     * @return 
     */
    public Date getShDate() {
        return shDate;
    }

    /**
     * 设置  审核日期
     *
     * @param shDate
     */
    public void setShDate(Date shDate) {
        this.shDate = shDate;
    }

    /**
     * 获取 批准人
     *
     * @return 
     */
    public String getPzPerson() {
        return pzPerson;
    }

    /**
     * 设置  批准人
     *
     * @param pzPerson
     */
    public void setPzPerson(String pzPerson) {
        this.pzPerson = pzPerson;
    }

    /**
     * 获取 批准日期
     *
     * @return 
     */
    public Date getPzDate() {
        return pzDate;
    }

    /**
     * 设置  批准日期
     *
     * @param pzDate
     */
    public void setPzDate(Date pzDate) {
        this.pzDate = pzDate;
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