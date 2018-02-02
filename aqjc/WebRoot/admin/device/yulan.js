function setImagePreview1(avalue) {
	var	docObj = document.getElementById(avalue);
	var	imgObjPreview = document.getElementById("preview"+avalue);
	var	localImagObj = document.getElementById("localImag"+avalue);
	if(docObj.files &&docObj.files[0]){
		//火狐下，直接设img属性
		imgObjPreview.style.display = 'block';
		imgObjPreview.style.width = '315px';
		imgObjPreview.style.height = '230px';
		//imgObjPreview.src = docObj.files[0].getAsDataURL();
		 
		//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
		imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
	}else{
		//IE下，使用滤镜
		docObj.select();
		var imgSrc = document.selection.createRange().text;
		alert(imgSrc);
		var localImagId = localImagObj;
		//必须设置初始大小
		localImagId.style.width = "315px";
		localImagId.style.height = "230px";
		//图片异常的捕捉，防止用户修改后缀来伪造图片
		try{
			localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
			localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
		}catch(e){
			alert("您上传的图片格式不正确，请重新选择!");
			return false;
		}
		imgObjPreview.style.display = 'none';
		document.selection.empty();
	}
	return true;
}

function setImagePreview2(avalue) {
	var	docObj=document.getElementById(avalue);
	var	imgObjPreview=document.getElementById("preview"+avalue);
	var	localImagObj = document.getElementById("localImag"+avalue);
	if(docObj.files &&docObj.files[0]){
		//火狐下，直接设img属性
		imgObjPreview.style.display = 'block';
		imgObjPreview.style.width = '656px';
		imgObjPreview.style.height = '230px';
		//imgObjPreview.src = docObj.files[0].getAsDataURL();
		 
		//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
		imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
	}else{
		//IE下，使用滤镜
		docObj.select();
		var imgSrc = document.selection.createRange().text;
		alert(imgSrc);
		var localImagId = localImagObj;
		//必须设置初始大小
		localImagId.style.width = "656px";
		localImagId.style.height = "230px";
		//图片异常的捕捉，防止用户修改后缀来伪造图片
		try{
			localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
			localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
		}catch(e){
			alert("您上传的图片格式不正确，请重新选择!");
			return false;
		}
		imgObjPreview.style.display = 'none';
		document.selection.empty();
	}
	return true;
}

function validatePic(flag){
	var filename = "";
	if(flag==1){
		filename = document.getElementById("headPortrait").value;
	}else{
		filename = document.getElementById("updheadPortrait").value;
	}
	if(filename!=""&filename!=null){
		var index1=filename.lastIndexOf(".");
		var index2=filename.length;
		var filetype=filename.substring(index1,index2);//后缀名
		if(filetype!=".bmp"&filetype!=".pcx"&filetype!=".tiff"&filetype!=".gif"&
			filetype!=".jpeg"&filetype!=".jpg"&filetype!=".png"){
			return 1;
		}else{
			return 2;
		}
	}else{
		return 3;
	}	
}

function addFile1(obj){
	setImagePreview1(Number($(obj).attr('id')));
	var wj_control=$("#picTab1 :file :last");
	if(Number($(obj).attr('id'))==Number(wj_control.attr('id'))){
		var id=Number(wj_control.attr('id'))+1;
		$("picTab-in-1").append("<span><a href='javascript:void(0)' onclick='del_file(this)'>(删除)</a></span>");
		$("#picTab1").append("<tr><td class='input-td'><table><tr><td><input id='"+id+"' name='testPic' type='file' onchange='addFile1(this)'/></td></tr><tr><td>图片名称： <input name='testPicName1' type='text' class='picName'/></td></tr></table>"+
				"<span><a href='javascript:void(0)' onclick='del_file(this)'>(删除)</a></span></td>"+
				"<td><div align='center' id='localImag"+id+"'><img id='preview"+id+"' src='../../uploads/image/noPic1.PNG' style='display: block; width: 315px; height: 230px;'></div>"+
				"</td></tr>");
	}	
}
function addFile2(obj){
	setImagePreview2(Number($(obj).attr('id')));
	var wj_control=$("#picTab2 :file :last");
	if(Number($(obj).attr('id'))==Number(wj_control.attr('id'))){
		var id=Number(wj_control.attr('id'))+1;
		$("#picTab2").append("<tr><td><div style='padding-top:15px;'><table><tr><td><input id='"+id+"' name='pinpuPic' type='file' onchange='addFile2(this)'/></td></tr><tr><td>图片名称：<input name='pintuPicName1' type='text' class='picName'/></td></tr></table>"+
				"<a href='javascript:void(0)' onclick='del_file(this)'>(删除)</a></div>"+
				"<div align='center' id='localImag"+id+"'><img id='preview"+id+"' src='../../uploads/image/noPic2.PNG' style='display: block; width: 656px; height: 230px;'></div>"+
				"</td></tr>");
	}
}
function del_file(obj){
	$(obj).parent().parent().parent().remove(); 
}