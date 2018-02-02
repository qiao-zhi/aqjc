$(function(){
	$("#btn_add_device").click(function() {
		if (!validate($("#addDeviceInfoForm"))){
			var $mark = $("body>div").last();
			var _zIndex = $mark.css('zIndex');
			$mark.css({
				zIndex:9999
			});
			$.ajax({
				url : '${pageContext.request.contextPath}/test_saveDeviceInfo.do',
				data : $("#addDeviceInfoForm").serialize(),
				type : 'POST',
				dataType : 'json',
				async:false,
				success : function(data) {
					$mark.css('zIndex',_zIndex);
					if(data.success){
						alert(data.message);
						$('#device_grid').reload();// 表格重载
						$.dialog.get('idAdd').close();
				      //情空form表单
				        $("#addDeviceInfoForm input").each(function(i){
				    		$(this).val('');
				    	 });
					}else{
						alert(data.message);
					}
				}
			});
		}
	});
	$("#btn_update_device").click(function() {
		if (!validate($("#updateDeviceInfoForm"))){
			var $mark = $("body>div").last();
			var _zIndex = $mark.css('zIndex');
			$mark.css({
				zIndex:9999
			});
			$.ajax({
				url : '${pageContext.request.contextPath}/test_saveDeviceInfo.do',
				data : $("#updateDeviceInfoForm").serialize(),
				type : 'POST',
				dataType : 'json',
				success : function(data) {
					$mark.css('zIndex',_zIndex);
					//刷新列表
					$('#device_grid').reload();// 表格重载
					$.dialog.get('idUpdate').close();
				}
			});
		}
	});
});