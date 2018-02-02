<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.tyust.common.DateHandler" %>
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
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/webuploader/css/webuploader.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/webuploader/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/lightbox/css/lightbox.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/css/fileinput.min.css" />
		
	<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/dist/js/app.min.js"></script>

	<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/dist/webuploader.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/upload_enTestReport.js"></script>
	<script src="<%=request.getContextPath() %>/controls/JCalendar/WdatePicker.js"></script>
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
	$("#save").click(function() {
		$("#operate").val("save");
		saveInfo();
	});
	$("#submit").click(function() {
		$("#operate").val("submit");
		saveInfo();
	});
});


function load(){
	var v = $("#selectedInsTab tr").length;
	var insIdStr = "";
	if(v > 1){
		$("input[name='insId']").each(function(index,item){
			insIdStr = insIdStr + $(this).val()+",";
		});
	}
	$.ajax({
		url : '${pageContext.request.contextPath}/ins_chooseInsList.do',
		data : {'useType':'3',
			'existInsIds' : insIdStr},
		dataType : 'json',
		type : 'POST',
		success : function(data) {
			var json = eval(data.rows);
			if(json.length>0){
				for(var v=0;v<json.length;v++){
					$("#selectedInsTab1").append("<tr><td><input type='hidden' name='insId' value='"+json[v].InstrumentId+"'/><div>"+json[v].Name+"</div></td>"+
							"<td>"+json[v].Model+"</td>"+
							"<td>"+json[v].Code+"</td>"+
							"<td>"+json[v].Manufacturer+"</td>"+
							"<td><a href='javascript:void(0)' onclick='addIns(this)'><i class='fa fa-plus' style='font-size: 20px;'></i></td></tr>");
				}
			}
			
		},
		error : function(data){
			
		}
	});
}
function addIns(obj){
	var v = $(obj).parent().parent();
	$("#selectedInsTab").append("<tr><td><input name='insId' type='hidden' value='"+$(v).children('td').eq(0).children('input').val()+
	  					"'/>"+$(v).children('td').eq(0).children('div').text()+"</td>"+
						"<td>"+$(v).children('td').eq(1).text()+"</td>"+
						"<td>"+$(v).children('td').eq(2).text()+"</td>"+
						"<td>"+$(v).children('td').eq(3).text()+"</td>"+
						"<td><a href='javascript:void(0)' onclick='delSeletedIns(this)'><i class='fa fa-trash' style='font-size: 20px;'></i></td></tr>");
	$(obj).parent().parent().remove();
}

function chooseInsDialog(){
	load();
	$("#chooseInsTab").modal("show");
}
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
							"<td><a href='javascript:void(0)' onclick='delSeletedIns(this)'><i class='fa fa-trash' style='font-size: 20px;'></i></td></tr>");
				}
			}
		}
	});
}
// 删除仪器
function delSeletedIns(obj){
	$(obj).parent().parent().remove();
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
	        			str = str + "<div class='row'>";
	        			str = str + "<div class='col-sm-2'>";
	        			str = str + "<button class='btn btn-default' onclick='delEnPic(\""+id+"\")'>删除</button>";
	        			str = str + "</div>"
	        			str = str + "</div>";
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
	        			str = str + "<div class='row'>";
	        			str = str + "<div class='col-sm-2'>";
	        			str = str + "<button class='btn btn-default' onclick='delEnPic(\""+id+"\")'>删除</button>";
	        			str = str + "</div>"
	        			str = str + "</div>";
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
                      <input id="testReportNumber" name="enTestReport.testReportNumber" type="text" class="form-control">
                    </div>
                   </div>
                </div>
                <div class="col-sm-6">
                   <div class="form-group">
                    <label for="testDate" class="col-sm-4 control-label">检测日期</label>
                    <div class="col-sm-8">
                      <input id="testDate" name="enTestReport.testDate" type="text" class="form-control" value="<%= DateHandler.dateToString(new Date()) %>"
                      onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})">
                    </div>
                  </div>
               </div>
              </div>

              <div class="row">
               <div class="col-sm-6">
                  <div class="form-group">
                    <label for="testUserName" class="col-sm-4 control-label">检测人</label>
                    <div class="col-sm-8">
                      <input id="testUserName" name="enTestReport.testUserName" type="text" class="form-control">
                    </div>
                  </div>
                </div>
                <div class="col-sm-6">
                   <div class="form-group">
                     <label for="testUniName" class="col-sm-4 control-label">委托单位</label>
                    <div class="col-sm-8">
                      <input id="testUnitName" name="enTestReport.testUnitName" type="text" class="form-control">
                    </div>
                   </div>
                </div>
              </div>
                <div class="row">
               <div class="col-sm-6">
                  <div class="form-group">
                    <label for="testSampleName" class="col-sm-4 control-label">样品名称</label>
                    <div class="col-sm-8">
                      <input id="testSampleName" name="enTestReport.testSampleName" type="text" class="form-control">
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
               		 <textarea id="testResult" name="enTestReport.testResult" class="textarea333" placeholder="请填写检测结论" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>     
           		 </div>
       		 	</div>
              	</div>
              </div>
              
              	<input type="hidden" name="enTestReport.environmentApplyId" value="<%=enApplyId %>"/>
              	
                <input type="hidden" id="enTestReportId" name="enTestReport.environmentTestReportId" value='<%=enTestReportId %>' />
                
                
                <!-- 隐藏项 ：操作-提交与保存-->
             	<input type="hidden" id="operate" name="operate" value="save"/>
              </form>
             </div>
            </div>
            
            <div class="box box-info">
             <div class="box-header with-border">
               <h3 class="box-title">检测仪器</h3>
               <button type="button" class="btn btn-primary pull-right" onclick="chooseInsDialog()">添加仪器</button>
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
               	<span class="label label-info" style="font-size: 100%;"> 检测设备及检测过程照片</span>
       			 </div>
       			 <hr>
               	<div class="container" id="pic2">
               	 <span class="label label-info" style="font-size: 100%;">检测过程频谱分析</span>
       			 </div>
               
               <div class="row">
               	<div class="container">
                 <div class="form-group">
                   <div class="col-sm-5">
               		 <label>
                      <input type="radio" name="rd" class="minimal-red" value="2" checked onclick="initUpload()">
						 检测设备及检测过程照片
                    </label>
                    </div>
                    <div class="col-sm-5 col-sm-offset-1">
                    <label>
                      <input type="radio" name="rd" value="3" class="minimal-red" onclick="initUpload()">
                     	 检测过程频谱分析
                    </label>
                    </div>
                  </div>
                  </div>
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
                        <div id="filePicker2"></div><div class="uploadBtn">开始上传</div>
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
     <div id="chooseInsTab" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title text-center" id="myModalLabel">添加仪器</h4>
			</div>
			<div class="modal-body">
     		 <div class="box box-info">
             <div class="box-body">
              <table class="table table-bordered" id="selectedInsTab1">
                <tr>
                  <th>仪器名称</th>
                  <th>仪器型号</th>
                  <th>仪器序列号</th>
                  <th>仪器厂商</th>
                </tr>
              </table>
         	</div><!-- /.box-body -->
         	
       		</div><!-- /.box -->
      	   </div>
        </div>
     </div>
   </div> 
  </div>
  <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->
<script type="text/javascript">
function validate(){
	if($("#testReportNumber").val() == "") {
		return true;
	}
	if($("#testDate").val() == ""){
		return true;
	}
	if($("#testUserName").val() == ""){
		return true;
	}
	if($("#testUnitName").val() == "") {
		return true;
	}
	if($("#testSampleName").val() == "") {
		return true;
	}
	if($("#testResult").val() == "") {
		return true;
	}
}

	function saveInfo(){
		if (validate()){
			alert("请完善信息");
			return;
		}
		$.ajax({
			url : '<%=request.getContextPath()%>/enTestReport_updateEnTestReport.do',
			type : 'POST',
			dataType : 'json',
			data : $("#enTestReportForm").serializeArray(),
			success : function(data){
				// 设置图片上传的url
				var data = eval(data);
				if (data.result == "success") {
					var enTestReportId = '<%=enTestReportId%>';
					saveEnIns(enTestReportId);
					// 获取没有上传的图片文件数
					var num = uploader.getFiles().length;
					if (num == 0){
						alert("保存成功");
						window.location.href = 'enTestReport_list.jsp';
					} else {
						uploader.upload();
						uploader.on( 'uploadSuccess', function( file ) {
							num  = num - 1;
							if (num == 0) {
								// 页面跳转
								alert("保存成功");
								window.location.href='enTestReport_list.jsp';
							}
						});
					}
				}
				alert("操作完成");
			},
			error : function(data){
				alert("error");
			}
		});
	}
	
	function saveEnIns(enTestReportId){
		var v = $("#selectedInsTab tr").length;
		var insIdStr = "";
		if(v > 1){
			$("input[name='insId']").each(function(index,item){
				insIdStr = insIdStr + $(this).val()+",";
			});
		}
		$.ajax({
			url : '<%=request.getContextPath()%>/enTestReport_saveReportAndIns.do',
			data : {'enTestReportId' : enTestReportId,
				'insIdStr' : insIdStr},
			dataType : 'json',
			type : 'POST',
			success : function(data){
				
			},
			error : function(data){
				alert("检测仪器保存失败");			
			}
		});
	}
	
		// 删除图片
	function delEnPic(enPicId){
		var con = confirm("确认删除该图片吗？");
		if (con == true) {
			$.ajax({
				url : '${pageContext.request.contextPath}/enTestReport_delEnPic.do',
				data : {'enPicId' : enPicId},
				type : 'POST',
				dataType : 'json',
				success : function (data){
					var data = eval(data);
					if (data.result == "success"){
						// 删除节点
						$("#"+enPicId).empty();
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
	
	// 初始化图片上传
	function initUpload(){
		var type = $("input[type='radio']:checked").val();
		var url = "<%=request.getContextPath()%>/enTestReport_saveEnPic.do?enApplyId=<%=enApplyId%>&picType="+type;
		uploader.option('server',url);
	}
</script>
</body>
</html>