<%@ page language="java" import="java.util.*,java.lang.*" pageEncoding="utf-8"%>
<%  
  String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head> 
	<jsp:include page="../../common/include-common.jsp"></jsp:include>
	<style>
      .dataTab tr td input {width:200px;height:21px;}
    </style>
	<script>   
	$(function(){
		$("#dic-grid").flexigrid({   
	     	url: '${pageContext.request.contextPath}/finddic_getElementById.do?id=<%=id%>',
	        dataType: 'json',
	        method : 'POST', 
	        display : 'true',     	
	        colModel : [   
	          {display: '上级字典', name : 'matchdicid', width :100, sortable : true, align: 'center'},
	          {display: '中文名称', name : 'dictionaryOptionName', width : 150, sortable : true, align: 'left',hide: false},           
	          {display: '编号', name : 'dictionaryOptionId', width : 50, sortable : true, align: 'center',hide:true},         
	          {display: '是否启用', name : 'inuse', width : 50, sortable : true, align: 'center'} ,           
	          {display: '字典项描述', name : 'descriptions', width : 130, sortable : true, align: 'center'} ,           
	          {display: '排序号', name : 'sortno', width : 50, sortable : true, align: 'center'},
	          {display: '英文名称', name : 'englishname', width : 100, sortable : true, align: 'center'},
	          {display: '数据类型', name : 'datatype', width : 80, sortable : true, align: 'center'},
	          {display: '数据类型code', name : 'datatypeCode', width : 80, sortable : true, align: 'center',hide:true},
	          {display: '是否启用code', name : 'inuseCode', width : 80, sortable : true, align: 'center',hide:true}
					],
			buttons : [
			  {name : '增加',onpress : action},{separator : true},
			  {name : '删除',onpress : action},{separator : true}, 
			  {name : '修改',onpress : action}
			],
	        sortname: "RINO",   
	        sortorder: "desc",   
	        usepager: false,   
	        title: false,   
	        useRp: false,   
	        rp: 30,
	        page:1,   		
	        checkbox : true,
	        showTableToggleBtn: true,
	        width: 'auto',
	        height:'auto'
		});
			
		var actions = "";
		function action(com, grid) {
			switch(com) {
				case '增加' :
					$('#addDicFm input[name="upid"]').val('<%=id%>');
					$("#addDicSubmit").attr({disabled:false});
					$.dialog({
						content:$("#adddic")[0],
						title:'添加字典',
						lock :true,
						id:'idAdd',
						background :'#000',
						opacity:0.5
					});
					break;
				case '删除' :
					selected_count = $('.trSelected', grid).length;
					if (selected_count == 0) {
						alert('请至少选择一条记录!');
						return;
					}
					ids = '';
					$('.trSelected td:nth-child(4) div', grid).each(function(i) {
						if (i)
							ids += ',';
						ids += $(this).text();
					});
					if (confirm("确定删除?")) {
						delDic(ids);
					}
					break;
				case '修改' :
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
					$('#updateDicFm input[name="update_id"]').val($.trim(data[2]));		
					$('#updateDicFm input[name="update_dicname"]').val($.trim(data[1]));
					$('#updateDicFm select[name="update_inuse"]').val($.trim(data[3]));
					$('#updateDicFm input[name="update_descriptions"]').val(strim($.trim(data[4])));
					$('#updateDicFm input[name="update_sortno"]').val($.trim(data[5]));
					$('#updateDicFm input[name="update_englishname"]').val(strim($.trim(data[6])));
					$('#updateDicFm select[name="update_datatype"]').val(strim($.trim(data[8])));
					$('#updateDicFm input[name="update_inuse"]').val(strim($.trim(data[9])));
					
					$("#updateDicSubmit").attr({disabled:false});
					$.dialog({
						content:$("#updatedic")[0],
						title:'修改字典',
						lock :true,
						id:'idUpdate',
						background :'#000',
						opacity:0.5
					});
					break;
			}
		}

		$("#btn-submit").click(function() {
			if (!validate($("#addDicFm"))){
				$.ajax({
					url : '${pageContext.request.contextPath}/dicManage_addDic.do',
					data : $("#addDicFm").serialize(),
					type : 'POST',
					dataType : 'json',
					success : function(data) {
						alert('添加成功');
						$.dialog.get('idAdd').close();
						$('#dic-grid').reload();
						$("#dicname").val("");
						$("#descriptions").val("");
						$("#matchdicid").val("");
					}
				});
			}
		});
	
	$("#btn-update").click(function() {
		if (!validate($("#updateDicFm"))){
			$.ajax({
				url : '${pageContext.request.contextPath}/dicManage_updateDic.do',
				data : $("#updateDicFm").serialize(),
				type : 'POST',
				dataType : 'json',
				success : function(data) {
					alert('修改成功');
					$.dialog.get('idUpdate').close();
					$('#dic-grid').reload();
				}
			});
		}
	});
		
	function delDic(ids) {
		$.ajax({
			url : '${pageContext.request.contextPath}/dicManage_delDic.do',
			data : {
				ids : ids
			},
			type : 'POST',
			dataType : 'json',
			success : function() {
				alert('删除成功');
				$('#dic-grid').reload();// 表格重载
			}
		});
	}
	});		
	</script>
</head>

<body>
	<table id="dic-grid"></table>
  
	
	<div id="adddic" style="display: none">
		<form id="addDicFm">
			<table class="dataTab">
				<tr>
					<td class="title_td">中文名称</td>
					<td><input name="dicname" id="dicname" isempty="no" tip="中文名称不能为空"/>
					<input name="upid"  id="upid" type="hidden" />
					</td>
				</tr>
				<tr>
					<td class="title_td">英文名称</td>
					<td><input name="englishname" id="englishname" /></td>
				</tr>
				<tr>
					<td class="title_td">数据类型</td>
					<td>
						<select name="datatype" id="datatype" style="width:100px;height:23px;">
							<option value="1">数字型</option>
							<option value="2">字符型</option>
							<option value="3">日期型</option>
							<option value="4">数据字典</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="title_td">字典项描述</td>
					<td>
						<input name="descriptions" id="descriptions" />
					</td>
				</tr>
				<tr>
					<td class="title_td">排序号</td>
					<td>
						<input  name="sortno" id="sortno" value="0" onkeyup="value=value.replace(/[^\d]/g,'')"/>
					</td>
				</tr>
				<tr>
					<td class="title_td">是否启用</td>
					<td>
						<select name="inuse" id="inuse" style="width:100px;height:23px;">
							<option value="1">启用</option>
							<option value="0">停用</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" style="padding-top:20px;">
						<span id="btn-submit" class="btn">确定</span>
					</td>
				</tr>
			</table>
		</form>
	</div>

	<div id="updatedic" style="display: none">
		<form id="updateDicFm">
			<table class="dataTab">
				<tr>
					<td class="title_td">中文名称</td>
					<td><input name="update_dicname" id="update_dicname" isempty="no" tip="中文名称不能为空"/>
						<input type="hidden" name="update_id" id="update_id"/>
					</td>
				</tr>
				<tr>
					<td class="title_td">英文名称</td>
					<td><input name="update_englishname" id="update_englishname"  /></td>
				</tr>
				<tr>
					<td class="title_td">数据类型</td>
					<td>
						<select name="update_datatype" id="update_datatype" style="width:100px;height:23px;">
							<option value="1">数字型</option>
							<option value="2">字符型</option>
							<option value="3">日期型</option>
							<option value="4">数据字典</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="title_td">字典项描述</td>
					<td>
						<input name="update_descriptions" id="update_descriptions"/>
					</td>
				</tr>
				<tr>
					<td class="title_td">排序号</td>
					<td>
						<input name="update_sortno" id="update_sortno"  onkeyup="value=value.replace(/[^\d]/g,'')" />
					</td>
				</tr>
				<tr>
					<td class="title_td">是否启用</td>
					<td>
						<select name="update_inuse" id="update_inuse" style="width:100px;height:23px;">
							<option value="1">启用</option>
							<option value="0">停用</option>
						</select>
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