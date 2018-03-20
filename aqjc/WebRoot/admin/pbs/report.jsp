<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.tyust.common.DateHandler" %>
<%
	String pbsTestReportId = request.getParameter("pbsTestReportId");
%>
<%@include file="/public/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>屏蔽室申请</title>
	<jsp:include page="../common/include-commonNew.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/webuploader/css/webuploader.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/webuploader/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/lightbox/css/lightbox.min.css" />		
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/dist/webuploader.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/upload_pbsTestReport.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/lightbox/js/lightbox-plus-jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/bootstrap/js/bootstrap.js"></script>
	<script src="<%=request.getContextPath() %>/controls/JCalendar/WdatePicker.js"></script>
	<style>
		.dataTab input{width:220px;height:23px;}
		.dataTab select{width:110px;height:22px;}
		.stace{margin:5px;}	
	</style>
	
	<!--S   LL预览照片相关css     -->
	    <style>
        .imageDiv{
            float: left;
            margin-left: 10px;
        }
        .deleteImgA{
            display: block;text-align: center
        }
        .priImg{
        height:140px;
        width:160px;
        }
    </style>
    <!--S   LL预览照片相关css     -->
	
	<!-- S     LL引入的bootstrapFileinput的CSS -->
	<link rel="stylesheet" type="text/css"
		href="${baseurl}/bootstrapFileinput/css/default.css">
	<link href="${baseurl}/bootstrapFileinput/css/fileinput.css" media="all"
		rel="stylesheet" type="text/css" />
	<!-- E     LL引入的bootstrapFileinput的CSS -->
	<!--S  LL引入发bootstrapFileiput的JS  -->
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
	<!--E  LL引入发bootstrapFileiput的JS  -->

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
             	
             	<!-- ll 增加屏蔽室申请信息 -->
	             	<div class="row">
	              		<div class="col-sm-6">
	                  	  <div class="form-group">
	                       <label for="input1" class="col-sm-4 control-label">申请单位</label>
	                      <div class="col-sm-8">
	                        <input id="pbsApplyUnitName" type="text" name="pbsApplyInfo.pbsApplyUnitName" class="form-control"  disabled="disabled">
	                      </div>
	                      </div>
	                    </div>
	                <div class="col-sm-6">
	                  <div class="form-group">
	                    <label for="pbsApplyDate" class="col-sm-4 control-label">申请日期</label>
	                    <div class="col-sm-8">
	                      <input id="pbsApplyDate" name="pbsApplyInfo.pbsApplyDate" type="text" class="form-control" disabled="disabled">
	                    </div>
	                  </div>
	                 </div>
	                </div>
	
	                <div class="row">
	                  <div class="col-sm-6">
	                    <div class="form-group">
	                    <label for="input1" class="col-sm-4 control-label">申请人</label>
	                    <div class="col-sm-8">
	                      <input id="pbsApplyUserName" type="text" name="pbsApplyInfo.pbsApplyUserName" class="form-control" disabled="disabled">
	                    </div>
	                    </div>
	                   </div>
	                   <div class="col-sm-6">
	                     <div class="form-group">
	                     <label for="pbsApplyTel" class="col-sm-4 control-label">联系方式</label>
	                      <div class="col-sm-8">
	                       <input id="pbsApplyTel" type="text" name="pbsApplyInfo.pbsApplyTel" class="form-control" disabled="disabled">
	                     </div>
	                    </div>
	                  </div>
	                </div>
	                               
	                <div class="row">
	                  <div class="col-sm-6">
	                    <div class="form-group">
	                    <label for="input1" class="col-sm-4 control-label">生产单位</label>
	                    <div class="col-sm-8">
	                       <input id="pbsApplyProduction" name="pbsApplyInfo.pbsApplyProduction" disabled="disabled" type="text" class="form-control" >
	                    </div>
	                    </div>
	                   </div>
	                   <div class="col-sm-6">
	                     <div class="form-group">
	                     <label for="input1" class="col-sm-4 control-label">评测等级</label>
	                      <div class="col-sm-8">                      
							<input id="pbsApplyGrade" name="pbsTestReport.pbsTestGrade" disabled="disabled" type="text" class="form-control" >
	                     </div>
	                    </div>
	                  </div>
	                </div>
             	<!-- ll 申请信息结束 -->
             	
            	<div class="row">
             	 <div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">报告编号</label>
                    <div class="col-sm-8">
                      <input id="pbs_testReportNumber" name="pbsTestReport.testReportNumber" type="text" class="form-control" disabled>
                    </div>
                  </div>
             	</div>
              	<div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">检测日期</label>
                    <div class="col-sm-8">
                      <input id="pbs_testDate" name="pbsTestReport.testDate" type="text" class="form-control" value="<%= DateHandler.dateToString(new Date()) %>"
                       disabled>
                    </div>
                 </div>
              	</div>
               </div>

             <div class="row">
              	<div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">检测人</label>
                    <div class="col-sm-8">
                      <input id="pbs_testUserName" disabled name="pbsTestReport.testUserName" type="text" class="form-control">
                    </div>
                  </div>
              	</div>
              	<div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">样品名称</label>
                    <div class="col-sm-8">
                      <input id="pbs_testSampleName" disabled name="pbsTestReport.pbsTestSampleName" type="text" class="form-control">
                    </div>
                  </div>
              	</div>
             </div>
              <div class="row">
              	<div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">型号规格</label>
                    <div class="col-sm-8">
                      <input id="pbs_testType" type="text" disabled name="pbsTestReport.pbsTestTypeSpecification" class="form-control">
                    </div>
                  </div>
              	</div>
              	<div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">温度</label>
                    <div class="col-sm-8">
                    	<div class="input-group">
	                      <input id="pbs_testTemperature" disabled type="text" name="pbsTestReport.pbsTestTemperature" class="form-control">
	                      <span style="background-color:rgb(238,238,238)" class="input-group-addon">℃</span>
                    	</div>
                    </div>
                  </div>
              	</div>
             </div>
             <div class="row">
              	<div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">湿度</label>
                    <div class="col-sm-8">
                    	<div class="input-group">
	                      <input id="pbs_testHumidity" disabled type="text" name="pbsTestReport.pbsTestHumidity" class="form-control">
	                      <span style="background-color:rgb(238,238,238)" class="input-group-addon">%RH</span>
                   		</div>
                    </div>
                  </div>
              	</div>              	
             </div>                         
             
             
             <!-- 检测内容及结论 S-->
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
			                       <input id="pbs_testProject" type="text" disabled class="form-control" name="pbsTestReport.pbsTestProject" id="applyUsername">
			                    </div>
			                  </div>
			              </div>
		              </div>
	                  <!-- 依据标准 -->      	    	  
		             <div class="row">
			              <div class="col-sm-12">
			                  <div class="form-group">
			                    <label for="input1" class="col-sm-2 control-label">依据标准</label>
			                    <div class="col-sm-10">
			                      <input id="pbs_testStandard" type="text" disabled name="pbsTestReport.pbsTestStandard" class="form-control"  id="applyUsername">
			                    </div>
			                  </div>
			              </div>
		              </div>
	                 <!-- 检测位置 -->                         		    	  
		             <div class="row">
			              <div class="col-sm-12">
			                  <div class="form-group">
			                    <label for="input1" class="col-sm-2 control-label">检测位置</label>
			                    <div class="col-sm-10">			                     
			       				  <input type="checkbox" disabled name="pbsTestReport.pbsTestLocation" value="屏蔽门">屏蔽门&nbsp;&nbsp;
			                      <input type="checkbox" disabled name="pbsTestReport.pbsTestLocation" value="波导窗">波导窗&nbsp;&nbsp;
			                      <input type="checkbox" disabled name="pbsTestReport.pbsTestLocation" value="屏蔽墙体">屏蔽墙体
			                    </div>
			                  </div>
			              </div>
		              </div>
	              			<br/>
	            		  <label for="input1" class="col-sm-2 control-label">检测结论</label>
	              			<br/>
	               		 <textarea id="pbs_testResult" disabled name="pbsTestReport.pbsTestConclusion" class="textarea333" placeholder="请填写检测结论" style="width: 80%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>     
           		  </div>
       		 	 </div>
              	</div>
              </div>
             <!-- 检测内容及结论 E -->
             
             <!-- 检测仪器和设备 S-->
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
			                </tr>
			              </table>
		             </div><!-- /.box-body -->
	            </div><!-- /.box -->
             <!-- 检测仪器和设备 E -->
             
             
             <!-- 屏蔽室描述 S -->             	
              <div class="row">
              	<div class="col-sm-12">
              	  <div class="box box-primary">
            		<div class="box-header">
              			<h3 class="box-title"><b>屏蔽室描述</b>
              			</h3>
            	  	</div>
            	 	 <div class="box-body pad">            	               
		              		<!--建成时间-->
				             <div class="row">
					              <div class="col-sm-6">
					                  <div class="form-group">
					                    <label for="input1" class="col-sm-4 control-label">建成时间</label>
					                    <div class="col-sm-8">
					                      <input id="pbs_testCompletionTime" type="text" disabled  name="pbsTestReport.pbsTestCompletionTime" class="form-control" />
					                    </div>
					                  </div>
				                  </div>
					              <div class="col-sm-6">
					                  <div class="form-group">
					                    <label for="input1" class="col-sm-4 control-label">尺寸</label>
					                    <div class="col-sm-8">
					                    		<div class="input-group">
													<input id="pbs_testSize" disabled type="text" class="form-control" name="pbsTestReport.pbsTestPbsSize">
													<span style="background-color:rgb(238,238,238)" class="input-group-addon">m³</span>
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
					                      <input id="pbs_testStatus"  disabled type="text" name="pbsTestReport.pbsTestPbsStatus" class="form-control" />
					                    </div>
					                  </div>
				              	  </div>
			              	 </div>
		             	</div>
		             </div>
			       </div>
	            </div>
             <!-- 屏蔽室描述 E -->
             
             <!-- 隐藏项 ：操作-提交与保存-->
             <input type="hidden" id="operate" name="operate" value="save"/>
            </form>
          </div>
        </div>
        
       
       <!-- 新的图片回显 S-->
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
									屏蔽室照片
			                      </label>
			                    </div>
			                   <div class="col-sm-2">
				               		 <label>
				                      <input type="radio" name="pictureType" class="processPicture" value="1">
										 检测过程照片
				                    </label>
			                    </div>
			                   
		                  </div>
		                </div>
               		</div>
       			<div id="imgBigDiv">
 					<div class="box-body planePicture pictureDiv" id="pingmianDiv" style="margin-top:20px;">
								<!-- 存放之前已经选好的图片 -->
								<div id="pingmianPriviousDiv">
										<!-- 提示语 -->
										<p>下面是您之前已经上传的照片，点击图片可以查看!</p>
									   
								</div>
								
								
					</div>
 					<div class="box-body  environmentPicture pictureDiv" id="XX" style="margin-top:20px;display:none;">
								<!-- 存放之前已经选好的图片 -->
								<div id="enviPriviousDiv">
										<!-- 提示语 -->
										<p>下面是您之前已经上传的照片，点击图片可以查看!</p>
									    
								</div>														
					</div>
 					<div class="box-body processPicture pictureDiv" id="XXX"  style="margin-top:20px;display:none;">
								<!-- 存放之前已经选好的图片 -->
								<div id="processPriviousDiv">
										<!-- 提示语 -->
										<p>下面是您之前已经上传的照片，点击图片可以查看!</p>
									    
								</div>															
					</div>
 					
             </div>
           </div>
        </div>
       <!-- 新的图片回显 E -->
       
             <!-- 检测数据 S -->
            	<div class="box box-info">
		             <div class="box-header with-border">
		               <h3 class="box-title">检测数据</h3>		              		             
		             </div><!-- /.box-header -->
		             <div class="box-body">
			             <table class="table table-bordered">
			             	<thead>
				                <tr>
				                  <th  rowspan="2" class="center" style="vertical-align:middle;">屏蔽效能(dB)</th>
				                  <th  colspan="5" class="center">检测频率</th>
				                </tr>
				                <tr>
				                	<th>14kHz</th>			                  
				                    <th>100kHz</th>
				                    <th>450kHz</th>
				                    <th>950kHz</th>
				                    <th>6GHz</th>				                    		                 
				                </tr>
				             </thead>
				             <tbody id="pbsTestDataList">				             	
				             </tbody>
			              </table>
		             </div><!-- /.box-body -->
	            </div><!-- /.box -->
            <!-- 检测数据 E -->
            
            </div>
           </div>   
          </div><!-- /.box-body -->
          
          <div class="box-footer">
          	
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
	
	
	<!-- S   预览照片模态框-->
	  <!-- /.content -->           
	  <div id="imgModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel111" aria-hidden="true">
	      <div class="modal-dialog">
			<div class="modal-content">
				
	             <div class="box-body">
	             		 <span style="">
	             		 	<img alt="" src="${baseurl }/images/left.jpg" style="width:40px;height:60px;margin-bottom:40%" title="点击查看上一张" onclick="lastImg()">
	             		 </span>
	             		<span>
	             			<img id="dynamicImage" src=""  style="width:83%;height:83%">
	             		</span>
	             		<span style="">
	             			<img alt="" src="${baseurl }/images/right.jpg" style="width:40px;height:60px;margin-bottom:40%" title="点击查看下一张" onclick="nextImg()">
	           			</span>
	         	</div><!-- /.box-body -->
	        </div>
	     </div>
	   </div> 
     <!-- E   预览照片模态框-->
	
</div>
<!-- ./wrapper -->

<script>
//先提交表单信息，成功后返回该信息的主键，然后在保存相关的图片和附件
$(document).ready(function(){
	// 加载信息
	loadInfo();	
	//单选按钮的点击事件
	$("[name='pictureType']").click(function(){
		var clazz = $(this).prop("class");
		$(".pictureDiv").css("display","none");//隐藏所有的div
		$("div."+clazz).css("display","block");
	});
	//预览图片的点击事件:
	 $('body').on('click','.priImg', function () {
			var src = $(this).prop("src");
			$("#dynamicImage").prop("src",src);
			$("#imgModal").modal("show");
    });
	
});



function loadInfo(){
	$.ajax({
		url : '<%=request.getContextPath()%>/pbsTestReport_queryPbsTestReport.do?pbsTestReportId=<%=pbsTestReportId%>',
		type : 'POST',
		dataType :'json',
		success : function(data){
			var data = eval(data.testReport);			
			$("#pbsTestReportId").val(data.pbsTestReportId);
			$("#pbsApplyId").val(data.pbsApplyId);
			$("#pbs_testReportNumber").val(data.testReportNumber);				
			$("#pbs_testDate").val(data.testDate); 
			$("#pbs_testUserName").val(data.testUserName);
			$("#pbs_testSampleName").val(data.pbsTestSampleName);
			$("#pbs_testType").val(data.pbsTestTypeSpecification); 
			$("#pbs_testTemperature").val(data.pbsTestTemperature); 
			$("#pbs_testHumidity").val(data.pbsTestHumidity); 
			$("#pbs_testProject").val(data.pbsTestProject); 
			$("#pbs_testStandard").val(data.pbsTestStandard); 
			$("#pbs_testResult").val(data.pbsTestConclusion); 
			$("#pbs_testCompletionTime").val(data.pbsTestCompletionTime); 
			$("#pbs_testSize").val(data.pbsTestPbsSize); 
			$("#pbs_testStatus").val(data.testStatus); 			
			//给检测位置赋值
			var pbsTestLocation = data.pbsTestLocation;
			if(pbsTestLocation != null && "" != pbsTestLocation && pbsTestLocation.length>0){
				var locationArray = pbsTestLocation.toString().split(",");				
				for(var i=0,length_1=locationArray.length;i<length_1;i++){	
					var locationValue = locationArray[i];
					$("[name='pbsTestReport.pbsTestLocation'][value='"+locationValue+"']").prop("checked",true);
				}
			}
			
			var pbsApplyId = data.pbsApplyId;
			var pbsTestReportId = data.pbsTestReportId;
			showPbsPic(pbsApplyId,"1");
			showPbsPic(pbsApplyId,"2");
			showPbsPic(pbsApplyId,"4");
			//显示申请信息
			showPbsApplyInfo(pbsApplyId);
			//显示屏蔽室检测设备信息
			showPbsInstrumentInfo(pbsTestReportId);
			//显示屏蔽室检测数据信息
			showPbsTestDatasInfo(pbsTestReportId);
		},
		error :function(){
			alert("加载数据错误");
		}
	});
}

//显示屏蔽室申请信息
function showPbsApplyInfo(pbsApplyId) {	
	$.ajax({
		url : '${pageContext.request.contextPath}/pbsApplyInfo_selPbsApplyInfoById.do',
		data : {'pbsApplyId' : pbsApplyId},
		type : 'POST',
		dataType : 'json',
		success : function(response) {
			var info = eval(response);
			$("#pbsApplyDate").val(info.pbsApplyDate);
			$("#pbsApplyUserName").val(info.pbsApplyUserName);
			$("#pbsApplyTel").val(info.pbsApplyTel);
			$("#pbsApplyProduction").val(info.pbsApplyProduction);
			$("#pbsApplyGrade").val(info.pbsApplyGrade+"级");
			$("#pbsApplyOpinion").val(info.pbsApplyOpinion);
			loadUnitName(info.pbsApplyUnitId);			
		}
	});
}

//加载部门名称
function loadUnitName(pbsApplyUnitId){
	$.ajax({
		url : contextPath+'/loadUnitName.do',
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				var data = eval(data);
				var optionStr = "";
				for (var i = 0; i < data.length; i++) {					
					if(data[i].unitId == pbsApplyUnitId){						
						$("#pbsApplyUnitName").val(data[i].unitName);
						break;
					}
				}
			},
			error : function(data) {
				alert("error");
			}
		});
	}

//显示屏蔽室检测设备信息
function showPbsInstrumentInfo(pbsTestReportId){
	$.ajax({
		url: contextPath+'/pbsTestReport_getPbsInsInfoListByReportId.do',
		type:'post',
		data:{"pbsTestReportId":pbsTestReportId},
		dataType:"json",
		success:function(data){			
			var json = data.insInfoList;
			if(json.length>0){
				$("#selectedInsTab  tr:not(:first)").html("");
				for(var v=0;v<json.length;v++){
					$("#selectedInsTab").append("<tr><td><input type='hidden' name='insId' value='"+json[v].instrumentId+"'/>"+json[v].name+"</td>"+
							"<td>"+json[v].model+"</td>"+
							"<td>"+json[v].code+"</td>"+
							"<td>"+json[v].manufacturer+"</td></tr>");
				}
			}
		}
	})
}

//显示屏蔽室检测数据信息
function showPbsTestDatasInfo(pbsTestReportId){
	$.ajax({
		url: contextPath+'/pbsTestReport_getPbsTestDatasByReportId.do',
		type:'post',
		data:{"pbsTestReportId":pbsTestReportId},
		dataType:"json",
		success:function(data){			
			var json = data.pbsTestDatasList;
			if(json.length>0){
				$("#pbsTestDataList").html("");
				var testDataStr = "";
				for(var v=0;v<json.length;v++){
					 testDataStr += "<tr><td>"+json[v].pbsTestShield
					 +"</td><td>"+checkIsNull(json[v].datas14kHz)
					 +"</td><td>"+checkIsNull(json[v].datas100kHz)
					 +"</td><td>"+checkIsNull(json[v].datas450kHz)
					 +"</td><td>"+checkIsNull(json[v].datas950kHz)
					 +"</td><td>"+checkIsNull(json[v].datas6gHz)
					 +"</td></tr>";										
				}				
				$("#pbsTestDataList").append(testDataStr);
			}
		}
	})
}

//验证字符是否为空
function checkIsNull(value){
	if(value==""||value==null){
		return "--";
	}else{
		return value;
	}
}

//初始化照片回显
function showPbsPic(pbsApplyId,pictureType){
	$.ajax({
		url : '${pageContext.request.contextPath}/pbsApplyInfo_selPbsPic.do',
		data : {'pbsApplyId' : pbsApplyId,
				'pbsPicType' :pictureType},
		type : 'POST',
		dataType : 'json',
		success : function(response) {
			if(response!=null && response.length>0){
				if(pictureType == "2"){
					$("#processPriviousDiv .imageDiv").remove();
					for(var i=0;i<response.length;i++){
						$("#processPriviousDiv").append(
								'<div class="imageDiv"><img src="/pbs/picture/'+response[i].pbsPicUrl+'" class="priImg" id="'+response[i].pbsPicId+'">'
								+'</div >')
						
					}
				}				
				if(pictureType == "4"){
					$("#enviPriviousDiv .imageDiv").remove();
					for(var i=0;i<response.length;i++){
						$("#enviPriviousDiv").append(				
								'<div class="imageDiv"><img src="/pbs/picture/'+response[i].pbsPicUrl+'" class="priImg" id="'+response[i].pbsPicId+'">'
								+'</div >')
					}
				}
				if(pictureType == "1"){
					$("#pingmianPriviousDiv .imageDiv").remove();
					for(var i=0;i<response.length;i++){
						$("#pingmianPriviousDiv").append(			
								'<div class="imageDiv"><img src="/pbs/picture/'+response[i].pbsPicUrl+'" class="priImg" id="'+response[i].pbsPicId+'">'
								+'</div >')
						
					}
				}
			}
		}
	});
};

	
	/************  S   预览图片的上一张下一张*******************/
	function lastImg(){
		var src = $("#dynamicImage").attr("src");
		var imgName = src.toString().substring(src.length-36);//获取图片名字
		var imgParent = $("#imgBigDiv").find("[src$='"+imgName+"']").parent();//获取到class为imageDiv的div
		var lastImageDiv = imgParent.prev("div");
		if(lastImageDiv.length == 0){
			alert("已经是第一张了");
		}else{
			$("#dynamicImage").prop("src",lastImageDiv.children("img").prop("src"));
		}
	}
	function nextImg(){
		var src = $("#dynamicImage").attr("src");
		var imgName = src.toString().substring(src.length-36);//获取图片名字
		var imgParent = $("#imgBigDiv").find("[src$='"+imgName+"']").parent();//获取到class为imageDiv的div
		var lastImageDiv = imgParent.next("div");
		if(lastImageDiv.length == 0){
			alert("已经是最后一张了");
		}else{
			$("#dynamicImage").prop("src",lastImageDiv.children("img").prop("src"));
		}
	}
	/************  E   预览图片的上一张下一张*******************/
	
	
	
</script>
</body>
</html>