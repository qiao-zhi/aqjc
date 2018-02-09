<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.tyust.bean.user.TBaseUserInfo" %>
<%@ page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.tyust.dao.unit.IunitDao,com.tyust.bean.unit.TBaseUnitInfo"%>
<%@ page import="java.util.*,com.tyust.common.DateHandler" %>
<%
	TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
	ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
	String unitId = user.getUnitId();
	IunitDao unitDao = (IunitDao)context.getBean("Unit");
	String enApplyId = request.getParameter("enApplyId");
%>
<%@include file="/public/tag.jsp"%>
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
	<script src="<%=request.getContextPath() %>/controls/JCalendar/WdatePicker.js"></script>
	<style>
		.dataTab input{width:220px;height:23px;}
		.dataTab select{width:110px;height:22px;}
		.modal-dialog{
			aria-hidden:true !important;
			z-index:999;
			}
			/* .file-zoom-dialog{
				display:none;
			} */
		/********S   QLQ**********/
        /***限制图片框的大小**/
/*         .kv-file-content {
            height: 160px;
            width: 160px !important;
        }

        .kv-preview-data {
            height: 80%;
            width: 80% !important;
        } */
        
		/********S   QLQ**********/
	</style>
	
	
	<!-- S     QLQ引入的bootstrapFileinput的CSS -->
<link rel="stylesheet" type="text/css"
	href="${baseurl}/bootstrapFileinput/css/default.css">
<link href="${baseurl}/bootstrapFileinput/css/fileinput.css" media="all"
	rel="stylesheet" type="text/css" />
<!-- E     QLQ引入的bootstrapFileinput的CSS -->
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
$(function(){
	//1.初始化环境申请信息
	showEnApplyInfo();
	
	
});
//显示环境申请信息
function showEnApplyInfo() {
	$.ajax({
		url : '${pageContext.request.contextPath}/enApplyInfo_selEnApplyInfoById.do',
		data : {'enApplyId' : '<%= enApplyId%>'},
		type : 'POST',
		dataType : 'json',
		success : function(response) {
			var info = eval(response);
			$("#applyDate").val(info.enApplyDate);
			$("#enApplyUnitId").val(info.enApplyUnitId);
			$("#applyUsername").val(info.enApplyUserName);
			$("#appPhone").val(info.enApplyTel);
			$("#yangpinmingcheng").val(info.enApplySamply);
			$("#manuUnit").val(info.enApplyProduction);
			loadUnitName();//查询单位名称
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
					if(data[i].unitId == $("#enApplyUnitId").val()){
						$("#applyUnitName").val(data[i].unitName);
						break;
					}
				}
			},
			error : function(data) {
				alert("error");
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
          
           <!--S 基本信息  -->
            <div class="row">
              <div class="col-md-8 col-md-offset-2">
              
            <div class="box box-info">
             <div class="box-header with-border">
                <h3 class="box-title">基本信息</h3>
             </div>
            <form id="enTestReportForm" class="form-horizontal">
            <div class="box-body">
             <div class="row">
              <div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">申请单位</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" readonly="readonly" id="applyUnitName">
                      <input type="hidden" class="form-control" id="enApplyUnitId">
                    </div>
                  </div>
              </div>
              <div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">申请日期</label>
                    <div class="col-sm-8">
                      <input id="enApplyDate" type="text" class="form-control" readonly="readonly" id="applyDate">
                    </div>
                  </div>
               </div>
              </div>
              
              
             <!-- 申请人和联系方式 -->
             <div class="row">
              <div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">申请人</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" readonly="readonly" id="applyUsername">
                    </div>
                  </div>
              </div>
              <div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">联系方式</label>
                    <div class="col-sm-8">
                      <input id="appPhone" type="text" class="form-control" readonly="readonly" >
                    </div>
                  </div>
               </div>
              </div>
              
              
             <!-- 样品名称和生产单位 -->
             <div class="row">
              <div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">样品名称</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" readonly="readonly" name="enTestReport.testSampleName" id="yangpinmingcheng">
                    </div>
                  </div>
              </div>
              <div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">生产单位</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" readonly="readonly" name="enTestReport.environmentApplyProduction" id="manuUnit">
                    </div>
                  </div>
               </div>
              </div>
            
              <div class="row">
                <div class="col-sm-6">
                   <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label" >报告编号</label>
                    <div class="col-sm-8">
                      <input id="testReportNumber" name="enTestReport.testReportNumber" readonly style="background-color:#ffffff;" type="text" class="form-control">
                    </div>
                   </div>
                </div>
                <div class="col-sm-6">
                   <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">检测日期</label>
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
                    <label for="input1" class="col-sm-4 control-label">检测人</label>
                    <div class="col-sm-8">
                      <input id="testUserName" name="enTestReport.testUserName" type="text" class="form-control">
                    </div>
                  </div>
                </div>
                <div class="col-sm-6">
                   <div class="form-group">
                     <label for="input1" class="col-sm-4 control-label">委托单位</label>
                    <div class="col-sm-8">
                      <input id="testUnitName" name="enTestReport.testUnitName" type="text" class="form-control">
                    </div>
                   </div>
                </div>
              </div>
               <!--E 基本信息  -->
              
              
              
               <!--E  检测内容及结论  -->
              <div class="row">
              	<div class="col-sm-12">
              	  <div class="box box-primary">
            		<div class="box-header">
              			<h3 class="box-title"><b>检测内容及结论</b>
              			</h3>
            	  </div>
            	  <div class="box-body pad">
            	  
              
              <!--检测项目-->
             <div class="row">
	              <div class="col-sm-12">
	                  <div class="form-group">
	                    <label for="input1" class="col-sm-2 control-label">检测项目</label>
	                    <div class="col-sm-10" style="padding-top:5px;">
	                      <input type="checkbox" name="enTestReport.testProject" value="物理检查">物理检查&nbsp;&nbsp;
	                      <input type="checkbox" name="enTestReport.testProject" value="无线信号检查">无线信号检查&nbsp;&nbsp;
	                      <input type="checkbox" name="enTestReport.testProject" value="通信模块检查">通信模块检查
	                    </div>
	                  </div>
	              </div>
              </div>
              
              
    	  	  <!-- 申请人和联系方式 -->
             <div class="row">
	              <div class="col-sm-12">
	                  <div class="form-group">
	                    <label for="input1" class="col-sm-2 control-label">依据标准</label>
	                    <div class="col-sm-10">
	                      <input type="text" name="enTestReport.testCriterion" class="form-control" value="《密码工作环境电磁安全监察规范》" id="applyUsername">
	                    </div>
	                  </div>
	              </div>
              </div>
              
              
              
    	  	  <!-- 申请人和联系方式 -->
             <div class="row">
	              <div class="col-sm-12">
	                  <div class="form-group">
	                    <label for="input1" class="col-sm-2 control-label">检测位置</label>
	                    <div class="col-sm-10">
	                      <input type="text" class="form-control" name="enTestReport.testLocation" id="applyUsername">
	                    </div>
	                  </div>
	              </div>
              </div>
              			<br/>
            		  <label for="input1" class="col-sm-2 control-label">检测结论</label>
              			<br/>
               		 <textarea id="testResult" name="enTestReport.testResult" class="textarea333" placeholder="请填写检测结论" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;">检测结论:使用现有检测手段实施检查，没有发现信息窃取装置。 </textarea>     
           		 </div>
       		 	</div>
              	</div>
              </div>
              	<!--  隐藏检测编号-->
              	<input type="hidden" name="enTestReport.environmentTestReportId" id="environmentTestReportId"/>
              	<!-- 隐藏申请编号 -->
              	<input type="hidden" name="enTestReport.environmentApplyId" value="<%=enApplyId %>" id="hidden_apply_id"/>
                <!-- 隐藏项 ：操作-提交与保存-->
             	<input type="hidden" id="operate" name="operate" value="save"/>
             </div>
             <!--E  检测内容及结论  -->
            
            
             <!--S   检测仪器及设备  -->
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
              <!--E   检测仪器及设备  -->
              
            
                 <!--S   机房环境描述  -->
              <div class="row">
              	<div class="col-sm-12">
              	  <div class="box box-primary">
            		<div class="box-header">
              			<h3 class="box-title"><b>机房环境描述</b>
              			</h3>
            	  </div>
            	  <div class="box-body pad">
            	  
              
		              <!--建成时间-->
		             <div class="row">
			              <div class="col-sm-6">
			                  <div class="form-group">
			                    <label for="input1" class="col-sm-4 control-label">建成时间</label>
			                    <div class="col-sm-8">
			                      <input type="text" value="" name="enTestReport.createTime" class="form-control" />
			                    </div>
			                  </div>
			              </div>
<!-- 			              <div class="col-sm-2">
			              </div> -->
			              <div class="col-sm-6">
			                  <div class="form-group">
			                    <label for="input1" class="col-sm-4 control-label">尺寸</label>
			                    <div class="col-sm-8">
			                    		<div class="input-group">
											<input type="text" class="form-control" name="enTestReport.environmentSize">
											<span style="background-color:rgb(238,238,238)" class="input-group-addon">㎡</span>
										</div>		
			                    </div>
			                    	
			                  </div>
			              </div>
		              </div>
		              </div>
		              
		              <br/>
              
           		 <!--状态-->
	             <div class="row">
		              <div class="col-sm-12">
		                  <div class="form-group">
		                    <label for="input1" class="col-sm-2 control-label">状&nbsp;&nbsp;&nbsp;&nbsp;态</label>
		                    <div class="col-sm-10">
		                      <input type="text" value="" name="enTestReport.environmentStatus" class="form-control" />
		                    </div>
		                  </div>
		              </div>
	              </div>
                            
                </form> 
                <!-- 隐藏项 ：操作-提交与保存-->
             </div>
            </div>
            </div>
            </div>
             <!--E  检测内容及结论  -->
            
            
        
              
            
            
            
            
            <div class="box box-info">
               <div class="box-header with-border">
                 <h3 class="box-title">检测照片</h3>
               </div>
               <div class="box-body">
               <div class="row">
               	<div class="container">
                 <div class="form-group">
                   <div class="col-sm-2">
               		 <label>
                      <input type="radio" name="pictureType" class="planePicture" checked value="4" checked>
						 平面简图
                    </label>
                    </div>
                   <div class="col-sm-2">
               		 <label>
                      <input type="radio" name="pictureType" class="environmentPicture" value="3">
						环境照片
                    </label>
                    </div>
                   <div class="col-sm-2">
               		 <label>
                      <input type="radio" name="pictureType" class="processPicture" value="1">
						 检测过程照片
                    </label>
                    </div>
                    <div class="col-sm-3">
                    <label>
                      <input type="radio" name="pictureType" value="2" class="frequencyPicture">
                     	 检测过程频谱分析
                    </label>
                    </div>
                  </div>
                  </div>
                </div>
<!--                   头部，相册选择和格式选择
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
                 </div> -->
 					<div class="box-body planePicture pictureDiv" id="pingmianDiv" style="margin-top:20px;">
							<form enctype="multipart/form-data">
								<div>
									<input id="upPlanePicture" class="file planePicture" type="file"
										name="fileName">
								</div>
								<p>您选择的是平面简图:请选择单张图进行上传，平面简图只能上传单张!</p>
							</form>
					</div>
 					<div class="box-body  environmentPicture pictureDiv" id="XX" style="margin-top:20px;display:none;">
							<form enctype="multipart/form-data">
								<div>
									<input id="upEnvironmentPicture" class="file" multiple type="file"
										name="fileName">
								</div>
								<p>您选择的是环境照片:可以同时选择多张照片，也可以选择单张照片!</p>
							</form>
					</div>
 					<div class="box-body processPicture pictureDiv" id="XXX"  style="margin-top:20px;display:none;">
							<form enctype="multipart/form-data">
								<div>
									<input id="upProcessPicture" class="file" multiple type="file"
										name="fileName">
								</div>
								<p>您选择的是检测过程照片:可以同时选择多张照片，也可以选择单张照片!</p>
							</form>
					</div>
 					<div class="box-body frequencyPicture pictureDiv" id="XXXX"  style="margin-top:20px;display:none;">
							<form enctype="multipart/form-data">
								<div>
									<input id="upFrequencyPicture" class="file" multiple type="file"
										name="fileName">
								</div>
								<p>您选择的是检测过程频谱分析:可以同时选择多张照片，也可以选择单张照片!</p>
							</form>
					</div>
             </div>
            </div>
            
            
            
            <!-- 预览模态框(单独放出来，否则隐藏div的时候图片不显示) -->
             <div>
				   <div id="kvFileinputModal" class="file-zoom-dialog modal fade" tabindex="-1" aria-labelledby="kvFileinputModalLabel"><div class="modal-dialog modal-lg" role="document">
				  <div class="modal-content">
				    <div class="modal-header">
				      <div class="kv-zoom-actions pull-right"><button type="button" class="btn btn-default btn-header-toggle btn-toggleheader" title="缩放" data-toggle="button" aria-pressed="false" autocomplete="off"><i class="glyphicon glyphicon-resize-vertical"></i></button><button type="button" class="btn btn-default btn-fullscreen" title="全屏" data-toggle="button" aria-pressed="false" autocomplete="off"><i class="glyphicon glyphicon-fullscreen"></i></button><button type="button" class="btn btn-default btn-borderless" title="无边界模式" data-toggle="button" aria-pressed="false" autocomplete="off"><i class="glyphicon glyphicon-resize-full"></i></button><button type="button" class="btn btn-default btn-close" title="关闭当前预览" data-dismiss="modal" aria-hidden="true"><i class="glyphicon glyphicon-remove"></i></button></div>
				      <h3 class="modal-title">详细预览 <small><span class="kv-zoom-title"></span></small></h3>
				    </div>
				    <div class="modal-body">
				      <div class="floating-buttons"></div>
				      <div class="kv-zoom-body file-zoom-content"></div>
				<button type="button" class="btn btn-navigate btn-prev" title="预览上一个文件"><i class="glyphicon glyphicon-triangle-left"></i></button> <button type="button" class="btn btn-navigate btn-next" title="预览下一个文件"><i class="glyphicon glyphicon-triangle-right"></i></button>
				    </div>
				  </div>
				</div>
				</div>
            </div>
            
            
            
            </div>
           </div>   
          </div><!-- /.box-body -->
          
          <div class="box-footer" style="text-align:center">
		      <button id="save" type="button" class="btn btn-default">保存</button>
              <button id="submit" style="margin-left:20px;" class="btn btn-info">提交</button>
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


<!--S QLQ 2018.02.06修改的JS  -->
<script>
$(function(){
	//单选按钮的点击事件
	$("[name='pictureType']").click(function(){
		var clazz = $(this).prop("class");
		$(".pictureDiv").css("display","none");//隐藏所有的div
		$("div."+clazz).css("display","block");
	});

	//初始化的时候获取编号
	getEnvironmentNum();
});
/**页面执行一次删除插件初始化的预览图片的模态框的函数**/
 (function(){
	$(".pictureDiv .modal").remove();//删除bootstrapFileinput初始化预览的div
})();

function getEnvironmentNum(){
	$.ajax({
		url:"${baseurl}/enTestReport_selEnviromentId.do",
		type:'POST',
		dateType:'json',
		success:function(response){
			$("[name='enTestReport.testReportNumber']").val(response.enviromentId);
		},
		error:function(){
			alert("获取编号失败!");
		}
		
	});
}

function changePictureName(obj){
/* 	
	
	var value = $(obj).val();
	var file_input = $(obj).parents(".file-input");
	var parent = file_input.find(".file-preview-frame");
	var img = parent.find(".kv-file-content").find("img");
	img.prop("title",value+".jpg").prop("alt",value+".jpg");
	var footer = parent.find(".file-footer-caption");
	footer.prop("title",value+".jpg");
	footer.text(value+".jpg");
	
	
	var file_caption_main = file_input.children(".file-caption-main");
	file_caption_main.find(".file-caption-name").prop("title",value+".jpg");
	alert(file_caption_main.find(".file-caption-name").text()); */
}
/*S    四种图片上传插件的显示*/
/**
 * 上传平面简图
 */
$("#upPlanePicture").fileinput({
    language: 'zh',//中文
    uploadUrl:"upLoadMultiple.do",//上传的地址，加上这个才会出现删除按钮
    dropZoneEnabled: false,//是否显示拖拽区域
    showUpload: false, //是否显示上传按钮,跟随文本框的那个
    showRemove : true, //显示移除按钮,跟随文本框的那个
    showClose:false,//显示关闭按钮
    showCaption: true,//是否显示标题,就是那个文本框
    uploadAsync:true,//是否异步
    layoutTemplates:{//预览区域删除按钮与上传按钮的显示
        actionUpload:''//上传按钮不显示
   },
    autoReplace:true,//是否自动替换上一个文件
    enctype: 'multipart/form-data',
/*     layoutTemplates : {
    	actionUpload:"<input type='text' placeholder='请输入图片名称' onchange='changePictureName(this)' style='width:100px;background-color:rgb(238,238,238);'/>"
    }, */
    previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
    uploadExtraData: function (previewId, index) {//携带其他一些数据的格式
        var data = {
        	applyId:$("#hidden_apply_id").val(),//申请编号
        	pictureType:'4'//4代表是平面简图
        };
        return data;
    },
    previewSettings: {//限制预览区域的宽高
    	image: {width: "160px", height: "160px"}
    },
    validateInitialCount:true,
    allowedFileExtensions: ['jpg','png']//允许上传问价你的后缀
}).on('filepreupload', function(event, data, previewId, index) {
    var form = data.form, files = data.files, extra = data.extra,response = data.response, reader = data.reader;
    
}).on("filebatchselected", function(event, files) {//文件选中函数
	
}).on("fileuploaded", function(event, data) {//上传成功之后的一些处理
        if(data.response)
        {
           /*  alert('处理成功'); */
        }
    });
/**
 * 上传环境描述
 */
 $("#upEnvironmentPicture").fileinput({
	    language: 'zh',//中文
	    uploadUrl:"upLoadMultiple.do",//上传的地址，加上这个才会出现删除按钮
	    dropZoneEnabled: false,//是否显示拖拽区域
	    showUpload: false, //是否显示上传按钮,跟随文本框的那个
	    showRemove : true, //显示移除按钮,跟随文本框的那个
	    showClose:false,//显示关闭按钮
	    showCaption: true,//是否显示标题,就是那个文本框
	    uploadAsync:true,//是否异步
	    layoutTemplates:{//预览区域删除按钮与上传按钮的显示
	        actionUpload:''//上传按钮不显示
	   },
	   autoReplace:true,//是否自动替换，只能替换上一步选择的文件
	    enctype: 'multipart/form-data',
	    previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
/* 	    layoutTemplates : {
	    	actionUpload:"<input type='text' placeholder='请输入图片名称' onchange='changePictureName(this)' style='width:100px;background-color:rgb(238,238,238);'/>"
	    }, */
	    uploadExtraData: function (previewId, index) {//携带其他一些数据的格式
	        var data = {
	        	applyId:$("#hidden_apply_id").val(),
	        	pictureType:'3'
	        };
	        return data;
	    },
	    previewSettings: {//限制预览区域的宽高
	    	image: {width: "160px", height: "160px"}
	    },
	    validateInitialCount:true,
	    allowedFileExtensions: ['jpg','png']//允许上传问价你的后缀
	}).on('filepreupload', function(event, data, previewId, index) {
	    var form = data.form, files = data.files, extra = data.extra,
	        response = data.response, reader = data.reader;
	}) .on("fileuploaded", function(event, data) {//上传成功之后的一些处理
	        if(data.response)
	        {
	           /*  alert('处理成功'); */
	        }
	    });
/**
 * 上传检测过程照片
 */
$("#upProcessPicture").fileinput({
    language: 'zh',//中文
    uploadUrl:"upLoadMultiple.do",//上传的地址，加上这个才会出现删除按钮
    dropZoneEnabled: false,//是否显示拖拽区域
    showUpload: false, //是否显示上传按钮,跟随文本框的那个
    showRemove : true, //显示移除按钮,跟随文本框的那个
    showClose:false,//显示关闭按钮
    showCaption: true,//是否显示标题,就是那个文本框
    uploadAsync:true,//是否异步
    layoutTemplates:{//预览区域删除按钮与上传按钮的显示
        actionUpload:''//上传按钮不显示
   },
    enctype: 'multipart/form-data',
    previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
    previewSettings: {//限制预览区域的宽高
    	image: {width: "160px", height: "160px"}
    },
    uploadExtraData: function (previewId, index) {//携带其他一些数据的格式
        var data = {
        	applyId:$("#hidden_apply_id").val(),
        	pictureType:'1'
        };
        return data;
    },
    validateInitialCount:true,
    allowedFileExtensions: ['jpg','png']//允许上传问价你的后缀
}).on('filepreupload', function(event, data, previewId, index) {
    var form = data.form, files = data.files, extra = data.extra,
        response = data.response, reader = data.reader;
}) .on("fileuploaded", function(event, data) {//上传成功之后的一些处理
        if(data.response)
        {
           /*  alert('处理成功'); */
        }
    });
/**
 * 上传频谱图
 */
$("#upFrequencyPicture").fileinput({
    language: 'zh',//中文
    uploadUrl:"upLoadMultiple.do",//上传的地址，加上这个才会出现删除按钮
    dropZoneEnabled: false,//是否显示拖拽区域
    showUpload: false, //是否显示上传按钮,跟随文本框的那个
    showRemove : true, //显示移除按钮,跟随文本框的那个
    showClose:false,//显示关闭按钮
    showCaption: true,//是否显示标题,就是那个文本框
    uploadAsync:true,//是否异步
    layoutTemplates:{//预览区域删除按钮与上传按钮的显示
        actionUpload:''//上传按钮不显示
   },
    enctype: 'multipart/form-data',
    previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
    previewSettings: {//限制预览区域的宽高
    	image: {width: "160px", height: "160px"}
    },
    uploadExtraData: function (previewId, index) {//携带其他一些数据的格式
        var data = {
        	applyId:$("#hidden_apply_id").val(),
        	pictureType:'2'
        };
        return data;
    },
    validateInitialCount:true,
    allowedFileExtensions: ['png','jpg']//允许上传问价你的后缀
}).on('filepreupload', function(event, data, previewId, index) {
    var form = data.form, files = data.files, extra = data.extra,
        response = data.response, reader = data.reader;
}) .on("fileuploaded", function(event, data) {//上传成功之后的一些处理
        if(data.response)
        {
           /*  alert('处理成功'); */
        }
    });
/*E    四种图片上传插件的显示*/

/**
 * 根据单选按钮变化下面的图片div
 */

</script>

<script>
/***********************保存相关操作***************/
$(function(){
	showInsTab();
	loadEnApplyInfo();
	//保存的点击事件
	$("#save").click(function() {
		if(confirm("您确认保存信息?保存之后可以修改!")){
			saveInfo();
		}
	});
	$("#submit").click(function() {
		if(confirm("您确认保存信息?保存之后可以修改!")){
			if (validate()){
				alert("请完善信息");
				return;
			}
			$("#operate").val("submit");
			saveInfo();
		}
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
					$("#selectedInsTab1").append("<tr><td><input type='hidden' name='insId1' value='"+json[v].InstrumentId+"'/><div>"+json[v].Name+"</div></td>"+
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
function showInsTab(){
	$.ajax({
		url : '${pageContext.request.contextPath}/ins_showInsTab.do',
		data : {'useType':'3'},
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
							"<td><a href='javascript:void(0)' onclick='delSeletedIns(this)'><i class='fa fa-trash'></i></td></tr>");
				}
			}
		}
	});
}

function delSeletedIns(obj){
	$(obj).parent().parent().remove();
}

// 获取环境检测申请信息
function loadEnApplyInfo(){
	$.ajax({
		url : '${pageContext.request.contextPath}/enApplyInfo_selEnApplyInfoById.do',
		data : {'enApplyId' : '<%= enApplyId %>'},
		dataType : 'json',
		type : 'POST',
		success : function(data){
			var data = eval(data);
			$("#enApplyDate").val(data.enApplyDate);
		},
		error : function(){
			alert("error");
		}
	});
	
}

function saveTestReport(flag){
	$("#operate").val(flag);
	var v = $("#selectedInsTab tr").length;
	if(v>1){
		var insIdStr = "";
		$("input[name='insId']").each(function(index,item){
			insIdStr=insIdStr+$(this).val()+",";
		});
		$("#selectedInsId").val(insIdStr);
		$("#testCode").val($("#testCodeInput").val());
		$("#testDate").val($("#testDateInput").val());
		$("#sampleName").val($("#sampleNameInput").val());
		$("#wtUnit").val($("#wtUnitInput").val());
	
		$("#testReportFm").submit();
	}else{
		alert("请选择检测仪器");
		return;
	}
}
</script>

<!--E QLQ 2018.02.06修改的JS  -->


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
		//将两个按钮设置为不可点击
		$("#save").prop("disabled",true);
		$("#submit").prop("disabled",true);
		$.ajax({
			url : '<%=request.getContextPath()%>/enTestReport_saveEnTestReport.do',
			type : 'POST',
			dataType : 'json',
			data : $("#enTestReportForm").serializeArray(),
			success : function(data){
				$("#environmentTestReportId").val(data.enTestReportId);
				//保存设备信息
				saveEnIns();
				// 设置图片上传的url
				savePicture();
			},
			error : function(data){
				alert("error");
			}
		});
	}
	
	/**保存设备信息*/
	function saveEnIns(){
		var v = $("#selectedInsTab tr").length;
		if(v==1){
			return;
		}
		var insIdStr = "";
		if(v > 1){
			$("input[name='insId']").each(function(index,item){
				insIdStr = insIdStr + $(this).val()+",";
			});
		}
		$.ajax({
			url : '<%=request.getContextPath()%>/enTestReport_saveReportAndIns.do',
			data : {'enTestReportId' : $("#environmentTestReportId").val(),
				'insIdStr' : insIdStr.toString().substring(0,insIdStr.length-1)},
			dataType : 'json',
			type : 'POST',
			success : function(data){
				
			},
			error : function(data){
				alert("检测仪器保存失败");			
			}
		});
	}
	/*****S  保存图片信息***********/
	function savePicture(){
		//判断是否有图片选择并上传
		if(isSelectedFile("upPlanePicture")){
			$("#upPlanePicture").fileinput("upload");
		}
		//上传环境监测图片
		if(isSelectedFile("upEnvironmentPicture")){
			$("#upEnvironmentPicture").fileinput("upload");
		}
		//上传监测过程
		if(isSelectedFile("upProcessPicture")){
			$("#upProcessPicture").fileinput("upload");
		}
		//上传频谱图
		if(isSelectedFile("upFrequencyPicture")){
			$("#upFrequencyPicture").fileinput("upload");
		}
	}
	
	
	/**判断是否选上文件**/
	function isSelectedFile(inputId){
		var applyFile = $("#"+inputId)[0].files;
		var applyFile_length = applyFile.length;
		return applyFile_length>0?true:false;
	}
	
<%-- 	function initUpload(){
		var type = $("input[type='radio']:checked").val();
		var url = "<%=request.getContextPath()%>/enTestReport_saveEnPic.do?enApplyId=<%=enApplyId%>&picType="+type;
		uploader.option('server',url);
	} --%>
	
</script>
</body>
</html>