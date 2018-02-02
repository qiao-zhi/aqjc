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
<script>
	$(function(){
		$("#dveTestReport-grid").flexigrid({
			url: '${pageContext.request.contextPath}/dveTestReport_selTestRptList.do',
	        dataType: 'json',
	        display : 'true',   
	        colModel : [
			  {display: '序号', name : 'num', width : 50, sortable : false, align: 'center'},
	          {display: 'ID', name : 'ReportId', width : 70, sortable : false, align: 'center',hide: true},
	          {display: '检测报告编号', name : 'TestCode', width : 150, sortable : false, align: 'center'},
	          {display: '检测日期', name : 'TestDate', width : 150, sortable : true, align: 'center'},
	          {display: '检测人', name : 'TestUser', width : 100, sortable : true, align: 'center'},
	          {display: '样品名称', name : 'SampleName', width : 200, sortable : true, align: 'center'},
	          {display: '状态', name : 'State', width : 100, sortable : true, align: 'center'},
	          {display: '操作', name : 'operate', width : 100, sortable : true, align: 'center'}
					],
					
            sortname: "TestDate",   
            sortorder: "desc",   
            usepager: true,   
            checkbox : false,
            useRp: true,
            title: '设备安全检测报告列表',
            rp: 10,   
            width: 'auto',
            height:'auto',
            wjsearch:[{name:'state',value: $('#search_state').attr('value')}]
		});
	});	
						            		
	function search(){
		var  k = {wjsearch:[{name:'state',value: $('#search_state').attr('value')}]};
		$('#dveTestReport-grid').flexReload(k);
	};
</script>
</head>

<body>
	<div id="Nav">
		<span>设备检测>>检测报告</span>
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
	
	<table id="dveTestReport-grid"></table>

</body>
</html>