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
				<span><a href="admin/sys/dic/dicList.jsp?id=0" target="dic_right">字典列表</a></span>
				<ul>
                   <c:forEach items="${dicList}" var="dic" varStatus="vs">
				<li id="${dic.dictionaryOptionId}" >
				<span></span>
				<a href="admin/sys/dic/dicList.jsp?id=${dic.dictionaryOptionId}" target="dic_right">${dic.dictionaryOptionName}</a>
				<ul class="ajax">
						<li id="${dic.dictionaryOptionId}">
								{url:finddic_getItemById.do?id=}${dic.dictionaryOptionId}
						</li>
				</ul>
				</li>
		         	</c:forEach>
			</li>
		</ul>
	</body>
	<script src="<%=request.getContextPath() %>/controls/simpleTree/index.js"></script>
</html>



