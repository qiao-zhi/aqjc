
var dbrObject;

//show or hide loading layer
function showLoadingLayer(bShow){
	var loaderContent = document.getElementById('loaderContent'),
		elLoadingLayer = document.getElementById('loadingLayer');

	loaderContent.style.display = bShow ? 'block' : 'none';
	elLoadingLayer.style.display = bShow ? 'block' : 'none';
}

function onInitDBRSuccess() {
    dbrObject = new dynamsoft.dbrEnv.BarcodeReader();
    showLoadingLayer(false);
}

function onInitDBRError(errCode, errMsg) {
    alert(errMsg);
    showLoadingLayer(false);
}

function start_init_dcs() {
    dynamsoft.dbrEnv.init(onInitDBRSuccess, onInitDBRError);
    showLoadingLayer(true);
}

function btnScanReadBarcode_onclick() {
    if (!checkIfImagesInBuffer()) {
        return;
    }
    
    var index;
    index = document.getElementById("ddl_barcodeFormat").selectedIndex;
    dbrObject.barcodeFormats = BarcodeInfo[index].val;

	var result;
	if(Dynamsoft.Lib.product.bActiveXEdition || Dynamsoft.Lib.product.bPluginEdition)
	{
		DWObject.SelectedImagesCount = 1;
		DWObject.SetSelectedImageIndex(0, DWObject.CurrentImageIndexInBuffer);
		DWObject.GetSelectedImagesSize(EnumDWT_ImageType.IT_JPG);
		var imagedata = DWObject.SaveSelectedImagesToBase64Binary();
		result = dbrObject.readBase64(imagedata);
	}
	else
	{
		var _url = DWObject.GetImagePartURL(DWObject.CurrentImageIndexInBuffer);
		result = dbrObject.readURL(_url);
	}

    displayResult(result);
}

       
function displayResult(data) {

    var barcodeCount = 0;
    
    if (data)
        barcodeCount = data.getCount();

    var boundingRect = {};
    var result = ['Total barcode(s) found: ', barcodeCount, '. <br /><br />'];
    for (var i = 0; i < barcodeCount; i++) {
        var barcode = data.get(i);
        boundingRect["left"] = barcode.left;
        boundingRect["top"] = barcode.top;
        boundingRect["right"] = barcode.width + barcode.left;
        boundingRect["bottom"] = barcode.height + barcode.top;
        addResultRect(DWObject.CurrentImageIndexInBuffer, boundingRect);
        result.push('Barcode: ' + (i + 1) + '<br />');
        result.push('Type: ' + barcode.formatString + '<br />');
        result.push('Value: ' + barcode.text + '<br />');
        result.push('Region: {Left: ' + barcode.left + ', Top: ' + barcode.top
            + ', Width: ' + barcode.width
            + ', Height: ' + barcode.height + '}' + '<br />');
        result.push('Module Size: ' + barcode.moduleSize + '<br />');
        result.push('Angle: ' + barcode.angle + '<br /><br />');
    }
    appendMessage(result.join(''));
}


function addResultRect(index, rect) {

    var left = rect.left, top = rect.top, right = rect.right, bottom = rect.bottom;

    DWObject.OverlayRectangle(index, left, top, right, top+2, 0xFF, 1);
    DWObject.OverlayRectangle(index, left, top, left+2, bottom, 0xFF, 1);
    DWObject.OverlayRectangle(index, left, bottom-2, right, bottom, 0xFF, 1);
    DWObject.OverlayRectangle(index, right-2, top, right, bottom, 0xFF, 1);
}