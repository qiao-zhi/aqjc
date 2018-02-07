package com.tyust.bean.app;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

public class InstrumentInfo {
    /**
     * 检测仪器表，主键
     */
    private String instrumentId;

    /**
     * 仪器名称
     */
    private String name;

    /**
     * 仪器型号
     */
    private String model;

    /**
     * 类别（设备，屏蔽室，环境）
     */
    private String useType;

    /**
     * 厂商
     */
    private String manufacturer;

    /**
     * 仪器编号
     */
    private String code;

    /**
     * null
     */
    private String remark;
    
    /**
     * 有效期开始日期
     */
    private Date startTime;
    /**
     * 有效期结束日期
     */
    private Date endTime;

    /**
     * 获取 检测仪器表，主键
     *
     * @return 
     */
    public String getInstrumentId() {
        return instrumentId;
    }

    /**
     * 设置  检测仪器表，主键
     *
     * @param instrumentId
     */
    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    /**
     * 获取 仪器名称
     *
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * 设置  仪器名称
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 仪器型号
     *
     * @return 
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置  仪器型号
     *
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 获取 类别（设备，屏蔽室，环境）
     *
     * @return 
     */
    public String getUseType() {
        return useType;
    }

    /**
     * 设置  类别（设备，屏蔽室，环境）
     *
     * @param useType
     */
    public void setUseType(String useType) {
        this.useType = useType;
    }

    /**
     * 获取 厂商
     *
     * @return 
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * 设置  厂商
     *
     * @param manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * 获取 仪器编号
     *
     * @return 
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置  仪器编号
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
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
     * 获取开始日期
     * @return
     */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置开始日期
	 * @param startTime
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取结束日期
	 * @return
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * 设置结束日期
	 * @param endTime
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
    
}