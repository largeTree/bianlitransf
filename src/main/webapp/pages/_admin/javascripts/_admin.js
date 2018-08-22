window.AdminPage = {
    init: function() {
        $('#leftMenu').tree({
            onClick: function(node) {
            	AdminPage.addTab(node);
            }
        });
    },
    addTab:function(node) {
    	var tabs = $('#mainTabs');
    	if (tabs.tabs('exists',node.text)) {
    		tabs.tabs('select',node.text);
    	} else if(node.children) {
    		$('#leftMenu').tree('toggle',node.target);
    	} else if (node.attributes) {
    		tabs.tabs('add',{
    			title:node.text,
    			href:node.attributes.url,
    			method:'get',
    			closable:true
    		});
    	} 
    }
}