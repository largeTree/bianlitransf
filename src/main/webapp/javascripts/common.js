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