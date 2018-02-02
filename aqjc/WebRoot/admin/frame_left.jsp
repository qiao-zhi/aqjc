<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta  charset="utf-8"/>

	<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath() %>/style/css/sys/commonFrame.css" />
	<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath() %>/style/css/sys/leftFrame.css" />
	<script src="<%=request.getContextPath()%>/jscript/jquery-1.8.3.min.js"></script>
	<script src="<%=request.getContextPath()%>/jscript/sys/frame_left.js"></script>
	<script type="text/javascript">
	var urlPre = "<%=request.getContextPath() %>/";
	function showPage(url){
		$(window.parent.document.getElementById('rightframe')).attr("src",urlPre+url);
	}
	</script>
</head>
<body>
	<div id="Nav_postion">
	   <%
	    out.println(request.getAttribute("result"));
	   %>
   </div>
</body>
</html>