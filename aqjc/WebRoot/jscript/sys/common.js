/**
 * 正在加载
 */
opts = {
		  lines: 20, // The number of lines to draw
		  length: 50, // The length of each line
		  width: 10, // The line thickness
		  radius: 35, // The radius of the inner circle
		  corners: 1, // Corner roundness (0..1)
		  rotate: 0, // The rotation offset
		  color: '#000', // #rgb or #rrggbb
		  speed: 1, // Rounds per second
		  trail: 60, // Afterglow percentage
		  shadow: false, // Whether to render a shadow
		  hwaccel: false, // Whether to use hardware acceleration
		  className: 'spinner', // The CSS class to assign to the spinner
		  zIndex: 2e9, // The z-index (defaults to 2000000000)
		  top: ($(window).height()-200)/2, // Top position relative to parent in px
		  left: ($(window).width()-200)/2 // Left position relative to parent in px
		};
/**
 * 根据字典上级编号和divId设置下拉框数据
 * @param divId
 * @param upId
 */
function dicSelect(divId,upId){
	$.ajax({
		url : '${pageContext.request.contextPath}/dicTool_showDicListByUp.do',
		data : {'upDicId':upId},
		type : 'POST',
		dataType : 'json',
		success : function(data) {
			var json = eval(data.root);
			$('#'+divId).empty().append("<option value=''>请选择</option>");
			for(var i=0;i<json.length;i++){
				if(json[i].isHaveChild=="1"){
					$('#'+divId).append("<optgroup label='"+json[i].dictionaryOptionName+"'></optgroup>");
					for(var n=0;n<json[i].childRoot.length;n++){
						$('#'+divId).append("<option value=\""+json[i].childRoot[n].dictionaryOptionId+"\">"+json[i].childRoot[n].dictionaryOptionName+"</option>");
					}
				}else{
					$('#'+divId).append("<option value=\""+json[i].dictionaryOptionId+"\">"+json[i].dictionaryOptionName+"</option>");
				}
			}
		}
	});
};

/**
 * 根据字典上级编号和divId设置下拉框数据
 * 如：dicSelectArray([{"id":"addpolitics"},{"id":"updatepolitics"},{"id":"politics","sel":0}],DIC_CODE.politics);
 * sel{0:无“请选择”}
 * @param divId
 * @param upId
 */
function dicSelectArray(divId,upId){
	$.ajax({
		url : '${pageContext.request.contextPath}/dicTool_showDicListByUp.do',
		data : {'upDicId':upId},
		type : 'POST',
		dataType : 'json',
		success : function(data) {
			var json = eval(data.root);
			for(var j=0;j<divId.length;j++){
				if(divId[j].sel==0)
					$('#'+divId[j].id).empty();
				else
					$('#'+divId[j].id).empty().append("<option value=''>请选择</option>");
					
				for(var i=0;i<json.length;i++){
					if(json[i].isHaveChild=="1"){
						$('#'+divId[j].id).append("<optgroup label='"+json[i].dictionaryOptionName+"'></optgroup>");
						for(var n=0;n<json[i].childRoot.length;n++){
							$('#'+divId[j].id).append("<option value=\""+json[i].childRoot[n].dictionaryOptionId+"\">"+json[i].childRoot[n].dictionaryOptionName+"</option>");
						}
					}else{
						$('#'+divId[j].id).append("<option value=\""+json[i].dictionaryOptionId+"\">"+json[i].dictionaryOptionName+"</option>");
					}
				}
			};
		}
	});
};
/**
 * 显示企业列表
 */
function showEnterpeise(divId,value){
	$.ajax({
		url : '${pageContext.request.contextPath}/hazard_showEnterpeiseListNoPage.do',
		data : {},
		type : 'POST',
		dataType : 'json',
		success : function(data) {
			var json = eval(data.rows);
			for(var n=0;n<divId.length;n++){
				$('#'+divId[n]).empty();
				for(var i=0;i<json.length;i++){
					$('#'+divId[n]).append("<option value=\""+json[i].enterpeiseId+"\">"+json[i].name+"</option>");
				}				
			}
		}
	});
};
/**
 * 显示企业列表
 */
function showEnterpeiseSel(divId,value){
	$.ajax({
		url : '${pageContext.request.contextPath}/hazard_showEnterpeiseListNoPage.do',
		data : {},
		type : 'POST',
		dataType : 'json',
		success : function(data) {
			var json = eval(data.rows);
			for(var n=0;n<divId.length;n++){
				$('#'+divId[n]).empty().append("<option value=''>请选择</option>");;
				for(var i=0;i<json.length;i++){
					$('#'+divId[n]).append("<option value=\""+json[i].enterpeiseId+"\">"+json[i].name+"</option>");
				}				
			}
		}
	});
};
function showDevice(divId,value){
	$.ajax({
		url : '${pageContext.request.contextPath}/video_showVideoDeviceListNoPage.do',
		data : {},
		type : 'POST',
		dataType : 'json',
		success : function(data) {
			var json = eval(data.rows);
			for(var n=0;n<divId.length;n++){
				$('#'+divId[n]).empty().append("<option value=''>请选择</option>");
				for(var i=0;i<json.length;i++){
					$('#'+divId[n]).append("<option value=\""+json[i].deviceId+"\">"+json[i].factory+"-"+json[i].model+"</option>");
				}
			}
		}
	});
};
//修正FckEditor错误
var __fckEditorInstance_ = new Array();// 用来储存FCKeditor Instance的阵列

function FCKeditor_OnComplete(editorInstance) {
	__fckEditorInstance_[editorInstance.Name] = editorInstance;
}

function getFckInst(idname) {
	return __fckEditorInstance_[idname];
}
// 设置编辑器中内容
function SetEditorContents(EditorName, ContentStr) {
	//var oEditor = getFckInst(EditorName);
	var oEditor = FCKeditorAPI.GetInstance(EditorName);
	oEditor.SetHTML(ContentStr);
}

//获取编辑器中内容
function GetEditorContents(EditorName) {
	var oEditor = FCKeditorAPI.GetInstance(EditorName);
	return(oEditor.GetXHTML(true));
}
function stopSpin(){
	spinner.spin(false);
};
function enabledUI(btnadd, id, message) {
	var coutent = message;
	show(id, coutent);// 让程序自动启用自定义的div层遮罩button按钮
	if (document.getElementById(btnadd).count > 0) {
		return false;
	}
	document.getElementById(btnadd).count++;
	return true;
}  

function enabledUI1(btnadd, id, message) {
	var coutent = message;
	show(id, coutent);// 让程序自动启用自定义的div层遮罩button按钮
}  

/*********************
* 方法描述：显示一个模式层加载到页面之上。
* 参数描述：elementId：元素ID
            strMessage:提示信息
* 创建信息：薛瑞  09-12-24 创建 
**********************/
function show(elementId,strMessage){

   var msgw,msgh,bordercolor;  
   msgw=200;//提示窗口的宽度
   msgh=100;//提示窗口的高度
   
   titleheight=25 //提示窗口标题高度
   bordercolor="#336699";//提示窗口的边框颜色
   titlecolor="#99CCFF";//提示窗口的标题颜色

   var sWidth,sHeight;
   
   var WAH =document.getElementById(elementId);
   sWidth=WAH.offsetWidth;
   sHeight=WAH.offsetHeight;
   var element = getElementPos(elementId);
   
   //背景层（大小与窗口有效区域相同，即当弹出对话框时，背景显示为放射状透明灰色）
   var bgObj=document.createElement("div");//创建一个div对象（背景层）
   //定义div属性，即相当于
   //<div id="bgDiv" style="position:absolute; top:0; background-color:#777; filter:progid:DXImagesTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75); opacity:0.6; left:0; width:918px; height:768px; z-index:10000;"></div>
   bgObj.setAttribute('id','bgDiv');
   bgObj.setAttribute("align","center");
   bgObj.style.position="absolute";
   bgObj.style.top=element.y;
   bgObj.style.left=element.x;
   bgObj.style.background="palegoldenrod";
   bgObj.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=0,opacity=80)";//,finishOpacity=75
   bgObj.style.opacity="0.4";
   bgObj.style.width=sWidth + "px";
   bgObj.style.height=sHeight + "px";
   bgObj.style.zIndex = "10000";
   bgObj.style.border="1px";
   bgObj.style.borderstyle="solid";

   var msgObj=document.createElement("div")//创建一个div对象（提示框层）
   //定义div属性，即相当于
   //<div id="msgDiv" align="center" style="background-color:white; border:1px solid #336699; position:absolute; left:50%; top:50%; font:12px/1.6em Verdana,Geneva,Arial,Helvetica,sans-serif; margin-left:-225px; margin-top:npx; width:400px; height:100px; text-align:center; line-height:25px; z-index:100001;"></div>
   msgObj.setAttribute("id","msgDiv");
   msgObj.setAttribute("align","center");
   msgObj.style.background="white";
   msgObj.style.border="1px solid " + bordercolor;
   msgObj.style.position = "absolute";
   msgObj.style.left = element.x+(sWidth/2)-110+"px";
   msgObj.style.top = element.y+(sHeight/2)+"px";
   msgObj.style.font="12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
//   msgObj.style.marginLeft = "-225px" ;
//   msgObj.style.marginTop = -75+document.documentElement.scrollTop+"px";
   //msgObj.style.width = sWidth/3 + "px";
   msgObj.style.height ='20px';//sHeight/3 + "px";
   msgObj.style.textAlign = "center";
   msgObj.style.lineHeight ="17px";
   msgObj.style.zIndex = "10001";


  
  //margin-top: 0px; margin-bottom: 0px; padding-bottom: 0px; padding-top: 0px;
    var txt=document.createElement("table");
    txt.setAttribute("id","strTable");
    //txt.setAttribute("valign","middle");
    var tr=txt.insertRow(-1);
    var td=tr.insertCell(-1);
    td.setAttribute("valign","middle");
    td.style.margintop=0;
    td.style.marginbottom=0;
    td.style.paddingbottom=0;
    td.style.paddingtop=0;
    td.style.color="red";
    td.innerHTML="<img src='../../../yjpt/style/images/tqimgs/loading.gif' align='absmiddle' />&nbsp;&nbsp;"+strMessage;

   //页面加载
   document.body.appendChild(bgObj);//在body内添加该div对象
   document.body.appendChild(msgObj);//在body内添加提示框div对象msgObj
   
   //document.getElementById("msgDiv").appendChild(title);//在提示框div中添加标题栏对象title
   document.getElementById("msgDiv").appendChild(txt);//在提示框div中添加提示信息对象txt
   //document.getElementById("bgDiv").innerHTML=tableStr;
   document.body.focus();
}

function dialogClose()
{
    if(document.getElementById('msgDiv')){
    document.body.removeChild(document.getElementById('msgDiv'));}
    if(document.getElementById('bgDiv')){
    document.body.removeChild(document.getElementById('bgDiv'));}
}


/*********************
* 方法描述：获得元素的X、Y轴的座标
* 创建信息：薛瑞  09-12-24 创建 
**********************/
function getElementPos(elementId) {
var ua = navigator.userAgent.toLowerCase();
var isOpera = (ua.indexOf('opera') != -1);
var isIE = (ua.indexOf('msie') != -1 && !isOpera); // not opera spoof
var el = document.getElementById(elementId);
if(el.parentNode === null || el.style.display == 'none') {
   return false;
}      
var parent = null;
var pos = [];     
var box;     
if(el.getBoundingClientRect)    //IE
{         
   box = el.getBoundingClientRect();
   var scrollTop = Math.max(document.documentElement.scrollTop, document.body.scrollTop);
   var scrollLeft = Math.max(document.documentElement.scrollLeft, document.body.scrollLeft);
   return {x:box.left + scrollLeft, y:box.top + scrollTop};
}else if(document.getBoxObjectFor)    // gecko    
{
   box = document.getBoxObjectFor(el); 
   var borderLeft = (el.style.borderLeftWidth)?parseInt(el.style.borderLeftWidth):0; 
   var borderTop = (el.style.borderTopWidth)?parseInt(el.style.borderTopWidth):0; 
   pos = [box.x - borderLeft, box.y - borderTop];
} else    // safari & opera    
{
   pos = [el.offsetLeft, el.offsetTop]; 
   parent = el.offsetParent;     
   if (parent != el) { 
    while (parent) { 
   pos[0] += parent.offsetLeft; 
   pos[1] += parent.offsetTop; 
   parent = parent.offsetParent;
    } 
   }   
   if (ua.indexOf('opera') != -1 || ( ua.indexOf('safari') != -1 && el.style.position == 'absolute' )) { 
    pos[0] -= document.body.offsetLeft;
    pos[1] -= document.body.offsetTop;         
   }    
}              
if (el.parentNode) { 
   parent = el.parentNode;
    } else {
   parent = null;
    }
while (parent && parent.tagName != 'BODY' && parent.tagName != 'HTML') { // account for any scrolled ancestors
   pos[0] -= parent.scrollLeft;
   pos[1] -= parent.scrollTop;
   if (parent.parentNode) {
    parent = parent.parentNode;
   } else {
    parent = null;
   }
}
return {x:pos[0], y:pos[1]};
}



function getStyle(elem , type){
    var typeface = '';
    if(elem.currentStyle)
        typeface = elem.currentStyle[type];
    else if(window.getComputedStyle)
        typeface = window.getComputedStyle(elem , null)[type];
    return typeface;        
}