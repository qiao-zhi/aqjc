package com.tyust.dao.unit;

import java.util.List;

import com.tyust.bean.unit.TBaseUnitRoleModule;



public interface IunitRoleModuleDao {
	   /**根据机构和用户查询权限
	    * 查询某个机构的某个角色下配置的模块列表
	    * unit_id=#unitId# and role_id=#roleId#
	    * @param unitRoleModule
	    * @return
	    */
	   public List findUnitModule(TBaseUnitRoleModule unitRoleModule);
	   /**根据机构删除权限
	    *from t_base_unit_role_module where unit_id=#unitId#
	    * @param unitId
	    * @return
	    */
	   public int delUnitRoleModule(String unitId);

}
