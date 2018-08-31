window.HttpService = {
    post: function(url, params, success, error) {
        params = params || {};
        $.ajax({
            url: url,
            async: true,
            data: params,
            method: 'post',
            success: function(data, textStatus) {
                success.call(this, data, textStatus);
            },
            error: function(xhr, textStatus, e) {
                error.call(this, xhr, textStatus, e);
            }
        });
    }
}

function getQueryParmas() {
    var queryString = document.location.search.substring(1);
    var pairs = queryString.split('&');
    var params = {};
    for (var i = 0; i < pairs.length; i++) {
        var pair = pairs[i];
        var n_v = pair.split('=');
        params[n_v[0]] = n_v[1];
    }
    return params;
}

function jumpPage(page, params) {
    window.location.href = page + '?' + toQueryString(params);
}

function toQueryString(params) {
    var queryString = '_=' + new Date().getTime();
    for (var key in params) {
        queryString += '&' + key + '=' + params[key];
    }
    return queryString;
}

/**
  发出一个会话过期事件，通知app端提示会话过期并跳转到登陆页面
*/
function sendSessionInvalidEvent() {
    if (window.parent != window) {
        window.parent.postMessage({
            act: 'sessionInvalid'
        }, '*');
    }
}

// 页面初始化事件
$(function() {
    $('.tback-btn').on('click', function() {
        window.history.go(-1);
    });
    console.log('init success...');
});