<%@ page contentType="text/html; charset=UTF-8" import="com.tyust.bean.user.TBaseUserInfo" pageEncoding="UTF-8" %>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath() %>/style/css/sys/sys-common.css" />
	<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath() %>/style/css/sys/navCommon.css" />
    <script src="<%=request.getContextPath() %>/jscript/jquery-1.8.3.min.js"></script>
	<script src="<%=request.getContextPath() %>/jscript/sys/Frame-Tree-MessageList.js"></script>
	<title></title>
</head>
<body>
	<%
	TBaseUserInfo user = (TBaseUserInfo)request.getSession().getAttribute("user");
	String unitId = user.getUnitId();
	String flag = request.getParameter("flag");
	
	if(flag.equals("1")){//部门管理
	%>
	<div id="Nav">
		<span>系统管理>>单位管理</span>
		<a class="btn-nav" href="javascript:history.go(-1)">返回</a>
	</div>
	<div style="height:90%;">
		<iframe name="frame_left"  width="20%"  src="<%=request.getContextPath() %>/tree.do?jspName=admin/sys/unit/unitList.jsp&unitId=<%=unitId%>"  frameborder="0" scrolling="yes" marginwidth="0" marginheight="0"></iframe>
		<iframe name="frame_right" width="75%" src="../sys/unit/unitList.jsp?unitid=<%=unitId %>"  scrolling="auto" frameborder="0" marginwidth="0" marginheight="0" ></iframe>
	</div>    
	<%
	} if(flag.equals("3")){//用户管理
	%>
	<div id="Nav">
		<span>系统管理>>用户管理</span>
		<a class="btn-nav" href="javascript:history.go(-1)">返回</a>
	</div>
	<div style="height:90%;">
		<iframe name="frame_left"  width="25%"  src="<%=request.getContextPath() %>/tree.do?jspName=admin/sys/user/userList.jsp&unitId=<%=unitId %>"  frameborder="0" scrolling="yes" marginwidth="0" marginheight="0"></iframe>
		<iframe name="frame_right" width="75%" style="float:left; " src="../sys/user/userList.jsp?unitid=<%=unitId %>"   scrolling="auto" frameborder="0" marginwidth="0" marginheight="0" ></iframe>
	</div>
	<%
	} if(flag.equals("2")){//角色管理
	%>
	<div id="Nav">
		<span>系统管理>>角色管理</span>
		<a class="btn-nav" href="javascript:history.go(-1)">返回</a>
	</div>
	<div style="height:90%;">
		<iframe name="frame_left"  width="25%"  src="<%=request.getContextPath() %>/tree.do?jspName=admin/sys/user/roleList.jsp&unitId=<%=unitId %>"  frameborder="0" scrolling="yes" marginwidth="0" marginheight="0"></iframe>
		<iframe name="frame_right" width="75%" style="float:left;" src="../sys/user/roleList.jsp?unitid=<%=unitId %>" scrolling="auto" frameborder="0" marginwidth="0" marginheight="0" ></iframe>
	</div>
	<%} %>    
</body>
</html>