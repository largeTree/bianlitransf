function dataLoader(param, success, error) {
    HttpService.post($(this).datagrid('options').url, param, function(data, status) {
        success(data);
    }, function() {
        error();
    });
}

function captionFormatter(value, row, index) {
    var caption = row._caption;
    return caption ? caption[this.field] : value;
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

// Promise.prototype.then = function(resolve, reject) {
//     var next = this._next || (this._next = new Promise(function(resolve, reject){
        
//     }));
//     var status = this.status;
//     var x;

//     if ('pending' === status) {
//         isFn(resolve) && this._resolves.push(resolve);
//         isFn(reject) && this._rejects.push(reject);
//         return next;
//     }

//     if ('resolved' === status) {
//         if (!isFn(resolve)) {
//             next.resolve(resolve);
//         } else {
//             try {
//                 x = resolve(this.value);
//                 resolveX(next, x);
//             } catch (e) {
//                 this.reject(e);
//             }
//         }
//         return next;
//     }

//     if ('rejected' === status) {
//         if (!isFn(reject)) {
//             next.reject(reject);
//         } else {
//             try {
//                 x = reject(this.reason);
//                 resolveX(next, x);
//             } catch (e) {
//                 this.reject(e);
//             }
//         }
//         return next;
//     }
// };