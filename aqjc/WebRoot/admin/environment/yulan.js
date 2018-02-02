function setImagePreview(avalue) {
	var docObj = document.getElementById(avalue);
	var imgObjPreview = document.getElementById("preview" + avalue);
	var localImagObj = document.getElementById("localImag" + avalue);
	if (docObj.files && docObj.files[0]) {
		// 火狐下，直接设img属性
		imgObjPreview.style.display = 'block';
		imgObjPreview.style.width = '320px';
		imgObjPreview.style.height = '230px';
		// imgObjPreview.src = docObj.files[0].getAsDataURL();

		// 火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
		imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
	} else {
		// IE下，使用滤镜
		docObj.select();
		var imgSrc = document.selection.createRange().text;
		alert(imgSrc);
		var localImagId = localImagObj;
		// 必须设置初始大小
		localImagId.style.width = "320px";
		localImagId.style.height = "230px";
		// 图片异常的捕捉，防止用户修改后缀来伪造图片
		try {
			localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
			localImagId.filters
					.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
		} catch (e) {
			alert("您上传的图片格式不正确，请重新选择!");
			return false;
		}
		imgObjPreview.style.display = 'none';
		document.selection.empty();
	}
	return true;
}
function validatePic(flag) {
	var filename =  document.getElementById("1").value;
	if (filename != "" & filename != null) {
		var index1 = filename.lastIndexOf(".");
		var index2 = filename.length;
		var filetype = filename.substring(index1, index2);// 后缀名
		if (filetype != ".bmp" & filetype != ".gif" & filetype != ".jpeg"
				& filetype != ".jpg" & filetype != ".png") {
			return 1;
		} else {
			return 2;
		}
	} else {
		return 3;
	}
}

function addFile(obj) {
	setImagePreview(Number($(obj).attr('id')));
}