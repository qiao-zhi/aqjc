<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.tyust.bean.user.TBaseUserInfo" %>
<%@ page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.tyust.dao.unit.IunitDao,com.tyust.bean.unit.TBaseUnitInfo"%>
<%@ page import="java.util.*,com.tyust.common.DateHandler" %>
<%
	// 获取当前用户
	TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
	ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
	// 获取用户的部门信息
	String unitId = user.getUnitId();
	IunitDao unitDao = (IunitDao)context.getBean("Unit");
	TBaseUnitInfo unit = unitDao.findUnit(unitId);
%>
<!DOCTYPE html>
<html>
<head>
	<title>环境检测申请</title>
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
                      	<!-- 隐藏 -->
                      	<input name="enApplyInfo.environmentApplyUnitId" value="<%=unit.getUnitId()%>" type="hidden">
                        <input type="text" class="form-control" value="<%=unit.getUnitName() %>">
                      </div>
                      </div>
                    </div>
                	<div class="col-sm-6">
                  		<div class="form-group">
                   			<label for="input1" class="col-sm-4 control-label">申请日期</label>
                    		<div class="col-sm-8">
                      			<input name="enApplyInfo.environmentApplyDate" type="text" class="form-control" value="<%= DateHandler.dateToString(new Date()) %>"
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
                      <input name="enApplyInfo.environmentApplyUserId" value="<%=user.getUserId() %>" type="hidden">
                      <input id="add_userName" name="enApplyInfo.environmentApplyUserName" type="text" class="form-control" value="<%=user.getName() %>">
                    </div>
                    </div>
                   </div>
                   <div class="col-sm-6">
                     <div class="form-group">
                     <label for="input1" class="col-sm-4 control-label">联系方式</label>
                      <div class="col-sm-8">
                       <input type="text" id="add_tel" name="enApplyInfo.environmentApplyTel" class="form-control" value="<%=user.getTelephone() %>">
                     </div>
                    </div>
                  </div>
                </div>
                
                <div class="row">
                  <div class="col-sm-6">
                    <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">样品名称</label>
                    <div class="col-sm-8">
                      <input id="add_samply" name="enApplyInfo.environmentApplySamply" type="text" class="form-control"/>
                    </div>
                    </div>
                   </div>
                   <div class="col-sm-6">
                     <div class="form-group">
                     <label for="input1" class="col-sm-4 control-label">生产单位</label>
                      <div class="col-sm-8">
                       <input type="text" id="add_production" name="enApplyInfo.environmentApplyProduction" class="form-control">
                     </div>
                    </div>
                  </div>
                </div>
                
                <div class="row">
                  <div class="col-sm-12">
                    <div class="form-group">
                    <label for="input1" class="col-sm-2 control-label">申请意见</label>
                    <div class="col-sm-10">
                      <textarea id="add_opinion" name="enApplyInfo.environmentApplyOpinion" class="textarea333" placeholder="请填写申请意见" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
                    </div>
                    </div>
                   </div>
                </div>
                
                <!-- 隐藏项 ：操作-提交与保存-->
                <input type="hidden" id="operate" name="operate" value="save"/>
                </form>
             </div>
            </div>
            
            <div class="box box-info">
              <div class="box-header with-border">
                <h3 class="box-title">申请书扫描照片</h3>
              </div>
              <div class="box-body">
         		<div id="container">
             	 <!--头部，相册选择和格式选择-->
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
            </div>
            
            <div class="box box-info">
              <div class="box-header with-border">
                <h3 class="box-title">申请书电子版</h3>
              </div>
              <div class="box-body">
              	 <form id="attach_form" enctype="multipart/form-data">
              	 	<input id="attach_enApplyId" name="enAttach.environmentApplyId" type="hidden"/>
              	 	<input name="enAttach.environmentAttachType" type="hidden" value="1"/>
					<input id="attach" name="attach" class="file" type="file" multiple data-min-file-count="1">
				</form>
              </div>
            </div>
            
            </div>
           </div>   
          </div><!-- /.box-body -->
          
          <div class="box-footer">
          	<center>
		      <button id="save" type="button" class="btn btn-default">保存</button>
              <button id="submit" type="button" style="margin-left:20px;" class="btn btn-info">提交</button>
		   	</center>
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
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/dist/webuploader.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/upload_enApplyInfo.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/lightbox/js/lightbox-plus-jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/js/fileinput.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/js/fileinput_locale_zh.js"></script>
<script src="<%=request.getContextPath() %>/controls/JCalendar/WdatePicker.js"></script>
<script>

//先提交表单信息，成功后返回该信息的主键，然后在保存相关的图片和附件
$(document).ready(function(){
		$("#save").click(function (){
			$("#operate").val("save");
			var o = isOK();
			if (o == true){
				saveInfo();
			}
		});
		$("#submit").click(function (){
			$("#operate").val("submit");
			var o = isOK();
			if (o == true){
				saveInfo();
			}
		});
});

function  isOK(){
	var ok = false;
	var fileNum = uploader.getFiles().length;
	if (fileNum == 0){
		alert("请添加图片");
	}
	var attach = $("#attach").val();
	if (attach == "") {
		alert("请添加附件");
	}
	if(fileNum != 0 && attach != "") {
		ok = true;
	}
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

function saveInfo(){
	if (validate()){
		alert("请完善信息");
		return;
	}
	$.ajax({
		url : '<%=request.getContextPath()%>/enApplyInfo_saveEnApplyInfo.do',
		type : 'POST',
		dataType : 'json',
		data : $("#enApplyInfo_form").serializeArray(),
		success : function(data){
			var data = eval(data);
			if (data.result == "success"){
				// 获取保存好的屏蔽室申请ID
				var num = uploader.getFiles().length;
				var enApplyId = data.enApplyId;
				// 设置图片上传的url
				var url = "<%=request.getContextPath()%>/enApplyInfo_saveEnPic.do?enApplyId="+enApplyId;
				// 图片上传
				uploader.option('server',url);
				
				uploader.upload();
				uploader.on( 'uploadSuccess', function( file ) {
					num  = num - 1;
					if (num == 0) {
						// 附件上传
						fileUpload(enApplyId);
						// 页面跳转
						window.location.href='enApplyInfo_list.jsp';
					}
				});
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


//准备附件上传的样式
$("#attach").fileinput({
	  language : 'zh',
	  showUpload: false, //是否显示上传按钮
      allowedFileExtensions : ['doc', 'docx']
   });

</script>
</body>
</html>