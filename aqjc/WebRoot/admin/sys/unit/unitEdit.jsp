<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.tyust.dao.unit.IunitDao,com.tyust.bean.unit.TBaseUnitInfo"%>
<%@ page import="com.tyust.bean.user.TBaseUserInfo" %>
<%
	TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
	ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
	String unitId = user.getUnitId();
	IunitDao unitDao = (IunitDao)context.getBean("Unit");
	TBaseUnitInfo unit = unitDao.findUnit(unitId);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">

<title>单位信息</title>
<style>
	body {padding: 10px}
	.lable-td {text-align:right;padding-top:8px;padding-bottom:8px;font-size:14px;}
	.input-td {padding-left:10px;}
	#infoTab input {width:300px;height:25px;}
	#infoTab textarea {width:300px; height:50px; font-size:14px}
</style>

<script src="<%=request.getContextPath() %>/newStyle/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script>
$(function(){
	$("#up_address").val("<%=unit.getAddress()%>");
});
	function saveUserInfo(){
		$.ajax({
			url : '<%=request.getContextPath() %>/updateUnit.do',
			data : $("#unitInfoFm").serialize(),
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				var data = eval(data);
				if(data.success){
					alert(data.message);
				}else{
					alert(data.message);
				}
			}
		});
	}
</script>
</head>
<body>
<div style="border:1px solid #999;width:100%;padding-top:20px;padding-bottom:50px;">
<form id="unitInfoFm">
	<table align="center" id="infoTab">
		<tr>
			<th colspan="2" align="center" style="font-size:18px;padding-bottom:20px;">部门信息</th>
		</tr>
		<tr>
			<td class="lable-td">单位名称：</td>
			<td class="input-td">
				<input name="updateunitName" readonly="readonly" value="<%=unit.getUnitName() %>"/>
				<input type="hidden" name="updateunitId" value="<%=unit.getUnitId() %>"/>
			</td>
		</tr>
		<tr>
			<td class="lable-td">单位缩写：</td>
			<td class="input-td">
				<input name="updateunitClass" value="<%=unit.getUnitClass()%>"/>
			</td>
		</tr>
		<tr>
			<td class="lable-td">联系人：</td>
			<td class="input-td">
				<input name="updatecontactPerson" value="<%=unit.getContactPerson() %>"/>
			</td>
		</tr>
		<tr>
			<td class="lable-td">联系电话：</td>
			<td class="input-td">
				<input name="updatetelephone" value="<%=unit.getTelephone()%>"/>
			</td>
		</tr>
		<tr>
			<td class="lable-td">电子邮件：</td>
			<td class="input-td">
				<input name="updateemail" value="<%=unit.getEmail()%>"/>
			</td>
		</tr>
		<tr>
			<td class="lable-td">传真：</td>
			<td class="input-td">
				<input name="updateheader" value="<%=unit.getHeader()%>"/>
			</td>
		</tr>
		<tr>
			<td class="lable-td">地址：</td>
			<td class="input-td">
				<input id="up_address" name="updateaddress" value="<%=unit.getAddress() %> "/>
			</td>
		</tr>
	</table>
	<div align="center" style="padding-top:30px;">
		<input type="hidden" name="inuse" value="1"/>
		<input type="button" value="保存 " onclick="saveUserInfo()" style="padding:10px;"/>
	</div>
</form>
</div>
</body>
</html>