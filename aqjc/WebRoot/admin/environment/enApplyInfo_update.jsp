<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.tyust.bean.user.TBaseUserInfo" %>
<%@ page import="com.tyust.bean.unit.TBaseUnitInfo" %>
<%@ page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.tyust.dao.unit.IunitDao"%>
<%@ page import="com.tyust.dao.user.IuserDao"%>
<%@ page import="java.util.*,com.tyust.common.DateHandler" %>
<%
	ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
	
	String enApplyId = request.getParameter("enApplyId");
	String enApplyUnitId = request.getParameter("enApplyUnitId");
	String enApplyUserId = request.getParameter("enApplyUserId");
	// 获取申请部门信息
	IunitDao unitDao = (IunitDao)context.getBean("Unit");
	TBaseUnitInfo unit = unitDao.findUnit(enApplyUnitId);
	// 获取申请人信息
	IuserDao userDao = (IuserDao)context.getBean("User");
	List<TBaseUserInfo> userList = new ArrayList<TBaseUserInfo>();
	userList = userDao.selectUserInfoById(enApplyUserId);
	TBaseUserInfo user = userList.get(0);
	
%>
<%@include file="/public/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>屏蔽室申请</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/font-awesome-4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/ionicons-2.0.1/css/ionicons.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/dist/css/AdminLTE.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/plugins/iCheck/flat/blue.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/dist/css/skins/skin-blue.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/webuploader/css/webuploader.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/webuploader/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/lightbox/css/lightbox.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/css/fileinput.min.css" />
	<style>
		.dataTab input{width:220px;height:23px;}
		.dataTab select{width:110px;height:22px;}
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
          </div><!-- /.box-header -->

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
                      	<!-- 隐藏申请单位信息 -->
                      	<input name="enApplyInfo.environmentApplyUnitId" id="enApplyUnitId" type="hidden">
                        
							<!-- 申请单位下拉列表 -->
							<select id="unitSelect" class="form-control"
								onchange="changeUnit()">
							</select>
                        
                      </div>
                      </div>
                    </div>
                <div class="col-sm-6">
                  <div class="form-group">
                    <label for="pbsApplyDate" class="col-sm-4 control-label">申请日期</label>
                    <div class="col-sm-8">
                      <input id="enApplyDate" name="enApplyInfo.environmentApplyDate" type="text" class="form-control"
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
                      <input name="enApplyInfo.environmentApplyUserId" value="<%=enApplyUserId %>" type="hidden">
                      <input id="enApplyUserName" name="enApplyInfo.environmentApplyUserName" type="text" class="form-control" value="<%=user.getName() %>">
                    </div>
                    </div>
                   </div>
                   <div class="col-sm-6">
                     <div class="form-group">
                     <label for="enApplyTel" class="col-sm-4 control-label">联系方式</label>
                      <div class="col-sm-8">
                       <input id="enApplyTel" type="text" name="enApplyInfo.environmentApplyTel" class="form-control">
                     </div>
                    </div>
                  </div>
                </div>
                
                <div class="row">
                  <div class="col-sm-6">
                    <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">样品名称</label>
                    <div class="col-sm-8">
                      <input id="enApplySamply" name="enApplyInfo.environmentApplySamply" type="text" class="form-control">
                    </div>
                    </div>
                   </div>
                   <div class="col-sm-6">
                     <div class="form-group">
                     <label for="input1" class="col-sm-4 control-label">生产单位</label>
                      <div class="col-sm-8">
                       <input id="enApplyProduction" type="text" name="enApplyInfo.environmentApplyProduction" class="form-control">
                     </div>
                    </div>
                  </div>
                </div>
                
                <div class="row">
                  <div class="col-sm-12">
                    <div class="form-group">
                    <label for="input1" class="col-sm-2 control-label">申请意见</label>
                    <div class="col-sm-10">
                      <textarea id="enApplyOpinion" name="enApplyInfo.environmentApplyOpinion" class="textarea333" placeholder="请填写申请意见" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
                    </div>
                    </div>
                   </div>
                </div>
                
                <!-- 环境检测申请id -->
                <input type="hidden" id="enApplyId" name="enApplyInfo.environmentApplyId" value="<%=enApplyId%>">
                <!-- 隐藏 操作：保存与提交-->
                <input type="hidden" id="operate" name="operate" value="save"/>
                </form>
             </div>
            </div>
            
<!--             <div class="box box-info">
              <div class="box-header with-border">
                <h3 class="box-title">申请书扫描附件</h3>
              </div>
              <div class="box-body">
         		<div class="container" id="pic">
             	 	
               </div>

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
            
            
            
            <div class="box box-info">
              <div class="box-header with-border">
                <h3 class="box-title">申请书扫描附件</h3>
                <!-- 隐藏该申请书电子版附件的主键 -->
                <input type="hidden" id="hidden_scan_id">
              </div>
              <div class="box-body">
				<form enctype="multipart/form-data" id="scanFileForm" style="display:none;">
					<input id="bootUpOne" class="file" type="file"
						name="fileName">
				</form>
              	
              	 <div class="row" id="scanDiv">
              	 	<div class="col-sm-8">
              			<div id="scanFile"></div>
              		</div>
         		    <div class="col-sm-4">
              			<button style="float:right;" id="delScanFile" class="btn btn-info" onclick="deleteAttach('3')">删除</button>
              		</div>
              	 </div>
              </div>
            </div>
            
            
            <div class="box box-info">
              <div class="box-header with-border">
                <h3 class="box-title">申请书电子版</h3>
                <!-- 隐藏该申请书电子版附件的主键 -->
                <input type="hidden" id="hidden_attach_id">
              </div>
              <div class="box-body">
				<form id="attach_form" style="display:none;">
					<input id="attach" name="fileName" class="file"
						type="file" multiple data-min-file-count="1">
				</form>              	
              	 <div class="row" id="attachDiv">
              	 	<div class="col-sm-8">
              			<div id="fileName"></div>
              		</div>
              		<div class="col-sm-4">
              			<button style="float:right;" id="delAttach" class="btn btn-info" onclick="deleteAttach('1')">删除</button>
              		</div>
              	 </div>
              </div>
            </div>
            </div>
           </div>   
          </div><!-- /.box-body -->
          <div class="box-footer" style="text-align:center">
		      <button id="save" type="button" class="btn btn-default">保存</button>
              <button id="submit" type="button" style="margin-left:20px;" class="btn btn-info">提交</button>
		  </div>
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
<script src="<%=request.getContextPath() %>/newStyle/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/jquery.js"></script> --%>
<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/dist/webuploader.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/upload_enApplyInfo.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/lightbox/js/lightbox-plus-jquery.min.js"></script> --%>
<%-- <script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/js/fileinput.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/js/fileinput_locale_zh.js"></script> --%>
<script src="<%=request.getContextPath() %>/controls/JCalendar/WdatePicker.js"></script>

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


<!-- S QLQ -->
<script>
var hasUploadAttach = true;//标记附件是否上传
var hasUploadScan = true; //标记扫描文件是否上传
$(document).ready(function(){
	//查询申请信息
	showEnApplyInfo();
	//显示扫描附件信息
	showEnAttach('3');
	//显示申请书附件
	showEnAttach('1');
});
// 显示屏蔽室申请信息
function showEnApplyInfo() {
	$.ajax({
		url : '${pageContext.request.contextPath}/enApplyInfo_selEnApplyInfoById.do',
		data : {'enApplyId' : '<%= enApplyId%>'},
		type : 'POST',
		dataType : 'json',
		success : function(response) {
			var info = eval(response);
			$("#enApplyDate").val(info.enApplyDate);
			$("#enApplyUnitId").val(info.enApplyUnitId);
			$("#enApplyUserName").val(info.enApplyUserName)
			$("#enApplyTel").val(info.enApplyTel);
			$("#enApplySamply").val(info.enApplySamply);
			$("#enApplyProduction").val(info.enApplyProduction);
			$("#enApplyOpinion").val(info.enApplyOpinion);
			loadUnitName();
		}
	});
}



/**
查询附件信息
**/
function showEnAttach(attachType){
	$.ajax({
		url : '${pageContext.request.contextPath}/enApplyInfo_selEnAttach.do',
		data : {'enApplyId' : '<%= enApplyId%>',
				'enAttachType' : attachType	
		},
		type : 'POST',
		dataType : 'json',
		success : function(response) {
			var info = eval(response);
			var isNull = info.isNull;
			if (isNull == 0) {//如果为空的话
				displayBootstraoControl();
			} else {//如果文件不为空的话
				var url = info.fileUrl;
				var fileName = info.fileName;
				var enAttachId = info.enAttachId;
				var URL='/file/'+url;
				//如果是扫描附件
				if(attachType == '3'){
					$("#hidden_scan_id").val(enAttachId);//向隐藏的扫描附件赋值
					$("#scanFile").append("<a target='_blank' href='"+URL+"'>"+fileName+"</a>");
				}else{//如果是申请书电子版
					$("#hidden_attach_id").val(enAttachId);//向隐藏的申请附件赋值
					$("#fileName").append("<a target='_blank' href='"+URL+"'>"+fileName+"</a>");
				}
				displayBootstraoControl();
			}
		}
	});
}

//加载部门名称
function loadUnitName(){
	$.ajax({
		url : '<%=request.getContextPath()%>/loadUnitName.do',
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				var data = eval(data);
				var optionStr = "";
				for (var i = 0; i < data.length; i++) {
					optionStr += "<option value='" + data[i].unitId + "'";
					//动态设置哪个选中
					if ($("#enApplyUnitId").val() == data[i].unitId) {
						optionStr += " selected='selected' ";
					}
					optionStr += ">" + data[i].unitName + "</option>";
				}
				$("#unitSelect").append(optionStr);
			},
			error : function(data) {
				alert("error");
			}
		});
	}
	
/*********************S   保存*****************/
$(document).ready(function(){
	//保存信息
	$("#save").click(function (){
		$("#operate").val("save");
		if(confirm("您确认保存申请信息?")){
			saveInfo();
		}	
	});
	//提交信息
	$("#submit").click(function (){
		$("#operate").val("submit");
		var o = isOK();
		if (o == true){
			if (validate()){
				alert("请完善信息");
				return;
			}
			if(confirm("您确认提交信息?提交之后不可以修改!")){
				saveInfo();
			}
		}else{
			alert("请先上传附件!");
		}
	});
});

function isOK(){
	return hasUploadScan && hasUploadAttach;
}

function validate(){
	if($("#enApplyUserName").val() == "") {
		return true;
	}
	if($("#enApplyTel").val() == ""){
		return true;
	}
	if($("#enApplySamply").val() == ""){
		return true;
	}
	if($("#enApplyProduction").val() == "") {
		return true;
	}
	if(!hasUploadScan){
		return true;
	}
	if(!hasUploadAttach){
		return true;
	}
}

function saveInfo(){
	$.ajax({
		url : '<%=request.getContextPath()%>/enApplyInfo_saveEnApplyInfo.do',
		type : 'POST',
		dataType : 'json',
		data : $("#enApplyInfo_form").serializeArray(),
		success : function(data){
			alert("保存成功!")
		},
		error : function(data){
			alert("error");
		}
	});
}	
/*********************S   保存*****************/	
	
/**
 * 获取下拉菜单的单位信息给隐藏的值赋值
 */
function changeUnit(){
	var opt = $("#unitSelect option:selected");
	var value = opt.val();
	$("[name='enApplyInfo.environmentApplyUnitId']").val(value);//向隐藏的单位ID赋值	
}


// 根据附件编号删除附件
function deleteAttach(attachType){
	if(!confirm("您确认删除该文件并进行修改?")){
		return;
	}
	var enAttachId = "";
	if(attachType == '1'){//删除附件
		enAttachId = $("#hidden_attach_id").val();
	}else{//删除扫描件
		enAttachId = $("#hidden_scan_id").val();
	}
	$.ajax({
		url : '${pageContext.request.contextPath}/enApplyInfo_delEnAttach.do',
		type : 'POST',
		data : {'enAttachId' : enAttachId},
		dataType : 'json',
		success : function (data){
			var data = eval(data);
			if (data.result == 'success'){
				if(attachType == '1'){//删除附件之后
					$("#attachDiv").css("display","none");
					$("#attach_form").css("display","block");
					hasUploadScan = false;//将上传标记标记为false
					
				  }else{//删除扫描件之后
					 $("#scanDiv").css("display","none");
					 $("#scanFileForm").css("display","block");
					 hasUploadAttach = false;//将上传标记标记为false
				}
			}
		},
		error : function (){
			alert("删除附件失败");
		}
	});
}

function displayBootstraoControl(){
	var hidden_attach_id = $("#hidden_attach_id").val();
	var hidden_scan_id = $("#hidden_scan_id").val();
	//判断附件显示的控件信息
	if(hidden_attach_id == null || ""==hidden_attach_id){//如果为空证明未上传文件
		$("#attachDiv").css("display","none");
		$("#attach_form").css("display","block");
		 hasUploadAttach = false ;
	}else{
		$("#attachDiv").css("display","block");
		$("#attach_form").css("display","none");
		 hasUploadAttach = true ;
	}
	//判断扫描件显示的控件信息
	if(hidden_scan_id == null || ""==hidden_scan_id){//如果为空证明未上传文件
		$("#scanDiv").css("display","none");
		$("#scanFileForm").css("display","block");
		 hasUploadScan = false ;
	}else{
		$("#scanDiv").css("display","block");
		$("#scanFileForm").css("display","none");
		 hasUploadScan = true ;
	}
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
    showUpload: true, //是否显示上传按钮,跟随文本框的那个
    showRemove : false, //显示移除按钮,跟随文本框的那个
    showCaption: true,//是否显示标题,就是那个文本框
    uploadAsync:true,
    enctype: 'multipart/form-data',
    layoutTemplates:{//预览区域删除按钮与上传按钮的显示
        actionUpload:''//上传按钮不显示
   },
    previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
    uploadExtraData: function (previewId, index) {//携带其他一些数据的格式
        var data = {
        		applyId:$("#enApplyId").val(),
       			attachType:'3'
        };
        return data;
    },
    validateInitialCount:true,
    allowedFileExtensions: ['pdf']//允许上传问价你的后缀
}).on('filepreupload', function(event, data, previewId, index) {//文件上传之前的操作
    var form = data.form, files = data.files, extra = data.extra,
        response = data.response, reader = data.reader;
}) .on("fileuploaded", function(event, data) {//上传成功之后的一些处理
        if(data.response)
        {	
        	saveInfo();//文件上传之后临时保存修改的信息
        	//重新执行查询文件
        	window.location.reload(); //上传成功之后局部刷新页面 
        }
    });

/**
 * 上传申请书电子版
 */
$("#attach").fileinput({
    language: 'zh',//中文
    uploadUrl:"upLoadOne.do",//上传的地址，加上这个才会出现删除按钮
    dropZoneEnabled: false,//是否显示拖拽区域
    showUpload: true, //是否显示上传按钮,跟随文本框的那个
    showRemove : true, //显示移除按钮,跟随文本框的那个
    showCaption: true,//是否显示标题,就是那个文本框
    uploadAsync:true,
    enctype: 'multipart/form-data',
    previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
    uploadExtraData: function (previewId, index) {//携带其他一些数据的格式
        var data = {
        	applyId:$("#enApplyId").val(),
        	attachType:'1'
        };
        return data;
    },
    validateInitialCount:true,
    layoutTemplates:{//预览区域删除按钮与上传按钮的显示
        actionUpload:''//上传按钮不显示
   },
    allowedFileExtensions: ['pdf','doc','docx'],//允许上传问价你的后缀
}).on('filepreupload', function(event, data, previewId, index) {
    var form = data.form, files = data.files, extra = data.extra,
        response = data.response, reader = data.reader;
}) .on("fileuploaded", function(event, data) {//上传成功之后的一些处理
        if(data.response)
        {
        	saveInfo();//文件上传之后临时保存修改的信息
        	window.location.reload(); //上传成功之后局部刷新页面 
        }
    });
/***E   上传文件相关操作****/




</script>
<!-- E QLQ -->

<script>
</script>
</body>
</html>