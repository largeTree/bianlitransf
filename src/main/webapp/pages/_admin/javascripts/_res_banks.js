window.ResBanksPage = {
    optColFormatter: function(value, row, index) {
        return '<a href="javascript:void(0)" onclick="ResBanksPage.showDetails(\'' + row.id + '\')">明细</a>';
        /*
        + '<span class="split"> | </span>'
        + '<a href="javascript:void(0)" onclick="ResBanksPage.deleteById(\'' + row.id + '\')">删除</a>';*/
    },
    iconUrlFormatter: function(value, row, index) {
        return '<img widh="25px" height="25px" src="' + value + '"/>';
    },
    showDetails: function(resId) {
        var $win = $(document.createElement('div'));
		$win.attr('res-id', resId);
        $win.window({
            width: window.innerWidth * 0.8,
            height: window.innerHeight * 0.8,
            modal: true,
            title: '明细-' + resId,
            draggable:false,
            loadingMessage:'加载中...',
            method:'get',
            href:'/blh/pages/_admin/_pages/_res_det_banks.html',
            queryParams:{resId:resId},
            onLoad: ResDetPage.pageOnLoaded
        });
    },
    deleteById: function(resId) {
        alert('deleteId = ' + resId);
    }
}

window.ResDetPage = {
	resId:null,
	pageOnLoaded : function () {
		ResDetPage.resId = this.attributes['res-id'].value;
		var dataTbl = document.createElement('table');
		this.append(dataTbl);
		$(dataTbl).datagrid({
			url:'/blh/api/resourcesdetails/list?resId=' + ResDetPage.resId,
			idField:'id',
			loadFilter:dataLoadFilter,
			fitColumns:true,
			singleSelect:true,
			columns:[[{
				field:'id',
				title:'id'
			},{
				field:'relUrl',
				title:'地址',
				width:100
			},{
				field:'resType',
				title:'类型',
				width:20
			},{
				field:'target',
				title:'目标',
				width:200
			},{
				field:'createdBy',
				title:'创建人'
			},{
				field:'createdTime',
				title:'创建时间'
			},{
				field:'updatedBy',
				title:'修改人'
			},{
				field:'updatedTime',
				title:'修改时间'
			},{
				field:'opt',
				title:'操作',
				formatter:function(value, row, index) {
					return '<a href="javascript:void(0)" onclick="ResDetPage.edit(\'' + row.id + '\')">编辑</a>';
				}
			}]]
		});
	},
	edit:function(resDetId){
		alert(resDetId);
	}
}