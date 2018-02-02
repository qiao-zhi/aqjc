<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tyust.bean.user.TBaseUserInfo" %>	

<!DOCTYPE html>
<html>
<head>
<title></title>
<jsp:include page="../common/include-common.jsp"></jsp:include>
<script>
	$(function(){		
		//设备安全检测申请列表
		$("#pbsTestApply-grid").flexigrid({
			url: '${pageContext.request.contextPath}/pbsApply_selSubList.do',
	        dataType: 'json',
	        display : 'true',   
	        colModel : [
                  {display: '序号', name : 'num', width : 50, sortable : false, align: 'center'},
      	          {display: 'ID', name : 'TestApplyId', width : 70, sortable : false, align: 'center',hide: true},
      	          {display: '申请单位', name : 'Unit', width : 100, sortable : false, align: 'center'},
      	          {display: '申请日期', name : 'Apply_Date', width : 100, sortable : true, align: 'center'},
      	          {display: '申请检测的屏蔽室', name : 'PbsName', width : 150, sortable : true, align: 'center'},
      	          {display: '申请检测的类别', name : 'ApplyTestType', width : 100, sortable : true, align: 'center'},
      	          {display: '申请检测的级别', name : 'ApplyTestGrade', width : 100, sortable : true, align: 'center'},
      	          {display: '状态', name : 'State', width : 100, sortable : true, align: 'center'},
      	          {display: '操作', name : 'operate', width : 150, sortable : true, align: 'center'}
					],
					
            sortname: "Apply_Date",   
            sortorder: "desc",   
            usepager: true,   
            checkbox : false,
            useRp: true,
            title: '屏蔽室检测申请列表',
            rp: 10,   
            width: 'auto',
            height:'auto',
            wjsearch:[{name:'state',value: $('#search_state').attr('value')}]
		});
	});							         
				
	function search(){
		var  k = {wjsearch:[{name:'state',value: $('#search_state').attr('value')}]};
		$('#pbsTestApply-grid').flexReload(k);  
	};
	
	function selRptByApp(appId,unitId){
		$.ajax({
			url : '${pageContext.request.contextPath}/pbsTestReport_selRptByApp.do',
			data : {'applyId':appId},
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var json = eval(response);
				//alert(json.count);
				if(json.count>0){
					window.location.href='test_report_upd.jsp?applyId='+appId+'&unitId='+unitId+'&testRptId='+json.rptId;
				}else{
					window.location.href='test_report.jsp?applyId='+appId+'&unitId='+unitId;
				}
			}
		});
	}
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
						<option value="2">待审核</option>
						<option value="3">审核未通过</option>
						<option value="4">审核通过</option>
						<option value="5">已检测</option>
					</select>
				</td>
				<td class="btn-td"><input type="button"
					onclick="return search()" value="搜索" /></td>
			</tr>
		</table>
	</div>
	
	<table id="pbsTestApply-grid"></table>

</body>
</html>