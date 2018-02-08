<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.tyust.bean.user.TBaseUserInfo"%>
<%@ page
	import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page
	import="com.tyust.dao.unit.IunitDao,com.tyust.bean.unit.TBaseUnitInfo"%>
<%@ page import="java.util.*,com.tyust.common.DateHandler"%>
<%
	// 获取当前用户
	TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
	ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
	// 获取用户的部门信息
	String unitId = user.getUnitId();
	IunitDao unitDao = (IunitDao)context.getBean("Unit");
	TBaseUnitInfo unit = unitDao.findUnit(unitId);
%>
<%@include file="/public/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>环境检测申请</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">

<link rel="stylesheet"
	href="<%=request.getContextPath() %>/newStyle/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/newStyle/font-awesome-4.5.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/newStyle/ionicons-2.0.1/css/ionicons.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/newStyle/dist/css/AdminLTE.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/newStyle/plugins/iCheck/flat/blue.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/newStyle/dist/css/skins/skin-blue.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/newStyle/plugins/webuploader/css/webuploader.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/newStyle/plugins/webuploader/style.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/newStyle/plugins/lightbox/css/lightbox.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/css/fileinput.min.css" />
<style>
.dataTab input {
	width: 220px;
	height: 23px;
}

.dataTab select {
	width: 110px;
	height: 22px;
}
</style>

<!-- S     QLQ引入的bootstrapFileinput的CSS -->
<link rel="stylesheet" type="text/css"
	href="${baseurl}/bootstrapFileinput/css/default.css">
<link href="${baseurl}/bootstrapFileinput/css/fileinput.css" media="all"
	rel="stylesheet" type="text/css" />
<!-- E     QLQ引入的bootstrapFileinput的CSS -->


</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-12">

						<div class="box box-solid box-primary">
							<div class="box-header with-border">
								<h3 class="box-title">环境检测申请</h3>
							</div>
							<!-- /.box-header -->

							<div class="box-body pad">
								<div class="row">
									<div class="col-md-8 col-md-offset-2">
										<div class="box box-info">
											<div class="box-header with-border">
												<h3 class="box-title">基本信息</h3>
											</div>
											<div class="box-body">
												<form id="enApplyInfo_form" class="form-horizontal">
													<div class="row">
														<div class="col-sm-6">
															<div class="form-group">
																<label for="input1" class="col-sm-4 control-label">申请单位</label>
																<div class="col-sm-8">
																	<!-- 申请单位下拉列表 -->
																	<select id="unitSelect" class="form-control"
																		onchange="changeUnit()">
																	</select>
																	<!-- 隐藏 -->
																	<input name="enApplyInfo.environmentApplyUnitId"
																		type="hidden">
																	<%-- <input  class="form-control" value="<%=unit.getUnitName() %>" type="hidden"> --%>
																</div>
															</div>
														</div>
														<div class="col-sm-6">
															<div class="form-group">
																<label for="input1" class="col-sm-4 control-label">申请日期</label>
																<div class="col-sm-8">
																	<input readonly style="background-color: #ffffff"
																		name="enApplyInfo.environmentApplyDate" type="text"
																		class="form-control"
																		value="<%= DateHandler.dateToString(new Date()) %>"
																		onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})">
																</div>
															</div>
														</div>
													</div>

													<div class="row">
														<div class="col-sm-6">
															<div class="form-group">
																<label for="input1" class="col-sm-4 control-label">申请人</label>
																<div class="col-sm-8">
																	<!-- 隐藏 -->
																	<input name="enApplyInfo.environmentApplyUserId"
																		value="<%=user.getUserId() %>" type="hidden">
																	<input id="add_userName"
																		name="enApplyInfo.environmentApplyUserName"
																		type="text" class="form-control"
																		value="<%=user.getName() %>">
																</div>
															</div>
														</div>
														<div class="col-sm-6">
															<div class="form-group">
																<label for="input1" class="col-sm-4 control-label">联系方式</label>
																<div class="col-sm-8">
																	<input type="text" id="add_tel"
																		name="enApplyInfo.environmentApplyTel"
																		class="form-control" value="<%=user.getTelephone() %>">
																</div>
															</div>
														</div>
													</div>

													<div class="row">
														<div class="col-sm-6">
															<div class="form-group">
																<label for="input1" class="col-sm-4 control-label">样品名称</label>
																<div class="col-sm-8">
																	<input id="add_samply"
																		name="enApplyInfo.environmentApplySamply" type="text"
																		class="form-control" />
																</div>
															</div>
														</div>
														<div class="col-sm-6">
															<div class="form-group">
																<label for="input1" class="col-sm-4 control-label">生产单位</label>
																<div class="col-sm-8">
																	<input type="text" id="add_production"
																		name="enApplyInfo.environmentApplyProduction"
																		class="form-control">
																</div>
															</div>
														</div>
													</div>

													<div class="row">
														<div class="col-sm-12">
															<div class="form-group">
																<label for="input1" class="col-sm-2 control-label">申请意见</label>
																<div class="col-sm-10">
																	<textarea id="add_opinion"
																		name="enApplyInfo.environmentApplyOpinion"
																		class="textarea333" placeholder="请填写申请意见"
																		style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
																</div>
															</div>
														</div>
													</div>

													<!-- 隐藏项 ：操作-提交与保存-->
													<input type="hidden" id="operate" name="operate"
														value="save" />
												</form>
											</div>
										</div>

										<!--             <div class="box box-info">
              <div class="box-header with-border">
                <h3 class="box-title">申请书扫描照片</h3>                             
             <button type="button" class="btn btn-info" title="点击进行文件扫描" onclick="window.open('scanner_file.jsp')">扫描</button>
              </div>
              <div class="box-body">
         		<div id="container">
             	 头部，相册选择和格式选择
              	<div id="uploader">
               	 <div class="queueList">
                    <div id="dndArea" class="placeholder">
                        <div id="filePicker"></div>
                        <p>或将照片拖到这里，单次最多可选300张</p>
                    </div>
                 </div>
                 <div class="statusBar" style="display:none;">
                    <div class="progress">
                        <span class="text">0%</span>
                        <span class="percentage"></span>
                    </div><div class="info"></div>
                    <div class="btns">
                        <div id="filePicker2"></div>
                    </div>
                 </div>
                </div>
               </div>
              </div>
            </div> -->

										<!-- S  QLQ改造的上传扫描的pdf文件-->
										<!-- S 隐藏一个申请编号 -->
										<input type="hidden" id="hidden_apply_id"/>


										<div class="box box-info">
											<div class="box-header with-border">
												<h3 class="box-title">申请书扫描件pdf文件上传</h3>
												 <button type="button" class="btn btn-info" title="点击进行文件扫描" onclick="window.open('scanner_file.jsp')">扫描</button>
											</div>
											<div class="box-body">
												<form enctype="multipart/form-data">
													<input id="bootUpOne" class="file" type="file"
														name="fileName">
												</form>
											</div>
										</div>
										<!-- S  QLQ改造的上传扫描的pdf文件-->



										<div class="box box-info">
											<div class="box-header with-border">
												<h3 class="box-title">申请书电子版</h3>
											</div>
											<div class="box-body">
												<form id="attach_form">
													<input id="attach_enApplyId"
														name="enAttach.environmentApplyId" type="hidden" /> <input
														name="enAttach.environmentAttachType" type="hidden"
														value="1" /> <input id="attach" name="fileName" class="file"
														type="file" multiple data-min-file-count="1">
												</form>
											</div>
										</div>

									</div>
								</div>
							</div>
							<!-- /.box-body -->

							<div class="box-footer" style="text-align:center">
									<button id="save" type="button" class="btn btn-default">保存</button>
									<button id="submit" type="button" style="margin-left: 20px;"
										class="btn btn-info">提交</button>
							</div>
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
	<!-- ./wrapper -->
	<script
		src="<%=request.getContextPath() %>/newStyle/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<%-- 	<script type="text/javascript"
		src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/jquery.js"></script>
	<script type="text/javascript"
			src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/dist/webuploader.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/upload_enApplyInfo.js"></script> --%>
		
<%--  	<script type="text/javascript"	src="<%=request.getContextPath() %>/newStyle/plugins/lightbox/js/lightbox-plus-jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/js/fileinput.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/js/fileinput_locale_zh.js"></script>  --%>
	<script
		src="<%=request.getContextPath() %>/controls/JCalendar/WdatePicker.js"></script>


	<!--S  QLQ引入发bootstrapFileiput的JS  -->
	<script src="${baseurl }/bootstrapFileinput/js/fileinput.js"
		type="text/javascript"></script>
	<!--简体中文-->
	<script src="${baseurl }/bootstrapFileinput/js/locales/zh.js"
		type="text/javascript"></script>
	<!--繁体中文-->
	<script src="${baseurl }/bootstrapFileinput/js/locales/zh-TW.js"
		type="text/javascript"></script>
	<!-- Bootstrap的JS -->
	<script src="${baseurl }/bootstrapFileinput/js/bootstrap.min.js"
		type="text/javascript"></script>

	<!--E  QLQ引入发bootstrapFileiput的JS  -->


	<script>
var saveScan=true,saveAtta=true;
//先提交表单信息，成功后返回该信息的主键，然后在保存相关的图片和附件
$(document).ready(function(){
		$("#save").click(function (){
			$("#operate").val("save");
			if(confirm("您确认保存申请信息?")){
				saveInfo();
			}	
		});
		$("#submit").click(function (){
			$("#operate").val("submit");
			var o = isOK();
			if (o == true){
				if (validate()){
					alert("请完善信息");
					return;
				}
				saveInfo();
			}
		});
});

function  isOK(){
 	var ok = false;
	//判断扫描文件是否选上
	var scanFile = $("#bootUpOne")[0].files;
	var scanFile_length = scanFile.length;
	
	//判断申请书电子版文件是否选上
	var applyFile = $("#attach")[0].files;
	var applyFile_length = applyFile.length;
	
	//如果选择上文件可以进行提交
	if(scanFile_length > 0 && applyFile_length>0) {
		ok = true ;
	} else
		alert("请选择上传的附件进行上传!");
	
	return ok;
};

function validate(){
	if($("#add_userName").val() == "") {
		return true;
	}
	if($("#add_tel").val() == ""){
		return true;
	}
	if($("#add_samply").val() == ""){
		return true;
	}
	if($("#add_production").val() == "") {
		return true;
	}
}
/**
 * 保存
 */
function saveInfo(){
	//上传前将两个按钮置为不可点击
	$("#save").prop("disabled",true);
	$("#submit").prop("disabled",true);
	$.ajax({
		url : '<%=request.getContextPath()%>/enApplyInfo_saveEnApplyInfo.do',
		type : 'POST',
		async:false,
		dataType : 'json',
		data : $("#enApplyInfo_form").serializeArray(),
		success : function(data){
			var data = eval(data);
			if (data.result == "success"){
				// 获取保存好的屏蔽室申请ID
				var enApplyId = data.enApplyId;
				//设置传回来的申请编号
				$("#hidden_apply_id").val(enApplyId);
				//保存成功之后上传文件:
				//判断扫描文件是否选上
				var scanFile = $("#bootUpOne")[0].files;
				var scanFile_length = scanFile.length;
				
				//判断申请书电子版文件是否选上
				var applyFile = $("#attach")[0].files;
				var applyFile_length = applyFile.length;
				
				if(scanFile_length == 0  && applyFile_length ==0 ){
					alert("保存成功!");
					window.location.href=contextPath+"/admin/environment/enApplyInfo_list.jsp";
				}
				if(scanFile_length > 0){//上传扫描照片
					//上传扫描的照片附件
					$("#bootUpOne").fileinput("upload");
				}
				if(applyFile_length > 0){//上传申请书附件
					//上传扫描的照片附件
					$("#attach").fileinput("upload");
				}
				
			}
		},
		error : function(data){
			alert("error");
		}
	});
}


//附件上传功能:传入申请id作为参数
function fileUpload(id){
	//设置屏蔽室申请ID
	$("#attach_enApplyId").val(id);
	var formData = new FormData($('#attach_form')[0]);
	$.ajax({
	       url: '<%=request.getContextPath()%>/enApplyInfo_saveEnAttach.do',
	       data: formData,
	       async: false,
	       contentType: false,
	       processData: false,
	       cache: false,
	       type: 'post',
	       success: function(data) {
	    	   isUp = true;
	       },
	       error : function(){
	    	   alert("附件上传失败，请重试！");
	       }
	   });
}



/* S   乔利强  2018.02.05 */
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
				if(i == 0){
					$("[name='enApplyInfo.environmentApplyUnitId']").val(data[i].unitId);//向隐藏的单位ID赋值(默认值为第一个单位)	
					optionStr += "<option value="+data[i].unitId+" selected>"+data[i].unitName+"</option>";
				}else
					optionStr += "<option value="+data[i].unitId+" >"+data[i].unitName+"</option>";
			}
			$("#unitSelect").append(optionStr);
		},
		error : function(data){
			alert("error");
		}
	});
}
/**
 * 获取下拉菜单的单位信息给隐藏的值赋值
 */
function changeUnit(){
	var opt = $("#unitSelect option:selected");
	var value = opt.val();
	$("[name='enApplyInfo.environmentApplyUnitId']").val(value);//向隐藏的单位ID赋值	
}



/***S   上传文件相关操作****/
/**
 * 上传扫描的pdf原件
 */
//利用插件异步上传单文件
$("#bootUpOne").fileinput({
    language: 'zh',//中文
    uploadUrl:"upLoadOne.do",//上传的地址，加上这个才会出现删除按钮
    dropZoneEnabled: false,//是否显示拖拽区域
    showPreview:true,//是否显示预览区域
    showClose:false,//显示关闭按钮
    showUpload: false, //是否显示上传按钮,跟随文本框的那个
    showRemove : true, //显示移除按钮,跟随文本框的那个
    showCaption: true,//是否显示标题,就是那个文本框
    uploadAsync:true,
    enctype: 'multipart/form-data',
    previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
    layoutTemplates:{//预览区域删除按钮与上传按钮的显示
         actionUpload:''//上传按钮不显示
    },
    previewSettings: {//限制预览区域的宽高
        pdf: {width: "0px", height: "0px"}
    },
    uploadExtraData: function (previewId, index) {//携带其他一些数据的格式
        var data = {
        		applyId:$("#hidden_apply_id").val(),
       		attachType:'3'
        };
        return data;
    },
    validateInitialCount:true,
    allowedFileExtensions: ['pdf'],//允许上传问价你的后缀
}).on('filepreupload', function(event, data, previewId, index) {
    var form = data.form, files = data.files, extra = data.extra,
        response = data.response, reader = data.reader;
   		 saveScan = false;
}) .on("fileuploaded", function(event, data) {//上传成功之后的一些处理
        if(data.response)
        { 
        	saveScan = true;
        	if(saveScan&&saveAtta){
        		alert("上传成功!");
        		window.location.href=contextPath+"/admin/environment/enApplyInfo_list.jsp";
        	}
        }
    });

/**
 * 上传申请书电子版
 */
$("#attach").fileinput({
    language: 'zh',//中文
    uploadUrl:"upLoadOne.do",//上传的地址，加上这个才会出现删除按钮
    dropZoneEnabled: false,//是否显示拖拽区域
    showUpload: false, //是否显示上传按钮,跟随文本框的那个
    showRemove : true, //显示移除按钮,跟随文本框的那个
    showCaption: true,//是否显示标题,就是那个文本框
    showClose:false,//显示关闭按钮
    uploadAsync:true,//是否异步
    layoutTemplates:{//预览区域删除按钮与上传按钮的显示
        actionUpload:''//上传按钮不显示
    },
    enctype: 'multipart/form-data',
    previewSettings: {//限制预览区域的宽高
        pdf: {width: "0px", height: "0px"},
        other: {width: "0px", height: "0px"}
    },
    previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
    uploadExtraData: function (previewId, index) {//携带其他一些数据的格式
        var data = {
        	applyId:$("#hidden_apply_id").val(),
        	attachType:'1'
        };
        return data;
    },
    validateInitialCount:true,
    allowedFileExtensions: ['pdf','doc','docx']//允许上传问价你的后缀
}).on('filepreupload', function(event, data, previewId, index) {
    var form = data.form, files = data.files, extra = data.extra,
        response = data.response, reader = data.reader;
    	saveAtta = false;
}) .on("fileuploaded", function(event, data) {//上传成功之后的一些处理
        if(data.response)
        {	
        	saveAtta = true;
        	if(saveScan&&saveAtta){
        		alert("上传成功!");
        		window.location.href=contextPath+"/admin/environment/enApplyInfo_list.jsp";
        	}
        }
    });
/***E   上传文件相关操作****/



/* E   QLQ 2018.02.05 */



</script>
</body>
</html>