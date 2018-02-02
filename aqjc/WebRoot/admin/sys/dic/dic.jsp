<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>字典管理</title>
   
    <meta charset="utf-8"/>
    <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath() %>/style/css/sys/sys-common.css" />
    <script src="<%=request.getContextPath() %>/jscript/jquery-1.8.3.min.js"></script>
	<script src="<%=request.getContextPath() %>/jscript/sys/Frame-Tree-MessageList.js"></script>
</head>
  
<body>
	<iframe name="dic_left"  src="<%=request.getContextPath() %>/finddic_getItemById.do?id=0"  frameborder="0" scrolling="no" marginwidth="0" marginheight="0"></iframe>
	<iframe name="dic_right" src="dicList.jsp?id=0"  scrolling="auto" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>
</body>
</html>