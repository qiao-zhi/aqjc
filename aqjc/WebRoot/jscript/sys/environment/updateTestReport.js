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
 
 
 var isReset = false;
 
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
	//查询环境检测照片
	loadEnTestPic("3");
	//查询环境检测照片
	loadEnTestPic("4");
	//查询环境检测照片
	loadEnTestPic("2");
	//查询环境检测照片
	loadEnTestPic("1");
	//以前图片的点击事件:
	 $('body').on('click','.priImg', function () {
			var src = $(this).prop("src");
			$("#dynamicImage").prop("src",src);
			$("#imgModal").modal("show");
     });
	//删除按钮点击事件:
	 $('body').on('click','.deleteImgA', function () {
		 if(confirm("您确认此照片?")){
			 var enPicId = $(this).parent().children("img").prop("id");
			 //删除图片
			 delEnPic(enPicId);
		 }
  });
	
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
				
				//给检测项目赋值
				var testProject = data.testProject;
				if(testProject != null && "" != testProject && testProject.length>0){
					var projectArray = testProject.toString().split(",");
					for(var i=0,length_1=projectArray.length;i<length_1;i++){
						$("[name='enTestReport.testProject'][value='"+projectArray[i]+"']").prop("checked",true);
					}
				}
				
				$("#testProject").val(data.testProject);
				$("#testCriterion").val(data.testCriterion);
				$("#testLocation").val(data.testLocation);
				$("#createTime").val(data.createTime);
				$("#environmentStatus").val(data.environmentStatus);
				$("#environmentSize").val(data.environmentSize);
				$("#environmentApplyProduction").val(data.environmentApplyProduction);
			}
		},
		error : function(){
			alert("加载检测报告信息错误");
		}
	});
}
//根据图片类型查询图片加载图片
function loadEnTestPic(pictureType){
	$.ajax({
		url : contextPath + '/enTestReport_selEnPic.do',
		data : {'enApplyId' : $("#hidden_apply_id").val(),
				'enPicType' : pictureType},
		type : 'POST',
		dataType : 'json',
		success : function(response) {
			if(response!=null && response.length>0){
				if(pictureType == "1"){
					$("#processPriviousDiv .imageDiv").remove();
					for(var i=0;i<response.length;i++){
						$("#processPriviousDiv").append(
								'<div class="imageDiv"><img src="/picture/'+response[i].enPicUrl+'" class="priImg" id="'+response[i].enPicId+'">'
								+'<a href="javascript:void(0)" class="deleteImgA">删除</a></div >')
						
					}
				}
				if(pictureType == "2"){
					$("#frequencyPriviousDiv .imageDiv").remove();
					for(var i=0;i<response.length;i++){
						$("#frequencyPriviousDiv").append(						
								'<div class="imageDiv"><img src="/picture/'+response[i].enPicUrl+'" class="priImg" id="'+response[i].enPicId+'">'
								+'<a href="javascript:void(0)" class="deleteImgA">删除</a></div >')
						
					}
				}
				if(pictureType == "3"){
					$("#enviPriviousDiv .imageDiv").remove();
					for(var i=0;i<response.length;i++){
						$("#enviPriviousDiv").append(				
								'<div class="imageDiv"><img src="/picture/'+response[i].enPicUrl+'" class="priImg" id="'+response[i].enPicId+'">'
								+'<a href="javascript:void(0)" class="deleteImgA">删除</a></div >')
					}
				}
				if(pictureType == "4"){
					$("#pingmianPriviousDiv .imageDiv").remove();
					for(var i=0;i<response.length;i++){
						$("#pingmianPriviousDiv").append(			
								'<div class="imageDiv"><img src="/picture/'+response[i].enPicUrl+'" class="priImg" id="'+response[i].enPicId+'">'
								+'<a href="javascript:void(0)" class="deleteImgA">删除</a></div >')
						
					}
				}
			}
		}
	});
}
/**
 * 加载设备信息
 */
function showInsTab(){
	$.ajax({
		url : contextPath+'/enTestReport_getInstrumentInfosByReportId.do',
		data : {'useType':'3',
			'enTestReportId' : $("#environmentTestReportId").val()//报告编号
			},
		type : 'POST',
		async:false,
		dataType : 'json',
		success : function(response) {
			var json = response.instrumentInfos;
			if(json.length>0){
				$("#selectedInsTab  tr:not(:first)").html("");
				for(var v=0;v<json.length;v++){
					$("#selectedInsTab").append("<tr><td><input type='hidden' name='insId' value='"+json[v].instrumentId+"'/>"+json[v].name+"</td>"+
							"<td>"+json[v].model+"</td>"+
							"<td>"+json[v].code+"</td>"+
							"<td>"+json[v].manufacturer+"</td>"+
							"<td><a href='javascript:void(0)' onclick='delSeletedIns(this)'><i class='fa fa-trash'></i></td></tr>");
				}
			}
		}
	});
}
// 删除图片
function delEnPic(enPicId){
		$.ajax({
			url : contextPath+'/enTestReport_delEnPic.do',
			data : {'enPicId' : enPicId},
			type : 'POST',
			dataType : 'json',
			success : function (data){
				var data = eval(data);
				if (data.result == "success"){
					// 删除节点
					$("#"+enPicId).parent().remove();
				} else {
					alert("删除图片失败！");
				}
			},
			error : function (){
				alert("删除图片失败！");
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
			saveEnIns();//保存设备信息
			saveInfo();//保存检测信息
		}
	});
	//提交
	$("#submit").click(function() {
		if(confirm("您确认提交信息?提交之后不可以更改!")){
			$("#operate").val("submit");
			saveEnIns();//保存设备信息
			if (validate()){
				alert("请完善信息");
				return;
			}
			//验证设备信息
			if(!validateInstrument()){
				alert("请完善设备信息");
				return;
			}
			//验证图片信息
			if(!validatePicture()){
				alert("请完善图片信息");
				return;
			}
			saveInfo();//保存基本信息
		}
	});
	
	
});

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
	if($("#environmentTestReportId").val() == "") {
		return true;
	}
	if($("#createTime").val() == "") {
		return true;
	}
	if($("#environmentSize").val() == "") {
		return true;
	}
	if($("#environmentStatus").val() == "") {
		return true;
	}
}
//验证设备信息
function validateInstrument(){
	var length = $("#selectedInsTab tr").length;
	return length>1?true:false;
}
//验证图片信息
function validatePicture(){
	if($("#pingmianPriviousDiv").find(".imageDiv").length==0) return false;
	if($("#enviPriviousDiv").find(".imageDiv").length==0) return false;
	if($("#processPriviousDiv").find(".imageDiv").length==0) return false;
	if($("#frequencyPriviousDiv").find(".imageDiv").length==0) return false;
	return true;
}

	function saveInfo(){
		//将两个按钮设置为不可点击
		$("#save").prop("disabled",true);
		$("#submit").prop("disabled",true);
		$.ajax({
			url : contextPath+'/enTestReport_updateEnTestReport.do',
			type : 'POST',
			dataType : 'json',
			data : $("#enTestReportForm").serializeArray(),
			success : function(data){
				if(data.result=="success"){
					alert("保存成功");
					window.location.href=contextPath+"/admin/environment/enTestReport_list.jsp";
				}
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
			url : contextPath+'/enTestReport_saveReportAndIns.do',
			data : {'enTestReportId' : $("#environmentTestReportId").val(),
					'insIdStr' : insIdStr.toString().substring(0,insIdStr.length-1)//去掉最后一个逗号
				},
			dataType : 'json',
			type : 'POST',
			success : function(data){
//				成功之后重新查询设备信息
				showInsTab();
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
    showRemove : true, //显示移除按钮,跟随文本框的那个
    showClose:false,//显示关闭按钮
    showCaption: true,//是否显示标题,就是那个文本框
    uploadAsync:true,//是否异步
    layoutTemplates:{//预览区域删除按钮与上传按钮的显示
        actionUpload:'',//上传按钮不显示
        progress:''//隐藏进度条
   },
    autoReplace:true,//是否自动替换上一个文件
    enctype: 'multipart/form-data',
    previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
    uploadExtraData: function (previewId, index) {//携带其他一些数据的格式
        var data = {
        	applyId:$("#hidden_apply_id").val(),//申请编号
        	pictureType:'4'//4代表是平面简图
        };
        return data;
    },
    previewSettings: {//限制预览区域的宽高
    	image: {width: "160px", height: "160px"}
    },
    validateInitialCount:true,
    allowedFileExtensions: ['jpg','png']//允许上传问价你的后缀
}).on('filepreupload', function(event, data, previewId, index) {
    var form = data.form, files = data.files, extra = data.extra,response = data.response, reader = data.reader;
    
}).on("filebatchselected", function(event, files) {//文件选中函数
	$(this).fileinput("upload");
}).on("fileuploaded", function(event, data) {//上传成功之后的一些处理
        if(data.response)
        {
        	$(this).fileinput("reset");
        	loadEnTestPic("4");
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
	    showRemove : true, //显示移除按钮,跟随文本框的那个
	    showClose:false,//显示关闭按钮
	    showCaption: true,//是否显示标题,就是那个文本框
	    uploadAsync:true,//是否异步
	    layoutTemplates:{//预览区域删除按钮与上传按钮的显示
	        actionUpload:'',//上传按钮不显示
	        progress:''//隐藏进度条
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
	    	image: {width: "160px", height: "160px"}
	    },
	    validateInitialCount:true,
	    allowedFileExtensions: ['jpg','png']//允许上传问价你的后缀
	}).on('filepreupload', function(event, data, previewId, index) {
	    var form = data.form, files = data.files, extra = data.extra,
	        response = data.response, reader = data.reader;
	}).on("filebatchselected", function(event, files) {//文件选中函数(选完上传)
		isReset = false ; 
		$(this).fileinput("upload");
	}).on("fileuploaded", function(event, data) {//上传成功之后的一些处理(成功之后重置)
	        if(data.response)
	        {
	        	if(!isReset){
	 	           //查询环境检测照片
	 	           $("#upEnvironmentPicture").fileinput("reset");
	 	           loadEnTestPic("3");
	        		isReset = true;
		        	}
	        }
	    });
/**
 * 上传检测过程照片
 */
$("#upProcessPicture").fileinput({
    language: 'zh',//中文
    uploadUrl:"upLoadMultiple.do",//上传的地址，加上这个才会出现删除按钮
    dropZoneEnabled: false,//是否显示拖拽区域
    showUpload: true, //是否显示上传按钮,跟随文本框的那个
    showRemove : true, //显示移除按钮,跟随文本框的那个
    showClose:false,//显示关闭按钮
    showCaption: true,//是否显示标题,就是那个文本框
    uploadAsync:true,//是否异步
    layoutTemplates:{//预览区域删除按钮与上传按钮的显示
        actionUpload:'',//上传按钮不显示
        progress:''
   },
    enctype: 'multipart/form-data',
    previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
    previewSettings: {//限制预览区域的宽高
    	image: {width: "160px", height: "160px"}
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
}).on("filebatchselected", function(event, files) {//文件选中函数
	$(this).fileinput("upload");
	isReset = false ; 
}) .on("fileuploaded", function(event, data) {//上传成功之后的一些处理
        if(data.response)
        {
	        	if(!isReset){
	 	           //查询环境检测照片
	 	           $("#upProcessPicture").fileinput("reset");
	 	           loadEnTestPic("1");
	        		isReset = true;
	        	}
	           
        }
    });
/**
 * 上传频谱图
 */
$("#upFrequencyPicture").fileinput({
    language: 'zh',//中文
    uploadUrl:"upLoadMultiple.do",//上传的地址，加上这个才会出现删除按钮
    dropZoneEnabled: false,//是否显示拖拽区域
    showUpload: true, //是否显示上传按钮,跟随文本框的那个
    showRemove : true, //显示移除按钮,跟随文本框的那个
    showClose:false,//显示关闭按钮
    showCaption: true,//是否显示标题,就是那个文本框
    uploadAsync:true,//是否异步
    layoutTemplates:{//预览区域删除按钮与上传按钮的显示
        actionUpload:'',//上传按钮不显示
        progress:''//隐藏进度条
    },
    enctype: 'multipart/form-data',
    previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
    previewSettings: {//限制预览区域的宽高
    	image: {width: "160px", height: "160px"}
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
}).on("filebatchselected", function(event, files) {//文件选中函数(选中之后上传文件)
	isReset = false;
	$(this).fileinput("upload");
}).on("fileuploaded", function(event, data) {//上传成功之后的一些处理
        if(data.response)
        {
        	if(!isReset){
        		$("#upFrequencyPicture").fileinput("reset");//将此插件重置(前提是不显示上传进度条，否则将留下进度条)
        		loadEnTestPic("2");//执行页面的一个JS函数重新查询图片
        		isReset = true;
        	}
        }
    });
/************E    四种图片上传插件的显示*/


/************  S   预览图片的上一张下一张*******************/
function lastImg(){
	var src = $("#dynamicImage").attr("src");
	var imgName = src.toString().substring(src.length-36);//获取图片名字
	var imgParent = $("#imgBigDiv").find("[src$='"+imgName+"']").parent();//获取到class为imageDiv的div
	var lastImageDiv = imgParent.prev("div");
	if(lastImageDiv.length == 0){
		alert("已经是第一张了");
	}else{
		$("#dynamicImage").prop("src",lastImageDiv.children("img").prop("src"));
	}
}
function nextImg(){
	var src = $("#dynamicImage").attr("src");
	var imgName = src.toString().substring(src.length-36);//获取图片名字
	var imgParent = $("#imgBigDiv").find("[src$='"+imgName+"']").parent();//获取到class为imageDiv的div
	var lastImageDiv = imgParent.next("div");
	if(lastImageDiv.length == 0){
		alert("已经是最后一张了");
	}else{
		$("#dynamicImage").prop("src",lastImageDiv.children("img").prop("src"));
	}
}
/************  E   预览图片的上一张下一张*******************/



