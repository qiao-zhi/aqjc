<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.tyust.bean.user.TBaseUserInfo" %>
<%
	TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">

<title>用户信息</title>
<style>
	body {padding: 10px}
	.lable-td {text-align:right;padding-top:8px;padding-bottom:8px;font-size:14px;}
	.input-td {padding-left:10px;}
	#infoTab input{width:250px;height:25px;}
	#infoTab textarea {width:250px; height:40px; font-size:14px}
</style>

<script src="<%=request.getContextPath() %>/newStyle/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script>
$(function(){
	$("#up_sex").val("<%=user.getSex()%>");
	$("#up_userComment").val("<%=user.getUserComment()%>");
});
	function saveUserInfo(){
		$.ajax({
			url : '<%=request.getContextPath() %>/editUser_updateUserInfo.do',
			data : $("#userInfoFm").serialize(),
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
<form id="userInfoFm">
	<table align="center" id="infoTab">
		<tr>
			<th colspan="2" align="center" style="font-size:18px;padding-bottom:20px;">用户信息</th>
		</tr>
		<tr>
			<td class="lable-td">用户名：</td>
			<td class="input-td">
				<input id="up_userName" name="userName" readonly="readonly" value="<%=user.getUserName() %>"/>
				<input type="hidden" name="userId" value="<%=user.getUserId() %>"/>
			</td>
		</tr>
		<tr>
			<td class="lable-td">姓名：</td>
			<td class="input-td">
				<input id="up_name" name="name" value="<%=user.getName()%>"/>
			</td>
		</tr>
		<tr>
			<td class="lable-td">性别：</td>
			<td class="input-td">
				<select id="up_sex" name="sex" style="width:80px;height:23px;">
					<option value="0">男</option>
					<option value="1">女</option>
				</select>
			</td>
		</tr>
		<tr>
			<td class="lable-td">职务：</td>
			<td class="input-td">
				<input id="up_duty" name="duty" value="<%=user.getDuty()%>"/>
			</td>
		</tr>
		<tr>
			<td class="lable-td">联系方式：</td>
			<td class="input-td">
				<input id="up_telephone" name="telephone" value="<%=user.getTelephone()%>"/>
			</td>
		</tr>
		<tr>
			<td class="lable-td">电子邮件：</td>
			<td class="input-td">
				<input id="up_email" name="email" value="<%=user.getEmail()%>"/>
			</td>
		</tr>
		<tr>
			<td class="title_td">其他说明：</td>
			<td class="input-td"><textarea id="up_userComment" name="userComment"/></textarea></td>
		</tr>
	</table>
	<input type="hidden" name="inuse" value="1"/>
	<div align="center" style="padding-top:30px;">
		<input type="button" value="保存 " onclick="saveUserInfo()" style="padding:10px;"/>
	</div>
</form>
</div>
</body>
</html>