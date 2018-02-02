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
<script>
$(function(){
	showApplyDetail();
	showApplyDve();
	showApplyAuditInfo();
});	
	
	function showApplyDetail(){
		$.ajax({
			url : '${pageContext.request.contextPath}/dveTestApply_selApplyDetail.do?applyId=<%= applyId%>',
			data : '',
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				var json = eval(data);
				$("#deviceNum").val(json.DeviceNum);
				$("#userName").val(json.User);
				$("#telePhone").val(json.Tel);
				$("#applyOpinion").val(json.ApplyOpinion);
				$("#unitName").val(json.Unit);
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
					$("#dveNum").val(json.length);
				}
			}
		});
	};
	
	function showApplyAuditInfo(){
		$.ajax({
			url : '${pageContext.request.contextPath}/dveTestApply_selApplyAuditInfo.do?applyId=<%= applyId%>',
			data : {},
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				var json = eval(data);
				$("#auditUser").val(json.user);
				$("#auditDate").val(json.AuditDate);
				$("#auditOpinion").val(json.AuditOppinion);
				$("#auditRes").text(json.AuditResult);
				var auditResult = json.AuditResult;
				if(auditResult == '已通过'){
					$("#devtz").attr('src','../../images/dev/devtz_pass.png'); 
				}					
				else{
					$("#devtz").attr('src','../../images/dev/devtz_notpass.png'); 
				}
				var picJson = eval(data.picData);
				if(picJson.length>0){
					var num1 = "0";
					for(var v=0;v<picJson.length;v++){				
						num1 = Number(num1)+1;
						$("#picTab1").append("<tr><td>扫描件图片"+num1+"</td>"+
								"<td style='text-align:center;'><a taget='_blank' href='../../uploads/smj/"+picJson[v].SmjUrl+"'>"+
								"<img style='width:315px;height:230px' src='../../uploads/smj/"+picJson[v].SmjUrl+"'/>"+
								"</a></td></tr>");			
					}
				}
			}
		});
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
            <div class="row">
              <div class="col-md-12">
                <table class="table table-bordered table-striped" id="selectedDveTab">
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
             	 <label class="col-sm-4 control-label">申请意见</label>
                <textarea  readonly="readonly" id="applyOpinion" name="deviceTestApply.applyOpinion" class="textarea333" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;">
                </textarea>
            <hr>
            <div class="row">
              <div class="col-sm-6">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">审核人</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" readonly="readonly" id="auditUser" />
                    </div>
                  </div>
                </form>
              </div>
              <div class="col-sm-6">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">审核时间</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" readonly="readonly" id="auditDate" />
                    </div>
                  </div>
                </form>
              </div>
            </div>
            <hr>
            	<label class="col-sm-4 control-label">审核意见</label>
                <textarea readonly="readonly" id="auditOpinion" class="textarea333" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
             <hr>
			 
			 
             <div class="row">
              <div class="col-sm-6">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">审核结果</label>
                    <div class="col-sm-8">
                      <span id="auditRes" style="display:none;padding-left:10px;padding-top:5px;padding-bottom:5px;font-size:25px;font-family:黑体;"></span>
                    </div>
                    <div class="col-sm-4">
      					<img   id="devtz" alt="审核结果" src="">     					
    				</div>
    				
                  </div>
				
                </form>
              </div>
            </div>    
			
			
          </div><!-- /.box-body -->
        </div><!-- /.box -->
 		<div class="box box-primary">
          <div class="box-header with-border">
            <h3 class="box-title">扫描件图片</h3>
          </div><!-- /.box-header -->
          <table id="picTab1" align="center" class="picTab" style="width:700px;" >
		 </table>
        </div>
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