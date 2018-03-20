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
	                        <input id="pbsApplyUnitName" type="text" name="pbsApplyInfo.pbsApplyUnitName" class="form-control"  readonly="readonly">
	                      </div>
	                      </div>
	                    </div>
	                <div class="col-sm-6">
	                  <div class="form-group">
	                    <label for="pbsApplyDate" class="col-sm-4 control-label">申请日期</label>
	                    <div class="col-sm-8">
	                      <input id="pbsApplyDate" name="pbsApplyInfo.pbsApplyDate" type="text" class="form-control" readonly="readonly">
	                    </div>
	                  </div>
	                 </div>
	                </div>
	
	                <div class="row">
	                  <div class="col-sm-6">
	                    <div class="form-group">
	                    <label for="input1" class="col-sm-4 control-label">申请人</label>
	                    <div class="col-sm-8">
	                      <input id="pbsApplyUserName" type="text" name="pbsApplyInfo.pbsApplyUserName" class="form-control" readonly="readonly">
	                    </div>
	                    </div>
	                   </div>
	                   <div class="col-sm-6">
	                     <div class="form-group">
	                     <label for="pbsApplyTel" class="col-sm-4 control-label">联系方式</label>
	                      <div class="col-sm-8">
	                       <input id="pbsApplyTel" type="text" name="pbsApplyInfo.pbsApplyTel" class="form-control" readonly="readonly">
	                     </div>
	                    </div>
	                  </div>
	                </div>
	                               
	                <div class="row">
	                  <div class="col-sm-6">
	                    <div class="form-group">
	                    <label for="input1" class="col-sm-4 control-label">生产单位</label>
	                    <div class="col-sm-8">
	                       <input id="pbsApplyProduction" name="pbsApplyInfo.pbsApplyProduction" readonly="readonly" type="text" class="form-control" >
	                    </div>
	                    </div>
	                   </div>
	                   <div class="col-sm-6">
	                     <div class="form-group">
	                     <label for="input1" class="col-sm-4 control-label">评测等级</label>
	                      <div class="col-sm-8">                      
							<input id="pbsApplyGrade" name="pbsTestReport.pbsTestGrade" readonly="readonly" type="text" class="form-control" >
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
                      <input id="pbs_testReportNumber" name="pbsTestReport.testReportNumber" type="text" class="form-control" readonly>
                    </div>
                  </div>
             	</div>
              	<div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">检测日期</label>
                    <div class="col-sm-8">
                      <input id="pbs_testDate" name="pbsTestReport.testDate" type="text" class="form-control" value="<%= DateHandler.dateToString(new Date()) %>"
                      onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" readonly>
                    </div>
                 </div>
              	</div>
               </div>

             <div class="row">
              	<div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">检测人</label>
                    <div class="col-sm-8">
                      <input id="pbs_testUserName" name="pbsTestReport.testUserName" type="text" class="form-control">
                    </div>
                  </div>
              	</div>
              	<div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">样品名称</label>
                    <div class="col-sm-8">
                      <input id="pbs_testSampleName" name="pbsTestReport.pbsTestSampleName" type="text" class="form-control">
                    </div>
                  </div>
              	</div>
             </div>
              <div class="row">
              	<div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">型号规格</label>
                    <div class="col-sm-8">
                      <input id="pbs_testType" type="text"  name="pbsTestReport.pbsTestTypeSpecification" class="form-control">
                    </div>
                  </div>
              	</div>
              	<div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">温度</label>
                    <div class="col-sm-8">
                    	<div class="input-group">
	                      <input id="pbs_testTemperature" type="text" name="pbsTestReport.pbsTestTemperature" class="form-control">
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
	                      <input id="pbs_testHumidity" type="text" name="pbsTestReport.pbsTestHumidity" class="form-control">
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
			                       <input id="pbs_testProject" type="text" class="form-control" name="pbsTestReport.pbsTestProject" id="applyUsername">
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
			                      <input id="pbs_testStandard" type="text" name="pbsTestReport.pbsTestStandard" class="form-control"  id="applyUsername">
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
			       				  <input type="checkbox" name="pbsTestReport.pbsTestLocation" value="屏蔽门">屏蔽门&nbsp;&nbsp;
			                      <input type="checkbox" name="pbsTestReport.pbsTestLocation" value="波导窗">波导窗&nbsp;&nbsp;
			                      <input type="checkbox" name="pbsTestReport.pbsTestLocation" value="屏蔽墙体">屏蔽墙体
			                    </div>
			                  </div>
			              </div>
		              </div>
	              			<br/>
	            		  <label for="input1" class="col-sm-2 control-label">检测结论</label>
	              			<br/>
	               		 <textarea id="pbs_testResult" name="pbsTestReport.pbsTestConclusion" class="textarea333" placeholder="请填写检测结论" style="width: 80%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>     
           		  </div>
       		 	 </div>
              	</div>
              </div>
             <!-- 检测内容及结论 E -->
             
             <!-- 检测仪器和设备 S-->
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
			                  <th>操作</th>
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
					                      <input id="pbs_testCompletionTime" type="text" readonly onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" name="pbsTestReport.pbsTestCompletionTime" class="form-control" />
					                    </div>
					                  </div>
				                  </div>
					              <div class="col-sm-6">
					                  <div class="form-group">
					                    <label for="input1" class="col-sm-4 control-label">尺寸</label>
					                    <div class="col-sm-8">
					                    		<div class="input-group">
													<input id="pbs_testSize" type="text" class="form-control" name="pbsTestReport.pbsTestPbsSize">
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
					                      <input id="pbs_testStatus" type="text" name="pbsTestReport.pbsTestPbsStatus" class="form-control" />
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
        
       <!--   原来的图片回显    S-->
    <!--    <div class="box box-info">
	           <div class="box-header with-border">
	              <h3 class="box-title">检测报表扫描照片</h3>
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
       <!-- 原来的图片回显 E -->
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
								
								<div style="clear:both;margin-top:20px;">
									<form enctype="multipart/form-data">
										<div>
											<input id="upPlanePicture" class="file planePicture" type="file"
												name="fileName">
										</div>
										<p>您选择的是平面简图:请选择单张图进行上传，平面简图只能上传单张!</p>
									</form>
								</div>
					</div>
 					<div class="box-body  environmentPicture pictureDiv" id="XX" style="margin-top:20px;display:none;">
								<!-- 存放之前已经选好的图片 -->
								<div id="enviPriviousDiv">
										<!-- 提示语 -->
										<p>下面是您之前已经上传的照片，点击图片可以查看!</p>
									    
								</div>
								
							<div style="clear:both;margin-top:20px;">
								<form enctype="multipart/form-data">
									<div>
										<input id="upEnvironmentPicture" class="file" multiple type="file"
											name="fileName">
									</div>
									<p>您选择的是环境照片:可以同时选择多张照片，也可以选择单张照片!</p>
								</form>
							</div>
					</div>
 					<div class="box-body processPicture pictureDiv" id="XXX"  style="margin-top:20px;display:none;">
								<!-- 存放之前已经选好的图片 -->
								<div id="processPriviousDiv">
										<!-- 提示语 -->
										<p>下面是您之前已经上传的照片，点击图片可以查看!</p>
									    
								</div>
								
								<div style="clear:both;margin-top:20px;">
									<form enctype="multipart/form-data">
										<div>
											<input id="upProcessPicture" class="file" multiple type="file"
												name="fileName">
										</div>
										<p>您选择的是检测过程照片:可以同时选择多张照片，也可以选择单张照片!</p>
									</form>
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
		               <button type="button" class="btn btn-primary pull-right" onclick="openTestDataModal()" >添加检测物</button>		              
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
				                    <th>操作</th>				                   
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
	
	<!-- 隐藏表单用于检测数据的提交 -->
	<form id="pbsTestDatasForm">
		<input type="hidden" name="pbsTestReportId" id="pbsTestReportIdInForm"/>
	</form>
	
	<!-- 检测设备添加模态框 S -->
		<div id="chooseInsTab" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	      <div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					  <button type="button" class="close" data-dismiss="modal"
                                    aria-hidden="true" >&times;</button><!--关闭符号-->
					<h4 class="modal-title text-center" id="myModalLabel">添加仪器</h4>
				</div>
				<div class="modal-body">
	     		 <div class="box box-info">
	             <div class="box-body">
	              <table class="table table-bordered">
	                <tr>
	                  <th>仪器名称</th>
	                  <th>仪器型号</th>
	                  <th>仪器序列号</th>
	                  <th>仪器厂商</th>
	                  <th>操作</th>
	                </tr>
	                <tbody id="selectedInsTab1">
	                </tbody>
	              </table>
	         	</div><!-- /.box-body -->
	         	
	       		</div><!-- /.box -->
	      	   </div>
	        </div>
	     </div>
	   </div> 
	<!-- 检测设备添加模态框 E -->
	
	<!-- 添加检测物的模态框 S -->
		
		<div id="addPbsTestDatas" class="modal fade" tabindex="-1" role="dialog" data-backdrop="static" aria-labelledby="myModalLabel" aria-hidden="true">
	      <div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					  <button type="button" class="close" data-dismiss="modal"
                                    aria-hidden="true" >&times;</button><!--关闭符号-->
					<h4 class="modal-title text-center" id="myModalLabel">检测数据</h4>
				</div>
				<div class="modal-body">
	     		 <div class="box box-info">
		             <div class="box-body">		             	 		             	
			             	 <div class="col-sm-12 stace">
				                  <div class="form-group">
				                    <label for="input1" class="col-sm-2 control-label">检测物</label>
				                    <div class="col-sm-10">
				                      <input type="text"  class="form-control addInfo" />
				                    </div>
				                  </div>
			              	  </div>
			              	  <div class="col-sm-12 stace">
				                  <div class="form-group">
				                    <label for="input1" class="col-sm-2 control-label">14kHz</label>
					                    <div class="col-sm-10">
					                      <input type="number"  class="form-control addInfo" />
					                    </div>
				                  </div>
			              	  </div>
			              	  <div class="col-sm-12 stace">
				                  <div class="form-group">
				                    <label for="input1" class="col-sm-2 control-label">100kHz</label>
				                    <div class="col-sm-10">
				                      <input type="number"  class="form-control addInfo" />
				                    </div>
				                  </div>
			              	  </div>
			              	  <div class="col-sm-12 stace">
				                  <div class="form-group">
				                    <label for="input1" class="col-sm-2 control-label">450kHz</label>
				                    <div class="col-sm-10">
				                      <input type="number"  class="form-control addInfo" />
				                    </div>
				                  </div>
			              	  </div>
			              	  <div class="col-sm-12 stace">
				                  <div class="form-group">
				                    <label for="input1" class="col-sm-2 control-label">950kHz</label>
				                    <div class="col-sm-10">
				                      <input type="number"  class="form-control addInfo" />
				                    </div>
				                  </div>
			              	  </div>
			              	  <div class="col-sm-12 stace">
				                  <div class="form-group">
				                    <label for="input1" class="col-sm-2 control-label">6GHz</label>
				                    <div class="col-sm-10">
				                      <input type="number"  class="form-control addInfo" />
				                    </div>
				                  </div>
			              	  </div>
		             	 
		         	 </div><!-- /.box-body -->	         	
	       		</div><!-- /.box -->
	      	   </div>
	      	   
	      	   <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="addPbsTestData()">保存</button>
               </div>	      	   
	        </div>
	     </div>
	   </div> 
	
	<!-- 添加检测物的模态框 E -->
	
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
	var picCount = 0;//图片数量
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
	//删除按钮点击事件:
	 $('body').on('click','.deleteImgA', function () {
		 if(confirm("您确认删除此照片吗?")){
			 var enPicId = $(this).parent().children("img").prop("id");
			 //删除图片
			 delPbsPic(enPicId);
		 }
	 })
	$("#save").click(function (){
		if(confirm("您确定要保存信息吗？保存后可以修改")){			
			$("#operate").val("save");	
			saveInfo();
		}
	});
	$("#submit").click(function (){
		if(confirm("您确认提交信息?提交之后不可以更改!")){
			$("#operate").val("submit");
			if(validate()){
				alert("请完善基本信息");
				return;
			}
			if(validateInstrument()){
				alert("请完善设备信息");
				return;
			}
			if(validatePicture()){
				alert("请完善图片信息");
				return;
			}
			if(validateTestDatas()){
				alert("请完善检测数据信息");
				return;
			}		
			saveInfo();
		}
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
							"<td>"+json[v].manufacturer+"</td>"+
							"<td><a href='javascript:void(0)' onclick='delSeletedIns(this)'><i class='fa fa-trash' style='font-size: 20px;'></i></td></tr>");
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
					 +"</td><td><a href='javascript:void(0)' onclick='delSeletedIns(this)'><i class='fa fa-trash' style='font-size: 20px;'></i></a>"
					 +" <a href='javascript:void(0)' onclick='updatePbsTestData(this)'><span class='glyphicon glyphicon-pencil' title='修改'>"
					 +"</span></a></td></tr>";										
				}				
				$("#pbsTestDataList").append(testDataStr);
			}
		}
	})
}

//验证字符是否为空
function checkIsNull(value){
	if(value==""||value==null){
		return "";
	}else{
		return value;
	}
}

//点击添加仪器按钮执行的操作
function chooseInsDialog(){
	load();
	$("#chooseInsTab").modal("show");
}

/* 初始化检测设备模态框 */
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
			data : {'useType':'2',
				'existInsIds' : insIdStr},
			dataType : 'json',
			type : 'POST',
			success : function(data) {
				var json = eval(data.rows);
				$("#selectedInsTab1").empty();
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
//添加检测仪器
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

//打开添加检测数据模态框
function openTestDataModal(){
	  $(".addInfo").val('');
	  $("#addPbsTestDatas").modal("show");
}
//删除所选行
function delSeletedIns(obj){
		$(obj).parent().parent().remove();
	}
//添加检测物及数据
function addPbsTestData(){
	  var $inputs = $(".addInfo");
	  if($inputs.eq(0).val()!=""){		 
		  var testDataStr = "<tr><td>"+$inputs.eq(0).val()
							 +"</td><td>"+$inputs.eq(1).val()
							 +"</td><td>"+$inputs.eq(2).val()
							 +"</td><td>"+$inputs.eq(3).val()
							 +"</td><td>"+$inputs.eq(4).val()
							 +"</td><td>"+$inputs.eq(5).val()
							 +"</td><td><a href='javascript:void(0)' onclick='delSeletedIns(this)'><i class='fa fa-trash' style='font-size: 20px;'></i></a>"
							 +" <a href='javascript:void(0)' onclick='updatePbsTestData(this)'><span class='glyphicon glyphicon-pencil' title='修改'>"
							 +"</span></a></td></tr>";
		 $("#pbsTestDataList").append(testDataStr);
		 $("#addPbsTestDatas").modal("hide");
	  }
}
//修改检测物及数据
function updatePbsTestData(obj){
	  //获取当前行的所有列
	  var $tds = $(obj).parents("tr").children("td");
	  //获取模态框中的所有input对象
	  var $inputs = $(".addInfo");	  
	  for(var i=0,j=$inputs.length;i<j;i++){
		  $inputs.eq(i).val($tds.eq(i).text());
	  }
	  $(obj).parents("tr").remove();
	  $("#addPbsTestDatas").modal("show");
}


function saveInfo(){
	$.ajax({
		url : '<%=request.getContextPath()%>/pbsTestReport_updatePbsTestReport.do',
		type : 'POST',
		dataType : 'json',
		data : $("#pbsTestReportForm").serializeArray(),
		async:false,
		success : function(data){
			// 设置图片上传的url
			var data = eval(data);
			if (data.result == "success") {
				saveAddTestDatas($("#pbsTestReportId").val());
				saveSelInstrument($("#pbsTestReportId").val());
				alert("保存成功")
				window.location.href = 'test_report_list.jsp';	
			}
		},//success processing over!
		error : function(data){
			alert("保存失败");
		}
	});
};

//保存所选检测设备信息
function saveSelInstrument(pbsTestReportId){
	  var v = $("#selectedInsTab tr").length;
		var insIdStr = "";
		if(v > 1){
			$("input[name='insId']").each(function(index,item){
				insIdStr = insIdStr + $(this).val()+",";
			});
		}
		insIdStr = insIdStr.substring(0,insIdStr.length-1);
		$.ajax({
			url:"{pageContext.request.contextPath}/pbsTestReport_savePbsTestInstrument.do",
			data:{"pbsTestReportId":pbsTestReportId,"pbsInstrumentIds":insIdStr},
			type:"post",
			//设定为同步
			async:false,
			dataType:"json",
			success:function(data){						
			}
		})
}

//保存填写的检测数据等信息
function saveAddTestDatas(pbsTestReportId){
	  var $trs = $("#pbsTestDataList").children("tr");
	  var testDatasList = "";
	  var str = $trs.eq(0).children("td").eq(0).text();
	  for(var i=0,j=$trs.length;i<j;i++){
		  var $tds = $trs.eq(i).children("td");
		  testDatasList +=	  "<input name='pbsTestDatasList[" + i
							+ "].pbsTestReportId' type='hidden' value='"+ pbsTestReportId + "'/>"				
							+ "<input name='pbsTestDatasList[" + i
							+ "].pbsTestShield' type='hidden' value='"+ $tds.eq(0).text()+ "'/>"
							+ "<input name='pbsTestDatasList[" + i
							+ "].datas14kHz' type='hidden' value='" + $tds.eq(1).text() + "'/>"
							+ "<input name='pbsTestDatasList[" + i
							+ "].datas100kHz' type='hidden' value='" + $tds.eq(2).text() + "'/>"
							+ "<input name='pbsTestDatasList[" + i
							+ "].datas450kHz' type='hidden' value='" + $tds.eq(3).text() + "'/>"
							+ "<input name='pbsTestDatasList[" + i
							+ "].datas950kHz' type='hidden' value='" + $tds.eq(4).text() + "'/>"
							+ "<input name='pbsTestDatasList[" + i
							+ "].datas6gHz' type='hidden' value='" + $tds.eq(5).text() + "'/>";
	  }
	  //向表单中设置信息
	  $("#pbsTestReportIdInForm").val(pbsTestReportId);
	  $("#pbsTestDatasForm").append(testDatasList);
	$.ajax({
		url:"{pageContext.request.contextPath}/pbsTestReport_savePbsTestDatas.do",
		data:$("#pbsTestDatasForm").serialize(),
		type:"post",
		//设定为同步
		async:false,
		dataType:"json",
		success:function(data){			
		}
	})
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
								+'<a href="javascript:void(0)" class="deleteImgA">删除</a></div >')
						
					}
				}				
				if(pictureType == "4"){
					$("#enviPriviousDiv .imageDiv").remove();
					for(var i=0;i<response.length;i++){
						$("#enviPriviousDiv").append(				
								'<div class="imageDiv"><img src="/pbs/picture/'+response[i].pbsPicUrl+'" class="priImg" id="'+response[i].pbsPicId+'">'
								+'<a href="javascript:void(0)" class="deleteImgA">删除</a></div >')
					}
				}
				if(pictureType == "1"){
					$("#pingmianPriviousDiv .imageDiv").remove();
					for(var i=0;i<response.length;i++){
						$("#pingmianPriviousDiv").append(			
								'<div class="imageDiv"><img src="/pbs/picture/'+response[i].pbsPicUrl+'" class="priImg" id="'+response[i].pbsPicId+'">'
								+'<a href="javascript:void(0)" class="deleteImgA">删除</a></div >')
						
					}
				}
			}
		}
	});
};
//删除照片
function delPbsPic(pbsPicId){
		$.ajax({
			url : '${pageContext.request.contextPath}/pbsApplyInfo_delImage.do',
			data : {'pbsPicId' : pbsPicId},
			type : 'POST',
			dataType : 'json',
			success : function (data){
				var data = eval(data);
				if (data.result == "success"){
					// 删除节点
					$("#"+pbsPicId).parent().remove();					
				} else {
					alert("删除图片失败！");
				}
			},
			error : function (){
				alert("删除图片失败！");
			}
		});	
}

/******************S    四种图片上传插件的显示************/
/**
 * 上传平面简图
 */
$("#upPlanePicture").fileinput({
    language: 'zh',//中文
    uploadUrl:"pbsMultipleFileUpAction.do",//上传的地址，加上这个才会出现删除按钮
    dropZoneEnabled: false,//是否显示拖拽区域
    showUpload: false, //是否显示上传按钮,跟随文本框的那个
    showRemove : true, //显示移除按钮,跟随文本框的那个
    showClose:false,//显示关闭按钮
    showCaption: true,//是否显示标题,就是那个文本框
    uploadAsync:true,//是否异步
    layoutTemplates:{//预览区域删除按钮与上传按钮的显示
        actionUpload:'',//上传按钮不显示
        progress:''//隐藏进度条
   },
    autoReplace:true,//是否自动替换上一个文件
    enctype: 'multipart/form-data',
    previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
    uploadExtraData: function (previewId, index) {//携带其他一些数据的格式
        var data = {
        	applyId:$("#pbsApplyId").val(),//申请编号
        	pictureType:'1'
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
		$(this).fileinput("upload");
	}).on("fileuploaded", function(event, data) {//上传成功之后的一些处理
	        if(data.response)
	        {
	        	$(this).fileinput("reset");
	        	showPbsPic($("#pbsApplyId").val(),"1");
	        }
	 });
/**
 * 上传屏蔽室照片
 */
 $("#upEnvironmentPicture").fileinput({
	    language: 'zh',//中文
	    uploadUrl:"pbsMultipleFileUpAction.do",//上传的地址，加上这个才会出现删除按钮
	    dropZoneEnabled: false,//是否显示拖拽区域
	    showUpload: false, //是否显示上传按钮,跟随文本框的那个
	    showRemove : true, //显示移除按钮,跟随文本框的那个
	    showClose:false,//显示关闭按钮
	    showCaption: true,//是否显示标题,就是那个文本框
	    uploadAsync:true,//是否异步
	    layoutTemplates:{//预览区域删除按钮与上传按钮的显示
	        actionUpload:'',//上传按钮不显示
	        progress:''//隐藏进度条
	   },
	   autoReplace:true,//是否自动替换，只能替换上一步选择的文件
	    enctype: 'multipart/form-data',
	    previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
/* 	    layoutTemplates : {
	    	actionUpload:"<input type='text' placeholder='请输入图片名称' onchange='changePictureName(this)' style='width:100px;background-color:rgb(238,238,238);'/>"
	    }, */
	    uploadExtraData: function (previewId, index) {//携带其他一些数据的格式
	        var data = {
	        	applyId:$("#pbsApplyId").val(),
	        	pictureType:'4'
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
	}).on("filebatchselected", function(event, files) {//文件选中函数(选完上传)
		isReset = false ; 
		$(this).fileinput("upload");
	}).on("fileuploaded", function(event, data) {//上传成功之后的一些处理(成功之后重置)
	        if(data.response)
	        {
	        	if(!isReset){
	 	           //查询环境检测照片
	 	           $("#upEnvironmentPicture").fileinput("reset");
	 	           showPbsPic($("#pbsApplyId").val(),"4");
	        		isReset = true;
		        	}
	        }
	    });
/**
 * 上传检测过程照片
 */
$("#upProcessPicture").fileinput({
    language: 'zh',//中文
    uploadUrl:"pbsMultipleFileUpAction.do",//上传的地址，加上这个才会出现删除按钮
    dropZoneEnabled: false,//是否显示拖拽区域
    showUpload: true, //是否显示上传按钮,跟随文本框的那个
    showRemove : true, //显示移除按钮,跟随文本框的那个
    showClose:false,//显示关闭按钮
    showCaption: true,//是否显示标题,就是那个文本框
    uploadAsync:true,//是否异步
    layoutTemplates:{//预览区域删除按钮与上传按钮的显示
        actionUpload:'',//上传按钮不显示
        progress:''
   },
    enctype: 'multipart/form-data',
    previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
    previewSettings: {//限制预览区域的宽高
    	image: {width: "160px", height: "160px"}
    },
    uploadExtraData: function (previewId, index) {//携带其他一些数据的格式
        var data = {
        	applyId:$("#pbsApplyId").val(),
        	pictureType:'2'
        };
        return data;
    },
    validateInitialCount:true,
    allowedFileExtensions: ['jpg','png']//允许上传问价你的后缀
	}).on('filepreupload', function(event, data, previewId, index) {
	    var form = data.form, files = data.files, extra = data.extra,
	        response = data.response, reader = data.reader;
	}).on("filebatchselected", function(event, files) {//文件选中函数
		$(this).fileinput("upload");
		isReset = false ; 
	}) .on("fileuploaded", function(event, data) {//上传成功之后的一些处理
	        if(data.response)
	        {
		        	if(!isReset){
		 	           //查询环境检测照片
		 	           $("#upProcessPicture").fileinput("reset");
		 	           showPbsPic($("#pbsApplyId").val(),"2");
		        		isReset = true;
		        	}
		           
	        }
    });
/************E    四种图片上传插件的显示*******************/
	
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
	
	/*********S 验证信息***********/
	//验证基本信息
	function validate(){
		if($("#pbs_testDate").val() == "") {
			return true;
		}
		if($("#pbs_testUserName").val() == ""){
			return true;
		}
		if($("#pbs_testSampleName").val() == ""){
			return true;
		}
		if($("#pbs_testType").val() == "") {
			return true;
		}
		if($("#pbs_testTemperature").val() == "") {
			return true;
		}
		if($("#pbs_testHumidity").val() == "") {
			return true;
		}
		if($("#pbs_testProject").val() == "") {
			return true;
		}
		if($("#pbs_testStandard").val() == "") {
			return true;
		}
		if($("#pbs_testResult").val() == "") {
			return true;
		}
		if($("#pbs_testCompletionTime").val() == "") {
			return true;
		}
		if($("#pbs_testSize").val() == "") {
			return true;
		}
		if($("#pbs_testStatus").val() == "") {
			return true;
		}
		//判断检测位置复选框中是否有值
		if($("input[name='pbsTestReport.pbsTestLocation']:checked").length==0){
			return true;
		}
	}
	//验证设备信息
	function validateInstrument(){
		var length = $("#selectedInsTab tr").length;
		return length==1?true:false;
	}
	//验证图片信息
	function validatePicture(){		
		if($("#pingmianPriviousDiv").find(".imageDiv").length==0) return true;
		if($("#enviPriviousDiv").find(".imageDiv").length==0) return true;
		if($("#processPriviousDiv").find(".imageDiv").length==0) return true;		
		return false;
	}
	//验证检测数据信息
	function validateTestDatas(){
		if($("#pbsTestDataList").children("tr").length==0){
			return true;
		}
	}
	/*********E 验证信息***********/
	
</script>
</body>
</html>