<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.tyust.common.DateHandler" %>
<%
	String pbsTestReportId = request.getParameter("pbsTestReportId");
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
             	<input type="hidden" id="pbsApplyId" name="pbsTestReport.pbsApplyId">
             	<!-- 屏蔽室检测报告ID -->
             	<input type="hidden" id="pbsTestReportId" name="pbsTestReport.pbsTestReportId">
            	<div class="row">
             	 <div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">报告编号</label>
                    <div class="col-sm-8">
                      <input id="testReportNumber" name="pbsTestReport.testReportNumber" type="text" class="form-control">
                    </div>
                  </div>
             	</div>
              	<div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">检测日期</label>
                    <div class="col-sm-8">
                      <input id="testDate" name="pbsTestReport.testDate" type="text" class="form-control" value="<%= DateHandler.dateToString(new Date()) %>"
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
                      <input id="testUserName" name="pbsTestReport.testUserName" type="text" class="form-control">
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
       	<div class="container" id="pic">
        </div>
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
		      <button id="save" type="submit" class="btn btn-default">保存</button>
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
	// 加载信息
	var picCount = 0;//图片数量
	loadInfo();
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
	alert(picCount);
	
	if (fileNum == 0 && picCount == 0){
		alert("请添加图片");
	}
	if(fileNum != 0 || picCount != 0) {
		ok = true;
	}
	return ok;
}

function loadInfo(){
	$.ajax({
		url : '<%=request.getContextPath()%>/pbsTestReport_queryPbsTestReport.do?pbsTestReportId=<%=pbsTestReportId%>',
		type : 'POST',
		dataType :'json',
		success : function(data){
			var data = eval(data);
			$("#pbsTestReportId").val(data.pbsTestReportId);
			$("#pbsApplyId").val(data.pbsApplyId);
			$("#testReportNumber").val(data.testReportNumber);
			$("#testUserName").val(data.testUserName);
			$("#testDate").val(data.testDate);
			var pbsApplyId = data.pbsApplyId;
			showPbsPic(pbsApplyId);
		},
		error :function(){
			alert("加载数据错误");
		}
	});
}

function saveInfo(){
	$.ajax({
		url : '<%=request.getContextPath()%>/pbsTestReport_updatePbsTestReport.do',
		type : 'POST',
		dataType : 'json',
		data : $("#pbsTestReportForm").serializeArray(),
		success : function(data){
			// 设置图片上传的url
			var data = eval(data);
			if (data.result == "success") {
				var num = uploader.getFiles().length;
				alert("保存成功");
				if(num == 0)
					window.location.href = 'test_report_list.jsp';
				else{
					var pbsApplyId = $("#pbsApplyId").val();
					var url = "<%=request.getContextPath()%>/pbsTestReport_saveImage.do?pbsApplyId="+pbsApplyId;
					uploader.option('server',url);
					uploader.upload();
					uploader.on( 'uploadSuccess', function( file ) {
						// 页面跳转
						num = num - 1;
						if (num == 0){
							window.location.href = 'test_report_list.jsp';
						}
					});//uploader.on end!
				}//num!=0 end!
			}
		},//success processing over!
		error : function(data){
			alert("保存失败");
		}
	});
};

function showPbsPic(pbsApplyId){
	$.ajax({
		url : '${pageContext.request.contextPath}/pbsApplyInfo_selPbsPic.do',
		data : {'pbsApplyId' : pbsApplyId,
				'pbsPicType' :'2'},
		type : 'POST',
		dataType : 'json',
		success : function(response) {
			var pic = eval(response);
			var len = pic.length;
			picCount  = len;
			var a = len / 3;
			var row = parseInt(a);
			if(a > row){
				row = row + 1;
			}
			for(var i = 0;i < row;i++){
				var str  = "<div class='row'>";
				for(var j = 0;j<3;j++){
					var index = i*3+j;
					if(index < len){
						var ind = new Number(index);
						var url = pic[ind].pbsPicUrl;
						var id = pic[ind].pbsPicId;
						str = str + "<div class='col-sm-4' id='"+id+"'>";
	        			str = str + "<a href='../../uploads/pbsPic/"+url+"' data-lightbox='1'><img width='210px' height='290px' src='../../uploads/pbsPic/"+url+"'></a>";
	        			str = str + "<div class='row'>";
	        			str = str + "<div class='col-sm-2'>";
	        			str = str + "<button class='btn btn-default' onclick='delPbsPic(\""+id+"\")'>删除</button>";
	        			str = str + "</div>"
	        			str = str + "</div>";
	        			str = str + "</div>";
					}
				}
    			str = str + "</div>";
    			$("#pic").append(str);
			}
		}
	});
};

function delPbsPic(pbsPicId){
	var con = confirm("确认删除该图片吗？");
	if (con == true) {
		$.ajax({
			url : '${pageContext.request.contextPath}/pbsApplyInfo_delImage.do',
			data : {'pbsPicId' : pbsPicId},
			type : 'POST',
			dataType : 'json',
			success : function (data){
				var data = eval(data);
				if (data.result == "success"){
					// 删除节点
					$("#"+pbsPicId).empty();
					picCount = picCount - 1;
				} else {
					alert("删除图片失败！");
				}
			},
			error : function (){
				alert("删除图片失败！");
			}
		});
	}
}
</script>
</body>
</html>