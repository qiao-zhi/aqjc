<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.tyust.common.DateHandler" %>
<%@ page import="com.tyust.bean.user.TBaseUserInfo" %>
<%@ page import="com.tyust.bean.unit.TBaseUnitInfo" %>
<%@ page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.tyust.dao.unit.IunitDao"%>
<%@ page import="com.tyust.dao.user.IuserDao"%>
<%

	ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
	
	String pbsApplyId = request.getParameter("pbsApplyId");
	String pbsApplyUnitId = request.getParameter("pbsApplyUnitId");
	String pbsApplyUserId = request.getParameter("pbsApplyUserId");
	
	IunitDao unitDao = (IunitDao)context.getBean("Unit");
	TBaseUnitInfo unit = unitDao.findUnit(pbsApplyUnitId);	

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
	
	<!-- S    ll引入的bootstrapFileinput的CSS -->
	<link rel="stylesheet" type="text/css"
		href="${baseurl}/bootstrapFileinput/css/default.css">
	<link href="${baseurl}/bootstrapFileinput/css/fileinput.css" media="all"
		rel="stylesheet" type="text/css" />
	<!-- E     ll引入的bootstrapFileinput的CSS -->
	<!--S  ll引入发bootstrapFileiput的JS  -->
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

	<!--E  ll引入发bootstrapFileiput的JS  -->
	<style>
		.dataTab input{width:220px;height:23px;}
		.dataTab select{width:110px;height:22px;}	
		.stace{margin:5px;}	
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
             	<input id="hidden_apply_id" type="hidden" name="pbsTestReport.pbsApplyId" value="<%=pbsApplyId%>">
             	<!-- ll 增加屏蔽室申请信息 -->
	             	<div class="row">
	              		<div class="col-sm-6">
	                  	  <div class="form-group">
	                       <label for="input1" class="col-sm-4 control-label">申请单位</label>
	                      <div class="col-sm-8">
	                        <input type="text" name="pbsApplyInfo.pbsApplyUnitName" class="form-control" value="<%=unit.getUnitName() %>" readonly="readonly">
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
                      <input name="pbsTestReport.testReportNumber" type="text" class="form-control" readonly>
                    </div>
                  </div>
             	</div>
              	<div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">检测日期</label>
                    <div class="col-sm-8">
                      <input id="pbs_testDate" name="pbsTestReport.testDate" type="text" readonly class="form-control" value="<%= DateHandler.dateToString(new Date()) %>"
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
			                      <input id="pbs_testStandard" type="text" name="pbsTestReport.pbsTestStandard" class="form-control" value="BMB3-1999 处理涉密信息的电磁屏蔽室的技术要求和测试方法" id="applyUsername">
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
            
            <!-- 原来的扫描图片上传 S -->
		       <!-- <div class="box box-info">
		           <div class="box-header with-border">
		              <h3 class="box-title">检测报表扫描照片</h3>
		           </div>
			       <div class="box-body">
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
            <!-- 原来的扫描图片上传 D -->
            
            <!-- 新的扫描图片上传 S -->
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
						                      <input type="radio" name="pictureType" class="planePicture" checked value="1" checked>
												 平面简图
						                      </label>
					                    </div>
				                  	   <div class="col-sm-2">
						               		 <label>
						                      <input type="radio" name="pictureType" class="environmentPicture" value="4">
												屏蔽室照片
						                     </label>	
				                       </div>
				                   	  <div class="col-sm-2">
					               		 <label>
					                       <input type="radio" name="pictureType" class="processPicture" value="2">
											 检测过程照片
					                     </label>
				                      </div>                    
			                    	</div>
		                 	 </div>
	                	 </div>
	                	 
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
	                	 
	                </div>
                </div>
            <!-- 新的扫描图片上传 E -->
            
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
	
	<!-- 隐藏表单用于检测数据的提交 -->
	<form id="pbsTestDatasForm">
		<input type="hidden" name="pbsTestReportId" id="pbsTestReportId"/>
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
<!-- ./wrapper -->


<script>
//先提交表单信息，成功后返回该信息的主键，然后在保存相关的图片和附件
$(document).ready(function(){
		$("#save").click(function (){
			if(confirm("您确认保存信息?保存之后可以修改!")){
				$("#operate").val("save");		
					savePicture();
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
				savePicture();
				saveInfo();	
			}
		});
});

function saveInfo(){
	$.ajax({
		url : '<%=request.getContextPath()%>/pbsTestReport_savePbsTestReport.do',
		type : 'POST',
		dataType : 'json',
		data : $("#pbsTestReportForm").serializeArray(),
		success : function(data){
			var data = eval(data);
			if (data.result == "success") {
				//屏蔽室检测报告ID
				var pbsTestReportId = data.pbsTestReportId;
				saveAddTestDatas(pbsTestReportId);
				saveSelInstrument(pbsTestReportId);
				alert("保存成功");
				window.location.href = 'test_report_list.jsp';				
			}
		},
		error : function(data){
			alert("保存失败");
		}
	});
}

/*******ll s******/

$(function(){
	//单选按钮的点击事件
	$("[name='pictureType']").click(function(){
		var clazz = $(this).prop("class");
		$(".pictureDiv").css("display","none");//隐藏所有的div
		$("div."+clazz).css("display","block");
	});
	
	//显示申请信息
	showPbsApplyInfo();
	//显示所有屏蔽室检测仪器
	showInsTab();
});

// 显示屏蔽室申请信息
	function showPbsApplyInfo() {
		$.ajax({
			url : '${pageContext.request.contextPath}/pbsApplyInfo_selPbsApplyInfoById.do',
			data : {'pbsApplyId' : '<%= pbsApplyId%>'},
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
				
				//获取检测报告编号
				getPbstestReportNumber(info.pbsApplyGrade);
			}
		});
	}

//生成检测报告编号
function getPbstestReportNumber(grade){
	$.ajax({
		url:"{pageContext.request.contextPath}/pbsTestReport_selPbsTestReportNumber.do",
		data:{"pbsApplyGrade":grade},
		type:"post",
		dataType:"json",
		success:function(data){
				$("[name='pbsTestReport.testReportNumber']").val(data.testReportNumber);
				
			}
	})
}


//添加仪器
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
//删除所选行
  function delSeletedIns(obj){
		$(obj).parent().parent().remove();
	}
  
  //页面初始化显示所有屏蔽室检测仪器
  function showInsTab(){
		$.ajax({
			url : '${pageContext.request.contextPath}/ins_showInsTab.do',
			data : {'useType':'2'},
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
  //打开添加检测数据模态框
  function openTestDataModal(){
	  $(".addInfo").val('');
	  $("#addPbsTestDatas").modal("show");
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
	  $("#pbsTestReportId").val(pbsTestReportId);
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
      uploadAsync:false,//是否异步
      layoutTemplates:{//预览区域删除按钮与上传按钮的显示
          actionUpload:''//上传按钮不显示
     },
      autoReplace:true,//是否自动替换上一个文件
      enctype: 'multipart/form-data', 
      previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
      uploadExtraData: function (previewId, index) {//携带其他一些数据的格式
          var data = {
          	applyId:$("#hidden_apply_id").val(),//申请编号
          	pictureType:'1'//4代表是平面简图
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
   * 上传屏蔽室图片
   */
   $("#upEnvironmentPicture").fileinput({
  	    language: 'zh',//中文
  	    uploadUrl:"pbsMultipleFileUpAction.do",//上传的地址，加上这个才会出现删除按钮
  	    dropZoneEnabled: false,//是否显示拖拽区域
  	    showUpload: false, //是否显示上传按钮,跟随文本框的那个
  	    showRemove : true, //显示移除按钮,跟随文本框的那个
  	    showClose:false,//显示关闭按钮
  	    showCaption: true,//是否显示标题,就是那个文本框
  	    uploadAsync:false,//是否异步
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
      uploadUrl:"pbsMultipleFileUpAction.do",//上传的地址，加上这个才会出现删除按钮
      dropZoneEnabled: false,//是否显示拖拽区域
      showUpload: false, //是否显示上传按钮,跟随文本框的那个
      showRemove : true, //显示移除按钮,跟随文本框的那个
      showClose:false,//显示关闭按钮
      showCaption: true,//是否显示标题,就是那个文本框
      uploadAsync:false,//是否异步
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
  
  /*****S  保存图片信息***********/
	function savePicture(){
		//判断是否有图片选择并上传
		if(isSelectedFile("upPlanePicture")){
			$("#upPlanePicture").fileinput("upload");
		}
		//上传屏蔽室图片
		if(isSelectedFile("upEnvironmentPicture")){			
			$("#upEnvironmentPicture").fileinput("upload");
		}
		//上传检测过程
		if(isSelectedFile("upProcessPicture")){
			$("#upProcessPicture").fileinput("upload");
		}		
	}
		
	/**判断是否选上文件**/
	function isSelectedFile(inputId){
		var applyFile = $("#"+inputId)[0].files;
		var applyFile_length = applyFile.length;
		return applyFile_length>0?true:false;
	}  		
	
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
		//判断是否有图片选择并上传
		if(!isSelectedFile("upPlanePicture")){
			return true;
		}
		//上传屏蔽室图片
		if(!isSelectedFile("upEnvironmentPicture")){
			return true;
		}
		//上传检测过程
		if(!isSelectedFile("upProcessPicture")){
			return true;
		}		
		return false;
	}
	//验证检测数据信息
	function validateTestDatas(){
		if($("#pbsTestDataList").children("tr").length==0){
			return true;
		}
	}
	
	
</script>
</body>
</html>