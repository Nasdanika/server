$('#{{container-id}}').jstree({ 
	'core' : { 
		'data' : {{data}}, 
		"multiple" : false 
	}, 
	'plugins' : ['state', 'sort'],
	'state' : { 
		"filter" : function (k) { 
			delete k.core.selected; return k; 
		} 
	}
});
