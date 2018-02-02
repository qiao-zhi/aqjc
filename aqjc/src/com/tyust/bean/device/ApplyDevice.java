package com.tyust.bean.device;

public class ApplyDevice {
    /**
     * 申请检测的设备表，主键
     */
    private String id;

    /**
     * 申请ID
     */
    private String applyId;

    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * null
     */
    private String remark;

    /**
     * 获取 申请检测的设备表，主键
     *
     * @return 
     */
    public String getId() {
        return id;
    }

    /**
     * 设置  申请检测的设备表，主键
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
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
     * 获取 设备ID
     *
     * @return 
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * 设置  设备ID
     *
     * @param deviceId
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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