package com.tyust.bean.dic;
/**
 * 字典Bean
 * @author along
 *
 */
public class DicSystemDictionary {
	
	private String dictionaryOptionId;
	
	private String dictionaryOptionName;
	
	private String upDictionaryOptionId;

    private int isUse;
    
    private String descriptions;
    
    private int sortNo;
    
    private int flag;
    
    private String englishName;
    
    private String dataType;
    
    private String remark1;
    
    private String remark2;
    
    private String matchDicId;

	public String getDictionaryOptionId() {
		return dictionaryOptionId;
	}

	public void setDictionaryOptionId(String dictionaryOptionId) {
		this.dictionaryOptionId = dictionaryOptionId;
	}

	public String getDictionaryOptionName() {
		return dictionaryOptionName;
	}

	public void setDictionaryOptionName(String dictionaryOptionName) {
		this.dictionaryOptionName = dictionaryOptionName;
	}

	public String getUpDictionaryOptionId() {
		return upDictionaryOptionId;
	}

	public void setUpDictionaryOptionId(String upDictionaryOptionId) {
		this.upDictionaryOptionId = upDictionaryOptionId;
	}

	public int getIsUse() {
		return isUse;
	}

	public void setIsUse(int isUse) {
		this.isUse = isUse;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public int getSortNo() {
		return sortNo;
	}

	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
	}

	public int getFlag(){
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getMatchDicId() {
		return matchDicId;
	}

	public void setMatchDicId(String matchDicId) {
		this.matchDicId = matchDicId;
	}
}
