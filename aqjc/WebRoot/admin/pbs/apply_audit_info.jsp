<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
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
<!DOCTYPE html>
<html>
<head>
	<title>屏蔽室申请</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

	<%-- <link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/font-awesome-4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/ionicons-2.0.1/css/ionicons.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/dist/css/AdminLTE.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/plugins/iCheck/flat/blue.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/dist/css/skins/skin-blue.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/lightbox/css/lightbox.min.css" />
 --%>	
	<!-- ll s -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/font-awesome-4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/ionicons-2.0.1/css/ionicons.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/dist/css/AdminLTE.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/plugins/iCheck/flat/blue.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/dist/css/skins/skin-blue.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/plugins/select2/select2.css">
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/webuploader/css/webuploader.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/webuploader/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/lightbox/css/lightbox.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/css/fileinput.min.css" />
    <!-- ll e -->
	
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
            <h3 class="box-title">屏蔽室申请审核</h3>
          </div><!-- /.box-header -->

          <div class="box-body pad">
            <div class="row">
              <div class="col-md-8 col-md-offset-2">
            	<div class="box box-info">
             <div class="box-header with-border">
                <h3 class="box-title">基本信息</h3>
             </div>
            <div class="box-body">
              <form id="pbsApplyInfo_form" class="form-horizontal">
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
                
                <!--S 新增字段 ll -->
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
						<input id="pbsApplyGrade"  readonly="readonly" type="text" class="form-control" >
                     </div>
                    </div>
                  </div>
                </div>
                
                <div class="row">
					<div class="col-sm-12">
						<div class="form-group">
							<label for="input1" class="col-sm-2 control-label">申请意见</label>
							<div class="col-sm-10">
								<textarea id="pbsApplyOpinion" readonly="readonly" name="pbsApplyInfo.pbsApplyOpinion" class="textarea333" placeholder="请填写申请意见" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
							</div>
						</div>
					</div>
				</div>
                <!--D 新增字段 ll -->
                
                <!-- 隐藏 -->
                <input type="hidden" id="operate" name="operate" value="add"/>
                </form>
             </div>
            </div>
            
            <div class="box box-info">
              <div class="box-header with-border">
                <h3 class="box-title">申请书扫描照片</h3>
              </div>
              <div class="box-body">
         		<div id="fileName1"></div>
              </div>
            </div>
            
            <div class="box box-info">
              <div class="box-header with-border">
                <h3 class="box-title">申请书电子版</h3>
              </div>
              <div class="box-body">
              		<div id="fileName2"></div>
              </div>
            </div>
            <!-- ll 增加审核信息 -->
            <div class="box box-info">
              <div class="box-header with-border">
                <h3 class="box-title">审核内容</h3>
              </div>


		      <div class="box-body">
		      
		      
		       <div class="row">
                  <div class="col-sm-6">
                    <div class="form-group">
                    <label for="input1" class="col-sm-3 control-label">审核人</label>
                    <div class="col-sm-8">
                      <input id="auditUserName" type="text" class="form-control" readonly>
                    </div>
                    </div>
                   </div>
                   
                <div class="col-sm-6">
                  <div class="form-group">
                    <label for="pbsApplyDate" class="col-sm-4 control-label">审核日期</label>
                    <div class="col-sm-8">
                      <input id="auditDate" type="text" class="form-control" readonly
                      onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})">
                    </div>
                  </div>
                 </div>
                </div>
		      	<br/>
		      	<br/>
              	 <div class="row">
              		 <div class="form-group">
                   		 <label for="pbsApplyDate" class="col-sm-4 control-label">审核意见</label>
	              	 	<div class="col-sm-12">
	              	 		<br/>
	               			<textarea id="auditOppinion"  class="textarea333" placeholder="请填写审核意见" readonly style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>     
	              		</div>
              		</div>
              	 </div>
              	 <!-- 审核结果 -->
              	  <div class="row">
		              <div class="col-sm-6">
		                <form class="form-horizontal">
		                  <div class="form-group">
		                    <label for="input1" class="col-sm-4 control-label">审核结果</label>
		                    <div class="col-sm-8">
		                     <!--  <span id="auditResult" style="padding-left:10px;padding-top:5px;padding-bottom:5px;font-size:25px;font-family:黑体;"></span> -->
		                   	  <img id="devtz" alt="审核结果" src="../../images/dev/devtz_pass.png">		                   	 
		                    </div>
		                  </div>
		                </form>
		              </div>
	            	</div> 
            	              	 
            <!-- ll 增加审核信息 -->
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
<script src="<%=request.getContextPath() %>/newStyle/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/lightbox/js/lightbox-plus-jquery.min.js"></script>
<script>
	$(function() {
		showPbsApplyInfo();
		showPbsAttach1();
		showPbsAttach2();
		showPbsAuditInfo();
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
			}
		});
	}
	
	
	function showPbsAttach1(){
		$.ajax({
			url : '${pageContext.request.contextPath}/pbsApplyInfo_selPbsAttach.do',
			data : {'pbsApplyId' : '<%= pbsApplyId%>',
				'pbsAttachType' : '1'},
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var info = eval(response);
				var url = info[0].fileUrl;
				var fileName = info[0].fileName;
				var fileUrl = info[0].pbsAttachUrl;
				//在线预览PDF
				var URL ='/pbs/file/'+fileUrl;
				//var URL = '${pageContext.request.contextPath}/pbsApplyInfo_downAttach.do?filename='+url;
				$("#fileName1").append("<a href='"+URL+"' target='_blank'>"+fileName+"</a>");
			}
		});
	}
	
	function showPbsAttach2(){
		$.ajax({
			url : '${pageContext.request.contextPath}/pbsApplyInfo_selPbsAttach.do',
			data : {'pbsApplyId' : '<%= pbsApplyId%>',
				'pbsAttachType' : '2'},
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var info = eval(response);
				var url = info[0].fileUrl;
				var fileName = info[0].fileName;
				var fileUrl = info[0].pbsAttachUrl;
				//在线预览PDF
				var URL ='/pbs/file/'+fileUrl;
				//var URL = '${pageContext.request.contextPath}/pbsApplyInfo_downAttach.do?filename='+url;
				$("#fileName2").append("<a href='"+URL+"' target='_blank'>"+fileName+"</a>");
			}
		});
	}
	
	function showPbsAuditInfo(){
		$.ajax({
			url:"${pageContext.request.contextPath}/pbsApplyInfo_selEnApplyAudit.do",
			data:{"pbsApplyId":'<%= pbsApplyId%>'},
			type:"post",
			dataType:"json",
			success:function(responce){
				var audit = eval(responce);
				$("#auditOppinion").val(audit.auditOppinion);
				$("#auditDate").val(audit.auditDate);
				$("#auditUserName").val(audit.auditUser);
				if(audit.auditResult == "1"){
					//$("#auditResult").html("通过");
					$("#devtz").prop("src","../../images/dev/devtz_pass.png");
				} else if(audit.auditResult == "2"){
					//$("#auditResult").html("不通过");
					$("#devtz").prop("src","../../images/dev/devtz_notpass.png");
				}
			},
			error:function(){
				alert("加载审核信息失败！")
			}
		})
	}
	
</script>
</body>
</html>