<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/runqianReport4.tld" prefix="report"%>
<%@page import="java.util.*,com.tyust.common.*" %>
<!DOCTYPE html>
<html >
<head>
<jsp:include page="/admin/common/include-common.jsp"></jsp:include>
</head>
<body topmargin=0 leftmargin=0 rightmargin=0 bottomMargin=0>
<div id="Nav">
	<span>丢失单管理>>打印丢失单</span>
	<a class="btn-nav" href="javascript:history.go(-1)">返回</a>
</div>
<jsp:include page="/reportJsp/toolbar.jsp" flush="false" />
<%  
String loseId = (String)request.getParameter("loseId");
String depName = (String)request.getParameter("depName");
//获取由参数表单传递的值
  request.setCharacterEncoding("UTF-8");
  String saveAsName="丢失单"+DateHandler.dateToString(new Date());
  String param ="loseId="+loseId+";depName="+depName;
%>


<table align=center>

	<tr><td>
	<report:html
		srcType="file"
		exceptionPage="/reportJsp/myError2.jsp"
		funcBarFontSize="13"
		name="report1"
		reportFileName="tool_lose.raq"
		generateParamForm="no"
		saveAsName="<%=saveAsName%>"
  		params="<%=param%>"


	/>
	</td></tr>
</table>
</body>
</html>
