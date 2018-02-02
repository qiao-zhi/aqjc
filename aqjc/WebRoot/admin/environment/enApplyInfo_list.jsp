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
	$("#enApply-grid").flexigrid({
		url: '${pageContext.request.contextPath}/enApplyInfo_selEnApplyInfoList.do?unitId=<%= user.getUnitId() %>',
        dataType: 'json',
        display : 'true',
        colModel : [
		  {display: '序号', name : 'num', width : 50, sortable : false, align: 'center'},
          {display: 'ID', name : 'enApplyId', width : 70, sortable : false, align: 'center',hide: true},
          {display: '申请人', name : 'userName', width : 100, sortable : false, align: 'center'},
          {display: '申请日期', name : 'enApplyDate', width : 100, sortable : true, align: 'center'},
          {display: '状态', name : 'state', width : 100, sortable : true, align: 'center'},
          {display: '操作', name : 'operate', width : 200, sortable : true, align: 'center'}
				],
		buttons :[
				{name : '删除申请信息',onpress : action}
				 ],
        sortname: "enApplyDate",   
        sortorder: "desc",   
        usepager: true,   
        checkbox : true,
        useRp: true,
        title: '环境检测申请列表',
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
			url : '${pageContext.request.contextPath}/enApplyInfo_delEnApplyInfo.do',
			data : {'enApplyId' : id},
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				if(data.result == 'success'){
					alert("删除成功");
					$('#enApply-grid').reload();// 表格重载						
				} else {
					alert(data.result);
				}
			}
		});
	};
				
	function search(){
		var  k = {wjsearch:[{name:'state',value: $('#search_state').attr('value')}]};
		$('#enApply-grid').flexReload(k);
	};
	
	// 查看检测证书
	function selZS(obj){
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
		    		   var src = "../../uploads/enPic/"+data.enPicUrl;
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
			content:$("#pic")[0],
			title:'查看证书',
			id:'idAdd',
			lock :true,
			background :'#245EDC',
			opacity:0.5
		});
	};
</script>
</head>

<body>
	<div id="Nav">
		<span>环境检测>>查看申请</span>
	</div>
	<div id="searchDiv">
		<table id="serach-table">
			<tr>
				<td class="title_td">申请状态</td>
				<td colspan="3">
					<select id="search_state" name="state">
					    <option value="all">请选择</option>
						<option value="1">未提交</option>
						<option value="2">待审核</option>
						<option value="3">审核未通过</option>
						<option value="4">审核通过</option>
						<option value="6">已检测</option>
					</select>
				</td>
				<td class="btn-td">
					<input type="button" onclick="return search()" value="搜索" />
				</td>
			</tr>
		</table>
	</div>
	
	<table id="enApply-grid"></table>

	<div id="pic" style="width:450px;display: none">
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