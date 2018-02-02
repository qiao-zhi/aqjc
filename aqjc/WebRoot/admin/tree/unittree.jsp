<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String jspName = (String)request.getAttribute("jspName");
	String unitId = (String)request.getAttribute("unitId");
%>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/controls/simpleTree/simpleTree.css" />
	<script src="<%=request.getContextPath() %>/jscript/jquery-1.8.3.min.js"></script>
	<script src="<%=request.getContextPath() %>/controls/simpleTree/js/jquery.simple.tree.js"></script>
	<title>单位列表</title>
</head>
<body>
	<div style="border:1px solid #999;padding:20px;height:300px;">	
		<ul class="simpleTree">
			<li class="root" id='1'>
				<%if(jspName.endsWith("unitList.jsp")){ %>
				<span><a href="<%=jspName%>?unitid=<%=unitId %>" target="frame_right">单位列表</a></span>
				<%}else{ %>
				<span>选择单位</span>
				<%} %>
				<ul>
				  <c:forEach items="${unit}" var="c" varStatus="vs">
					<li id="${c.unitId}" >
						<span></span>
						<a href="<%=jspName%>?unitid=${c.unitId}&unitname=${c.unitName}" target="frame_right">${c.unitName}</a>
						<ul class="ajax">
							<li id="${c.unitId}">
								{url:findUnitByUpId.do?upId=${c.unitId}&jspName=<%=jspName %>}
							</li>
						</ul>
					</li>
				  </c:forEach>
				</ul> 
			</li>
		</ul>
	</div>
<script src="<%=request.getContextPath() %>/controls/simpleTree/index.js"></script>
</body>
	
</html>