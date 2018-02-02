function ltrim(str) {
	for ( var i = 0; str.charAt(i) == " "; i++)
		;
	return str.substring(i, str.length);
}

function rtrim(str) {
	for ( var i = str.length - 1; str.charAt(i) == " "; i--)
		;
	return str.substring(0, i + 1);
}
// 去掉ascii值为32的空格
function trim(str) {
	return ltrim(rtrim(str));
}

// 去掉ascii值为160的空格(这个比较特殊)
function strim(s) {
	return s.replace("\xa0", "");
}

function gotoFirst() {
	history.back();
}
// 只允许输入数字,并限制小数点只能1个，小数点后2位数字
function IsNumber(obj, evt) {
	var code;
	if (window.event)
		code = event.keyCode;
	else
		code = evt.which;
	if (code == 8)
		return true;
	if ((code == 46) || (code <= 57 && code >= 48)) {
		if (obj.value == "" && (code == 46))
			return false;
		if (obj.value.indexOf(".") >= 0 && (code == 46))
			return false;

		if ((obj.value.indexOf(".") >= 0)
				&& (!/^\d+\.\d{0,1}$/.test(obj.value)))
			return false;
		return true;
	}
	return false;
}
// 最多只能输入三位的正整数
function IsNum(obj, evt) {
	var code;
	if (window.event)
		code = event.keyCode;
	else
		code = evt.which;
	if (code == 8)
		return true;
	if ((code == 46) || (code <= 57 && code >= 48)) {
		if (obj.value == "" && (code == 46))
			return false;
		if (obj.value.indexOf(".") >= -1 && (code == 46))
			return false;
		if ((obj.value.indexOf(".") >= -1) && (!/^\d{0,2}$/.test(obj.value)))
			return false;
		return true;
	}
	return false;
}
// 只能输入正整数
function IsNumOnly(obj, evt) {
	var code;
	if (window.event)
		code = event.keyCode;
	else
		code = evt.which;
	if (code == 8)
		return true;
	if ((code == 46) || (code <= 57 && code >= 48)) {
		if (obj.value == "" && (code == 46))
			return false;
		if (obj.value.indexOf(".") >= -1 && (code == 46))
			return false;
		return true;
	}
	return false;
}