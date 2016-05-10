define(['jquery', 'knockout', 'domReady!'], function(jQuery, ko, doc) {
	return function(idBase, diagramURL, showComponents) {
		
		this.direction = ko.observable("both");
		this.depth = ko.observable(1);
		this.types = ko.observable("name");
		this.leftToRightDirection = ko.observable(false);

		var overlay = jQuery("#"+idBase+"-overlay");
		
		this.imageLoaded = function(model, event) {
			overlay.hide();
		}.bind(this);
		
	    this.diagramAttributes = ko.computed(function() {
	    	var queryString = "direction="+this.direction() +
	    		"&depth="+this.depth() +
	    		"&types="+this.types() +
	    		"&leftToRightDirection="+this.leftToRightDirection();

	    	var attrs = {
	    		src: diagramURL+"?"+queryString
	    	};
	    	    	
	    	overlay.height(overlay.parent().height());
	    	overlay.width(overlay.parent().width());
	    	overlay.show();
	    	
	    	return attrs;
	    }.bind(this));    
		
	};
});
