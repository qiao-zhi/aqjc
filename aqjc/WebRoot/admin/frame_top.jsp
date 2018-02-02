<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.tyust.bean.user.TBaseUserInfo,com.tyust.common.*,java.util.*"%>
<%
TBaseUserInfo  user = (TBaseUserInfo )request.getSession().getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
	
	<meta  charset="utf-8"/>
	
	<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath() %>/style/css/sys/commonFrame.css" />
	<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath() %>/style/css/sys/topFrame.css" />
	<script src="<%=request.getContextPath()%>/jscript/jquery-1.8.3.min.js"></script>
	<script src="<%=request.getContextPath()%>/jscript/sys/frame_top.js"></script>
	<script type="text/javascript">
	/* $(function(){
		$.ajax({
			url : '${pageContext.request.contextPath}/weather_getWeather.do',
			data : {'city':"太原"},
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var json = eval(response);
				if(json!=null){
					var info = json.data.split("#");
					if(info.length>=21){
					//1
						$("#weather11").html(info[7]+info[5]);
						$("#weather12").attr("src","../style/images/tqimgs/"+info[8]);
						$("#weather13").attr("src","../style/images/tqimgs/"+info[9]);
						$("#weather14").html(info[6]);
					//2
						$("#weather21").html(info[14]+info[12]);
						$("#weather22").attr("src","../style/images/tqimgs/"+info[15]);
						$("#weather23").attr("src","../style/images/tqimgs/"+info[16]);
						$("#weather24").html(info[13]);
					//3
						$("#weather31").html(info[19]+info[17]);
						$("#weather32").attr("src","../style/images/tqimgs/"+info[20]);
						$("#weather33").attr("src","../style/images/tqimgs/"+info[21]);
						$("#weather34").html(info[18]);
					}else{
						
					}
				}
			}
		});
	}) */
	</script>
</head>

<body>
	<!-- <div id="topFrame_weather">
		<table border="0">
			<tr align="center">
			<td >
				<table >
					<tr align="center">
						<td><span id="weather11" style="font-size:12px;color:red"></span></td>
					</tr>
					<tr align="center">
						<td><img id="weather12"/> <img id="weather13"/></td>
					</tr>
					<tr align="center">
						<td>
							<span id="weather14" style="font-size:12px;color:red"></span>
						</td>
					</tr>
				</table>
			</td>
			

			<td>
				<table align="center">
					<tr align="center">
						<td><span id="weather21" style="font-size:12px;"></span></td>
					</tr>
					<tr align="center">
						<td><img id="weather22"/> <img id="weather23"/></td>
					</tr>
					<tr align="center">
						<td>
							<span id="weather24" style="font-size:12px;"></span>
						</td>
					</tr>
				</table></td>


			<td>
				<table align="center">
					<tr align="center">
						<td><span id="weather31" style="font-size:12px;"></span></td>
					</tr>
					<tr align="center">
						<td><img id="weather32"/> <img id="weather33"/></td>
					</tr>
					<tr align="center">
						<td>
							<span id="weather34" style="font-size:12px;"></span>
						</td>
					</tr>
				</table>
			</td>
		</tr>

	</table>
	</div> -->
	<div id="topFrame_postion">
		<div id="topFrame_time"></div>
		<div id="topFrame_info">
			<span id="dutyCase" style="color:red;margin-left:20px;float:left"></span>
			<span style="margin-right:10px;">欢迎您，<%=user.getUserName()%></span>
			<a target="rightframe" href="<%=request.getContextPath() %>/admin/sys/user/updatePassword.jsp"><span class="topFrame_icon_updataPassword">修改密码</span></a>
		    <span class="topFrame_icon_exitlogin" onclick="logout()">退出登录</span> 
		</div>
	</div>
</body>
</html>
