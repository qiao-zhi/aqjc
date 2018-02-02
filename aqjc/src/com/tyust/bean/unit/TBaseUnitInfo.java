package com.tyust.bean.unit;

import java.io.Serializable;
import java.util.Date;

/**
 * 机构信息
 * @author Administrator
 *
 */
public class TBaseUnitInfo implements Serializable {
	public String toString() {
		return "TBaseUnitInfo [address=" + address 
				+ ", contactPerson=" + contactPerson
				+ ", createDate=" + createDate + ", email=" + email
				+ ", header=" + header 
				+ ", telephone=" + telephone
				+ ", unitClass=" + unitClass + ", unitId=" + unitId
				+ ", unitName=" + unitName + ", upUnitId=" + upUnitId + "]";
	}

	private String unitId;

	private String upUnitId;

	private String unitClass;

	private String unitName;

	private String address;

	private String telephone;

	private String contactPerson;

	private String email;

	private String header;
	
	private Date createDate;

	
	private String setDefaultValue(String s){
		return s == null? "":s;
	}
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUpUnitId() {
		return upUnitId;
	}

	public void setUpUnitId(String upUnitId) {
		this.upUnitId = upUnitId;
	}

	public String getUnitClass() {
		return unitClass;
	}

	public void setUnitClass(String unitClass) {
		this.unitClass = unitClass;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getAddress() {
		return setDefaultValue(address);
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return setDefaultValue(telephone);
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getContactPerson() {
		return setDefaultValue(contactPerson);
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getEmail() {
		return setDefaultValue(email);
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHeader() {
		return setDefaultValue(header);
	}

	public void setHeader(String header) {
		this.header = header;
	}

}
