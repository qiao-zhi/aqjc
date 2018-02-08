<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 定义一个全局变量，在JSP中使用 -->
<c:set var="baseurl" value="${pageContext.request.contextPath}"></c:set>
<!-- 定义一JS全局变量，在JS中使用 -->
<script>var contextPath='${baseurl}'</script>