<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.json.JSONObject" %>
<%
	String message="处理完成。";
	if(request.getAttribute("message") !=null) {
		message=(String)request.getAttribute("message");
	}
	JSONObject json = new JSONObject();
	json.put("success",true).put("message",message);
%>
<%=json.toString()%>
