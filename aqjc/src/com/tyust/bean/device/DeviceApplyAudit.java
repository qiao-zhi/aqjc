package com.tyust.bean.device;

import java.util.Date;

public class DeviceApplyAudit {
    /**
     * 设备检测申请审核表，主键
     */
    private String auditId;

    /**
     * 申请ID
     */
    private String applyId;

    /**
     * 审核日期
     */
    private Date auditDate;

    /**
     * 审核意见
     */
    private String auditOppinion;

    /**
     * 审核结果:1通过，0未通过
     */
    private String auditResult;

    /**
     * 审核人
     */
    private String auditUser;

    /**
     * null
     */
    private String remark1;

    /**
     * null
     */
    private String remark2;

    /**
     * 获取 设备检测申请审核表，主键
     *
     * @return 
     */
    public String getAuditId() {
        return auditId;
    }

    /**
     * 设置  设备检测申请审核表，主键
     *
     * @param auditId
     */
    public void setAuditId(String auditId) {
        this.auditId = auditId;
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
     * 获取 审核日期
     *
     * @return 
     */
    public Date getAuditDate() {
        return auditDate;
    }

    /**
     * 设置  审核日期
     *
     * @param auditDate
     */
    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    /**
     * 获取 审核意见
     *
     * @return 
     */
    public String getAuditOppinion() {
        return auditOppinion;
    }

    /**
     * 设置  审核意见
     *
     * @param auditOppinion
     */
    public void setAuditOppinion(String auditOppinion) {
        this.auditOppinion = auditOppinion;
    }

    /**
     * 获取 审核结果:1通过，0未通过
     *
     * @return 
     */
    public String getAuditResult() {
        return auditResult;
    }

    /**
     * 设置  审核结果:1通过，0未通过
     *
     * @param auditResult
     */
    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult;
    }

    /**
     * 获取 审核人
     *
     * @return 
     */
    public String getAuditUser() {
        return auditUser;
    }

    /**
     * 设置  审核人
     *
     * @param auditUser
     */
    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser;
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