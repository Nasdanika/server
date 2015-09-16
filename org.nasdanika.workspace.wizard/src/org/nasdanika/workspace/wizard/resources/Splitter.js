require(['jquery', 'domReady!'], function(jQuery, doc) {
	var leftPanel = jQuery('#left-panel')
	leftPanel.width(jQuery(window).width()/5);
	var jDoc = jQuery(doc);
	
	jQuery('#splitter').mousedown(function (e) {
	    e.preventDefault();
	    jDoc.mousemove(function (e) {
	        e.preventDefault();
	        var x = e.pageX - leftPanel.offset().left;
			var windowWidth = jQuery(window).width();
	        var min = windowWidth/10;
	        if (x > min && x < windowWidth && e.pageX < (windowWidth - min)) {  
	        	leftPanel.width(x);
	    		jQuery("div#doc-content .markdown-body").each(function() {
	    			var delta = jQuery("#docAppPanel")[0].getBoundingClientRect().right - this.getBoundingClientRect().right - 30;
    				var jThis = jQuery(this);
    				jThis.css("max-width", jThis.width()+delta+"px");
	    		});
	        }
	    })
	});
	
	jDoc.mouseup(function (e) {
	    jDoc.unbind('mousemove');
	});
});