<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>屏蔽室检测报告列表</title>
<jsp:include page="../common/include-commonNew.jsp"></jsp:include>
<script type="text/javascript" src="yulan.js"></script>
<script>
	$(function(){
		$("#enTestReport-grid").flexigrid({
			url: '${pageContext.request.contextPath}/enTestReport_selEnTestReportList.do',
	        dataType: 'json',
	        display : 'true',   
	        colModel : [
			  {display: '序号', name : 'num', width : 50, sortable : false, align: 'center'},
	          {display: 'ID', name : 'ReportId', width : 70, sortable : false, align: 'center',hide: true},
	          {display: '检测报告编号', name : 'TestReportNumber', width : 150, sortable : false, align: 'center'},
	          {display: '检测日期', name : 'TestDate', width : 150, sortable : true, align: 'center'},
	          {display: '检测人', name : 'TestUserName', width : 100, sortable : true, align: 'center'},
	          {display: '样品名称', name : 'TestSampleName', width : 200, sortable : true, align: 'center'},
	          {display: '状态', name : 'State', width : 100, sortable : true, align: 'center'},
	          {display: '操作', name : 'operate', width : 230, sortable : true, align: 'center'}
					],
            sortname: "TestDate",
            sortorder: "desc",   
            usepager: true,
            checkbox : false,
            useRp: true,
            title: '环境检测报告列表',
            rp: 10,   
            width: 'auto',
            height:'auto',
            wjsearch:[{name:'state',value: $('#search_state').attr('value')}]
		});
	});	
						            		
	function search(){
		var  k = {wjsearch:[{name:'state',value: $('#search_state').attr('value')}]};
		$('#enTestReport-grid').flexReload(k);
	};
	
	// 全局变量 设置操作是添加还是更新
	var operate = "";
	
	// 添加证书
	function zs_add(obj){
		var enApplyId = $(obj).parent().parent().parent().find("td:eq(1)").find("div").html();
		$.ajax({
			 url: '<%=request.getContextPath()%>/enApplyInfo_selEnZSPic.do',
		       data: {'enApplyId' : enApplyId,
		    	   'enPicType' : '3'},
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
		   			$("#zs_enApplyId").val(enApplyId);
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
			urls =  '<%=request.getContextPath()%>/enApplyInfo_saveZSEnPic.do';
		} else if(operate == 'update'){
			urls =  '<%=request.getContextPath()%>/enApplyInfo_updateZSEnPic.do';
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
		var enApplyId = $(obj).parent().parent().parent().find("td:eq(1)").find("div").html();
		$.ajax({
			 url: '<%=request.getContextPath()%>/enApplyInfo_selEnZSPic.do',
		       data: {'enApplyId' : enApplyId,
		    	   'enPicType' : '3'},
		       type: 'POST',
		       dataType:'json',
		       success: function(data) {
		    	   var data = eval(data);
		    	   if(data.result == 'success'){
		    		   $('#zsForm')[0].reset();
		    		   var url = data.enPicUrl;
		    		   $("#preview1").attr('src',"../../uploads/enPic/"+url);
		    		   $.dialog({
		   				content:$("#pic")[0],
		   				title:'更新证书',
		   				id:'idAdd',
		   				lock :true,
		   				background :'#245EDC',
		   				opacity:0.5
		   			});
		   			$("#zs_enApplyId").val(enApplyId);
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
		var enApplyId = $(obj).parent().parent().parent().find("td:eq(1)").find("div").html();
		$.ajax({
			 url: '<%=request.getContextPath()%>/enApplyInfo_selEnZSPic.do',
		       data: {'enApplyId' : enApplyId,
		    	   'enPicType' : '3'},
		       type: 'POST',
		       dataType:'json',
		       success: function(data) {
		    	   var data = eval(data);
		    	   if(data.result == 'success'){
		    		   var c = confirm("确定删除该证书吗？");
		   			if (c == true) {
		   				$.ajax({
		   					 url: '<%=request.getContextPath()%>/enApplyInfo_delEnZSPic.do',
		   				       data: {'enApplyId' : enApplyId,
		   				    	   'enPicType' : '3'},
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
</script>
</head>

<body>
	<div id="Nav">
		<span>环境检测>>检测报告</span>
	</div>
	<div id="searchDiv">
		<table id="serach-table">
			<tr>
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
	
	<table id="enTestReport-grid"></table>
	
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
						    <input type="hidden" id="zs_enApplyId" name="enApplyId"/>
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
</body>
</html>