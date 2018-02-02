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

	$("#pbsTestApply-grid").flexigrid({
		url: '${pageContext.request.contextPath}/pbsApplyInfo_selPbsApplyInfoListByUnit.do?unitId=<%= user.getUnitId() %>',
        dataType: 'json',
        display : 'true',   
        colModel : [
		  {display: '序号', name : 'num', width : 50, sortable : false, align: 'center'},
          {display: 'ID', name : 'pbsApplyId', width : 70, sortable : false, align: 'center',hide: true},
          {display: '申请人', name : 'userName', width : 100, sortable : false, align: 'center'},
          {display: '申请日期', name : 'pbsApplyDate', width : 100, sortable : true, align: 'center'},
          {display: '状态', name : 'state', width : 100, sortable : true, align: 'center'},
          {display: '操作', name : 'operate', width : 150, sortable : true, align: 'center'}
				],
		buttons :[
				{name : '删除申请信息',onpress : action}
				 ],
        sortname: "pbsApplyDate",   
        sortorder: "desc",   
        usepager: true,   
        checkbox : true,
        useRp: true,
        title: '屏蔽室检测申请列表',
        rp: 10,   
        width: 'auto',
        height:'auto',
        wjsearch:[{name:'state',value: $('#search_state').attr('value')}]
	});
	function action(com, grid) {
		switch (com) {
			case '删除申请信息' :
				var selected_count = $('.trSelected', grid).length;
				if (selected_count == 1){
					$('.trSelected td:nth-child(3) div', grid).each(function(i) {
						var id = $(this).text();
						var c = confirm("确定删除该申请记录的所有信息吗？");
						if (c == true) {
							delApply(id);
						}
					});
				} else {
					alert("请选择一条记录");
				}
				break;
		}
	}
});	
						            
	function delApply(id) {
		$.ajax({
			url : '${pageContext.request.contextPath}/pbsApplyInfo_delApply.do',
			data : {'pbsApplyInfo.pbsApplyId' : id},
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				if(data.result == 'success'){
					alert("删除成功");
					$('#pbsTestApply-grid').reload();// 表格重载						
				} else {
					alert(data.result);
				}
			}
		});
	};
				
	function search(){
		var  k = {wjsearch:[{name:'state',value: $('#search_state').attr('value')}]};
		$('#pbsTestApply-grid').flexReload(k);
	};
</script>
</head>

<body>
	<div id="Nav">
		<span>屏蔽室检测>>查看申请</span>
	</div>
	<div id="searchDiv">
		<table id="serach-table">
			<tr>
				<td class="title_td">申请状态</td>
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
	
	<table id="pbsTestApply-grid"></table>

</body>
</html>