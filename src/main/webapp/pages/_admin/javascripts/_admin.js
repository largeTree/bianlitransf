window.AdminPage = {
    init: function() {
        var storage = window.localStorage;
        var userLite = storage.userLite;
        if (!userLite) {
            window.location.href = './_login.html';
        }
        var userLite = JSON.parse(userLite);
        if (new Date().getTime() - userLite._timestamp > 7 * 24 * 60 * 60 * 1000) {
            window.location.href = './_login.html';
        }
        SessionManager.userLite = userLite;
        $('body').removeClass('hide');
        $('#leftMenu').tree({
            onClick: function(node) {
                AdminPage.addTab(node);
            }
        });
    },
    logout: function() {
        HttpService.post('/blh/auth/logout', {});
        delete window.localStorage.userLite;
        window.location.href = './_login.html';
    },
    addTab: function(node) {
        var tabs = $('#mainTabs');
        if (tabs.tabs('exists', node.text)) {
            tabs.tabs('select', node.text);
        } else if (node.children) {
            $('#leftMenu').tree('toggle', node.target);
        } else if (node.attributes) {
            var onLoad = node.attributes.ctrl ? window[node.attributes.ctrl]['init'] : function(){};
            tabs.tabs('add', {
                title: node.text,
                href: node.attributes.url,
                method: 'get',
                closable: true,
                onLoad: onLoad
            });
        }
    }
}