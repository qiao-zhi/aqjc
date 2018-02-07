<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.tyust.bean.user.TBaseUserInfo" %>
<%@ page import="com.tyust.bean.unit.TBaseUnitInfo" %>
<%@ page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.tyust.dao.unit.IunitDao"%>
<%@ page import="com.tyust.dao.user.IuserDao"%>
<%@ page import="java.util.*,com.tyust.common.DateHandler" %>
<%
	ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
	
	String enApplyId = request.getParameter("enApplyId");
	String enApplyUnitId = request.getParameter("enApplyUnitId");
	String enApplyUserId = request.getParameter("enApplyUserId");
	// 获取申请部门信息
	IunitDao unitDao = (IunitDao)context.getBean("Unit");
	TBaseUnitInfo unit = unitDao.findUnit(enApplyUnitId);

%>
<!DOCTYPE html>
<html>
<head>
	<title>屏蔽室申请</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/font-awesome-4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/ionicons-2.0.1/css/ionicons.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/dist/css/AdminLTE.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/plugins/iCheck/flat/blue.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/dist/css/skins/skin-blue.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/webuploader/css/webuploader.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/webuploader/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/lightbox/css/lightbox.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/css/fileinput.min.css" />
	<style>
		.dataTab input{width:220px;height:23px;}
		.dataTab select{width:110px;height:22px;}
	</style>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">

    <!-- Main content -->
    <section class="content">
      <div class="row">
       <div class="col-md-12">

        <div class="box box-solid box-primary">
          <div class="box-header with-border">
            <h3 class="box-title">环境检测申请审核</h3>
          </div><!-- /.box-header -->

          <div class="box-body pad">
            <div class="row">
              <div class="col-md-8 col-md-offset-2">
            	<div class="box box-info">
             <div class="box-header with-border">
                <h3 class="box-title">基本信息</h3>
             </div>
            <div class="box-body">
              <form id="enApplyInfo_form" class="form-horizontal">
             	<div class="row">
              		<div class="col-sm-6">
                  	  <div class="form-group">
                       <label for="input1" class="col-sm-4 control-label">申请单位</label>
                      <div class="col-sm-8">
                      	<!-- 隐藏 -->
                      	<input name="enApplyInfo.environmentApplyUnitId" value="<%=enApplyUnitId %>" type="hidden">
                        <input type="text" readonly="readonly" class="form-control" value="<%=unit.getUnitName() %>">
                      </div>
                      </div>
                    </div>
                <div class="col-sm-6">
                  <div class="form-group">
                    <label for="pbsApplyDate" class="col-sm-4 control-label">申请日期</label>
                    <div class="col-sm-8">
                      <input id="enApplyDate" readonly="readonly" name="enApplyInfo.environmentApplyDate" type="text" class="form-control">
                    </div>
                  </div>
                 </div>
                </div>

                <div class="row">
                  <div class="col-sm-6">
                    <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">申请人</label>
                    <div class="col-sm-8">
                      <!-- 隐藏 -->
                      <input name="enApplyInfo.environmentApplyUserId" value="<%=enApplyUserId %>" type="hidden">
                      <input type="text" id="enApplyUserName" readonly="readonly" class="form-control">
                    </div>
                    </div>
                   </div>
                   <div class="col-sm-6">
                     <div class="form-group">
                     <label for="enApplyTel" class="col-sm-4 control-label">联系方式</label>
                      <div class="col-sm-8">
                       <input id="enApplyTel" readonly="readonly" type="text" name="enApplyInfo.environmentApplyTel" class="form-control">
                     </div>
                    </div>
                  </div>
                </div>
                
                <div class="row">
                  <div class="col-sm-6">
                    <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">样品名称</label>
                    <div class="col-sm-8">
                      <input id="enApplySamply" readonly="readonly" name="enApplyInfo.environmentApplySamply" type="text" class="form-control">
                    </div>
                    </div>
                   </div>
                   <div class="col-sm-6">
                     <div class="form-group">
                     <label for="input1" class="col-sm-4 control-label">生产单位</label>
                      <div class="col-sm-8">
                       <input id="enApplyProduction" readonly="readonly" type="text" name="enApplyInfo.environmentApplyProduction" class="form-control">
                     </div>
                    </div>
                  </div>
                </div>
                
                <div class="row">
                  <div class="col-sm-12">
                    <div class="form-group">
                    <label for="input1" class="col-sm-2 control-label">申请意见</label>
                    <div class="col-sm-10">
                      <textarea id="enApplyOpinion" readonly="readonly" name="enApplyInfo.environmentApplyOpinion" class="textarea333" placeholder="请填写申请意见" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
                    </div>
                    </div>
                   </div>
                </div>                
                <!-- 环境检测申请id -->
                <input type="hidden" id="enApplyId" name="enApplyInfo.environmentApplyId" value="<%=enApplyId%>">
                <!-- 隐藏 操作：保存与提交-->
                <input type="hidden" id="operate" name="operate" value="save"/>
                </form>
             </div>
            </div>
            
            <div class="box box-info">
              <div class="box-header with-border">
                <h3 class="box-title">申请书扫描附件</h3>
              </div>
              <div class="box-body">
              	 <div class="row" id="file">
              	 	<div class="col-sm-8">
              			<div id="scanFile"></div>
              		</div>
              	 </div>
              </div>
            </div>
            
            <div class="box box-info">
              <div class="box-header with-border">
                <h3 class="box-title">申请书电子版</h3>
              </div>
              <div class="box-body">
              	 <div class="row" id="attachFile">
              	 	<div class="col-sm-8">
              			<div id="fileName"></div>
              		</div>
              	 </div>
              </div>
            </div>
            
            <div class="box box-info">
              <div class="box-header with-border">
                <h3 class="box-title">审核内容</h3>
              </div>


		      <div class="box-body">
		      
		      
		       <div class="row">
                  <div class="col-sm-6">
                    <div class="form-group">
                    <label for="input1" class="col-sm-3 control-label">审核人</label>
                    <div class="col-sm-8">
                      <input id="auditUserName" type="text" class="form-control">
                    </div>
                    </div>
                   </div>
                   
                <div class="col-sm-6">
                  <div class="form-group">
                    <label for="pbsApplyDate" class="col-sm-4 control-label">审核日期</label>
                    <div class="col-sm-8">
                      <input id="auditDate" type="text" class="form-control" readonly
                      onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})">
                    </div>
                  </div>
                 </div>
                </div>
		      	<br/>
		      	<br/>
              	 <div class="row">
              		 <div class="form-group">
                   		 <label for="pbsApplyDate" class="col-sm-4 control-label">审核意见</label>
	              	 	<div class="col-sm-12">
	              	 		<br/>
	               			<textarea id="auditOppinion"  class="textarea333" placeholder="请填写审核意见" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>     
	              		</div>
              		</div>
              	 </div>
              	 
              	 
              	 
              	 
              </div>



            </div>
            
            </div>
           </div>   
          </div><!-- /.box-body -->
          <div class="box-footer">
          
          <input type="hidden" id="auditResult"/>
          <div style="text-align:center">
		      <button id="audityes" type="button" class="btn btn-info">审核通过</button>
              <button id="auditno" type="button" style="margin-left:20px;" class="btn btn-default">不通过</button>
          </div>
		  </div>
        </div><!-- /.box -->

       </div>
       <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

</div>
<!-- ./wrapper -->
<script src="<%=request.getContextPath() %>/newStyle/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/lightbox/js/lightbox-plus-jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/controls/JCalendar/WdatePicker.js"></script>
<!--S   QLQ2018.02.06改造的  -->
<script>
$(function(){
	//显示申请信息
	showEnApplyInfo();
	//显示扫描附件信息
	showEnAttach('3');
	//显示申请书附件
	showEnAttach('1');
})



/**
查询附件信息
**/
function showEnAttach(attachType){
	$.ajax({
		url : '${pageContext.request.contextPath}/enApplyInfo_selEnAttach.do',
		data : {'enApplyId' : '<%= enApplyId%>',
				'enAttachType' : attachType	
		},
		type : 'POST',
		dataType : 'json',
		success : function(response) {
			var info = eval(response);
			var isNull = info.isNull;
			if (isNull == 0) {
				$("#file").empty();
				loadFileinput();
			} else {
				var url = info.fileUrl;
				var fileName = info.fileName;
				var enAttachId = info.enAttachId;
				var URL='/file/'+url;
				//如果是扫描附件
				if(attachType == '3'){
					$("#hidden_scan_id").val(enAttachId);//向隐藏的扫描附件赋值
					$("#scanFile").append("<a target='_blank' href='"+URL+"'>"+fileName+"</a>");
				}else{//如果是申请书电子版
					$("#hidden_attach_id").val(enAttachId);//向隐藏的申请附件赋值
					$("#fileName").append("<a target='_blank' href='"+URL+"'>"+fileName+"</a>");
				}
			}
		}
	});
}

// 显示环境申请信息
function showEnApplyInfo() {
	$.ajax({
		url : '${pageContext.request.contextPath}/enApplyInfo_selEnApplyInfoById.do',
		data : {'enApplyId' : '<%= enApplyId%>'},
		type : 'POST',
		dataType : 'json',
		success : function(response) {
			var info = eval(response);
			$("#enApplyDate").val(info.enApplyDate);
			$("#enApplyUserName").val(info.enApplyUserName);
			$("#enApplyTel").val(info.enApplyTel);
			$("#enApplySamply").val(info.enApplySamply);
			$("#enApplyProduction").val(info.enApplyProduction);
			$("#enApplyOpinion").val(info.enApplyOpinion);
		}
	});
}
$(document).ready(function(){
	$("#audityes").click(function (){
		$("#auditResult").val("1");
		saveInfo();
	});
	$("#auditno").click(function (){
		$("#auditResult").val("0");
		saveInfo();
	});
});

function saveInfo(){
	
	var auditResult = $("#auditResult").val();
	var auditOppinion = $("#auditOppinion").val();
	var enApplyId = '<%=enApplyId %>';
	var enApplyId = '<%=enApplyId %>';
	var auditUserName = $("#auditUserName").val();
	var auditDate = $("#auditDate").val();
	if(auditUserName == "" || auditDate == "" || auditOppinion == ""){
		alert("请完善审核信息!");
		return;
	}
	if(!confirm("确认进行审核?审核之后审核信息不可更改!")){
		return;
	}
	$.ajax({
		url : '${pageContext.request.contextPath}/enApplyInfo_saveEnApplyAudit.do',
		data : {'auditResult' : auditResult,
			'auditOppinion' : auditOppinion,//审核人
			'auditUserName':auditUserName,//审核日期
			auditDate:auditDate,
			'enApplyId' : enApplyId},
		dataType : 'json',
		type : 'POST',
		success : function(data){
			var data = eval(data);
			if(data.result == "success"){
				alert("审核成功");
				window.location.href = 'enApplyAudit_list.jsp';
			} else {
				alert("保存错误");
			}
		},
		error : function(){
			alert("审核错误");
		}
	});
}
</script>


<!--E   QLQ2018.02.06改造的  -->



<script>
	$(function() {
		showEnPic();
	});
	
	var isAttach = false;
	
	function showEnPic(){
		$.ajax({
			url : '${pageContext.request.contextPath}/enApplyInfo_selEnPic.do',
			data : {'enApplyId' : '<%= enApplyId%>',
				'enPicType' : '1'},
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var pic = eval(response);
				var len = pic.length;
				var a = len / 3;
				var row = parseInt(a);
				if(a > row){
					row = row + 1;
				}
				for(var i = 0;i < row;i++){
					var str  = "<div class='row'>";
					for(var j = 0;j<3;j++){
						var index = i*3+j;
						if(index < len){
							var ind = new Number(index);
							var url = pic[ind].enPicUrl;
							var id = pic[ind].enPicId;
							str = str + "<div class='col-sm-3' id='"+id+"'>";
		        			str = str + "<a href='../../uploads/enPic/"+url+"' data-lightbox='1'><img width='210px' height='290px' src='../../uploads/enPic/"+url+"'></a>";
		        			str = str + "</div>";
						}
					}
        			str = str + "</div>";
        			$("#pic").append(str);
				}
			}
		});
	}
	

</script>
</body>
</html>