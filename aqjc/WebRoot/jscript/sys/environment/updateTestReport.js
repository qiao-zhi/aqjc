/**
 * QLQ 2018.02.07
 *修改检测报告的JS 
 */
/***********S   页面只执行一次的相关操作*****************/
/**页面执行一次删除插件初始化的预览图片的模态框的函数**/
 (function(){
	$(".pictureDiv .modal").remove();//删除bootstrapFileinput初始化预览的div
})();
/***********E   页面只执行一次的相关操作*****************/
 
 
/********S   页面初始化相关操作***************/
$(function(){
	//单选按钮的点击事件
	$("[name='pictureType']").click(function(){
		var clazz = $(this).prop("class");
		$(".pictureDiv").css("display","none");//隐藏所有的div
		$("div."+clazz).css("display","block");
	});
	//1.初始化环境申请信息
	showEnApplyInfo();
	//2.初始化检测信息(需要完善)
	loadEnTestReport();
	
});
//查询环境申请信息
function showEnApplyInfo() {
	$.ajax({
		url : contextPath+'/enApplyInfo_selEnApplyInfoById.do',
		data : {'enApplyId' : $("#hidden_apply_id").val()},
		type : 'POST',
		dataType : 'json',
		success : function(response) {
			var info = eval(response);
			$("#applyDate").val(info.enApplyDate);
			$("#enApplyUnitId").val(info.enApplyUnitId);
			$("#applyUsername").val(info.enApplyUserName);
			$("#appPhone").val(info.enApplyTel);
			$("#yangpinmingcheng").val(info.enApplySamply);
			$("#manuUnit").val(info.enApplyProduction);
			loadUnitName();//查询单位名称
		}
	});
}
//加载部门名称
function loadUnitName(){
	$.ajax({
		url : contextPath+'/loadUnitName.do',
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				var data = eval(data);
				var optionStr = "";
				for (var i = 0; i < data.length; i++) {
					if(data[i].unitId == $("#enApplyUnitId").val()){
						$("#applyUnitName").val(data[i].unitName);
						break;
					}
				}
			},
			error : function(data) {
				alert("error");
			}
		});
	}

//获取检测报告信息
function loadEnTestReport(){
	$.ajax({
		url : contextPath + '/enTestReport_selEnTestReportById.do',
		data : {'enTestReportId' : $("#environmentTestReportId").val()},
		dataType : 'json',
		type : 'POST',
		success : function(data){
			var data = eval(data);
			if(data.result == 'success') {
				$("#testReportNumber").val(data.testReportNumber);
				$("#testUserName").val(data.testUserName);
				$("#testUnitName").val(data.testUnitName);
				$("#testDate").val(data.testDate);
				$("#testResult").val(data.testResult);
				$("#testSampleName").val(data.testSampleName);
			}
		},
		error : function(){
			alert("加载检测报告信息错误");
		}
	});
}

/********E   页面初始化相关操作***************/

/**************S  **保存相关操作***************/
$(function(){
	showInsTab();
//	loadEnApplyInfo();
	//保存的点击事件
	$("#save").click(function() {
		if(confirm("您确认保存信息?保存之后可以修改!")){
			saveInfo();
		}
	});
	//提交
	$("#submit").click(function() {
		$("#operate").val("submit");
		if (validate()){
			alert("请完善信息");
			return;
		}
		saveInfo();
	});
	
	
});

function showInsTab(){
	$.ajax({
		url : contextPath+'/ins_showInsTab.do',
		data : {'useType':'3'},
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
							"<td><a href='javascript:void(0)' onclick='delSeletedIns(this)'><i class='fa fa-trash'></i></td></tr>");
				}
			}
		}
	});
}

function validate(){
	if($("#testReportNumber").val() == "") {
		return true;
	}
	if($("#testDate").val() == ""){
		return true;
	}
	if($("#testUserName").val() == ""){
		return true;
	}
	if($("#testUnitName").val() == "") {
		return true;
	}
	if($("#testSampleName").val() == "") {
		return true;
	}
	if($("#testResult").val() == "") {
		return true;
	}
}

	function saveInfo(){
		//将两个按钮设置为不可点击
		$("#save").prop("disabled",true);
		$("#submit").prop("disabled",true);
		$.ajax({
			url : '<%=request.getContextPath()%>/enTestReport_saveEnTestReport.do',
			type : 'POST',
			dataType : 'json',
			data : $("#enTestReportForm").serializeArray(),
			success : function(data){
				$("#environmentTestReportId").val(data.enTestReportId);
				//保存设备信息
				saveEnIns();
				// 设置图片上传的url
				savePicture();
			},
			error : function(data){
				alert("error");
			}
		});
	}
	
	/**保存设备信息*/
	function saveEnIns(){
		var v = $("#selectedInsTab tr").length;
		if(v==1){
			return;
		}
		var insIdStr = "";
		if(v > 1){
			$("input[name='insId']").each(function(index,item){
				insIdStr = insIdStr + $(this).val()+",";
			});
		}
		$.ajax({
			url : '<%=request.getContextPath()%>/enTestReport_saveReportAndIns.do',
			data : {'enTestReportId' : $("#environmentTestReportId").val(),
				'insIdStr' : insIdStr},
			dataType : 'json',
			type : 'POST',
			success : function(data){
				
			},
			error : function(data){
				alert("检测仪器保存失败");			
			}
		});
	}
	/*****S  保存图片信息***********/
	function savePicture(){
		//判断是否有图片选择并上传
		if(isSelectedFile("upPlanePicture")){
			$("#upPlanePicture").fileinput("upload");
		}
		//上传环境监测图片
		if(isSelectedFile("upEnvironmentPicture")){
			$("#upEnvironmentPicture").fileinput("upload");
		}
		//上传监测过程
		if(isSelectedFile("upProcessPicture")){
			$("#upProcessPicture").fileinput("upload");
		}
		//上传频谱图
		if(isSelectedFile("upFrequencyPicture")){
			$("#upFrequencyPicture").fileinput("upload");
		}
	}
	/**判断是否选上文件**/
	function isSelectedFile(inputId){
		var applyFile = $("#"+inputId)[0].files;
		var applyFile_length = applyFile.length;
		return applyFile_length>0?true:false;
	}

/**************E  **保存相关操作***************/










/******************S    四种图片上传插件的显示*/
/**
 * 上传平面简图
 */
$("#upPlanePicture").fileinput({
    language: 'zh',//中文
    uploadUrl:"upLoadMultiple.do",//上传的地址，加上这个才会出现删除按钮
    dropZoneEnabled: false,//是否显示拖拽区域
    showUpload: false, //是否显示上传按钮,跟随文本框的那个
    showRemove : false, //显示移除按钮,跟随文本框的那个
    showClose:false,//显示关闭按钮
    showCaption: true,//是否显示标题,就是那个文本框
    uploadAsync:true,//是否异步
    layoutTemplates:{//预览区域删除按钮与上传按钮的显示
        actionUpload:''//上传按钮不显示
   },
    autoReplace:true,//是否自动替换上一个文件
    enctype: 'multipart/form-data',
/*     layoutTemplates : {
    	actionUpload:"<input type='text' placeholder='请输入图片名称' onchange='changePictureName(this)' style='width:100px;background-color:rgb(238,238,238);'/>"
    }, */
    previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
    uploadExtraData: function (previewId, index) {//携带其他一些数据的格式
        var data = {
        	applyId:$("#hidden_apply_id").val(),//申请编号
        	pictureType:'4'//4代表是平面简图
        };
        return data;
    },
    previewSettings: {//限制预览区域的宽高
        image: {width: "100px", height: "100px"},
    },
    validateInitialCount:true,
    allowedFileExtensions: ['jpg','png']//允许上传问价你的后缀
}).on('filepreupload', function(event, data, previewId, index) {
    var form = data.form, files = data.files, extra = data.extra,response = data.response, reader = data.reader;
    
}).on("filebatchselected", function(event, files) {//文件选中函数
	
}).on("fileuploaded", function(event, data) {//上传成功之后的一些处理
        if(data.response)
        {
           /*  alert('处理成功'); */
        }
    });
/**
 * 上传环境描述
 */
 $("#upEnvironmentPicture").fileinput({
	    language: 'zh',//中文
	    uploadUrl:"upLoadMultiple.do",//上传的地址，加上这个才会出现删除按钮
	    dropZoneEnabled: false,//是否显示拖拽区域
	    showUpload: false, //是否显示上传按钮,跟随文本框的那个
	    showRemove : false, //显示移除按钮,跟随文本框的那个
	    showClose:false,//显示关闭按钮
	    showCaption: true,//是否显示标题,就是那个文本框
	    uploadAsync:true,//是否异步
	    layoutTemplates:{//预览区域删除按钮与上传按钮的显示
	        actionUpload:''//上传按钮不显示
	   },
	   autoReplace:true,//是否自动替换，只能替换上一步选择的文件
	    enctype: 'multipart/form-data',
	    previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
/* 	    layoutTemplates : {
	    	actionUpload:"<input type='text' placeholder='请输入图片名称' onchange='changePictureName(this)' style='width:100px;background-color:rgb(238,238,238);'/>"
	    }, */
	    uploadExtraData: function (previewId, index) {//携带其他一些数据的格式
	        var data = {
	        	applyId:$("#hidden_apply_id").val(),
	        	pictureType:'3'
	        };
	        return data;
	    },
	    previewSettings: {//限制预览区域的宽高
	        image: {width: "0px", height: "0px"},
	    },
	    validateInitialCount:true,
	    allowedFileExtensions: ['jpg','png']//允许上传问价你的后缀
	}).on('filepreupload', function(event, data, previewId, index) {
	    var form = data.form, files = data.files, extra = data.extra,
	        response = data.response, reader = data.reader;
	}) .on("fileuploaded", function(event, data) {//上传成功之后的一些处理
	        if(data.response)
	        {
	           /*  alert('处理成功'); */
	        }
	    });
/**
 * 上传检测过程照片
 */
$("#upProcessPicture").fileinput({
    language: 'zh',//中文
    uploadUrl:"upLoadMultiple.do",//上传的地址，加上这个才会出现删除按钮
    dropZoneEnabled: false,//是否显示拖拽区域
    showUpload: false, //是否显示上传按钮,跟随文本框的那个
    showRemove : false, //显示移除按钮,跟随文本框的那个
    showClose:false,//显示关闭按钮
    showCaption: true,//是否显示标题,就是那个文本框
    uploadAsync:true,//是否异步
    layoutTemplates:{//预览区域删除按钮与上传按钮的显示
        actionUpload:''//上传按钮不显示
   },
    enctype: 'multipart/form-data',
    previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
    previewSettings: {//限制预览区域的宽高
        image: {width: "0px", height: "0px"},
    },
    uploadExtraData: function (previewId, index) {//携带其他一些数据的格式
        var data = {
        	applyId:$("#hidden_apply_id").val(),
        	pictureType:'1'
        };
        return data;
    },
    validateInitialCount:true,
    allowedFileExtensions: ['jpg','png']//允许上传问价你的后缀
}).on('filepreupload', function(event, data, previewId, index) {
    var form = data.form, files = data.files, extra = data.extra,
        response = data.response, reader = data.reader;
}) .on("fileuploaded", function(event, data) {//上传成功之后的一些处理
        if(data.response)
        {
           /*  alert('处理成功'); */
        }
    });
/**
 * 上传频谱图
 */
$("#upFrequencyPicture").fileinput({
    language: 'zh',//中文
    uploadUrl:"upLoadMultiple.do",//上传的地址，加上这个才会出现删除按钮
    dropZoneEnabled: false,//是否显示拖拽区域
    showUpload: false, //是否显示上传按钮,跟随文本框的那个
    showRemove : false, //显示移除按钮,跟随文本框的那个
    showClose:false,//显示关闭按钮
    showCaption: true,//是否显示标题,就是那个文本框
    uploadAsync:true,//是否异步
    layoutTemplates:{//预览区域删除按钮与上传按钮的显示
        actionUpload:''//上传按钮不显示
   },
    enctype: 'multipart/form-data',
    previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
    previewSettings: {//限制预览区域的宽高
        image: {width: "0px", height: "0px"},
    },
    uploadExtraData: function (previewId, index) {//携带其他一些数据的格式
        var data = {
        	applyId:$("#hidden_apply_id").val(),
        	pictureType:'2'
        };
        return data;
    },
    validateInitialCount:true,
    allowedFileExtensions: ['png','jpg']//允许上传问价你的后缀
}).on('filepreupload', function(event, data, previewId, index) {
    var form = data.form, files = data.files, extra = data.extra,
        response = data.response, reader = data.reader;
}) .on("fileuploaded", function(event, data) {//上传成功之后的一些处理
        if(data.response)
        {
           /*  alert('处理成功'); */
        }
    });
/************E    四种图片上传插件的显示*/