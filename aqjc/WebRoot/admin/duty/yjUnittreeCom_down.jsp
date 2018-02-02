<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String jspName = (String)request.getAttribute("jspName");
%>
<ul id="juli">
	<c:forEach items="${yjList}" var="yjUnit" varStatus="vs">
		<li id="${yjUnit.unitId}"><span></span>
          <a href="<%=request.getContextPath() %>/<%=jspName %>?id=${yjUnit.unitId}"
			target="frame_right">${yjUnit.unitName}</a>
			<ul class="ajax">
				<li id="${yjUnit.unitId}">
					{url:yjUnit_getItemById.do?id=${yjUnit.unitId}&jspName=<%=jspName%>}</li>
			</ul>
		</li>
	</c:forEach>

</ul>