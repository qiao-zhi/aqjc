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
	showInsTab();//显示检测仪器
	showApplyDve();//显示申请设备列表
	// 显示检测所需要的仪器
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
									"<td><a href='javascript:void(0)' title='删除仪器' onclick='delSeletedIns(this)'><i class='fa fa-trash' style='font-size: 20px;' ></i></td></tr>");
				});
				$.dialog.get('idAdd').close();
				//$('#flex1').reload();
				break;
		}
	};
});	


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


	function showInsTab(){
		$.ajax({
			url : '${pageContext.request.contextPath}/ins_showInsTab.do',
			data : {'useType':'1'},
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
								"<td><a href='javascript:void(0)' onclick='delSeletedIns(this)'><i class='fa fa-trash'></i></td></tr>");
					}
				}
			}
		});
	}
	
	// 获取并显示申请的设备
	function showApplyDve(){
		$.ajax({
			url : '${pageContext.request.contextPath}/test_showApplyDve.do?applyId=<%= applyId%>',
			data : '',
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var json = eval(response.data);
				if(json.length>0){
					
					for(var v=0;v<json.length;v++)	{					
						var type="";
						(json[v].deviceType == "1") ? type="新购": type="维修后";
						$("#selectedDveTab").append("<tr><td>"+(v+1)+"</td><td>"+json[v].deviceName+"</td>"+
								"<td>"+json[v].deviceModel+"</td>"+
								"<td>"+json[v].deviceNum+"</td>"+
								"<td>"+type+"</td>"+
								"<td><input type='hidden' name='deviceId' value='"+json[v].deviceId+"'/> <input type='text' name='deviceLabel' size='20'/></td></tr>");
					}
				}
				$("#deviceNum").val(json.length);
				
				showReportCode(json.length);
			}
		});
	};
	
	function delSeletedIns(obj){
		$(obj).parent().parent().remove();
	};
	
	function showReportCode(dveCount){
		$.ajax({
			url : '${pageContext.request.contextPath}/dveTestReport_showReportCode.do',
			data : {'unitSx':'<%=unit.getUnitClass() %>','dveCount':dveCount},
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var json = eval(response);
				$("#testCodeInput").val(json.rptCode);
			}
		});
	};


	/*
		根据flag对检测报告进行保存或修改 
		falg:save-保存；sub-修改
		2017-5-23 做了如下修改
		1、当保存时，不需要对任何信息进行验证；
		2、当提交时，需要对下面信息进行验证
		（1）设备标签；
		（2）检测仪器；
		（3）检测过程照片
		（4）频谱分析照片
		（5）检测样品名称、委托单位、检测结论、被测样品状态
	 */
	function saveTestReport(flag){
		if(flag == "sub"){
			if (!confirm("确定要提交检测报告吗？\n提交后报告将不可修改！")){
				return;
			}
		}
		
		$("#operate").val(flag);
		var isOK = true;


		var deviceIdStr = "";	 //设备编号
		var deviceLabelStr = ""; //设备标签
		// 获取所有的设备编号，为修改设备标签做好准备
		$("input[name='deviceId']").each(function(index,item){
			var id = $(this).val();
			deviceIdStr = deviceIdStr+id+",";
		});

		// 设备标签的验证
		$("input[name='deviceLabel']").each(function(index,item){
			var label = $(this).val();
			//alert("设备标签"+label);
			deviceLabelStr = deviceLabelStr+label+",";
			if(flag == "sub" && label == ""){
				alert("请输入设备标签");
				isOK = false;
				return;
			}
		});

		// 检测过程图片名称校验
		var test = $("input[name='testPicName1']").length;
		for(var i=0; i<test; i++) {
			var val = $("input[name='testPicName1']").get(i).value;
			if(test == (i+1)){
				break;
			}
			if(flag == "sub" && (val == "" || val == null)) {
				alert("请输入图片名称");
				return;
			}
		}

		// 频谱分析图片名称检测
		var pintu = $("input[name='pintuPicName1']").length;
		for(var j=0;j<pintu;j++) {
			var val1 = $("input[name='pintuPicName1']").get(j).value;
			if(pintu == (j+1)){
				break;
			}
			if(flag == "sub" && (val1 == "" || val1 == null)){
				alert("请输入频谱图片名称");
				return;
			}
		}
		

		// 检测仪器的验证
		var v = $("#selectedInsTab tr").length;
		if(v>1){
			var insIdStr = "";
			// 获取检测仪器的编号
			$("input[name='insId']").each(function(index,item){
				insIdStr=insIdStr+$(this).val()+",";
			});

		}else if(flag == "sub" ){
			alert("请选择检测仪器");
			return;
		}

		$("#selectedInsId").val(insIdStr);
		$("#testCode").val($("#testCodeInput").val());
		$("#testDate").val($("#testDateInput").val());
		$("#sampleName").val($("#sampleNameInput").val());
		$("#wtUnit").val($("#wtUnitInput").val());
		$("#testDeviceId").val(deviceIdStr);
		$("#testDeviceLabel").val(deviceLabelStr);
		
		
		if(isOK){
			$("#testReportFm").submit();
		}else{
			alert("请完善信息");
		}
	};
	/*
		为每个设备自动分配一个设备标签
		标签格式：SXJY00023AJ
	*/
	function createDevTag(){
		
		tagIdLen = 5;//标签数值部分长度
		prefixDevTag = 'SXJY';//标签前缀
		suffixDevTag = 'AJ';//标签后缀
		
		//第一个标签的值
		firstDevTag = $("input[name='deviceLabel']").get(0).value;
		//第一个标签的数值部分		
		tagId = firstDevTag.substr(4,tagIdLen);
		
		firstTagId = parseInt(tagId);
		
		console.log(firstDevTag);		
		console.log(tagId);
		console.log(parseInt(tagId));
		console.log(PrefixInteger(tagId,5));
		
		if (firstDevTag ==  null || firstDevTag == ""){
			alert("请输入第一个设备标签");
			return;
		};
		
		
		$("input[name='deviceLabel']").each(function(index,item){
			thisTagId =  firstTagId + index;
			thisDevTag =  prefixDevTag + PrefixInteger(thisTagId,tagIdLen) + suffixDevTag;
			
			$(this).val(thisDevTag);
			
		});
		
	};
	
	function PrefixInteger(num, length) {
		 return (Array(length).join('0') + num).slice(-length);
	};
	
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
                      <input type="text" class="form-control" id="wtUnitInput" value="<%=unit.getUnitName() %>">
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
	<form id="testReportFm" action="<%=request.getContextPath()%>/dveTestReport_addTestReport.do" method="post" enctype="multipart/form-data">
        <div class="box box-primary">
          <div class="box-header with-border">
            <h3 class="box-title">申请检测的设备</h3>
            <button type="button" class="btn btn-primary pull-right" onclick="createDevTag()">自动分配设备标签</button>
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
                <textarea id="testResult" name="testResult" class="textarea333" style="width: 100%; height: 100px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;">在10kHz~3GHz频段范围内未发现向外发射的异常信号。</textarea>     
            </div>
        </div>
		
		<div class="box box-primary">
            <div class="box-header">
              <h3 class="box-title">被测样品状态
              </h3>
            </div>
            <div class="box-body pad">             
                <textarea id="sampleState" name="sampleState" class="textarea333" style="width: 100%; height:100px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;">被测设备在受检时开机正常运行。</textarea>     
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
                  <th>操作</th>
                </tr>
              </table>
          </div><!-- /.box-body -->
        </div><!-- /.box -->
	
        <div class="box box-primary">
          <div class="box-header with-border">
            <h3 class="box-title">检测设备及检测过程照片</h3>
          </div><!-- /.box-header -->
          <table id="picTab1" align="center" class="picTab" style="width:700px;" >
				<tr>	
					<td class="input-td">
						<table>
						<tr><td>
						<input type="file" id="1" name="testPic" onchange="addFile1(this)" />
						</td></tr>
						<tr><td>图片名称：<input name='testPicName1' type='text' class='picName'/></td></tr>
						</table>
					</td>
					<td>
						<div id="localImag1" align="center">
							<img id="preview1" src="../../uploads/image/noPic1.PNG" style="display: block; width: 315px; height: 230px;">
						</div>
					</td>
				</tr>
		 </table>
        </div>

        <div class="box box-primary">
          <div class="box-header with-border">
            <h3 class="box-title">检测过程频谱分析</h3>
          </div><!-- /.box-header -->
          <table id="picTab2" align="center" class="picTab" style="width:700px;" >
				<tr>	
					<td class="input-td">
						<div style="padding-top:10px;padding-bottom:10px">
							<table><tr><td>
							<input type="file" id="100" name="pinpuPic" onchange="addFile2(this)" />
							</td></tr><tr><td>图片名称：<input name='pintuPicName1' type='text' class='picName'/></td></tr></table>
						</div>
						<div id="localImag100" align="center">
							<img id="preview100" src="../../uploads/image/noPic2.PNG" style="display: block; width: 656px; height: 230px;">
						</div>
					</td>
				</tr>
			</table>
        </div><!-- /.box -->
        <input type="hidden" id="applyId" name="applyId" value="<%= applyId%>"/>
        <input type="hidden" id="selectedInsId" name="selectedInsId" />
		<input type="hidden" id="operate" name="operate" />
        <input type="hidden" id="testCode" name="testCode"/>
        <input type="hidden" id="testDate" name="testDate"/>
        <input type="hidden" id="sampleName" name="sampleName"/>
        <input type="hidden" id="wtUnit" name="wtUnit"/>
        <input type="hidden" id="testDeviceId" name="testDeviceId"/>
        <input type="hidden" id="testDeviceLabel" name="testDeviceLabel"/>
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