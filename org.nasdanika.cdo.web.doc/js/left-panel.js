define(['jquery', 'knockout', 'q', './../../toc.js', './../jstree/jstree.js', 'domReady!'], function(jQuery, ko, q, toc, jstree, doc) {
	var jToc = jQuery('#toc');
	
	var treeDeferred = q.defer();
	
	jToc.bind("ready.jstree", function(e, data) {
		treeDeferred.resolve(jToc);	
	});
	
	jToc.jstree({
		'core': { 
			'data': toc.tree 
			}
	}).bind("changed.jstree", function(e, data) {
		if (data.selected.length>0) {
			window.location = toc.idMap[data.selected[0]];
		}
	});

	var leftOverlay = jQuery("#left-overlay");
	
	var searchContainer = doc.getElementById('search-container');
	
	if (searchContainer) {
		ko.applyBindings({
			
			query: ko.observable(),
			error: ko.observable(),
			searchKeyPress: function(data, event) {
			    if (event.which == 13) {
			        this.search();
			    } else {
			    	return true;
			    }			
			},
			search: function() {
				leftOverlay.height(leftOverlay.parent().height());
				leftOverlay.width(leftOverlay.parent().width());
				leftOverlay.css("display", "block");
				this.error(undefined);
				this.results(undefined);
				jQuery.ajax("doc/search", {
					data: {
						query: this.query
					},
					dataType: "json",
					success: function(data, textStatus, jqXHR) {
						if (data.length>0) {
							this.results(data);
						} else {
							this.error("No results");
						}					
					}.bind(this),
					error: function(jqXHR, textStatus, errorThrown) {
						this.error("Search error: "+errorThrown);				
					}.bind(this),
					complete: function() {
						leftOverlay.css("display", "none");						
					}
				});
			},
			
			results: ko.observable()
			
		}, searchContainer);
	} else {
		console.error("Search container not found");
	}
		
	return treeDeferred.promise;	
});
