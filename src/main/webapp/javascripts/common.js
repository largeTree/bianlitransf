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

// 页面初始化事件
$(function() {
    var $title = $('.title');
    var titleHeight = $title.length > 0 ? $title.height() : 0;
    var containerHeigth = window.innerHeight - titleHeight;
    $('.content-container').height(containerHeigth);
    console.log('init success...');
});