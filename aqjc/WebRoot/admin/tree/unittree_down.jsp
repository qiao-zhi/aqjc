<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String jspName =(String) request.getAttribute("jspName");
%>
	
	<ul id="juli">
		<c:forEach items="${unitList}" var="unit" varStatus="vs">
		 <li id="${unit.unitId}" >
			<span></span>
			<a href="<%=jspName%>?unitid=${unit.unitId}&unitname=${unit.unitName}"
			 target="frame_right">${unit.unitName}</a>
			<ul class="ajax">
					<li id="${unit.unitId}">
							{url:findUnitByUpId.do?upId=${unit.unitId}&jspName=<%=jspName %>}
					</li>
			</ul>
		 </li>
		</c:forEach>	
	</ul>
	
			
		