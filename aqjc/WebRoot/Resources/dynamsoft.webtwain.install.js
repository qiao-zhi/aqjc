
function OnWebTwainNotFoundOnWindowsCallback(ProductName, InstallerUrl, bHTML5, bIE, bSafari, bSSL, strIEVersion) {
	var objUrl={'default':InstallerUrl};
	
	_show_install_dialog(ProductName, objUrl, bHTML5, EnumDWT_PlatformType.enumWindow, bIE, bSafari, bSSL, strIEVersion);
}

function OnWebTwainNotFoundOnLinuxCallback(ProductName, strDebUrl, strRpmUrl, bHTML5, bIE, bSafari, bSSL, strIEVersion) {
	var objUrl={'default':strDebUrl, 'deb':strDebUrl, 'rpm':strRpmUrl};
	
	_show_install_dialog(ProductName, objUrl, bHTML5, EnumDWT_PlatformType.enumLinux, bIE, bSafari, bSSL, strIEVersion);
}

function OnWebTwainNotFoundOnMacCallback(ProductName, InstallerUrl, bHTML5, bIE, bSafari, bSSL, strIEVersion) {

	var objUrl={'default':InstallerUrl};
		
	_show_install_dialog(ProductName, objUrl, bHTML5, EnumDWT_PlatformType.enumMac, bIE, bSafari, bSSL, strIEVersion);
}

function dwt_change_install_url(url)
{
	var install=document.getElementById('dwt-btn-install');
	if(install)
		install.href = url;
}

function DCP_DWT_onclickInstallButton(el)
{
	if(el)
		el.style.display = 'none';
	var install=document.getElementById('dwt-install-url-div');
	if(install)
		install.style.display = 'none';
}

function _show_install_dialog(ProductName, objInstallerUrl, bHTML5, iPlatform, bIE, bSafari, bSSL, strIEVersion){
	
	var ObjString, title;

	if(bHTML5) {
		title = 'Dynamsoft Service<br /> is not installed';
	} else {
		if(bIE)
			title = 'Dynamic Web TWAIN<br /> ActiveX is not installed';
		else
			title = 'Dynamic Web TWAIN<br /> Plugin is not installed';
	}
	
	
	ObjString = [
			'<div class="dynamsoft-dwt-dlg-title">',
			title,
			'</div>'];
	
	
	if (bHTML5 && iPlatform == EnumDWT_PlatformType.enumLinux)
	{
		ObjString.push('<div style="margin:10px 0 0 60px;"><div id="dwt-install-url-div"><div><input id="dwt-install-url-deb" name="dwt-install-url" type="radio" onclick="dwt_change_install_url(\'' + objInstallerUrl['deb'] + '\')" checked="checked" /><label for="dwt-install-url-deb">64 bit .deb (For Ubuntu/Debian)</label></div>');
		ObjString.push('<div><input id="dwt-install-url-rpm" name="dwt-install-url" type="radio" onclick="dwt_change_install_url(\'' + objInstallerUrl['rpm'] + '\')" /><label for="dwt-install-url-rpm">64 bit .rpm (For Fedora)</label></div></div></div>');
	}
	else
	{
		ObjString.push('<div style="margin-top:20px;"></div>');
	}
	
	ObjString.push('<div style="margin:0 20px 20px 20px;text-align:center">');
	ObjString.push('<a id="dwt-btn-install" target="_blank" href="');
	ObjString.push(objInstallerUrl['default']);
	ObjString.push('" onclick="DCP_DWT_onclickInstallButton(this)"><div class="dynamsoft-dwt-dlg-button">Start to Download</div></a>');
	ObjString.push('<div style="color:#AAAAAA">* Please manually install it</div></div>');
	
	if(bHTML5){

		if(bIE){
			
			ObjString.push('<div class="dynamsoft-dwt-dlg-tail">');
			ObjString.push('If you still see the dialog after installing the scan service, please<br />');
			ObjString.push('1. Add the website to the zone of trusted sites.<br />');
			ObjString.push('IE | Tools | Internet Options | Security | Trusted Sites.<br />');
			ObjString.push('2. Refresh your browser.');
			ObjString.push('</div>');
			
		} else {
			ObjString.push('<div class="dynamsoft-dwt-dlg-tail">');

			if(iPlatform == EnumDWT_PlatformType.enumMac && bSafari && bSSL) {
				//
			} else {
			    ObjString.push('<div>');
			    ObjString.push('If you still see the dialog after the installation,<br />');
			    ObjString.push('please check <a href="http://developer.dynamsoft.com/why-am-i-prompted-to-install-the-dynamsoft-service" target="_blank">this article</a> for troubleshooting.');
			    ObjString.push('</div>');
			}
			
			
			if (iPlatform == EnumDWT_PlatformType.enumLinux 
				|| navigator.userAgent.toLowerCase().indexOf("firefox") > -1) 
			{
			    ObjString.push('<div class="dynamsoft-dwt-dlg-red">After the installation, please RESTART your browser.</div>');
            } 
            else
			{
				ObjString.push('<div class="dynamsoft-dwt-dlg-red">After the installation, please REFRESH your browser.</div>');
			}
			ObjString.push('</div>');
		}

	} else {
		ObjString.push('<div class="dynamsoft-dwt-dlg-tail">');
		if(bIE){
			ObjString.push('After the installation, please<br />');
			ObjString.push('1. Refresh the browser<br />');
			ObjString.push('2. Allow "DynamicWebTWAIN" add-on to run by right clicking on the Information Bar in the browser.');
		} else {
			ObjString.push('<div class="dynamsoft-dwt-dlg-red">After installation, please REFRESH your browser.</div>');
		}
		ObjString.push('</div>');
	}
	
	Dynamsoft.WebTwainEnv.ShowDialog(365, 0, ObjString.join(''));
}

function OnWebTwainOldPluginNotAllowedCallback(ProductName) {
    var ObjString = [
		'<div class="dynamsoft-dwt-dlg-title">',
		ProductName,
		'<br/> plugin is not allowed<br/> to run on this site.',
		'</div>',
		'<div class="dynamsoft-dwt-dlg-tail" style="margin-top:30px">',
		'Please click "<b>Always run on this site</b>" for the prompt "',
		ProductName,
		' Plugin needs your permission to run", then <a href="javascript:void(0);" style="color:#50A8E1" class="dynamsoft-dialog-close">close</a> this dialog OR refresh/restart the browser and try again.',
		'</div>'];

	Dynamsoft.WebTwainEnv.ShowDialog(365, 0, ObjString.join(''));
}

function OnWebTwainNeedUpgradeCallback(ProductName, objInstallerUrl, bHTML5, iPlatform, 
		bIE, bSafari, bSSL, strIEVersion, bForceUpgrade, bError, strErrorString) {
			
	var ObjString, title, bActiveX=!bHTML5 && bIE, bPlugin=!bHTML5 && !bIE;

	if(bError) {
		
		var ObjString = [
			'<div class="dynamsoft-dwt-dlg-center">',
			'<div class="dynamsoft-dwt-dlg-errorIcon"></div>',
			'</div>',
			'<div class="dynamsoft-dwt-dlg-error">',
				strErrorString,
			'</div>'
			];
	} else {
		
		if(bActiveX)
			title = 'Dynamic Web TWAIN <br />ActiveX update';
		else if(bPlugin)
			title = 'Dynamic Web TWAIN <br />Plugin update';
		else
			title = 'Dynamsoft Service Update';
		
		ObjString = [
			'<div class="dynamsoft-dwt-dlg-title">',
			title,
			'</div>'];	
	}
	
	if (bHTML5 && iPlatform == EnumDWT_PlatformType.enumLinux)
	{
		ObjString.push('<div style="margin:10px 0 0 19px;"><div id="dwt-install-url-div"><div><input id="dwt-install-url-deb" name="dwt-install-url" type="radio" onclick="dwt_change_install_url(\'' + objInstallerUrl['deb'] + '\')" checked="checked" /><label for="dwt-install-url-deb">64 bit .deb (For Ubuntu/Debian)</label></div>');
		ObjString.push('<div><input id="dwt-install-url-rpm" name="dwt-install-url" type="radio" onclick="dwt_change_install_url(\'' + objInstallerUrl['rpm'] + '\')" /><label for="dwt-install-url-rpm">64 bit .rpm (For Fedora)</label></div></div></div>');
	}
	else
	{
		if(!bError)
			ObjString.push('<div style="margin-top:40px;"></div>');
	}	
		
	ObjString.push('<a id="dwt-btn-install" target="_blank" href="');
	ObjString.push(objInstallerUrl['default']);
	ObjString.push('" onclick="DCP_DWT_onclickInstallButton(this)"><div class="dynamsoft-dwt-dlg-button">Start to Download</div></a>');
	ObjString.push('<div style="text-align:center;color:#AAAAAA">* Please manually install it</div>');
	ObjString.push('<p></p>');
	
	ObjString.push('<div class="dynamsoft-dwt-dlg-tail">');
	
	if(bActiveX)
	{
		ObjString.push('A newer version of the ActiveX is available on this page. Please download and update now.');
		ObjString.push('<div class="dynamsoft-dwt-dlg-red">Please EXIT Internet Explorer before you install the new version.</div>');
	}
	else if(bPlugin)
	{
		ObjString.push('<div class="dynamsoft-dwt-dlg-red">After the installation, please RESTART your browser.</div>');
	}
	else
	{
		ObjString.push('A newer version of the Dynamsoft Service is available on this page. Please download and update now.');
		if (iPlatform == EnumDWT_PlatformType.enumLinux 
				|| navigator.userAgent.toLowerCase().indexOf("firefox") > -1) 
		{
			ObjString.push('<div class="dynamsoft-dwt-dlg-red">After the installation, please RESTART your browser.</div>');
		} else {
			ObjString.push('<div class="dynamsoft-dwt-dlg-red">After the update, please REFRESH the browser.</div>');
		}
	}
	
	ObjString.push('</div>');

	Dynamsoft.WebTwainEnv.ShowDialog(365, 0, ObjString.join(''), false, bForceUpgrade);
}

function OnWebTwainPreExecuteCallback(){
	Dynamsoft.WebTwainEnv.OnWebTwainPreExecute();
}

function OnWebTwainPostExecuteCallback(){
	Dynamsoft.WebTwainEnv.OnWebTwainPostExecute();
}

function OnRemoteWebTwainNotFoundCallback(ProductName, ip, port, bSSL)
{
	var ObjString = [
		'<div class="dynamsoft-dwt-dlg-tips">',
		'Dynamic Web TWAIN is not installed on the PC with IP/domain "', ip, '",',
		'please open the page on that PC to download and install it.',
		'</div>',
		
		'<div style="padding-top:35px"></div>'
		];

	Dynamsoft.WebTwainEnv.ShowDialog(365, 0, ObjString.join(''));
}

function OnRemoteWebTwainNeedUpgradeCallback(ProductName, ip, port, bSSL)
{
	var ObjString = [
		'<div class="dynamsoft-dwt-dlg-tips">',
		
		'Dynamic Web TWAIN is outdated on the PC with IP/domain "', ip, '",',
		'please open the page on that PC to download and install it.',

		'</div>',
		'<div style="padding-top:35px"></div>'
		
		];

	Dynamsoft.WebTwainEnv.ShowDialog(365, 0, ObjString.join(''));
}

function OnWebTWAINDllDownloadSuccessful()
{
}

function OnWebTWAINDllDownloadFailure(ProductName, errorCode, errorString)
{
	if(errorCode == EnumDWT_Error.ModuleNotExists)
	{
		var ObjString = [
			'<div class="dynamsoft-dwt-dlg-tips">',
			errorString,
			'</div>',
			'<div style="padding-top:35px"></div>'
			];

		Dynamsoft.WebTwainEnv.ShowDialog(365, 0, ObjString.join(''));
		
	}
	return true;
}

function OnGetServiceUpdateStatus (bError, statusCode, statusString)
{
	console.log(statusString);
}
