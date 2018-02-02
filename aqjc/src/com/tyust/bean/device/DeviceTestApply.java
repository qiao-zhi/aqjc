package com.tyust.bean.device;

import java.util.Date;

public class DeviceTestApply {
    /**
     * 设备检测申请表，主键
     */
    private String applyId;

    /**
     * 单位ID
     */
    private String unitId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 申请意见
     */
    private String applyOpinion;

    /**
     * 申请时间
     */
    private Date applyDate;

    /**
     * 设备数量
     */
    private Integer deviceNum;

    /**
     * 申请状态：1待提交，2待审核，3审核未通过，4审核通过，5已检测
     */
    private String state;

    /**
     * 申请单位
     */
    private String remark1;

    /**
     * 申请人
     */
    private String remark2;

    /**
     * 获取 设备检测申请表，主键
     *
     * @return 
     */
    public String getApplyId() {
        return applyId;
    }

    /**
     * 设置  设备检测申请表，主键
     *
     * @param applyId
     */
    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    /**
     * 获取 单位ID
     *
     * @return 
     */
    public String getUnitId() {
        return unitId;
    }

    /**
     * 设置  单位ID
     *
     * @param unitId
     */
    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    /**
     * 获取 用户ID
     *
     * @return 
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置  用户ID
     *
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取 申请意见
     *
     * @return 
     */
    public String getApplyOpinion() {
        return applyOpinion;
    }

    /**
     * 设置  申请意见
     *
     * @param applyOpinion
     */
    public void setApplyOpinion(String applyOpinion) {
        this.applyOpinion = applyOpinion;
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
     * 获取 设备数量
     *
     * @return 
     */
    public Integer getDeviceNum() {
        return deviceNum;
    }

    /**
     * 设置  设备数量
     *
     * @param deviceNum
     */
    public void setDeviceNum(Integer deviceNum) {
        this.deviceNum = deviceNum;
    }

    /**
     * 获取 申请状态：1待提交，2待审核，3审核未通过，4审核通过，5已检测
     *
     * @return 
     */
    public String getState() {
        return state;
    }

    /**
     * 设置  申请状态：1待提交，2待审核，3审核未通过，4审核通过，5已检测
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