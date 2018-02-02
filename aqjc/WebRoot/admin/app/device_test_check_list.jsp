<%@ page language="java" import="java.util.*,com.tyust.bean.user.TBaseUserInfo"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<title>设备安全检测申请列表</title>
<jsp:include page="../common/include-common.jsp"></jsp:include>
<style type="text/css">
.w_title{
	width:398px;
}
</style>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/jscript/sys/app/device_test_check_list.js"></script>
<script>
	$(function(){
		//设备详情列表
		$("#device_add_detail_grid").flexigrid({   
			url: '${pageContext.request.contextPath}/test_showDeviceBaseLinkList.do?state=0&unit=<%=user.getUnitId()%>',
	        dataType: 'json',
	        display : 'true',   
	        colModel : [   
	          {display: '主键', name : 'linkId', width : 70, sortable : true, align: 'center',hide: true},
	          {display: '序号', name : 'number', width : 20, sortable : true, align: 'center',hide: false},
	          {display: '设备名称', name : 'deviceName', width : 200, sortable : true, align: 'center'},
	          {display: '设备型号', name : 'deviceModel', width : 250, sortable : true, align: 'center'},
	          {display: '设备序列号', name : 'deviceNum', width : 150, sortable : true, align: 'center'},
	          {display: '设备类型', name : 'deviceTypeName', width : 150, sortable : true, align: 'center'}
					],
			buttons : [
					{name : '增加',onpress : action1},
					{separator: true},
					{name : '删除',onpress : action1},
					{separator: true}
				],
	            sortname: "name",   
	            sortorder: "desc",   
	            usepager: true,   
	            checkbox : true,// 是否要多选框
	            useRp: true,
	            title: '设备信息列表',
	            rp: 10,   
	            width: '650',
	            height:'auto'
			});
		var actions = "";
		function action1(com, grid) {
			switch (com) {
				case '增加' :
					$.dialog({
						content:$("#addSelTab")[0],
						title:'选择加入需要检测的设备',
						id:'idAddSel',
						lock :true,
						background :'#245EDC',
						opacity:0.5
					});
					break;
				case '删除' :
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
					if (confirm("确定删除需要检测的设备?")) {
						delDeviceTestBaseLink(ids);
					}
					break;
			}
		};
		//设备详情列表
		$("#device_update_detail_grid").flexigrid({   
			url: '${pageContext.request.contextPath}/test_showDeviceBaseLinkList.do',
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
					{name : '增加',onpress : action2},
					{separator: true},
					{name : '删除',onpress : action2},
					{separator: true}
				],
	            sortname: "name",   
	            sortorder: "desc",   
	            usepager: true,   
	            checkbox : true,// 是否要多选框
	            useRp: true,
	            title: '设备信息列表',
	            rp: 10,   
	            width: '650',
	            height:'auto',
	            wjsearch:[{name:'testId',value: 'testId'}]
			});
		var actions = "";
		function action2(com, grid) {
			switch (com) {
				case '增加' :
					$.dialog({
						content:$("#updateSelTab")[0],
						title:'选择加入需要检测的设备',
						id:'idUpdateSel',
						lock :true,
						background :'#245EDC',
						opacity:0.5
					});
					break;
				case '删除' :
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
					if (confirm("确定删除需要检测的设备?")) {
						delDeviceTestBaseLink(ids);
					}
					break;
			}
		};
		//设备详情列表
		$("#device_select_detail_grid").flexigrid({   
			url: '${pageContext.request.contextPath}/test_showDeviceBaseLinkList.do',
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
	            sortname: "name",   
	            sortorder: "desc",   
	            usepager: true,   
	            checkbox : true,// 是否要多选框
	            useRp: true,
	            title: '设备信息列表',
	            rp: 10,   
	            width: '650',
	            height:'auto',
	            wjsearch:[{name:'testId',value: 'testId'}]
			});
		//选择加入设备列表
		$("#device_add_sel_detail_grid").flexigrid({   
			url: '${pageContext.request.contextPath}/test_showDeviceInfoList.do?unitId=<%=user.getUnitId()%>',
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
					{name : '选择加入',onpress : action5},
					{separator: true}
				],
	            sortname: "name",   
	            sortorder: "desc",   
	            usepager: true,   
	            checkbox : true,// 是否要多选框
	            useRp: true,
	            title: '设备信息列表',
	            rp: 10,   
	            width: 'auto',
	            height:'auto'
			});
		var actions = "";
		function action5(com, grid) {
			switch (com) {
				case '选择加入' :
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
					if (confirm("确定加入所选设备?")) {
						saveDeviceTestBaseLink(ids,'10','');
					}
					break;
			}
		};
		//选择加入设备列表
		$("#device_update_sel_detail_grid").flexigrid({   
			url: '${pageContext.request.contextPath}/test_showDeviceInfoList.do?unitId=<%=user.getUnitId()%>',
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
					{name : '选择加入',onpress : action6},
					{separator: true}
				],
	            sortname: "name",   
	            sortorder: "desc",   
	            usepager: true,   
	            checkbox : true,// 是否要多选框
	            useRp: true,
	            title: '设备信息列表',
	            rp: 10,   
	            width: 'auto',
	            height:'auto'
			});
		var actions = "";
		function action6(com, grid) {
			switch (com) {
				case '选择加入' :
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
					if (confirm("确定加入所选设备?")) {
						var testId = $('#update_testId').attr('value');
						saveDeviceTestBaseLink(ids,'20',testId);
					}
					break;
			}
		};
		//设备安全检测申请列表
		$("#device_test_grid").flexigrid({   
			url: '${pageContext.request.contextPath}/test_showDeviceTestList.do',
	        dataType: 'json',
	        display : 'true',   
	        colModel : [   
	          {display: '主键', name : 'testId', width : 70, sortable : true, align: 'center',hide: true},
	          {display: '状态编号', name : 'state', width : 70, sortable : true, align: 'center',hide: true},
	          {display: '序号', name : 'number', width : 20, sortable : true, align: 'center',hide: false},
	          {display: '申请单位', name : 'unitName', width : 150, sortable : true, align: 'center'},
	          {display: '申请人', name : 'applyName', width : 120, sortable : true, align: 'center'},
	          {display: '申请时间', name : 'applyDate', width : 120, sortable : true, align: 'center'},
	          {display: '设备数量', name : 'applyNum', width : 120, sortable : true, align: 'center'},
	          {display: '联系电话', name : 'applyPhone', width : 120, sortable : true, align: 'center'},
	         /*  {display: '手机', name : 'applyTel', width : 120, sortable : true, align: 'center'}, */
	          {display: '状态', name : 'stateStr', width : 120, sortable : true, align: 'center'},
	          {display: '操作', name : 'editor', width : 150, sortable : true, align: 'center'}
					],
					buttons : [
								{name : '录入',onpress : action},
								{separator: true},
								{name : '修改',onpress : action},
								{separator: true},
								{name : '删除',onpress : action},
								{separator: true},
								{name : '查看详情',onpress : action}
							],
				            sortname: "name",   
				            sortorder: "desc",   
				            usepager: true,   
				            checkbox : true,// 是否要多选框
				            useRp: true,
				            title: '设备安全检测申请信息列表',
				            rp: 10,   
				            width: 'auto',
				            height:'auto',
				            wjsearch:[{name:'state',value: $('#serach_state').attr('value')}]
					});
						            
						var actions = "";
						function action(com, grid) {
							switch (com) {
								case '录入' :
									$('#device_add_detail_grid').reload();
									$('#add_unitName').val("<%=user.getUnitName()%>");
									setTimeout("$('#add_applyNum').val($('#device_add_detail_grid').flexigrid().find('tr').length)",1000);
									//$('#add_applyNum').val($('#device_add_detail_grid').flexigrid().find('tr').length);
									$.dialog({
										content:$("#addTab")[0],
										title:'录入设备安全检测申请信息',
										id:'idAdd',
										lock :true,
										background :'#245EDC',
										opacity:0.5
									});
									break;
								case '修改' :
									selected_count = $('.trSelected', grid).length;
									if (selected_count == 0) {
										alert('请选择一条记录!');
										return;
									}
									if (selected_count > 1) {
										alert('抱歉只能同时修改一条记录!');
										return;
									}
									var state = false;
									$('.trSelected td:nth-child(3) div', grid).each(function(i) {
										if ($(this).text()!="10"){
											state = true;
											return;
										}
									});
									if(state){
										alert('只能修改未提交的记录!');
										return;
									}
									data = new Array();
									$('.trSelected td', grid).each(function(i) {
										data[i] = $(this).children('div').text();
									});
									$.dialog({
										content:$("#updateTab")[0],
										title:'修改设备安全检测申请信息',
										id:'idUpdate',
										lock :true,
										background :'#245EDC',
										opacity:0.5
									});
									
									$.ajax({
										url : '${pageContext.request.contextPath}/test_showDeviceTestById.do',
										data : {id : data[0]},
										type : 'POST',
										dataType : 'json',
										success : function(data) {
											var json = eval(data);
											$("#update_testId").val(json.testId);
											$("#update_unitName").val(json.unitName);
											$("#update_applyNum").val(json.applyNum);
											$("#update_applyName").val(json.applyName);
											$("#update_applyPhone").val(json.applyPhone);
											$("#update_unitOption").val(json.unitOption);
											var  k = {wjsearch:[{name:'testId',value: $('#update_testId').attr('value')}]};
											$('#device_update_detail_grid').flexReload(k);
										}
									});
									break;
								case '删除' :
									selected_count = $('.trSelected', grid).length;
									if (selected_count == 0) {
										alert('请选择一条记录!');
										return;
									}
									var state = false;
									$('.trSelected td:nth-child(3) div', grid).each(function(i) {
										if ($(this).text()!="10"){
											state = true;
											return;
										}
									});
									if(state){
										alert('只能删除未提交的记录!');
										return;
									}
									ids = '';
									$('.trSelected td:nth-child(2) div', grid).each(function(i) {
												if (i)
													ids += ',';
												ids += $(this).text();
									});
									if (confirm("确定删除?")) {
										delDeviceTest(ids);
									}
									break;
								case '查看详情' :
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
										title:'设备安全检测申请详细信息',
										id:'idSelect',
										lock :true,
										background :'#245EDC',
										opacity:0.5
									});
									
									$.ajax({
										url : '${pageContext.request.contextPath}/test_showDeviceTestById.do',
										data : {id : data[0]},
										type : 'POST',
										dataType : 'json',
										success : function(data) {
											var json = eval(data);
											var json = eval(data);
											$("#select_testId").val(json.testId);
											$("#select_unitName").val(json.unitName);
											$("#select_applyNum").val(json.applyNum);
											$("#select_applyName").val(json.applyName);
											$("#select_applyPhone").val(json.applyPhone);
											$("#select_unitOption").val(json.unitOption);
											var  k = {wjsearch:[{name:'testId',value: $('#select_testId').attr('value')}]};
											$('#device_select_detail_grid').flexReload(k);
										}
									});
									break;
							}
						}
					});
					function delDeviceTest(ids) {
						$.ajax({
							url : '${pageContext.request.contextPath}/test_delDeviceTest.do',
							data : {id : ids},
							type : 'POST',
							dataType : 'json',
							success : function(data) {
								if(data.success){
									alert(data.message);
									$('#device_test_grid').reload();// 表格重载						
								}else{
									alert(data.message);
								}
							}
						});
					};
					function delDeviceTestBaseLink(ids) {
						$.ajax({
							url : '${pageContext.request.contextPath}/test_delDeviceTestBaseLink.do',
							data : {id : ids},
							type : 'POST',
							dataType : 'json',
							success : function(data) {
								if(data.success){
									alert(data.message);
									$('#device_add_detail_grid').reload();// 表格重载	
									setTimeout("$('#add_applyNum').val($('#device_add_detail_grid').flexigrid().find('tr').length)",1000);
									$('#device_update_detail_grid').reload();// 表格重载
									setTimeout("$('#update_applyNum').val($('#device_update_detail_grid').flexigrid().find('tr').length)",1000);
								}else{
									alert(data.message);
								}
							}
						});
					};
					function saveDeviceTestBaseLink(ids,type,testId) {
						$.ajax({
							url : '${pageContext.request.contextPath}/test_saveDeviceTestBaseLink.do',
							data : {id : ids,'type':type,'testId':testId},
							type : 'POST',
							dataType : 'json',
							success : function(data) {
								if(data.success){
									alert(data.message);
									if(type=="10"){
										$('#device_add_detail_grid').reload();// 表格重载
										setTimeout("$('#add_applyNum').val($('#device_add_detail_grid').flexigrid().find('tr').length)",1000);
										$.dialog.get('idAddSel').close();
									}else if(type="20"){
										$('#device_update_detail_grid').reload();// 表格重载
										setTimeout("$('#update_applyNum').val($('#device_update_detail_grid').flexigrid().find('tr').length)",1000);
										$.dialog.get('idUpdateSel').close();
									}
								}else{
									alert(data.message);
								}
							}
						});
					};
					function editDeviceState(ids,type,testId) {
						$.ajax({
							url : '${pageContext.request.contextPath}/test_editDeviceState.do',
							data : {id : ids,'type':type,'testId':testId},
							type : 'POST',
							dataType : 'json',
							success : function(data) {
								if(data.success){
									//alert(data.message);
									if(type=="10"){
										$('#device_add_detail_grid').reload();// 表格重载
										setTimeout("$('#add_applyNum').val($('#device_add_detail_grid').flexigrid().find('tr').length)",1000);
										setTimeout("$('#update_applyNum').val($('#device_update_detail_grid').flexigrid().find('tr').length)",1000);
										$.dialog.get('idSel').close();
									}
									if(type=="20"){
										$('#device_add_detail_grid').reload();// 表格重载
										setTimeout("$('#add_applyNum').val($('#device_add_detail_grid').flexigrid().find('tr').length)",1000);
									}
									if(type=="40"){
										$('#device_update_detail_grid').reload();// 表格重载
										setTimeout("$('#update_applyNum').val($('#device_update_detail_grid').flexigrid().find('tr').length)",1000);
									}
									
								}else{
									alert(data.message);
								}
							}
						});
					};
					function submitTest(testId) {
						$.ajax({
							url : '${pageContext.request.contextPath}/test_submitDeviceTestState.do',
							data : {'testId' : testId},
							type : 'POST',
							dataType : 'json',
							success : function(data) {
								if(data.success){
									alert(data.message);
									$('#device_test_grid').reload();// 表格重载						
								}else{
									alert(data.message);
								}
							}
						});
					};
					function search(){
						var  k = {wjsearch:[{name:'state',value: $('#serach_state').attr('value')}]};
						$('#device_test_grid').flexReload(k);  
					};
					</script>
</head>

<body>
	<div id="Nav">
		<span>设备管理>>设备安全检测申请</span>
	</div>
	<div id="searchDiv">
		<table id="serach-table">
			<tr>
				<td class="title_td">申请状态</td>
				<td colspan="3">
				<select id="serach_state" name="state">
					    <option value="">请选择</option>
						<option value="10">未提交</option>
						<option value="11">未审核</option>
						<option value="12">已审核</option>
					</select>
				</td>
				<td class="btn-td"><input type="button"
					onclick="return search()" value="搜索" /></td>
			</tr>
		</table>
	</div>
	<table id="device_test_grid"></table>
	<div id="addTab" style="display: none">
		<form id="addDeviceTestForm">
			<table class="dataTab">
				<tr>
					<td class="title_td">申请单位</td>
					<td ><input id="add_unitName" name="deviceTest.unitName" readonly="readonly"/></td>
					<td class="title_td">设备数量</td>
					<td ><input id="add_applyNum" name="deviceTest.applyNum" readonly="readonly"/></td>
				</tr>
			</table>
			<table id="device_add_detail_grid"></table>
			<table class="dataTab">
				<tr>
					<td class="title_td">申请人</td>
					<td ><input id="add_applyName" name="deviceTest.applyName" isempty="no" tip="申请人不能为空"/><font color="red">*</font></td>
					<td class="title_td">联系方式</td>
					<td ><input id="add_applyPhone" name="deviceTest.applyPhone" isempty="no" tip="联系方式不能为空"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td class="title_td">申请单位意见</td>
					<td colspan="3">
					<textarea id="add_unitOption" name="deviceTest.unitOption" class="w_title"></textarea><font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" style="padding-top:20px;">
						<span id="btn_add_device_test" class="btn">保存</span>
					</td>
					<td colspan="2" align="center" style="padding-top:20px;">
						<span id="btn_add_submit_device_test" class="btn">提交</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="updateTab" style="display: none">
		<form id="updateDeviceTestForm">
			<table class="dataTab">
				<tr>
					<td class="title_td">申请单位</td>
					<td >
					<input id="update_testId" name="deviceTest.testId" type="hidden"/>
					<input id="update_unitName" name="deviceTest.unitName" readonly="readonly"/></td>
					<td class="title_td">设备数量</td>
					<td ><input id="update_applyNum" name="deviceTest.applyNum" readonly="readonly"/></td>
				</tr>
			</table>
			<table id="device_update_detail_grid"></table>
			<table class="dataTab">
				<tr>
					<td class="title_td">申请人</td>
					<td ><input id="update_applyName" name="deviceTest.applyName" isempty="no" tip="申请人不能为空"/><font color="red">*</font></td>
					<td class="title_td">联系方式</td>
					<td ><input id="update_applyPhone" name="deviceTest.applyPhone" isempty="no" tip="联系方式不能为空"/><font color="red">*</font></td>
				</tr>
				<tr>
					<td class="title_td">申请单位意见</td>
					<td colspan="3">
					<textarea id="update_unitOption" name="deviceTest.unitOption" class="w_title"></textarea><font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" style="padding-top:20px;">
						<span id="btn_update_device_test" class="btn">修改</span>
					</td>
					<td colspan="2" align="center" style="padding-top:20px;">
						<span id="btn_update_submit_device_test" class="btn">提交</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="selectTab" style="display: none">
		<form id="selectDeviceTestForm">
			<table class="dataTab">
				<tr>
					<td class="title_td">申请单位</td>
					<td >
					<input id="select_testId" name="deviceTest.testId" type="hidden"/>
					<input id="select_unitName" name="deviceTest.unitName" readonly="readonly"/></td>
					<td class="title_td">设备数量</td>
					<td ><input id="select_applyNum" name="deviceTest.applyNum" readonly="readonly"/></td>
				</tr>
			</table>
			<table id="device_select_detail_grid"></table>
			<table class="dataTab">
				<tr>
					<td class="title_td">申请人</td>
					<td ><input id="select_applyName" name="deviceTest.applyName" readonly="readonly"/></td>
					<td class="title_td">联系方式</td>
					<td ><input id="select_applyPhone" name="deviceTest.applyPhone" readonly="readonly"/></td>
				</tr>
				<tr>
					<td class="title_td">申请单位意见</td>
					<td colspan="3">
					<textarea id="select_unitOption" name="deviceTest.unitOption" readonly="readonly" class="w_title"></textarea>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="addSelTab" style="display: none">
		<form id="addSelDeviceTestForm">
			<table id="device_add_sel_detail_grid"></table>
		</form>
	</div>
	<div id="updateSelTab" style="display: none">
		<form id="updateSelDeviceTestForm">
			<table id="device_update_sel_detail_grid"></table>
		</form>
	</div>
</body>
</html>