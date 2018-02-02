package com.tyust.dao.dic;

import java.util.HashMap;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tyust.bean.dic.DicSystemDictionary;
import com.tyust.dao.dic.IdictionaryDao;

public class DictionaryDaoImpl extends SqlMapClientDaoSupport implements
		IdictionaryDao {


	public int insertDic(DicSystemDictionary dicsystemdictionary) {
		   Object obj = this.getSqlMapClientTemplate().insert("DicSystemDictionary.insertDic",dicsystemdictionary);
		   if(obj!=null){
			   return 1;
		   }
		return 0;
	}

	public List selectDicByupid(String unitId,String upId) {
		HashMap map = new HashMap();
		map.put("unitId", unitId);
		map.put("upDictionaryOptionId", upId);
		List list = this.getSqlMapClientTemplate().queryForList("DicSystemDictionary.selectDicByupid",map);

		if(list!=null){
			return list;
		}
		return null;
	}

	public int deleteDic(DicSystemDictionary dicsystemdictionary) {
		return this.getSqlMapClientTemplate().delete("DicSystemDictionary.deleteDic",dicsystemdictionary);
	}

	public DicSystemDictionary selectDicByid(String id) {

		return (DicSystemDictionary)this.getSqlMapClientTemplate().queryForObject("DicSystemDictionary.selectDicByid",id);
	}

	public String selectMaxidByUpid(String upid) {
		Object obj = this.getSqlMapClientTemplate().queryForObject("DicSystemDictionary.selectMaxidByUpid",upid);
		if(obj!=null){
			return obj.toString();
		}
		return null;
	}

	public int updateDic(DicSystemDictionary dicsystemdictionary) {
		return this.getSqlMapClientTemplate().update("DicSystemDictionary.updateDic",dicsystemdictionary);
	}

	public List selectItemsByupid(String upId) {
		List list = this.getSqlMapClientTemplate().queryForList("DicSystemDictionary.selectItemsByupid",upId);
		if(list!=null){
			return list;
		}
		return null;
	}

	public String selectNameByid(String id) {
		Object obj = this.getSqlMapClientTemplate().queryForObject("DicSystemDictionary.selectNameByid",id);
		if(obj!=null){
			return obj.toString();
		}
		return null;
	}

}
