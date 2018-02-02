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
		$("#pbsInfo-grid").flexigrid({
			url: '${pageContext.request.contextPath}/pbsInfo_selPbsList.do?unitId=<%= user.getUnitId() %>',
	        dataType: 'json',
	        display : 'true',   
	        colModel : [
			  {display: '序号', name : 'num', width : 30, sortable : false, align: 'center'},
	          {display: 'ID', name : 'PbsId', width : 70, sortable : false, align: 'center',hide: true},
	          {display: '屏蔽室名称', name : 'PbsName', width : 200, sortable : false, align: 'center'},
	          {display: '型号规格', name : 'Model', width : 100, sortable : false, align: 'center'},
	          {display: '门数量', name : 'DoorNums', width : 50, sortable : true, align: 'center'},
	          {display: '设备数量', name : 'DeviceNum', width : 50, sortable : true, align: 'center'},
	          {display: '承建单位', name : 'Builder', width : 200, sortable : true, align: 'center'},
	          {display: '所在地址', name : 'PbsAddress', width : 250, sortable : true, align: 'center'},
	          {display: '操作', name : 'operate', width : 150, sortable : true, align: 'center'}
					],
			buttons : [
						{name : '新增',onpress : action},
						{separator: true}
					],		
            sortname: "Apply_Date",   
            sortorder: "desc",   
            usepager: false,   
            checkbox : false,
            useRp: false,
            title: '屏蔽室列表',
            rp: 10,   
            width: 'auto',
            height:'auto',
            wjsearch:[{name:'state',value: $('#search_state').attr('value')}]
		});
		function action(com, grid) {
			switch (com) {
				case '新增' :
					window.location.href="pbs_info_add.jsp";
					break;
			}
		}
	});	
						            
	function delApply(id) {
		$.ajax({
			url : '${pageContext.request.contextPath}/test_delDeviceTest.do',
			data : {id : ids},
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				if(data.success){
					alert(data.message);
					$('#device_test_grid').reload();// 表格重载						
				}else{
					alert(data.message);
				}
			}
		});
	};
				
	function search(){
		var  k = {wjsearch:[{name:'state',value: $('#search_state').attr('value')}]};
		$('#dveTestApply-grid').flexReload(k);
	};
</script>
</head>

<body>
	<div id="Nav">
		<span>屏蔽室管理>>屏蔽室信息</span>
	</div>
	<table id="pbsInfo-grid"></table>
</body>
</html>