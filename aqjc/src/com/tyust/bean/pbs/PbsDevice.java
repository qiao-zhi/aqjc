package com.tyust.bean.pbs;

public class PbsDevice {
    /**
     * 屏蔽室设备表
     */
    private String id;

    /**
     * 屏蔽室编号
     */
    private String pbsId;

    /**
     * 厂家
     */
    private String devFactory;

    /**
     * 

型号

     */
    private String devModel;

    /**
     * 工作频段范围

     */
    private String band;

    /**
     * 插入损耗
     */
    private String insertionLoss;

    /**
     * 设备类型：电源滤波器、电话滤波器、信号滤波器、通风波导窗、空调、消防、光纤
     */
    private String devType;

    /**
     * 屏蔽效能（通风波导窗）
     */
    private String pbEfficiency;

    /**
     * 光纤类型
     */
    private String hasMetalFirmware;

    /**
     * 空调波导管数量
     */
    private Integer ktbdgNum;

    /**
     * null
     */
    private String remark1;

    /**
     * null
     */
    private String remark2;

    /**
     * 设备名称
     */
    private String dveName;

    /**
     * 获取 屏蔽室设备表
     *
     * @return 
     */
    public String getId() {
        return id;
    }

    /**
     * 设置  屏蔽室设备表
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取 屏蔽室编号
     *
     * @return 
     */
    public String getPbsId() {
        return pbsId;
    }

    /**
     * 设置  屏蔽室编号
     *
     * @param pbsId
     */
    public void setPbsId(String pbsId) {
        this.pbsId = pbsId;
    }

    /**
     * 获取 厂家
     *
     * @return 
     */
    public String getDevFactory() {
        return devFactory;
    }

    /**
     * 设置  厂家
     *
     * @param devFactory
     */
    public void setDevFactory(String devFactory) {
        this.devFactory = devFactory;
    }

    /**
     * 获取 

型号

     *
     * @return 
     */
    public String getDevModel() {
        return devModel;
    }

    /**
     * 设置  

型号

     *
     * @param devModel
     */
    public void setDevModel(String devModel) {
        this.devModel = devModel;
    }

    /**
     * 获取 工作频段范围

     *
     * @return 
     */
    public String getBand() {
        return band;
    }

    /**
     * 设置  工作频段范围

     *
     * @param band
     */
    public void setBand(String band) {
        this.band = band;
    }

    /**
     * 获取 插入损耗
     *
     * @return 
     */
    public String getInsertionLoss() {
        return insertionLoss;
    }

    /**
     * 设置  插入损耗
     *
     * @param insertionLoss
     */
    public void setInsertionLoss(String insertionLoss) {
        this.insertionLoss = insertionLoss;
    }

    /**
     * 获取 设备类型：电源滤波器、电话滤波器、信号滤波器、通风波导窗、空调、消防、光纤
     *
     * @return 
     */
    public String getDevType() {
        return devType;
    }

    /**
     * 设置  设备类型：电源滤波器、电话滤波器、信号滤波器、通风波导窗、空调、消防、光纤
     *
     * @param devType
     */
    public void setDevType(String devType) {
        this.devType = devType;
    }

    /**
     * 获取 屏蔽效能（通风波导窗）
     *
     * @return 
     */
    public String getPbEfficiency() {
        return pbEfficiency;
    }

    /**
     * 设置  屏蔽效能（通风波导窗）
     *
     * @param pbEfficiency
     */
    public void setPbEfficiency(String pbEfficiency) {
        this.pbEfficiency = pbEfficiency;
    }

    /**
     * 获取 光纤类型
     *
     * @return 
     */
    public String getHasMetalFirmware() {
        return hasMetalFirmware;
    }

    /**
     * 设置  光纤类型
     *
     * @param hasMetalFirmware
     */
    public void setHasMetalFirmware(String hasMetalFirmware) {
        this.hasMetalFirmware = hasMetalFirmware;
    }

    /**
     * 获取 空调波导管数量
     *
     * @return 
     */
    public Integer getKtbdgNum() {
        return ktbdgNum;
    }

    /**
     * 设置  空调波导管数量
     *
     * @param ktbdgNum
     */
    public void setKtbdgNum(Integer ktbdgNum) {
        this.ktbdgNum = ktbdgNum;
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

    /**
     * 获取 设备名称
     *
     * @return 
     */
    public String getDveName() {
        return dveName;
    }

    /**
     * 设置  设备名称
     *
     * @param dveName
     */
    public void setDveName(String dveName) {
        this.dveName = dveName;
    }
}