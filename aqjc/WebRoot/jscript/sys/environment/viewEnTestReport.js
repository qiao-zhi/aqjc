/**
 * 2018年2月9日
 * liqiang
 * 查看检测报告的JS
 */
/***********S   页面只执行一次的相关操作*****************/
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
	 //加载设备信息
	 showInsTab();
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
							"<td>"+json[v].manufacturer+"</td></tr>");
				}
			}
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
								+'</div >')
						
					}
				}
				if(pictureType == "2"){
					$("#frequencyPriviousDiv .imageDiv").remove();
					for(var i=0;i<response.length;i++){
						$("#frequencyPriviousDiv").append(						
								'<div class="imageDiv"><img src="/picture/'+response[i].enPicUrl+'" class="priImg" id="'+response[i].enPicId+'">'
								+'</div >')
						
					}
				}
				if(pictureType == "3"){
					$("#enviPriviousDiv .imageDiv").remove();
					for(var i=0;i<response.length;i++){
						$("#enviPriviousDiv").append(				
								'<div class="imageDiv"><img src="/picture/'+response[i].enPicUrl+'" class="priImg" id="'+response[i].enPicId+'">'
								+'</div >')
					}
				}
				if(pictureType == "4"){
					$("#pingmianPriviousDiv .imageDiv").remove();
					for(var i=0;i<response.length;i++){
						$("#pingmianPriviousDiv").append(			
								'<div class="imageDiv"><img src="/picture/'+response[i].enPicUrl+'" class="priImg" id="'+response[i].enPicId+'">'
								+'</div >')
						
					}
				}
			}
		}
	});
}
/********E   页面初始化相关操作***************/

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



