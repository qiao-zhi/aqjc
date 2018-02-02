<%@ page language="java" import="java.util.*,java.lang.*" pageEncoding="utf-8"%>
<%@ page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.tyust.dao.unit.IunitDao,com.tyust.bean.unit.TBaseUnitInfo,com.tyust.bean.user.TBaseUserInfo"%>
<%@ page import="com.tyust.bean.unit.TBaseUnitRole,com.tyust.dao.user.IuserRoleDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<%
	TBaseUserInfo user = (TBaseUserInfo)session.getAttribute("user");
	ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
	String unitId = user.getUnitId();
	System.out.println("******:"+unitId);
	IunitDao unitDao = (IunitDao)context.getBean("Unit");
	TBaseUnitInfo unit = unitDao.findUnit(unitId);
	//String unitId = user.getUnitId();
	//String unitName ="无";
	//String tabTitle="单位列表";
	//if(unit!=null){
	//	unitName = unit.getUnitName();
	//	tabTitle = "<"+unitName+">下级单位列表";
	//}
	
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
<html>
  <head>
  <jsp:include page="../../common/include-common.jsp"></jsp:include>
  <style>
    .dataTab tr td input {width:200px;}
    .dataTab tr td textarea {width:200px;}
  </style>
  <script type="text/javascript">
  $(function(){
	  $("#flex1").flexigrid({ 
	     	url: '../../lowUnits.do?unitid=<%=unit.getUpUnitId() %>',
	        dataType: 'json',
	        method : 'POST', 
	        display : 'true',     	
	        colModel : [   
			  {display: '上级单位ID', name : 'upUnitId', width : 80, sortable : false, align: 'center',hide: true},
	          {display: '序号', name : 'num', width :30, sortable : false, align: 'center'},
	          {display: '单位名称', name : 'unitName', width : 200, sortable : false, align: 'center',aligntd:'left'},
	          {display: '单位编号', name : 'unitId', width : 100, sortable : true, align: 'center',hide: true},
	          {display: '联系 人', name : 'contactPerson', width : 80, sortable : false, align: 'center'},
	          {display: '联系电话', name : 'telephone', width : 100, sortable : false, align: 'center'},
	          {display: '电子邮件', name : 'email', width : 150, sortable : false, align: 'center'},
	          {display: '传真', name : 'header', width : 100, sortable : false, align: 'center'},
	          {display: '地址', name : 'address', width : 300, sortable : false, align: 'center'},
	          {display: '缩写', name : 'unitClass', width : 50, sortable : false, align: 'center',hide: true}
					],
			buttons : [{name : '添加单位',onpress : action},
			           {separator : true}, 
			           {name : '修改单位',onpress : action},
			           {separator : true},
			           {name : '删除单位',onpress : action},
			           {name: '分配管理员',onpress : action}
			          ],
				
            sortname: "unitId",
            sortorder: "asc",   
            usepager: true,   
            title: false,
            useRp: true,   
            rp: 15,
            pagestat : '显示 {from} 至{to},共 {total}个单位',
            page:1,   		
            checkbox : true,
            showTableToggleBtn: true,
            width:'auto',
            height:'auto'
	    });
        //var actions = "";
		function action(com, grid) {
			switch (com) {
				case '添加单位' :
					$("#infoFmTab input").each(function(i){
			    		$(this).val('');
			    	 });
					$("#address").val("");
					$("#highUnitId").val("<%=unit.getUpUnitId() %>");
					$.dialog({
						content:$("#addUnit")[0],
						title:'添加单位',
						id:'idAdd',
						lock :true,
						background :'#000',
						opacity:0.5
					});
					break;
				
				case '修改单位' :
					selected_count = $('.trSelected', grid).length;
					if (selected_count == 0) {
						alert('请勾选要修改的单位!');
						return;
					}
					if (selected_count > 1) {
						alert('只能同时修改一个单位!');
						return;
					}
					data = new Array();
					$('.trSelected td', grid).each(function(i) {data[i] = $(this).children('div').text();});
					$('#updateUnitFm input[name="updateunitId"]').val($.trim(data[3]));
					$('#updateUnitFm input[name="updateunitName"]').val($.trim(data[2]));
				    $('#updateUnitFm input[name="updatecontactPerson"]').val(strim($.trim(data[4])));
				    $('#updateUnitFm input[name="updatetelephone"]').val(strim($.trim(data[5])));
				    $('#updateUnitFm input[name="updateemail"]').val(strim($.trim(data[6])));
				    $('#updateUnitFm textarea[name="updateaddress"]').val(strim($.trim(data[8])));
				    $('#updateUnitFm input[name="updateheader"]').val(strim($.trim(data[7])));
				    $('#updateUnitFm input[name="updateunitClass"]').val(strim($.trim(data[9])));
				   
				    $.dialog({
						content:$("#updateUnit")[0],
						title:'修改单位',
						lock :true,
						id:'idUpdate',
						background :'#000',
						opacity:0.5
					});
					break;
				case '删除单位' :
					selected_count = $('.trSelected', grid).length;
					if (selected_count == 0) {
						alert('请选择至少一条记录!');
						return;
					}
					ids = '';
					$('.trSelected td:nth-child(5) div', grid).each(function(i) {
						if (i)
							ids += ',';
						ids += $(this).text();
					})
					if (confirm("确定删除?")) {
						delUnit(ids);
					}
					break;
				case '分配管理员' :
					selected_count = $('.trSelected', grid).length;
					if (selected_count == 0) {
						alert('请选择至少一条记录!');
						return;
					}
					if (selected_count > 1) {
						alert('只能同时选择一个单位!');
						return;
					}
					var data = new Array();
					$('.trSelected td', grid).each(function(i) {data[i] = $(this).children('div').text();});
					// 部门缩写
					var unitClass = data[9];
					$("#add_userName").val(unitClass+"Admin");
					$("#add_password").val(unitClass+"Admin");
					$("#add_unitId").val(data[3]);
					$("#add_unitName").val(data[2]);
				   
				    $.dialog({
						content:$("#addUnitAdmin")[0],
						title:'分配管理员',
						lock :true,
						id:'idAddUnitAdmin',
						background :'#000',
						opacity:0.5
					});
					break;
			}
		}
						
	$("#updateUnitBtn").click(function() {
		if (validate($("#updateUnitFm"))){
			return false;
		}
		var $mark = $("body>div").last();
		var _zIndex = $mark.css('zIndex');
		$mark.css({
			zIndex:9999
		});
			$.ajax({
					url : '<%=request.getContextPath() %>/updateUnit.do',
					data : $("#updateUnitFm").serialize(),
					type : 'POST',
					dataType : 'json',
					success : function(data) {
						$mark.css('zIndex',_zIndex);
						$.dialog.get('idUpdate').close();
						alert('修改成功');
						$('#flex1').reload();
					}
			});
	});
	$("#submitUnit").click(function() {
		if (validate($("#addUnitFm"))){
			return false;
		}
		var $mark = $("body>div").last();
		var _zIndex = $mark.css('zIndex');
		$mark.css({
			zIndex:9999
		});
			$.ajax({
					url : '<%=request.getContextPath() %>/saveUnit.do',
					data : $("#addUnitFm").serialize(),
					type : 'POST',
					dataType : 'json',
					success : function(data) {	
						$mark.css('zIndex',_zIndex);
						$.dialog.get('idAdd').close();
						alert('添加成功');
						$('#flex1').reload();
					}
			});
		});
		function delUnit(ids) {
			$.ajax({
				url : '<%=request.getContextPath() %>/delUnit.do',
				data : {unitId : ids},
				type : 'POST',
				dataType : 'json',
				success : function(data) {
					if(data=="0"){
						alert("删除成功！");
						$('#flex1').reload();// 表格重载
					}
					if(data=="1"){
						alert("所选单位有下级单位，请先删除下级单位！");
					}
					if(data=="2"){
						alert("所选单位有成员存在，请先删除单位成员！");
					}
					
				}
			});
		};
		
		// 添加部门管理员
		$("#submitUnitAdmin").click(function() {
			if (validate($("#addUnitAdminFm"))){
				return false;
			}
			var $mark = $("body>div").last();
			var _zIndex = $mark.css('zIndex');
			$mark.css({
				zIndex:9999
			});
			$.ajax({
				url : '<%=request.getContextPath() %>/addUnitAdmin.do',
				data : $("#addUnitAdminFm").serialize(),
				type : 'POST',
				dataType : 'json',
				success : function(data) {	
					$mark.css('zIndex',_zIndex);
					$.dialog.get('idAddUnitAdmin').close();
					alert('添加成功');
					$('#flex1').reload();
				}
			});
	});	

  });
	
  </script>

  </head>
  <body>
  <div id="Nav">
		<span>系统管理>>单位管理</span>
		<a class="btn-nav" href="javascript:history.go(-1)">返回</a>
  </div>
  <table id="flex1"></table>
  <div id="updateUnit" style=" display: none">
  	<form id="updateUnitFm" >
		<table class="dataTab">
		     <tr>
				<td class="title_td">单位名称</td>
   				<td>
    				<input type="hidden" name="updateunitId" />
    				<input type="text" name="updateunitName" id="updateunitName" isempty="no" tip="名称不能为空"/>
    				<font color="red">*</font>
   				</td>
   		     </tr>
   		     <tr>
		        <td class="title_td">单位缩写</td>
		        <td><input type="text" name="updateunitClass" id="updateunitClass"/> </td>
			  </tr>
   		     <tr>
		        <td class="title_td">联系人</td>
		        <td><input type="text" name="updatecontactPerson" id="updatecontactPerson"/> </td>
			  </tr>
		      <tr>
		        <td class="title_td">联系电话</td>
		        <td>
			        <input type="text" name="updatetelephone" id="updatetelephone"/>
		        </td>
		      </tr>
		       <tr>
		        <td class="title_td">电子邮件</td>
		        <td>
			        <input type="text" name="updateemail" id="updateemail"/>
		        </td>
		      </tr>
		      <tr>
   		     	<td class="title_td">传真</td>
   		     	<td><input type="text" name="updateheader" id="updateheader"/> </td>
   		     </tr>
		      <tr>
		        <td class="title_td">地址</td>
		        <td><textarea name="updateaddress" id="updateaddress"></textarea></td>
		      </tr>		 
		  </table>
		  <div align="center" style="padding-top:20px;">
			  <input class="btn" type="button" id="updateUnitBtn" value="保存" />
 		  </div>
		</form>
   </div>
   <div id="addUnit" style=" display: none">
	  	<form id="addUnitFm" >
		    <table class="dataTab" id="infoFmTab">
			  <tr>
			    <td class="title_td">单位名称</td>
			    <td> 
				    <input type="text" name="unitName"  id="unitName" isempty="no" tip="名称不能为空"/>
				    <font color="red">*</font>
				    <input type="hidden" id="highUnitId" name="unitId" />
			    </td>
			  </tr>
			   <tr>
			    <td class="title_td">单位缩写</td>
			    <td>
			    	<input type="text" name="unitClass" id="unitClass" isempty="no" tip="缩写不能为空"/>
			    	<font color="red">*</font>
				</td>
			  </tr>
			  <tr>
			    <td class="title_td">联系人</td>
			    <td><input type="text" name="contactPerson" id="contactPerson"/>
				</td>
			  </tr>
			  <tr>
			    <td class="title_td">联系电话</td>
			    <td><input type="text" name="telephone" id="telephone" />			     
				</td>
			  </tr>
			  <tr>
			    <td class="title_td">电子邮件</td>
			    <td><input type="text" name="email" id="email" />			     
				</td>
			  </tr>
			  <tr>
			    <td class="title_td">传真</td>
			    <td> 				
				    <input type="text" name="header" id="header" />		   
			    </td>
			  </tr>
			  <tr>
			    <td class="title_td">地址</td>
			    <td><textarea name="address" id="address"></textarea></td>
			  </tr>
		    </table>
		    <div align="center" style="padding-top:20px;">
		    	<input class="btn" type="button" id="submitUnit" value="保存" />
		    </div>
	    </form>
	  </div>
	  <!-- 分配部门管理员 -->
	  <div id="addUnitAdmin" style=" display: none">
	  	<form id="addUnitAdminFm" >
		    <table class="dataTab" id="infoFmTab">
			  <tr>
			    <td class="title_td">用户名</td>
			    <td>
				    <input type="text" name="userName"  id="add_userName" isempty="no" tip="名称不能为空"/>
				    <font color="red">*</font>
			    </td>
			  </tr>
			   <tr>
			    <td class="title_td">密码</td>
			    <td>
			    	<input type="password" name="password" id="add_password"/>
				</td>
			  </tr>
			  <tr>
			    <td class="title_td">所属单位</td>
			    <td>
			    	<input type="text" name="unitName" id="add_unitName" readonly="readonly"/>
			    	<input type="hidden" name="unitId" id="add_unitId"/>
				</td>
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
			    <td class="title_td">角色</td>
			    <td>
			    	<select name="roleId" id="add_role" style="width:100px;height:23px;">
			    		<c:forEach var="c" items="${roleList}">
						<option value="${c.roleId}"> ${c.roleName}</option>
						</c:forEach>	
			    	</select> 
				</td>
			  </tr>
		    </table>
		    <div align="center" style="padding-top:20px;">
		    	<input class="btn" type="button" id="submitUnitAdmin" value="保存" />
		    </div>
	    </form>
	  </div>
  </body>
</html>