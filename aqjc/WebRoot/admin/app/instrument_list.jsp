<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>仪器管理</title>
<jsp:include page="../common/include-common.jsp"></jsp:include>
<style type="text/css">
.w_title{
	width:398px;
}
</style>
<script type="text/javascript" src="<%=request.getContextPath() %>/jscript/sys/app/ins_list.js"></script>
<script>
	$(function(){ 
		$("#device_grid").flexigrid({   
			url: '${pageContext.request.contextPath}/ins_showInstrumentList.do',
	        dataType: 'json',
	        display : 'true',   
	        colModel : [   
	          {display: '主键', name : 'InstrumentId', width : 70, sortable : true, align: 'center',hide: true},
	          {display: '序号', name : 'number', width : 20, sortable : true, align: 'center'},
	          {display: '仪器名称', name : 'Name', width : 200, sortable : true, align: 'center'},
	          {display: '仪器类型', name : 'Remark', width : 100, sortable : true, align: 'center'},
	          {display: '类型dic', name : 'UseType', width : 100, sortable : true, align: 'center',hide: true},
	          {display: '仪器型号', name : 'Model', width : 150, sortable : true, align: 'center'},
	          {display: '仪器序列号', name : 'Code', width : 150, sortable : true, align: 'center'},
	          {display: '设备厂商', name : 'Manufacturer', width : 200, sortable : true, align: 'center'}	          
					],
			buttons : [
						{name : '录入仪器信息',onpress : action},
						{separator: true},
						{name : '修改仪器信息',onpress : action},
						{separator: true},
						{name : '删除仪器信息',onpress : action}
						//{separator: true},
						//{name : '查看仪器信息',onpress : action}
					],
		            sortname: "UseType",
		            sortorder: "desc",   
		            usepager: true,   
		            checkbox : true,
		            useRp: true,
		            title: '仪器信息列表',
		            rp: 10,   
		            width: 'auto',
		            height:'auto',
		            wjsearch:[{name:'insName',value: $('#search_insName').attr('value')},{name:'insType',value: $('#search_insType').attr('value')}]
		});				            
		//var actions = "";
		function action(com, grid) {
			switch (com) {
				case '录入仪器信息' :
					$("#operateAdd").val("add");
					$.dialog({
						content:$("#addTab")[0],
						title:'录入设备信息',
						id:'idAdd',
						lock :true,
						background :'#245EDC',
						opacity:0.5
					});
					break;
				case '修改仪器信息' :
					selected_count = $('.trSelected', grid).length;
					if (selected_count == 0) {
						alert('请选择一条记录!');
						return;
					}
					if (selected_count > 1) {
						alert('抱歉只能同时修改一条记录!');
						return;
					}
					data = new Array();
					$('.trSelected td', grid).each(function(i) {
						data[i] = $(this).children('div').text();
					});
					$("#operateUpd").val("upd");
					$('#update_instrumentId').val($.trim(data[0]));
					$('#update_name').val($.trim(data[2]));
					$('#update_model').val($.trim(data[5]));
					$('#update_code').val($.trim(data[6]));
					$('#update_manufacturer').val($.trim(data[7]));
					$('#update_useType').val($.trim(data[4]));
					$.dialog({
						content:$("#updateTab")[0],
						title:'修改仪器信息',
						id:'idUpdate',
						lock :true,
						background :'#245EDC',
						opacity:0.5
					});
					break;
				case '删除仪器信息' :
					selected_count = $('.trSelected', grid).length;
					if (selected_count == 0) {
						alert('请选择一条记录!');
						return;
					}
					ids = '';
					$('.trSelected td:nth-child(2) div', grid).each(function(i) {
								if (i)
									ids += ',';
								ids += $(this).text();
					});
					if (confirm("确定删除?")) {
						delDeviceInfo(ids);
					}
					break;
				case '查看仪器信息' :
					selected_count = $('.trSelected', grid).length;
					if (selected_count == 0) {
						alert('请选择一条记录!');
						return;
					}
					if (selected_count > 1) {
						alert('抱歉只能同时修改一条记录!');
						return;
					}
					data = new Array();
					$('.trSelected td', grid).each(function(i) {
						data[i] = $(this).children('div').text();
					});
					$.dialog({
						content:$("#selectTab")[0],
						title:'设备详细信息',
						id:'idSelect',
						lock :true,
						background :'#245EDC',
						opacity:0.5
					});
					break;
			}
		}
	});
	function delDeviceInfo(ids) {
		$.ajax({
			url : '${pageContext.request.contextPath}/ins_delInstrument.do',
			data : {'idsStr' : ids},
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				if(data.success){
					alert(data.message);
					$('#device_grid').reload();					
				}else{
					alert(data.message);
				}
			}
		});
	};
	function search(){
		var  k = {wjsearch:[{name:'insName',value: $('#search_insName').attr('value')},{name:'insType',value: $('#search_insType').attr('value')}]};
		$('#device_grid').flexReload(k);  
	};
</script>
</head>

<body>
	<div id="Nav">
		<span>设备管理>>检测仪器</span>
	</div>
	<div id="searchDiv">
		<table id="serach-table">
			<tr>
				<td class="title_td">仪器名称</td>
				<td><input id="search_insName" name="insName" /></td>
				<td class="title_td">设备类型</td>
				<td>
				<select id="search_insType" name="insType">
					    <option value="">请选择</option>
						<option value="1">设备检测仪器</option>
						<option value="2">屏蔽室检测仪器</option>
						<option value="3">环境检测仪器</option>
					</select>
				</td>
				<td class="btn-td"><input type="button" onclick="return search()" value="搜索" /></td>
			</tr>
		</table>
	</div>
	
	<table id="device_grid"></table>
	
	<div id="addTab" style="display: none">
		<form id="addDeviceInfoForm">
			<table class="dataTab">
				<tr>
					<td class="title_td">仪器名称</td>
					<td colspan="3"><input id="add_name" name="instrumentInfo.name" class="w_title" isempty="no" tip="名称不能为空"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td class="title_td">仪器型号</td>
					<td colspan="3"><input id="add_model" name="instrumentInfo.model" class="w_title" isempty="no" tip="型号不能为空"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td class="title_td">仪器序列号</td>
					<td colspan="3"><input id="add_code" name="instrumentInfo.code" isempty="no" tip="序列号不能为空"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td class="title_td">仪器厂商</td>
					<td colspan="3"><input id="add_manufacturer" name="instrumentInfo.manufacturer" />
				</tr>
				<tr>
					<td class="title_td">仪器类型</td>
					<td colspan="3">
					<select id="add_useType" name="instrumentInfo.useType" isempty="no" tip="设备类型不能为空">
					    <option value="1">设备检测仪器</option>
						<option value="2">屏蔽室检测仪器</option>
						<option value="3">环境检测仪器</option>
					</select>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center" style="padding-top:20px;">
						<input id="operateAdd" name="operate" type="hidden">
						<span id="btn_add" class="btn">保存</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="updateTab" style="display: none">
		<form id="updateDeviceInfoForm">
			<table class="dataTab">
				<tr>
					<td class="title_td">仪器名称</td>
					<td colspan="3">
					<input type="hidden" id="update_instrumentId" name="instrumentInfo.instrumentId">
					<input id="update_name" name="instrumentInfo.name" class="w_title" isempty="no" tip="名称不能为空"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td class="title_td">仪器型号</td>
					<td colspan="3"><input id="update_model" name="instrumentInfo.model" class="w_title" isempty="no" tip="型号不能为空"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td class="title_td">仪器序列号</td>
					<td colspan="3"><input id="update_code" name="instrumentInfo.code" isempty="no" tip="序列号不能为空"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td class="title_td">仪器厂商</td>
					<td colspan="3"><input id="update_manufacturer" name="instrumentInfo.manufacturer" /></td>
				</tr>
				<tr>
					<td class="title_td">仪器类型</td>
					<td colspan="3">
					<select id="update_useType" name="instrumentInfo.useType" isempty="no" tip="设备类型不能为空">
					    <option value="1">设备检测仪器</option>
						<option value="2">屏蔽室检测仪器</option>
						<option value="3">环境检测仪器</option>
					</select>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center" style="padding-top:20px;">
						<input id="operateUpd" name="operate" type="hidden">
						<span id="btn_update" class="btn">保存</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="selectTab" style="display: none">
		<form id="selectDeviceInfoForm">
			<table class="dataTab">
				<tr>
					<td class="title_td">设备名称</td>
					<td colspan="3"><input id="select_deviceName" name="deviceBaseInfo.deviceName" class="w_title" readonly="readonly"/></td>
				</tr>
				<tr>
					<td class="title_td">设备型号</td>
					<td colspan="3"><input id="select_deviceModel" name="deviceBaseInfo.deviceModel" class="w_title" readonly="readonly"/></td>
				</tr>
				<tr>
					<td class="title_td">设备序列号</td>
					<td colspan="3"><input id="select_deviceNum" name="deviceBaseInfo.deviceNum" readonly="readonly"/></td>
				</tr>
				<tr>
					<td class="title_td">设备类型</td>
					<td colspan="3">
					<select id="select_deviceType" name="deviceBaseInfo.deviceType" disabled="disabled">
					    <option value="009001">类型一</option>
						<option value="009002">类型二</option>
						<option value="009003">类型三</option>
					</select>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>