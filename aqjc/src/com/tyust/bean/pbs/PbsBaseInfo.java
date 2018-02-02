package com.tyust.bean.pbs;

public class PbsBaseInfo {
    /**
     * 屏蔽室编号，主键
     */
    private String pbsId;

    /**
     * 屏蔽室名称
     */
    private String pbsName;

    /**
     * 屏蔽室地址
     */
    private String pbsAddress;

    /**
     * 完成情况
     */
    private String completionInfo;

    /**
     * 维护情况
     */
    private String maintenanceInfo;

    /**
     * 用途
     */
    private String usage;

    /**
     * 屏蔽室型号
     */
    private String model;

    /**
     * 屏蔽门数量
     */
    private Integer doorNums;

    /**
     * 屏蔽门规格
     */
    private String doorModel;

    /**
     * 接地电阻
     */
    private Integer groundResistance;

    /**
     * 绝缘电阻
     */
    private Integer insulationResistance;

    /**
     * 接地电阻检测附件
     */
    private String grAnnex;

    /**
     * 绝缘电阻检测附件
     */
    private String irAnnex;

    /**
     * 通信线过壁方式
     */
    private String telcomCableCrossWall;

    /**
     * null
     */
    private String remark;

    /**
     * 所属单位ID
     */
    private String pbsUnitId;

    /**
     * 承建单位id
     */
    private String builderUnitId;

    /**
     * 设备数量
     */
    private Integer deviceNum;

    /**
     * 屏蔽室规格
     */
    private String pbsSize;

    /**
     * 平面图
     */
    private String pmPic;

    /**
     * 获取 屏蔽室编号，主键
     *
     * @return 
     */
    public String getPbsId() {
        return pbsId;
    }

    /**
     * 设置  屏蔽室编号，主键
     *
     * @param pbsId
     */
    public void setPbsId(String pbsId) {
        this.pbsId = pbsId;
    }

    /**
     * 获取 屏蔽室名称
     *
     * @return 
     */
    public String getPbsName() {
        return pbsName;
    }

    /**
     * 设置  屏蔽室名称
     *
     * @param pbsName
     */
    public void setPbsName(String pbsName) {
        this.pbsName = pbsName;
    }

    /**
     * 获取 屏蔽室地址
     *
     * @return 
     */
    public String getPbsAddress() {
        return pbsAddress;
    }

    /**
     * 设置  屏蔽室地址
     *
     * @param pbsAddress
     */
    public void setPbsAddress(String pbsAddress) {
        this.pbsAddress = pbsAddress;
    }

    /**
     * 获取 完成情况
     *
     * @return 
     */
    public String getCompletionInfo() {
        return completionInfo;
    }

    /**
     * 设置  完成情况
     *
     * @param completionInfo
     */
    public void setCompletionInfo(String completionInfo) {
        this.completionInfo = completionInfo;
    }

    /**
     * 获取 维护情况
     *
     * @return 
     */
    public String getMaintenanceInfo() {
        return maintenanceInfo;
    }

    /**
     * 设置  维护情况
     *
     * @param maintenanceInfo
     */
    public void setMaintenanceInfo(String maintenanceInfo) {
        this.maintenanceInfo = maintenanceInfo;
    }

    /**
     * 获取 用途
     *
     * @return 
     */
    public String getUsage() {
        return usage;
    }

    /**
     * 设置  用途
     *
     * @param usage
     */
    public void setUsage(String usage) {
        this.usage = usage;
    }

    /**
     * 获取 屏蔽室型号
     *
     * @return 
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置  屏蔽室型号
     *
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 获取 屏蔽门数量
     *
     * @return 
     */
    public Integer getDoorNums() {
        return doorNums;
    }

    /**
     * 设置  屏蔽门数量
     *
     * @param doorNums
     */
    public void setDoorNums(Integer doorNums) {
        this.doorNums = doorNums;
    }

    /**
     * 获取 屏蔽门规格
     *
     * @return 
     */
    public String getDoorModel() {
        return doorModel;
    }

    /**
     * 设置  屏蔽门规格
     *
     * @param doorModel
     */
    public void setDoorModel(String doorModel) {
        this.doorModel = doorModel;
    }

    /**
     * 获取 接地电阻
     *
     * @return 
     */
    public Integer getGroundResistance() {
        return groundResistance;
    }

    /**
     * 设置  接地电阻
     *
     * @param groundResistance
     */
    public void setGroundResistance(Integer groundResistance) {
        this.groundResistance = groundResistance;
    }

    /**
     * 获取 绝缘电阻
     *
     * @return 
     */
    public Integer getInsulationResistance() {
        return insulationResistance;
    }

    /**
     * 设置  绝缘电阻
     *
     * @param insulationResistance
     */
    public void setInsulationResistance(Integer insulationResistance) {
        this.insulationResistance = insulationResistance;
    }

    /**
     * 获取 接地电阻检测附件
     *
     * @return 
     */
    public String getGrAnnex() {
        return grAnnex;
    }

    /**
     * 设置  接地电阻检测附件
     *
     * @param grAnnex
     */
    public void setGrAnnex(String grAnnex) {
        this.grAnnex = grAnnex;
    }

    /**
     * 获取 绝缘电阻检测附件
     *
     * @return 
     */
    public String getIrAnnex() {
        return irAnnex;
    }

    /**
     * 设置  绝缘电阻检测附件
     *
     * @param irAnnex
     */
    public void setIrAnnex(String irAnnex) {
        this.irAnnex = irAnnex;
    }

    /**
     * 获取 通信线过壁方式
     *
     * @return 
     */
    public String getTelcomCableCrossWall() {
        return telcomCableCrossWall;
    }

    /**
     * 设置  通信线过壁方式
     *
     * @param telcomCableCrossWall
     */
    public void setTelcomCableCrossWall(String telcomCableCrossWall) {
        this.telcomCableCrossWall = telcomCableCrossWall;
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

    /**
     * 获取 所属单位ID
     *
     * @return 
     */
    public String getPbsUnitId() {
        return pbsUnitId;
    }

    /**
     * 设置  所属单位ID
     *
     * @param pbsUnitId
     */
    public void setPbsUnitId(String pbsUnitId) {
        this.pbsUnitId = pbsUnitId;
    }

    /**
     * 获取 承建单位id
     *
     * @return 
     */
    public String getBuilderUnitId() {
        return builderUnitId;
    }

    /**
     * 设置  承建单位id
     *
     * @param builderUnitId
     */
    public void setBuilderUnitId(String builderUnitId) {
        this.builderUnitId = builderUnitId;
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
     * 获取 屏蔽室规格
     *
     * @return 
     */
    public String getPbsSize() {
        return pbsSize;
    }

    /**
     * 设置  屏蔽室规格
     *
     * @param pbsSize
     */
    public void setPbsSize(String pbsSize) {
        this.pbsSize = pbsSize;
    }

    /**
     * 获取 平面图
     *
     * @return 
     */
    public String getPmPic() {
        return pmPic;
    }

    /**
     * 设置  平面图
     *
     * @param pmPic
     */
    public void setPmPic(String pmPic) {
        this.pmPic = pmPic;
    }
}