package com.tyust.common;


/**
 * ibator 自动生成的 example 类 的分页查询助手，
 * 继承这个助手来实现数据库的分页
 * 1. 修改vo 对应的***Sqlmap.xml 在selectByExample中添加SQL分页语句实现selectByExample分页查询
 * pagination 参数是个开关用于在sqlmap中判断是否需要分页
 * MYSQL：
 * <select id="ibatorgenerated_selectByExample...
 * ......
 * 	<isParameterPresent>
 *  ....
 *   <isEqual property="pagination" compareValue="true">
 *           limit #start#,#limit#
 *   </isEqual>
 *   </isParameterPresent>
 * </select>
 *
 * ORACLE
 * 	<select id="selectbyexample" ...>
		<isParameterPresent>
			<isEqual property="pagination" compareValue="true">
		           <![CDATA[SELECT * FROM
					(
					SELECT A.*, ROWNUM RN
					FROM (
				]]>
			</isEqual>
		</isParameterPresent>
		***
		<isParameterPresent>
			<isEqual property="pagination" compareValue="true">
	            <![CDATA[
					) A
					WHERE ROWNUM <=#end#
					)
					WHERE RN >#start# order by $sortname$ $sortorder$
				]]>
			</isEqual>
		</isParameterPresent>
	</select>
	</select>
 *
 *
 *
 * @author Administrator
 *
 */
public class IbatorGenExamplePageHelper {
	private int start = 0;
	private int limit = 0;
	private int pageCount = 1;
	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	private boolean pagination ;
	/**
	 * sortname，sortorder用来接收页面空间的排序列和排序方式（针对flexigrid这个表单控件）
	 */
	private String sortname;
	private String sortorder;
	private String typeValue;
	private String stateValue;
	private String upType;
	private String isPic;
	private String name1;
	private String name2;
	
	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getIsPic() {
		return isPic;
	}

	public void setIsPic(String isPic) {
		this.isPic = isPic;
	}

	public String getUpType() {
		return upType;
	}

	public void setUpType(String upType) {
		this.upType = upType;
	}

	public String getStateValue() {
		return stateValue;
	}

	public void setStateValue(String stateValue) {
		this.stateValue = stateValue;
	}

	public String getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getSortorder() {
		return sortorder;
	}

	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getStart() {
		return start;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getLimit() {
		return limit;
	}

	public void enablePagination() {
		this.pagination = true;
	}

	public void disablePagination() {
		this.pagination = false;
	}

	public boolean isPagination() {
		return pagination;
	}

	public int getTotal(){
		return start+limit;
	}
	public int getEnd(){
		return start+limit;
		
	}
}
