<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String enApplyId = request.getParameter("enApplyId");
	String enTestReportId = request.getParameter("enTestReportId");
%>
<%@include file="/public/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>查看检测报告</title>
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
       .imageDiv{float: left;margin-left: 10px;margin-top:10px;}
       .deleteImgA{display: block;text-align: center}
        .priImg{height:200px;width:200px;}
        input,textarea {
			background-color: #ffffff !important;
		}
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
                      <input type="text" class="form-control" disabled readonly="readonly" id="applyUnitName">
                      <input type="hidden" class="form-control" id="enApplyUnitId">
                    </div>
                  </div>
              </div>
              <div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">申请日期</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" readonly="readonly" disabled id="applyDate">
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
                      <input type="text" class="form-control" readonly="readonly" disabled id="applyUsername">
                    </div>
                  </div>
              </div>
              <div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">联系方式</label>
                    <div class="col-sm-8">
                      <input id="appPhone" type="text" class="form-control" disabled readonly="readonly" >
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
                      <input type="text" class="form-control" readonly="readonly" disabled name="enTestReport.testSampleName" id="yangpinmingcheng">
                    </div>
                  </div>
              </div>
              <div class="col-sm-6">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">生产单位</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" readonly="readonly" disabled name="enTestReport.environmentApplyProduction" id="manuUnit">
                    </div>
                  </div>
               </div>
              </div>
            
              <div class="row">
                <div class="col-sm-6">
                   <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label" >报告编号</label>
                    <div class="col-sm-8">
                      <input id="testReportNumber" name="enTestReport.testReportNumber" disabled readonly style="background-color:#ffffff;" type="text" class="form-control">
                    </div>
                   </div>
                </div>
                <div class="col-sm-6">
                   <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">检测日期</label>
                    <div class="col-sm-8">
                      <input id="testDate" name="enTestReport.testDate" type="text" disabled class="form-control"
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
                      <input id="testUserName" name="enTestReport.testUserName" disabled type="text" class="form-control">
                    </div>
                  </div>
                </div>
                <div class="col-sm-6">
                   <div class="form-group">
                     <label for="input1" class="col-sm-4 control-label">委托单位</label>
                    <div class="col-sm-8">
                      <input id="testUnitName" name="enTestReport.testUnitName" disabled type="text" class="form-control">
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
	                      <input type="checkbox" name="enTestReport.testProject" disabled value="物理检查">物理检查&nbsp;&nbsp;
	                      <input type="checkbox" name="enTestReport.testProject" disabled value="无线信号检查">无线信号检查&nbsp;&nbsp;
	                      <input type="checkbox" name="enTestReport.testProject" disabled value="通信模块检查">通信模块检查
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
	                      <input type="text" name="enTestReport.testCriterion" class="form-control" disabled id="testCriterion">
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
	                      <input type="text" class="form-control" disabled name="enTestReport.testLocation" id="testLocation">
	                    </div>
	                  </div>
	              </div>
              </div>
              			<br/>
            		  <label for="input1" class="col-sm-2 control-label">检测结论</label>
              			<br/>
               		 <textarea id="testResult" name="enTestReport.testResult" disabled class="textarea333" placeholder="请填写检测结论" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>     
           		 </div>
       		 	</div>
              	</div>
              </div>
              	<!--  隐藏检测编号-->
              	<input type="hidden" name="enTestReport.environmentTestReportId" id="environmentTestReportId" value="<%=enTestReportId%>"/>
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
			                      <input type="text" id="createTime" name="enTestReport.createTime" disabled class="form-control" />
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
											<input type="text" id="environmentSize" disabled class="form-control" name="enTestReport.environmentSize">
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
		                      <input type="text" id="environmentStatus" disabled name="enTestReport.environmentStatus" class="form-control" />
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
                
                
                <div id="imgBigDiv">
 					<div class="box-body planePicture pictureDiv" id="pingmianDiv" style="margin-top:20px;">
								<!-- 存放之前已经选好的图片 -->
								<div id="pingmianPriviousDiv">
										<!-- 提示语 -->
										<p>下面是您之前已经上传的照片，点击图片可以查看!</p>
									   <!--  <div class="imageDiv">
									        <img src="http://localhost/picture/0b6c3372f3fc4ebb884eb228f5d46364.png" class="priImg">
									        <a href="javascript:void(0)" class="deleteImgA">删除</a>
									    </div > -->
								</div>
					</div>
					
					
 					<div class="box-body  environmentPicture pictureDiv" id="XX" style="margin-top:20px;display:none;">
								<!-- 存放之前已经选好的图片 -->
								<div id="enviPriviousDiv">
										<!-- 提示语 -->
										<p>下面是您之前已经上传的照片，点击图片可以查看!</p>
									    <!-- <div class="imageDiv">
									        <img src="http://localhost/picture/0b6c3372f3fc4ebb884eb228f5d46364.png" class="priImg">
									        <a href="javascript:void(0)" class="deleteImgA">删除</a>
									    </div > -->
								</div>
					</div>
					
					
 					<div class="box-body processPicture pictureDiv" id="XXX"  style="margin-top:20px;display:none;">
								<!-- 存放之前已经选好的图片 -->
								<div id="processPriviousDiv">
										<!-- 提示语 -->
										<p>下面是您之前已经上传的照片，点击图片可以查看!</p>
									    <!-- <div class="imageDiv">
									        <img src="http://localhost/picture/0b6c3372f3fc4ebb884eb228f5d46364.png" class="priImg">
									        <a href="javascript:void(0)" class="deleteImgA">删除</a>
									    </div > -->
								</div>
					</div>
					
					
 					<div class="box-body frequencyPicture pictureDiv" id="XXXX"  style="margin-top:20px;display:none;">
								<!-- 存放之前已经选好的图片 -->
								<div id="frequencyPriviousDiv">
										<!-- 提示语 -->
										<p>下面是您之前已经上传的照片，点击图片可以查看!</p>
									    <!-- <div class="imageDiv">
									        <img src="http://localhost/picture/0b6c3372f3fc4ebb884eb228f5d46364.png" class="priImg">
									        <a href="javascript:void(0)" class="deleteImgA">删除</a>
									    </div > -->
								</div>
					</div>
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
    
    
    
    
     <!-- S   预览照片模态框-->
     <!-- /.content -->           
     <div id="imgModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel111" aria-hidden="true">
      <div class="modal-dialog">
		<div class="modal-content">
			
             <div class="box-body">
             		 <span style="">
             		 	<img alt="" src="${baseurl }/images/left.jpg" style="width:40px;height:60px;margin-top:20%" title="点击查看上一张" onclick="lastImg()">
             		 </span>
             		<span>
             			<img id="dynamicImage" src=""  style="width:83%;height:83%">
             		</span>
             		<span style="">
             			<img alt="" src="${baseurl }/images/right.jpg" style="width:40px;height:60px;margin-top:20%" title="点击查看下一张" onclick="nextImg()">
           			</span>
         	</div><!-- /.box-body -->
        </div>
     </div>
   </div> 
     <!-- E   预览照片模态框-->
     
     
  </div>
  <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->
<!--S  QLQ最后引入，放开头不起作用  -->
<script src="${baseurl}/jscript/sys/environment/viewEnTestReport.js"
		type="text/javascript"></script>
<!--E  QLQ最后引入，放开头不起作用  -->
</body>
</html>