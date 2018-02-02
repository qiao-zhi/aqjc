<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.tyust.bean.user.TBaseUserInfo" %>
<%@ page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.tyust.dao.unit.IunitDao,com.tyust.bean.unit.TBaseUnitInfo"%>
<%
	TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
	ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
	String unitId = user.getUnitId();
	IunitDao unitDao = (IunitDao)context.getBean("Unit");
	TBaseUnitInfo unit = unitDao.findUnit(unitId);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">

<title></title>
<jsp:include page="../common/include-common.jsp"></jsp:include>
<style>
	.lable-td {text-align:right;padding-top:8px;padding-bottom:8px;font-size:14px;}
	.input-td {padding-left:10px;}
	.infoTab {width:750px;}
	.infoTab input{width:200px;height:22px;}
	.infoTab textarea{width:600px;height:150px;}
	#selectedDveTab {width:720px;}
	#selectedDveTab tr td {text-align:center;padding-top:5px;padding-bottom:5px;font-size:13px;}
	.col-head {font-weight:bold;}
</style>

<script>
	function savePbsInfo(){
		$("#pbsFm").submit();
	}
</script>
</head>
<body>
<div id="Nav">
	<span>屏蔽室管理>>屏蔽室信息</span>
	<a class="btn-nav" href="javascript:history.go(-1)">返回</a>
</div>
<div style="padding: 10px">
	<div style="border:1px solid #999;width:100%;padding-top:20px;padding-bottom:50px;">
		<form id="pbsFm" action="<%=request.getContextPath()%>/pbsInfo_savePbsInfo.do" method="post" enctype="multipart/form-data">
			<table align="center" class="infoTab">
				<tr>
					<th colspan="4" align="center" style="font-size:18px;padding-bottom:20px;">屏蔽室信息</th>
				</tr>
				<tr>
					<td class="lable-td">屏蔽室名称：</td>
					<td class="input-td" colspan="3">
						<input id="pbsUnitId" name="pbsBaseInfo.pbsUnitId" value="<%= unitId%>" type="hidden"/>
						<input id="pbsName" name="pbsBaseInfo.pbsName" style="width:600px;"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >屏蔽室地址：</td>
					<td class="input-td" colspan="3">
						<input id="pbsAddress" name="pbsBaseInfo.pbsAddress" style="width:600px;"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >完成情况：</td>
					<td class="input-td" colspan="3">
						<textarea id="completionInfo" name="pbsBaseInfo.completionInfo"  ></textarea>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >维护情况：</td>
					<td class="input-td" colspan="3">
						<textarea id="maintenanceInfo" name="pbsBaseInfo.maintenanceInfo"></textarea>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >屏蔽室用途：</td>
					<td class="input-td" colspan="3">
						<textarea id="usage" name="pbsBaseInfo.usage" ></textarea>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >屏蔽室型号：</td>
					<td class="input-td">
						<input id="model" name="pbsBaseInfo.model" />
					</td>
					<td class="lable-td" >屏蔽室规格：</td>
					<td class="input-td">
						<input id="pbsSize" name="pbsBaseInfo.pbsSize" />
					</td>
				</tr>
				<tr>
					<td class="lable-td" >屏蔽室平面图：</td>
					<td class="input-td">
						<input id="pmPic" name="pmPic" type="file"/>
					</td>	
					<td class="lable-td" >通信线过壁方式：</td>
					<td class="input-td">
						<select id="telcomCableCrossWall" name="pbsBaseInfo.telcomCableCrossWall" style="width:200px;height:22px;">
							<option value="1">使用光纤</option>
							<option value="2">使用信号滤波器 </option>
							<option value="3">其它方式</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="lable-td">屏蔽室门数量：</td>
					<td class="input-td">
						<input id="doorNums" name="pbsBaseInfo.doorNums" />
					</td>
					<td class="lable-td" >屏蔽室门规格：</td>
					<td class="input-td">
						<input id="doorModel" name="pbsBaseInfo.doorModel" />
					</td>
				</tr>
				<tr>
					<td class="lable-td" >接地电阻：</td>
					<td class="input-td">
						<input id="groundResistance" name="pbsBaseInfo.groundResistance" />
					</td>
					<td class="lable-td" >绝缘电阻：</td>
					<td class="input-td">
						<input id="insulationResistance" name="pbsBaseInfo.insulationResistance" />
					</td>
				</tr>
			</table>
			<div align="center" style="padding-top:30px;">
				<input id="operate" name="operate" type="hidden" value="add"/>
				<input type="button" value="保 存 " onclick="savePbsInfo()" style="padding:10px;"/> 
			</div>
		</form>
	</div>
</div>
</body>
</html>