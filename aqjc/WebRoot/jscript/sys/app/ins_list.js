$(function(){
	$("#btn_add").click(function() {
		if (!validate($("#addDeviceInfoForm"))){
			var $mark = $("body>div").last();
			var _zIndex = $mark.css('zIndex');
			$mark.css({
				zIndex:9999
			});
			$.ajax({
				url : '${pageContext.request.contextPath}/ins_saveInstrument.do',
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
	$("#btn_update").click(function() {
		if (!validate($("#updateDeviceInfoForm"))){
			var $mark = $("body>div").last();
			var _zIndex = $mark.css('zIndex');
			$mark.css({
				zIndex:9999
			});
			$.ajax({
				url : '${pageContext.request.contextPath}/ins_saveInstrument.do',
				data : $("#updateDeviceInfoForm").serialize(),
				type : 'POST',
				dataType : 'json',
				success : function(data) {
					$mark.css('zIndex',_zIndex);
					if(data.success){
						alert(data.message);
						$('#device_grid').reload();// 表格重载
						$.dialog.get('idUpdate').close();
					}else{
						alert(data.message);
					}
				}
			});
		}
	});
});