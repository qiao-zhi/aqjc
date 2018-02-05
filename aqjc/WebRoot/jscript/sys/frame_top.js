function logout() {
	if(confirm("确认退出系统?")){
		top.location.href = "logout.do"
	}
}
$(function() {
	$("#topFrame_time").html(myTime()), $(
			".topFrame_icon_updataPassword,.topFrame_icon_exitlogin").hover(
			function() {
				$(this).css({
					textDecoration : "underline"
				})
			}, function() {
				$(this).css({
					textDecoration : "none"
				})
			})
}), myTime = function() {
	var a = new Date, b = a.getFullYear(), c = a.getMonth() + 1, d = a
			.getDate();
	return a = "\u4eca\u5929\u662f\uff1a" + b + "\u5e74" + c + "\u6708" + d
			+ "\u65e5&nbsp;" + "\u661f\u671f"
			+ "\u65e5\u4e00\u4e8c\u4e09\u56db\u4e94\u516d".charAt(a.getDay())
};