package com.tyust.bean.pbs;

import java.util.Date;

public class PbsTestApply {
    /**
     * 屏蔽室检测申请表，主键
     */
    private String testApplyId;

    /**
     * 申请单位ID
     */
    private String applyUnit;

    /**
     * 屏蔽室ID
     */
    private String pbsId;

    /**
     * 申请时间
     */
    private Date applyDate;

    /**
     * 屏蔽室承建单位ID
     */
    private String pbsBuilderId;

    /**
     * 申请检测级别：ABC
     */
    private String applyTestGrade;

    /**
     * 申请检测的类型：初检 复检
     */
    private String applyTestType;

    /**
     * 申请状态：1待提交，2待审核，3审核未通过，4审核通过，5已检测
     */
    private String applyState;

    /**
     * 申请人
     */
    private String applyUser;

    /**
     * null
     */
    private String remark1;

    /**
     * null
     */
    private String remark2;

    /**
     * 获取 屏蔽室检测申请表，主键
     *
     * @return 
     */
    public String getTestApplyId() {
        return testApplyId;
    }

    /**
     * 设置  屏蔽室检测申请表，主键
     *
     * @param testApplyId
     */
    public void setTestApplyId(String testApplyId) {
        this.testApplyId = testApplyId;
    }

    /**
     * 获取 申请单位ID
     *
     * @return 
     */
    public String getApplyUnit() {
        return applyUnit;
    }

    /**
     * 设置  申请单位ID
     *
     * @param applyUnit
     */
    public void setApplyUnit(String applyUnit) {
        this.applyUnit = applyUnit;
    }

    /**
     * 获取 屏蔽室ID
     *
     * @return 
     */
    public String getPbsId() {
        return pbsId;
    }

    /**
     * 设置  屏蔽室ID
     *
     * @param pbsId
     */
    public void setPbsId(String pbsId) {
        this.pbsId = pbsId;
    }

    /**
     * 获取 申请时间
     *
     * @return 
     */
    public Date getApplyDate() {
        return applyDate;
    }

    /**
     * 设置  申请时间
     *
     * @param applyDate
     */
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * 获取 屏蔽室承建单位ID
     *
     * @return 
     */
    public String getPbsBuilderId() {
        return pbsBuilderId;
    }

    /**
     * 设置  屏蔽室承建单位ID
     *
     * @param pbsBuilderId
     */
    public void setPbsBuilderId(String pbsBuilderId) {
        this.pbsBuilderId = pbsBuilderId;
    }

    /**
     * 获取 申请检测级别：ABC
     *
     * @return 
     */
    public String getApplyTestGrade() {
        return applyTestGrade;
    }

    /**
     * 设置  申请检测级别：ABC
     *
     * @param applyTestGrade
     */
    public void setApplyTestGrade(String applyTestGrade) {
        this.applyTestGrade = applyTestGrade;
    }

    /**
     * 获取 申请检测的类型：初检 复检
     *
     * @return 
     */
    public String getApplyTestType() {
        return applyTestType;
    }

    /**
     * 设置  申请检测的类型：初检 复检
     *
     * @param applyTestType
     */
    public void setApplyTestType(String applyTestType) {
        this.applyTestType = applyTestType;
    }

    /**
     * 获取 申请状态：1待提交，2待审核，3审核未通过，4审核通过，5已检测
     *
     * @return 
     */
    public String getApplyState() {
        return applyState;
    }

    /**
     * 设置  申请状态：1待提交，2待审核，3审核未通过，4审核通过，5已检测
     *
     * @param applyState
     */
    public void setApplyState(String applyState) {
        this.applyState = applyState;
    }

    /**
     * 获取 申请人
     *
     * @return 
     */
    public String getApplyUser() {
        return applyUser;
    }

    /**
     * 设置  申请人
     *
     * @param applyUser
     */
    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
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