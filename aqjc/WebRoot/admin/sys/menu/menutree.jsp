<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/controls/simpleTree/simpleTree.css" />
	<script src="<%=request.getContextPath() %>/jscript/jquery-1.8.3.min.js"></script>
	<script src="<%=request.getContextPath() %>/controls/simpleTree/js/jquery.simple.tree.js"></script>
</head>

<body>
	<ul class="simpleTree">
		<li class="root" id='1'>
			<span>
				<a href="admin/sys/menu/menuList.jsp?id=0" target="menu_right">菜单列表</a>
			</span>
			<ul>
            <c:forEach items="${moduleList}" var="c" varStatus="vs">
				<li id="${c.moduleId}" >
					<span></span>
					<a href="admin/sys/menu/menuList.jsp?id=${c.moduleId}" target="menu_right">${c.moduleName}(${c.moduleId })</a>
					<ul class="ajax">
						<li id="${c.moduleId}">{url:<%=request.getContextPath() %>/findModule_findModuleByUpid.do?id=}${c.moduleId}</li>
					</ul>
				</li>
		    </c:forEach>
		</li>
	</ul>
	<script src="<%=request.getContextPath() %>/controls/simpleTree/index.js"></script>
</body>
</html>