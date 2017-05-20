
// Generic view model interacting with the server side over AJAX
// Tokens 
// 		- app-id - application id, base for other ID's like modal, form, and overlay.
//		- url - server endpoint communication url.
//		- declarations - observables and other declarations
//		- success-handler - invoked on AJAX success
//		- error-handler - invoked on AJAX error
//		- ajax-config - additional configuration for jQuery.ajax, e.g. method. Shall end with a comma, may be blank
$(function() {	
	ko.applyBindings(function() {	
		// Observables with inital values for edits etc.
		// {{declarations}}
		
		// When set to true the overlay shall be shown and the form shall be disabled.
		this.isWorking = ko.observable();
		this.test = ko.observable("My value");
		
		var overlay = jQuery("#{{app-id}}-overlay");

		this.submit = function() {
			this.isWorking();
			overlay.height(overlay.parent().height());
			overlay.width(overlay.parent().width());
			
			jQuery.ajax("{{url}}", 
					{
						{{ajax-config}}
						
						success: function(data) {
							// {{success-handler}}
							this.isWorking(false);
						}.bind(this),
						
						error: function(jqXHR, textStatus, errorThrown) {
							// {{error-handler}}
							this.isWorking(false);
						}.bind(this)
					});
		};
		
	}, document.getElementById("{{app-id}}"));	
	
});
	
	