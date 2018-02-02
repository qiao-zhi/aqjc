<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.tyust.bean.user.TBaseUserInfo" %>
<%@ page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.tyust.dao.unit.IunitDao,com.tyust.bean.unit.TBaseUnitInfo"%>
<%@ page import="java.util.*,com.tyust.common.DateHandler" %>

<%
	TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
	ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
	String unitId = user.getUnitId();
	IunitDao unitDao = (IunitDao)context.getBean("Unit");
	TBaseUnitInfo unit = unitDao.findUnit(unitId);
	String applyId = request.getParameter("applyId");
	request.setAttribute("agentUnitId",unitId);
%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<jsp:include page="../common/include-commonNew2.jsp"></jsp:include>
	 <link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/plugins/select2/select2.css">
	 <link rel="stylesheet" type="text/css" 	href="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/css/fileinput.min.css" />
	 <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/controls/jquery-editable-select-master/dist/jquery-editable-select.min.css" />

	<style>
		.dataTab input{width: 220px;height: 28px;font-size: 12px;	color: #000;}
		.dataTab select{width: 220px;height:28px;font-size: 12px;	color: #000;}
	</style>
	
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/select2/select2.full.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/dist/js/app.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/dist/js/demo.js"></script>	
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/js/fileinput.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/js/fileinput_locale_zh.js"></script>
<script src="<%=request.getContextPath()%>/controls/jquery-editable-select-master/dist/jquery-editable-select.min.js"></script>
 
<script type="text/javascript" >
var applyUnitId="";
//isAttach2变量表示是否进行了附件的修改，0：未修改；1：修改
var isAttach2 = 0;

/* 为新增的设备设置顺序号 */
var devMaxSeqId = 0;

$(function(){
	// 显示设备检测申请的详细信息
	showApplyDetail();
	// 显示申请的设备信息
	showApplyDve();
	// 显示申请的附件
	showDevAttach2();
});


	
	function delSeletedDve(obj){
		var id=$(obj).parent().children('input').val();
		$.ajax({
			url : '${pageContext.request.contextPath}/test_delDeviceInfo.do',
			data : {'id': id},
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				$(obj).parent().parent().remove();
				$("#dveNum").val(parseInt($("#dveNum").val())-1);
			}
		});	
	}
	
	/*
		函数作用：仅从界面中删除用户选择的设备信息；
		step1：向Form隐藏域ID:delExsitDev中添加一个待删除的设备编号
		step2：从界面中删除该设备；
		step3：更新form中的设备数量；
		
	 */
	function delExsitDve(obj){
		if(confirm("确定删除该设备信息吗？")){
			var id = $(obj).parent().children("input").val();
			// console.log("id:"+id);
			// 将要删除的设备的编号（即NT_APPLY_DEVICE中的ID主键值）保存到delExsitDve中
			$("#delExsitDve").val($("#delExsitDve").val()+id+",");

			// 获取要删除的设备编号（即T_DEVICE_BASE_INFO中的DEVICE_ID的值），并保存到delDeviceId中；
			// console.log($(obj).parent().parent().children("td").eq(1).children("input").val());
			var deviceId = $(obj).parent().parent().children("td").eq(1).children("input").val();

			$("#delDeviceId").val($("#delDeviceId").val()+deviceId+",");
			
			// 更新表格中每行的序号
			$(obj).parent().parent().nextAll().each(function(){
				var oldRowSeq = parseInt($(this).find("td").eq(0).text() );
				console.log(oldRowSeq) ;
				$(this).find("td").eq(0).text(oldRowSeq- 1); 
			});

			// 删除table中该行
			$(obj).parent().parent().remove();

			// 更新界面中设备数量
			$("#dveNum").val(parseInt($("#dveNum").val())-1);


		}
	}
	
	// 显示添加设备模态对话框
	function addDveDialog(){
		$("#infoTab input").each(function(i){
    		$(this).val('');
    	 });
		
		//若是省局用户，将添加设备对话框中的单位信息设置为页面下拉列表框中选择的值；否则，当前用户所在单位作为默认值
		if(<%=unitId%> == "1"){
			$("#unitName").val($(".select2 option:selected").html());
			$("#devUnitId").val($("#devApplyUnitName").val());
			//alert($("#devApplyUnitName").val());
		}else{
			$("#unitName").val('<%=unit.getUnitName() %>');
			$("#unitId").val('<%=unit.getUpUnitId() %>');
		}
		
		$.dialog({
			content:$("#addTab")[0],
			title:'添加设备',
			id:'idAdd',
			lock :true,
			background :'#245EDC',
			opacity:0.5
		});
		// 初始化设备类型字典
		loadUpdic("");
		// 初始化3个select控件
		loadLocalData2SelectDevName("");
		loadLocalData2SelectDevModel("");
		loadLocalData2SelectDevNum("");
		// 添加设备时初始化最新的设备顺序号
		$("#devSeqId").val(++devMaxSeqId);
		$("#operation").val("add");
	}
	
	// 修改设备信息的模态对话框
	function updDveDialog(obj){
	$("#infoTab input").each(function(i){
		$(this).val('');
	 });

	 // 获取当前行tr的所有td对象
	 var $inputs	= $(obj).parent().children('input');
	 var devId 		= $inputs.eq(1).val();
	 var devClassUp = $inputs.eq(2).val();
	 var devTypeID 	= $inputs.eq(3).val();
	 var devSeqId 	= $inputs.eq(4).val();

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
            
            // console.log(storage["devName"]);
            // console.log(storage["devModel"]);
            // console.log(storage["devNum"]);
        }
};

//验证录入设备信息的合法性 
function validateDevInfo(){
	var devName 	= 	$("#add_deviceName").val();
    var devModel 	= 	$("#add_deviceModel").val();
    var devNum 		= 	$("#add_deviceNum").val();

    var validated = true;

    if(devName == ""){
    	validated = false;
    	alert("请输入设备名称！");
    	// return;
    }
    if(devModel == ""){
    	validated = false;
    	alert("请输入设备型号！");
    	return;
    }
    if(devModel == ""){
    	validated = false;
    	alert("请输入设备序列号！");
    	// return;
    }

    return validated;


};


// 向NT_DEVICE_BASE_INFO数据库中添加或修改设备信息
	function addDve(){

		if(!validateDevInfo())
			return;
		// 将模态框中的设备信息保存到本地浏览器中
		saveDevInfo2Local();

		var operation = $("#operation").val();
		var devId = $("#devId").val();

		//  alert("operation:"+operation);

		if (operation == 'update') {
			 var $tds = $("#"+devId).children("td");
			 $.ajax({
				url : '${pageContext.request.contextPath}/test_saveDeviceInfo.do',
				data : $("#addDeviceInfoForm").serialize(),
				type : 'POST',
				dataType : 'json',
				async:false,
				success : function(data) {
					if(data.success){
							// "<input name='devId' 		type='hidden'	value='"+data.message 					+"' />"+
							// "<input name='devClassUp' 	type='hidden' 	value='"+$("#add_deviceClassUp").val()	+"' />"+
							// "<input name='devTypeID' 	type='hidden' 	value='"+$("#add_deviceType").val()		+"' />"+
							// "<input name='devSeqId' 	type='hidden'	value='"+$("#devSeqId").val()			+"' />"+
						var tdIndex = 1;
						$tds.eq(tdIndex++).text($("#add_deviceName").val());
						$tds.eq(tdIndex++).text($("#add_deviceModel").val());
						$tds.eq(tdIndex++).text($("#add_deviceNum").val());
						$tds.eq(tdIndex++).text($("#add_deviceType").find("option:selected").text());
						// 把可能变化的值设置到隐藏的input中：deviceClassUp devTypeID
						$tds.eq(tdIndex).children().eq(2).val($("#add_deviceClassUp").val());
						$tds.eq(tdIndex).children().eq(3).val($("#add_deviceType").val());

						// $tds.eq(4).html("<input name='dveId' 		type='hidden' 	value='"+devId+"' />"+
						// 				"<input name='devId' 		type='hidden' 	value='"+devId+"' />"+
						// 				"<input name='devClassUp' 	type='hidden' 	value='"+
						// 											$("#add_deviceClassUp").val()+ "' />  "+
						// 				"<input name='devTypeID' 	type='hidden' 	value='"+
						// 											$("#add_deviceType").val()+ "' />  "+
						// 				"<input name='devSeqId'		type='hidden'	value='" + $("#devSeqId").val()+" '/> "+
						// 				"<a href='javascript:void(0)' title='修改设备信息' onclick='updDveDialog(this)'><i class='fa fa-pencil-square-o fa-lg'  ></i></a>&nbsp;&nbsp;"+
						// 				"<a href='javascript:void(0)' title='删除设备信息' onclick='delExistDve(this)'><i class='fa fa-trash fa-lg'  ></i></a>");
						$.dialog.get('idAdd').close();
					}else{
						alert(data.message);
					}
				}
			});
		}else{
			/*添加新的设备操作  */
		$.ajax({
			url : '${pageContext.request.contextPath}/test_saveDeviceInfo.do',
			data : $("#addDeviceInfoForm").serialize(),
			type : 'POST',
			dataType : 'json',
			async:false,
			success : function(data) {
				if(data.success){
					// 为新增设备显示分配新的序号：在现有基础上增1；
					var newRowSeq = parseInt($("#selectedDveTab").find("tr").last().find("td").eq(0).text()) + 1 ;
					console.log("newRowSeq:" + newRowSeq);

					$("#selectedDveTab").append("<tr id='"+data.message+"'><td>"+newRowSeq+"<td>"+$("#add_deviceName").val()+"</td>"+
							"<td>"+$("#add_deviceModel").val()+"</td>"+
							"<td>"+$("#add_deviceNum").val()+"</td>"+
							"<td>"+$("#add_deviceType").find("option:selected").text()+"</td>"+
							"<td><input name='newChoose' type='hidden' 	value='"+data.message+"' />"+
							
							"<input name='devId' 		type='hidden'	value='"+data.message 					+"' />"+
							"<input name='devClassUp' 	type='hidden' 	value='"+$("#add_deviceClassUp").val()	+"' />"+
							"<input name='devTypeID' 	type='hidden' 	value='"+$("#add_deviceType").val()		+"' />"+
							"<input name='devSeqId' 	type='hidden'	value='"+$("#devSeqId").val()			+"' />"+

							"<a href='javascript:void(0)' title='修改设备信息' onclick='updDveDialog(this)'><i class='fa fa-pencil-square-o fa-lg'  ></i></a>&nbsp;&nbsp;"+
							"<a href='javascript:void(0)' title='删除设备信息' onclick='delExistDve(this)'><i class='fa fa-trash fa-lg'  ></i></a>"+
							"</td></tr>");
					$("#dveNum").val(parseInt($("#dveNum").val())+1);
					$.dialog.get('idAdd').close();
				}else{
					alert(data.message);
				}
			}
		});
	  }
	}


	/*
		修改设备检测申请报告;
		@type:表示提交或保存操作；
	 */
	function updApply(type){
		if(type == "sub"){
			if (!confirm("确定提交设备检测申请吗？\n提交后申请将不可修改！")){
				return;
			}
		}
		
		if(type=="sub"){
			if($("#userNameTab").val() == ''){
				alert("请输入申请人！");
				return false;
			}
			if($("#telTab").val() == ''){
				alert("请输入联系方式！");
				return false;
			}	
		}
		
		
		if($("#dveNum").val()=='0'){
			alert("请添加至少一个设备");
			return false;
		}
		/* 获取所有新增加的设备 */
		var newChooseDve = "";
		$("input[name='newChoose']").each(function(index,item){
			newChooseDve=newChooseDve+$(this).val()+",";
		});
		
		//判断是否是省局用户填写申请，若是修改申请单位编号
		if($("#devApplyUnitName").val()!= null){
			if(<%=unit.getUnitId()%> == "1"){
				// 省局
				$("#unitId").val($("#devApplyUnitName").val());
			}
		}else{
			alert("请选择申请单位！");
			return false;
		}
		// 为表单赋值，准备提交
		$("#newChooseDve").val(newChooseDve);
		$("#operate").val(type);
		$("#deviceNum").val($("#dveNum").val());
		$("#userName").val($("#userNameTab").val());
		$("#tel").val($("#telTab").val());
		$("#applyDate").val($("#applyDatePicker").val());

		var $mark = $("body>div").last();
		var _zIndex = $mark.css('zIndex');
		$mark.css({
			zIndex:9999
		});
		
		// 无论提交或保存无需验证附件
		// if(isAttach2 == 1){
		// 	if($("#attach2").val() == ""){
		// 		alert("请上传附件");
		// 		return;
		// 	}
		// }
		
		$.ajax({
			url : '${pageContext.request.contextPath}/dveTestApply_updApply.do',
			data : $("#applyFm").serialize(),
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				$mark.css('zIndex',_zIndex);
				if(data.success){
					alert(data.message);
					// 没有对附件修改
					if(isAttach2 == 0){
						window.location.href="apply_list.jsp";
					} else {
						// 修改了附件，且附件不为空，则重新上传附件
						if ($("#attach2").val() != ""){
							var applyId = '<%= applyId%>';
							fileUpload2(applyId);
						}
					}
					// 2017-08-04 bug修改
					// 点击保存按钮后，若保存成功，应该修改界面中每个设备的状态。
					// 否则，若此时点击提交或保存按钮会出现设备重复提交的问题。

					initUpdateOperation();
				}else{
					alert(data.message);
				}
			}
		});
	}
	/*
	 清除界面中原来做过的关于已添加和已删除的设备标记；
	 这样当重复点击保存或提交按钮时操作不受影响
	 */
	function initUpdateOperation () {
		// 将所有表示新增设备的input清除掉；
		// 将表示设备删除的内容置空
		$("input[name='newChoose']").remove();
		$("#delExsitDve").val(" ");
		$("#delDeviceId").val(" ");
	}
	
	function showApplyDetail(){
		$.ajax({
			url : '${pageContext.request.contextPath}/dveTestApply_selApplyDetail.do?applyId=<%= applyId%>',
			data : '',
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				var json = eval(data);
				
				applyUnitId = json.ApplyUnitId;
				loadUnitName();
				$("#dveNum").val(json.DeviceNum);
				$("#userNameTab").val(json.User);
				$("#telTab").val(json.Tel);
				$("#applyOpinion").val(json.ApplyOpinion);
				$("#applyDatePicker").val(json.applyDate);
			}
		});
	}
	/*
		显示申请对应的设备信息
	 */
	function showApplyDve(){
		$.ajax({
			url : '${pageContext.request.contextPath}/test_showApplyDve.do?applyId=<%= applyId %>',
			data : '',
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var json = eval(response.data);
				if(json.length>0){
					// 行序号
					var trSeq = 1;

					for(var v=0;v<json.length;v++){
						var type="";

						if(json[v].deviceType=="1"){
							type="新购";
						}else{
							type="维修后";
						}


						// dveId用于删除NT_DEVICE_BASE_INFO表中数据；json[v].id用于删除NT_APPLY_DEVICE表中数据
						$("#selectedDveTab").append("<tr id='"+json[v].deviceId+"'><td>"+(trSeq++)+"</td><td><input name='dveId' type='hidden' value='"+json[v].deviceId+
			  					"'/>"+json[v].deviceName+"</td>"+
								"<td>"+json[v].deviceModel+"</td>"+
								"<td>"+json[v].deviceNum+"</td>"+
								"<td>"+type+"</td>"+
								"<td><input type='hidden' value='"+json[v].id+"'/>"+
								
								"<input name='devId' 		type='hidden' 	value='"+json[v].deviceId 		+"' />"+
								"<input name='devClassUp' 	type='hidden' 	value='"+json[v].deviceClass 	+"' />"+
								"<input name='devTypeID' 	type='hidden' 	value='"+json[v].deviceType 	+"' />"+
								"<input name='devSeqId'		type='hidden'	value='"+json[v].deviceSeqId	+"' />"+
								
								"<a href='javascript:void(0)' title='修改设备信息' onclick='updDveDialog(this)'><i class='fa fa-pencil-square-o fa-lg'  ></i></a>&nbsp;&nbsp;"+
								"<a href='javascript:void(0)' title='删除设备信息' onclick='delExsitDve(this)'><i class='fa fa-trash fa-lg' ></i></td></tr>");
						// 获得已添加设备的最大顺序号
						devMaxSeqId = json[v].deviceSeqId;

					}
				}
			}
		});
	}
	
	function loadUpdic(item){
		$.ajax({
			url : '${pageContext.request.contextPath}/finddic_getElementByUpId.do?id=002',
			type : 'POST',
			dataType : 'json',
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
					if(applyUnitId == data[i].unitId)
						optionStr += "<option value="+data[i].unitId+"  selected >"+data[i].unitName+"</option>";
					else
						optionStr += "<option value="+data[i].unitId+" >"+data[i].unitName+"</option>";
						
				}
				$("#devApplyUnitName").append(optionStr);
				var select  = $(".select2").select2();
			},
			error : function(data){
				alert("error");
			}
		});
	}
	
	
	// 显示附件信息
	function showDevAttach2(){
		$.ajax({
			url : '${pageContext.request.contextPath}/dveTestApply_selApplyAttach.do',
			data : {'devApplyId' : '<%= applyId%>'},
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var info = eval(response);
				var v = info[0];
				if (v == null) {
					$("#file2").empty();
					loadFileinput2();
				} else {
					var url = info[0].fileUrl;
					var fileName = info[0].fileName;
					var devAttachId = info[0].devAttachId;
					var URL = '${pageContext.request.contextPath}/dveTestApply_downAttach.do?filename='+url;
					$("#fileName2").append("<a href='"+URL+"'>"+fileName+"</a>");
					$("#delAttach2").click(function (){
						delAttachConf(devAttachId);
					});
				}
			}
		});
	}
	
	
	
	function fileUpload2(id){
		//设置屏蔽室申请ID
		$("#attach_deviceApplyId").val(id);
		var formData = new FormData($('#attach_form2')[0]);
		$.ajax({
		       url: '<%=request.getContextPath()%>/dveTestApply_saveApplyAttach.do',
		       data: formData,
		       async: false,
		       contentType: false,
		       processData: false,
		       cache: false,
		       type: 'post',
		       success: function(data) {
		    	   alert("操作成功！");
		    	   window.location.href="apply_list.jsp";
		       },
		       error : function(){
		    	   alert("附件上传失败，请重试！");
		       }
		   });
	}
	
	
	// 确认删除附件 
	function delAttachConf(devAttachId){
		var con = confirm("是否确认删除附件？");
		if (con == true) {
			delAttach(devAttachId);
		}
	}
	
	// 根据附件编号删除附件
	function delAttach(devAttachId){
		$.ajax({
			url : '${pageContext.request.contextPath}/deviceTestApply_deleteApplyAttach.do',
			type : 'POST',
			data : {'devAttachId' : devAttachId},
			dataType : 'json',
			success : function (data){
				var data = eval(data);
				if(data.result = 'success'){
					alert("操作成功");
					$("#file2").empty();
					loadFileinput2();
				}
			},
			error : function (){
				alert("删除附件失败");
			}
		});
	}
	
	function loadFileinput2(){
		var dom = '<form id="attach_form2" enctype="multipart/form-data">';
  	 	dom = dom + '<input id="attach_deviceApplyId" name="deviceTestApply.applyId" type="hidden"/>';
		dom = dom + '<input id="attach2" name="applyAttach" class="file" type="file" multiple data-min-file-count="1">';
		dom = dom + '</form>';
		$("#file2").html(dom);
		loadStyle2();
		isAttach2 = 1;
	}
	
	function loadStyle2(){
		$("#attach2").fileinput({
			language : 'zh',
			showUpload : false, //是否显示上传按钮
			allowedFileExtensions : [ 'doc', 'docx','xls','xlsx' ]
		});
	}

</script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div id="Nav">
	<span>设备检测>>查看申请</span>
	<a class="btn-nav" href="javascript:history.go(-1)">返回</a>
</div>
<div class="wrapper">

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
      </h1>
      <span class="breadcrumb">
        <a class="btn btn-app" href="javascript:void(0)" onclick="updApply('save')">
          <i class="fa fa-save"></i> 保存
        </a>
        <a class="btn btn-app" href="javascript:void(0)" onclick="updApply('sub')">
          <i class="fa fa-check-square-o"></i> 提交
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
          </div><!-- /.box-header -->

          <div class="box-body pad">
            <div class="row">
              <div class="col-sm-6">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">申请单位</label>
                    <div class="col-sm-8">
                    <c:set var="agenUnitId" scope="session" value="<%=unitId %>"/>
                     <c:choose>
                    	<c:when test="${agentUnitId == '1'}">
                    		<select id="devApplyUnitName" name="devApplyInfo.devApplyUnitId" class="form-control select2" style="width: 100%;margin-top: 10px;">
                    		</select>
                    	</c:when>
                    	<c:otherwise>
                   		 	<input type="text" id="devApplyUnitName" name="devApplyInfo.devApplyUnitId" class="form-control" readonly="readonly" value="<%=unit.getUnitName() %>">
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
                      <input id="dveNum" type="text" class="form-control" readonly="readonly" value="0">
                    </div>
                  </div>
                  <button type="button" class="btn btn-primary pull-right" onclick="addDveDialog()">添加检测设备</button>
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
                    <th>操作 </th>
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
                      <input type="text" id="userNameTab" class="form-control" />
                    </div>
                  </div>
                </form>
              </div>
              <div class="col-sm-6">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">联系方式</label>
                    <div class="col-sm-8">
                      <input type="text" id="telTab" class="form-control" />
                    </div>
                  </div>
                </form>
              </div>
            </div>
              
              <div class="row">
					<div class="col-sm-6">
						<form class="form-horizontal">
							<div class="form-group">
								<label for="applyDatePicker" class="col-sm-4 control-label">申请日期</label>
								<div class="col-sm-8">
									<input class="form-control" id="applyDatePicker" 	 name="applyDatePicker" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" />
								</div>
							</div>
						</form>
					</div>
			 </div>
            <hr>
             <form id="applyFm">
             	 <label class="col-sm-4 control-label">申请意见</label>
                <textarea  id="applyOpinion" name="deviceTestApply.applyOpinion" class="textarea333" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;">
                </textarea>
                <!-- 申请部门 -->
                <input id="unitId" name="deviceTestApply.unitId" value="<%= unitId%>" type="hidden"/>
                <!-- 申请人 -->
                <input type="hidden" id="userName" name="deviceTestApply.remark1"/>
                <!-- 联系方式 -->
                <input type="hidden" id="tel" name="deviceTestApply.remark2"/>
                <!-- 表示要删除的设备编号（T_DEVICE_BASE_INFO） -->
                <input type="hidden" id="delDeviceId" name="delDeviceId" value=""/>
                <input type="hidden" id="deviceNum" name="deviceTestApply.deviceNum"/>
                <input id="newChooseDve" name="newChooseDve" type="hidden"/>
                <!-- 表示要删除的设备编号（NT_APPLY_DEVICE） -->
				<input id="delExsitDve" name="delExsitDve" type="hidden" value=""/>
				<input id="applyId" name="deviceTestApply.applyId" type="hidden" value="<%=applyId%>"/>
				<input id="operate" name="operate" type="hidden"/>
				<!-- 申请日期 -->
				<input id="applyDate" name="deviceTestApply.applyDate" type="hidden" />
              </form>

			 <div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title">申请书电子版</h3>
				</div>
				<div class="box-body">
					<div class="row" id="file2">
						<div class="col-sm-8">
							<div id="fileName2"></div>
						</div>
						<div class="col-sm-4">
							<button style="float: right;" id="delAttach2" class="btn btn-info">删除</button>
						</div>
					</div>
				</div>
			</div>

		</div><!-- /.box-body -->
        </div><!-- /.box -->

       </div>
       <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

</div>



<!-- ./wrapper -->
<div id="addTab" style="display: none">
	<form id="addDeviceInfoForm">
		<table class="dataTab" id="infoTab">
			<tr>
				<td class="title_td">设备使用单位</td>
				<td colspan="3">
					<input id="unitName" name="deviceBaseInfo.unitName"  value="<%=unit.getUnitName() %>" readonly="readonly"/>
					<input id="devUnitId"   name="deviceBaseInfo.unitId" value="$('#devApplyUnitName').val()" type="hidden"  />
				</td>
			</tr>
			<tr>
				<td class="title_td">设备类型</td>
				<td colspan="3">
					<select id="add_deviceClassUp" name="deviceBaseInfo.deviceClass" >
					
					</select>
				</td>
			</tr>
			<tr>
				<td class="title_td">设备名称</td>
				<td colspan="3">
					<!-- <input id="add_deviceName" name="deviceBaseInfo.deviceName" isempty="no" tip="设备名称不能为空"/>
					<font color="red">*</font> -->
					<select  class="form-control" name = "deviceBaseInfo.deviceName"  id = "add_deviceName" >
		            </select>
				</td>
			</tr>
			<tr>
				<td class="title_td">设备型号</td>
				<td colspan="3">
					<!-- <input id="add_deviceModel" name="deviceBaseInfo.deviceModel"   isempty="no" tip="设备型号不能为空"/>
					<font color="red">*</font> -->
					<select  class="form-control" name = "deviceBaseInfo.deviceModel"  id = "add_deviceModel" >
			        </select>
				</td>
			</tr>
			
			<tr>
				<td class="title_td">设备序列号</td>
				<td colspan="3">
					<!-- <input id="add_deviceNum" name="deviceBaseInfo.deviceNum"  isempty="no" tip="设备序列号不能为空"/>
					<font color="red">*</font> -->
					<select  class="form-control" name = "deviceBaseInfo.deviceNum"  id = "add_deviceNum" >
			        </select>
				</td>
			</tr>
			<tr>
				<td class="title_td">设备类别</td>
				<td colspan="3">
					<select id="add_deviceType" name="deviceBaseInfo.deviceType" >
					    <option value="1">新购</option>
						<option value="2">维修后</option>
					</select>
					<input type="hidden" id="devId" name="deviceBaseInfo.deviceId" value="" /> 
					<input type="hidden" id="operation" value="add" /></td>
					<input type="hidden" id="devSeqId" name="deviceBaseInfo.remark" value="" />
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center" style="padding-top:20px;">
					<span id="btn_add_device" class="btn" onclick="addDve()">确定</span>
				</td>
			</tr>
		</table>
	</form>
</div>

</body>

<script type="text/javascript">
//Initialize Select2 Elements
//$(".select2").select2();
</script>
</html>