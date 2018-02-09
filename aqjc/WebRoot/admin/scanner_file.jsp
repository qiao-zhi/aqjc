<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>扫描仪</title>
<meta http-equiv="Content-type" content="text/html;charset=UTF-8" />
<meta http-equiv="Content-Language" content="en-us"/>
<meta http-equiv="X-UA-Compatible" content="requiresActiveX=true" />
<meta name="viewport" content="width=device-width, maximum-scale=1.0" />
<link href="<%=request.getContextPath() %>/Resources/Styles/style.css" type="text/css" rel="stylesheet" />
<script src="<%=request.getContextPath() %>/Resources/Scripts/common.js?t=170607"></script>
<script>
	var urlPath = '${pageContext.request.contextPath}';	
    if (dynamsoft.onlineNavInfo.deviceType == 'pc') {

    } else {

        var accept = confirm("Sorry, the demo is designed for web browsers on Windows PC or macOS only.\n\nYou are using a mobile device, would you like to visit our mobile camera web demo instead?");
	    if (accept) {
          window.location.replace("https://demo.dynamsoft.com/m/mobile-camera-web-capture.aspx");
        } else{/**/}
    }
    
</script>
<script type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</script>

</head>

<style>
	.btnOrg,#btnScan{
		background-color:#00acd6; 	
		border-color:#269abc
	}
	.btnOrg:link, .btnOrg:visited { color: #00acd6; }
	.btnOrg:hover { background: #00acd6; }
	.btnOrg:active { background: #00acd6; }	
	#btnCancelChange{
		 margin-top: 15px;
	    margin-left:  20px;
	    font-size: 15px;
	}
	#btnChangeImageSizeOK{
		 margin-left: 50px;
    	 font-size: 15px;
	}
</style>
<body onpageshow="if (event.persisted) noBack();">
<div id="wrapper">
    <div class="DWTHeader">         
       <!--  <script src="<%=request.getContextPath() %>/Resources/Scripts/PageMenu.js?Type=0"></script> -->
        <!-- 页面菜单 -->
			<div id="divmenu" style="text-align:right">
				<div id="menu" style="text-align:center;">
					<ul>
						<li class="D_menu_item_select" style="width: 100%"><a
							href="javaScript:void(0);" style="cursor: none;">文档扫描</a></li>						
					</ul>
					<!-- <span style="display:block;margin-top:5px;font-size:18px">文档扫描</span> -->					
				</div>
				<!-- 返回按钮 -->
				<!-- <button type="button" class='btnOrg' onclick="javascript:history.back(-1);" style="margin-top: 10px;">返回</button> -->
			</div>
		<!-- 结束菜单 -->
		</div>
    <div id="DWTcontainer" class="container" style="padding-top: 20px;">
        <div id="DWTcontainerTop">
           <div id ="divEdit" class="divinput">
               <ul>                   
                    <li><img src="<%=request.getContextPath() %>/Resources/Images/RotateLeft.png" title="向左旋转" alt="Rotate Left" id="btnRotateL"  onclick="btnRotateLeft_onclick()"/> </li>
                    <li><img src="<%=request.getContextPath() %>/Resources/Images/RotateRight.png" title="向右旋转" alt="Rotate Right" id="btnRotateR"  onclick="btnRotateRight_onclick()"/> </li>
                    <li><img src="<%=request.getContextPath() %>/Resources/Images/Rotate180.png" alt="Rotate 180" title="旋转180" onclick="btnRotate180_onclick()" /> </li>
                    <li><img src="<%=request.getContextPath() %>/Resources/Images/Mirror.png" title="左右镜像" alt="Mirror" id="btnMirror"  onclick="btnMirror_onclick()"/> </li>
                    <li><img src="<%=request.getContextPath() %>/Resources/Images/Flip.png" title="上下镜像" alt="Flip" id="btnFlip" onclick="btnFlip_onclick()"/> </li>
                    <li><img src="<%=request.getContextPath() %>/Resources/Images/RemoveSelectedImages.png" title="删除当前图片" alt="Remove Selected Images" id="DW_btnRemoveCurrentImage" onclick="btnRemoveCurrentImage_onclick();"/></li>
                    <li><img src="<%=request.getContextPath() %>/Resources/Images/RemoveAllImages.png" title="删除所有图片" alt="删除所有图片" id="DW_btnRemoveAllImages" onclick="btnRemoveAllImages_onclick();"/></li>
                    <li style="height:57px;"><img src="<%=request.getContextPath() %>/Resources/Images/ChangeSize.png" title="改变图片大小" alt="Change Image Size" id="btnChangeImageSize" onclick="btnChangeImageSize_onclick();"/> </li>
                    <li> <img src="<%=request.getContextPath() %>/Resources/Images/Crop.png" title="裁剪" alt="Crop" id="btnCrop" onclick="btnCrop_onclick();"/></li>
                </ul>
            </div>
            <div id="dwtcontrolContainer"></div>
            <div id="btnGroupBtm" class="clearfix"></div>
        </div>
        <div id="ScanWrapper">
            <div id="divScanner" class="divinput">
                <ul class="PCollapse">
                    <li>
                        <div class="divType">
                            <div class="mark_arrow expanded"></div>
                           	自定义扫描</div>
                        <div id="div_ScanImage" class="divTableStyle">
                            <ul id="ulScaneImageHIDE" >
                                <li>
                                    <label for="source">
                                    <p>选择设备:</p>
                                    </label>
                                    <select size="1" id="source" style="position:relative;" onchange="source_onchange()">
                                        <option value = ""></option>
                                    </select>
                                </li>
                                <li style="display:none;" id="pNoScanner"> <a href="javascript: void(0)" class="ShowtblLoadImage" style="position:relative;color:red" id="aNoScanner"><b>(No TWAIN compatible drivers detected)</b></a></li>
                                <li id="divProductDetail"></li>
                                <li class="tc">
                                    <input id="btnScan" disabled="disabled" type="button" value="扫描" onclick ="acquireImage();"/>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <div class="divType">
                            <div class="mark_arrow collapsed"></div>
                           	 上传图片或PDF文件</div>
                        <div id="div_LoadLocalImage" style="display: none" class="divTableStyle">
                            <ul>
                                <li class="tc">
                                    <input class="btnOrg" type="button" value="上传" onclick="return btnLoadImagesOrPDFs_onclick()" />
                                </li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
            <div id="tblLoadImage" style="visibility:hidden; height:125px">
                <ul>
                    <li><b>You can:</b><a href="javascript: void(0)" style="text-decoration:none; padding-left:185px" class="ClosetblLoadImage">X</a></li>
                </ul>
                <div id="notformac1" style="background-color:#f0f0f0; padding:5px;">
                    <ul>
                        <li><img alt="arrow" src="<%=request.getContextPath() %>/Resources/Images/arrow.gif" width="9" height="12"/><b>Install a Virtual Scanner:</b></li>
                        <li style="text-align:center;"><a id="samplesource32bit" href="http://demo.dynamsoft.com/DWT/Sources/twainds.win32.installer.2.1.3.msi">32-bit Sample Source</a> <a id="samplesource64bit" style="display:none;" href="http://demo.dynamsoft.com/DWT/Sources/twainds.win64.installer.2.1.3.msi">64-bit Sample Source</a> from <a target="_blank" href="http://www.twain.org">TWG</a></li>
                    </ul>
                </div>
            </div>
            <div id="divUpload" class="divinput mt30" style="position:relative">
                <ul>
                    <li class="toggle">保存扫描文件</li>
                    <li>
                        <label for="txt_fileName">
                        <p>文件名称:</p>
                        </label>
                        <label>
                        <input type="text" size="20" id="txt_fileName1"/>      
                        </label>                  
                    </li>                                       
                    <li style="display:none">   
                    	 <label for="imgTypepdf">
                            <input type="radio" style="display:none" value="pdf" name="ImageType" id="imgTypepdf" checked onclick ="rdPDF_onclick();"/>
                           </label>                   
                        <label for="MultiPagePDF">
                            <input type="checkbox" id="MultiPagePDF" style="display:none" checked/>
                           </label>
                    </li>
                    <li class="tc">
                        <input id="btnSave" class="btnOrg" type="button" value="保存" onclick ="saveUploadImage('local')"/>
                        <!-- <input id="btnUpload" class="btnOrg" type="button" value="Upload to Server" onclick ="saveUploadImage('server')"/> -->
                    </li>
                </ul>
            </div>
        </div>
       <!--  <div id="DWTcontainerBtm" class="clearfix">
            <div id="DWTemessageContainer"></div>
            <div id="divNoteMessage"> </div>
        </div>  -->
    </div>
    <div class="DWTTail"> 
        <!-- #include file=includes/PageTail.aspx --> 
    </div>
</div>
<div id="ImgSizeEditor" style="visibility:hidden; text-align:left;">
    <ul>
        <li>
            <label for="img_height">图片高度 :&nbsp;
                <input type="text" id="img_height" style="width:50%;" size="10"/>
                pixel</label>
        </li>
        <li>
            <label for="img_width">图片宽度 :&nbsp;
                <input type="text" id="img_width" style="width:50%;" size="10"/>
                pixel</label>
        </li>
        <li>图像插值法:&nbsp;
            <select size="1" id="InterpolationMethod">
                <option value = ""></option>
            </select>
        </li>
        <li>
            <input type="button" value=" 确定 " id="btnChangeImageSizeOK" onclick ="btnChangeImageSizeOK_onclick();"/>
            <input type="button" value=" 取消 " id="btnCancelChange" onclick ="btnCancelChange_onclick();"/>
        </li>
    </ul>
</div>
<%-- <div class="narrow-screen">
    <div class="tips-header clearfix"> <a class="logo-dwt" href="http://www.dynamsoft.com/Products/WebTWAIN_Overview.aspx" target="_blank"> <img alt="Dynamic Web TWAIN logo" src="<%=request.getContextPath() %>/Resources/Images/logo-dwt-68x68.png"></a> <img class="img-onlineDemo" src="<%=request.getContextPath() %>/Resources/Images/img-onlineDemo-126x21.png" alt="Dynamic Web TWAIN onlineDemo"/> </div>
    <div class="tips-desktop"><img src="<%=request.getContextPath() %>/Resources/Images/sc-desktop-only.png" border="0" alt="" width="280"/></div>
    <p class="tips">Sorry! <br />
        This page is an online demo of Dynamic Web TWAIN which runs in browsers on Windows and Mac OS X only, for now. Thanks! </p>
</div> --%>

<script>
    window['bDWTOnlineDemo'] = true;
</script>
<script src="<%=request.getContextPath() %>/Resources/Scripts/jquery.js?t=170607"></script>
    
<script src="<%=request.getContextPath() %>/Resources/dynamsoft.webtwain.config.js?t=170607"></script>
<script src="<%=request.getContextPath() %>/Resources/dynamsoft.webtwain.initiate.js?t=170607"></script>
<script src="<%=request.getContextPath() %>/Resources/addon/dynamsoft.webtwain.addon.pdf.js?t=170607"></script>
    
<script src="<%=request.getContextPath() %>/Resources/Scripts/online_demo_operation.js?t=170607"></script>
<script src="<%=request.getContextPath() %>/Resources/Scripts/online_demo_initpage.js?t=170607"></script>

<script>
    $("ul.PCollapse li>div").click(function() {
        if ($(this).next().css("display") == "none") {
            $(".divType").next().hide("normal");
            $(".divType").children(".mark_arrow").removeClass("expanded");
            $(".divType").children(".mark_arrow").addClass("collapsed");
            $(this).next().show("normal");
            $(this).children(".mark_arrow").removeClass("collapsed");
            $(this).children(".mark_arrow").addClass("expanded");
        }
    });
</script> 
<script>
    // Assign the page onload fucntion.
    $(function() {
        pageonload();
    });
</script>
</body>
</html>