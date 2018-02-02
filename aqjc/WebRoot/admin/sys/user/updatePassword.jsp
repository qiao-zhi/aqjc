<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>
  	<jsp:include page="../../common/include-common.jsp"></jsp:include>
  	<style>
	html,body {height: 100%}
	body {margin: 0;padding: 0}
	#PosWel {height:100%;width:100%; font-size: 42px;color: #f90; font-weight: bold; font-family: "黑体"; border-collapse:collapse;}
	#PosWel td {text-align: center; vertical-align: middle;}
	</style>
	<script type="text/javascript">
	$(function(){
		$.dialog({
			content:$("#updateTab")[0],
			title:'修改用户密码',
			id:'idSerach',
			lock :true,
			background :'#000',
			opacity:0.5
		});
		$("#btn_updatePwd").click(function(){
				if (!validate($("#updatePasswordForm"))){
					$.ajax({
						type:"POST",
						url:"${pageContext.request.contextPath}/editUser_updatePwd.do?oldpwd="+$('#oldPwd').val()+'&newpwd='+$('#newPwd').val()+'&renewpwd='+$('#twicePwd').val(),
						dataType : 'json',
						success:function(data){
							alert(data.message);
							//window.location.href="${pageContext.request.contextPath}/admin/frame_welcome.jsp";
							history.back();
						}
					});
				  }
				});
	});	
		</script>
  </head>
  
  <body>
  	<table id="PosWel">
		<tr>
			<td>欢迎使用安全检测信息管理系统</td>
		</tr>
	</table>
	<div id="updateTab" style="display: none">
		<form id="updatePasswordForm">
			<table class="dataTab">
				<tr>
					<td class="title_td">原密码</td>
					<td>
						<input type="password" id="oldPwd" name="oldPwd" isempty="no" tip="原密码不能为空"/>
					</td>
				</tr>
				<tr>
					<td class="title_td">新密码</td>
					<td>
						<input type="password" id="newPwd" name="newPwd" rep="^\w+$" isempty="no" tip="新密码不能为空或格式只能为数字字母下划线"/>
					</td>
				</tr>
				<tr>
					<td class="title_td">确认新密码</td>
					<td>
						<input type="password" id="twicePwd" name="twicePwd"  rep="^\w+$" isempty="no" tip="确认密码不能为空"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" style="padding-top:10px;">
						<span id="btn_updatePwd" class="btn" >确定</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
  </body>
</html>
