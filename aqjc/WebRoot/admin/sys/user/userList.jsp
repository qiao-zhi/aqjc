<%@ page language="java" import="java.util.*,com.tyust.bean.unit.TBaseUnitRole,com.tyust.dao.user.IuserRoleDao,org.springframework.web.context.support.WebApplicationContextUtils,org.springframework.context.ApplicationContext,com.tyust.bean.unit.TBaseUnitInfo,com.tyust.dao.unit.IunitDao,com.tyust.bean.user.TBaseUserInfo" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	//String unitId=request.getParameter("unitid");
	String unitName ="";
	TBaseUserInfo user = (TBaseUserInfo)session.getAttribute("user");
	String unitId = user.getUnitId();
	ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
	IunitDao unitDao = (IunitDao)context.getBean("Unit");
	TBaseUnitInfo unit = unitDao.findUnit(unitId);
	if(unit!=null){
		unitName = unit.getUnitName();
	}
	IuserRoleDao userrole = (IuserRoleDao)context.getBean("UserRole");
	TBaseUnitRole unitrole;
	ArrayList roleList = new ArrayList();
	List rolelist  = userrole.selectRoleByUnitIds(unitId);
	if(rolelist!=null){
		for(int i=0;i<rolelist.size();i++){
			unitrole = (TBaseUnitRole)rolelist.get(i);
			roleList.add(unitrole);
		}
	}  
	session.setAttribute("roleList", roleList);
%>
<!DOCTYPE html>
<html>
<head> 
	<style>
	    .dataTab tr td input {width:200px;height:21px;}
	    .dataTab tr td textarea {width:200px;}
  </style>
	<jsp:include page="../../common/include-common.jsp"></jsp:include>
	<script>
		$(function(){
			$("#user-grid").flexigrid({   
		     	url: '<%=request.getContextPath() %>/selUser_selAllUser.do?&unitid=<%=unitId %>',
		        dataType: 'json',
		        method : 'POST', 
		        colModel : [   
		          {display: '用户ID', name : 'userId', width : 150, sortable : true, align: 'center',hide: true},  		        
		          {display: '用户名', name : 'userName', width : 100, sortable : true, align: 'center',hide: false},
		          {display: '角色', name : 'roleId', width : 100, sortable : true, align: 'center',hide: false},
		          {display: '真实姓名', name : 'name', width : 100, sortable : true, align: 'center',hide: false}, 
		          {display: '性别', name : 'sex', width : 100, sortable : true, align: 'center',hide: false}, 
		          {display: '性别code', name : 'sexCode', width : 130, sortable : true, align: 'center',hide:true},
		          {display: '职务', name : 'duty', width : 120, sortable : true, align: 'center',hide: false},
		          {display: '联系电话', name : 'telephone', width : 120, sortable : true, align: 'center',hide: false},  
		          {display: 'Email', name : 'email', width : 120, sortable : true, align: 'center',hide: false},
		          {display: '创建时间', name : 'createTime', width : 100, sortable : true, align: 'center'},
		          {display: '是否启用', name : 'inuse', width : 100, sortable : true, align: 'center',hide:false},
		          {display: '是否启用code', name : 'inuseCode', width : 130, sortable : true, align: 'center',hide:true},			
		          {display: '其他说明', name : 'userComment', width : 100, sortable : true, align: 'center',hide:true}		     	               
						],
				buttons : [
					{name : '添加用户',onpress : action},{separator : true}, 
					{name : '修改用户',onpress : action},{separator : true}, 
					{name : '删除用户',onpress : action},{separator : true},
					{name : '分配角色',onpress : action},{separator : true},
					{name : '重置密码',onpress : action}
				],
	            sortname: "createTime",   
	            sortorder: "desc",   
	            usepager: true,   
	            title: "<%= unitName%>的用户列表",   
	            useRp: true,
	            checkbox : true,
	            pagestat : '显示 {from} 至{to},共 {total} 个用户',
	            page:1,
	            rp: 10,  
	            showTableToggleBtn: true,
	            width: 'auto',
	            height:'auto'
            });
            
			//var actions = "";
			function action(com, grid) {
				switch (com) {
					case '添加用户' :
						$("#addUserTab input").each(function(i){
				    		$(this).val('');
				    	 });
						$("#adduserComment").val("");
						$("#unit_id").val("<%=unitId%>");
						$("#addtecduty").val("<%= user.getTecduty() %>");
				    	$.dialog({
							content:$("#adduser")[0],
							title:'添加用户(注：用户密码默认与用户名相同)',
							id:'idAdd',
							lock :true,
							background :'#000',
							opacity:0.5
						});
						break;
					case '分配角色' :
						selected_count = $('.trSelected', grid).length;
						if (selected_count == 0) {
							alert('请至少选择一条记录!');
							return;
						}
						userNames = '';
						$('.trSelected td:nth-child(3) div', grid).each(function(i) {
							if (i)
								userNames += ',';
								userNames += $(this).text();
						})
						userIds = '';
						 $('.trSelected td:nth-child(2) div',grid).each(function(i){
				         	if(i)
					           userIds += ',';
					           userIds += $(this).text();
				         })
						$('#addUserRoleFm input[name="userName"]').val(userNames);
						$('#addUserRoleFm input[name="userId"]').val(userIds);
						$.dialog({
							content:$("#userrole")[0],
							title:'分配角色',
							lock :true,
							id:'idFen',
							background :'#000',
							opacity:0.5
						});
						break;
					case '修改用户' :
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
						$('.trSelected td', grid).each(function(i) {data[i] = $(this).children('div').text();});
						$('#updateUserFm input[name="userId"]').val($.trim(data[0]));
						$('#updateUserFm input[name="userName"]').val($.trim(data[1]));
						$('#updateUserFm input[name="name"]').val($.trim(data[3]));
					    $('#updateUserFm select[name="sex"]').val($.trim(data[5]));
					    $('#updateUserFm input[name="duty"]').val(strim($.trim(data[6])));
					    $('#updateUserFm input[name="telephone"]').val(strim($.trim(data[7])));
					    $('#updateUserFm input[name="email"]').val(strim($.trim(data[8])));
					    $('#updateUserFm textarea[name="userComment"]').val(strim($.trim(data[12])));
					    $('#updateUserFm select[name="inuse"]').val($.trim(data[11]));
					    $.dialog({
							content:$("#updateuser")[0],
							title:'修改用户',
							lock :true,
							id:'idUpdate',
							background :'#000',
							opacity:0.5
						});
						break;
					case '删除用户' :
						selected_count = $('.trSelected', grid).length;
						if (selected_count == 0) {
							alert('请选择至少一条记录!');
							return;
						}
						ids = '';
						$('.trSelected td:nth-child(2) div', grid).each(function(i) {
							if (i)
								ids += ',';
							ids += $(this).text();
						})
						if (confirm("确定删除?")) {
							delUser(ids);
						}
						break;
					case '重置密码':
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
						$('.trSelected td', grid).each(function(i) {data[i] = $(this).children('div').text();});
						$('#resetPwdFm input[name="resetpwd_userid"]').val($.trim(data[0]));
						$.dialog({
							content:$("#resetpwd")[0],
							title:'重置密码',
							lock :true,
							id:'idReset',
							background :'#000',
							opacity:0.5
						});
						break;	
				}}
				
							
			$("#btn-submit").click(function() {
				if (!validate($("#addUserFm"))){
					var $mark = $("body>div").last();
					var _zIndex = $mark.css('zIndex');
					$mark.css({
						zIndex:9999
					});
					$.ajax({
						url : '<%=request.getContextPath() %>/addUser.do',
						data : $("#addUserFm").serialize(),
						type : 'POST',
						dataType : 'json',
						success : function(data) {
							$mark.css('zIndex',_zIndex);
							if(data.success){
								alert(data.message);
								$.dialog.get('idAdd').close();
								$('#user-grid').reload();				
							}else{
								alert(data.message);
							}
						}
					});
				}
			});
							
		 	$("#btn-update").click(function() {
		 		if (!validate($("#updateUserFm"))){
					var $mark = $("body>div").last();
					var _zIndex = $mark.css('zIndex');
					$mark.css({
						zIndex:9999
					});
					$.ajax({
						url : '<%=request.getContextPath() %>/editUser_updateUser.do',
						data : $("#updateUserFm").serialize(),
						type : 'POST',
						dataType : 'json',
						success : function(data) {
							$mark.css('zIndex',_zIndex);
							if(data.success){
								alert(data.message);
								$.dialog.get('idUpdate').close();
								$('#user-grid').reload();
							}else{
								alert(data.message);
							}
						}
					});
		 		}
			});
			   
		    $("#btn_JiaoSe").click(function() {
				if($("#roleId").val()==""){
			    	alert('请选择角色！');
			        return false;
			    }
				$.ajax({
					url : '<%=request.getContextPath() %>/addUserRole.do',
					data : $("#addUserRoleFm").serialize(),
					type : 'POST',
					dataType : 'json',
					success : function(data) {
						alert('分配成功');
						$.dialog.get('idFen').close();
						$('#user-grid').reload();
					}
				});
			});
							
			$("#btn_reset").click(function() {
				if($("#pwd").val()==""){
					alert('密码不能为空！');
		       		return false;
	       		}
		        if($("#repwd").val()==""){
		       		alert('重复密码不能为空!');
		       		return false;
		       	}
		        if($("#pwd").val()!=$("#repwd").val()){
		        	alert('两次输入密码不一致！');
		        	return false;
		        }
				if(!/[a-zA-Z0-9_]/.test($("#pwd").val())){
					alert('密码必须由数字，字母，下划线组成');
					return false;
				}
				$.ajax({
					url : '<%=request.getContextPath() %>/editUser_adminUpdatePwd.do',
					data : $("#resetPwdFm").serialize(),
					type : 'POST',
					dataType : 'json',
					success : function(data) {
						alert('重置成功');
						$('#user-grid').reload();
						$.dialog.get('idReset').close();
						$("#pwd,#repwd").val("");
					}
				});
			});
							
			function delUser(ids) {
				$.ajax({
					url : '<%=request.getContextPath() %>/delUser.do',
					data : {ids : ids},
					type : 'POST',
					dataType : 'json',
					success : function() {
						alert("删除用户成功!");
						$('#user-grid').reload();// 表格重载
					}
				});
			}
		});
	</script>
</head>
        
<body>
	<div id="Nav">
		<span>系统管理>>用户管理</span>
		<a class="btn-nav" href="javascript:history.go(-1)">返回</a>
	</div>
	<table id="user-grid"></table>
	
	<div id="adduser" style=" display: none">
  		<form id="addUserFm">
  			<table class="dataTab" id="addUserTab">
				<tr>
					<td class="title_td">用户名</td>
					<td>
						<input name="userName" id="adduserName" isempty="no" tip="用户名不能为空"/>
						<font color="red">*</font>
						<input id="unit_id" type="hidden" name="unitId" value="<%=unitId %>" />
					</td>
				</tr>
				<tr>
					<td class="title_td">姓名</td>
					<td>
						<input name="name" id="addname" isempty="no" tip="姓名不能为空"/>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>	
					<td class="title_td">性别</td>
					<td><select name="sex" style="width:80px;height:23px;">
							<option value="0">男</option>
							<option value="1">女</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="title_td">职务</td>
					<td>
						<input name="duty" id="addduty"/>
						<input type="hidden" name="tecduty" id="addtecduty" value="<%=user.getTecduty() %>"/>
					</td>
				<tr/>
				<tr>	
					<td class="title_td">联系电话</td>
					<td>
						<input name="telephone" id="addtelephone" isempty="no" tip="联系电话不能为空"/>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="title_td">Email</td>
					<td><input name="email" id="addemail"/></td>
				</tr>
				<tr>
					<td class="title_td">其他说明</td>
					<td><textarea name="userComment" id="adduserComment"/></textarea></td>
				</tr>
				<tr>	
					<td class="title_td">是否启用</td>
					<td>
						<select name="inuse" style="width:100px;height:23px;">
							<option value="1">启用</option>
							<option value="0">停用</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center" style="padding-top:20px;">
						<span id="btn-submit" class="btn">保存</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
  
	
  	<div id="updateuser" style="display:none">
  		<form id="updateUserFm">
  			<table class="dataTab">
				<tr>
					<td class="title_td">用户名</td>
					<td>
						<input name="userName" readonly="readonly" id="userName" />
						<input type="hidden" name="userId" />
					</td>
				</tr>
				<tr>
					<td class="title_td">姓名</td>
					<td>
						<input name="name" id="updatename" isempty="no" tip="姓名不能为空"/>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>	
					<td class="title_td">性别</td>
					<td><select name="sex" style="width:80px;height:23px;">
							<option value="0">男</option>
							<option value="1">女</option>
						</select></td>
				</tr>
				<tr>
					<td class="title_td">职务</td>
					<td><input name="duty"/></td>
				</tr>
				<tr>	
					<td class="title_td">联系电话</td>
					<td>
						<input name="telephone" isempty="no" tip="联系电话不能为空"/>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="title_td">Email</td>
					<td><input name="email"/></td>
				</tr>
				<tr>
					<td class="title_td">其他说明</td>
					<td><input name="userComment"/></td>
				</tr>
				<tr>	
					<td class="title_td">是否启用</td>
					<td>
						<select name="inuse" style="width:100px;height:23px;">
							<option value="1">启用</option>
							<option value="0">停用</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center" style="padding-top:20px;">
						<span id="btn-update" class="btn">保存</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
  
  	<div id="userrole" style="display: none">
  		<form id="addUserRoleFm">
  			<table class="dataTab">
				<tr>
					<td class="title_td">用户名</td>
					<td>
						<input name="userName" readonly="readonly" />
						<input type="hidden" name="userId"/>
						<input type="hidden" name="unitId" value="<%=unitId %>" />
					</td>
				</tr>
				<tr>
					<td class="title_td">角色名</td>
					<td>
						<select name="roleId" id="roleId">
							<option value="">请选择</option>
							<c:forEach var="c" items="${roleList}">
							<option value="${c.roleId}"> ${c.roleName}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" style="padding-top:20px;">
						<span id="btn_JiaoSe" class="btn">确定</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
  
  	<div id="resetpwd" style="display:none">
  		<form id="resetPwdFm">
			<table class="dataTab">
				<tr>
					<td class="title_td">新密码</td>
					<td>
						<input name="pwd" id="pwd"  type="password"/>
						<input type="hidden" name="resetpwd_userid" id="resetpwd_userid"/>
					</td>
				</tr>
				<tr>
					<td class="title_td">重复密码</td>
					<td>
						<input type="password" name="repwd" id="repwd" /> 
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" style="padding-top:20px;">
						<span id="btn_reset" class="btn">确定</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
		
</body>
</html>