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
<meta http-equiv="Content-Type" content="text/html; charset=gbk">

<title></title>
<jsp:include page="../common/include-commonNew.jsp"></jsp:include>

<script>
	$(function(){
		showApplyDetail();
		showApplyDve();
		showDevAttach2();
	});	
	
	function showApplyDetail(){
		$.ajax({
			url : '${pageContext.request.contextPath}/dveTestApply_selApplyDetail.do?applyId=<%= applyId%>',
			data : '',
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				var json = eval(data);
				$("#unitName").val(json.Unit);
				$("#dveNum").val(json.DeviceNum);
				$("#userName").val(json.User);
				$("#telePhone").val(json.Tel);
				$("#applyOpinion").val(json.ApplyOpinion);
				$("#applyDate").val(json.applyDate);
			}
		});
	}
	
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
	}
	
	
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
	}
	
	 function indexFormatter(value, row, index) {
	      return index+1;
	 }
	
</script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div id="Nav">
	<span>设备检测>>查看申请</span>
	<a class="btn-nav" href="javascript:history.go(-1)">返回</a>
</div>
<div class="wrapper">

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
      </h1>
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
                    <!-- <%=unit.getUnitName() %> -->
                      <input id="unitName" type="text" class="form-control" readonly="readonly" >
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
            <div class="row">
              <div class="col-md-12">
                <table class="table table-bordered table-striped" id="selectedDveTab">
                  <tr class="info">
                    <th>序号</th>
                    <th>设备名称</th>             
                    <th>设备型号</th>
                    <th>设备序列号</th>
                    <th>设备类别</th>
                    <!-- <th> </th> -->
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
            
            <div class="row">
					<div class="col-sm-6">
						<form class="form-horizontal">
							<div class="form-group">
								<label for="applyDate" class="col-sm-4 control-label">申请日期</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="applyDate" name="applyDate" readonly="readonly" />
								</div>
							</div>
						</form>
					</div>
			 </div>
            <hr>
             <form id="applyFm">
             	 <label class="col-sm-4 control-label">申请意见</label>
                <textarea readonly="readonly" id="applyOpinion" name="deviceTestApply.applyOpinion" class="textarea333" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;">
                </textarea>
              </form>
              
             <div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title">申请书电子版</h3>
				</div>
				<div class="box-body">
					<div class="row" id="file2">
						<div class="col-sm-8">
							<div id="fileName2"></div>
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