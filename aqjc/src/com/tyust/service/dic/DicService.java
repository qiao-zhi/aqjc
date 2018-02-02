package com.tyust.service.dic;

import java.util.List;

import com.tyust.bean.dic.DicSystemDictionary;

public interface DicService {
	//根据上级字典编号查询
	public List<?> selectDicByupid(String unitId,String upId);
	//根据上级编号查询下级最大的编号
	public String selectMaxidByUpid(String upId);
	//添加字典
	public int insertDic(DicSystemDictionary dic);
	//删除字典
	public int deleteDic(DicSystemDictionary dic);
	//修改字典
	public int updateDic(DicSystemDictionary dic);
	//根据字典编号，查询字典信息
	public DicSystemDictionary selectDicByid(String dicId);
	public List<?> selectItemsByupid(String upId);
}
