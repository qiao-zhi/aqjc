<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.tyust.bean.user.TBaseUserInfo" %>
<%@ page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.tyust.dao.unit.IunitDao,com.tyust.bean.unit.TBaseUnitInfo"%>
<%
	TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
	ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
	String unitId = user.getUnitId();
	IunitDao unitDao = (IunitDao)context.getBean("Unit");
	TBaseUnitInfo unit = unitDao.findUnit(unitId);
	String applyId = request.getParameter("applyId");
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<jsp:include page="../common/include-commonNew.jsp"></jsp:include>
<style>
	.picTab td{padding-top:5px;padding-bottom:5px;}
</style>
<script type="text/javascript" src="yulan.js"></script>
<script>
$(function(){
	showApplyDetail();
	showApplyDve();
	showDevAttach2();
});	
	//获取申请表信息
	function showApplyDetail(){
		$.ajax({
			url : '${pageContext.request.contextPath}/dveTestApply_selApplyDetail.do?applyId=<%= applyId%>',
			data : '',
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				var json = eval(data);
				$("#dveNum").val(json.DeviceNum);
				$("#userName").val(json.User);
				$("#telePhone").val(json.Tel);
				$("#applyOpinion").val(json.ApplyOpinion);
				$("#unitName").val(json.Unit);
			}
		});
	}
	//获取申请检测设备信息；
	function showApplyDve(){
		$.ajax({
			url : '${pageContext.request.contextPath}/test_showApplyDve.do?applyId=<%= applyId%>',
			data : '',
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var json = eval(response.data);
				if(json.length>0){
					var rowSeq = 1;
					for(var v=0;v<json.length;v++){
						var type="";
						if(json[v].deviceType=="1"){
							type="新购";
						}else{
							type="维修后";
						}
						$("#selectedDveTab").append("<tr><td>"+(rowSeq++)+"</td><td>"+json[v].deviceName+"</td>"+
								"<td>"+json[v].deviceModel+"</td>"+
								"<td>"+json[v].deviceNum+"</td>"+
								"<td>"+type+"</td></tr>");
					}
				}
			}
		});
	};
	//获取申请书电子版
	function showDevAttach2(){
		$.ajax({
			url : '${pageContext.request.contextPath}/dveTestApply_selApplyAttach.do',
			data : {'devApplyId' : '<%= applyId%>'},
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var info = eval(response);
				var v = info[0];
				if (v == null) {
					// alert("附件为空");
				} else {
					var url = info[0].fileUrl;
					var fileName = info[0].fileName;
					var devAttachId = info[0].devAttachId;
					var URL = '${pageContext.request.contextPath}/dveTestApply_downAttach.do?filename='+url;
					$("#fileName2").append("<a href='"+URL+"'>"+fileName+"</a>");
				}
			}
		});
	} ;
	function auditApply(auditRes){
		$("#auditRes").val(auditRes);
		$("#auditOpinion").val($("#auditOpinionInput").val());
		$("#auditForm").submit();
		/*$.ajax({
			url : '${pageContext.request.contextPath}/dveTestApply_auditApply.do?applyId=< %= applyId%>',
			data : {'auditRes':auditRes,'auditOpinion':$("#auditOpinion").val()},
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				if(data.success){
					alert(data.message);
					window.location.href="apply_audit_list.jsp";
				}else{
					alert(data.message);
				}
			}
		});*/
	}
</script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div id="Nav">
	<span>设备检测>>审核申请</span>
	<a class="btn-nav" href="javascript:history.go(-1)">返回</a>
</div>
<div class="wrapper">

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
      </h1>
      <span class="breadcrumb">
        <a class="btn btn-app" href="javascript:void(0)" onclick="auditApply(1)">
           <i class="fa fa-check-square-o"></i>审核通过
        </a>
        <a class="btn btn-app" href="javascript:void(0)" onclick="auditApply(0)">
          <i class="fa fa-minus-square-o"></i>不通过
        </a>
      </span>
      
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
       <div class="col-md-offset-1 col-md-9">

        <div class="box box-solid box-primary">
          <div class="box-header with-border">
            <h3 class="box-title">设备检测申请</h3>
          </div><!-- /.box-header -->

          <div class="box-body pad">
            <div class="row">
              <div class="col-sm-6">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">申请单位</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" readonly="readonly" id="unitName">
                    </div>
                  </div>
                </form>
              </div>
              <div class="col-sm-6">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">设备数量</label>
                    <div class="col-sm-8">
                      <input id="dveNum" type="text" class="form-control" readonly="readonly" value="0">
                    </div>
                  </div>
                </form>
              </div>
            </div>
            <hr>
			<label class="col-sm-4 control-label">申请检测设备列表</label>
            <div class="row">
              <div class="col-md-12">
                <table class="table table-striped table-bordered table-hover" id="selectedDveTab"> 
					
                  <tr class="info">
                  	<th>序号</th>
                    <th>设备名称</th>             
                    <th>设备型号</th>
                    <th>设备序列号</th>
                    <th>设备类别</th>
                   
                  </tr>                 
                </table>
              </div>
            </div>
            <hr>
             <div class="row">
              <div class="col-sm-6">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">申请人</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" readonly="readonly" id="userName" />
                    </div>
                  </div>
                </form>
              </div>
              <div class="col-sm-6">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">联系方式</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" readonly="readonly" id="telePhone" />
                    </div>
                  </div>
                </form>
              </div>
            </div>
            <hr>
                <label class="col-sm-4 control-label">申请意见</label>
                <textarea  readonly="readonly" id="applyOpinion" class="textarea333" style="width: 100%; height: 100px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;">
                </textarea>
            <hr>   
			
			<label class="col-sm-4 control-label">申请书电子版</label>
				
				<div class="box-body">
					<div class="row" id="file2">
						<div class="col-sm-8">
							<div id="fileName2"></div>
						</div>
					</div>
				</div>
			<hr>
		
            	<label class="col-sm-4 control-label">审核意见</label>
                <textarea  id="auditOpinionInput" class="textarea333" style="width: 100%; height: 100px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>            
          </div><!-- /.box-body -->
        </div><!-- /.box -->
        
        
        <form id="auditForm" action="<%=request.getContextPath()%>/dveTestApply_auditApply.do" method="post" enctype="multipart/form-data">
		<div class="box box-primary">
          <div class="box-header with-border">
            <h3 class="box-title">申请书扫描件上传</h3>
          </div><!-- /.box-header -->
          <table id="picTab1" align="center" class="picTab" style="width:700px;" >
				<tr>	
					<td class="input-td">
						<input type="file" id="1" name="testPic" onchange="addFile1(this)" />
					</td>
					<td>
						<div id="localImag1" align="center">
							<img id="preview1" src="../../uploads/image/noPic1.PNG" style="display: block; width: 315px; height: 230px;">
						</div>
					</td>
				</tr>
		 </table>
        </div>
        
        <input name="applyId" type="hidden" value="<%= applyId%>"/>
        <input id="auditRes" name="auditRes" type="hidden" />
        <input id="auditOpinion"  name="auditOpinion" type="hidden" />
        </form>
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