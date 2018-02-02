<%@ page language="java" pageEncoding="utf-8"%>
<%
String unitId=request.getParameter("id");
%>
<!DOCTYPE HTML>
<html>
  <head>
    <jsp:include page="../common/include-common.jsp"></jsp:include>	
	<script type="text/javascript" src="<%=request.getContextPath() %>/jscript/sys/duty/yjUnitContactManage.js"></script>
  	<style>
  	.flexigrid div.tDiv {
  		height: 27px;
  	}
  	.flexigrid div.tDiv2 {
	    width: 100%;
	}
  	</style>
  </head>
  
<body>
	<div id="searchDiv">
		<table id="serach-table">
			<tr>
				<td class='title-td'>姓名:</td>
				<td>
					<input type="text" id="nameS" name="nameS"/>
				</td>
				<td class="btn-td">
					<input type="button" id="btn_search" name="btn_search" onclick="return search()" value="搜索"/>
				</td>
			</tr>
		</table>
		
	</div>
	<table id="yjUnitContactList"></table>
	<div id="yjUnitContactInfodiv" style="display: none">
		<form id="yjUnitContactInfo" name="yjUnitContactInfo" method="post">
			<table class="dataTab">
				<tr>
					<td class="title_td">姓名：</td>
					<td>
						<input type="hidden"  id="unitId" name="unitId" value="<%=unitId %>">
						<input id="contactId" name="contactId" value="" type="hidden"/>
						<input id="name" name="name" value="" isempty="no" tip="姓名不能为空"/><font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="title_td">性别：</td>
					<td>
						<select id="sex" name="sex"><option value="男">男</option><option value="女">女</option></select>
					</td>
				</tr>
				<tr>
					<td class="title_td">职务：</td>
					<td>
						<input id="position" name="position" value=""/>
					</td>
				</tr>
				<tr>
					<td class="title_td">手机号码：</td>				
					<td>
						<input id="telephone" name="telephone" value="" reg="(^(\+)?(0\d{2})-(\d{8})$)|(^(\+)?(0\d{3})(\-)?(\d{7,8})$)|((^\+?(0?1[358]\d))-?(\d{8})|(^[2-9]\d{6,7})$)" isempty="no" tip="手机号码不能为空或格式不正确"/><font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="title_td">电话号码：</td>
					<td>
						<input id="mobilePhone" name="mobilePhone" value="" reg="(^(\+)?(0\d{2})-(\d{8})$)|(^(\+)?(0\d{3})(\-)?(\d{7,8})$)|((^\+?(0?1[358]\d))-?(\d{8})|(^[2-9]\d{6,7})$)"  tip="格式不正确"/>
					</td>
				</tr>				
			</table>
			<div align="center" style="padding-top:20px;">
				<input id="btnYjUnitContact" name="btnYjUnitContact" type="button" value="确定" class="btn"/>
			</div>	
		</form>
	</div>
</body>
</html>

