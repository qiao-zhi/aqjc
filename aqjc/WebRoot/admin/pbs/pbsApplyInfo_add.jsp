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
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/plugins/select2/select2.css">
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/webuploader/css/webuploader.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/webuploader/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/lightbox/css/lightbox.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/css/fileinput.min.css" />
    <script src="<%=request.getContextPath() %>/controls/JCalendar/WdatePicker.js"></script>	
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
            <h3 class="box-title">屏蔽室检测申请</h3>
          </div><!-- /.box-header -->

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
                      <div class="col-sm-8" style="padding-top:5px;font-size:15px;">
                      	<select id="pbsApplyUnitName" name="pbsApplyInfo.pbsApplyUnitId" class="form-control select2" style="width: 100%;">
                      		
                    	</select>
                      </div>
                      </div>
                  </div>
                  <div class="col-sm-6">
                   <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">申请日期</label>
                    <div class="col-sm-8">
                      <input id="pbsApplyDate" name="pbsApplyInfo.pbsApplyDate" type="text" class="form-control" value="<%= DateHandler.dateToString(new Date()) %>"
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
                      <input name="pbsApplyInfo.pbsApplyUserId" value="<%=user.getUserId() %>" type="hidden">
                      <input name="pbsApplyInfo.pbsApplyUserName" type="text" class="form-control" value="<%=user.getName() %>">
                    </div>
                    </div>
                   </div>
                   <div class="col-sm-6">
                     <div class="form-group">
                     <label for="input1" class="col-sm-4 control-label">联系方式</label>
                      <div class="col-sm-8">
                       <input type="text" name="pbsApplyInfo.pbsApplyTel" class="form-control" value="<%=user.getTelephone() %>">
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
                <h3 class="box-title">申请书扫描照片PDF文件</h3>
              </div>
              <div class="box-body">
         		<div id="container">
             	 <form id="attach_form1" enctype="multipart/form-data">
              	 	<input id="attach_pbsApplyId1" name="pbsApplyInfo.pbsApplyId" type="hidden"/>
              	 	<input name="pbsAttach.pbsAttachType" type="hidden" value="1"/>
					<input id="attach1" name="pbsApplyInfoAttach" class="file" type="file" multiple data-min-file-count="1">
				</form>
               </div>
              </div>
            </div>
            
            <div class="box box-info">
              <div class="box-header with-border">
                <h3 class="box-title">申请书电子版</h3>
              </div>
              <div class="box-body">
              	 <form id="attach_form2" enctype="multipart/form-data">
              	 	<input id="attach_pbsApplyId2" name="pbsApplyInfo.pbsApplyId" type="hidden"/>
              	 	<input name="pbsAttach.pbsAttachType" type="hidden" value="2"/>
					<input id="attach2" name="pbsApplyInfoAttach" class="file" type="file" multiple data-min-file-count="1">
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
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/upload_pbsApplyInfo.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/lightbox/js/lightbox-plus-jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/js/fileinput.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/js/fileinput_locale_zh.js"></script>
<script src="<%=request.getContextPath() %>/controls/JCalendar/WdatePicker.js"></script>

<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/select2/select2.full.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/dist/js/app.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/dist/js/demo.js"></script>
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
				optionStr += "<option value="+data[i].unitId+">"+data[i].unitName+"</option>";
			}
			$("#pbsApplyUnitName").append(optionStr);
		},
		error : function(data){
			alert("error");
		}
	});
}


function  isOK(){
	var ok = false;
	var attach1 = $("#attach1").val();
	var attach2 = $("#attach2").val();
	if (attach1 == "") {
		alert("请添加PDF");
	}
	if (attach2 == ""){
		alert("请添加附件");
	}
	if(attach1 != "" && attach2 != "") {
		ok = true;
	}
	return ok;
}

function saveInfo(){
	$.ajax({
		url : '<%=request.getContextPath()%>/pbsApplyInfo_savePbsApplyInfo.do',
		type : 'POST',
		dataType : 'json',
		data : $("#pbsApplyInfo_form").serializeArray(),
		success : function(data){
			var data = eval(data);
			alert("保存成功");
			if (data.result == "success"){
				var pbsApplyId = data.pbsApplyId;
				fileUpload1(pbsApplyId);
				fileUpload2(pbsApplyId);
			}
		},
		error : function(data){
			alert("error");
		}
	});
}

//附件上传功能:传入申请id作为参数
function fileUpload1(id){
	//设置屏蔽室申请ID
	$("#attach_pbsApplyId1").val(id);
	var formData = new FormData($('#attach_form1')[0]);
	$.ajax({
	       url: '<%=request.getContextPath()%>/pbsApplyInfo_saveAttach.do',
	       data: formData,
	       async: false,
	       contentType: false,
	       processData: false,
	       cache: false,
	       type: 'post',
	       success: function(data) {
	       },
	       error : function(){
	    	   alert("附件上传失败，请重试！");
	       }
	   });
}

function fileUpload2(id){
	//设置屏蔽室申请ID
	$("#attach_pbsApplyId2").val(id);
	var formData = new FormData($('#attach_form2')[0]);
	$.ajax({
	       url: '<%=request.getContextPath()%>/pbsApplyInfo_saveAttach.do',
	       data: formData,
	       async: false,
	       contentType: false,
	       processData: false,
	       cache: false,
	       type: 'post',
	       success: function(data) {
	    	   alert("操作成功！");
	    	   window.location.href = 'apply_list.jsp';
	       },
	       error : function(){
	    	   alert("附件上传失败，请重试！");
	       }
	   });
}

//准备附件上传的样式
$("#attach1").fileinput({
	  language : 'zh',
	  showUpload: false, //是否显示上传按钮
      allowedFileExtensions : ['pdf']
   });
   
$("#attach2").fileinput({
	  language : 'zh',
	  showUpload: false, //是否显示上传按钮
      allowedFileExtensions : ['doc', 'docx']
 });
 
//Initialize Select2 Elements
$(".select2").select2();
</script>
</body>
</html>