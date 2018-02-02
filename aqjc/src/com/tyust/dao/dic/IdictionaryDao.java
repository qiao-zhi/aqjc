package com.tyust.dao.dic;

import java.util.List;

import com.tyust.bean.dic.DicSystemDictionary;

public interface IdictionaryDao {
     /**
      * 根据上级ID查询字典项
      * @param upId
      * @return
      */
	public List selectDicByupid(String unitId,String upId);
	/**
	 * 根据ID删除该字典项以及其子项
	 * @param id
	 * @return
	 */
	public int deleteDic(DicSystemDictionary dicsystemdictionary);
	/**
	 * 添加字典项
	 * @param dicsystemdictionary
	 * @return
	 */
	public int insertDic(DicSystemDictionary dicsystemdictionary);
	/**
	 * 根据ID 查询字典项
	 * @param id
	 * @return
	 */
	public DicSystemDictionary selectDicByid(String id);
	/**
	 * 根据上级ID获取该子项的最大编号
	 * @param upid
	 * @return
	 */
	public String selectMaxidByUpid(String upid);
	/**
	 * 修改字典项
	 * @param dicsystemdictionary
	 * @return
	 */
	public int updateDic(DicSystemDictionary dicsystemdictionary);
	/**
	 * 根据上级ID获取子项（名称、编号） 绑定下拉列表用的
	 * @param upId
	 * @return
	 */
	public List selectItemsByupid(String upId);
	/**
	 * 根据字典编号查找名称
	 * @param id
	 * @return
	 */
	public String selectNameByid(String id);
}
