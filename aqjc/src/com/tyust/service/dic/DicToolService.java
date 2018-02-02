package com.tyust.service.dic;

import java.util.List;

import com.tyust.dao.dic.SystemDictionaryDAO;

/**
 * 
 * 
 * 类名称：DicToolService
 * 类描述：
 * 修改时间：2012-9-17 下午05:05:49
 * 修改备注：
 * @version 1.0.0
 *
 */
public class DicToolService {
	private SystemDictionaryDAO systemDictionaryDAO;


	public SystemDictionaryDAO getSystemDictionaryDAO() {
		return systemDictionaryDAO;
	}

	public void setSystemDictionaryDAO(SystemDictionaryDAO systemDictionaryDAO) {
		this.systemDictionaryDAO = systemDictionaryDAO;
	}

	/**
	 * 根据区划编号得到区划名称
	 * getGBAreaNameById(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param areaId
	 * @return 
	 *String
	 * @exception 
	 * @since  1.0.0
	 */
	public String getGBAreaNameById(String areaId){
		String areaName="";
		//areaName = dicGbAreaDAO.selectByPrimaryKey(areaId).getAreaName();
		return areaName;
		
	}
	/**
	 * 根据数组获取逗号分隔符字符串
	 * getStrValue(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param str
	 * @return 
	 *String
	 * @exception 
	 * @since  1.0.0
	 */
	public String getStrValue(String[] str){
		String strValue = "";
		if (str.length > 0) {
			for (int i = 0; i < str.length - 1; i++) {
				strValue += (str[i] + ",");
			}
			strValue += str[str.length - 1];
		}
		return strValue;
	}
	/**
	 * 根据鱼种编号获取鱼种名称
	 * getFishKindName(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param fishKind
	 * @return 
	 *String
	 * @exception 
	 * @since  1.0.0
	 */
	public String getFishKindName(String fishKind){
		String fishKindName = "";
		String[] kindArr = fishKind.split(",");
		if(kindArr.length>0){
			for(int i=0; i<kindArr.length-1; i++){
				fishKindName += (systemDictionaryDAO.selectByPrimaryKey(kindArr[i]).getDictionaryOptionName()+"、");
			}
			fishKindName += (systemDictionaryDAO.selectByPrimaryKey(kindArr[kindArr.length-1]).getDictionaryOptionName());
		}
		return fishKindName;
	}
	
	
}














