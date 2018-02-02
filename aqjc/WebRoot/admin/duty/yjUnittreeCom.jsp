<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String id = request.getParameter("id");
	String jspName = (String)request.getAttribute("jspName");
%>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/controls/simpleTree/simpleTree.css" />
	<script src="<%=request.getContextPath() %>/jscript/jquery-1.8.3.min.js"></script>
	<script src="<%=request.getContextPath() %>/controls/simpleTree/js/jquery.simple.tree.js"></script>
	<title>单位部门列表</title>
</head>
<body onload="open();">	
		<ul class="simpleTree" >
			<li class="root" id='1'>
			 <%
				if("cb5a1fd7-7286-4dc8-871c-434a2745e1f7".equals(id)&&jspName.endsWith("yjUnitList.jsp")){
					%>
					<span><a href="<%=request.getContextPath() %>/admin/duty/yjUnitList.jsp?id=0" target="frame_right">单位部门列表</a></span>
					<%
				}else{
					%> 
					<span>单位部门列表</span>
			<%
				}
			%> 
				<ul  id="anserdh">
                   <c:forEach items="${yjList}" var="yjUnit" varStatus="vs">
					<li id="${yjUnit.unitId}" >
						<span></span>
						<a href="<%=request.getContextPath() %>/<%=jspName %>?id=${yjUnit.unitId}" target="frame_right">${yjUnit.unitName}</a>
						<ul class="ajax">
							<li id="${yjUnit.unitId}">
								{url:yjUnit_getItemById.do?id=${yjUnit.unitId}&jspName=<%=jspName%>}
							</li>
						</ul>
					</li>
		         	</c:forEach>
	         	</ul>
			</li>
		</ul>
	</body>
	<script src="<%=request.getContextPath() %>/controls/simpleTree/index.js"></script>
	<script type="text/javascript">
	function open (){
		var TREE = $('.simpleTree')[0];
		var obj = $('#anserdh li')[1];
		obj.className = obj.className.replace('close','open');
		var childUl = $('>ul',obj);
		childUl.animate({height:"toggle"},TREE.option.speed, function(){
			if(childUl.is('.ajax'))TREE.setAjaxNodes(childUl, obj.id);
		});
	}
	</script>
</html>