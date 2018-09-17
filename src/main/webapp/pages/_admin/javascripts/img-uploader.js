function FileUploader(selector, opt) {
    var $assembly = $(selector);
    if ($assembly.length == 0) {
        throw new Error('No Element with selector[' + selector + ']');
    }
    var otherParams = opt.otherParams || {};
    if ($assembly[0].localName != 'img') {
        throw new Error('only Support Element[div]');
    }
    if (!opt.url || opt.url == null || opt.url.length == 0) {
        throw new Error('Error Url[' + opt.url + ']');
    }

    var $fileInput = $(document.createElement('input'));
    $fileInput.attr('type', 'file');
    $fileInput.css('display', 'none');
    $assembly.after($fileInput);
    $assembly.on('click', function() {
        $fileInput.click();
    });
    $fileInput.on('change', function() {
        var xhr = new XMLHttpRequest();
        xhr.onload = function(evt) {
          	var res = JSON.parse(evt.target.responseText);
        	if (res.code == 0) {
        		$assembly.attr('src','/blh/api/attachment/getImg/' + res.data.val);
        	}
            if (opt.success) {
                opt.success(res);
            }
        }
        xhr.open('POST', opt.url, true);
        var formData = new FormData();
        for (var key in otherParams) {
            formData.append(key, otherParams[key]);
        }
        var file = $fileInput[0].files[0];
        formData.append('file-' + new Date().getTime(), file);
        xhr.send(formData);
    });
    
}