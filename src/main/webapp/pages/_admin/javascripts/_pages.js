window.ReportBill = {
    
}

window.UsersPage = {
    $curEditWindow: null,
    optFormat: function(value, row, index) {
        return '<a href="javascript:void(0)" onclick="UsersPage.edit(\'' + value + '\')" >修改</a>  <a href="javascript:void(0)" onclick="UsersPage.disable(\'' + value + '\')" >停用</a>';
    },
    addNew: function() {
        this.showEditWindow();
    },
    refershData: function() {
        $('#_user_dg').datagrid('load', { _: new Date().getTime(), orderBy: 'createdTime desc' });
    },
    edit: function(id) {
        this.showEditWindow(id);
    },
    disable: function(id) {
        HttpService.post('/blh/api/user/disable', { id: id }, function(data, staus) {
            if (data.code == 0) {
                alert('停用成功');
                $('#_user_dg').datagrid('load', { _: new Date().getTime(), orderBy: 'disorder' });
            } else {
                alert(data.msg);
            }
        });
    },
    showEditWindow: function(id) {
        $curEditWindow = PageUtils.openWin({
            title: id ? '修改' : '新增',
            iconCls: 'icon-save',
            href: './_pages/_edit_user.html',
            onLoad: function() {
                if (id) {
                    HttpService.post('/blh/api/user/get', { id: id }, function(data, staus) {
                        if (data && data.code == 0) {
                            data = data.data;
                            PageUtils.applyFormData('#user_edit_table', data);
                        }
                    }, function(xhr, status, e) {
                        console.error(e);
                    });
                }
            },
            onBeforeClose:function() {
                $('#user_edit_table .form-field').val('');
            }
        });
    },
    save: function() {
        PageUtils.saveForm('/blh/api/user/save', '#user_edit_table', '#_user_dg', $curEditWindow, { _: new Date().getTime(), orderBy: 'createdTime desc' });
    }
}

window.ScoreExchange = {
    $curEditWindow: null,
    addNew: function() {
        this.showEditWindow();
    },
    refershData: function() {
        $('#_score_exg_dg').datagrid('load', { _: new Date().getTime(), orderBy: 'disorder' });
    },
    iconFormat: function(value, row, index) {
        return '<img src="' + value + '" width="50px" height="50px" />';
    },
    optFormat: function(value, row, index) {
        return '<a href="javascript:void(0)" onclick="ScoreExchange.edit(\'' + value + '\')" >修改</a>  <a href="javascript:void(0)" onclick="ScoreExchange.delete(\'' + value + '\')" >删除</a>';
    },
    edit: function(id) {
        this.showEditWindow(id);
    },
    delete: function(id) {
        HttpService.post('/blh/api/scoreexchange/delete', { id: id }, function(data, staus) {
            if (data.code == 0) {
                alert('删除成功');
                $('#_score_exg_dg').datagrid('load', { _: new Date().getTime(), orderBy: 'disorder' });
            } else {
                alert(data.msg);
            }
        });
    },
    showEditWindow: function(id) {
        $curEditWindow = PageUtils.openWin({
            title: id ? '修改' : '新增',
            iconCls: 'icon-save',
            href: './_pages/_edit_score_exg.html',
            onLoad: function() {
                if (id) {
                    HttpService.post('/blh/api/scoreexchange/get', { id: id }, function(data, staus) {
                        if (data && data.code == 0) {
                            data = data.data;
                            PageUtils.applyFormData('#exg_edit_table', data);
                        }
                    }, function(xhr, status, e) {
                        console.error(e);
                    });
                }
            }
        });
    },
    save: function() {
        PageUtils.saveForm('/blh/api/scoreexchange/save', '#exg_edit_table', '#_score_exg_dg', $curEditWindow,{ _: new Date().getTime(), orderBy: 'disorder' });
    }
}

window.PageUtils = {
    saveForm: function(uri, formSelector, dgSelector, $window, dgLoadParam) {
        var jsonParam = PageUtils.getFormData(formSelector);
        HttpService.post(uri, {
            jsonParam: JSON.stringify(jsonParam)
        }, function(data, staus) {
            if (data.code == 0) {
                $window.window('close');
                $window.remove();
                $(dgSelector).datagrid('load', dgLoadParam);
            } else {
                alert(data.msg);
            }
        });
    },
    openWin: function(options) {
        var $editWindow = $(document.createElement('div'));
        $editWindow.window({
            width: window.innerWidth * 0.8,
            height: window.innerHeight * 0.8,
            modal: true,
            collapsible: false,
            minimizable: false,
            maximizable: false,
            draggable: false,
            title: options.title,
            iconCls: options.icon || 'icon-save',
            href: options.href,
            onLoad: options.onLoad,
            onBeforeClose:options.onBeforeClose
        });
        return $editWindow;
    },
    applyFormData: function(selector, data) {
        for (var key in data) {
            $(selector + ' *[name="' + key + '"]').val(data[key]);
        }
    },
    getFormData: function(selector) {
        var $fields = $(selector + ' .form-field');
        var jsonParam = {};
        for (var i = 0; i < $fields.length; i++) {
            var $field = $($fields[i]);
            var val = $field.val();
            var fieldName = $field.attr('name');
            if (fieldName === 'id' && (!val || val.length == 0)) {
                continue;
            }
            jsonParam[fieldName] = val;
        }
        return jsonParam;
    }
}