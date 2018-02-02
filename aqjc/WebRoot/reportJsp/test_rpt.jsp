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
	<span>检测报告>>打印</span>
	<a class="btn-nav" href="javascript:history.go(-1)">返回</a>
</div>
<jsp:include page="/reportJsp/toolbar.jsp" flush="false" />
<%  
	String testRptId = (String)request.getParameter("testRptId");
	String applyId = (String)request.getParameter("applyId");
	//String unitId = (String)request.getParameter("unitId");
	String proUrl = request.getSession().getServletContext().getRealPath("/");//获取web项目的路径
	String picUrl = proUrl+"uploads\\pic\\";
  	request.setCharacterEncoding("UTF-8");
  	String saveAsName="检测报告"+DateHandler.dateToString(new Date(),"yyyy-MM-dd_HHmmss");
  	String param ="rptId="+testRptId+";applyId="+applyId+";picUrl="+picUrl;
%>


<table align=center>
	<tr>
		<td>
			<report:html
				srcType="file"
				exceptionPage="/reportJsp/myError2.jsp"
				funcBarFontSize="13"
				name="report1"
				reportFileName="test_rpt.raq"
				generateParamForm="no"
				saveAsName="<%=saveAsName%>"
		  		params="<%=param%>"
			/>
		</td>
	</tr>
</table>
</body>
</html>
