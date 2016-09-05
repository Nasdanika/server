define(['jquery', 'knockout', 'domReady!'], function(jQuery, ko, doc) {
	return function(idBase, diagramURL, depth) {
		
		this.direction = ko.observable("both");
		this.depth = ko.observable(depth);
		this.members = ko.observable(true);
		//this.packages = ko.observable(false);
		this.leftToRightDirection = ko.observable(false);
		this.fitWidth = ko.observable(false);

		var overlay = jQuery("#"+idBase+"-overlay");
		
		this.imageLoaded = function(model, event) {
			overlay.hide();
		}.bind(this);
		
	    this.diagramAttributes = ko.computed(function() {
	    	var queryString = "direction="+this.direction() +
	    		"&depth="+this.depth() +
	    		"&members="+this.members() +
	    		"&packages="+this.members() +
	    		"&leftToRightDirection="+this.leftToRightDirection();
	    	
	    	if (this.fitWidth()) {
	    		queryString+="&width="+(document.body.getBoundingClientRect().right - document.getElementById(idBase+"-app").getBoundingClientRect().left - 10);
	    	}
	    	
	    	var attrs = {
	    		src: diagramURL+"?"+queryString
	    	};
	    	    	
	    	overlay.height(overlay.parent().height());
	    	overlay.width(overlay.parent().width());
	    	overlay.show();
	    	
	    	return attrs;
	    }.bind(this));
	    
	    this.diagramAttributes.extend({ deferred: true });    
		
	};
});
