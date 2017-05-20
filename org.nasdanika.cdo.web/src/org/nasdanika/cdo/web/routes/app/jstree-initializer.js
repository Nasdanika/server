$(function () {
	$('#{{container-id}}').jstree({ 
		'core' : { 
			'data' : {{data}}, 
			"multiple" : false 
		}, 
		'plugins' : ['state', 'sort', 'search'],
		'state' : { 
			"filter" : function (k) { 
				delete k.core.selected; return k; 
			} 
		},
		'search' : {
			show_only_matches : true,
			show_only_matches_children : true
		}
	});
	
	var to = false;

	$('#{{container-id}}-search').keyup(function () {
		if (to) { 
			clearTimeout(to); 
		}
		to = setTimeout(function () {
			var v = $('#{{container-id}}-search').val();
			$('#{{container-id}}').jstree(true).search(v);
		}, 250);
  });	
	
});
