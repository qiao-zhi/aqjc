package com.tyust.bean.device;

import java.util.Date;

public class ApplyAuditSmj {
    /**
     * 审核表扫描件，主键
     */
    private String id;

    /**
     * 审核表ID
     */
    private String auditId;

    /**
     * 扫描件名字
     */
    private String smjName;

    /**
     * 扫描件url
     */
    private String smjUrl;

    /**
     * 上传日期
     */
    private Date uploadDate;

    /**
     * null
     */
    private String remark;

    /**
     * 获取 审核表扫描件，主键
     *
     * @return 
     */
    public String getId() {
        return id;
    }

    /**
     * 设置  审核表扫描件，主键
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取 审核表ID
     *
     * @return 
     */
    public String getAuditId() {
        return auditId;
    }

    /**
     * 设置  审核表ID
     *
     * @param auditId
     */
    public void setAuditId(String auditId) {
        this.auditId = auditId;
    }

    /**
     * 获取 扫描件名字
     *
     * @return 
     */
    public String getSmjName() {
        return smjName;
    }

    /**
     * 设置  扫描件名字
     *
     * @param smjName
     */
    public void setSmjName(String smjName) {
        this.smjName = smjName;
    }

    /**
     * 获取 扫描件url
     *
     * @return 
     */
    public String getSmjUrl() {
        return smjUrl;
    }

    /**
     * 设置  扫描件url
     *
     * @param smjUrl
     */
    public void setSmjUrl(String smjUrl) {
        this.smjUrl = smjUrl;
    }

    /**
     * 获取 上传日期
     *
     * @return 
     */
    public Date getUploadDate() {
        return uploadDate;
    }

    /**
     * 设置  上传日期
     *
     * @param uploadDate
     */
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
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