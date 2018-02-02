<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.tyust.common.DateHandler" %>

<%
    String applyId = request.getParameter("applyId");
	String pbsId = request.getParameter("pbsId");
	String pbsBuilderId = request.getParameter("pbsBuilderId");
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
	.addBtnDiv{margin:0 auto;width:720px;;text-align:right;font-size:12px;padding-top:10px;}
</style>
<script type="text/javascript" src="yulan.js"></script>
<script>
	$(function(){
		showBuilderInfo();
		showPbsInfo();
		showInsTab();
		$("#choose_ins_grid").flexigrid({   
			url: '${pageContext.request.contextPath}/ins_chooseInsList.do',
		    dataType: 'json',
		    display : 'true',   
		    colModel : [   
		      {display: '主键', name : 'InstrumentId', width : 70, sortable : true, align: 'center',hide: true},
		      {display: '序号', name : 'number', width : 20, sortable : true, align: 'center',hide: false},
		      {display: '仪器名称', name : 'Name', width : 150, sortable : true, align: 'center'},
		      {display: '仪器型号', name : 'Model', width : 150, sortable : true, align: 'center'},
		      {display: '仪器序列号', name : 'Code', width : 150, sortable : true, align: 'center'},
		      {display: '仪器厂商', name : 'Manufacturer', width : 150, sortable : true, align: 'center'}
					],
			buttons : [
					{name : '确定',onpress : action},
					{separator: true}
				],
		        sortname: "name",   
		        sortorder: "desc",   
		        usepager: false,
		        checkbox : true,
		        title: '请勾选要添加的仪器',	
		        width: 'auto',
		        height:'auto',
		        wjsearch:[{name:'existInsIds',value: '0'},{name:'useType',value:'1'}]
			});
		function action(com, grid) {
			switch (com) {
				case '确定' :
					selected_count = $('.trSelected', grid).length;
					if (selected_count == 0) {
						alert('请选择至少一个仪器!');
						return;
					}
					//var selectedData = [];
					$('.trSelected', grid).each(function(i) {
					  	$("#selectedInsTab").append("<tr><td><input name='insId' type='hidden' value='"+$(this).children('td').eq(0).children('div').text()+
					  					"'/>"+$(this).children('td').eq(2).children('div').text()+"</td>"+
										"<td>"+$(this).children('td').eq(3).children('div').text()+"</td>"+
										"<td>"+$(this).children('td').eq(4).children('div').text()+"</td>"+
										"<td>"+$(this).children('td').eq(5).children('div').text()+"</td>"+
										"<td><a href='javascript:void(0)' onclick='delSeletedIns(this)'>删除</td></tr>");
					});
					$.dialog.get('idAdd').close();
					//$('#flex1').reload();
					break;
			}
		};
	});	
	
	function chooseInsDialog(){
		var v = $("#selectedInsTab tr").length;
		var insIdStr = "";
		if(v>1){
			$("input[name='insId']").each(function(index,item){
				insIdStr=insIdStr+$(this).val()+",";
			});
		}
		var k = {wjsearch:[{name:'existInsIds',value: insIdStr},{name:'useType',value:'1'}]};
		$('#choose_ins_grid').flexReload(k);
		$.dialog({
			content:$("#chooseInsTab")[0],
			title:'添加仪器',
			id:'idAdd',
			lock :true,
			background :'#245EDC',
			opacity:0.5
		});
	};
	
	function showInsTab(){
		$.ajax({
			url : '${pageContext.request.contextPath}/ins_showInsTab.do',
			data : {'useType':'1'},
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var json = eval(response.data);
				if(json.length>0){
					for(var v=0;v<json.length;v++){
						$("#selectedInsTab").append("<tr><td><input type='hidden' name='insId' value='"+json[v].InstrumentId+"'/>"+json[v].Name+"</td>"+
								"<td>"+json[v].Model+"</td>"+
								"<td>"+json[v].Code+"</td>"+
								"<td>"+json[v].Manufacturer+"</td>"+
								"<td><a href='javascript:void(0)' onclick='delSeletedIns(this)'>删除</td></tr>");
					}
				}
			}
		});
	};
	function delSeletedIns(obj){
		$(obj).parent().parent().remove();
	};
	function showPbsInfo(){
		$.ajax({
			url : '${pageContext.request.contextPath}/pbsInfo_selPbsInfo.do',
			data : {'pbsId' : '<%= pbsId%>'},
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var info = eval(response);
				$("#model").val(info.model);
				$("#pbsSize").val(info.pbsSize);
				$("#pbsCc").val(info.pbsSize);
				if(info.pmPic!="0"){
					$("#pmPic").html("<img src='../../uploads/pbsPic/"+info.pmPic+"' style='width:250px;height:250px;'/>");
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
				$("#builderUnit").val(info.unitName);
			}
		});
	}
	
	function showInfo(flag){
		$("#testReportFm").children("div").each(function(index,item){
			$(this).hide();
		});
		$("#infoDiv"+flag+"").show();
	}
	
	function savePbsRpt(flag){
		$("#operate").val(flag);
		var v = $("#selectedInsTab tr").length;
		if(v>1){
			var insIdStr = "";
			$("input[name='insId']").each(function(index,item){
				insIdStr=insIdStr+$(this).val()+",";
			});
			$("#selectedInsId").val(insIdStr);
			$("#testReportFm").submit();
		}else{
			alert("请选择检测仪器");
			return;
		}
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
				<th colspan="4" align="center" style="font-size:18px;padding-bottom:20px;">屏蔽室检测报告</th>
			</tr>
			<tr>
				<td colspan="2" style="text-align:left;font-size:12px;padding-top:10px;">
					<a href="javascript:void(0)" onclick="showInfo(1)">基本信息</a> |
					<a href="javascript:void(0)" onclick="showInfo(2)">检测内容及结论</a> |
					<a href="javascript:void(0)" onclick="showInfo(3)">检测仪器</a> |
					<a href="javascript:void(0)" onclick="showInfo(4)">屏蔽室描述</a> |
					<a href="javascript:void(0)" onclick="showInfo(5)">检测照片</a> 
				</td>	
				<td colspan="2" style="text-align:right;padding-right:50px;">
					<input type="button" value="保存" onclick="savePbsRpt('save')" style="width:50px;"/> 
					<input type="button" value="提交" onclick="savePbsRpt('sub')" style="width:50px;"/> 
				</td>
			</tr>
		</table>
		<form id="testReportFm" action="<%=request.getContextPath()%>/pbsRpt_addRpt.do" method="post" enctype="multipart/form-data">
		<div id="infoDiv1" >
			<table align="center" class="infoTab">
				<tr>
					<th colspan="4" align="center" style="font-size:18px;padding-bottom:20px;">基本信息</th>
				</tr>
				<tr>
					<td class="lable-td">检测报告编号：</td>
					<td class="input-td">
						<input id="testCode" name="pbsTestRpt.rptCode" />
						<input type="hidden" name="pbsTestRpt.applyId" value="<%=applyId %>">
						<input type="hidden" id="selectedInsId" name="selectedInsId" />
						<input type="hidden" id="operate" name="operate" />
					</td>
					<td class="lable-td" style="width:200px;">样品名称：</td>
					<td class="input-td">
						<input id="sampleName" name="pbsTestRpt.sampleName"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td">型号：</td>
					<td class="input-td">
						<input id="model"  readonly="readonly"/>
					</td>
					<td class="lable-td" style="width:200px;">规格：</td>
					<td class="input-td">
						<input id="pbsSize"  readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" style="width:200px;">生产单位：</td>
					<td class="input-td">
						<input id="builderUnit" readonly="readonly"/>
					</td>
					<td class="lable-td" style="width:200px;">委托单位：</td>
					<td class="input-td">
						<input id="delegateUnit" name="pbsTestRpt.delegateUnit"/>
					</td>
				</tr>
			</table>
		</div>
		<div id="infoDiv2" style="display: none">
			<table align="center" class="infoTab">
				<tr>
					<th colspan="4" align="center" style="font-size:13px;padding-bottom:20px;">检测内容及结论</th>
				</tr>
				<tr>
					<td class="lable-td">检测项目：</td>
					<td class="input-td" colspan="3">
						<input id="testItem" name="pbsTestRpt.testItem" style="width:600px;"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >依据标准：</td>
					<td class="input-td" colspan="3">
						<input id="testStandards" name="pbsTestRpt.testStandards"  style="width:600px;"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >检测位置：</td>
					<td class="input-td" colspan="3">
						<input id="testPos"  name="pbsTestRpt.testPos" style="width:600px;"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >性能判断：</td>
					<td class="input-td" colspan="3">
						<input id="xnpj" name="pbsTestRpt.xnpj" style="width:600px;"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >检测结论：</td>
					<td class="input-td" colspan="3">
						<textarea id="testResult" name="pbsTestRpt.testResult"></textarea>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >检测人：</td>
					<td class="input-td">
						<input id="testPerson" name="pbsTestRpt.testPerson"/>
					</td>
					<td class="lable-td" >检测日期：</td>
					<td class="input-td">
						<input id="testDate" name="pbsTestRpt.testDate" value="<%= DateHandler.dateToString(new Date()) %>" name="testDate" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" />
					</td>
				</tr>
				<tr>
					<td class="lable-td">审核人：</td>
					<td class="input-td">
						<input id="shPerson" name="pbsTestRpt.shPerson"/>
					</td>
					<td class="lable-td" >审核日期：</td>
					<td class="input-td">
						<input id="shDate" name="pbsTestRpt.shDate" value="<%= DateHandler.dateToString(new Date()) %>" name="testDate" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" />
					</td>
				</tr>
				<tr>
					<td class="lable-td" >批准人：</td>
					<td class="input-td">
						<input id="pzPerson" name="pbsTestRpt.pzPerson" />
					</td>
					<td class="lable-td" >批准日期：</td>
					<td class="input-td">
						<input id="pzDate" name="pbsTestRpt.pzDate" value="<%= DateHandler.dateToString(new Date()) %>" name="testDate" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" />
					</td>
				</tr>
			</table>
		</div>
		<div id="infoDiv3" style="display: none">
			<div style="font-size:13px;font-weight:bold;text-align:center;padding-bottom:15px;">检测仪器</div>
			<div class="addBtnDiv">
				<input type="button" value="添加仪器" onclick="chooseInsDialog()" style="width:100px;"/>
			</div>
			<table id="selectedInsTab" class="devTab" align="center" border="1" cellspacing="0" cellpadding="0">
				<tr>
					<td class="col-head">仪器名称</td>
					<td class="col-head">仪器型号</td>
					<td class="col-head">仪器序列号</td>
					<td class="col-head">仪器厂商</td>
					<td class="col-head" style="width:50px;">-</td>
				</tr>
			</table>		
		</div>
		<div id="infoDiv4" style="display: none">
			<table align="center" class="infoTab">
				<tr>
					<th colspan="4" align="center" style="font-size:13px;padding-bottom:20px;">屏蔽室描述</th>
				</tr>
				<tr>
					<td class="lable-td">被测屏蔽室状态：</td>
					<td class="input-td" colspan="3">
						<input id="pbsState" name="pbsTestRpt.pbsState" style="width:600px;"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >屏蔽室尺寸：</td>
					<td class="input-td" colspan="3">
						<input id="pbsCc" readonly="readonly" style="width:600px;"/>
					</td>
				</tr>
				<tr>
					<td class="lable-td" >屏蔽室平面图：</td>
					<td class="input-td" colspan="3" id="pmPic" style="text-align:center;">
					</td>
				</tr>				
			</table>
		</div>
		<div id="infoDiv5" style="display: none">
			<table align="center" class="infoTab" id="picTab" style="border:1px solid #ddd;">
				<tr>
					<th colspan="4" align="center" style="font-size:13px;padding-bottom:20px;">检测照片</th>
				</tr>
				<tr>	
					<td class="input-td">
						<input type="file" id="1" name="testPic" onchange="addFile(this)" />
					</td>
					<td>
						<div id="localImag1" align="center">
							<img id="preview1" src="" style="display: block; width: 320px; height: 230px;">
						</div>
					</td>
					<td> </td>
				</tr>
			</table>
		</div>
		</form>
		<div id="infoDiv6">
		</div>
	</div>
</div>
<div id="chooseInsTab" style="width:750px;display: none">
		<table id="choose_ins_grid"></table>
</div>
</body>
</html>