define(['jquery', 'knockout', 'domReady!'], function(jQuery, ko, doc) {
	return function(idBase, diagramURL, defaultIncludes, defaultExcludes) {
		
		this.dependencies = ko.observable(true);
		this.services = ko.observable(true);
		this.components = ko.observable(false);
		this.types = ko.observable("name");
		this.leftToRightDirection = ko.observable(false);
		this.fitWidth = ko.observable(false);
		this.includes = ko.observable(defaultIncludes);
		this.excludes = ko.observable(defaultExcludes);
		this.formIncludes = ko.observable();
		this.formExcludes = ko.observable();

		var overlay = jQuery("#"+idBase+"-overlay");
		var modal = jQuery("#"+idBase+"-modal");
		
		this.showFilterModal = function() {
			this.formIncludes(this.includes());
			this.formExcludes(this.excludes());
			modal.modal('show');
		}.bind(this);
		
		this.filter = function() {
			this.includes(this.formIncludes());
			this.excludes(this.formExcludes());
			modal.modal('hide');
		}
		
		this.imageLoaded = function(model, event) {
			overlay.hide();
		}.bind(this);
		
	    this.diagramAttributes = ko.computed(function() {
	    	var queryString = "dependencies="+this.dependencies() +
	    		"&services="+this.services() +
	    		"&components="+this.components() +
	    		"&types="+this.types() +
	    		"&leftToRightDirection="+this.leftToRightDirection() +
	    		"&includes="+encodeURIComponent(this.includes()) +
	    		"&excludes="+encodeURIComponent(this.excludes());
	    	
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
