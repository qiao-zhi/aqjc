<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>日志管理</title>
	<jsp:include page="../../common/include-common.jsp"></jsp:include>	
	<script src="<%=request.getContextPath() %>/controls/JCalendar/WdatePicker.js"></script>
	<script>
	$(function(){ 
		$("#journal-grid").flexigrid({   
			url: '${pageContext.request.contextPath}/logManage_selLog.do',
	        dataType: 'json',
	        display : 'true',   
	        colModel : [   
		    	{display: '日志ID', name : 'logId', width : 30, sortable : true, align: 'center',hide:true},  
				{display: '操作单位', name : 'actionUnit', width : 220, sortable : true, align: 'center'},  
			    {display: '操作人', name : 'actionPeopre', width : 50, sortable : true, align: 'center'},
	            {display: '操作时间', name : 'actionDate', width :120, sortable : true, align: 'center'}, 
	            {display: '操作模块', name : 'opeprateObject', width :150, sortable : true, align: 'center'},  
	            {display: '操作类型', name : 'actionType', width :60, sortable : true, align: 'center'},   
	            {display: '操作用户IP', name : 'ip', width :85, sortable : true, align: 'center'},
	            {display: '操作结果', name : 'actionResult', width : 250,  align: 'left'}
	        ],
			/* buttons : [
				{name : '删除',onpress : action},
				{separator: true}
			], */
            sortname: "actionDate",   
            sortorder: "desc",   
            usepager: true,   
            checkbox : true,// 是否要多选框
            rowId : 'logId',// 多选框绑定行的id    
            useRp: true,   
            rp: 10,   
            width: 'auto',
            height:'auto'
	});
		            
		var actions = "";
		function action(com, grid) {
			switch (com) {
				case '删除' :
					selected_count = $('.trSelected', grid).length;
					if (selected_count == 0) {
						alert('请选择一条记录!');
						return;
					}
					ids = '';
					$('.trSelected td:nth-child(2) div', grid).each(function(i) {
								if (i)
									ids += ',';
								ids += $(this).text();
					})
					if (confirm("确定删除?")) {
						delLog(ids);
					}
					break;
			}
		}
	
		function delLog(ids) {
			$.ajax({
						url : '${pageContext.request.contextPath}/logManage_deleteLog.do',
						data : {ids : ids},
						type : 'POST',
						dataType : 'json',
						success : function() {
							alert("日志删除成功！");
							$('#flex1').reload();// 表格重载
						}
			});
		}
	});
	function search(){
		   $('#journal-grid').flexReload();  
	}
	</script>
</head>
  
<body>
	<div id="searchDiv">
		<table id="serach-table">
			<tr>
				<td class='title-td'>操作时间</td>
				<td>
					<input type="text" id="text1" name="text1" style="width:140px" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
	         		 至
	            	<input type="text" id="text2" name="text2" style="width:140px" onclick="WdatePicker({skin:'whyGreen',alwaysUseStartDate:true,dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'text1\')}'})"/>
				</td>
				<td class='title-td'>操作类型</td>
				<td>
					<select id="text3" name="text3">
		          		<option value="">---请选择---</option>
		            	<option value="登录">登录</option>
		            	<option value="退出">退出</option>
		            	<option value="删除">删除</option>
		            	<option value="添加">添加</option>
		            	<option value="修改">修改</option>
		            </select>
				</td>
				<td class='title-td'>操作人</td>
				<td>
					<input type="text" id="text4" name="text4" />
				</td>
				<td class="btn-td"><input type="button" id="text4" name="text4" onclick="search()" value="搜索"/></td>
			</tr>
		</table>
	</div>
    
  	<table id="journal-grid"></table>
</body>
</html>