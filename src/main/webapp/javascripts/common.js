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

// 页面初始化事件
$(function() {
    var $title = $('.title');
    var $footer = $('.footer');
    var titleHeight = $title.length > 0 ? $title.height() : 0;
    var footerHeight = $footer.length > 0 ? $footer.height() : 0;
    var containerHeigth = window.innerHeight - titleHeight - footerHeight;
    $('.content-container').height(containerHeigth);
    $('.title .tback-btn').on('click', function() {
        window.history.go(-1);
    });
    console.log('init success...');
});