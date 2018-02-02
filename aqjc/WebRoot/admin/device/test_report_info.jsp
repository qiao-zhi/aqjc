<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.tyust.bean.user.TBaseUserInfo" %>
<%@ page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.tyust.dao.unit.IunitDao,com.tyust.bean.unit.TBaseUnitInfo"%>
<%@ page import="java.util.*,com.tyust.common.DateHandler" %>
<%
	ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
	String unitId = request.getParameter("unitId");
	IunitDao unitDao = (IunitDao)context.getBean("Unit");
	TBaseUnitInfo unit = unitDao.findUnit(unitId);
	String applyId = request.getParameter("applyId");
	String testRptId = request.getParameter("testRptId");
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<jsp:include page="../common/include-commonNew.jsp"></jsp:include>

<style>
	.picTab td{padding-top:5px;padding-bottom:5px;}
	.picName {width:200px;}
</style>

<script>
$(function(){
	showReportInfo();
	showInsTab();
	showApplyDve();
});	
	//显示报告信息
	function showReportInfo(){
		$.ajax({
			url : '${pageContext.request.contextPath}/dveTestReport_selRptDetail.do',
			data : {'testRptId':'<%=testRptId %>'},
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var rptJson = eval(response);
				$("#testCodeInput").val(rptJson.TestCode);
				$("#testDateInput").val(rptJson.TestDate);
				$("#sampleNameInput").val(rptJson.SampleName);
				$("#wtUnitInput").val(rptJson.wtUnit);
				$("#testResult").val(rptJson.TestResult);
				$("#sampleState").val(rptJson.SampleState);
				var picJson = eval(response.picData);
				if(picJson.length>0){
					var num1 = "0";
					var num2 = "0";
					for(var v=0;v<picJson.length;v++){
						if(picJson[v].PicType=="1"){
							num1 = Number(num1)+1;
							$("#picTab1").append("<tr><td>检测照片"+num1+"</td>"+
									"<td style='text-align:center;'><img style='width:315px;height:230px' src='../../uploads/pic/"+picJson[v].PicUrl+"'/>"+
									"<input type='hidden' name='delPic' value='"+picJson[v].PicId+"'/></td></tr>");
						}else{
							num2 = Number(num2)+1;
							$("#picTab2").append("<tr><td>频谱照片"+num2+
									"<span style='padding-left:20px;'><img style='width:656px;height:230px' src='../../uploads/pic/"+picJson[v].PicUrl+"'/></span>"+
									"<input type='hidden' name='delPic' value='"+picJson[v].PicId+"'/></td></tr>");
						}
					}
				}
			}
		});
	};
	
	//显示已有的仪器
	function showInsTab(){
		$.ajax({
			url : '${pageContext.request.contextPath}/ins_showRptInstrument.do',
			data : {'rptId':'<%= testRptId%>'},
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var json = eval(response.data);
				if(json.length>0){
					for(var v=0;v<json.length;v++){
						$("#selectedInsTab").append("<tr><td>"+json[v].Name+"</td>"+
								"<td>"+json[v].Model+"</td>"+
								"<td>"+json[v].Code+"</td>"+
								"<td>"+json[v].Manufacturer+"</td>"+
								"</tr>");
					}
				}
			}
		});
	}
	
	//显示申请检测的设备
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
								"<td>"+type+"</td>"+
								"<td><input type='hidden' name='deviceId' value='"+json[v].deviceId+"'><input type='text' readonly='readonly' name='deviceLabel' value='"+json[v].deviceLabel+"'/></td></tr>");
					}
					$("#deviceNum").val(json.length);
				}
			}
		});
	};

</script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div id="Nav">
	<span>设备检测>>检测报告</span>
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
      </span>
      
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
       <div class="col-md-offset-1 col-md-9">

        <div class="box box-solid box-primary">
          <div class="box-header with-border">
            <h3 class="box-title">设备检测报告</h3>
          </div><!-- /.box-header -->
          <div class="box-body">
            <div class="row">
              <div class="col-sm-6">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">检测报告编号</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" readonly="readonly" id="testCodeInput">
                    </div>
                  </div>
                </form>
              </div>
              <div class="col-sm-6">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">检测日期</label>
                    <div class="col-sm-8">
                      <input class="form-control" id="testDateInput" readonly="readonly" name="testDate" >
                    </div>
                  </div>
                </form>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-6">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">申请单位</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" value="<%=unit.getUnitName() %>" readonly="readonly" >
                    </div>
                  </div>
                </form>
              </div>
              <div class="col-sm-6">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">委托单位</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" id="wtUnitInput" readonly="readonly">
                    </div>
                  </div>
                </form>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-6">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">设备数量</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" id="deviceNum" readonly="readonly">
                    </div>
                  </div>
                </form>
              </div>
              <div class="col-sm-6">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">样品名称</label>
                    <div class="col-sm-8">
                      <input id="sampleNameInput" class="form-control" readonly="readonly">
                    </div>
                  </div>
                  
                </form>
              </div>
            </div>

          </div><!-- /.box-body -->
        </div><!-- /.box -->
        <div class="box box-primary">
          <div class="box-header with-border">
            <h3 class="box-title">申请检测的设备</h3>
          </div><!-- /.box-header -->
          <div class="box-body">
            <table class="table table-bordered table-striped" id="selectedDveTab">
                <tr class="info">
                   <th>序号</th>
                  <th>设备名称</th>
                  <th>设备型号</th>
                  <th>设备序列号</th>
                  <th>设备类别</th>
                  <th>设备标签</th>
                </tr>
            </table>
          </div><!-- /.box-body -->
        </div><!-- /.box -->

        <div class="box box-primary">
            <div class="box-header">
              <h3 class="box-title">检测结论
              </h3>
            </div>
            <div class="box-body pad">             
                <textarea readonly="readonly" id="testResult" name="testResult" class="textarea333"  style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>     
            </div>
        </div>
		
		<div class="box box-primary">
            <div class="box-header">
              <h3 class="box-title">被测样品状态
              </h3>
            </div>
            <div class="box-body pad">             
                <textarea readonly="readonly" id="sampleState" name="sampleState" class="textarea333" style="width: 100%; height:100px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>     
            </div>
        </div>
        
        <div class="box box-primary">
          <div class="box-header with-border">
            <h3 class="box-title">检测仪器</h3>
          </div><!-- /.box-header -->
          <div class="box-body">
            <table class="table table-bordered table-striped" id="selectedInsTab">
                <tr class="info">
                  <th>仪器名称</th>
                  <th>仪器型号</th>
                  <th>仪器序列号</th>
                  <th>仪器厂商</th>
               
                </tr>
              </table>
          </div><!-- /.box-body -->
        </div><!-- /.box -->
	
        <div class="box box-primary">
          <div class="box-header with-border">
            <h3 class="box-title">检测设备及检测过程照片</h3>
          </div><!-- /.box-header -->
          <table id="picTab1" align="center" class="picTab" style="width:700px;" >
		 </table>
        </div>

        <div class="box box-primary">
          <div class="box-header with-border">
            <h3 class="box-title">检测过程频谱分析</h3>
          </div><!-- /.box-header -->
          <table id="picTab2" align="center" class="picTab" style="width:700px;" >
			</table>
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
<div id="chooseInsTab" style="width:750px;display: none">
		<table id="choose_ins_grid"></table>
</div>
</body>
</html>