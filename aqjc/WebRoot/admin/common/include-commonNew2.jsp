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

<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/style/css/sys/navCommon.css" />
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/controls/jquery-artDialog/default.css" />
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/controls/flexigrid/css/flexigrid/flexigrid.css" />
<!-- 
<script src="<%=request.getContextPath() %>/newStyle/plugins/jQuery/jQuery-1.8.3.min.js"></script>
 -->
<script src="<%=request.getContextPath() %>/newStyle/plugins/jQuery/jQuery-2.1.4.min.js"></script>

<script src="<%=request.getContextPath()%>/jscript/sys/trim.js"></script>
<script src="<%=request.getContextPath()%>/jscript/final_dic.js"></script>
<script src="<%=request.getContextPath()%>/controls/flexigrid/jqDnR.js"></script>
<script src="<%=request.getContextPath()%>/controls/flexigrid/jqModal.js"></script>
<script src="<%=request.getContextPath()%>/jscript/sys/common.js"></script>
<script src="<%=request.getContextPath()%>/controls/flexigrid/flexigrid.js"></script>
<script src="<%=request.getContextPath()%>/controls/easyvalidator/js/easy_validator.pack.js"></script>
<script src="<%=request.getContextPath()%>/controls/easyvalidator/js/jquery.bgiframe.min.js"></script>
<script src="<%=request.getContextPath()%>/controls/jquery-artDialog/jquery.artDialog.js"></script>
<script src="<%=request.getContextPath() %>/controls/JCalendar/WdatePicker.js"></script>

<!--
<script src="<%=request.getContextPath() %>/newStyle/plugins/jQuery/jQuery-1.8.3.min.js"></script>
<script src="<%=request.getContextPath() %>/newStyle/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/newStyle/dist/js/app.min.js"></script>
<script src="<%=request.getContextPath() %>/newStyle/dist/js/demo.js"></script>
<script src="<%=request.getContextPath() %>/newStyle/plugins/iCheck/icheck.min.js"></script>
<script src="<%=request.getContextPath() %>/newStyle/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
-->
<!--
<script>
  $(function () {
    //bootstrap WYSIHTML5 - text editor
    $(".textarea").wysihtml5();
    //Enable iCheck plugin for checkboxes
    //iCheck for checkbox and radio inputs
    $('input[type="checkbox"]').iCheck({
      checkboxClass: 'icheckbox_flat-blue',
      radioClass: 'iradio_flat-blue'
    });

    //Enable check and uncheck all functionality
    $(".checkbox-toggle").click(function () {
      var clicks = $(this).data('clicks');
      if (clicks) {
        //Uncheck all checkboxes
        $("input[type='checkbox']").iCheck("uncheck");
        $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
      } else {
        //Check all checkboxes
        $("input[type='checkbox']").iCheck("check");
        $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
      }
      $(this).data("clicks", !clicks);
    });

    //Handle starring for glyphicon and font awesome
    $(".mailbox-star").click(function (e) {
      e.preventDefault();
      //detect type
      var $this = $(this).find("a > i");
      var glyph = $this.hasClass("glyphicon");
      var fa = $this.hasClass("fa");

      //Switch states
      if (glyph) {
        $this.toggleClass("glyphicon-star");
        $this.toggleClass("glyphicon-star-empty");
      }

      if (fa) {
        $this.toggleClass("fa-star");
        $this.toggleClass("fa-star-o");
      }
    });
  });
</script>-->