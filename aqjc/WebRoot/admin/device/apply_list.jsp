<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tyust.bean.user.TBaseUserInfo" %>	
<%
	TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<jsp:include page="../common/include-common.jsp"></jsp:include>
<script>
	$(function(){		
		//设备安全检测申请列表
		$("#dveTestApply-grid").flexigrid({
			url: '${pageContext.request.contextPath}/dveTestApply_selApplyList.do?unitId=<%= user.getUnitId() %>',
	        dataType: 'json',
	        display : 'true',   
	        colModel : [
			  {display: '序号', name : 'num', width : 50, sortable : false, align: 'center'},
	          {display: 'ID', name : 'ApplyId', width : 70, sortable : false, align: 'center',hide: true},
	          {display: '申请单位', name : 'UnitName', width : 100, sortable : false, align: 'center'},
	          {display: '申请人', name : 'User', width : 100, sortable : false, align: 'center'},
	          {display: '申请日期', name : 'Apply_Date', width : 100, sortable : true, align: 'center'},
	          {display: '设备数量', name : 'DeviceNum', width : 80, sortable : true, align: 'center'},
	          {display: '申请意见', name : 'ApplyOpinion', width : 250, sortable : true, align: 'center'},
	          {display: '状态', name : 'State', width : 100, sortable : true, align: 'center'},
	          {display: '操作', name : 'operate', width : 150, sortable : true, align: 'center'}
					],
					
            sortname: "Apply_Date",   
            sortorder: "desc",   
            usepager: true,   
            checkbox : false,
            useRp: true,
            title: '设备检测申请信息列表',
            rp: 10,   
            width: 'auto',
            height:'auto',
            wjsearch:[{name:'state',value: $('#search_state').attr('value')}]
		});
	});	
						            
	/* 将检测报告的状态由已提交修改为未提交*/
	function updApplyState(applyId){
		if (confirm("确定需要修改该申请报告吗？\n修改后可再次编辑报告内容")) {
			  $.ajax({
				url: '${pageContext.request.contextPath}/dveTestApply_updApplyState.do',
				data : {applyId: applyId},
				type : 'POST',
				dataType : 'json',
				success : function(data) {
					if(data.success){
						alert(data.message);
						$('#dveTestApply-grid').reload();// 表格重载						
					}else{
						alert(data.message);
					}
				}
			});
		   }
	}
	
	function delApply(id) {
		if (confirm("确定删除?")) {
		  $.ajax({
			//url : '${pageContext.request.contextPath}/test_delDeviceTest.do',
			url: '${pageContext.request.contextPath}/dveTestApply_delApply.do',
			data : {id : id},
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				if(data.success){
					alert(data.message);
					$('#dveTestApply-grid').reload();// 表格重载						
				}else{
					alert(data.message);
				}
			}
		});
	   }
	};
				
	function search(){
		var  k = {wjsearch:[{name:'state',value: $('#search_state').attr('value')}]};
		$('#dveTestApply-grid').flexReload(k);
	};
</script>
</head>

<body>
	<div id="Nav">
		<span>设备检测>>查看申请</span>
	</div>
	<div id="searchDiv">
		<table id="serach-table">
			<tr>
				<td class="title_td">申请状态</td>
				<td colspan="3">
					<select id="search_state" name="state">
					    <option value="all">请选择</option>
						<option value="1">待提交</option>
						<option value="2">待审核</option>
						<option value="3">审核未通过</option>
						<option value="4">审核通过</option>
						<option value="5">已检测</option>
					</select>
				</td>
				<td class="btn-td">
					<input type="button" onclick="return search()" value="搜索" />
				</td>
			</tr>
		</table>
	</div>
	
	<table id="dveTestApply-grid"></table>

</body>
</html>