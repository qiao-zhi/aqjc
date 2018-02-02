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
<script type="text/javascript" src="yulan.js"></script>
<script type="text/javascript">
$(function(){
	showReportInfo();
	showInsTab();
	showApplyDve();
	$("#choose_ins_grid").flexigrid({   
		url: '${pageContext.request.contextPath}/ins_chooseInsList.do',
	    dataType: 'json',
	    display : 'true',   
	    colModel : [   
	      {display: '主键', name : 'InstrumentId', width : 70, sortable : true, align: 'center',hide: true},
	      {display: '仪器名称', name : 'Name', width : 150, sortable : true, align: 'center'},
	      {display: '仪器型号', name : 'Model', width : 150, sortable : true, align: 'center'},
	      {display: '仪器序列号', name : 'Code', width : 150, sortable : true, align: 'center'},
	      {display: '仪器厂商', name : 'Manufacturer', width : 150, sortable : true, align: 'center'}
				],
		buttons : [
				{name : '确定',onpress : action},
				{separator: true}
			],
	        sortname: "name",   
	        sortorder: "desc",   
	        usepager: false,
	        checkbox : true,
	        title: '请勾选要添加的仪器',	
	        width: 'auto',
	        height:'auto',
	        wjsearch:[{name:'existInsIds',value: '0'},{name:'useType',value:'1'}]
		});
	function action(com, grid) {
		switch (com) {
			case '确定' :
				selected_count = $('.trSelected', grid).length;
				if (selected_count == 0) {
					alert('请选择至少一个仪器!');
					return;
				}
				//var selectedData = [];
				$('.trSelected', grid).each(function(i) {
				  	$("#selectedInsTab").append("<tr><td><input name='insId' type='hidden' value='"+$(this).children('td').eq(0).children('div').text()+
				  					"'/>"+$(this).children('td').eq(1).children('div').text()+"</td>"+
									"<td>"+$(this).children('td').eq(2).children('div').text()+"</td>"+
									"<td>"+$(this).children('td').eq(3).children('div').text()+"</td>"+
									"<td>"+$(this).children('td').eq(4).children('div').text()+"</td>"+
									"<td><input name='newSelIns' type='hidden' value='"+$(this).children('td').eq(0).children('div').text()+
									"'/><a href='javascript:void(0)' title='删除仪器' onclick='delSeletedIns(this)'><i class='fa fa-trash fa-lg' ></i></td></tr>");
				});
				$.dialog.get('idAdd').close();
				//$('#flex1').reload();
				break;
		}
	};
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
							$("#picTab1").append("<tr><td>已上传照片"+num1+"：<table><tr><td><input name='testPicName1' type='text' class='picName' value="+picJson[v].picName+" /></td></tr></table>"+"<a href='javascript:void(0)' onclick='delExistPic(this)'>  (删除)</a>"+
									"<input type='hidden' name='delPic' value='"+picJson[v].PicId+"'/></td>"+
									"<td style='text-align:center;'><img style='width:315px;height:230px' src='../../uploads/pic/"+picJson[v].PicUrl+"'/>"+
									"</td></tr>");
						}else{
							num2 = Number(num2)+1;
							$("#picTab2").append("<tr><td>已上传照片"+num2+"<a href='javascript:void(0)' onclick='delExistPic(this)'> (删除)</a>"+
									"<span style='padding-left:20px;'><img style='width:656px;height:230px' src='../../uploads/pic/"+picJson[v].PicUrl+"'/></span>"+
									"<input type='hidden' name='delPic' value='"+picJson[v].PicId+"'/></td></tr>");
						}
					}
				}
				$("#picTab1").append("<tr><td class='input-td'><table><tr><td><input id='1' name='testPic' type='file' onchange='addFile1(this)'/></td></tr><tr><td>照片名称：<input name='testPicName1' type='text' class='picName'/></td></tr></table>"+
						"<span><a href='javascript:void(0)' onclick='del_file(this)'>(删除)</a></span></td>"+
						"<td><div align='center' id='localImag1'><img id='preview1' src='../../uploads/image/noPic1.PNG' style='display: block; width: 315px; height: 230px;'></div>"+
						"</td></tr>");

				$("#picTab2").append("<tr><td><div style='padding-top:15px;'><table><tr><td><input id='100' name='pinpuPic' type='file' onchange='addFile2(this)'/></td></tr><tr><td>照片名称：<input name='pintuPicName1' type='text' class='picName'/></td></tr></table>"+
						"<a href='javascript:void(0)' onclick='del_file(this)'>(删除)</a></div>"+
						"<div align='center' id='localImag100'><img id='preview100' src='../../uploads/image/noPic2.PNG' style='display: block; width: 656px; height: 230px;'></div>"+
						"</td></tr>");
			}
		});
	};
	
	//选择仪器
	function chooseInsDialog(){
		var v = $("#selectedInsTab tr").length;
		var insIdStr = "";
		if(v>1){
			$("input[name='insId']").each(function(index,item){
				insIdStr=insIdStr+$(this).val()+",";
			});
		}
		var k = {wjsearch:[{name:'existInsIds',value: insIdStr},{name:'useType',value:'1'}]};
		$('#choose_ins_grid').flexReload(k);
		$.dialog({
			content:$("#chooseInsTab")[0],
			title:'添加仪器',
			id:'idAdd',
			lock :true,
			background :'#245EDC',
			opacity:0.5
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
						$("#selectedInsTab").append("<tr><td><input type='hidden' name='insId' value='"+json[v].InstrumentId+"'/>"+json[v].Name+"</td>"+
								"<td>"+json[v].Model+"</td>"+
								"<td>"+json[v].Code+"</td>"+
								"<td>"+json[v].Manufacturer+"</td>"+
								"<td><input type='hidden' value='"+json[v].Remark+"'><a href='javascript:void(0)' onclick='delExistIns(this)'><i class='fa fa-trash fa-lg'></i></td></tr>");
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
								"<td><input type='hidden' name='deviceId' value='"+json[v].deviceId+"'><input type='text' size='25' name='deviceLabel' value='"+json[v].deviceLabel+"' /></td></tr>");
					}
					$("#deviceNum").val(json.length);
				}
			}
		});
	};
	
	
	function delSeletedIns(obj){
		$(obj).parent().parent().remove();
	}
	function delExistIns(obj){
		var id = $(obj).parent().children("input").val();
		$("#delInsId").val($("#delInsId").val()+id+",");
		$(obj).parent().parent().remove();
	}
	function delExistPic(obj){
		var picid = $(obj).parent().children("input").val();
		$("#delPicId").val($("#delPicId").val()+picid+",");
		$(obj).parent().parent().remove();
	}


	//保存或提交检测报告 flag=save：保存 flag=sub：提交 
	//存在问题：提交时候，没有对图片数量进行验证，至少需要1张图片
	function saveTestReport(flag){
		if(flag == "sub"){
			if (!confirm("确定要提交检测报告吗？\n提交后报告将不可修改！")){
				return;
			}
		}
		
		$("#operate").val(flag);

		var isOK = true;// isOK验收合格标记

		// 获取设备编号
		var deviceIdStr = "";//所有待检测设备的编号
		var deviceLabelStr = "";//所有待检测设备的标签
		$("input[name='deviceId']").each(function(index,item){
			var id = $(this).val();
			deviceIdStr = deviceIdStr+id+",";
		});
		// 1、对设备标签进行验证
		$("input[name='deviceLabel']").each(function(index,item){
			var label = $(this).val();
			deviceLabelStr = deviceLabelStr+label+",";
			//alert("设备标签"+label);
			if(flag == "sub" && label == ""){
				alert("请输入设备标签");
				isOK = false;
				return;
			}
		});

		// 2、对检测仪器进行验证
		var v = $("#selectedInsTab tr").length;
		// 除了表头之外，因此v>1判断是否选择了检测仪器
		if(v>1){
			// 获取所有新增的检测仪器编号
			var insIdStr = "";
			$("input[name='newSelIns']").each(function(index,item){
				insIdStr=insIdStr+$(this).val()+",";
			});
		}else{
			alert("请选择检测仪器");
			return;
		}


		// 对图片名称校验
		var test = $("input[name='testPicName1']").length;
		for(var i=0; i<test; i++) {
			var val = $("input[name='testPicName1']").get(i).value;
			if(test == (i+1)){
				break;
			}
			if(val == "" || val == null) {
				alert("请输入图片名称");
				isOK = false;
				return;
			}
		}

		//对频谱图片名称验证 
		var pintu = $("input[name='pintuPicName1']").length;
		for(var j=0;j<pintu;j++) {
			var val1 = $("input[name='pintuPicName1']").get(j).value;
			if(pintu == (j+1)){
				break;
			}
			if(val1 == "" || val1 == null) {
				alert("请输入频谱图片名称");
				isOK = false;
				return;
			}
		}

		//检测其余必填项
		if (flag =="sub") {
			if($("#wtUnitInput").val() ==""){
				alert("请输入委托单位！");	
				return;
			}
			if($("#sampleNameInput").val() == ""){
				alert("请输入样品名称");
				return;
			}
		}
		//为表单input赋值，提交表单
		if(isOK){
			$("#newSelInsId").val(insIdStr);//
			$("#testDate").val($("#testDateInput").val());//
			$("#sampleName").val($("#sampleNameInput").val());//
			$("#wtUnit").val($("#wtUnitInput").val());//
			$("#testDeviceId").val(deviceIdStr);//
			$("#testDeviceLabel").val(deviceLabelStr);//
			$("#testReportFm").submit();//
		}else{
			alert("请完善信息");
		}
	}

</script>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div id="Nav">
	<span>设备检测>>填写检测报告</span>
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
        <a class="btn btn-app" href="javascript:void(0)" onclick="saveTestReport('save')">
          <i class="fa fa-save"></i> 保存
        </a>
        <a class="btn btn-app" href="javascript:void(0)" onclick="saveTestReport('sub')">
          <i class="fa fa-check-square-o"></i> 提交
        </a>
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
                      <input class="form-control" id="testDateInput" value="<%= DateHandler.dateToString(new Date()) %>" name="testDate" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})">
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
                      <input type="text" class="form-control" id="wtUnitInput" placeholder="请输入委托单位">
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
                      <input id="sampleNameInput" class="form-control" placeholder="请输入样品名称">
                    </div>
                  </div>
                  
                </form>
              </div>
            </div>

          </div><!-- /.box-body -->
        </div><!-- /.box -->
	<form id="testReportFm" action="<%=request.getContextPath()%>/dveTestReport_updTestReport.do" method="post" enctype="multipart/form-data">
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
                <textarea id="testResult" name="testResult" class="textarea333" placeholder="请填写检测结论" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>     
            </div>
        </div>
		
		<div class="box box-primary">
            <div class="box-header">
              <h3 class="box-title">被测样品状态
              </h3>
            </div>
            <div class="box-body pad">             
                <textarea id="sampleState" name="sampleState" class="textarea333" placeholder="请填写被测样品状态"  style="width: 100%; height:100px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>     
            </div>
        </div>
        
        <div class="box box-primary">
          <div class="box-header with-border">
            <h3 class="box-title">检测仪器</h3>
            <button type="button" class="btn btn-primary pull-right" onclick="chooseInsDialog()">添加仪器</button>
          </div><!-- /.box-header -->
          <div class="box-body">
            <table class="table table-bordered table-striped" id="selectedInsTab">
                <tr class="info">
                  <th>仪器名称</th>
                  <th>仪器型号</th>
                  <th>仪器序列号</th>
                  <th>仪器厂商</th>
                  <th>操作 </th>
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
       <input type="hidden" id="testRptId" name="testRptId" value="<%= testRptId%>"/>
		<input type="hidden" id="delInsId" name="delInsId" value=""/>
		<input type="hidden" id="delPicId" name="delPicId" value=""/>
		<input type="hidden" id="newSelInsId" name="newSelInsId" />
        <input type="hidden" id="testDate" name="testDate"/>
        <input type="hidden" id="sampleName" name="sampleName"/>
        <input type="hidden" id="wtUnit" name="wtUnit"/>
        <input type="hidden" id="operate" name="operate" />
        <input type="hidden" id="testDeviceId" name="testDeviceId"/>
        <input type="hidden" id="testDeviceLabel" name="testDeviceLabel"/>
        
        <input type="hidden" name="unitId" value="<%= unitId %>"/>
        <input type="hidden" name="applyId" value="<%= applyId %>"/>
        
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
<div id="chooseInsTab" style="width:750px;display: none">
		<table id="choose_ins_grid"></table>
</div>
</body>
</html>