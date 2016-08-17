define(['jquery', 'knockout', 'domReady!'], function(jQuery, ko, doc) {
	return function(idBase, objectURL, view) {
		
		this.view = ko.observable(view);
		this.direction = ko.observable("both");
		this.depth = ko.observable(1);
		this.leftToRightDirection = ko.observable(false);
		this.fitWidth = ko.observable(false);

		var overlay = jQuery("#"+idBase+"-overlay");
		
		this.imageLoaded = function(model, event) {
			overlay.hide();
		}.bind(this);
		
	    this.diagramAttributes = ko.computed(function() {
	    	var queryString = "direction="+this.direction() +
	    		"&depth="+this.depth() +
	    		"&leftToRightDirection="+this.leftToRightDirection();
	    	
	    	if (this.fitWidth()) {
	    		queryString+="&width="+(document.body.getBoundingClientRect().right - document.getElementById(idBase+"-app").getBoundingClientRect().left - 10);
	    	}
	    	
	    	var attrs = {
	    		src: objectURL+"/"+this.view()+".png?"+queryString
	    	};
	    	    	
	    	overlay.height(overlay.parent().height());
	    	overlay.width(overlay.parent().width());
	    	overlay.show();
	    	
	    	return attrs;
	    }.bind(this));
	    
	    this.diagramAttributes.extend({ deferred: true });    
		
	};
});
