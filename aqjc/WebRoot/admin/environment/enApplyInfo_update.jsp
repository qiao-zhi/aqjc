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
	// 获取申请人信息
	IuserDao userDao = (IuserDao)context.getBean("User");
	List<TBaseUserInfo> userList = new ArrayList<TBaseUserInfo>();
	userList = userDao.selectUserInfoById(enApplyUserId);
	TBaseUserInfo user = userList.get(0);
	
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
            <h3 class="box-title">环境检测申请</h3>
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
                        <input type="text" class="form-control" value="<%=unit.getUnitName() %>">
                      </div>
                      </div>
                    </div>
                <div class="col-sm-6">
                  <div class="form-group">
                    <label for="pbsApplyDate" class="col-sm-4 control-label">申请日期</label>
                    <div class="col-sm-8">
                      <input id="enApplyDate" name="enApplyInfo.environmentApplyDate" type="text" class="form-control"
                      onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})">
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
                      <input id="enApplyUserName" name="enApplyInfo.environmentApplyUserName" type="text" class="form-control" value="<%=user.getName() %>">
                    </div>
                    </div>
                   </div>
                   <div class="col-sm-6">
                     <div class="form-group">
                     <label for="enApplyTel" class="col-sm-4 control-label">联系方式</label>
                      <div class="col-sm-8">
                       <input id="enApplyTel" type="text" name="enApplyInfo.environmentApplyTel" class="form-control">
                     </div>
                    </div>
                  </div>
                </div>
                
                <div class="row">
                  <div class="col-sm-6">
                    <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">样品名称</label>
                    <div class="col-sm-8">
                      <input id="enApplySamply" name="enApplyInfo.environmentApplySamply" type="text" class="form-control">
                    </div>
                    </div>
                   </div>
                   <div class="col-sm-6">
                     <div class="form-group">
                     <label for="input1" class="col-sm-4 control-label">生产单位</label>
                      <div class="col-sm-8">
                       <input id="enApplyProduction" type="text" name="enApplyInfo.environmentApplyProduction" class="form-control">
                     </div>
                    </div>
                  </div>
                </div>
                
                <div class="row">
                  <div class="col-sm-12">
                    <div class="form-group">
                    <label for="input1" class="col-sm-2 control-label">申请意见</label>
                    <div class="col-sm-10">
                      <textarea id="enApplyOpinion" name="enApplyInfo.environmentApplyOpinion" class="textarea333" placeholder="请填写申请意见" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
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
                <h3 class="box-title">申请书扫描照片</h3>
              </div>
              <div class="box-body">
         		<div class="container" id="pic">
             	 	
               </div>

               <div id="container">
             	 <!--头部，相册选择和格式选择-->
              	<div id="uploader">
               	 <div class="queueList">
                    <div id="dndArea" class="placeholder">
                        <div id="filePicker"></div>
                        <p>或将照片拖到这里，单次最多可选300张</p>
                    </div>
                 </div>
                 <div class="statusBar" style="display:none;">
                    <div class="progress">
                        <span class="text">0%</span>
                        <span class="percentage"></span>
                    </div><div class="info"></div>
                    <div class="btns">
                        <div id="filePicker2"></div>
                    </div>
                 </div>
                 </div>
               </div>
              </div>
            </div>
            
            <div class="box box-info">
              <div class="box-header with-border">
                <h3 class="box-title">申请书电子版</h3>
              </div>
              <div class="box-body">
              	 <div class="row" id="file">
              	 	<div class="col-sm-8">
              			<div id="fileName"></div>
              		</div>
              		<div class="col-sm-4">
              			<button style="float:right;" id="delAttach" class="btn btn-info">删除</button>
              		</div>
              	 </div>
              </div>
            </div>
            </div>
           </div>   
          </div><!-- /.box-body -->
          <div class="box-footer">
          	<center>
		      <button id="save" type="button" class="btn btn-default">保存</button>
              <button id="submit" type="button" style="margin-left:20px;" class="btn btn-info">提交</button>
		   	</center>
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
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/dist/webuploader.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/upload_enApplyInfo.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/lightbox/js/lightbox-plus-jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/js/fileinput.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-fileinput/js/fileinput_locale_zh.js"></script>
<script src="<%=request.getContextPath() %>/controls/JCalendar/WdatePicker.js"></script>
<script>
	$(function() {
		showEnApplyInfo();
		showEnPic();
		showEnAttach();
	});
	
	var isAttach = false;
	
	// 显示屏蔽室申请信息
	function showEnApplyInfo() {
		$.ajax({
			url : '${pageContext.request.contextPath}/enApplyInfo_selEnApplyInfoById.do',
			data : {'enApplyId' : '<%= enApplyId%>'},
			type : 'POST',
			dataType : 'json',
			success : function(response) {
				var info = eval(response);
				$("#enApplyDate").val(info.enApplyDate);
				$("#enApplyUserName").val(info.enApplyUserName)
				$("#enApplyTel").val(info.enApplyTel);
				$("#enApplySamply").val(info.enApplySamply);
				$("#enApplyProduction").val(info.enApplyProduction);
				$("#enApplyOpinion").val(info.enApplyOpinion);
			}
		});
	}
	
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
		        			str = str + "<div class='row'>";
		        			str = str + "<div class='col-sm-2'>";
		        			str = str + "<button class='btn btn-default' onclick='delEnPic(\""+id+"\")'>删除</button>";
		        			str = str + "</div>"
		        			str = str + "</div>";
		        			str = str + "</div>";
						}
					}
        			str = str + "</div>";
        			$("#pic").append(str);
				}
			}
		});
	}
	
	function showEnAttach(){
		$.ajax({
			url : '${pageContext.request.contextPath}/enApplyInfo_selEnAttach.do',
			data : {'enApplyId' : '<%= enApplyId%>'},
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
					var URL = '${pageContext.request.contextPath}/enApplyInfo_downAttach.do?filename='+url;
					$("#fileName").append("<a href='"+URL+"'>"+fileName+"</a>");
					$("#delAttach").click(function (){
						delAttachConf(enAttachId);
					});
				}
			}
		});
	}
	
	
	$(document).ready(function(){
		$("#save").click(function (){
			$("#operate").val("save");
			saveInfo();
		});
		$("#submit").click(function (){
			$("#operate").val("submit");
			saveInfo();
		});
	});
	
	function validate(){
		if($("#enApplyUserName").val() == "") {
			return true;
		}
		if($("#enApplyTel").val() == ""){
			return true;
		}
		if($("#enApplySamply").val() == ""){
			return true;
		}
		if($("#enApplyProduction").val() == "") {
			return true;
		}
	}
	
	// 添加图片的数量
	var num = 0;
	function saveInfo(){
		if (validate()){
			alert("请完善信息");
			return;
		}
		$.ajax({
			url : '<%=request.getContextPath()%>/enApplyInfo_saveEnApplyInfo.do',
			type : 'POST',
			dataType : 'json',
			data : $("#enApplyInfo_form").serializeArray(),
			success : function(data){
				var data = eval(data);
				if (data.result == "success"){
					// 获取保存好的屏蔽室申请ID
					var enApplyId = data.enApplyId;
					// 添加图片的数量
					num = uploader.getFiles().length;
					if (num > 0) {
						uploadImage(enApplyId);
					}
					// 附件上传
					if (isAttach) {
						fileUpload(enApplyId);
					}
					alert("保存成功！")
			  	}
			},
			error : function(data){
				alert("error");
			}
		});
	}
	
	function uploadImage(enApplyId){
		// 设置图片上传的url
		var url = "<%=request.getContextPath()%>/enApplyInfo_saveEnPic.do?enApplyId="+enApplyId;
		uploader.option('server',url);
		uploader.upload();
		uploader.on( 'uploadSuccess', function( file ) {
			num  = num - 1;
		});
	}
	
	
	//附件上传功能:传入申请id作为参数
	function fileUpload(id){
		var v = $("#attach").val();
		if (v != "") {
			//设置屏蔽室申请ID
			$("#attach_enApplyId").val(id);
			var formData = new FormData($('#attach_form')[0]);
			$.ajax({
			       url: '${pageContext.request.contextPath}/enApplyInfo_saveEnAttach.do',
			       data: formData,
			       async: false,
			       contentType: false,
			       processData: false,
			       cache: false,
			       type: 'post',
			       success: function(data) {
			    	   alert("附件上传成功！");
			       },
			       error : function(){
			    	   alert("附件上传失败，请重试！");
			       }
			   });
		}
		
	}
	
	// 确认删除附件 
	function delAttachConf(enAttachId){
		var con = confirm("是否确认删除附件？");
		if (con == true) {
			delAttach(enAttachId);
		}
	}
	
	// 根据附件编号删除附件
	function delAttach(enAttachId){
		$.ajax({
			url : '${pageContext.request.contextPath}/enApplyInfo_delEnAttach.do',
			type : 'POST',
			data : {'enAttachId' : enAttachId},
			dataType : 'json',
			success : function (data){
				var data = eval(data);
				if (data.result == 'success'){
					// 清空
					$("#file").empty();
					// 加载上传附件
					loadFileinput();
				}
			},
			error : function (){
				alert("删除附件失败");
			}
		});
	}
	
	function loadFileinput(){
		var dom = '<form id="attach_form" enctype="multipart/form-data">';
  	 	dom = dom + '<input id="attach_enApplyId" name="enAttach.environmentApplyId" type="hidden"/>';
  	 	dom = dom + '<input name="enAttach.environmentAttachType" type="hidden" value="1"/>';
		dom = dom + '<input id="attach" name="attach" class="file" type="file" multiple data-min-file-count="1">';
		dom = dom + '</form>';
		$("#file").html(dom);
		loadStyle();
		isAttach = true;
	}
	
	//准备附件上传的样式
	function loadStyle(){
		$("#attach").fileinput({
			language : 'zh',
			showUpload : false, //是否显示上传按钮
			allowedFileExtensions : [ 'doc', 'docx' ]
		});
	}
	
	// 删除图片
	function delEnPic(enPicId){
		var con = confirm("确认删除该图片吗？");
		if (con == true) {
			$.ajax({
				url : '${pageContext.request.contextPath}/enApplyInfo_delEnPic.do',
				data : {'enPicId' : enPicId},
				type : 'POST',
				dataType : 'json',
				success : function (data){
					var data = eval(data);
					if (data.result == "success"){
						// 删除节点
						$("#"+enPicId).empty();
					} else {
						alert("删除图片失败！");
					}
				},
				error : function (){
					alert("删除图片失败！");
				}
			});
		}
	}	
</script>
</body>
</html>