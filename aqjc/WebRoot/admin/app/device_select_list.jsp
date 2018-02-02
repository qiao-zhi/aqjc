<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>设备管理</title>
<jsp:include page="../common/include-common.jsp"></jsp:include>
<style type="text/css">
.w_title{
	width:398px;
}
</style>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/jscript/sys/app/device_list.js"></script>
<script>
	$(function(){
		$("#device_grid").flexigrid({
			url: '${pageContext.request.contextPath}/test_showTestDevice.do',
	        dataType: 'json',
	        display : 'true',
	        colModel : [
	          {display: '主键', name : 'deviceId', width : 70, sortable : true, align: 'center',hide: true},
	          {display: '序号', name : 'number', width : 20, sortable : true, align: 'center',hide: false},
	          {display: '设备名称', name : 'deviceName', width : 200, sortable : true, align: 'center'},
	          {display: '设备类别', name : 'deviceType', width : 100, sortable : true, align: 'center'},
	          {display: '设备类型', name : 'deviceClass', width : 150, sortable : true, align: 'center'},
	          {display: '设备标签', name : 'deviceLabel', width : 150, sortable : true, align: 'center'},
	          {display: '申请单位', name : 'unitName', width : 150, sortable : true, align: 'center'},
	          {display: '检测日期', name : 'testDate', width : 150, sortable : true, align: 'center'}
					],
			buttons : [
				{name : '导出',onpress : action},
				{separator: true},
				{name : '导入',onpress : action}
					],
			sortname: "name",   
			sortorder: "desc",   
			usepager: true,   
			checkbox : true,// 是否要多选框
			useRp: true,
			title: '设备信息列表',
			rp: 10,   
			width: 'auto',
			height:'auto',
			wjsearch:[{name:'deviceName',value: $('#serach_deviceName').attr('value')},{name:'deviceType',value: $('#serach_deviceType').attr('value')}]
		});
		
		function action(com, grid) {
			switch (com) {
				case '导出' :
					var url = $("#downExcel").attr('href');
					window.location.href = url;
					break;
				case '导入' :
					uploadExcel();
					break;
			}
		}
		
		loadUpdic();
	});
	function loadUpdic(){
		$.ajax({
			url : '${pageContext.request.contextPath}/finddic_getElementByUpId.do?id=002',
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				var data = eval(data);
				var rows = data.rows;
				var node = "";
				for(var i=0;i<rows.length;i++){
					node = node+"<option value='"+rows[i].dictionaryOptionId+"'>"+rows[i].dictionaryOptionName+"</option>";
				}
				$("#search_deviceClass").append(node);
			}
		});
	}
	
	function search(){
		var v_deviceType = $('#search_deviceType').attr('value');
		var v_unitName = $('#search_unitName').attr('value');
		var v_startDate = $('#search_startDate').attr('value');
		var v_endDate = $('#search_endDate').attr('value');
		var v_deviceClass = $("#search_deviceClass").attr('value');
		var  k = {wjsearch:[{name:'deviceType',value: $('#search_deviceType').attr('value')},
		                    {name:'unitName',value: $('#search_unitName').attr('value')},
		                    {name:'startDate',value:$('#search_startDate').attr('value')},
		                    {name:'endDate',value:$('#search_endDate').attr('value')},
		                    {name:'deviceClass',value:$('#search_deviceClass').attr('value')}
		                    ]};
		$('#device_grid').flexReload(k);
		var url = "${pageContext.request.contextPath}/excel.do?deviceType="+v_deviceType+"&deviceClass="+v_deviceClass+"&unitName="+v_unitName+"&startDate="+v_startDate+"&endDate="+v_endDate;
		$("#downExcel").attr('href',url);
	};
	function reset(){
		$("#search_deviceType").val("");
		$("#search_deviceClass").val("");
		$("#search_unitName").val("");
		$("#search_startDate").val("");
		$("#search_endDate").val("");
	}
	function uploadExcel(){
		$.dialog({
			content:$("#excelTab")[0],
			title:'上传设备信息文件',
			id:'idExcel',
			lock :true,
			background :'#245EDC',
			opacity:0.5
		});
		$("#excelFile").val("");
	}
	
	$(function(){
		$("#uploadExcel").click(function (){
			var file = $("#excelFile").val();
			if(file == "") {
				alert("添加文件");
				return;
			}
			var formDate = new FormData($('#uploadExcelForm')[0]);
			$.ajax({
				url : '${pageContext.request.contextPath}/readExcel.do',
				type : 'POST',
				dateType : 'json',
				data : formDate,
			    async: false,
			    contentType: false,
			    processData: false,
			    cache: false,
				success : function(data) {
					var data = eval(data);
					if(data.result == "success"){
						alert("数据更新成功");
					} else {
						alert("error");
					}
					$.dialog.get('idExcel').close();
					$('#device_grid').flexReload();
				},
				error : function (data){
					alert("导入错误");
				}
			});
		});
	});

</script>
</head>

<body>
	<div id="Nav">
		<span>设备管理>>设备管理</span>
	</div>
	<div id="searchDiv">
		<table id="serach-table">
			<tr>
				<td class="title_td">设备类别</td>
				<td>
					<select id="search_deviceType" name="deviceType">
					    <option value="">请选择</option>
						<option value="1">新购</option>
						<option value="2">维修后</option>
					</select>
				</td>
				<td class="title_td">设备类型</td>
				<td>
					<select id="search_deviceClass" name="deviceClass">
						<option value="">请选择</option>
					</select>
				</td>
				<td class="title_td">申请单位</td>
				<td>
					<input type="text" id="search_unitName" name="unitName"/>
				</td>
				<td class="title_td">检测时间</td>
				<td>
					<input id="search_startDate" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})">
					--
					<input id="search_endDate" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})">
				</td>
				<td class="btn-td"><input type="button" onclick="return search()" value="搜索" /></td>
				<td class="btn-td"><input type="button" onclick="reset()" value="重置" /></td>
			</tr>
		</table>
	</div>
	
	<table id="device_grid"></table>
	
	<div style="display:none">
		<a id="downExcel" href="${pageContext.request.contextPath}/excel.do">导出</a>
	</div>
	
	<div id="excelTab" style="display: none">
		<form id="uploadExcelForm" enctype="multipart/form-data">
			<table class="dataTab">
				<tr>
					<td class="title_td">文件</td>
					<td colspan="3"><input type="file" id="excelFile" name="excel" class="w_title"/></td>
				</tr>
				<tr>
					<td colspan="4" align="center" style="padding-top:20px;">
						<span id="uploadExcel" class="btn">上传</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>