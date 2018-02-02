<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
    String id = request.getParameter("id");
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
	$(function(){
		showBuilderIInfo();
	});
	function savePbsInfo(){
		$("#pbsFm").submit();
	}
	function showBuilderIInfo(){
		$.ajax({
			url : '${pageContext.request.contextPath}/pbsInfo_selBuilderUnit.do',
			data : {'id' : '<%= id%>'},
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
				$("#zzzsUrl").text("已上传："+info.zzzsUrl);
				$("#yyzzUrl").text("已上传："+info.yyzzUrl);
				$("#builderIntro").val(info.builderIntro);
				$("#researchAbility").val(info.researchAbility);
				$("#qualityManage").val(info.qualityManage);
				$("#afterService").val(info.afterService);
				$("#employeeManage").val(info.employeeManage);
			}
		});
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
		<form id="pbsFm" action="<%=request.getContextPath()%>/pbsInfo_saveBuilderUnit.do" method="post" enctype="multipart/form-data">
			<table align="center" class="infoTab">
				<tr>
					<th colspan="4" align="center" style="font-size:18px;padding-bottom:20px;">承建单位信息</th>
				</tr>
				<tr>
					<td class="lable-td">单位名称：</td>
					<td class="input-td" colspan="3">
						<input id="bId" name="pbsBuilder.id" value="<%= id%>" type="hidden"/>
						<input id="unitName" name="pbsBuilder.unitName" style="width:600px;"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >单位性质：</td>
					<td class="input-td" colspan="3">
						<input id="unitType" name="pbsBuilder.unitType" style="width:600px;"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >经营范围：</td>
					<td class="input-td" colspan="3">
						<input id="businessScope" name="pbsBuilder.businessScope"  style="width:600px;"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >单位地址：</td>
					<td class="input-td" colspan="3">
						<input id="unitAddress" name="pbsBuilder.unitAddress" style="width:600px;"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >邮政编码：</td>
					<td class="input-td">
						<input id="postCode" name="pbsBuilder.postCode" />
					</td>
					<td class="lable-td" >电子信箱：</td>
					<td class="input-td">
						<input id="unitEmail" name="pbsBuilder.unitEmail" />
					</td>
				</tr>
				<tr>
					<td class="lable-td">单位电话：</td>
					<td class="input-td">
						<input id="unitTel" name="pbsBuilder.unitTel" />
					</td>
					<td class="lable-td" >法人姓名：</td>
					<td class="input-td">
						<input id="legalPerson" name="pbsBuilder.legalPerson" />
					</td>
				</tr>
				<tr>
					<td class="lable-td" >法人职务：</td>
					<td class="input-td">
						<input id="lpPosition" name="pbsBuilder.lpPosition" />
					</td>
					<td class="lable-td" >法人电话：</td>
					<td class="input-td">
						<input id="lpTelphone" name="pbsBuilder.lpTelphone" />
					</td>
				</tr>
				<tr>
					<td class="lable-td" >法人传真：</td>
					<td class="input-td">
						<input id="lpTax" name="pbsBuilder.lpTax" />
					</td>
					<td class="lable-td" >法人Email：</td>
					<td class="input-td">
						<input id="lpEmail" name="pbsBuilder.lpEmail" />
					</td>
				</tr>
				<tr>
					<td class="lable-td" >资质证书：</td>
					<td class="input-td" colspan="3">
						<input id="zzzs" name="zzzsFile" type="file"/>
						<span id="zzzsUrl" style="padding-left:10px;"></span>
					</td>
				</tr>	
				<tr>	
					<td class="lable-td" >营业执照：</td>
					<td class="input-td" colspan="3">
						<input id="yyzz" name="yyzzFile" type="file"/>
						<span id="yyzzUrl" style="padding-left:10px;"></span>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >单位简介：</td>
					<td class="input-td" colspan="3">
						<textarea id="builderIntro" name="pbsBuilder.builderIntro" ></textarea>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >科研生产能力：</td>
					<td class="input-td" colspan="3">
						<textarea id="researchAbility" name="pbsBuilder.researchAbility" ></textarea>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >质量管理：</td>
					<td class="input-td" colspan="3">
						<textarea id="qualityManage" name="pbsBuilder.qualityManage" ></textarea>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >售后服务：</td>
					<td class="input-td" colspan="3">
						<textarea id="afterService" name="pbsBuilder.afterService" ></textarea>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >人员管理制度：</td>
					<td class="input-td" colspan="3">
						<textarea id="employeeManage" name="pbsBuilder.employeeManage" ></textarea>
					</td>
				</tr>
				
			</table>
			<div align="center" style="padding-top:30px;">
				<input id="operate" name="operate" type="hidden" value="upd"/>
				<input type="button" value="保 存 " onclick="savePbsInfo()" style="padding:10px;"/> 
			</div>
		</form>
	</div>
</div>
</body>
</html>