package com.tyust.service.dic;

import java.util.List;

import com.tyust.bean.dic.DicSystemDictionary;
import com.tyust.dao.dic.DictionaryDaoImpl;
import com.tyust.service.dic.DicService;

public class DicServiceImpl implements DicService {
	private DictionaryDaoImpl dicDao;
	public DictionaryDaoImpl getDicDao() {
		return dicDao;
	}
	public void setDicDao(DictionaryDaoImpl dicDao) {
		this.dicDao = dicDao;
	}
	
	
	//根据上级字典编号查询
	public List<?> selectDicByupid(String unitId,String upId) {
		return dicDao.selectDicByupid(unitId,upId);
	}
	
	public List<?> selectItemsByupid(String upId) {
		return dicDao.selectItemsByupid(upId);
	}
	
	//根据上级编号查询下级最大的编号
	public String selectMaxidByUpid(String upId) {
		return dicDao.selectMaxidByUpid(upId);
	}
	//添加字典
	public int insertDic(DicSystemDictionary dic) {
		return dicDao.insertDic(dic);
	}
	//删除字典
	public int deleteDic(DicSystemDictionary dic) {
		return dicDao.deleteDic(dic);
	}
	//修改字典
	public int updateDic(DicSystemDictionary dic) {
		return dicDao.updateDic(dic);
	}
	//根据字典编号，查询字典信息
	public DicSystemDictionary selectDicByid(String dicId) {
		return dicDao.selectDicByid(dicId);
	}
	
}
