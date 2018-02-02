<%@ page language="java" import="java.util.*,java.lang.*" pageEncoding="utf-8"%>
<%  
  String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head> 
	<jsp:include page="../../common/include-common.jsp"></jsp:include>
	<script>   
	$(function(){
		$("#menu-grid").flexigrid({   
	     	url: '${pageContext.request.contextPath}/findModule_findModuleList.do?id=<%=id%>',
	        dataType: 'json',
	        method : 'POST', 
	        display : 'true',     	
	        colModel : [   
	          	{display: 'ID', name : 'id', width :100, sortable : true, align: 'center',hide: true},
	          	{display: '菜单编号', name : 'moduleid', width : 80, sortable : true, align: 'center'} ,   
	          	{display: '菜单名称', name : 'modulename', width : 100, sortable : true, align: 'center',hide: false},           
	          	{display: '链接地址', name : 'moduleurl', width : 270, sortable : true, align: 'left'} , 
	          	{display: '菜单描述', name : 'descriptions', width : 130, sortable : true, align: 'center'},
	          	{display: '是否启用', name : 'inuse', width : 80, sortable : true, align: 'center'} ,          
	          	{display: '菜单级别', name : 'menuclass', width :100, sortable : true, align: 'center',hide: true}, 
	        	{display: '排序号', name : 'sortno', width : 100, sortable : true, align: 'center'}    
			],
			buttons : [
				{name : '增加子菜单',onpress : action},
				{separator : true}, 
				{name : '删除菜单',onpress : action}, 
				{separator : true},
				{name : '修改菜单',onpress : action}
			],
	        sortname: "RINO",   
	        sortorder: "desc",   
	        usepager: false,   
	        title: false,   
	        useRp: false,   
	        rp: 15,
	        page:1,   		
	        checkbox : true,
	        width: 'auto',
	        height:'auto'
	});
	
	var actions = "";
	function action(com, grid) {
		switch (com) {
			case '增加子菜单' :
				$('#addModuleFm input[name="upid"]').val('<%=id%>');
				$("#addModuleSubmit").attr({disabled:false});
				$.dialog({
					content:$("#addmodule")[0],
					title:'添加菜单',
					lock :true,
					id:'idAdd',
					background :'#000',
					opacity:0.5
				});
				break;
			case '删除菜单' :
				selected_count = $('.trSelected', grid).length;
				if (selected_count == 0) {
					alert('请至少选择一条记录!');
					return;
				}
				ids = '';
				$('.trSelected td:nth-child(3) div', grid).each(function(i) {
					if (i)
						ids += ',';
					ids += $(this).text();
				});
				if (confirm("确定删除?")) {
					delModule(ids);
				}
				break;
			case '修改菜单' :
				selected_count = $('.trSelected', grid).length;
				if (selected_count == 0) {
					alert('请选择一条记录!');
					return;
				}
				if (selected_count > 1) {
					alert('只能选择一条记录!');
					return;
				}
				data = new Array();
				$('.trSelected td', grid).each(function(i) {
					data[i] = $(this).children('div').text();
				});
				$('#updateModuleFm input[name="update_moduleid"]').val($.trim(data[1]));		
				$('#updateModuleFm input[name="update_modulename"]').val($.trim(data[2]));
				$('#updateModuleFm input[name="update_moduleurl"]').val(strim($.trim(data[3])));
				$('#updateModuleFm input[name="update_sortno"]').val($.trim(data[7]));
				$('#updateModuleFm input[name="update_descriptions"]').val(strim($.trim(data[4])));
				if(data[5]=="启用"){
					$("#yes").attr({checked:"true"});
				}
				else(
					$("#no").attr({checked:"true"})
				);
				$("#updateModuleSubmit").attr({disabled:false});
				$.dialog({
					content:$("#updatemodule")[0],
					title:'修改菜单',
					lock :true,
					id:'idUpdate',
					background :'#000',
					opacity:0.5
				});
				break;
		};
	};
			
		
	$("#btn-submit").click(function() {
		if($("#modulename").val()==""){
			alert('菜单名称不能为空！');
            return false;
		}
        if($("#sortno").val()==""){
        	alert('排序号不能为空！');
          	return false;
        }
        if($("#sortno").val()>999){
        	alert('排序号不能大于999');
            return false;
        }
		$.ajax({
			url : '${pageContext.request.contextPath}/editModule_addModule.do',
			data : $("#addModuleFm").serialize(),
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				alert('添加成功');
				$.dialog.get('idAdd').close();
				$('#menu-grid').reload();
                $("#modulename").val("");
                $("#moduleurl").val("");
                $("#descriptions").val("");
                $("#sortno").val("");                   
			}
		});
	});
	
	$("#btn-update").click(function() {
		if($("#update_modulename").val()==""){
			alert('菜单名称不能为空！');
       		return false;
        }
        if($("#update_sortno").val()==""){
          	alert('排序号不能为空！');
          	return false;
        }
        if($("#update_sortno").val()>999){
          	alert('排序号不能大于999');
            return false;
        }
       	$.ajax({
			url : '${pageContext.request.contextPath}/editModule_updateModule.do',
			data : $("#updateModuleFm").serialize(),
			type : 'POST',
			dataType : 'json',
			success : function(data) {
				alert('修改成功');
				$.dialog.get('idUpdate').close();
				$('#menu-grid').reload();
			}
		});
	});
		
	function delModule(ids) {
		$.ajax({
			url : '${pageContext.request.contextPath}/editModule_delModule.do',
			data : {ids : ids},
			type : 'POST',
			dataType : 'json',
			success : function() {
			     alert('删除成功');
				$('#menu-grid').reload();
			}
		});
	}
	
	});
	</script>
</head>
  
<body>
  	<table id="menu-grid"></table>
  	
	<div id="addmodule" style="display:none">
  		<form id="addModuleFm">
			<table class="dataTab">
				<tr>
					<td class="title_td">上级菜单编号</td>
					<td><input name="moduleid" id="moduleid" value="<%=id %>" readonly="readonly"/></td>
				</tr>
				<tr>
					<td class="title_td">菜单名称</td>
					<td><input name="modulename" id="modulename" /></td>
				</tr>
				<tr>
					<td class="title_td">链接地址</td>
					<td><input name="moduleurl" id="moduleurl" /></td>
				</tr>
				<tr>
					<td class="title_td">菜单描述</td>
					<td><input name="descriptions" id="descriptions"/></td>
				</tr>
				<tr>
					<td class="title_td">排序号</td>
					<td><input name="sortno" id="sortno" onkeyup="value=value.replace(/[^\d]/g,'')"/></td>
				</tr>
				<tr>
					<td class="title_td">是否启用</td>
					<td>
						<label><input type="radio" name="inuse" value="1" checked="checked"/>启用</label>
						<label><input type="radio" name="inuse" value="0"/>停用</label>
					</td>
				</tr>
				<tr>
					<td class="title_td">关联字典编号</td>
					<td><input name="matchdicid" id="matchdicid"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center" style="padding-top:20px;">
						<span id="btn-submit" class="btn">确定</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	
	
	<div id="updatemodule" style="display:none">
		<form id="updateModuleFm">
			<table class="dataTab">
				<tr>
					<td class="title_td">菜单名称</td>
					<td><input name="update_modulename" id="update_modulename"/><input type="hidden" name="update_moduleid" id="update_moduleid" /></td>
				</tr>
				<tr>
					<td class="title_td">链接地址</td>
					<td><input name="update_moduleurl" id="update_moduleurl" /></td>
				</tr>
				<tr>
					<td class="title_td">菜单描述</td>
					<td><input name="update_descriptions" id="update_descriptions"/></td>
				</tr>
				<tr>
					<td class="title_td">排序号</td>
					<td><input name="update_sortno" id="update_sortno" onkeyup="value=value.replace(/[^\d]/g,'')" /></td>
				</tr>
				<tr>
					<td class="title_td">是否启用</td>
					<td>
						<label><input type="radio" name="update_inuse" id="yes" value="1" checked="checked"/>启用</label>
						<label><input type="radio" name="update_inuse" id="no" value="0"/>停用</label>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" style="padding-top:20px;">
						<span id="btn-update" class="btn">确定</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>