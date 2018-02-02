<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
                      <input id="testReportNumber" name="pbsTestReport.testReportNumber" type="text" class="form-control" readonly="readonly">
                    </div>
                  </div>
             	</div>
              	<div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">检测日期</label>
                    <div class="col-sm-8">
                      <input id="testDate" name="pbsTestReport.testDate" type="text" class="form-control" readonly="readonly">
                    </div>
                 </div>
              	</div>
               </div>

             <div class="row">
              	<div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">检测人</label>
                    <div class="col-sm-8">
                      <input id="testUserName" name="pbsTestReport.testUserName" type="text" class="form-control" readonly="readonly">
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
      </div>
            
            </div>
           </div>   
          </div><!-- /.box-body -->
        
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
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/upload.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/lightbox/js/lightbox-plus-jquery.min.js"></script>
<script>
//先提交表单信息，成功后返回该信息的主键，然后在保存相关的图片和附件
$(document).ready(function(){
	// 加载信息
	loadInfo();
	
});
function loadInfo(){
	$.ajax({
		url : '<%=request.getContextPath()%>/pbsTestReport_queryPbsTestReport.do?pbsTestReportId=<%=pbsTestReportId%>',
		type : 'POST',
		dataType :'json',
		success : function(data){
			var data = eval(data);
			console.log(data);
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
						str = str + "<div class='col-sm-4'>";
	        			str = str + "<a href='../../uploads/pbsPic/"+url+"' data-lightbox='1'><img width='210px' height='290px' src='../../uploads/pbsPic/"+url+"'></a>";
	        			str = str + "</div>";
					}
				}
    			str = str + "</div>";
    			$("#pic").append(str);
			}
		}
	});
}


</script>
</body>
</html>