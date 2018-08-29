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
        params.sessionId = params.sessionId || SessionManager.sessionId;
        $.ajax({
            url: url,
            async: true,
            data: params,
            method: 'post',
            success: function(data, textStatus) {
                CommonUtil.finishLoading();
                success.call(this, data, textStatus);
            },
            error: function(xhr, textStatus, e) {
                CommonUtil.finishLoading();
                error.call(this, xhr, textStatus, e);
            }
        });
    }
}

window.SessionManager = {
    sessionId: 'xxxx'
}