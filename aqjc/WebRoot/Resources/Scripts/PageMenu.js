var GetParameter = function() {
    var map = new Array();
    var tgs = document.getElementsByTagName('script');
    if (tgs.length <= 0) { return null; }
    var src = tgs.item(tgs.length - 1).src;
    var pos = src.indexOf('?');
    if (-1 == pos) { return null; }
    var paras = src.substring(pos + 1);
    paras = paras.split('&');
    for (var n = 0; n < paras.length; n++) {
        _ParseParameter(map, paras[n]);
    }
    return map;
};

var _ParseParameter = function(map, para) {
    var pos = para.indexOf('=');
    var key = para.substring(0, pos);
    var value = para.substring(pos + 1);
    map[key] = value;
};

var paras = GetParameter();
var paraValue = -1;
if (paras != null)
 paraValue = paras['Type'];

document.write('<div id="divmenu"><div id="menu"><ul>');

var nav = dynamsoft.onlineNavInfo;
var _bPluginEdition = false;
if (nav.bChrome || nav.bFirefox) {
	if(nav.mainVer < 27){
		_bPluginEdition = true;
	}
} 
else if(nav.bIE)
{
	if(nav.mainVer < 10){
		_bPluginEdition = true;
	}
}

if (nav.bWin && !_bPluginEdition && !nav.bSafari)
{
    if (paraValue == 0)
        document.write('<li class="D_menu_item_select" style="width:25%"><a href="online_demo_scan.aspx">Document Scanning</a></li>');
    else
        document.write('<li class="D_menu_item" style="width:25%"><a href="online_demo_scan.aspx">Document Scanning</a></li>');
        
    if(paraValue == 1)
        document.write('<li class="D_menu_item_select" style="width:25%"><a href="online_demo_scan_Webcam.aspx">Webcam Capture</a></li>');
    else
        document.write('<li class="D_menu_item" style="width:25%"><a href="online_demo_scan_Webcam.aspx">Webcam Capture</a></li>');
      
    if(paraValue == 2)  
        document.write('<li class="D_menu_item_select" style="width:25%"><a href="online_demo_scan_Barcode.aspx">Read Barcode</a></li>');
    else
        document.write('<li class="D_menu_item" style="width:25%"><a href="online_demo_scan_Barcode.aspx">Read Barcode</a></li>');

    document.write('<li class="D_menu_item" style="width:25%" title="Includes Source Code of Current Page"><a target="_blank" href="http://demo.dynamsoft.com/OCR/OCRProServerSide.aspx">OCR Professional</a></li></ul></div></div>');
}
else
{
    if (paraValue == 0)
        document.write('<li class="D_menu_item_select" style="width:50%"><a href="online_demo_scan.aspx">Document Scanning</a></li>');
    else
        document.write('<li class="D_menu_item" style="width:50%"><a href="online_demo_scan.aspx">Document Scanning</a></li>');

    document.write('<li class="D_menu_item" style="width:50%" title="Includes Source Code of Current Page"><a target="_blank" href="http://demo.dynamsoft.com/OCR/OCRProServerSide.aspx">OCR Professional</a></li></ul></div></div>');
}
