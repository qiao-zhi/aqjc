<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.tyust.bean.user.TBaseUserInfo" %>
<%@ page import="org.springframework.context.ApplicationContext,org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.tyust.dao.unit.IunitDao,com.tyust.bean.unit.TBaseUnitInfo"%>
<%
	TBaseUserInfo user = (TBaseUserInfo) request.getSession().getAttribute("user");
	ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
	String unitId = user.getUnitId();
	IunitDao unitDao = (IunitDao)context.getBean("Unit");
	TBaseUnitInfo unit = unitDao.findUnit(unitId);
%>
<!DOCTYPE html>
<html>
<head>
	<title>屏蔽室申请</title>
	<jsp:include page="../common/include-commonNew.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/webuploader/css/webuploader.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/webuploader/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/newStyle/plugins/lightbox/css/lightbox.min.css" />	
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
            <h3 class="box-title">屏蔽室检测申请</h3>
          </div><!-- /.box-header -->

          <div class="box-body pad">
            <div class="row">
              <div class="col-md-8 col-md-offset-2">
              
            <div class="box box-info">
             <div class="box-header with-border">
                <h3 class="box-title">基本信息</h3>
             </div>
            <div class="box-body">
            <div class="row">
              <div class="col-sm-6">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">申请单位</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" readonly="readonly" value="<%=unit.getUnitName() %>">
                    </div>
                  </div>
                </form>
              </div>
              <div class="col-sm-6">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">申请日期</label>
                    <div class="col-sm-8">
                      <input id="dveNum" type="text" class="form-control" readonly="readonly" value="2014-11-1">
                    </div>
                  </div>
                </form>
              </div>
            </div>

             <div class="row">
              <div class="col-sm-6">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">申请人</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" readonly="readonly" value="<%=user.getName() %>">
                    </div>
                  </div>
                </form>
              </div>
              <div class="col-sm-6">
                <form class="form-horizontal">
                  <div class="form-group">
                    <label for="input1" class="col-sm-4 control-label">联系方式</label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control" readonly="readonly" value="<%=user.getTelephone() %>">
                    </div>
                  </div>
                </form>
              </div>
            </div>
            </div>
            </div>
            
            <div class="box box-info">
              <div class="box-header with-border">
                <h3 class="box-title">申请书扫描照片</h3>
              </div>
              <div class="box-body">
         <div id="container">
            <!--头部，相册选择和格式选择-->

            <div class="row">
            	<div class="col-sm-4">
            		<a href="../../uploads/pbsPic/example.png" data-lightbox="1"><img width="210px" height="290px" src="../../uploads/pbsPic/example.png"></a>
            	</div>
            	<div class="col-sm-4">
            		<a href="../../uploads/pbsPic/example.png" data-lightbox="1"><img width="210px" height="290px" src="../../uploads/pbsPic/example.png"></a>
            	</div>
            	<div class="col-sm-4">
            		<a href="../../uploads/pbsPic/example.png" data-lightbox="1"><img width="210px" height="290px" src="../../uploads/pbsPic/example.png"></a>
            	</div>
            </div>
        </div>
              
              </div>
            </div>
            
            </div>
           </div>   
          </div><!-- /.box-body -->
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
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/dist/webuploader.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/webuploader/upload.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/newStyle/plugins/lightbox/js/lightbox-plus-jquery.min.js"></script>

</body>
</html>