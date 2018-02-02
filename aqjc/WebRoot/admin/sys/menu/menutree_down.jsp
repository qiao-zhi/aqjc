<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		
<ul id="juli">
	<c:forEach items="${moduleList}" var="c" varStatus="vs">
	<li id="${c.moduleId}" >
		<span></span>
		<a href="admin/sys/menu/menuList.jsp?id=${c.moduleId}" target="menu_right">${c.moduleName}(${c.moduleId })</a>
		<ul class="ajax">
			<li id="${c.moduleId}">{url:<%=request.getContextPath() %>/findModule_findModuleByUpid.do?id=}${c.moduleId}</li>
		</ul>
	</li>
	</c:forEach>
</ul>
