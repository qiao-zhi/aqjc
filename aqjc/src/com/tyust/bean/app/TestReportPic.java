package com.tyust.bean.app;

import java.util.Date;

public class TestReportPic {
    /**
     * 检测报告照片表，主键
     */
    private String picId;

    /**
     * 检测报告ID
     */
    private String reportId;

    /**
     * 图片路径
     */
    private String picUrl;

    /**
     * 上传日期
     */
    private Date uploadDate;

    /**
     * 图片原名
     */
    private String picName;

    /**
     * 图片类别
     */
    private String picType;

    /**
     * null
     */
    private String remark;

    /**
     * 获取 检测报告照片表，主键
     *
     * @return 
     */
    public String getPicId() {
        return picId;
    }

    /**
     * 设置  检测报告照片表，主键
     *
     * @param picId
     */
    public void setPicId(String picId) {
        this.picId = picId;
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
     * 获取 图片路径
     *
     * @return 
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 设置  图片路径
     *
     * @param picUrl
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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
     * 获取 图片原名
     *
     * @return 
     */
    public String getPicName() {
        return picName;
    }

    /**
     * 设置  图片原名
     *
     * @param picName
     */
    public void setPicName(String picName) {
        this.picName = picName;
    }

    /**
     * 获取 图片类别
     *
     * @return 
     */
    public String getPicType() {
        return picType;
    }

    /**
     * 设置  图片类别
     *
     * @param picType
     */
    public void setPicType(String picType) {
        this.picType = picType;
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