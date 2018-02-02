<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul id="juli">

	<c:forEach items="${dicList}" var="dic" varStatus="vs">
		<li id="${dic.dictionaryOptionId}"><span></span> <a
			href="admin/sys/dic/dicList.jsp?id=${dic.dictionaryOptionId}"
			target="dic_right">${dic.dictionaryOptionName}</a>
			<ul class="ajax">
				<li id="${dic.dictionaryOptionId}">
					{url:finddic_getItemById.do?id=${dic.dictionaryOptionId}} </li>
			</ul></li>
	</c:forEach>

</ul>



