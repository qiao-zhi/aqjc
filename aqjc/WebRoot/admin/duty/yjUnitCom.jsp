<%@ page contentType="text/html; charset=UTF-8" import="com.tyust.bean.user.TBaseUserInfo" pageEncoding="UTF-8" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath() %>/style/css/sys/sys-common.css" />
    <script src="<%=request.getContextPath() %>/jscript/jquery-1.8.3.min.js"></script>
	<script src="<%=request.getContextPath() %>/jscript/sys/Frame-Tree-MessageList.js"></script>
<title>应急单位列表</title>
</head>
<body>
	<%
	TBaseUserInfo user = (TBaseUserInfo)request.getSession().getAttribute("user");
	String unitId = user.getUnitId();//当前登录用户的机构
	String flag = request.getParameter("flag");
	
	if(flag.equals("1")){//机构管理
	%>
		<iframe name="frame_left"  src="<%=request.getContextPath() %>/yjUnit/yjUnit_selectTreeByUnitId.do?jspName=admin/duty/yjUnitList.jsp&flag=0&id=<%=unitId %>"  frameborder="0" scrolling="no" marginwidth="0" marginheight="0"></iframe>
		<iframe name="frame_right" src="yjUnitList.jsp?id=<%=unitId %>"  scrolling="auto" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
	<%
	}else if(flag.equals("2")){//联系人管理
	%>
		<iframe name="frame_left"  src="<%=request.getContextPath() %>/yjUnit/yjUnit_selectTreeByUnitId.do?jspName=admin/duty/yjUnitContactList.jsp&flag=0&id=<%=unitId %>"  frameborder="0" scrolling="no" marginwidth="0" marginheight="0"></iframe>
		<iframe name="frame_right" src="yjUnitContactList.jsp?id=<%=unitId %>"  scrolling="auto" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
	<%
	
	}else if(flag.equals("3")){//用户管理
	%>
		<iframe name="frame_left"  src="<%=request.getContextPath() %>/yjUnit/yjUnit_selectTreeByUnitId.do?jspName=admin/sys/user/userList.jsp&flag=0&id=<%=unitId %>"  frameborder="0" scrolling="no" marginwidth="0" marginheight="0"></iframe>
		<iframe name="frame_right" style="float:left;" src="../sys/user/userList.jsp?id=<%=unitId %>"   scrolling="auto" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
	<%
	}else if(flag.equals("4")){//角色管理
	%>
		<iframe name="frame_left"  src="<%=request.getContextPath() %>/yjUnit/yjUnit_selectTreeByUnitId.do?jspName=admin/sys/user/roleList.jsp&flag=0&id=<%=unitId %>"  frameborder="0" scrolling="no" marginwidth="0" marginheight="0"></iframe>
		<iframe name="frame_right" style="float:left;" src="../sys/user/roleList.jsp?id=<%=unitId %>" scrolling="auto" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
	<%
	}else if(flag.equals("5")){//值班管理
	%>
		<iframe name="frame_left"  src="<%=request.getContextPath() %>/yjUnit/yjUnit_selectTreeByUnitId.do?jspName=admin/duty/dutyList.jsp&flag=0&id=<%=unitId %>"  frameborder="0" scrolling="no" marginwidth="0" marginheight="0"></iframe>
		<iframe name="frame_right" style="float:left;" src="dutyList.jsp?id=<%=unitId %>" scrolling="auto" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
	<%
	}else {//全部机构
	%>
		<iframe name="frame_left"  src="<%=request.getContextPath() %>/yjUnit/yjUnit_getItemById.do?jspName=admin/duty/yjUnitList.jsp&flag=0&id=0"  frameborder="0" scrolling="no" marginwidth="0" marginheight="0"></iframe>
		<iframe name="frame_right" style="float:left;" src="yjUnitList.jsp?id=0" scrolling="auto" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
	<%
	}
	%>
</body>
</html>