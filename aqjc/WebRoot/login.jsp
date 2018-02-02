<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.tyust.common.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>山西省机要局安全检测信息管理系统</title>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/controls/easyvalidator/css/validate.css" />
<script type="text/javascript" src="jscript/jquery-1.8.3.min.js"></script>
<script
	src="<%=request.getContextPath()%>/controls/easyvalidator/js/easy_validator.pack.js"></script>
<script
	src="<%=request.getContextPath()%>/controls/easyvalidator/js/jquery.bgiframe.min.js"></script>
<script type="text/javascript">
function login(){
	if (!validate($("#form_login"))){
		$.ajax({
			url : "<%=request.getContextPath()%>/login.do",
			data : $("#form_login").serialize(),
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var data=eval(response)
				if(!data.success)
					alert(data.message)
				else
					window.location.href='admin/frame_main.jsp'
				
			}
		});
	}
};

//下面函数使得登录时按回车键调用登录按钮
$(function() {
	var $inp = $('input');
    $inp.bind('keydown', function (event){ 
		var key = event.which;
		//alert(key);
		if(key == 13){
			event.preventDefault();
			$("#btn_login").click();
		}
	});
});
</script>
<style>
* {
	margin: 0;
	padding: 0;
}

#username_ap {
	background: url("style/images/sys/user.png") no-repeat scroll 45px
		center transparent;
}

#password_ap {
	background: url("style/images/sys/pwd.png") no-repeat scroll 45px center
		transparent;
}

#apDiv ul {
	list-style: none outside none;
	margin: 0;
	padding: 0;
}

#apDiv ul li {
	height: 50px;
	line-height: 50px;
}

#apDiv ul li input {
	background: none repeat scroll 0 0 transparent;
	border: medium none;
	margin-left: 70px;
	width: 160px;
	height: 22px;
	line-height: 22px;
}

#btn_login {
	background: url("style/images/sys/btn_login.png") no-repeat scroll 0 0
		transparent;
	border: medium none;
	cursor: pointer;
	float: left;
	height: 32px;
	margin-right: 35px;
	width: 200px;
}

#apDiv #button_div {
	margin-left: 45px;
	margin-top: 5px;
}

#copyright {
	color: #648CB8;
	font-size: 14px;
	height: 20px;
	left: 400px;
	position: relative;
	text-align: center;
	top: 40px;
	width:600px;
}

.tip {
	font-size: 12px;
	line-height: 20px;
}

#check_ap {
	font-size: 12px;
	line-height: 20px;
}

#check_ap input {
	width: 20px;
}

#isRemember {
	width: 20px;
}
</style>
</head>
<body style="background-color: #E7EBEE;">
	<div>
		<form id="form_login">
			<div style="height: 100px"></div>
			<div
				style="background: url('style/images/sys/bg_small.png') repeat-x;">
				<div
					style="background: url('style/images/sys/login1.png') no-repeat; height: 310px; margin: 0 auto; width: 1012px;">
					<div
						style="left: 565px; top: 122px; position: relative; width: 250px"
						id="apDiv">
						<ul>
							<li id="username_ap"><input type="text" id="username"
								name="username" isempty="no" tip="用户名不能为空!"  /></li>
							<li id="password_ap"><input type="password" id="userpsd"
								rep="^\w+$" name="userpsd" isempty="no"
								tip="密码不能为空或格式只能为数字字母下划线！"  /></li>

							<!-- <li id="check_ap" style="line-height: 20px;height:20px;text-align: left;">
			     		<a href="register.jsp" style="width:20px;margin-left: 135px;vertical-align: middle;">没有用户？点击注册</a>
			     	</li>
			     	 -->
						</ul>
						<div id="button_div">
							<input type="button" id="btn_login" onclick="login()" />
						</div>
					</div>
				</div>
			</div>
			<div id="copyright">
				<span style="font-family: arial;">CopyRight&nbsp;©<%=DateHandler.dateToString(new Date(),"yyyy") %>
					&nbsp;山西省委机要局&nbsp;安全检测信息管理系统 &nbsp;&nbsp;All Rights Reserved&nbsp; <br>联系电话：0351-4019002
				</span>
			</div>
		</form>
	</div>
</body>
</html>