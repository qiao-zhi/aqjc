$(init);

function init(){
	var simpleTreeCollection = $('.simpleTree').simpleTree({
		nodeCheckBox : false //启用多选框
		,ckFlag : "ww" //重写标记属性    默认ck
		,allCheckFlag  : 'aa'    //全选 默认a
		,halfCheckFlag : 'hh'    //半选 默认h
		,noCheckFlag   : 'nn'    //没选 默认n
		//,checkBoxClick : false   //多选框事件重写接口 (默认为当前正常的状态)
		,animate : true 
	});
}