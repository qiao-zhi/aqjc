<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%> 
 
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../../common/include-common.jsp"></jsp:include>
<script>
	function gotoFirst() {
		history.back()
	};
	function checkfu(menuid) {
		var idd;
		//上级级联下级
		for (var i = 0; i < document.getElementsByName("menuId").length; i++) {
			idd = document.getElementsByName("menuId")[i].value.substring(0,menuid.length);

			if (menuid == idd) {
				var iddd = document.getElementsByName("menuId")[i].value
				document.getElementById(iddd).checked = document.getElementById(menuid).checked

			}
		}
		var lengths = menuid.length;
		var id = menuid.substring(0, lengths - 3);
		var mid = '';
		var falg = false;//默认同级中没有选中的
		//同级的没有选中的，才能都选
		for (var i = 0; i < document.getElementsByName("menuId").length; i++) {

			if (document.getElementsByName("menuId")[i].value != menuid) {
				mid = document.getElementsByName("menuId")[i];
			}
			//同级中有选中的
			if (mid != '') {
				if (mid.value.length == lengths) {
					if (mid.checked == true) {
						//alert('长度相同的有选中的'+mid.value);
						if (mid.value.substring(0, lengths - 3) == id) {
							//alert('同级中有选中的');
							falg = true;
						}
					}
				}
			}

		}

		if (falg == false) {
			//alert('同级中没有选中的')
			//级联选中上级
			while (lengths > 3 & id != '') {
				// alert(lengths)
				id = menuid.substring(0, lengths - 3);
				document.getElementById(id).checked = document.getElementById(menuid).checked;
				lengths = lengths - 3;
			}
		}
	}
</script>
</head>

<body>
 	<form action="<%=request.getContextPath() %>/editRoleModule.do"  method="post">
	    <input type="hidden" name="roleId" value="${roleId }"/>
	    <input type="hidden" name="unitId" value="${unitId }"/>
	    <input type="hidden" name="roleModuleList" value="${roleModuleList }"/>
	    <div id="btns-postion">
		    <table>
				<tr>
					<th width="10%">权限ID</th>
					<th width="20%">权限名称</th>
					<th width="40%">权限URL</th>
					<th width="20%">
						<input type="submit" value="保存"/>
						<input type="reset" value="取消"/>
	            		<input type="button" value=返回 onclick="gotoFirst()"/>
					</th>
				</tr>
		    </table>
	    </div>
	 	<table id="roleTab">
			<c:forEach items="${ModulesList}" var="menu">
			<tr>
				<td width="10%">${menu.moduleId}</td>
				<td width="20%">${menu.moduleName}</td>
				<td width="40%">${menu.moduleUrl}</td>	
				<td width="20%">   
				<c:choose>                  
					<c:when test="${roleModuleList!=null}">
                    <input type="checkbox" onclick="checkfu('${menu.moduleId}')" name="menuId" id="${menu.moduleId}" value="${menu.moduleId}" 
					<c:forEach items="${roleModuleList}" var="menued">
						<c:if test="${menued.moduleId ==menu.moduleId}">
							checked="checked"
						</c:if>
					</c:forEach>/>
                    </c:when>
					<c:otherwise>
					<input type="checkbox" onclick="checkfu('${menu.moduleId}')" name="menuId" id="${menu.moduleId}" value="${menu.moduleId}" />
					</c:otherwise>
				</c:choose>
				</td>
			</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>
