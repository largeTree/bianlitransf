function dataLoader(param, success, error) {
    HttpService.post($(this).datagrid('options').url, param, function(data, status) {
        success(data);
    }, function() {
        error();
    });
}

function dataLoadFilter(data, parentId) {
    if (data.code != 0) {
        alert(data.msg);
        return [];
    }
    return data.data.rows;
}

window.CommonUtil = {
    loading: function() {
        $.messager.progress();
    },
    finishLoading: function() {
        $.messager.progress('close');
    }
}

window.HttpService = {
    post: function(url, params, success, error) {
        CommonUtil.loading();
        params = params || {};
        if (!params.ns) {
            params.sessionId = params.sessionId || SessionManager.getSessionId();
        }
        $.ajax({
            url: url,
            async: true,
            data: params,
            method: 'post',
            success: function(data, textStatus) {
                CommonUtil.finishLoading();
                if (success) {
                    success.call(this, data, textStatus);
                }
            },
            error: function(xhr, textStatus, e) {
                CommonUtil.finishLoading();
                if (error) {
                    error.call(this, xhr, textStatus, e);
                }
            }
        });
    }
}

window.SessionManager = {
    userLite: null,
    getSessionId: function() {
        if (SessionManager.userLite && SessionManager.userLite != null) {
            return SessionManager.userLite.sessionId;
        } else {
            window.location.href = './_login.html';
        }
    }
}