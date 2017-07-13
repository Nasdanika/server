$(function () {
	var container = $('#{{container-id}}');
	container.jstree({ 
		'core' : { 
			'data' : {{data}}, 
			"multiple" : false 
		}, 
		'plugins' : ['state', 'sort', 'search', 'contextmenu'],
		'state' : { 
			"filter" : function (k) { 
				delete k.core.selected; return k; 
			} 
		},
		'search' : {
			show_only_matches : true,
			show_only_matches_children : true
		},
		'contextmenu' : {
			'show_at_node' : false,
			'items' : function(node) {
				return { 
					{{context-menu-items}}
				}[node.id];
			}
		}
	});
	
    container.bind('ready.jstree', function(e, data) {
        for (var k in data.instance._model.data) {
        	if (k != "#") {
    			$(".nsd-jstree-context-menu-"+k).contextmenu(function(idx, e) {
    				var selected = data.instance.get_selected(true);
    				var obj = data.instance._model.data[idx];
    				data.instance.show_contextmenu(obj, e.clientX, e.clientY, e);
    				data.instance.deselect_all();
    				data.instance.select_node(selected);
    				return false;
    			}.bind(this, k));	
        	}
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
