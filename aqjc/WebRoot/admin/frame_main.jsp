<%@ page language="java" import="com.tyust.bean.user.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	
	<title>安全检测信息管理系统</title>
</head>

<frameset rows="90,*,25" cols="*" framespacing="0px" frameborder="no" border="0"> 
	<frame src="<%=request.getContextPath() %>/admin/frame_top.jsp" scrolling="no" name="topframe" /> 
	<frameset rows="*" cols="205,9,*" framespacing="0" frameborder="no"> 
		<frame src="<%=request.getContextPath() %>/findModule.do" name="leftframe" scrolling="auto" /> 
		<frame src="<%=request.getContextPath() %>/admin/frame_middle.jsp" name="middleframe" scrolling="no"/> 
		<frame src="<%=request.getContextPath() %>/admin/frame_welcome.jsp" name="rightframe" id="rightframe" /> 
	</frameset> 
	<frame src="<%=request.getContextPath() %>/admin/frame_bottom.jsp" scrolling="no" name="topframe" /> 
</frameset>

<body>
</body>
</html>
