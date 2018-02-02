<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.tyust.common.DateHandler" %>
<%
	String pbsApplyId = request.getParameter("pbsApplyId");
%>
<!DOCTYPE html>
<html>
<head>
	<title>屏蔽室申请</title>
	<jsp:include page="../common/include-commonNew.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/webuploader/css/webuploader.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/webuploader/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/lightbox/css/lightbox.min.css" />	
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
            <h3 class="box-title">屏蔽室检测报告</h3>
          </div><!-- /.box-header -->

          <div class="box-body pad">
            <div class="row">
              <div class="col-md-8 col-md-offset-2">
              
            <div class="box box-info">
             <div class="box-header with-border">
                <h3 class="box-title">基本信息</h3>
             </div>
            <div class="box-body">
             <form id="pbsTestReportForm" class="form-horizontal">
             	
             	<!-- 隐藏项 :屏蔽室申请ID-->
             	<input type="hidden" name="pbsTestReport.pbsApplyId" value="<%=pbsApplyId%>">
            	<div class="row">
             	 <div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">报告编号</label>
                    <div class="col-sm-8">
                      <input name="pbsTestReport.testReportNumber" type="text" class="form-control">
                    </div>
                  </div>
             	</div>
              	<div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">检测日期</label>
                    <div class="col-sm-8">
                      <input name="pbsTestReport.testDate" type="text" class="form-control" value="<%= DateHandler.dateToString(new Date()) %>"
                      onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})">
                    </div>
                 </div>
              	</div>
               </div>

             <div class="row">
              	<div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">检测人</label>
                    <div class="col-sm-8">
                      <input name="pbsTestReport.testUserName" type="text" class="form-control">
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
              <h3 class="box-title">检测报表扫描照片</h3>
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
            
            </div>
           </div>   
          </div><!-- /.box-body -->
          
          <div class="box-footer">
          	<center>
		      <button id="save"  class="btn btn-default">保存</button>
              <button id="submit" style="margin-left:20px;" class="btn btn-info">提交</button>
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
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/dist/webuploader.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/upload_pbsTestReport.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/lightbox/js/lightbox-plus-jquery.min.js"></script>
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
	if(fileNum != 0) {
		ok = true;
	}
	return ok;
}
function saveInfo(){
	$.ajax({
		url : '<%=request.getContextPath()%>/pbsTestReport_savePbsTestReport.do',
		type : 'POST',
		dataType : 'json',
		data : $("#pbsTestReportForm").serializeArray(),
		success : function(data){
			var data = eval(data);
			if (data.result == "success") {
				var num = uploader.getFiles().length;
				var url = "<%=request.getContextPath()%>/pbsTestReport_saveImage.do?pbsApplyId=<%=pbsApplyId%>";
				uploader.option('server',url);
				uploader.upload();
				uploader.on( 'uploadSuccess', function( file ) {
					// 页面跳转
					num = num - 1;
					if (num == 0){
						window.location.href = 'test_report_list.jsp';
					}
				});
			}
		},
		error : function(data){
			alert("error");
		}
	});
}
</script>
</body>
</html>