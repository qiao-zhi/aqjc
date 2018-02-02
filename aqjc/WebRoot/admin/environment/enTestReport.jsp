<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String enApplyId = request.getParameter("enApplyId");
	String enTestReportId = request.getParameter("enTestReportId");
%>
<!DOCTYPE html>
<html>
<head>
	<title>屏蔽室申请</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/font-awesome-4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/ionicons-2.0.1/css/ionicons.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/dist/css/AdminLTE.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/plugins/iCheck/flat/blue.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/dist/css/skins/skin-blue.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

	<script src="<%=request.getContextPath() %>/newStyle/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/lightbox/css/lightbox.min.css" />
		
	<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/dist/js/app.min.js"></script>

	<style>
		.dataTab input{width:220px;height:23px;}
		.dataTab select{width:110px;height:22px;}
	</style>
<script>
$(function(){
	showInsTab();
	loadEnTestReport();
	loadEnTestPic1();
	loadEnTestPic2();
});

// 显示仪器
function showInsTab(){
	$.ajax({
		url : '${pageContext.request.contextPath}/ins_showEnTestReportInstrument.do',
		data : {'enTestReportId': '<%=enTestReportId%>'},
		type : 'POST',
		dataType : 'json',
		success : function(response) {
			var json = eval(response.data);
			if(json.length>0){
				for(var v=0;v<json.length;v++){
					$("#selectedInsTab").append("<tr><td><input type='hidden' name='insId' value='"+json[v].InstrumentId+"'/>"+json[v].Name+"</td>"+
							"<td>"+json[v].Model+"</td>"+
							"<td>"+json[v].Code+"</td>"+
							"<td>"+json[v].Manufacturer+"</td>"+
							"</tr>");
				}
			}
		}
	});
}

// 获取检测报告信息
function loadEnTestReport(){
	$.ajax({
		url : '${pageContext.request.contextPath}/enTestReport_selEnTestReportById.do',
		data : {'enTestReportId' : '<%=enTestReportId%>'},
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
			}
		},
		error : function(){
			alert("加载检测报告信息错误");
		}
	});
}

// 加载图片
function loadEnTestPic1(){
	$.ajax({
		url : '${pageContext.request.contextPath}/enTestReport_selEnPic.do',
		data : {'enApplyId' : '<%=enApplyId %>',
				'enPicType' :'2'},
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
						var url = pic[ind].enPicUrl;
						var id = pic[ind].enPicId;
						str = str + "<div class='col-sm-3' id='"+id+"'>";
	        			str = str + "<a href='../../uploads/enPic/"+url+"' data-lightbox='1'><img width='210px' height='290px' src='../../uploads/enPic/"+url+"'></a>";
	        			str = str + "</div>";
					}
				}
    			str = str + "</div>";
    			$("#pic1").append(str);
			}
		}
	});
}
function loadEnTestPic2(){
	$.ajax({
		url : '${pageContext.request.contextPath}/enTestReport_selEnPic.do',
		data : {'enApplyId' : '<%=enApplyId %>',
				'enPicType' :'3'},
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
						var url = pic[ind].enPicUrl;
						var id = pic[ind].enPicId;
						str = str + "<div class='col-sm-4' id='"+id+"'>";
	        			str = str + "<a href='../../uploads/enPic/"+url+"' data-lightbox='1'><img width='210px' height='290px' src='../../uploads/enPic/"+url+"'></a>";
	        			str = str + "</div>";
					}
				}
    			str = str + "</div>";
    			$("#pic2").append(str);
			}
		}
	});
}
</script>
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
            <h3 class="box-title">环境检测报告</h3>
          </div><!-- /.box-header -->

          <div class="box-body pad">
            <div class="row">
              <div class="col-md-8 col-md-offset-2">
              
            <div class="box box-info">
             <div class="box-header with-border">
                <h3 class="box-title">基本信息</h3>
             </div>
            <div class="box-body">
            <form id="enTestReportForm" class="form-horizontal">
            
              <div class="row">
                <div class="col-sm-6">
                   <div class="form-group">
                    <label for="testReportNumber" class="col-sm-4 control-label">报告编号</label>
                    <div class="col-sm-8">
                      <input readonly="readonly" id="testReportNumber" name="enTestReport.testReportNumber" type="text" class="form-control">
                    </div>
                   </div>
                </div>
                <div class="col-sm-6">
                   <div class="form-group">
                    <label for="testDate" class="col-sm-4 control-label">检测日期</label>
                    <div class="col-sm-8">
                      <input readonly="readonly" id="testDate" name="enTestReport.testDate" type="text" class="form-control">
                    </div>
                  </div>
               </div>
              </div>

              <div class="row">
               <div class="col-sm-6">
                  <div class="form-group">
                    <label for="testUserName" class="col-sm-4 control-label">检测人</label>
                    <div class="col-sm-8">
                      <input readonly="readonly" id="testUserName" name="enTestReport.testUserName" type="text" class="form-control">
                    </div>
                  </div>
                </div>
                <div class="col-sm-6">
                   <div class="form-group">
                     <label for="testUniName" class="col-sm-4 control-label">委托单位</label>
                    <div class="col-sm-8">
                      <input readonly="readonly" id="testUnitName" name="enTestReport.testUnitName" type="text" class="form-control">
                    </div>
                   </div>
                </div>
              </div>
                <div class="row">
               <div class="col-sm-6">
                  <div class="form-group">
                    <label for="testSampleName" class="col-sm-4 control-label">样品名称</label>
                    <div class="col-sm-8">
                      <input readonly="readonly" id="testSampleName" name="enTestReport.testSampleName" type="text" class="form-control">
                    </div>
                  </div>
                </div>
              </div>
              <div class="row">
              	<div class="col-sm-12">
              	  <div class="box box-primary">
            		<div class="box-header">
              			<h3 class="box-title">检测结论
              			</h3>
            	  </div>
            	  <div class="box-body pad">
               		 <textarea readonly="readonly" id="testResult" name="enTestReport.testResult" name="testResult" class="textarea333" placeholder="请填写检测结论" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>     
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
               <h3 class="box-title">检测仪器</h3>
             </div><!-- /.box-header -->
             <div class="box-body">
              <table class="table table-bordered" id="selectedInsTab">
                <tr>
                  <th>仪器名称</th>
                  <th>仪器型号</th>
                  <th>仪器序列号</th>
                  <th>仪器厂商</th>
                  <th></th>
                </tr>
              </table>
             </div><!-- /.box-body -->
            </div><!-- /.box -->
            
            <div class="box box-info">
               <div class="box-header with-border">
                 <h3 class="box-title">照片</h3>
               </div>
               <div class="box-body">
               	<div class="container" id="pic1">
               	 	<span class="label label-info" style="font-size: 100%;">检测设备及检测过程照片</span>
       			 </div>
       			 <hr>
               	<div class="container" id="pic2">
               		<span class="label label-info" style="font-size: 100%;">检测过程频谱分析</span>
       			 </div>
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
</body>
</html>