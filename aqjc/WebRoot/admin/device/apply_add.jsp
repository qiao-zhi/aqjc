<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.tyust.bean.user.TBaseUserInfo"%>
<%@ page
	import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.tyust.dao.unit.IunitDao,com.tyust.bean.unit.TBaseUnitInfo"%>
<%@ page import="java.util.*,com.tyust.common.DateHandler" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	TBaseUserInfo user = (TBaseUserInfo) request.getSession()
			.getAttribute("user");
	ApplicationContext context = WebApplicationContextUtils
			.getRequiredWebApplicationContext(request.getSession()
					.getServletContext());
	String unitId = user.getUnitId().trim();
	request.setAttribute("unitId", unitId);
	IunitDao unitDao = (IunitDao) context.getBean("Unit");
	TBaseUnitInfo unit = unitDao.findUnit(unitId);
%>
<!DOCTYPE html>
<html>
<head>
<title>新增设备检测申请</title>
<jsp:include page="../common/include-commonNew2.jsp"></jsp:include>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/newStyle/plugins/select2/select2.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/newStyle/plugins/bootstrap-fileinput/css/fileinput.min.css" />
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/controls/jquery-editable-select-master/dist/jquery-editable-select.min.css" />
<style>
		.dataTab {font-size:13px; color: #000;}
		.dataTab input{width: 220px;height: 28px;font-size: 13px;	color: #000;}
		.dataTab select{width: 220px;height:28px;font-size: 13px;	color: #000;}


/*a{
	filter: alpha(opacity=30);
    opacity: 0.3;
    display: none;
}
a:hover{
	display: inline;
	filter: alpha(opacity=100);
    opacity: 1;
}*/
</style>

<script>

/* 为新增的设备设置顺序号 */
var devSeqId = 0;
$(function() {
	// $('#drpPublisher2').editableSelect();
     

});

//上传设备信息的excel文件对话框
function addDveFromFileDialog(){
	//importDevFromFileTab
	$.dialog({
		content:$("#importDevFromFileTab")[0],
		title:'从Excel文件中导入设备信息',
		id:'idImportDevFromFileTab',
		lock :true,
		background :'#245EDC',
		opacity:0.5
	});
}

//显示添加设备的对话框
function addDveDialog(){
	//初始化表单，置空
	$("#infoTab input").each(function(i){
		$(this).val('');
	 });
	
   //若是省局用户，将添加设备对话框中的单位信息设置为页面下拉列表框中选择的值；否则，当前用户所在单位作为默认值
	if(<%=unitId%> == "1"){
		$("#unitName").val($(".select2 option:selected").html());
		$("#devUnitId").val($("#devApplyUnitName").val());
		//alert($("#devApplyUnitName").val());
	}
	else{
		$("#unitName").val('<%=unit.getUnitName()%>');
		$("#unitId").val('<%=unit.getUpUnitId()%>');
	}
	$.dialog({
		content:$("#addTab")[0],
		title:'添加设备',
		id:'idAdd',
		lock :true,
		background :'#245EDC',
		opacity:0.5
	});
	// 加载设备类型字典信息
	loadUpdic("");
	// 初始化3个select控件
	loadLocalData2SelectDevName("");
	loadLocalData2SelectDevModel("");
	loadLocalData2SelectDevNum("");
	/*  */
	$("#devSeqId").val(devSeqId++);
	$("#operation").val("add");
}

//修改设备对话框
function updDveDialog(obj){
	$("#infoTab input").each(function(i){
		$(this).val('');
	 });

	 // 获取当前行tr的所有td对象
	 var $inputs=$(obj).parent().children('input');
	 var devId 		= $inputs.eq(0).val();
	 var devClassUp = $inputs.eq(1).val();
	 var devTypeID 	= $inputs.eq(2).val();
	 var devSeqId 	= $inputs.eq(3).val();

	 // alert(devClassUp);
	// alert(id);
	var $td= $(obj).parents('tr').children('td');  
    var devName = $td.eq(1).text();  
    var devModel = $td.eq(2).text();  
    var devNum = $td.eq(3).text();
    // var devType = $td.eq(3).text();
    // $("#add_deviceName").val(devName);
    // $("#add_deviceModel").val(devModel);
    // $("#add_deviceNum").val(devNum);
    $("#add_deviceType").val(devTypeID);
    $("#add_deviceClassUp").val(devClassUp);
    $("#devSeqId").val(devSeqId);

	
	
	//若是省局用户，将添加设备对话框中的单位信息设置为页面下拉列表框中选择的值；否则，当前用户所在单位作为默认值
	if(<%=unitId%> == "1"){
		$("#unitName").val($(".select2 option:selected").html());
		$("#devUnitId").val($("#devApplyUnitName").val());
		//alert($("#devApplyUnitName").val());
	}
	else{
		$("#unitName").val('<%=unit.getUnitName()%>');
		$("#unitId").val('<%=unit.getUpUnitId()%>');
	};

	$.dialog({
		content:$("#addTab")[0],
		title:'修改设备',
		id:'idAdd',
		lock :true,
		background :'#245EDC',
		opacity:0.5
	});
	// 加载设备类型字典信息
	loadUpdic(devClassUp);
	// 初始化3个select控件
	loadLocalData2SelectDevName(devName);
	loadLocalData2SelectDevModel(devModel);
	loadLocalData2SelectDevNum(devNum);

	$("#devId").val(devId);
    $("#operation").val("update");
}

// 将设备名称、设备型号、设备序列号信息保存到浏览器本地，方便用户检索
function saveDevInfo2Local(){
	if(!window.localStorage){
            alert("浏览器支持localstorage");
            return false;
        }else{
            var storage=window.localStorage;
            // 获取需要保存的值
            var devName 	= 	$("#add_deviceName").val();
            var devModel 	= 	$("#add_deviceModel").val();
            var devNum 		= 	$("#add_deviceNum").val();

            //获取浏览器已有的值
            var devNameValues = storage.getItem("devName") ;
            if(devNameValues == null) 
            	devNameValues= "";

            var devModelValues = storage.getItem("devModel") ;
            if(devModelValues == null)
            	devModelValues = "";

            var devNumValues = storage.getItem("devNum") ;
            if(devNumValues == null)
            	devNumValues = "";
            


            //写入浏览器本地
            if(devNameValues.indexOf(devName) == -1){
	            storage.setItem("devName",devName+","+devNameValues);
            }
            if(devModelValues.indexOf(devModel) == -1){
	            storage.setItem("devModel",devModel+","+devModelValues);
            }
            if (devNumValues.indexOf(devNum) == -1) {
	            storage.setItem("devNum",devNum+","+devNumValues);
            }
            
            console.log(storage["devName"]);
            console.log(storage["devModel"]);
            console.log(storage["devNum"]);
        }
}
//验证录入设备信息的合法性
function validateDevInfo(){
	var devName 	= 	$("#add_deviceName").val();
    var devModel 	= 	$("#add_deviceModel").val();
    var devNum 		= 	$("#add_deviceNum").val();
	console.log("devName:" + devName);
	console.log("devModel" + devModel);
	console.log("devNum"+devNum);
	
    var validated = true;
	
    if($.trim(devName) == ""){
    	validated = false;
    	alert("请输入设备名称！");
    	// return;
    }
    if($.trim(devModel) == ""){
    	validated = false;
    	alert("请输入设备型号！");
    	return;
    }
    if($.trim(devNum) == ""){
    	validated = false;
    	alert("请输入设备序列号！");
    	// return;
    }

    return validated;


}

//点击模态框中保存按钮时调用该函数，向设备基本信息表（T_DEVICE_BASE_INFO）中添加设备信息
function addDve(){
	// if (validate($("#addDeviceInfoForm"))){
	// 	return;
	// }
	// 
	if(!validateDevInfo())
		return;
	/*向本地浏览器保存用户输入的设备信息  */
	saveDevInfo2Local();
	// alert($("#add_deviceName").val());

	var operation = $("#operation").val();
	var devId = $("#devId").val();

	// var devTabTr = "";
	// devTabTr = "<tr id='"+data.message+"'><td>"+$("#add_deviceName").val()+"</td>"+
	// 					"<td>"+$("#add_deviceModel").val()+"</td>"+
	// 					"<td>"+$("#add_deviceNum").val()+"</td>"+
	// 					"<td>"+$("#add_deviceType").find("option:selected").text()+"</td>"+
	// 					"<td><input name='dveId' type='hidden' value='"+data.message+"' />"+
	// 					"<input name='devClassUp' type='hidden' value='"+
	// 					$("#add_deviceClassUp").val()+ "' />  "+
	// 					"<input name='devTypeID' type='hidden' value='"+
	// 					$("#add_deviceType").val()+ "' />  "+

	// 					"<a href='javascript:void(0)' title='修改设备信息' onclick='updDveDialog(this)'><i class='fa fa-pencil-square-o fa-lg'  ></i></a>&nbsp;&nbsp;"+
	// 					"<a href='javascript:void(0)' title='删除设备信息' onclick='delExistDve(this)'><i class='fa fa-trash fa-lg'  ></i></a>"+
	// 					"</td></tr>";

	if (operation == 'update') {
	
		 var $tds = $("#"+devId).children("td");
		// $("#"+devId).children("td")[0].text() = "xbh";
		/*修改数据库中的设备信息  */
		$.ajax({
		url : '${pageContext.request.contextPath}/test_saveDeviceInfo.do',
		data : $("#addDeviceInfoForm").serialize(),
		type : 'POST',
		dataType : 'json',
		async:false,
		success : function(data) {
			if(data.success){
				var trIndex = 1;
				$tds.eq(trIndex++).text($("#add_deviceName").val());
				$tds.eq(trIndex++).text($("#add_deviceModel").val());
				$tds.eq(trIndex++).text($("#add_deviceNum").val());
				$tds.eq(trIndex++).text($("#add_deviceType").find("option:selected").text());
				$tds.eq(trIndex++).html("<input name='dveId' type='hidden' value='"+devId+"' />"+
								"<input name='devClassUp' type='hidden' value='"+
								$("#add_deviceClassUp").val()+ "' />  "+
								"<input name='devTypeID' type='hidden' value='"+
								$("#add_deviceType").val()+ "' />  "+
								"<input name='devSeqId'type='hidden'value='" + $("#devSeqId").val()+" '/> "+
								"<a href='javascript:void(0)' title='修改设备信息' onclick='updDveDialog(this)'><i class='fa fa-pencil-square-o fa-lg'  ></i></a>&nbsp;&nbsp;"+
								"<a href='javascript:void(0)' title='删除设备信息' onclick='delExistDve(this)'><i class='fa fa-trash fa-lg'  ></i></a>");
				$.dialog.get('idAdd').close();
			}else{
				alert(data.message);
			}
		}
	});

		
		

		// $("#"+devId) = $(newtd);
		// alert($("#"+devId).html() + newtd);
		// $("#"+devId).html();
		 // $("#"+devId).text()="abc维护性";

	}else {
		/*向数据库中添加设备操作  */
	$.ajax({
		url : '${pageContext.request.contextPath}/test_saveDeviceInfo.do',
		data : $("#addDeviceInfoForm").serialize(),
		type : 'POST',
		dataType : 'json',
		async:false,
		success : function(data) {
			if(data.success){
				// 为新增设备显示分配新的序号：在现有基础上增1；
				var $tds = $("#selectedDveTab").find("tr");
				var newRowSeq;
				console.log( $tds.length);
				newRowSeq = $tds.length > 1 ?  parseInt($tds.last().find("td").eq(0).text()) + 1 :  1;
				// var newRowSeq = parseInt($("#selectedDveTab").find("tr").last().find("td").eq(0).text()) + 1 ;
			
				$("#selectedDveTab").append( "<tr id='"+data.message+"'><td>"+newRowSeq+"<td>"+$("#add_deviceName").val()+"</td>"+
						"<td>"+$("#add_deviceModel").val()+"</td>"+
						"<td>"+$("#add_deviceNum").val()+"</td>"+
						"<td>"+$("#add_deviceType").find("option:selected").text()+"</td>"+
						/* 将设备编号隐藏起来，在保存申请信息时用于向NT_APPLY_DEVICE表中添加 */
						"<td><input name='dveId' type='hidden' value='"+data.message+"' />"+
						"<input name='devClassUp' type='hidden' value='"+
						$("#add_deviceClassUp").val()+ "' />  "+
						"<input name='devTypeID' type='hidden' value='"+
						$("#add_deviceType").val()+ "' />  "+
						"<input name='devSeqId'type='hidden'value='" + $("#devSeqId").val()+" '/> "+

						"<a href='javascript:void(0)' title='修改设备信息' onclick='updDveDialog(this)'><i class='fa fa-pencil-square-o fa-lg'  ></i></a>&nbsp;&nbsp;"+
						"<a href='javascript:void(0)' title='删除设备信息' onclick='delExistDve(this)'><i class='fa fa-trash fa-lg'  ></i></a>"+
						"</td></tr>");
				/* 更新界面中设备数量 */
				$("#dveNum").val(parseInt($("#dveNum").val())+1);
				/* 关闭模态框 */
				$.dialog.get('idAdd').close();
			}else{
				alert(data.message);
			}
		}
	});
  }
}
//删除设备信息
function delExistDve(obj){
	if(confirm("确定删除该设备信息吗？")){
		var id=$(obj).parent().children('input').val();
		$.ajax({
			url : '${pageContext.request.contextPath}/test_delDeviceInfo.do',
			data : {'id': id},
			type : 'POST',
			dataType : 'json',
			success : function(data) {

					// 更新表格中每行的序号
				$(obj).parent().parent().nextAll().each(function(){
					var oldRowSeq = parseInt($(this).find("td").eq(0).text() );
					console.log(oldRowSeq) ;
					$(this).find("td").eq(0).text(oldRowSeq- 1); 
				});

				$(obj).parent().parent().remove();
				$("#dveNum").val(parseInt($("#dveNum").val())-1);
			}
		});	
	}
}

//修改设备信息
function updExistDve(obj){
	var id=$(obj).parent().children('input').val();
	$.ajax({
		url : '${pageContext.request.contextPath}/test_updDeviceInfo.do',
		data : {'id': id},
		type : 'POST',
		dataType : 'json',
		success : function(data) {
			$(obj).parent().parent().remove();
			//$("#dveNum").val(parseInt($("#dveNum").val())-1);
		}
	});	
}


//点击保存或提交按钮时，添加申请信息  type:sava保存；sub提交
function addApply(type){
	//alert($("#devApplyUnitName").val());
	if(type == "sub"){
		if (!confirm("确定要提交设备检测申请吗？\n提交后信息将不可修改！")){
			return;
		}
	}
	/* 设备检测申请的合法性验证 */
	if($("#userNameTab").val() == ''){
		alert("请输入申请人！");
		return false;
	}
	if($("#telTab").val() == ''){
		alert("请输入联系方式！");
		return false;
	}
	if($("#dveNum").val()!='0'){
		var dveIdStr = "";
		// 获取修改申请时，新增的设备编号；
		$("input[name='dveId']").each(function(index,item){
			dveIdStr=dveIdStr+$(this).val()+",";
		});
		//alert(dveIdStr);
		$("#selectedDve").val(dveIdStr);
	}else{
		alert("请添加至少一个设备");
		return false;
	}
	
	//判断是否是省局用户填写申请，若是,修改申请单位编号
	if($("#devApplyUnitName").val()!= null){
		if(<%=unitId%> == "1"){
			// 省局
			$("#unitId").val($("#devApplyUnitName").val());
			//alert($(".select2 option:selected").html());
			// 申请人ID 传入固定值,'1':代理填写
			$("#userId").val("1");
		}
	}else{
		alert("请选择申请单位！");
		return false;
	}
	// 对表单进行赋值，准备提交
	$("#operate").val(type);
	$("#deviceNum").val($("#dveNum").val());
	$("#userName").val($("#userNameTab").val());
	$("#tel").val($("#telTab").val());
	$("#applyDate").val($("#applyDatePicker").val());
	
	//alert($("#applyDate").val());

	var $mark = $("body>div").last();
	var _zIndex = $mark.css('zIndex');
	$mark.css({
		zIndex:9999
	});
	
	//无论保存或修改申请时都无需验证是否上传附件
	// var attach2 = $("#attach2").val();
	// if (attach2 == "") {
	// 	alert("请添加附件");
	// 	return false;
	// }
	
	$.ajax({
		url : '${pageContext.request.contextPath}/dveTestApply_addApply.do',
		data : $("#applyFm").serialize(),
		type : 'POST',
		dataType : 'json',
		success : function(data) {
			$mark.css('zIndex',_zIndex);
			if(data.success){
				var applyId = data.message;
				var attach2 = $("#attach2").val();
				if (attach2 != "")
					fileUpload2(applyId);
				alert("保存成功！");
				window.location.href="apply_list.jsp";
			}else{
				alert(data.message);
			}
		}
	});
}

function loadUpdic(item){
	$.ajax({
		url : '${pageContext.request.contextPath}/finddic_getElementByUpId.do?id=002',
		type : 'POST',
		dataType : 'json',
		async: false,
		success : function(data) {
			var data = eval(data);
			var rows = data.rows;
			//var node = "<option value=''>-----</option>";
			var node = "";
			for(var i=0;i<rows.length;i++){
					node = node+"<option value='"+rows[i].dictionaryOptionId+"'>"+rows[i].dictionaryOptionName+"</option>";
				}
				$("#add_deviceClassUp").empty();
				$("#add_deviceClass").empty();
				$("#add_deviceClassUp").append(node);

				if(item == "")
					$("#add_deviceClassUp").get(0).selectedIndex = 0;
				else
					$("#add_deviceClassUp").val(item);
		}
	});
}

// 将浏览器本地数据加载设备名称select中
function loadLocalData2SelectDevName(item){
	var storage=window.localStorage;

    // 获取本地值
    var devNameValues = storage.getItem("devName");
    if(devNameValues == null)
    	devNameValues = " ,"
    // var devModelValues = storage.getItem("devModel");
    // var devNumValues = storage.getItem("devNum");
	
    var items = devNameValues.split(",");
    // alert(devNameValues);
    var node = "";
    // 清除select原有的内容
    $("#add_deviceName").editableSelect('clear');
	for(var i=0; i<items.length; i++){
		// alert(items[i]);
		// node = node+"<option value='"+items[i]+"'>"+items[i]+"</option>";
		$("#add_deviceName").editableSelect('add',items[i]);
	}

	
	// $("#drpPublisher2").empty();	
	// $('#drpPublisher2').editableSelect('clear');

	// $("#drpPublisher2").append(node);
	// $("#drpPublisher2").editableSelect('destroy');
	$('#add_deviceName').editableSelect();
	// 设置默认选项
	$("#add_deviceName").val(item);
}

function loadLocalData2SelectDevModel(item){
	var storage=window.localStorage;

    // 获取本地值
    // var devNameValues = storage.getItem("devName");
    
    var devModelValues = storage.getItem("devModel");
    if(devModelValues == null)
    	devModelValues = " ,";
    // var devNumValues = storage.getItem("devNum");
	
    var items = devModelValues.split(",");
    
    var node = "";
    $('#add_deviceModel').editableSelect('clear');
	for(var i=0; i< items.length; i++){
		$('#add_deviceModel').editableSelect('add',items[i]);
	}


	$('#add_deviceModel').editableSelect();

	$("#add_deviceModel").val(item);
}

function loadLocalData2SelectDevNum(item){
	var storage=window.localStorage;

    // 获取本地值
    // var devNameValues = storage.getItem("devName");
    
    // var devModelValues = storage.getItem("devModel");
    var devNumValues = storage.getItem("devNum");
    if(devNumValues == null)
    	devNumValues = " ,";
	
    var items = devNumValues.split(",");
    
    var node = "";
    $('#add_deviceNum').editableSelect('clear');
	for(var i=0; i< items.length; i++){
		$('#add_deviceNum').editableSelect('add',items[i]);
	}

	$('#add_deviceNum').editableSelect();

	$("#add_deviceNum").val(item);
}


function loaddic(obj){
	var id = obj.value;
	if(id == ''){
		return;
	}
	$.ajax({
		url : '${pageContext.request.contextPath}/finddic_getElementById.do',
		data : {'id' : id},
		type : 'POST',
		dataType : 'json',
		success : function(data) {
			var data = eval(data);
			var rows = data.rows;
			var node = "";
			for(var i=0;i<rows.length;i++){
				node = node+"<option value='"+rows[i].dictionaryOptionId+"'>"+rows[i].dictionaryOptionName+"</option>";
			}
			$("#add_deviceClass").empty();
			$("#add_deviceClass").append(node);
		}
	});
}

function delDevNameHisInfo() {
	if(confirm("确定清空设备名称的历史记录吗？")){
		var storage = window.localStorage;
		storage.removeItem("devName");
		// loadLocalData2SelectDevName("");
	}
}

function delDevModelHisInfo( ){
	if(confirm("确定清空设备型号的历史记录吗？")){
		var storage = window.localStorage;
		storage.removeItem("devModel");
		// loadLocalData2SelectDevName("");
	}
}

function delDevNumHisInfo( ){
	if(confirm("确定清空设备序列号的历史记录吗？")){
		var storage = window.localStorage;
		storage.removeItem("devNum");
		// loadLocalData2SelectDevName("");
	}
}

//JS校验form表单信息  
function checkData(){  
   var fileDir = $("#upfile").val();  
   var suffix = fileDir.substr(fileDir.lastIndexOf("."));  
   if("" == fileDir){  
       alert("选择需要导入的Excel文件！");  
       return false;  
   }  
   if(".xls" != suffix && ".xlsx" != suffix ){  
       alert("选择Excel格式的文件导入！");  
       return false;  
   }  
   return true;  
}  


</script>
</head>

<body class="hold-transition skin-blue sidebar-mini">
	<div id="Nav">
		<span>设备检测>>新增申请</span> <a class="btn-nav"
			href="javascript:history.go(-1)">返回</a>
	</div>
	<div class="wrapper">

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1></h1>
				<span class="breadcrumb"> <a class="btn btn-app"
					href="javascript:void(0)" onclick="addApply('save')"> <i
						class="fa fa-save"></i> 保存
				</a> <a class="btn btn-app" href="javascript:void(0)"
					onclick="addApply('sub')"> <i class="fa fa-check-square-o"></i>
						提交
				</a>
				</span>

			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-offset-1 col-md-9">

						<div class="box box-solid box-primary">
							<div class="box-header with-border">
								<h3 class="box-title">设备检测申请</h3>
							</div>
							<!-- /.box-header -->

							<div class="box-body pad">
								<div class="row">
									<div class="col-sm-6">
										<form class="form-horizontal">
											<div class="form-group">
												<label for="input1" class="col-sm-4 control-label">申请单位</label>

												<div class="col-sm-8">

													<c:choose>
														<c:when test="${unitId =='1'}">
															<select id="devApplyUnitName"
																name="devApplyInfo.devApplyUnitId"
																class="form-control select2"
																style="width: 100%; margin-top: 10px;">
															</select>
														</c:when>
														<c:otherwise>
															<input type="text" id="devApplyUnitName"
																name="devApplyInfo.devApplyUnitId" class="form-control"
																readonly="readonly" value="<%=unit.getUnitName()%>">
														</c:otherwise>
													</c:choose>

												</div>
											</div>
										</form>
									</div>
									<div class="col-sm-6">
										<form class="form-horizontal">
											<div class="form-group">
												<label for="input1" class="col-sm-4 control-label">设备数量</label>
												<div class="col-sm-8">
													<input id="dveNum" type="text" class="form-control"
														readonly="readonly" value="0">
												</div>
											</div>
											<button type="button" class="btn btn-primary  btn-sm pull-right"
												onclick="addDveDialog()">添加检测设备</button>
											 	
											<button type="button" class="btn btn-primary btn-sm pull-right"
												onclick="addDveFromFileDialog()">批量导入检测设备</button>
											
										</form>
									</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-md-12">
										<table class="table table-bordered table-striped" id="selectedDveTab">
											<tr class="info">
												<th>序号</th>
												<th>设备名称</th>
												<th>设备型号</th>
												<th>设备序列号</th>
												<th>设备类别</th>
												<th>操作</th>
											</tr>
										</table>
									</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-6">
										<form class="form-horizontal">
											<div class="form-group">
												<label for="input1" class="col-sm-4 control-label">申请人</label>
												<div class="col-sm-8">
													<input type="text" id="userNameTab" class="form-control"
														value="" isempty="no" tip="申请人不能为空" />
												</div>
											</div>
											<!-- value="<%=user.getName()%>" <%=user.getTelephone()%>-->
										</form>
									</div>
									<div class="col-sm-6">
										<form class="form-horizontal">
											<div class="form-group">
												<label for="input1" class="col-sm-4 control-label">联系方式</label>
												<div class="col-sm-8">
													<input type="text" id="telTab" class="form-control"
														value="" isempty="no"
														tip="申请方式不能为空" />
												</div>
											</div>
										</form>
									</div>
								</div>


								<div class="row">
									<div class="col-sm-6">
										<form class="form-horizontal">
											<div class="form-group">
												<label for="input1" class="col-sm-4 control-label">申请日期</label>
												<div class="col-sm-8">
													<input class="form-control" id="applyDatePicker" 
													value="<%= DateHandler.dateToString(new Date()) %>" name="applyDatePicker" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" />
												</div>
											</div>
											<!-- value="<%=user.getName()%>" <%=user.getTelephone()%>-->
										</form>
									</div>
									
								</div>


								<hr>
								<form id="applyFm">
									<label class="col-sm-4 control-label">申请意见</label>
									<textarea id="applyOpinion" name="deviceTestApply.applyOpinion"
										class="textarea333" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;">请省局安检中心对我单位所申请设备进行安检。
                					</textarea>
									<input  type="hidden" id="unitId" 	name="deviceTestApply.unitId" value="<%=unitId%>" />
									<input type="hidden"  id="userId"  	name="deviceTestApply.userId" value="<%=user.getUserId()%>" />
									<input type="hidden"  id="deviceNum" name="deviceTestApply.deviceNum" />
									<!-- 申请人 -->
									<input type="hidden" id="userName" 	name="deviceTestApply.remark1" />
									<!-- 联系方式 -->
									<input type="hidden" id="tel" name="deviceTestApply.remark2" />
									<!-- 检测的设备编号 -->
									<input id="selectedDve" name="selectedDve" type="hidden" /> 
									<!-- 对申请的操作：save submit -->
									<input id="operate" name="operate" type="hidden" />
									<!-- 申请日期 -->
									<input id="applyDate" name="deviceTestApply.applyDate" type="hidden" />

								</form>

								<div class="box box-info">
									<div class="box-header with-border">
										<h3 class="box-title">申请书电子版</h3>
									</div>
									<div class="box-body">
										<form id="attach_form2" enctype="multipart/form-data">
											<input id="attach_deviceApplyId"
												name="deviceTestApply.applyId" type="hidden" /> <input
												id="attach2" name="applyAttach" class="file" type="file"
												multiple data-min-file-count="1">
										</form>
									</div>
								</div>
							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->

					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

	</div>
	<!-- 
<script src="<%=request.getContextPath()%>/newStyle/plugins/jQuery/jQuery-2.1.4.min.js"></script>
-->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/newStyle/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/newStyle/plugins/select2/select2.full.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/newStyle/dist/js/app.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/newStyle/dist/js/demo.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/newStyle/plugins/bootstrap-fileinput/js/fileinput.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/newStyle/plugins/bootstrap-fileinput/js/fileinput_locale_zh.js"></script>
    <script src="<%=request.getContextPath()%>/controls/jquery-editable-select-master/dist/jquery-editable-select.min.js"></script>

	<script>

$(document).ready(function(){
	loadUnitName();
});

	// 加载部门名称
	function loadUnitName(){
		$.ajax({
			url : '<%=request.getContextPath()%>/loadUnitName.do',
			type : 'POST',
			dataType : 'json',
			success : function(data){
				var data = eval(data);
				var optionStr = "";
				for(var i=0;i<data.length;i++){
					if(i == 0)
						optionStr += "<option value="+data[i].unitId+" selected>"+data[i].unitName+"</option>";
					else
						optionStr += "<option value="+data[i].unitId+" >"+data[i].unitName+"</option>";
				}
				$("#devApplyUnitName").append(optionStr);
				// 可以自定义tag
				var select  = $(".select2").select2();
			},
			error : function(data){
				alert("error");
			}
		});
	}
	
	
	$("#attach2").fileinput({
		  language : 'zh',
		  showUpload: false, //是否显示上传按钮
	    allowedFileExtensions : ['doc', 'docx','xls','xlsx']
	});

	
	function fileUpload2(id){
		//设置屏蔽室申请ID
		$("#attach_deviceApplyId").val(id);
		var formData = new FormData($('#attach_form2')[0]);
		$.ajax({
		       url: '<%=request.getContextPath()%>/dveTestApply_saveApplyAttach.do',
						data : formData,
						async : false,
						contentType : false,
						processData : false,
						cache : false,
						type : 'post',
						success : function(data) {
							alert("操作成功！");
							window.location.href = 'apply_list.jsp';
						},
						error : function() {
							alert("附件上传失败，请重试！");
						}
					});
		}

		//Initialize Select2 Elements
		//$(".select2").select2();
	</script>
	
	
	<div id="importDevFromFileTab" style="display:none">
		<form id="importDevFromFileForm" action="post"  enctype="multipart/form-data">
			<table>  
	         <tr>  
	            <td>上传文件: </td>  
	            <td> <input id="upfile" type="file" name="upfile"></td>  
	         </tr>  
	        <tr>  
	            <td><input type="submit" value="提交" onclick="return checkData()"></td>  
	         </tr>  
	        </table> 
		</form>
	</div>
	

	<!-- ./wrapper -->
	<div id="addTab" style="display: none">
		<form id="addDeviceInfoForm">
			<table class="dataTab" id="infoTab">
				<tr>
					<td class="title_td">设备使用单位</td>
					<td colspan="3"><input id="unitName"
						name="deviceBaseInfo.unitName"
						value="$('.select2 option:selected').html()" readonly="readonly" />
						<input id="devUnitId" name="deviceBaseInfo.unitId"
						value="$('#devApplyUnitName').val()" type="hidden" /></td>

				</tr>
				<tr>
					<td class="title_td">设备类型</td>
					<td colspan="3">
						<select id="add_deviceClassUp" name="deviceBaseInfo.deviceClass"></select>
					</td>
				</tr>
				<!-- <tr>
					<td class="title_td">设备名称</td>
					<td colspan="3">
						<input  id="add_deviceName" name="deviceBaseInfo.deviceName" isempty="no" tip="设备名称不能为空" /> 
						<font color="red">*</font></td>
				</tr> -->
				<tr>
					<td class="title_td">
					<a href='javascript:void(0)' title='清空设备名称历史记录' onclick='delDevNameHisInfo()'>
						<i class='fa fa-trash '  ></i>
					</a>设备名称</td>
					<td colspan="3">
						<select  class="form-control" name = "deviceBaseInfo.deviceName"  id = "add_deviceName" >
			            </select>
						<!-- <font color="red">*</font></td> -->
				</tr>
				<tr>
					<td class="title_td">
					<a href='javascript:void(0)' title='清空设备型号历史记录' onclick='delDevModelHisInfo()'>
						<i class='fa fa-trash '  ></i>
					</a>设备型号</td>
					<td colspan="3">
					<!-- <input id="add_deviceModel"	name="deviceBaseInfo.deviceModel" isempty="no" tip="设备型号不能为空" />
					<font color="red">*</font></td> -->
					<select  class="form-control" name = "deviceBaseInfo.deviceModel"  id = "add_deviceModel" >
			        </select>
				</tr>

				<tr>
					<td class="title_td">
					<a href='javascript:void(0)' title='清空设备序列号历史记录' onclick='delDevNumHisInfo()'>
						<i class='fa fa-trash '  ></i>
					</a>设备序列号</td>
					<td colspan="3">
						<!-- <input id="add_deviceNum" name="deviceBaseInfo.deviceNum" isempty="no" tip="设备序列号不能为空" /> 
						<font color="red">*</font> -->
					<select  class="form-control" name = "deviceBaseInfo.deviceNum"  id = "add_deviceNum" >
			        </select>
					</td>
				</tr>
				<tr>
					<td class="title_td">设备类别</td>
					<td colspan="3">
					<select id="add_deviceType"
						name="deviceBaseInfo.deviceType">
							<option value="1">新购</option>
							<option value="2">维修后</option>
					</select> 
					<input type="hidden" id="devId" name="deviceBaseInfo.deviceId" value="" /> 
					<input type="hidden" id="operation" value="add" /></td>
					<input type="hidden" id="devSeqId" name="deviceBaseInfo.remark" value="" />
				</tr>
				<tr>
					<td colspan="4" align="center" style="padding-top: 20px;"><span
						id="btn_add_device" class="btn" onclick="addDve()">确定</span></td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>