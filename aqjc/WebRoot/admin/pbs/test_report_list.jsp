<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tyust.bean.user.TBaseUserInfo" %>
<%
	TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<title>屏蔽室检测报告列表</title>
<jsp:include page="../common/include-common.jsp"></jsp:include>
<script type="text/javascript" src="yulan.js"></script>
<script>
	$(function(){		
		$("#dveTestReport-grid").flexigrid({
			url: '${pageContext.request.contextPath}/pbsTestReport_selPbsTestReportList.do',
	        dataType: 'json',
	        display : 'true',   
	        colModel : [
			  {display: '序号', name : 'num', width : 50, sortable : false, align: 'center'},
	          {display: 'ID', name : 'ReportId', width : 70, sortable : false, align: 'center',hide: true},
	          {display: '申请编号', name : 'ApplyId', width : 70, sortable : false, align: 'center',hide: true},
	          {display: '检测报告编号', name : 'TestCode', width : 150, sortable : false, align: 'center'},
	          {display: '检测日期', name : 'TestDate', width : 150, sortable : true, align: 'center'},
	          {display: '检测人', name : 'TestUser', width : 100, sortable : true, align: 'center'},
	          {display: '状态', name : 'State', width : 100, sortable : true, align: 'center'},
	          {display: '操作', name : 'Operate', width : 300, sortable : true, align: 'center'}
					],	
            sortname: "TestDate",   
            sortorder: "desc",   
            usepager: true,   
            checkbox : false,
            useRp: true,
            title: '屏蔽室检测报告列表',
            rp: 10,   
            width: 'auto',
            height:'auto',
            wjsearch:[{name:'state',value: $('#search_state').attr('value')}]
		});
		function action(com, grid) {
			switch (com) {
				case '删除检测信息' :
					var selected_count = $('.trSelected', grid).length;
					if (selected_count == 1){
						var reportId = "";
						var applyId = "";
						$('.trSelected td:nth-child(2) div', grid).each(function(i) {
							reportId = $(this).text();
						});
						$('.trSelected td:nth-child(3) div', grid).each(function(i) {
							applyId = $(this).text();
						});
						var c = confirm("确定删除该申请记录的所有信息？");
						if (c == true) {
							delApply(reportId,applyId);
						}
					} else {
						alert("请选择一条记录");
					}
					break;
			}
		}
	});	
	
	function delApply(reportId,applyId) {
		$.ajax({
			url : '${pageContext.request.contextPath}/pbsTestReport_delPbsTestReport.do',
			data : {'pbsTestReportId' : reportId,
					'pbsApplyId' : applyId},
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				if(data.result == 'success'){
					alert("删除成功");
					$('#dveTestReport-grid').reload();// 表格重载						
				} else {
					alert(data.result);
				}
			}
		});
	};
	
	function search(){
		var  k = {wjsearch:[{name:'state',value: $('#search_state').attr('value')},
		                    {name:'applyUnitName',value: $('#search_applyUnitName').val()},
		                    {name:'startDate',value: $('#search_startDate').val()},
		                    {name:'endDate',value:$("#search_endDate").val()}]};
		$('#dveTestReport-grid').flexReload(k);
	};
	
	
	// 全局变量 设置操作是添加还是更新
	var operate = "";
	
	// 添加证书
	function zs_add(obj){
		var pbsApplyId = $(obj).parent().parent().parent().find("td:eq(2)").find("div").html();
		$.ajax({
			 url: '<%=request.getContextPath()%>/pbsApplyInfoZS_selZSPbsPic.do',
		       data: {'pbsApplyId' : pbsApplyId,
		    	   'pbsPicType' : '3'},
		       type: 'POST',
		       dataType:'json',
		       success: function(data) {
		    	   var data = eval(data);
		    	   if(data.result == 'success'){
		    		  alert("已经上传证书");
		    	   } else {
		    		   $('#zsForm')[0].reset();
		    		   $("#preview1").attr('src',"../../uploads/image/noPic1.PNG");
		    		   $.dialog({
		   				content:$("#pic")[0],
		   				title:'添加证书',
		   				id:'idAdd',
		   				lock :true,
		   				background :'#245EDC',
		   				opacity:0.5
		   			});
		   			$("#zs_pbsApplyId").val(pbsApplyId);
		   			operate = "add";
		    	   }
		       },
		       error : function(){
		    	   alert("查询出现错误！");
		       }
		});
	};
	
	// 添加功能上传
	function uploadZS(){
		var urls = "";
		if(operate == 'add') {
			urls =  '<%=request.getContextPath()%>/pbsApplyInfoZS_saveZSPbsPic.do';
		} else if(operate == 'update'){
			urls =  '<%=request.getContextPath()%>/pbsApplyInfoZS_updateZSPbsPic.do';
		} else {
			alert("操作错误");
			return;
		}
		var v = $("#1").val();
		if( v == ""){
			alert("请添加文件");
			return;
		}
		var formData = new FormData($('#zsForm')[0]);
		$.ajax({
		       url: urls,
		       data: formData,
		       async: false,
		       contentType: false,
		       processData: false,
		       cache: false,
		       type: 'POST',
		       success: function(data) {
		    	   var result = eval(data).result;
		    	   if(result == 'success'){
		    		   alert("上传成功");
		    		   $.dialog.get('idAdd').close();
		    	   }
		       },
		       error : function(){
		    	   alert("证书上传失败，请重试！");
		       }
		   });
	}

	
	// 证书更新
	function zs_update(obj){
		var pbsApplyId = $(obj).parent().parent().parent().find("td:eq(2)").find("div").html();
		$.ajax({
			   url: '<%=request.getContextPath()%>/pbsApplyInfoZS_selZSPbsPic.do',
		       data: {'pbsApplyId' : pbsApplyId,
		    	   'pbsPicType' : '3'},
		       type: 'POST',
		       dataType:'json',
		       success: function(data) {
		    	   var data = eval(data);
		    	   if(data.result == 'success'){
		    		   $('#zsForm')[0].reset();
		    		   var url = data.enPicUrl;
		    		   $("#preview1").attr('src',"../../uploads/pbsPic/"+url);
		    		   $.dialog({
		   				content:$("#pic")[0],
		   				title:'更新证书',
		   				id:'idAdd',
		   				lock :true,
		   				background :'#245EDC',
		   				opacity:0.5
		   			});
		   			$("#zs_pbsApplyId").val(pbsApplyId);
		   			operate = "update";
		    	   } else {
		    		   alert("没有上传证书");
		    	   }
		       },
		       error : function(){
		    	   alert("查询出现错误！");
		       }
		});
	}
	
	// 删除证书
	function zs_delete(obj){
		var pbsApplyId = $(obj).parent().parent().parent().find("td:eq(2)").find("div").html();
		$.ajax({
			 url: '<%=request.getContextPath()%>/pbsApplyInfoZS_selZSPbsPic.do',
		       data: {'pbsApplyId' : pbsApplyId,
		    	   'pbsPicType' : '3'},
		       type: 'POST',
		       dataType:'json',
		       success: function(data) {
		    	   var data = eval(data);
		    	   if(data.result == 'success'){
		    		   var c = confirm("确定删除该证书吗？");
		   			if (c == true) {
		   				$.ajax({
		   					 url: '<%=request.getContextPath()%>/pbsApplyInfoZS_delZSPbsPic.do',
		   				       data: {'pbsApplyId' : pbsApplyId,
		   				    	   'pbsPicType' : '3'},
		   				       type: 'POST',
		   				       dataType:'json',
		   				       success: function(data) {
		   				    	   var data = eval(data);
		   				    	   if(data.result == 'success'){
		   				    		  alert("删除成功");
		   				    	   } else {
		   				    		   alert("删除错误");
		   				    	   }
		   				       },
		   				       error : function(){
		   				    	   alert("删除出现错误！");
		   				       }
		   				});
		   			}
		    	   } else {
		    		   alert("没有上传证书");
		    	   }
		       },
		       error : function(){
		    	   alert("查询出现错误！");
		       }
		});
	}
	
	
	// 查看检测证书
	function selZS(obj){
		var pbsApplyId = $(obj).parent().parent().parent().find("td:eq(2)").find("div").html();
		$.ajax({
			 url: '<%=request.getContextPath()%>/pbsApplyInfoZS_selZSPbsPic.do',
		       data: {'pbsApplyId' : pbsApplyId,
		    	   'pbsPicType' : '3'},
		       type: 'POST',
		       dataType:'json',
		       success: function(data) {
		    	   var data = eval(data);
		    	   if(data.result == 'success'){
		    		   var src = "../../uploads/pbsPic/"+data.enPicUrl;
		    		   $("#preview").attr('src',src);
		    		   zs();
		    	   } else {
		    		   alert("没有上传证书");
		    	   }
		       },
		       error : function(){
		    	   alert("查询出现错误！");
		       }
		});
	}
	
	function zs(){
		$.dialog({
			content:$("#pic_sel")[0],
			title:'查看证书',
			id:'idSel',
			lock :true,
			background :'#245EDC',
			opacity:0.5
		});
	};
	
</script>
</head>

<body>
	<div id="Nav">
		<span>屏蔽室管理>>检测报告</span>
	</div>
	<div id="searchDiv">
		<table id="serach-table">
			<tr>
				<!-- <td class="title_td">申请部门</td>
				<td><input type="text" id="search_applyUnitName"></td>
				<td class="title_td">检测日期</td>
				<td>
					<input id="search_startDate" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})">
					--
					<input id="search_endDate" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})">
				</td> -->
				<td class="title_td">检测报告状态</td>
				<td colspan="3">
					<select id="search_state" name="state">
					    <option value="all">请选择</option>
						<option value="1">未提交</option>
						<option value="2">已提交</option>
					</select>
				</td>
				
				<td class="btn-td">
					<input type="button" onclick="return search()" value="搜索" />
				</td>
			</tr>
		</table>
	</div>
	
	<table id="dveTestReport-grid"></table>

	<div id="pic" style="width:650px;display: none">
		<div class="box box-primary">
          <div class="box-header with-border">
            <h3 class="box-title">证书上传</h3>
          </div><!-- /.box-header -->
          <div class="box-body">
          	<table id="picTab1" align="center" class="picTab" style="width:700px;" >
				<tr>
					<td class="input-td" width="400px"> 
						<div id="localImag1" align="center">
							<img id="preview1" src="../../uploads/image/noPic1.PNG" style="display: block; width: 415px; height: 330px;">
						</div>
					</td>
					<td width="250px;">
						<form id="zsForm" enctype="multipart/form-data">
						    <input type="hidden" id="zs_pbsApplyId" name="pbsApplyId"/>
							<input type="file" id="1" name="image" onchange="addFile(this)" />
						</form>
					</td>
				</tr>
		 	</table>
		 </div>
		 <div class="box-footer">
		   <center>
		 	<button onclick="uploadZS()" class="btn btn-default">保存</button>
		 	</center>
		 </div>
	  </div>
   </div>
   
   <!-- 查看证书 -->
   	<div id="pic_sel" style="width:450px;display: none">
		<div class="box box-primary">
          <div class="box-header with-border">
            <h3 class="box-title">证书</h3>
          </div><!-- /.box-header -->
          <div class="box-body">
          	<table id="picTab1" align="center" class="picTab" style="width:400px;" >
				<tr>
					<td class="input-td" width="400px"> 
						<div align="center">
							<img id="preview" src="" style="display: block; width: 415px; height: 330px;">
						</div>
					</td>
				</tr>
		 	</table>
		 </div>
	  </div>
   </div>
   
</body>
</html>