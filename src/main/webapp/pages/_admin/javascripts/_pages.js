window.ScoreExchangeDetails = {
    editor: null,
    $curEditWindow: null,
    refershData: function() {
        $('#_score_exg_details_dg').datagrid('load');
    },
    dataLoader: function(param, success, error) {
        if (!param.exgId && param.exgId == null) {
            success({
                code: 0,
                data: {
                    rows: []
                }
            });
            return;
        }
        HttpService.post($(this).datagrid('options').url, param, function(data, status) {
            success(data);
        }, function() {
            error();
        });
    },
    optFormat: function(value, row, index) {
        return '<a href="javascript:void(0)" onclick="ScoreExchangeDetails.edit(\'' + value + '\')" >修改</a>';
    },
    edit: function(id) {
        var div = document.createElement('div');
        var elementId = 'exg_edit_' + new Date().getTime();
        div.id = elementId;
        $('#formContainer').append(div);
        ScoreExchangeDetails.$curEditWindow = PageUtils.openWin({
            title: '修改',
            iconCls: 'icon-save',
            href: './_pages/_edit_exg_class.html',
            onLoad: function() {
                if (id) {
                    HttpService.post('/blh/api/scoreexchangeclass/get', { id: id }, function(data, staus) {
                        if (data && data.code == 0) {
                            data = data.data;
                            var $formTable = $('#score_exg_details_edit_table');
                            $formTable.find('input[name="id"]').val(id);
                            var $name = $formTable.find('input[name="name"]');
                            $name.val(data.name);

                            $('#score_exg_details_edit_table_editer').height(window.innerHeight * 0.5);
                            ScoreExchangeDetails.editor = new window.wangEditor('#score_exg_details_edit_table_editer_toolbar', '#score_exg_details_edit_table_editer');
                            ScoreExchangeDetails.editor.customConfig.uploadImgShowBase64 = true;
                            // ScoreExchangeDetails.editor.customConfig.debug = true;
                            ScoreExchangeDetails.editor.create();
                            ScoreExchangeDetails.editor.txt.html(data.target);
                        }
                    }, function(xhr, status, e) {
                        console.error(e);
                    });
                }
            },
            onBeforeClose: function() {
                var $parent = $('#' + elementId).parent();
                $parent.next().next().remove();
                $parent.next().remove();
                $parent.remove();
            }
        }, elementId);
    },
    save: function() {
        var $formTable = $('#score_exg_details_edit_table');
        var $id = $formTable.find('input[name="id"]');
        var $name = $formTable.find('input[name="name"]');
        var target = ScoreExchangeDetails.editor.txt.html();
        var jsonParam = {
            id:$id.val(),
            name:$name.val(),
            target:target
        }
        HttpService.post('/blh/api/scoreexchangeclass/save',{
            jsonParam: JSON.stringify(jsonParam)
        }, function(data,status) {
            if (data && data.code == 0) {
                alert('保存成功');
                ScoreExchangeDetails.$curEditWindow.window('close');
            } else if (data) {
                alert(data.msg);
            }
        });
    }
}

window.ReportBill = {
    $curEditWindow: null,
    refershData: function() {
        $('#_exg_bill_dg').datagrid('load', { _: new Date().getTime(), orderBy: 'createdTime desc' });
    },
    optFormat: function(value, row, index) {
        return '<a href="javascript:void(0)" onclick="ReportBill.detail(\'' + value + '\')" >详情</a>  <a href="javascript:void(0)" onclick="ReportBill.confirmBill(\'' + value + '\')" >通过</a>  <a href="javascript:void(0)" onclick="ReportBill.refuseBill(\'' + value + '\')" >拒绝</a>';;
    },
    detail: function(exgBillId) {
        this.showDetailWindow(exgBillId);
    },
    confirmBill: function(exgBillId) {
        HttpService.post('/blh/api/exchangebill/confirmExchangeBill', { exgBillId: exgBillId }, function(data, staus) {
            if (data && data.code == 0) {
                alert('操作成功');
                ReportBill.refershData();
            } else if (data) {
                alert(data.msg);
            }
        }, function(xhr, status, e) {
            console.error(e);
        });
    },
    refuseBill: function(exgBillId) {
        HttpService.post('/blh/api/exchangebill/refuseExgBill', { exgBillId: exgBillId }, function(data, staus) {
            if (data && data.code == 0) {
                alert('操作成功');
                ReportBill.refershData();
            } else if (data) {
                alert(data.msg);
            }
        }, function(xhr, status, e) {
            console.error(e);
        });
    },
    showDetailWindow: function(exgBillId) {
        $curEditWindow = PageUtils.openWin({
            title: '详情',
            iconCls: 'icon-search',
            href: './_pages/_report_bill_det.html',
            onLoad: function() {
                HttpService.post('/blh/api/exchangebill/get', { id: exgBillId }, function(data, staus) {
                    if (data && data.code == 0) {
                        data = data.data;
                    }
                }, function(xhr, status, e) {
                    console.error(e);
                });
            }
        });
    }
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
                UsersPage.refershData();
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
            onBeforeClose: function() {
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
        return '<a href="javascript:void(0)" onclick="ScoreExchange.detail(\'' + value + '\')" >明细</a>  <a href="javascript:void(0)" onclick="ScoreExchange.edit(\'' + value + '\')" >修改</a>  <a href="javascript:void(0)" onclick="ScoreExchange.delete(\'' + value + '\')" >删除</a>';
    },
    detail: function(id) {
        PageUtils.openWin({
            title: '明细',
            iconCls: 'icon-search',
            href: './_pages/_score_exg_details.html',
            onLoad: function() {
                $('#_score_exg_details_dg').datagrid('load', { _: new Date().getTime(), orderBy: 'scoreExid', exgId: id });
            }
        });
    },
    edit: function(id) {
        this.showEditWindow(id);
    },
    delete: function(id) {
        HttpService.post('/blh/api/scoreexchange/delete', { id: id }, function(data, staus) {
            if (data.code == 0) {
                alert('删除成功');
                ScoreExchange.refershData();
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
        PageUtils.saveForm('/blh/api/scoreexchange/save', '#exg_edit_table', '#_score_exg_dg', $curEditWindow, { _: new Date().getTime(), orderBy: 'disorder' });
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
    openWin: function(options, elementId) {
        elementId = elementId ? elementId : 'commonWin';
        var div = document.getElementById(elementId);
        var $editWindow = $(div);
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
            onBeforeClose: options.onBeforeClose
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