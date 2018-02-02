<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String yjUnitupid=request.getParameter("id");
%>
<!DOCTYPE HTML>
<html>
  <head>
    <jsp:include page="../common/include-common.jsp"></jsp:include>	
	<script type="text/javascript" src="<%=request.getContextPath() %>/jscript/sys/duty/yjUnitManage.js"></script>
  </head>
  
<body>
	<div id="unitInfo" style="display: none">    
		<table class="dataTab" id="yjunit">
				<tr>
					<td class="title_td">单位名称：</td>
					<td>
						<input id="selunitName" name="selunitName" readOnly/>
					</td>
					<td class="title_td">单位地址：</td>
					<td>
						<input id="selunitAddress" name="selunitAddress" readOnly/>
					</td>
				</tr>
				<tr>
					<td class="title_td">单位邮编：</td>				
					<td>
						<input id="selpostcode" name="selpostcode"  readOnly/>
					</td>
					<td class="title_td">所属行业：</td>
					<td>
						<input id="selindustryName" name="selindustryName" readOnly/>
					</td>
				</tr>
				<tr>
					<td class="title_td">负责人：</td>
					<td>
						<input id="selunitHead" name="selunitHead" readOnly/>
					</td>
					<td class="title_td">单位电话：</td>
					<td>
						<input id="selphone" name="selphone" readOnly/>
					</td>
				</tr>
				<tr>
					<td class="title_td">单位传真：</td>
					<td>
						<input id="selfax" name="selfax" readOnly/>
					</td>
					<td class="title_td">单位email：</td>
					<td>
						<input id="selemail" name="selemail" readOnly/>
					</td>
				</tr>
				<tr>
					<td class="title_td">单位法人：</td>
					<td>
						<input id="sellegalPerson" name="sellegalPerson"  readOnly/>
					</td>
					<td class="title_td">值班电话：</td>
					<td>
						<input id="seldutyPhone" name="seldutyPhone" readOnly/>
					</td>
				</tr>
				<tr>
					<td class="title_td">值班传真：</td>
					<td>
						<input id="seldutyFax" name="seldutyFax" readOnly/>
					</td>
					<td class="title_td">单位网站：</td>
					<td>
						<input id="selunitWebsite" name="selunitWebsite" readOnly/>
					</td>
				</tr>
				<tr>
					<td class="title_td">主管人：</td>
					<td>
						<input id="seldirectorId" name="seldirectorId" readOnly/>
					</td>
					<td class="title_td">分管人：</td>
					<td>
						<input id="selfgrId" name="selfgrId" readOnly/>
					</td>
				</tr>
				<tr>
					<td class="title_td">排序号：</td>
					<td>
						<input id="selsortId" name="selsortId"  readOnly/>
					</td>
				</tr>
			</table>
	</div>
	<div id="searchDiv">
		<table id="serach-table">
			<tr>
				<td class='title-td'>机构名称:</td>
				<td>
					<input type="text" id="unitNameS" name="unitNameS"/>
				</td>
				<td class="btn-td">
					<input type="button" id="btn_search" name="btn_search" onclick="return search()" value="搜索"/>
				</td>
			</tr>
		</table>
	</div>
	<table id="yjUnitList"></table>
	<div id="yjUnitInfodiv" style="display: none">
		<form id="yjUnitInfo" name="yjUnitInfo" >
		<input type="hidden"  id="upyjUnitId" name="upyjUnitId" value="<%=yjUnitupid %>">
			<table class="dataTab">
				<tr>
					<td class="title_td">单位名称：</td>
					<td>
						<input id="unitId" name="unitId" value="" type="hidden"/>
						<input id="unitName" name="unitName" value="" isempty="no" tip="单位名称不能为空"/><font color="red">*</font>
					</td>
					<td class="title_td">单位地址：</td>
					<td>
						<input id="unitAddress" name="unitAddress" isempty="no" tip="单位地址不能为空"/><font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="title_td">单位邮编：</td>				
					<td>
						<input id="postcode" name="postcode" value="" reg="^\d{6}$" tip="邮编格式不正确"/>
					</td>
					<td class="title_td">所属行业：</td>
					<td>
						<select id="industryCode" name="industryCode"  style="width:160px">
						</select>
						<input id="industryName" name="industryName" value="" type="hidden"/>
					</td>
				</tr>
				<tr>
					<td class="title_td">负责人：</td>
					<td>
						<input id="unitHead" name="unitHead" isempty="no" tip="负责人不能为空"/><font color="red">*</font>
					</td>
					<td class="title_td">单位电话：</td>
					<td>
						<input id="phone" name="phone" value="" reg="(^(\+)?(0\d{2})-(\d{8})$)|(^(\+)?(0\d{3})(\-)?(\d{7,8})$)|((^\+?(0?1[358]\d))-?(\d{8})|(^[2-9]\d{6,7})$)" isempty="no" tip="单位电话不能为空或格式不正确"/><font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="title_td">单位传真：</td>
					<td>
						<input id="fax" name="fax" value="" reg="(^(\+)?(0\d{2})-(\d{8})$)|(^(\+)?(0\d{3})(\-)?(\d{7,8})$)|((^\+?(0?1[358]\d))-?(\d{8})|(^[2-9]\d{6,7})$)" tip="传真格式不正确"/>
					</td>
					<td class="title_td">单位email：</td>
					<td>
						<input id="email" name="email" value="" reg="^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$" tip="邮箱格式不正确" />
					</td>
				</tr>
				<tr>
					<td class="title_td">单位法人：</td>
					<td>
						<input id="legalPerson" name="legalPerson" isempty="no" tip="单位法人不能为空"/><font color="red">*</font>
					</td>
					<td class="title_td">值班电话：</td>
					<td>
						<input id="dutyPhone" name="dutyPhone" value="" reg="(^(\+)?(0\d{2})-(\d{8})$)|(^(\+)?(0\d{3})(\-)?(\d{7,8})$)|((^\+?(0?1[358]\d))-?(\d{8})|(^[2-9]\d{6,7})$)" isempty="no" tip="值班电话不能为空或格式不正确"/><font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="title_td">值班传真：</td>
					<td>
						<input id="dutyFax" name="dutyFax" value="" reg="(^(\+)?(0\d{2})-(\d{8})$)|(^(\+)?(0\d{3})(\-)?(\d{7,8})$)|((^\+?(0?1[358]\d))-?(\d{8})|(^[2-9]\d{6,7})$)" tip="传真格式不正确"/>
					</td>
					<td class="title_td">单位网站：</td>
					<td>
						<input id="unitWebsite" name="unitWebsite" value=""/>
					</td>
				</tr>
				<tr>
					<td class="title_td">主管人：</td>
					<td>
						<input id="directorId" name="directorId" value=""/>
					</td>
					<td class="title_td">分管人：</td>
					<td>
						<input id="fgrId" name="fgrId" value=""/>
					</td>
				</tr>
				<tr>
					<td class="title_td">排序号：</td>
					<td>
						<input id="sortId" name="sortId" value=""  isempty="no" tip="排序号不能为空"/>
					</td>
				</tr>
			</table>
			<div align="center" style="padding-top:20px;">
				<input id="btnYjUnit" name="btnYjUnit" type="button" value="确定" class="btn"/>
			</div>	
		</form>
	</div>
</body>
</html>
