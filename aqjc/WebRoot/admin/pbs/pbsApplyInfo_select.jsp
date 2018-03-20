<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.tyust.bean.user.TBaseUserInfo"%>
<%@ page import="com.tyust.bean.unit.TBaseUnitInfo"%>
<%@ page
	import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.tyust.dao.unit.IunitDao"%>
<%@ page import="com.tyust.dao.user.IuserDao"%>
<%@ page import="java.util.*,com.tyust.common.DateHandler"%>
<%@include file="/public/tag.jsp"%>
<%
	ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
	
	String pbsApplyId = request.getParameter("pbsApplyId");
	String pbsApplyUnitId = request.getParameter("pbsApplyUnitId");
	String pbsApplyUserId = request.getParameter("pbsApplyUserId");
	// 获取申请部门信息
	IunitDao unitDao = (IunitDao)context.getBean("Unit");
	TBaseUnitInfo unit = unitDao.findUnit(pbsApplyUnitId);
	
%>
<!DOCTYPE html>
<html>
<head>
<title>屏蔽室申请</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">

<%-- <link rel="stylesheet"	href="<%=request.getContextPath() %>/newStyle/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"	href="<%=request.getContextPath() %>/newStyle/font-awesome-4.5.0/css/font-awesome.min.css">
<link rel="stylesheet"	href="<%=request.getContextPath() %>/newStyle/ionicons-2.0.1/css/ionicons.min.css">
<link rel="stylesheet"	href="<%=request.getContextPath() %>/newStyle/dist/css/AdminLTE.min.css">
<link rel="stylesheet"	href="<%=request.getContextPath() %>/newStyle/plugins/iCheck/flat/blue.css">
<link rel="stylesheet"	href="<%=request.getContextPath() %>/newStyle/dist/css/skins/skin-blue.min.css">
<link rel="stylesheet"	href="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/plugins/select2/select2.css">

<link rel="stylesheet" type="text/css"	href="<%=request.getContextPath() %>/newStyle/plugins/lightbox/css/lightbox.min.css" />
<link rel="stylesheet" type="text/css" 	href="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/css/fileinput.min.css" />
 --%>
<!-- ll s -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/font-awesome-4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/ionicons-2.0.1/css/ionicons.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/dist/css/AdminLTE.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/plugins/iCheck/flat/blue.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/dist/css/skins/skin-blue.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/plugins/select2/select2.css">
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/webuploader/css/webuploader.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/webuploader/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/lightbox/css/lightbox.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/css/fileinput.min.css" />
<!-- ll e -->


<!-- ll S -->
	<script
		src="<%=request.getContextPath() %>/newStyle/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/newStyle/plugins/lightbox/js/lightbox-plus-jquery.min.js"></script>
	<%-- <script type="text/javascript"
		src="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/js/fileinput.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/js/fileinput_locale_zh.js"></script>
 --%>	<script
		src="<%=request.getContextPath() %>/controls/JCalendar/WdatePicker.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath() %>/newStyle/plugins/select2/select2.full.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/dist/js/app.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/dist/js/demo.js"></script>

	<!--S bootstrapFileiput的JS  -->
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

	<!--E bootstrapFileiput的JS  -->

<!-- ll E -->
	
	<!-- S    ll引入的bootstrapFileinput的CSS -->
	<link rel="stylesheet" type="text/css"
		href="${baseurl}/bootstrapFileinput/css/default.css">
	<link href="${baseurl}/bootstrapFileinput/css/fileinput.css" media="all"
		rel="stylesheet" type="text/css" />
	<!-- E   ll引入的bootstrapFileinput的CSS -->s
	
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
								<h3 class="box-title">屏蔽室检测申请</h3>
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
												<form id="pbsApplyInfo_form" class="form-horizontal">
													<div class="row">
														<div class="col-sm-6">
															<div class="form-group">
																<label for="input1" class="col-sm-4 control-label">申请单位</label>
																<div class="col-sm-8">
																	<select id="pbsApplyUnitName"
																		name="pbsApplyInfo.pbsApplyUnitId" 
																		class="form-control" style="width: 100%;font-size:14px;">
																	</select>
																</div>
															</div>
														</div>
														<div class="col-sm-6">
															<div class="form-group">
																<label for="pbsApplyDate" class="col-sm-4 control-label">申请日期</label>
																<div class="col-sm-8">
																	<input id="pbsApplyDate"
																		name="pbsApplyInfo.pbsApplyDate" type="text"
																		class="form-control"
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
																	<input name="pbsApplyInfo.pbsApplyUserId"
																		value="<%=pbsApplyUserId %>" type="hidden"> <input
																		id="pbsApplyUserName"
																		name="pbsApplyInfo.pbsApplyUserName" type="text"
																		class="form-control">
																</div>
															</div>
														</div>
														<div class="col-sm-6">
															<div class="form-group">
																<label for="pbsApplyTel" class="col-sm-4 control-label">联系方式</label>
																<div class="col-sm-8">
																	<input id="pbsApplyTel" type="text"
																		name="pbsApplyInfo.pbsApplyTel" class="form-control">
																</div>
															</div>
														</div>
													</div>
													
													<!--S 新增字段 ll -->
									                <div class="row">
									                  <div class="col-sm-6">
									                    <div class="form-group">
									                    <label for="input1" class="col-sm-4 control-label">生产单位</label>
									                    <div class="col-sm-8">
									                       <input id="pbsApplyProduction" name="pbsApplyInfo.pbsApplyProduction" type="text" class="form-control" >
									                    </div>
									                    </div>
									                   </div>
									                   <div class="col-sm-6">
									                     <div class="form-group">
									                     <label for="input1" class="col-sm-4 control-label">评测等级</label>
									                      <div class="col-sm-8">
									                       <select id="pbsApplyGrade" class="form-control" name="pbsApplyInfo.pbsApplyGrade">
															    <option value="A">A级</option>
																<option value="B">B级</option>
																<option value="C" selected>C级</option>
																<option value="D">D级</option>
															</select>
									                     </div>
									                    </div>
									                  </div>
									                </div>
									                
									                <div class="row">
														<div class="col-sm-12">
															<div class="form-group">
																<label for="input1" class="col-sm-2 control-label">申请意见</label>
																<div class="col-sm-10">
																	<textarea id="pbsApplyOpinion" name="pbsApplyInfo.pbsApplyOpinion" class="textarea333" placeholder="请填写申请意见" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
																</div>
															</div>
														</div>
													</div>
									                <!--D 新增字段 ll -->
													
													<!-- 屏蔽室申请id -->
													<input type="hidden" id="pbsApplyId"
														name="pbsApplyInfo.pbsApplyId" value="<%=pbsApplyId%>">
													<!-- 隐藏 操作：保存与提交-->
													<input type="hidden" id="operate" name="operate"
														value="save" />
												</form>
											</div>
										</div>

										<div class="box box-info">
											<div class="box-header with-border">
												<h3 class="box-title">申请书扫描照片PDF文件</h3>
												<button type="button" class="btn btn-info" title="点击进行文件扫描" onclick="window.open('${baseurl}/admin/scanner_file.jsp')">扫描</button>
											</div>
											<div class="box-body">
												<div class="row" id="file1">
													<div class="col-sm-8">
														<div id="fileName1"></div>
													</div>
													<div class="col-sm-4">
														<button style="float: right;" id="delAttach1"
															class="btn btn-info">删除</button>
													</div>
												</div>
											</div>
										</div>

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
														<button style="float: right;" id="delAttach2"
															class="btn btn-info">删除</button>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- /.box-body -->
							<div class="box-footer">
								<center>
									<button id="save" type="button" class="btn btn-default">保存</button>
									<button id="submit" type="button" style="margin-left: 20px;"
										class="btn btn-info">提交</button>
								</center>
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
	
	
	<script>
	$(function() {
		showPbsApplyInfo();
		showPbsAttach1();
		showPbsAttach2();
		loadUnitName();
	});
	
	//以下变量表示是否进行了附件的修改，0：未修改；1：修改
	var isAttach1 = 0;
	var isAttach2 = 0;
	
	// 显示屏蔽室申请信息
	function showPbsApplyInfo() {
		$.ajax({
			url : '${pageContext.request.contextPath}/pbsApplyInfo_selPbsApplyInfoById.do',
			data : {'pbsApplyId' : '<%= pbsApplyId%>'},
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var info = eval(response);
				$("#pbsApplyDate").val(info.pbsApplyDate);
				$("#pbsApplyUserName").val(info.pbsApplyUserName);
				$("#pbsApplyTel").val(info.pbsApplyTel);
				$("#pbsApplyProduction").val(info.pbsApplyProduction);
				$("#pbsApplyGrade").val(info.pbsApplyGrade);
				$("#pbsApplyOpinion").val(info.pbsApplyOpinion);
			}
		});
	}
	
	
	function showPbsAttach1(){
		$.ajax({
			url : '${pageContext.request.contextPath}/pbsApplyInfo_selPbsAttach.do',
			data : {'pbsApplyId' : '<%= pbsApplyId%>',
				'pbsAttachType' : '1'},
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var info = eval(response);
				var v = info[0];
				if (v == null) {
					$("#file1").empty();
					loadFileinput1();
				} else {
					var url = info[0].fileUrl;
					var fileName = info[0].fileName;
					var fileUrl = info[0].pbsAttachUrl;
					var pbsAttachId = info[0].pbsAttachId;
					//var URL = '${pageContext.request.contextPath}/pbsApplyInfo_downAttach.do?filename='+url;
					//在线预览PDF
					var URL ='/pbs/file/'+fileUrl;
					$("#fileName1").append("<a href='"+URL+"' target='_blank'>"+fileName+"</a>");
					$("#delAttach1").click(function (){
						delAttachConf(pbsAttachId,"1");
					});
				}
			}
		});
	}
	
	function showPbsAttach2(){
		$.ajax({
			url : '${pageContext.request.contextPath}/pbsApplyInfo_selPbsAttach.do',
			data : {'pbsApplyId' : '<%= pbsApplyId%>',
				'pbsAttachType' : '2'},
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
					var fileUrl = info[0].pbsAttachUrl;
					var pbsAttachId = info[0].pbsAttachId;
					//var URL = '${pageContext.request.contextPath}/pbsApplyInfo_downAttach.do?filename='+url;					
					/* //在线预览PDF
					var fileNewName = fileUrl.substring(0, fileUrl.lastIndexOf("."));					
					var URL ='/pbs/file/'+fileNewName+'.pdf'; */
					//在线预览PDF
					var URL ='/pbs/file/'+fileUrl;
					$("#fileName2").append("<a href='"+URL+"' target='_blank'>"+fileName+"</a>");
					$("#delAttach2").click(function (){
						delAttachConf(pbsAttachId,'2');
					});
				}
			}
		});
	}
	
	$(document).ready(function(){
		$("#save").click(function (){
			if(confirm("您确认保存申请信息?保存之后可以修改")){
				$("#operate").val("save");
				saveInfo();
			}
		});
		$("#submit").click(function (){
			if(confirm("您确认提交申请信息吗?提交之后不可修改")){
				$("#operate").val("submit");
				if(validate()){
					alert("请完善信息！")
					return;
				}
				saveInfo();
			}
		});
	});
	
	//校验
	function validate(){
		if($("#pbsApplyDate").val() == "") {
			return true;
		}
		if($("#pbsApplyUserName").val() == ""){
			return true;
		}	
		if($("#pbsApplyProduction").val() == "") {
			return true;
		}
		if($("#pbsApplyTel").val() == ""){
			return true;
		}	
		if($("#pbsApplyOpinion").val() == "") {
			return true;
		}	
	}
	
	// 保存信息
	function saveInfo(){
		if(isAttach1 == 1){
			if($("#attach1").val() == ""){
				alert("请上传申请书扫描照片PDF文件");
				return;
			}
		}
		if(isAttach2 == 1){
			if($("#attach2").val() == ""){
				alert("请上传申请书电子版");
				return;
			}
		}
		
		$.ajax({
			url : '<%=request.getContextPath()%>/pbsApplyInfo_savePbsApplyInfo.do',
			type : 'POST',
			dataType : 'json',
			data : $("#pbsApplyInfo_form").serializeArray(),
			success : function(data){
				var data = eval(data);
				if (data.result == "success"){
					// 获取保存好的屏蔽室申请ID
					//alert("isAttach1="+isAttach1+" #attach1.val()= "+$("#attach1").val());
					//alert("isAttach2="+isAttach2+" #attach2.val()= "+$("#attach2").val());
					
					var pbsApplyId = data.pbsApplyId;
					// 附件上传
					if (isAttach1 == 1 && $("#attach1").val() != ""){
						fileUpload1(pbsApplyId);
					}
					if (isAttach2 == 1 && $("#attach2").val() != ""){
						fileUpload2(pbsApplyId);
					}
					window.location.href="apply_list.jsp";
					alert("保存成功！");
			  	}
			},
			error : function(data){
				alert("保存失败");
			}
		});
	}
	
	
	//附件上传功能:传入申请id作为参数
	function fileUpload1(id){
		var v = $("#attach1").val();
		if (v != "") {
			//设置屏蔽室申请ID
			$("#attach_pbsApplyId1").val(id);
			var formData = new FormData($('#attach_form1')[0]);
			$.ajax({
			       url: '${pageContext.request.contextPath}/pbsApplyInfo_saveAttach.do',
			       data: formData,
			       async: false,
			       contentType: false,
			       processData: false,
			       cache: false,
			       type: 'post',
			       success: function(data) {
			    	   alert("附件上传成功！");
			       },
			       error : function(){
			    	   alert("附件上传失败，请重试！");
			       }
			   });
		}
		
	}
	function fileUpload2(id){
		var v = $("#attach2").val();
		if (v != "") {
			//设置屏蔽室申请ID
			$("#attach_pbsApplyId2").val(id);
			var formData = new FormData($('#attach_form2')[0]);
			$.ajax({
			       url: '${pageContext.request.contextPath}/pbsApplyInfo_saveAttach.do',
			       data: formData,
			       async: false,
			       contentType: false,
			       processData: false,
			       cache: false,
			       type: 'post',
			       success: function(data) {
			    	   alert("附件上传成功！");
			       },
			       error : function(){
			    	   alert("附件上传失败，请重试！");
			       }
			   });
		}
	}
	
	// 确认删除附件 
	function delAttachConf(pbsAttachId,pbsAttachType){
		var con = confirm("是否确认删除附件？");
		if (con == true) {
			delAttach(pbsAttachId,pbsAttachType);
		}
	}
	
	// 根据附件编号删除附件
	function delAttach(pbsAttachId,pbsAttachType){
		$.ajax({
			url : '${pageContext.request.contextPath}/pbsApplyInfo_delAttach.do',
			type : 'POST',
			data : {'pbsAttachId' : pbsAttachId},
			dataType : 'json',
			success : function (data){
				var data = eval(data);
				if (data.result == 'success'){
					
					// 加载上传附件
					if(pbsAttachType == '1'){
						// 清空
						$("#file1").empty();
						loadFileinput1();
					} else {
						// 清空
						$("#file2").empty();
						loadFileinput2();
					}
				}
			},
			error : function (){
				alert("删除附件失败");
			}
		});
	}
	
	function loadFileinput1(){
		var dom = '<form id="attach_form1" enctype="multipart/form-data">';
  	 	dom = dom + '<input id="attach_pbsApplyId1" name="pbsApplyInfo.pbsApplyId" type="hidden"/>';
  	 	dom = dom + '<input name="pbsAttach.pbsAttachType" type="hidden" value="1"/>';
		dom = dom + '<input id="attach1" name="pbsApplyInfoAttach" class="file" type="file" multiple data-min-file-count="1">';
		dom = dom + '</form>';
		$("#file1").html(dom);
		loadStyle1();
		isAttach1 = 1;
	}
	
	function loadFileinput2(){
		var dom = '<form id="attach_form2" enctype="multipart/form-data">';
  	 	dom = dom + '<input id="attach_pbsApplyId2" name="pbsApplyInfo.pbsApplyId" type="hidden"/>';
  	 	dom = dom + '<input name="pbsAttach.pbsAttachType" type="hidden" value="2"/>';
		dom = dom + '<input id="attach2" name="pbsApplyInfoAttach" class="file" type="file" multiple data-min-file-count="1">';
		dom = dom + '</form>';
		$("#file2").html(dom);
		loadStyle2();
		isAttach2 = 1;
	}
	//准备附件上传的样式
	function loadStyle1(){
		$("#attach1").fileinput({
			language : 'zh',
		 	uploadUrl:'#',
	 	    dropZoneEnabled: false,//是否显示拖拽区域
		    showPreview:true,//是否显示预览区域
		    showUpload: false, //是否显示上传按钮
		    showCaption: true,//是否显示标题,就是那个文本框
	        allowedFileExtensions : ['pdf'],
	        layoutTemplates:{//预览区域删除按钮与上传按钮的显示
		         actionUpload:''//上传按钮不显示
		     },
	        previewSettings: {//限制预览区域的宽高
	        pdf: {width: "0px", height: "0px"}
	       }
		});
	}
	
	function loadStyle2(){
		$("#attach2").fileinput({
			language : 'zh',
			showUpload : false, //是否显示上传按钮
			allowedFileExtensions : [ 'doc', 'docx' ]
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
					if(data[i].unitId == <%=pbsApplyUnitId %>){
						optionStr += "<option value="+data[i].unitId+"  selected>"+data[i].unitName+"</option>";
					}
					else {
						optionStr += "<option value="+data[i].unitId+" >"+data[i].unitName+"</option>";
					}
				}
			
				$("#pbsApplyUnitName").append(optionStr);				
				
			},
			error : function(data){
				alert("error");
			}
		});
	}

	//Initialize Select2 Elements
	
</script>
</body>
</html>