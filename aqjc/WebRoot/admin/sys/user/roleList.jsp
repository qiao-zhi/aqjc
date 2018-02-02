<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.tyust.dao.unit.IunitDao"%>
<%@page import="com.tyust.bean.unit.TBaseUnitInfo" %>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.tyust.bean.user.TBaseUserInfo" %>
<%
	//String uid = request.getParameter("unitid");
	String uname = "";
	//if(uid==null||"".equals(uid)){
	TBaseUserInfo user = (TBaseUserInfo)session.getAttribute("user");
	String uid = user.getUnitId();
	//}
	ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
	IunitDao unitDao = (IunitDao)context.getBean("Unit");
	TBaseUnitInfo unit = unitDao.findUnit(uid);
	if(unit!=null){
		uname = unit.getUnitName();
	}
 %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../../common/include-common.jsp"></jsp:include>
	<script >
	$(function(){
		 var uuid=$('#unitId').val();
		 $("#role-grid").flexigrid({   
		      	url: '<%=request.getContextPath() %>/findRoles.do?unitid=<%=uid%>&unitname=<%=uname%>',
		 		dataType : 'json',
		 		colModel : [
		 			{display : 'roleid',name : 'roleId',width : 120,sortable : true,align : 'left',hide : true}, {
		 								display : '角色名',
		 								name : 'roleName',
		 								width : 100,
		 								sortable : true,
		 								align : 'left'
		 							}, {
		 								display : '所属机构',
		 								name : 'unitName',
		 								width : 200,
		 								sortable : true,
		 								align : 'left'
		 							}, {
		 								display : '是否可用',
		 								name : 'useInfo',
		 								width : 60,
		 								sortable : true,
		 								align : 'left'
		 							}, {
		 								display : 'inuse',
		 								name : 'inuse',
		 								width : 60,
		 								sortable : true,
		 								align : 'left',
		 								hide : true
		 							}, {
		 								display : '权限分配',
		 								name : 'limits',
		 								width : 60,
		 								sortable : true,
		 								align : 'left'
		 							}, {
		 								display : '描述',
		 								name : 'description',
		 								width : 200,
		 								sortable : true,
		 								align : 'left'
		 							} ],
		 							buttons : [ {
		 								name : '添加角色',
		 								onpress : action
		 							}, {
		 								separator : true
		 							}, {
		 								name : '分配权限',
		 								onpress : action
		 							}, {
		 								separator : true
		 							}, {
		 								name : '修改',
		 								onpress : action
		 							}, {
		 								separator : true
		 							}, {
		 								name : '删除',
		 								onpress : action
		 							} ],
		 							sortname : "RINO",
		 							sortorder : "desc",
		 							usepager : true,
		 							useRp : true,
		 							title : false,
		 							checkbox : true,
		 							rp : 20, //每页显示多少条
		 							page : 1,
		 							showTableToggleBtn : true,
		 							width : 'auto',
		 							height :'auto'
		 						});
		 		var actions = "";
		 		function action(com, grid) {
		 			switch (com) {
		 			case '添加角色':
		 				if ("<%=uid%>"== null) {
		 					alert('请选择机构');
		 				} else {
		 					$.dialog({
								content:$("#adddiv")[0],
								title:'添加角色',
								id:'idAdd',
								lock :true,
								background :'#000',
								opacity:0.5
							});
		 				}
		 				break;
		 			case '分配权限':
		 				selected_count = $('.trSelected', grid).length;
		 				if (selected_count == 0) {
		 					alert('请选择一条记录!');
		 					return;
		 				}
		 				if (selected_count > 1) {
		 					alert('抱歉只能同时为一条记录分配权限!');
		 					return;
		 				}
		 				id = '';
		 				$('.trSelected td:nth-child(2) div', grid).each(function(i) {

		 					id = $(this).text();

		 				});
		 				$('.trSelected td:nth-child(2) div').serialize();
		 				if (confirm("确定分配?")) {
		 					selectRoleModule(id);
		 				}
		 				break;
		 			case '修改':
		 				selected_count = $('.trSelected', grid).length;
		 				if (selected_count == 0) {
		 					alert('请选择一条记录!');
		 					return;
		 				}
		 				if (selected_count > 1) {
		 					alert('抱歉只能同时修改一条记录!');
		 					return;
		 				}
		 				data = new Array();
		 				$('.trSelected td', grid).each(function(i) {
		 					data[i] = $(this).children('div').text();
		 				});
		 				$('#updateform input[name="roleId"]').val(data[0]);
		 				$('#updateform input[name="roleName"]').val(data[1]);
		 				$('#updateform input[name="unitName"]').val(data[2]);
		 				$('#updateform select[name="inuse"]').val(data[4]);
		 				$('#updateform textarea[name="description"]').val(data[6]);
		 				$.dialog({
							content:$("#updatediv")[0],
							title:'修改角色',
							lock :true,
							id:'idUpdate',
							background :'#000',
							opacity:0.5
						});
		 				break;
		 			case '删除':
		 				selected_count = $('.trSelected', grid).length;
		 				if (selected_count == 0) {
		 					alert('请选择一条记录!');
		 					return;
		 				}
		 				if (selected_count > 1) {
		 					alert('抱歉只能同时删除一条记录!');
		 					return;
		 				}

		 				ids = '';
		 				$('.trSelected td:nth-child(2) div', grid).each(function(i) {
		 					if (i)
		 						ids += ',';
		 					ids = $(this).text();

		 				});
		 				$('.trSelected td:nth-child(2) div').serialize();
		 				if (confirm("确定删除?")) {
		 					del(ids);
		 				}
		 				break;
		 			}
		 		}
		 		//分配权限
		 		function selectRoleModule(id) {
		 			location.href = '<%=request.getContextPath() %>/selectRoleModule.do?roleId='+ id + '&unitId=<%=uid %>';
		 		}
		 		
		 		$("#btn_submit").click(function() {
		 	 		var flag=true;
		 	 			if (flag == true) {
		 	 				$.ajax({
		 	 					url : '<%=request.getContextPath() %>/addRole.do',
		 	 					data : $("#addfrom").serialize(),
		 	 					type : 'POST',
		 	 					dataType : 'json',
		 	 					success : function(data) {
		 	 						alert('添加成功');
		 	 						$.dialog.get('idAdd').close();
		 	 						$('#role-grid').reload();
		 	 					}
		 	 				});
		 	 			}
		 	 			document.getElementById('descript').value = ""; 
		 	 			document.getElementById('rName').value = "";
		 	 	});

		 		$("#btn_update").click(function() {
		 			var flag=true;
		 				if (flag == true) {
		 					$.ajax({
		 						url : '<%=request.getContextPath() %>/updateRole.do',
		 						data : $("#updateform").serialize(),
		 						type : 'POST',
		 						dataType : 'json',
		 						success : function(data) {
		 							alert('修改成功');
		 							$.dialog.get('idUpdate').close();
		 							$('#role-grid').reload();
		 						}
		 					});

		 				}
		 		});
		 		
		 		function del(ids) {
					$.ajax({
						url : '<%=request.getContextPath() %>/deleteRole.do',
						data : {"ids" : ids},
						type : 'GET',
						dataType : 'json',
						success : function(data) {
							if(data.success){
								alert(data.message);
								$('#role-grid').reload();// 表格重载						
							}else{
								alert(data.message);
							}
						}
					});
				}
				
	});

	</script>
</head>

<body>
	<table id="role-grid"></table>

	<div id="adddiv" style="display: none">
		<form id="addfrom">
			<table class="dataTab">
				<tr>
					<td class="title_td">所属机构</td>
					<td>
						<input readonly="readonly" name="unitName" value="<%=uname%>"/>
						<input type="hidden" name="unitId" id="unitId" value="<%=uid %>" />
					</td>
				</tr>
				<tr>
					<td class="title_td">角色名</td>
					<td>
						<input id="rName" name="roleName"/>
					</td>
				</tr>
				<tr>
					<td class="title_td">启用标志</td>
					<td>
						 <select name="inuse">
							<option value="1">启用</option>
							<option value="0">禁用</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="title_td">描述</td>
					<td>
						 <textarea name="description" id="descript" ></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" style="padding-top:20px;">
						<span id="btn_submit" class="btn" >确定</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="updatediv" style="display: none">
		<form id="updateform">
			<table class="dataTab">
				<tr>
					<td class="title_td">所属机构</td>
					<td>
						<input name="unitName" disabled="disabled"/>
						<input type="hidden" name="unitId" value="<%=uid %>" />
					</td>
				</tr>
				<tr>
					<td class="title_td">角色名</td>
					<td>
						<input id="roleName" name="roleName"/>
						<input type="hidden" name="roleId" />
					</td>
				</tr>
				<tr>
					<td class="title_td">启用标志</td>
					<td>
						<select name="inuse">
							<option value="1">启用</option>
							<option value="0">禁用</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="title_td">描述</td>
					<td>
						 <textarea  name="description" ></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" style="padding-top:20px;">
						<span id="btn_update" class="btn" >确定</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
</body>
</html>