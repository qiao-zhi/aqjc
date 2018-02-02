<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String pbsId = request.getParameter("pbsId");
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<jsp:include page="../common/include-common.jsp"></jsp:include>
<style type="text/css">
#infoFmTab input{
	width:150px;
}
</style>
<script type="text/javascript" src="<%=request.getContextPath() %>/jscript/sys/app/ins_list.js"></script>
<script>
	$(function(){ 
		$("#device_grid").flexigrid({   
			url: '${pageContext.request.contextPath}/pbsInfo_selPbsDveList.do?pbsId=<%= pbsId%>',
	        dataType: 'json',
	        display : 'true',
	        colModel : [   
	          {display: '主键', name : 'Id', width : 70, sortable : true, align: 'center',hide: true},
	          {display: '序号', name : 'number', width : 20, sortable : true, align: 'center'},
	          {display: '设备名称', name : 'DveName', width : 150, sortable : true, align: 'center'},
	          {display: '设备类型', name : 'DevTypeName', width : 100, sortable : true, align: 'center'},
	          {display: '类型dic', name : 'DevType', width : 100, sortable : true, align: 'center',hide: true},
	          {display: '设备型号', name : 'DevModel', width : 150, sortable : true, align: 'center'},
	          {display: '设备厂商', name : 'DevFactory', width : 200, sortable : true, align: 'center'}, 
	          {display: '工作频段', name : 'Band', width : 200, sortable : true, align: 'center',hide: true},
	          {display: '光纤是否带金属', name : 'HasMetalFirmware', width : 200, sortable : true, align: 'center',hide: true},
	          {display: '插入损耗', name : 'InsertionLoss', width : 200, sortable : true, align: 'center',hide: true},
	          {display: '空调波导管数量', name : 'KtbdgNum', width : 200, sortable : true, align: 'center',hide: true},
	          {display: '屏蔽效能', name : 'PbEfficiency', width : 200, sortable : true, align: 'center',hide: true}
					],
			  buttons : [
						{name : '新增设备',onpress : action},
						{separator: true},
						{name : '修改设备',onpress : action},
						{separator: true},
						{name : '删除设备',onpress : action}
					],
	            sortname: "DevType",
	            sortorder: "desc",   
	            usepager: true,   
	            checkbox : true,
	            useRp: true,
	            title: '设备列表',
	            rp: 10,   
	            width: 'auto',
	            height:'auto',
	            wjsearch:[{name:'dName',value: $('#search_dveName').attr('value')},{name:'dType',value: $('#search_dveType').attr('value')}]
		});				            
		//var actions = "";
		function action(com, grid) {
			switch (com) {
				case '新增设备' :
					$("#infoFmTab input").each(function(i){
			    		$(this).val('');
			    	 });
					$("#operate").val("add");
					$("#flagId").val("<%= pbsId%>");
					chooseDveType();
					$.dialog({
						content:$("#addTab")[0],
						title:'新增设备',
						id:'idAdd',
						lock :true,
						background :'#245EDC',
						opacity:0.5
					});
					break;
				case '修改设备' :
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
					$("#infoFmTab input").each(function(i){
			    		$(this).val('');
			    	 });
					$("#operate").val("upd");
					$("#flagId").val($.trim(data[0]));
					$('#dveName').val($.trim(data[2]));
					$('#devFactory').val($.trim(data[6]));
					$('#devModel').val($.trim(data[5]));
					$('#band').val($.trim(data[7]));
					$('#insertionLoss').val($.trim(data[9]));
					$('#devType').val($.trim(data[4]));
					$('#pbEfficiency').val($.trim(data[11]));
					$('#hasMetalFirmware').val($.trim(data[8]));
					$('#ktbdgNum').val($.trim(data[10]));
					
					chooseDveType();
					$.dialog({
						content:$("#addTab")[0],
						title:'修改设备',
						id:'idAdd',
						lock :true,
						background :'#245EDC',
						opacity:0.5
					});
					break;
				case '删除设备' :
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
						delPbsDevice(ids);
					}
					break;
			}
		}
		$("#btn_save").click(function() {
			if (!validate($("#addDeviceInfoForm"))){
				var $mark = $("body>div").last();
				var _zIndex = $mark.css('zIndex');
				$mark.css({
					zIndex:9999
				});
				$.ajax({
					url : '${pageContext.request.contextPath}/pbsInfo_savePbsDve.do',
					data : $("#addDeviceInfoForm").serialize(),
					type : 'POST',
					dataType : 'json',
					async:false,
					success : function(data) {
						$mark.css('zIndex',_zIndex);
						if(data.success){
							alert(data.message);
							$('#device_grid').reload();// 表格重载
							$.dialog.get('idAdd').close();
						}else{
							alert(data.message);
						}
					}
				});
			}
		});
	});
	function delPbsDevice(ids) {
		$.ajax({
			url : '${pageContext.request.contextPath}/pbsInfo_delPbsDve.do',
			data : {'dveIds' : ids,'pbsId':'<%= pbsId%>'},
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
	function chooseDveType(){
		var v = $("#devType").val();
		if(v=="1"||v=="2"||v=="3"){
			$("#band").attr("disabled",false);
			$("#insertionLoss").attr("disabled",false);
			$("#pbEfficiency").attr("disabled",true);
			$("#hasMetalFirmware").attr("disabled",true);
			$("#ktbdgNum").attr("disabled",true);
		}
		if(v=="4"){
			$("#band").attr("disabled",false);
			$("#insertionLoss").attr("disabled",true);
			$("#pbEfficiency").attr("disabled",false);
			$("#hasMetalFirmware").attr("disabled",true);
			$("#ktbdgNum").attr("disabled",true);
		}
		if(v=="5"){
			$("#band").attr("disabled",false);
			$("#insertionLoss").attr("disabled",true);
			$("#pbEfficiency").attr("disabled",true);
			$("#hasMetalFirmware").attr("disabled",true);
			$("#ktbdgNum").attr("disabled",false);
		}
		if(v=="6"){
			$("#band").attr("disabled",true);
			$("#insertionLoss").attr("disabled",true);
			$("#pbEfficiency").attr("disabled",true);
			$("#hasMetalFirmware").attr("disabled",true);
			$("#ktbdgNum").attr("disabled",true);
		}
		if(v=="7"){
			$("#band").attr("disabled",true);
			$("#insertionLoss").attr("disabled",true);
			$("#pbEfficiency").attr("disabled",true);
			$("#hasMetalFirmware").attr("disabled",false);
			$("#ktbdgNum").attr("disabled",true);
		}
	}
	function search(){
		var  k = {wjsearch:[{name:'dName',value: $('#search_dveName').attr('value')},{name:'dType',value: $('#search_dveType').attr('value')}]};
		$('#device_grid').flexReload(k);  
	};
</script>
</head>

<body>
	<div id="Nav">
		<span>屏蔽室管理>>屏蔽室信息</span>
	</div>
	<div id="searchDiv">
		<table id="serach-table">
			<tr>
				<td class="title_td">设备名称</td>
				<td>
					<input id="search_dveName" name="dName" />
				</td>
				<td class="title_td">设备类型</td>
				<td>
					<select id="search_dveType" name="dType">
					    <option value="all">请选择</option>
						<option value="1">电磁滤波器</option>
						<option value="2">电话滤波器</option>
						<option value="3">信号滤波器</option>
						<option value="4">通风波导窗</option>
						<option value="5">空调设备</option>
						<option value="6">消防设备</option>
						<option value="7">光纤</option>
					</select>
				</td>
				<td class="btn-td"><input type="button" onclick="return search()" value="搜索" /></td>
			</tr>
		</table>
	</div>
	
	<table id="device_grid"></table>
	
	<div id="addTab" style="display: none">
		<form id="addDeviceInfoForm">
			<table class="dataTab" id="infoFmTab">
				<tr>
					<td class="title_td">设备名称</td>
					<td colspan="3">
						<input id="dveName" name="pbsDevice.dveName" style="width:250px;" isempty="no" tip="名称不能为空"/>
						<input type="hidden" id="flagId" name="flagId">
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="title_td">设备类型</td>
					<td >
					<select id="devType" name="pbsDevice.devType" onchange="chooseDveType()">
						<option value="1">电磁滤波器</option>
						<option value="2">电话滤波器</option>
						<option value="3">信号滤波器</option>
						<option value="4">通风波导窗</option>
						<option value="5">空调设备</option>
						<option value="6">消防设备</option>
						<option value="7">光纤</option>
					</select>
					</td>
					<td class="title_td">设备型号</td>
					<td ><input id="devModel" name="pbsDevice.devModel" /></td>
				</tr>
				<tr>
					<td class="title_td">设备厂商</td>
					<td ><input id="devFactory" name="pbsDevice.devFactory" /></td>
					<td class="title_td">工作频段</td>
					<td ><input id="band" name="pbsDevice.band" /></td>
				</tr>
				<tr>	
					<td class="title_td">插入损耗</td>
					<td ><input id="insertionLoss" name="pbsDevice.insertionLoss" /></td>
					<td class="title_td">屏蔽效能</td>
					<td ><input id="pbEfficiency" name="pbsDevice.pbEfficiency" /></td>
				</tr>	
				<tr>
					<td class="title_td">光纤类型</td>
					<td ><input id="hasMetalFirmware" name="pbsDevice.hasMetalFirmware" /></td>
					<td class="title_td">空调波导管数量</td>
					<td ><input id="ktbdgNum" name="pbsDevice.ktbdgNum" /></td>
				</tr>	
				<tr>
					<td colspan="4" align="center" style="padding-top:20px;">
						<input id="operate" name="operate" type="hidden">
						<span id="btn_save" class="btn">保存</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>