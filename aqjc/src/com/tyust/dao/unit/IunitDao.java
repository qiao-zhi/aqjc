package com.tyust.dao.unit;

import java.util.List;

import com.tyust.bean.unit.TBaseUnitInfo;
import com.tyust.common.CommonalityBean;

public interface IunitDao {
	
   /**查询下级机构，只有pid,id,name
    */
   public List<TBaseUnitInfo> findByUpid(String pid);
   
   /**
    * 查询下级机构，下级机构的所以信息
    */
   public List<TBaseUnitInfo> findAllByUpid(CommonalityBean comm);
   
   //
   public List<TBaseUnitInfo> findAll();
   
   /**在该机构下，添加下级机构
    *
    */
   public int savaUnit(TBaseUnitInfo tbaseUnitInfo);
   
   /**删除该机构
    */
   public int delUnit(String id);
   
   /**修改机构
    *
    */
   public int updateUnit(TBaseUnitInfo tbaseUnitInfo);
   
   /**查询该机构的详细信息
	* TODO 使用主键来查询数据库，要求返回一个单位，但是却用了List来作为返回值
    */
   public TBaseUnitInfo findUnit(String id);
   
   /**查询同级别下是否存在同名机构
    *FROM T_BASE_UNIT_INFO
     where UP_UNIT_ID = #upUnitId# AND UNIT_NAME =#unitName#
    * @param tbaseUnitInfo
    * @return
    */
   public List<TBaseUnitInfo> findUnit(TBaseUnitInfo tbaseUnitInfo);
   
   /**根据机构删除角色
    * @param id
    * @return
    */
   public int delUnitRoleByUnitId(String id);
   
   /**查找最高机构
    *
    * @return
    */
   public List<TBaseUnitInfo> selectMaxUnit();
   
   /**
    * 根据上级ID查询机构总数  分页用
    * @param upid
    * @return
    */
   public int selectCountByUpid(String upid);
  
   //
   public int registerUnit(TBaseUnitInfo tbaseUnitInfo);
   
   // 根据部门名称模糊查询
   public List<TBaseUnitInfo> selectUnitInfoByUnitName(String untiName);
}
