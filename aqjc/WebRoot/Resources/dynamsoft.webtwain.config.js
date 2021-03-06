//
// Dynamsoft JavaScript Library for Basic Initiation of Dynamic Web TWAIN
// More info on DWT: http://www.dynamsoft.com/Products/WebTWAIN_Overview.aspx
//
// Copyright 2018, Dynamsoft Corporation 
// Author: Dynamsoft Team
// Version: 13.3
//
/// <reference path="dynamsoft.webtwain.initiate.js" />
var Dynamsoft = Dynamsoft || { WebTwainEnv: {} };

Dynamsoft.WebTwainEnv.AutoLoad = true;

///
Dynamsoft.WebTwainEnv.Containers = [{ContainerId:'dwtcontrolContainer', Width:'638px', Height:'528px'}];

/// If you need to use multiple keys on the same server, you can combine keys and write like this 
/// Dynamsoft.WebTwainEnv.ProductKey = 'key1;key2;key3';
Dynamsoft.WebTwainEnv.ProductKey = 'C243EE418A530E0063EE88D92B0F127E0C45C86F2EBD22B7E0662D5857786FCBECDF22976A242C25A6582828687D6044CFC6D2C92AB946AA43D32DBA2097A2AF302E3B18F2EAF2550367A1860A3FC7D6039C24FBDBE429B70AE10DD5DC6A61E649F91C2A80F970009E28DEE040E9BD6EDD47600A0FFE4AA97E3BCFC91270B81846025206FA2413F7E45D19ABB3881E4F8A0EB1A018B3DFA2F1A0EDA8E27D865C402AD817682C300C5CA43FA2592535;t0068WQAAAAG0s1nhe4pAi9iz7ucSQ40XhQ1jNNg7nFDAhb9GfevHD8Aij0RENbouekU5QLfcDMjTB4woDAtY/3CrVnRWu4c=';

///
Dynamsoft.WebTwainEnv.Trial = true;

///
Dynamsoft.WebTwainEnv.ActiveXInstallWithCAB = false;

///
Dynamsoft.WebTwainEnv.IfUpdateService = false;

///
//Dynamsoft.WebTwainEnv.ResourcesPath = 'https://demo.dynamsoft.com/DWT/Resources';
Dynamsoft.WebTwainEnv.ResourcesPath = '../Resources';
/// All callbacks are defined in the dynamsoft.webtwain.install.js file, you can customize them.
// Dynamsoft.WebTwainEnv.RegisterEvent('OnWebTwainReady', function(){
// 		// webtwain has been inited
// });
Dynamsoft.WebTwainEnv.OnWebTwainInitMessage = function(errorString, errorCode){
	if(errorCode != 1)
	{
	    var msg = errorString;
	    if (errorCode == 5) {
	        msg = "Please RESTART your browser.";
	        alert(msg);
	    }
	    console && console.error(msg);
	}
};



