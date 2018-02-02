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
			url: '${pageContext.request.contextPath}/test_showDeviceInfoList.do',
	        dataType: 'json',
	        display : 'true',   
	        colModel : [   
	          {display: '主键', name : 'deviceId', width : 70, sortable : true, align: 'center',hide: true},
	          {display: '序号', name : 'number', width : 20, sortable : true, align: 'center',hide: false},
	          {display: '设备名称', name : 'deviceName', width : 200, sortable : true, align: 'center'},
	          {display: '设备型号', name : 'deviceModel', width : 250, sortable : true, align: 'center'},
	          {display: '设备序列号', name : 'deviceNum', width : 150, sortable : true, align: 'center'},
	          {display: '设备类型', name : 'deviceTypeName', width : 150, sortable : true, align: 'center'}
					],
					buttons : [
								{name : '录入设备信息',onpress : action},
								{separator: true},
								{name : '修改设备信息',onpress : action},
								{separator: true},
								{name : '删除设备信息',onpress : action},
								{separator: true},
								{name : '查看设备信息',onpress : action}
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
						            
						//var actions = "";
						function action(com, grid) {
							switch (com) {
								case '录入设备信息' :
									$.dialog({
										content:$("#addTab")[0],
										title:'录入设备信息',
										id:'idAdd',
										lock :true,
										background :'#245EDC',
										opacity:0.5
									});
									break;
								case '修改设备信息' :
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
										content:$("#updateTab")[0],
										title:'修改设备信息',
										id:'idUpdate',
										lock :true,
										background :'#245EDC',
										opacity:0.5
									});
									
									$.ajax({
										url : '${pageContext.request.contextPath}/test_showDeviceInfoById.do',
										data : {id : data[0]},
										type : 'POST',
										dataType : 'json',
										success : function(data) {
											var json = eval(data);
											$("#update_deviceId").val(json.deviceId);
											$("#update_deviceName").val(json.deviceName);
											$("#update_deviceModel").val(json.deviceModel);
											$("#update_deviceNum").val(json.deviceNum);
											$("#update_deviceType").val(json.deviceType);
										}
									});
									break;
								case '删除设备信息' :
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
								case '查看设备信息' :
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
									
									$.ajax({
										url : '${pageContext.request.contextPath}/test_showDeviceInfoById.do',
										data : {id : data[0]},
										type : 'POST',
										dataType : 'json',
										success : function(data) {
											var json = eval(data);
											$("#select_deviceId").val(json.deviceId);
											$("#select_deviceName").val(json.deviceName);
											$("#select_deviceModel").val(json.deviceModel);
											$("#select_deviceNum").val(json.deviceNum);
											$("#select_deviceType").val(json.deviceType);
										}
									});
									break;
							}
						}
					});
					function delDeviceInfo(ids) {
						$.ajax({
							url : '${pageContext.request.contextPath}/test_delDeviceInfo.do',
							data : {id : ids},
							type : 'POST',
							dataType : 'json',
							success : function(data) {
								if(data.success){
									alert(data.message);
									$('#device_grid').reload();// 表格重载						
								}else{
									alert(data.message);
								}
							}
						});
					};
					function search(){
						var  k = {wjsearch:[{name:'deviceName',value: $('#serach_deviceName').attr('value')},{name:'deviceType',value: $('#serach_deviceType').attr('value')}]};
						$('#device_grid').flexReload(k);  
					};
					</script>
</head>

<body>
	<div id="Nav">
		<span>设备管理>>设备管理</span>
	</div>
	<div id="searchDiv">
		<table id="serach-table">
			<tr>
				<td class="title_td">设备名称</td>
				<td><input id="serach_deviceName" name="deviceName" /></td>
				<td class="title_td">设备类型</td>
				<td>
				<select id="serach_deviceType" name="deviceType">
					    <option value="">请选择</option>
						<option value="009001">类型一</option>
						<option value="009002">类型二</option>
						<option value="009003">类型三</option>
					</select>
				</td>
				<td class="btn-td"><input type="button"
					onclick="return search()" value="搜索" /></td>
			</tr>
		</table>
	</div>
	<table id="device_grid"></table>
	<div id="addTab" style="display: none">
		<form id="addDeviceInfoForm">
			<table class="dataTab">
				<tr>
					<td class="title_td">设备名称</td>
					<td colspan="3"><input id="add_deviceName" name="deviceBaseInfo.deviceName" class="w_title" isempty="no" tip="设备名称不能为空"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td class="title_td">设备型号</td>
					<td colspan="3"><input id="add_deviceModel" name="deviceBaseInfo.deviceModel" class="w_title" isempty="no" tip="设备型号不能为空"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td class="title_td">设备序列号</td>
					<td colspan="3"><input id="add_deviceNum" name="deviceBaseInfo.deviceNum" isempty="no" tip="设备序列号不能为空"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td class="title_td">设备类型</td>
					<td colspan="3">
					<select id="add_deviceType" name="deviceBaseInfo.deviceType" isempty="no" tip="设备类型不能为空">
					    <option value="009001">类型一</option>
						<option value="009002">类型二</option>
						<option value="009003">类型三</option>
					</select>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center" style="padding-top:20px;">
						<span id="btn_add_device" class="btn">确定</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="updateTab" style="display: none">
		<form id="updateDeviceInfoForm">
			<table class="dataTab">
				<tr>
					<td class="title_td">设备名称</td>
					<td colspan="3">
					<input type="hidden" id="update_deviceId" name="deviceBaseInfo.deviceId">
					<input id="update_deviceName" name="deviceBaseInfo.deviceName" class="w_title" isempty="no" tip="设备名称不能为空"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td class="title_td">设备型号</td>
					<td colspan="3"><input id="update_deviceModel" name="deviceBaseInfo.deviceModel" class="w_title" isempty="no" tip="设备型号不能为空"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td class="title_td">设备序列号</td>
					<td colspan="3"><input id="update_deviceNum" name="deviceBaseInfo.deviceNum" isempty="no" tip="设备序列号不能为空"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td class="title_td">设备类型</td>
					<td colspan="3">
					<select id="update_deviceType" name="deviceBaseInfo.deviceType" isempty="no" tip="设备类型不能为空">
					    <option value="009001">类型一</option>
						<option value="009002">类型二</option>
						<option value="009003">类型三</option>
					</select>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center" style="padding-top:20px;">
						<span id="btn_update_device" class="btn">确定</span>
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