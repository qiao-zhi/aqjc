<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.tyust.bean.user.TBaseUserInfo" %>
<%@ page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.tyust.dao.unit.IunitDao,com.tyust.bean.unit.TBaseUnitInfo"%>

<%
    //String unitId = request.getParameter("unitId");
	String pbsId = request.getParameter("pbsId");
	String pbsBuilderId = request.getParameter("pbsBuilderId");
	String applyId = request.getParameter("applyId");
	
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
	.devTab {width:720px;}
	.devTab tr td {text-align:center;padding-top:5px;padding-bottom:5px;font-size:13px;}
	.col-head {font-weight:bold;font-size:13px;}
	.dveTypeNm{text-align:center;font-size:12px;padding-top:10px;}
</style>

<script>
	$(function(){
		showBuilderInfo();
		showPbsInfo();
		showPbsDve();
		showAppInfo();
	});
	function showPbsInfo(){
		$.ajax({
			url : '${pageContext.request.contextPath}/pbsInfo_selPbsInfo.do',
			data : {'pbsId' : '<%= pbsId%>'},
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var info = eval(response);
				$("#pbsName").val(info.pbsName);
				$("#pbsAddress").val(info.pbsAddress);
				$("#model").val(info.model);
				$("#usage").val(info.usage);
				$("#completionInfo").val(info.completionInfo);
				$("#maintenanceInfo").val(info.maintenanceInfo);
				$("#doorNums").val(info.doorNums);
				$("#doorModel").val(info.doorModel);
				$("#groundResistance").val(info.groundResistance);
				$("#insulationResistance").val(info.insulationResistance);
				$("#telcomCableCrossWall").val(info.telcomCableCrossWall);
				$("#pbsSize").val(info.pbsSize);
				if(info.pmPic!="0"){
					$("#pmPic").html("<img src='../../uploads/pbsPic/"+info.pmPic+"' style='width:45px;height:30px;'/>");
				}else{
					$("#pmPic").text("无");
				}
			}
		});
	}
	function showBuilderInfo(){
		$.ajax({
			url : '${pageContext.request.contextPath}/pbsInfo_selBuilderUnit.do',
			data : {'id' : '<%= pbsBuilderId%>'},
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var info = eval(response);
				$("#unitName").val(info.unitName);
				$("#unitAddress").val(info.unitAddress);
				$("#unitTel").val(info.unitTel);
				$("#businessScope").val(info.businessScope);
				$("#postCode").val(info.postCode);
				$("#unitType").val(info.unitType);
				$("#unitEmail").val(info.unitEmail);
				$("#legalPerson").val(info.legalPerson);
				$("#lpPosition").val(info.lpPosition);
				$("#lpTelphone").val(info.lpTelphone);
				$("#lpTax").val(info.lpTax);
				$("#lpEmail").val(info.lpEmail);
				$("#zzzsUrl").text(info.zzzsUrl);
				$("#yyzzUrl").text(info.yyzzUrl);
				$("#builderIntro").val(info.builderIntro);
				$("#researchAbility").val(info.researchAbility);
				$("#qualityManage").val(info.qualityManage);
				$("#afterService").val(info.afterService);
				$("#employeeManage").val(info.employeeManage);
			}
		});
	}
	function showPbsDve(){
		$.ajax({
			url : '${pageContext.request.contextPath}/pbsInfo_showPbsDve.do',
			data : {'pbsId' : '<%= pbsId%>'},
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var info = eval(response.data);
				if(info.length>0){
					for(var v=0;v<info.length;v++){
						if(info[v].DevType=="1"){
							$("#dclbq").append("<tr><td>"+info[v].DveName+"</td>"+
											"<td>"+info[v].DevModel+"</td>"+
											"<td>"+info[v].DevFactory+"</td>"+
											"<td>"+info[v].Band+"</td>"+
											"<td>"+info[v].InsertionLoss+"</td></tr>");
						}
						if(info[v].DevType=="2"){
							$("#dhlbq").append("<tr><td>"+info[v].DveName+"</td>"+
									"<td>"+info[v].DevModel+"</td>"+
									"<td>"+info[v].DevFactory+"</td>"+
									"<td>"+info[v].Band+"</td>"+
									"<td>"+info[v].InsertionLoss+"</td></tr>");				
						}
						if(info[v].DevType=="3"){
							$("#xhlbq").append("<tr><td>"+info[v].DveName+"</td>"+
									"<td>"+info[v].DevModel+"</td>"+
									"<td>"+info[v].DevFactory+"</td>"+
									"<td>"+info[v].Band+"</td>"+
									"<td>"+info[v].InsertionLoss+"</td></tr>");
						}
						if(info[v].DevType=="4"){
							$("#tfbdc").append("<tr><td>"+info[v].DveName+"</td>"+
									"<td>"+info[v].DevModel+"</td>"+
									"<td>"+info[v].DevFactory+"</td>"+
									"<td>"+info[v].Band+"</td>"+
									"<td>"+info[v].PbEfficiency+"</td></tr>");
						}
						if(info[v].DevType=="5"){
							$("#kt").append("<tr><td>"+info[v].DveName+"</td>"+
									"<td>"+info[v].DevModel+"</td>"+
									"<td>"+info[v].DevFactory+"</td>"+
									"<td>"+info[v].Band+"</td>"+
									"<td>"+info[v].KtbdgNum+"</td></tr>");
						}
						if(info[v].DevType=="6"){
							$("#xf").append("<tr><td>"+info[v].DveName+"</td>"+
									"<td>"+info[v].DevModel+"</td>"+
									"<td>"+info[v].DevFactory+"</td></tr>");
						}
						if(info[v].DevType=="7"){
							$("#gq").append("<tr><td>"+info[v].DveName+"</td>"+
									"<td>"+info[v].DevModel+"</td>"+
									"<td>"+info[v].DevFactory+"</td>"+
									"<td>"+info[v].HasMetalFirmware+"</td></tr>");
						}
					}	
				}	
			}
		});
	}
	function showAppInfo(){
		$.ajax({
			url : '${pageContext.request.contextPath}/pbsApply_selAppInfo.do',
			data : {'appId' : '<%= applyId%>'},
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var info = eval(response);
				$("#applyTestType").val(info.ApplyTestTypeNm);
				$("#applyTestGrade").val(info.ApplyTestGradeNm);
			}
		});
	}
	function showInfo(flag){
		$("#showInfoDiv").children("div").each(function(index,item){
			$(this).hide();
		});
		$("#infoDiv"+flag+"").show();
	}
	function savePbsApply(ope){
		$("#operate").val(ope);
		$("#appInfoFm").submit();
	}
</script>
</head>
<body>
<div id="Nav">
	<span>屏蔽室管理>>屏蔽室信息</span>
	<a class="btn-nav" href="javascript:history.go(-1)">返回</a>
</div>
<div style="padding: 10px">
	<div id="showInfoDiv" style="border:1px solid #999;width:100%;padding-top:20px;padding-bottom:50px;">
		<table align="center" class="infoTab" style="padding-bottom:50px;">
			<tr>
				<th colspan="4" align="center" style="font-size:18px;padding-bottom:20px;">屏蔽室检测申请</th>
			</tr>
			<tr>
				<td colspan="2" style="text-align:left;font-size:12px;padding-top:10px;">
					<a href="javascript:void(0)" onclick="showInfo(1)">申请单位信息</a> |
					<a href="javascript:void(0)" onclick="showInfo(2)">屏蔽室信息</a> |
					<a href="javascript:void(0)" onclick="showInfo(3)">屏蔽室设备</a> |
					<a href="javascript:void(0)" onclick="showInfo(4)">屏蔽室承建单位</a> |
					<a href="javascript:void(0)" onclick="showInfo(5)">检测类型</a> 
				</td>
			</tr>
		</table>
		<div id="infoDiv1" >
			<table align="center" class="infoTab">
				<tr>
					<th colspan="4" align="center" style="font-size:13px;padding-bottom:20px;">申请单位信息</th>
				</tr>
				<tr>
					<td class="lable-td">单位名称：</td>
					<td class="input-td" colspan="3">
						<input id="unit" value="<%= unit.getUnitName() %>" style="width:600px;" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >单位地址：</td>
					<td class="input-td" colspan="3">
						<input id="unitAdd" value="<%= unit.getAddress()==null?"":unit.getAddress() %>" style="width:600px;" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >联系人：</td>
					<td class="input-td" colspan="3">
						<input id="unitPerson"  value="<%= unit.getContactPerson()==null?"":unit.getContactPerson() %>" style="width:600px;" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >联系电话：</td>
					<td class="input-td" colspan="3">
						<input id="unitPhone" value="<%= unit.getTelephone()==null?"":unit.getTelephone() %>"  style="width:600px;" readonly="readonly"/>
					</td>
				</tr>
			</table>	
		</div>
		<div id="infoDiv2" style="display: none">
			<table align="center" class="infoTab">
				<tr>
					<th colspan="4" align="center" style="font-size:13px;padding-bottom:20px;">屏蔽室信息</th>
				</tr>
				<tr>
					<td class="lable-td">屏蔽室名称：</td>
					<td class="input-td" colspan="3">
						<input id="pbsName" readonly="readonly" style="width:600px;"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >屏蔽室地址：</td>
					<td class="input-td" colspan="3">
						<input id="pbsAddress" readonly="readonly" style="width:600px;"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >完成情况：</td>
					<td class="input-td" colspan="3">
						<textarea id="completionInfo" readonly="readonly"  ></textarea>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >维护情况：</td>
					<td class="input-td" colspan="3">
						<textarea id="maintenanceInfo" readonly="readonly"></textarea>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >屏蔽室用途：</td>
					<td class="input-td" colspan="3">
						<textarea id="usage" readonly="readonly" ></textarea>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >屏蔽室型号：</td>
					<td class="input-td">
						<input id="model" readonly="readonly" />
					</td>
					<td class="lable-td" >屏蔽室规格：</td>
					<td class="input-td">
						<input id="pbsSize" readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td class="lable-td" >屏蔽室平面图：</td>
					<td class="input-td" id="pmPic">
					</td>
					<td class="lable-td" >通信线过壁方式：</td>
					<td class="input-td">
						<select id="telcomCableCrossWall" style="width:200px;height:22px;">
							<option value="1">使用光纤</option>
							<option value="2">使用信号滤波器 </option>
							<option value="3">其它方式</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="lable-td">屏蔽室门数量：</td>
					<td class="input-td">
						<input id="doorNums" readonly="readonly"/>
					</td>
					<td class="lable-td" >屏蔽室门规格：</td>
					<td class="input-td">
						<input id="doorModel" readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td class="lable-td" >接地电阻：</td>
					<td class="input-td">
						<input id="groundResistance" readonly="readonly" />
					</td>
					<td class="lable-td" >绝缘电阻：</td>
					<td class="input-td">
						<input id="insulationResistance" readonly="readonly" />
					</td>
				</tr>
			</table>
		</div>
		<div id="infoDiv3" style="display: none">
			<div style="font-size:13px;font-weight:bold;text-align:center;padding-bottom:15px;">屏蔽室设备</div>
			<div class="dveTypeNm">电磁滤波器</div>
			<table id="dclbq" class="devTab" align="center" border="1" cellspacing="0" cellpadding="0">
				<tr>
					<td class="col-head">设备名称</td>
					<td class="col-head">设备型号</td>
					<td class="col-head">设备厂商</td>
					<td class="col-head">工作频段</td>
					<td class="col-head">插入损耗</td>
				</tr>
			</table>
			<div class="dveTypeNm">电话滤波器</div>
			<table id="dhlbq" class="devTab" align="center" border="1" cellspacing="0" cellpadding="0">
				<tr>
					<td class="col-head">设备名称</td>
					<td class="col-head">设备型号</td>
					<td class="col-head">设备厂商</td>
					<td class="col-head">工作频段</td>
					<td class="col-head">插入损耗</td>
				</tr>
			</table>
			<div class="dveTypeNm">信号滤波器</div>
			<table id="xhlbq" class="devTab" align="center" border="1" cellspacing="0" cellpadding="0">
				<tr>
					<td class="col-head">设备名称</td>
					<td class="col-head">设备型号</td>
					<td class="col-head">设备厂商</td>
					<td class="col-head">工作频段</td>
					<td class="col-head">插入损耗</td>
				</tr>
			</table>
			<div class="dveTypeNm">通风波导窗</div>
			<table id="tfbdc" class="devTab" align="center" border="1" cellspacing="0" cellpadding="0">
				<tr>
					<td class="col-head">设备名称</td>
					<td class="col-head">设备型号</td>
					<td class="col-head">设备厂商</td>
					<td class="col-head">工作频段</td>
					<td class="col-head">屏蔽效能</td>
				</tr>
			</table>
			<div class="dveTypeNm">空调设备</div>
			<table id="kt" class="devTab" align="center" border="1" cellspacing="0" cellpadding="0">
				<tr>
					<td class="col-head">设备名称</td>
					<td class="col-head">设备型号</td>
					<td class="col-head">设备厂商</td>
					<td class="col-head">工作频段</td>
					<td class="col-head">空调波导管数量</td>
				</tr>
			</table>
			<div class="dveTypeNm">消防设备</div>
			<table id="xf" class="devTab" align="center" border="1" cellspacing="0" cellpadding="0">
				<tr>
					<td class="col-head">设备名称</td>
					<td class="col-head">设备型号</td>
					<td class="col-head">设备厂商</td>
				</tr>
			</table>
			<div class="dveTypeNm">光纤</div>
			<table id="gq" class="devTab" align="center" border="1" cellspacing="0" cellpadding="0">
				<tr>
					<td class="col-head">设备名称</td>
					<td class="col-head">设备型号</td>
					<td class="col-head">设备厂商</td>
					<td class="col-head">是否带有金属固件</td>
				</tr>
			</table>
		</div>
		<div id="infoDiv4" style="display: none">
			<table align="center" class="infoTab">
				<tr>
					<th colspan="4" align="center" style="font-size:13px;padding-bottom:20px;">承建单位信息</th>
				</tr>
				<tr>
					<td class="lable-td">单位名称：</td>
					<td class="input-td" colspan="3">
						<input id="unitName" readonly="readonly" style="width:600px;"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >单位性质：</td>
					<td class="input-td" colspan="3">
						<input id="unitType" readonly="readonly" style="width:600px;"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >经营范围：</td>
					<td class="input-td" colspan="3">
						<input id="businessScope" readonly="readonly"  style="width:600px;"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >单位地址：</td>
					<td class="input-td" colspan="3">
						<input id="unitAddress" readonly="readonly" style="width:600px;"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >邮政编码：</td>
					<td class="input-td">
						<input id="postCode" readonly="readonly"/>
					</td>
					<td class="lable-td" >电子信箱：</td>
					<td class="input-td">
						<input id="unitEmail" readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td class="lable-td">单位电话：</td>
					<td class="input-td">
						<input id="unitTel" readonly="readonly" />
					</td>
					<td class="lable-td" >法人姓名：</td>
					<td class="input-td">
						<input id="legalPerson" readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td class="lable-td" >法人职务：</td>
					<td class="input-td">
						<input id="lpPosition" readonly="readonly" />
					</td>
					<td class="lable-td" >法人电话：</td>
					<td class="input-td">
						<input id="lpTelphone" readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td class="lable-td" >法人传真：</td>
					<td class="input-td">
						<input id="lpTax" readonly="readonly" />
					</td>
					<td class="lable-td" >法人Email：</td>
					<td class="input-td">
						<input id="lpEmail" readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td class="lable-td" >资质证书：</td>
					<td class="input-td">
						<span id="zzzsUrl" style="padding-left:10px;"></span>
					</td>	
					<td class="lable-td" >营业执照：</td>
					<td class="input-td" >
						<span id="yyzzUrl" style="padding-left:10px;"></span>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >单位简介：</td>
					<td class="input-td" colspan="3">
						<textarea id="builderIntro" readonly="readonly" ></textarea>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >科研生产能力：</td>
					<td class="input-td" colspan="3">
						<textarea id="researchAbility" readonly="readonly" ></textarea>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >质量管理：</td>
					<td class="input-td" colspan="3">
						<textarea id="qualityManage" readonly="readonly" ></textarea>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >售后服务：</td>
					<td class="input-td" colspan="3">
						<textarea id="afterService" readonly="readonly" ></textarea>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >人员管理制度：</td>
					<td class="input-td" colspan="3">
						<textarea id="employeeManage" readonly="readonly" ></textarea>
					</td>
				</tr>
				
			</table>
		</div>
		<div id="infoDiv5" style="display: none">
			<table align="center" class="infoTab">
				<tr>
					<th colspan="4" align="center" style="font-size:13px;padding-bottom:20px;">检测类别</th>
				</tr>
				<tr>
					<td class="lable-td">本次检测类型：</td>
					<td class="input-td" >
						<input id="applyTestType" readonly="readonly"/>
					</td>
					<td class="lable-td" >检测级别：</td>
					<td class="input-td" >
						<input id="applyTestGrade" readonly="readonly"/>
					</td>
				</tr>
			</table>
		</div>
		<div id="infoDiv6">
		</div>
	</div>
</div>
</body>
</html>