$(function(){
	$("#btn_add_device_test").click(function() {
		if (!validate($("#addDeviceTestForm"))){
			var $mark = $("body>div").last();
			var _zIndex = $mark.css('zIndex');
			$mark.css({
				zIndex:9999
			});
			$.ajax({
				url : '${pageContext.request.contextPath}/test_saveDeviceTest.do?type=save',
				data : $("#addDeviceTestForm").serialize(),
				type : 'POST',
				dataType : 'json',
				async:false,
				success : function(data) {
					$mark.css('zIndex',_zIndex);
					if(data.success){
						alert(data.message);
						$('#device_test_grid').reload();// 表格重载
						$.dialog.get('idAdd').close();
				      //情空form表单
				        $("#addDeviceTestForm input").each(function(i){
				    		$(this).val('');
				    	 });
					}else{
						alert(data.message);
					}
				}
			});
		}
	});
	$("#btn_add_submit_device_test").click(function() {
		if (!validate($("#addDeviceTestForm"))){
			var $mark = $("body>div").last();
			var _zIndex = $mark.css('zIndex');
			$mark.css({
				zIndex:9999
			});
			$.ajax({
				url : '${pageContext.request.contextPath}/test_saveDeviceTest.do?type=submit',
				data : $("#addDeviceTestForm").serialize(),
				type : 'POST',
				dataType : 'json',
				async:false,
				success : function(data) {
					$mark.css('zIndex',_zIndex);
					if(data.success){
						alert(data.message);
						$('#device_test_grid').reload();// 表格重载
						$.dialog.get('idAdd').close();
				      //情空form表单
				        $("#addDeviceTestForm input").each(function(i){
				    		$(this).val('');
				    	 });
					}else{
						alert(data.message);
					}
				}
			});
		}
	});
	$("#btn_update_device_test").click(function() {
		if (!validate($("#updateDeviceTestForm"))){
			var $mark = $("body>div").last();
			var _zIndex = $mark.css('zIndex');
			$mark.css({
				zIndex:9999
			});
			$.ajax({
				url : '${pageContext.request.contextPath}/test_saveDeviceTest.do?type=save',
				data : $("#updateDeviceTestForm").serialize(),
				type : 'POST',
				dataType : 'json',
				success : function(data) {
					$mark.css('zIndex',_zIndex);
					//刷新列表
					$('#device_test_grid').reload();// 表格重载
					$.dialog.get('idUpdate').close();
				}
			});
		}
	});
	$("#btn_update_submit_device_test").click(function() {
		if (!validate($("#updateDeviceTestForm"))){
			var $mark = $("body>div").last();
			var _zIndex = $mark.css('zIndex');
			$mark.css({
				zIndex:9999
			});
			$.ajax({
				url : '${pageContext.request.contextPath}/test_saveDeviceTest.do?type=submit',
				data : $("#updateDeviceTestForm").serialize(),
				type : 'POST',
				dataType : 'json',
				success : function(data) {
					$mark.css('zIndex',_zIndex);
					//刷新列表
					$('#device_test_grid').reload();// 表格重载
					$.dialog.get('idUpdate').close();
				}
			});
		}
	});
});